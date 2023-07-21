package com.drdisagree.iconify.ui.activities;

import static com.drdisagree.iconify.common.Const.SWITCH_ANIMATION_DELAY;
import static com.drdisagree.iconify.common.Preferences.HEADER_CLOCK_SWITCH;
import static com.drdisagree.iconify.common.Preferences.HEADER_IMAGE_OVERLAP;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.CompoundButton;

import com.drdisagree.iconify.R;
import com.drdisagree.iconify.config.RPrefs;
import com.drdisagree.iconify.databinding.ActivityExperimentalBinding;
import com.drdisagree.iconify.ui.utils.ViewBindingHelpers;
import com.drdisagree.iconify.utils.SystemUtil;

public class Experimental extends BaseActivity {

    private ActivityExperimentalBinding binding;

    @SuppressLint({"SetTextI18n", "CommitPrefEdits"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExperimentalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Header
        ViewBindingHelpers.setHeader(this, binding.header.collapsingToolbar, binding.header.toolbar, R.string.activity_title_experimental);

        binding.headerImageOverlap.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            RPrefs.putBoolean(HEADER_IMAGE_OVERLAP, isChecked);
            new Handler(Looper.getMainLooper()).postDelayed(SystemUtil::restartSystemUI, SWITCH_ANIMATION_DELAY);
        });
    }
}