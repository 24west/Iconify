package com.drdisagree.iconify.xposed.mods;

/* Modified from AOSPMods
 * https://github.com/siavash79/AOSPMods/blob/canary/app/src/main/java/sh/siava/AOSPMods/systemui/BatteryStyleManager.java
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 */

import static com.drdisagree.iconify.common.Const.SYSTEMUI_PACKAGE;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_CUSTOM_LANDSCAPE;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_CUSTOM_RLANDSCAPE;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_DEFAULT;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_DEFAULT_LANDSCAPE;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_DEFAULT_RLANDSCAPE;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_LANDSCAPE_STYLE_A;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_LANDSCAPE_STYLE_B;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_PORTRAIT_BUDDY;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_PORTRAIT_LINE;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_PORTRAIT_MUSKU;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_PORTRAIT_PILL;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_PORTRAIT_SIGNAL;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_RLANDSCAPE_STYLE_A;
import static com.drdisagree.iconify.common.Preferences.BATTERY_STYLE_RLANDSCAPE_STYLE_B;
import static com.drdisagree.iconify.common.Preferences.CUSTOM_BATTERY_HEIGHT;
import static com.drdisagree.iconify.common.Preferences.CUSTOM_BATTERY_STYLE;
import static com.drdisagree.iconify.common.Preferences.CUSTOM_BATTERY_WIDTH;
import static com.drdisagree.iconify.config.XPrefs.Xprefs;
import static com.drdisagree.iconify.xposed.HookRes.resparams;
import static de.robv.android.xposed.XposedBridge.hookAllConstructors;
import static de.robv.android.xposed.XposedBridge.hookAllMethods;
import static de.robv.android.xposed.XposedBridge.log;
import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;
import static de.robv.android.xposed.XposedHelpers.findClassIfExists;
import static de.robv.android.xposed.XposedHelpers.getAdditionalInstanceField;
import static de.robv.android.xposed.XposedHelpers.getBooleanField;
import static de.robv.android.xposed.XposedHelpers.getIntField;
import static de.robv.android.xposed.XposedHelpers.getObjectField;
import static de.robv.android.xposed.XposedHelpers.setAdditionalInstanceField;
import static de.robv.android.xposed.XposedHelpers.setObjectField;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XResources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.drdisagree.iconify.xposed.HookEntry;
import com.drdisagree.iconify.xposed.ModPack;
import com.drdisagree.iconify.xposed.mods.batterystyles.BatteryDrawable;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawable;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawableBuddy;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawableLine;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawableMusku;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawablePill;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawableSignal;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawableStyleA;
import com.drdisagree.iconify.xposed.mods.batterystyles.LandscapeBatteryDrawableStyleB;
import com.drdisagree.iconify.xposed.mods.batterystyles.RLandscapeBatteryDrawable;
import com.drdisagree.iconify.xposed.mods.batterystyles.RLandscapeBatteryDrawableStyleA;
import com.drdisagree.iconify.xposed.mods.batterystyles.RLandscapeBatteryDrawableStyleB;
import com.drdisagree.iconify.xposed.utils.SettingsLibUtils;

import java.util.ArrayList;
import java.util.Objects;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class BatteryStyleManager extends ModPack {

    private static final String TAG = "Iconify - BatteryStyleManager: ";
    public static final String listenPackage = SYSTEMUI_PACKAGE;
    private static boolean customBatteryEnabled = false;
    private int frameColor;
    public static int BatteryStyle = 0;
    public static boolean ShowPercent = false;
    public static int scaleFactor = 100;
    public static int batteryRotation = 0;
    private static int BatteryIconOpacity = 100;
    private Object BatteryController;
    private int landscapeBatteryWidth = 20;
    private int landscapeBatteryHeight = 20;
    private static final ArrayList<Object> batteryViews = new ArrayList<>();

    public BatteryStyleManager(Context context) {
        super(context);
    }

    public void updatePrefs(String... Key) {
        if (Xprefs == null) return;

        int batteryStyle = Xprefs.getInt(CUSTOM_BATTERY_STYLE, 0);
        customBatteryEnabled = batteryStyle != BATTERY_STYLE_DEFAULT;
        landscapeBatteryWidth = Xprefs.getInt(CUSTOM_BATTERY_WIDTH, 20);
        landscapeBatteryHeight = Xprefs.getInt(CUSTOM_BATTERY_HEIGHT, 20);

        if (batteryStyle == 1) {
            batteryRotation = 90;
        } else if (batteryStyle == 2) {
            batteryRotation = 270;
        } else {
            batteryRotation = 0;
        }

        if (BatteryStyle != batteryStyle) {
            BatteryStyle = batteryStyle;
            try {
                for (Object view : batteryViews) {
                    ImageView mBatteryIconView = (ImageView) getObjectField(view, "mBatteryIconView");
                    boolean mCharging = (boolean) getObjectField(view, "mCharging");
                    int mLevel = (int) getObjectField(view, "mLevel");

                    if (customBatteryEnabled) {
                        BatteryDrawable newDrawable = getNewDrawable(mContext);
                        if (newDrawable != null) {
                            mBatteryIconView.setImageDrawable(newDrawable);
                            setAdditionalInstanceField(view, "mBatteryDrawable", newDrawable);
                            newDrawable.setBatteryLevel(mLevel);
                            newDrawable.setChargingEnabled(mCharging);
                        }
                    } else {
                        try {
                            mBatteryIconView.setImageDrawable((Drawable) getObjectField(view, "mDrawable"));
                        } catch (Throwable ignored) { //PE+ !
                            mBatteryIconView.setImageDrawable((Drawable) getObjectField(view, "mThemedDrawable"));
                        }
                    }
                }
            } catch (Throwable throwable) {
                log(TAG + throwable);
            }
        }

        refreshBatteryIcons();

        if (Key.length > 0) {
            if (Objects.equals(Key[0], CUSTOM_BATTERY_WIDTH) || Objects.equals(Key[0], CUSTOM_BATTERY_HEIGHT))
                setCustomBatterySize();
        }
    }

    private static void refreshBatteryIcons() {
        try {
            for (Object view : batteryViews) {
                ImageView mBatteryIconView = (ImageView) getObjectField(view, "mBatteryIconView");
                mBatteryIconView.setRotation(batteryRotation);
                scale(mBatteryIconView);
                try {
                    BatteryDrawable drawable = (BatteryDrawable) getAdditionalInstanceField(view, "mBatteryDrawable");
                    drawable.setShowPercentEnabled(ShowPercent);
                    drawable.setAlpha(Math.round(BatteryIconOpacity * 2.55f));
                    drawable.invalidateSelf();
                } catch (Throwable ignored) {
                }
            }
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals(listenPackage)) return;

        Class<?> BatteryControllerImplClass = findClass("com.android.systemui.statusbar.policy.BatteryControllerImpl", lpparam.classLoader);
        Class<?> BatteryMeterViewClass = findClassIfExists("com.android.systemui.battery.BatteryMeterView", lpparam.classLoader);
        SettingsLibUtils.init(lpparam.classLoader);

        try {
            findAndHookConstructor("com.android.settingslib.graph.ThemedBatteryDrawable", lpparam.classLoader, Context.class, int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) {
                    frameColor = (int) param.args[1];
                }
            });
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }

        try {
            hookAllConstructors(BatteryControllerImplClass, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    BatteryController = param.thisObject;
                }
            });
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }

        try {
            hookAllMethods(BatteryControllerImplClass, "fireBatteryUnknownStateChanged", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    if (!customBatteryEnabled) return;

                    for (Object view : batteryViews) {
                        BatteryDrawable mBatteryDrawable = (BatteryDrawable) getAdditionalInstanceField(view, "mBatteryDrawable");
                        callMethod(view, "setImageDrawable", mBatteryDrawable);
                    }
                }
            });
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }

        try {
            XC_MethodHook batteryDataRefreshHook = new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    int level = getIntField(param.thisObject, "mLevel");
                    boolean charging = getBooleanField(param.thisObject, "mPluggedIn") || getBooleanField(param.thisObject, "mCharging") || getBooleanField(param.thisObject, "mWirelessCharging");
                    boolean powerSave = getBooleanField(param.thisObject, "mPowerSave");

                    if (!customBatteryEnabled) return;

                    for (Object view : batteryViews) {
                        ((View) view).post(() -> {
                            BatteryDrawable drawable = (BatteryDrawable) getAdditionalInstanceField(view, "mBatteryDrawable");
                            if (drawable != null) {
                                drawable.setBatteryLevel(level);
                                drawable.setChargingEnabled(charging);
                                drawable.setPowerSavingEnabled(powerSave);
                            }
                            scale(view);
                        });
                    }
                }
            };

            hookAllMethods(BatteryControllerImplClass, "fireBatteryLevelChanged", batteryDataRefreshHook);
            hookAllMethods(BatteryControllerImplClass, "firePowerSaveChanged", batteryDataRefreshHook);
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }

        try {
            View.OnAttachStateChangeListener listener = new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    batteryViews.add(v);
                    new Thread(() -> {
                        try {
                            Thread.sleep(500);
                            callMethod(BatteryController, "fireBatteryLevelChanged");
                        } catch (Throwable ignored) {
                        }
                    }).start();
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    batteryViews.remove(v);
                }
            };

            hookAllConstructors(BatteryMeterViewClass, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    ((View) param.thisObject).addOnAttachStateChangeListener(listener);

                    if (!customBatteryEnabled) return;

                    ImageView mBatteryIconView = (ImageView) getObjectField(param.thisObject, "mBatteryIconView");
                    mBatteryIconView.setRotation(batteryRotation);

                    BatteryDrawable mBatteryDrawable = getNewDrawable(mContext);
                    if (mBatteryDrawable != null) {
                        setAdditionalInstanceField(param.thisObject, "mBatteryDrawable", mBatteryDrawable);
                        mBatteryIconView.setImageDrawable(mBatteryDrawable);
                        setObjectField(param.thisObject, "mBatteryIconView", mBatteryIconView);
                    }

                    callMethod(BatteryController, "fireBatteryLevelChanged");
                }
            });
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }

        try {
            findAndHookMethod(BatteryMeterViewClass, "updateColors", int.class, int.class, int.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    if (!customBatteryEnabled) return;

                    BatteryDrawable mBatteryDrawable = (BatteryDrawable) getAdditionalInstanceField(param.thisObject, "mBatteryDrawable");
                    if (mBatteryDrawable != null) {
                        mBatteryDrawable.setColors((int) param.args[0], (int) param.args[1], (int) param.args[2]);
                    }
                }
            });
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }

        setCustomBatterySize();
    }

    public static void scale(Object thisObject) {
        ImageView mBatteryIconView = (ImageView) getObjectField(thisObject, "mBatteryIconView");
        scale(mBatteryIconView);
    }

    @SuppressLint("DiscouragedApi")
    public static void scale(ImageView mBatteryIconView) {
        if (mBatteryIconView == null) {
            return;
        }

        try {
            Context context = mBatteryIconView.getContext();
            Resources res = context.getResources();

            TypedValue typedValue = new TypedValue();

            res.getValue(res.getIdentifier("status_bar_icon_scale_factor", "dimen", context.getPackageName()), typedValue, true);
            float iconScaleFactor = typedValue.getFloat() * (scaleFactor / 100f);

            int batteryHeight = res.getDimensionPixelSize(res.getIdentifier("status_bar_battery_icon_height", "dimen", context.getPackageName()));
            int batteryWidth = res.getDimensionPixelSize(res.getIdentifier((customBatteryEnabled) ? "status_bar_battery_icon_height" : "status_bar_battery_icon_width", "dimen", context.getPackageName()));

            ViewGroup.LayoutParams scaledLayoutParams = mBatteryIconView.getLayoutParams();
            scaledLayoutParams.height = (int) (batteryHeight * iconScaleFactor);
            scaledLayoutParams.width = (int) (batteryWidth * iconScaleFactor);

            mBatteryIconView.setLayoutParams(scaledLayoutParams);
        } catch (Throwable throwable) {
            log(TAG + throwable);
        }
    }

    private BatteryDrawable getNewDrawable(Context context) {
        BatteryDrawable mBatteryDrawable = null;
        switch (BatteryStyle) {
            case BATTERY_STYLE_DEFAULT:
            case BATTERY_STYLE_DEFAULT_RLANDSCAPE:
            case BATTERY_STYLE_DEFAULT_LANDSCAPE:
                break;
            case BATTERY_STYLE_CUSTOM_RLANDSCAPE:
                mBatteryDrawable = new RLandscapeBatteryDrawable(context, frameColor);
                break;
            case BATTERY_STYLE_CUSTOM_LANDSCAPE:
                mBatteryDrawable = new LandscapeBatteryDrawable(context, frameColor);
                break;
            case BATTERY_STYLE_PORTRAIT_BUDDY:
                mBatteryDrawable = new LandscapeBatteryDrawableBuddy(context, frameColor);
                break;
            case BATTERY_STYLE_PORTRAIT_LINE:
                mBatteryDrawable = new LandscapeBatteryDrawableLine(context, frameColor);
                break;
            case BATTERY_STYLE_PORTRAIT_MUSKU:
                mBatteryDrawable = new LandscapeBatteryDrawableMusku(context, frameColor);
                break;
            case BATTERY_STYLE_PORTRAIT_PILL:
                mBatteryDrawable = new LandscapeBatteryDrawablePill(context, frameColor);
                break;
            case BATTERY_STYLE_PORTRAIT_SIGNAL:
                mBatteryDrawable = new LandscapeBatteryDrawableSignal(context, frameColor);
                break;
            case BATTERY_STYLE_RLANDSCAPE_STYLE_A:
                mBatteryDrawable = new RLandscapeBatteryDrawableStyleA(context, frameColor);
                break;
            case BATTERY_STYLE_LANDSCAPE_STYLE_A:
                mBatteryDrawable = new LandscapeBatteryDrawableStyleA(context, frameColor);
                break;
            case BATTERY_STYLE_RLANDSCAPE_STYLE_B:
                mBatteryDrawable = new RLandscapeBatteryDrawableStyleB(context, frameColor);
                break;
            case BATTERY_STYLE_LANDSCAPE_STYLE_B:
                mBatteryDrawable = new LandscapeBatteryDrawableStyleB(context, frameColor);
                break;
        }

        if (mBatteryDrawable != null) {
            mBatteryDrawable.setShowPercentEnabled(ShowPercent);
            mBatteryDrawable.setAlpha(Math.round(BatteryIconOpacity * 2.55f));
        }

        return mBatteryDrawable;
    }

    @Override
    public boolean listensTo(String packageName) {
        return listenPackage.equals(packageName) && !HookEntry.isChildProcess;
    }

    private void setCustomBatterySize() {
        XC_InitPackageResources.InitPackageResourcesParam ourResparam = resparams.get(SYSTEMUI_PACKAGE);
        if (ourResparam == null) return;

        if (customBatteryEnabled) {
            ourResparam.res.setReplacement(SYSTEMUI_PACKAGE, "dimen", "status_bar_battery_icon_width", new XResources.DimensionReplacement(landscapeBatteryWidth, TypedValue.COMPLEX_UNIT_DIP));
            ourResparam.res.setReplacement(SYSTEMUI_PACKAGE, "dimen", "status_bar_battery_icon_height", new XResources.DimensionReplacement(landscapeBatteryHeight, TypedValue.COMPLEX_UNIT_DIP));
        }
    }
}