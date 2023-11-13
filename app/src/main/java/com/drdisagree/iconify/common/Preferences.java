package com.drdisagree.iconify.common;

import static com.drdisagree.iconify.SplashActivity.SKIP_TO_HOMEPAGE_FOR_TESTING;

import com.drdisagree.iconify.config.Prefs;

public class Preferences {

    // Xposed mods
    public static final String FORCE_RELOAD_OVERLAY_STATE = "xposed_force_reload_overlay_state";
    public static final String QS_TRANSPARENCY_SWITCH = "xposed_qstransparency";
    public static final String NOTIF_TRANSPARENCY_SWITCH = "xposed_notiftransparency";
    public static final String QSALPHA_LEVEL = "xposed_qsalpha";
    public static final String STATUSBAR_CLOCKBG_SWITCH = "xposed_sbclockbg";
    public static final String STATUSBAR_CLOCK_COLOR_OPTION = "xposed_sbclockcolor";
    public static final String STATUSBAR_CLOCK_COLOR_CODE = "xposed_sbclockcolorcode";
    public static final String CHIP_STATUSBAR_CLOCKBG_STYLE = "xposed_chipstatusbarclockbgstyle";
    public static final String QSPANEL_STATUSICONSBG_SWITCH = "xposed_qsstatusiconsbg";
    public static final String CHIP_QSSTATUSICONS_STYLE = "xposed_chipqsstatusiconsstyle";
    public static final String VERTICAL_QSTILE_SWITCH = "xposed_verticalqstile";
    public static final String HIDE_QSLABEL_SWITCH = "xposed_hideqslabel";
    public static final String HEADER_IMAGE_SWITCH = "xposed_headerimage";
    public static final String HEADER_IMAGE_LANDSCAPE_SWITCH = "xposed_headerimagelandscape";
    public static final String HEADER_IMAGE_HEIGHT = "xposed_headerimageheight";
    public static final String HEADER_IMAGE_ALPHA = "xposed_headerimagealpha";
    public static final String HEADER_IMAGE_ZOOMTOFIT = "xposed_headerimagezoomtofit";
    public static final String HEADER_IMAGE_OVERLAP = "xposed_headerimageoverlap";
    public static final String HIDE_STATUS_ICONS_SWITCH = "xposed_hidestatusicons";
    public static final String HEADER_CLOCK_SWITCH = "xposed_headerclock";
    public static final String HEADER_CLOCK_SIDEMARGIN = "xposed_headerclocksidemargin";
    public static final String HEADER_CLOCK_TOPMARGIN = "xposed_headerclocktopmargin";
    public static final String HEADER_CLOCK_CENTERED = "xposed_headerclockcentered";
    public static final String HEADER_CLOCK_LANDSCAPE_SWITCH = "xposed_headerclocklandscape";
    public static final String HEADER_CLOCK_TEXT_WHITE = "xposed_headerclocktextwhite";
    public static final String HEADER_CLOCK_STYLE = "xposed_headerclockstyle";
    public static final String HEADER_CLOCK_FONT_SWITCH = "xposed_headerclockfont";
    public static final String HEADER_CLOCK_COLOR_SWITCH = "xposed_headerclockcolor";
    public static final String HEADER_CLOCK_COLOR_CODE = "xposed_headerclockcolorcode";
    public static final String HEADER_CLOCK_FONT_TEXT_SCALING = "xposed_headerclocktextscaling";
    public static final String QSPANEL_HIDE_CARRIER = "xposed_qspanelhidecarrier";
    public static final String LSCLOCK_SWITCH = "xposed_lockscreenclock";
    public static final String LSCLOCK_STYLE = "xposed_lockscreenclockstyle";
    public static final String LSCLOCK_TOPMARGIN = "xposed_lockscreenclocktopmargin";
    public static final String LSCLOCK_BOTTOMMARGIN = "xposed_lockscreenclockbottommargin";
    public static final String LSCLOCK_COLOR_SWITCH = "xposed_lockscreenclockcolor";
    public static final String LSCLOCK_COLOR_CODE = "xposed_lockscreenclockcolorcode";
    public static final String LSCLOCK_FONT_SWITCH = "xposed_lockscreenclockfont";
    public static final String LSCLOCK_FONT_LINEHEIGHT = "xposed_lockscreenclockfontlineheight";
    public static final String LSCLOCK_FONT_TEXT_SCALING = "xposed_lockscreenclocktextscaling";
    public static final String LSCLOCK_TEXT_WHITE = "xposed_lockscreenclocktextwhite";
    public static final String FIXED_STATUS_ICONS_SWITCH = "xposed_fixedstatusicons";
    public static final String FIXED_STATUS_ICONS_SIDEMARGIN = "xposed_fixedstatusiconssidemargin";
    public static final String FIXED_STATUS_ICONS_TOPMARGIN = "xposed_fixedstatusiconstopmargin";
    public static final String HIDE_LOCKSCREEN_STATUSBAR = "xposed_hidelockscreenstatusbar";
    public static final String HIDE_LOCKSCREEN_CARRIER = "xposed_hidelockscreencarrier";
    public static final String LIGHT_QSPANEL = "xposed_lightqspanel";
    public static final String DUALTONE_QSPANEL = "xposed_dualtoneqspanel";
    public static final String BLACK_QSPANEL = "xposed_blackqspanel";
    public static final String FLUID_QSPANEL = "xposed_fluidqspanel";
    public static final String FLUID_NOTIF_TRANSPARENCY = "xposed_fluidnotiftransparency";
    public static final String FLUID_POWERMENU_TRANSPARENCY = "xposed_fluidpowermenutransparency";
    public static final String CUSTOM_BATTERY_STYLE = "xposed_custombatterystyle";
    public static final String CUSTOM_BATTERY_WIDTH = "xposed_custombatterywidth";
    public static final String CUSTOM_BATTERY_HEIGHT = "xposed_custombatteryheight";
    public static final String HIDE_DATA_DISABLED_ICON = "xposed_hideDataDisabledIcon";
    public static final String DEPTH_WALLPAPER_SWITCH = "xposed_depthwallpaper";
    public static final String DEPTH_WALLPAPER_FADE_ANIMATION = "xposed_depthwallpaperfadeanimation";
    public static final String DEPTH_WALLPAPER_CHANGED = "xposed_depthwallpaperchanged";
    public static final String UNZOOM_DEPTH_WALLPAPER = "xposed_unzoomdepthwallpaper";
    public static final String CUSTOM_BATTERY_LAYOUT_REVERSE = "xposed_custombatterylayoutreverse";
    public static final String CUSTOM_BATTERY_DIMENSION = "xposed_custombatterydimension";
    public static final String CUSTOM_BATTERY_MARGIN_LEFT = "xposed_custombatterymarginleft";
    public static final String CUSTOM_BATTERY_MARGIN_TOP = "xposed_custombatterymargintop";
    public static final String CUSTOM_BATTERY_MARGIN_RIGHT = "xposed_custombatterymarginright";
    public static final String CUSTOM_BATTERY_MARGIN_BOTTOM = "xposed_custombatterymarginbottom";
    public static final String CUSTOM_BATTERY_PERIMETER_ALPHA = "xposed_custombatteryperimeteralpha";
    public static final String CUSTOM_BATTERY_FILL_ALPHA = "xposed_custombatteryfilledalpha";
    public static final String CUSTOM_BATTERY_RAINBOW_FILL_COLOR = "xposed_custombatteryrainbowfillcolor";
    public static final String CUSTOM_BATTERY_BLEND_COLOR = "xposed_custombatteryblendcolor";
    public static final String CUSTOM_BATTERY_CHARGING_COLOR = "xposed_custombatterychargingcolor";
    public static final String CUSTOM_BATTERY_FILL_COLOR = "xposed_custombatteryfillcolor";
    public static final String CUSTOM_BATTERY_FILL_GRAD_COLOR = "xposed_custombatteryfillgradcolor";
    public static final String CUSTOM_BATTERY_POWERSAVE_INDICATOR_COLOR = "xposed_custombatterypowersaveindicatorcolor";
    public static final String CUSTOM_BATTERY_POWERSAVE_FILL_COLOR = "xposed_custombatterypowersavefillcolor";
    public static final String CUSTOM_BATTERY_SWAP_PERCENTAGE = "xposed_custombatteryswappercentage";
    public static final String CUSTOM_BATTERY_CHARGING_ICON_SWITCH = "xposed_custombatterychargingiconswitch";
    public static final String CUSTOM_BATTERY_CHARGING_ICON_STYLE = "xposed_custombatterychargingiconstyle";
    public static final String CUSTOM_BATTERY_CHARGING_ICON_MARGIN_LEFT = "xposed_custombatterychargingiconmarginleft";
    public static final String CUSTOM_BATTERY_CHARGING_ICON_MARGIN_RIGHT = "xposed_custombatterychargingiconmarginright";
    public static final String CUSTOM_BATTERY_CHARGING_ICON_WIDTH_HEIGHT = "xposed_custombatterychargingiconwidthheight";
    public static final String CUSTOM_BATTERY_HIDE_PERCENTAGE = "xposed_custombatteryhidepercentage";
    public static final String CUSTOM_BATTERY_INSIDE_PERCENTAGE = "xposed_custombatteryinsidepercentage";
    public static final String CUSTOM_BATTERY_HIDE_BATTERY = "xposed_custombatteryhidebattery";
    public static final String BLUR_RADIUS_VALUE = "xposed_blurradiusvalue";
    public static final String QQS_TOPMARGIN = "xposed_qqspanelTopMargin";
    public static final String QS_TOPMARGIN = "xposed_qspanelTopMargin";
    public static final String FIX_NOTIFICATION_COLOR = "xposed_fixnotificationcolor";

    // Xposed view tags
    public static final String ICONIFY_HEADER_CLOCK_TAG = "iconify_header_clock";
    public static final String ICONIFY_LOCKSCREEN_CLOCK_TAG = "iconify_lockscreen_clock";
    public static final String ICONIFY_DEPTH_WALLPAPER_TAG = "iconify_depth_wallpaper";
    public static final String ICONIFY_CHARGING_ICON_TAG = "iconify_charging_icon";

    // Battery styles
    public static final int BATTERY_STYLE_DEFAULT = 0;
    public static final int BATTERY_STYLE_DEFAULT_RLANDSCAPE = 1;
    public static final int BATTERY_STYLE_DEFAULT_LANDSCAPE = 2;
    public static final int BATTERY_STYLE_CUSTOM_RLANDSCAPE = 3;
    public static final int BATTERY_STYLE_CUSTOM_LANDSCAPE = 4;
    public static final int BATTERY_STYLE_PORTRAIT_CAPSULE = 5;
    public static final int BATTERY_STYLE_PORTRAIT_LORN = 6;
    public static final int BATTERY_STYLE_PORTRAIT_MX = 7;
    public static final int BATTERY_STYLE_PORTRAIT_AIROO = 8;
    public static final int BATTERY_STYLE_RLANDSCAPE_STYLE_A = 9;
    public static final int BATTERY_STYLE_LANDSCAPE_STYLE_A = 10;
    public static final int BATTERY_STYLE_RLANDSCAPE_STYLE_B = 11;
    public static final int BATTERY_STYLE_LANDSCAPE_STYLE_B = 12;
    public static final int BATTERY_STYLE_LANDSCAPE_IOS_15 = 13;
    public static final int BATTERY_STYLE_LANDSCAPE_IOS_16 = 14;
    public static final int BATTERY_STYLE_PORTRAIT_ORIGAMI = 15;
    public static final int BATTERY_STYLE_LANDSCAPE_SMILEY = 16;
    public static final int BATTERY_STYLE_LANDSCAPE_MIUI_PILL = 17;
    public static final int BATTERY_STYLE_LANDSCAPE_COLOROS = 18;
    public static final int BATTERY_STYLE_RLANDSCAPE_COLOROS = 19;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYA = 20;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYB = 21;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYC = 22;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYD = 23;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYE = 24;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYF = 25;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYG = 26;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYH = 27;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYI = 28;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYJ = 29;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYK = 30;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYL = 31;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYM = 32;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYN = 33;
    public static final int BATTERY_STYLE_LANDSCAPE_BATTERYO = 34;

    // Xposed force reload overlay
    public static final String FORCE_RELOAD_PACKAGE_NAME = "com.android.internal.display.cutout.emulation.corner";

    // Xposed settings
    public static final String RESTART_SYSUI_BEHAVIOR_EXT = "IconifyRestartSysuiBehaviorExtended";
    public static final String LAST_RESTART_SYSTEMUI_TIME = "IconifyLastRestartSystemuiTime";
    public static final int RESTART_CLICK_DELAY_TIME = 6000;

    // Preference keys
    public static final String STR_NULL = "null";
    public static final String UPDATE_SCHEDULE = "iconify_update_schedule";
    public static final String UPDATE_CHECK_TIME = "iconify_update_check_time";
    public static final String LAST_UPDATE_CHECK_TIME = "iconify_last_update_check_time";
    public static final String FIRST_INSTALL = "firstInstall";
    public static final String UPDATE_DETECTED = "updateDetected";
    public static final String ON_HOME_PAGE = "onHomePage";
    public static final String COLORED_BATTERY_SWITCH = "isColoredBatteryEnabled";
    public static final String COLOR_ACCENT_PRIMARY = "colorAccentPrimary";
    public static final String COLOR_ACCENT_PRIMARY_LIGHT = "colorAccentPrimaryLight";
    public static final String COLOR_ACCENT_SECONDARY = "colorAccentSecondary";
    public static final String COLOR_ACCENT_SECONDARY_LIGHT = "colorAccentSecondaryLight";
    public static final String CUSTOM_PRIMARY_COLOR_SWITCH = "customPrimaryColor";
    public static final String CUSTOM_SECONDARY_COLOR_SWITCH = "customSecondaryColor";
    public static final String QS_ROW_COLUMN_SWITCH = "fabricatedqsRowColumn";
    public static final String MONET_ENGINE_SWITCH = "customMonet";
    public static final String QSPANEL_BLUR_SWITCH = "qsBlurSwitch";
    public static final String AGGRESSIVE_QSPANEL_BLUR_SWITCH = "aggressiveQsBlurSwitch";
    public static final String UI_CORNER_RADIUS = "uiCornerRadius";
    public static final String MONET_STYLE = "customMonetStyle";
    public static final String MONET_PRIMARY_COLOR = "monetPrimaryColor";
    public static final String MONET_SECONDARY_COLOR = "monetSecondaryColor";
    public static final String MONET_PRIMARY_ACCENT_SATURATION = "monetPrimaryAccentSaturationValue";
    public static final String MONET_SECONDARY_ACCENT_SATURATION = "monetSecondaryAccentSaturationValue";
    public static final String MONET_BACKGROUND_SATURATION = "monetBackgroundSaturationValue";
    public static final String MONET_BACKGROUND_LIGHTNESS = "monetBackgroundLightnessValue";
    public static final String MONET_ACCURATE_SHADES = "monetAccurateShades";
    public static final String PORT_QSTILE_EXPANDED_HEIGHT = "portraitQsTileExpandedHeight";
    public static final String PORT_QSTILE_NONEXPANDED_HEIGHT = "portraitQsTileNonExpandedHeight";
    public static final String LAND_QSTILE_EXPANDED_HEIGHT = "landscapeQsTileExpandedHeight";
    public static final String LAND_QSTILE_NONEXPANDED_HEIGHT = "landscapeQsTileNonExpandedHeight";
    public static final String SELECTED_SETTINGS_ICONS_COLOR = "selectedSettignsIconsColor";
    public static final String SELECTED_SETTINGS_ICONS_BG = "selectedSettignsIconsBg";
    public static final String SELECTED_SETTINGS_ICONS_SHAPE = "selectedSettignsIconsShape";
    public static final String SELECTED_SETTINGS_ICONS_SIZE = "selectedSettignsIconsSize";
    public static final String SELECTED_SETTINGS_ICONS_SET = "selectedSettignsIconsSet";
    public static final String SELECTED_TOAST_FRAME = "selectedToastFrame";
    public static final String SELECTED_ICON_SHAPE = "selectedIconShape";
    public static final String RESTART_SYSUI_AFTER_BOOT = "restartSysuiAfterBoot";
    public static final String VOLUME_PANEL_BACKGROUND_WIDTH = "volumePanelBackgroundWidth";
    public static final String SELECTED_PROGRESSBAR = "selectedProgressbar";
    public static final String SELECTED_SWITCH = "selectedSwitch";
    public static final String COLORED_BATTERY_CHECK = "isColoredBatteryEnabledByUser";
    public static final String CUSTOM_ACCENT = "customAccentColor";
    public static final String QS_TEXT_COLOR_VARIANT = "qsTextColorVariant";
    public static final String QS_TEXT_COLOR_VARIANT_NORMAL = "qsTextColorVariantNormal";
    public static final String QS_TEXT_COLOR_VARIANT_PIXEL = "qsTextColorVariantPixel";
    public static final String PORT_QQS_TOP_MARGIN = "portraitQqsTopMargin";
    public static final String PORT_QS_TOP_MARGIN = "portraitQsTopMargin";
    public static final String LAND_QQS_TOP_MARGIN = "landscapeQqsTopMargin";
    public static final String LAND_QS_TOP_MARGIN = "landscapeQsTopMargin";
    public static final String DYNAMIC_OVERLAY_RESOURCES = "dynamicOverlayResources";
    public static final String DYNAMIC_OVERLAY_RESOURCES_NIGHT = "dynamicOverlayResourcesNight";
    public static final String DYNAMIC_OVERLAY_RESOURCES_LAND = "dynamicOverlayResourcesLand";
    public static final String QS_HIDE_LABEL_SWITCH = "qsHideLabelSwitch";
    public static final String PROGRESS_WAVE_ANIMATION_SWITCH = "progressWaveAnimationSwitch";
    public static final String NOTCH_BAR_KILLER_SWITCH = "notchBarKillerSwitch";
    public static final String TABLET_LANDSCAPE_SWITCH = "tabletLandscapeSwitch";
    public static final String PILL_SHAPE_SWITCH = "navigationPillShapeSwitch";
    public static final String NAVBAR_FULL_SCREEN = "navbarfullscreen";
    public static final String NAVBAR_IMMERSIVE_V1 = "navbarimmersivev1";
    public static final String NAVBAR_IMMERSIVE_V2 = "navbarimmersivev2";
    public static final String NAVBAR_IMMERSIVE_V3 = "navbarimmersivev3";
    public static final String NAVBAR_GCAM_LAG_FIX = "navbargcamlagfix";
    public static final String NAVBAR_LOW_SENS = "navbarlowsens";
    public static final String NAVBAR_HIDE_PILL = "navbarhidepill";

    // Settings
    public static final String APP_LANGUAGE = "IconifyAppLanguage";
    public static final String APP_ICON = "IconifyAppIcon";
    public static final String APP_THEME = "IconifyAppTheme";
    public static final String AUTO_UPDATE = "IconifyAutoUpdate";
    public static final String UPDATE_OVER_WIFI = "IconifyUpdateOverWifi";
    public static final String SHOW_XPOSED_WARN = "IconifyShowXposedWarn";
    public static final String SHOW_HOME_CARD = "IconifyShowHomeCard";
    public static final String XPOSED_ONLY_MODE = "IconifyXposedOnlyMode";
    public static boolean isXposedOnlyMode = Prefs.getBoolean(XPOSED_ONLY_MODE, true) &&
            !SKIP_TO_HOMEPAGE_FOR_TESTING;

    // Others
    public static final String BOOT_ID = "boot_id";
    public static final String VER_CODE = "versionCode";
    public static final String EASTER_EGG = "iconify_easter_egg";
    public static final String ALERT_DIALOG_QSROWCOL = "alertDialogQsRowCol";
}
