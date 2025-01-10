package com.clean888.cleansuper.cleaner.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.nr1;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;
import com.clean888.cleansuper.cleaner.ui.fragment.PhoneBoostFragment;
import com.clean888.cleansuper.cleaner.ui.fragment.BAEY;

public class PhoneBoostActivity extends BaseFMActivity {
    @Override
    public Fragment createFragment() {
        if (nr1.k().l()) {
            return PhoneBoostFragment.newInstance();
        }
//        i4.a().i("c_phoneboost_auto").putEbKey1(Integer.valueOf(getIntent().getIntExtra(MainActivity.FROM, 0))).commit();
        return BAEY.newInstance(FuncFinishTitleModel.PhoneBoost.setExtras(""));
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ((BAEX) new ViewModelProvider(this).get(BAEX.class)).enter(this, FuncFinishTitleModel.PhoneBoost);
        int intExtra = getIntent().getIntExtra(MainActivity.FROM, 0);
        if (intExtra == 5) {
//            i4.a().i("r_quickboost_desktop").commit();
        } else if (intExtra == 6) {
//            i4.a().i("r_shortcut_phoneboost").commit();
        }
//        qh.c();
    }
}
