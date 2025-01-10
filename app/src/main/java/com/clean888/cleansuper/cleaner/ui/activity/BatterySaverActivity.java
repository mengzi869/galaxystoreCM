package com.clean888.cleansuper.cleaner.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.BatterySaverFragment;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;

public class BatterySaverActivity extends BaseFMActivity {
    @Override
    public Fragment createFragment() {
        return BatterySaverFragment.newInstance();
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ((BAEX) new ViewModelProvider(this).get(BAEX.class)).enter(this, FuncFinishTitleModel.BatterySaver);
    }
}