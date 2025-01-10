package com.clean888.cleansuper.cleaner.ui.activity;

import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.SettingsFragment;

public class SettingsActivity extends BaseFMActivity {
    @Override
    public Fragment createFragment() {
        return SettingsFragment.newInstance();
    }

}
