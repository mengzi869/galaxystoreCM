package com.clean888.cleansuper.cleaner.ui.activity;

import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.AboutUsFragment;

public class AboutUsActivity extends BaseFMActivity {
    @Override
    public Fragment createFragment() {
        return AboutUsFragment.newInstance();
    }
}
