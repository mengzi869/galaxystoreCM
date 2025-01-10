package com.clean888.cleansuper.cleaner.ui.base;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.fl;
import com.clean888.cleansuper.cleaner.ui.activity.ZZY;
import com.clean888.cleansuper.cleaner.ui.fragment.BaseFragment;

// ZZE
public abstract class BaseFMActivity extends BaseActivity {
    public /* synthetic */ void lambda$hideNavigationBar$0(int i) {
        fl.f(this, i == 0);
    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commitAllowingStateLoss();
    }

    public abstract Fragment createFragment();

    public Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.container);
    }

    public void hideNavigationBar() {
        fl.f(this, true);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: c43
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                BaseFMActivity.this.lambda$hideNavigationBar$0(i);
            }
        });
    }

    public void onAction(String str) {
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_base_fm);
        fl.o(this);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, createFragment()).commitNow();
        }
    }

    public void onFinishFragment(BaseFragment bafq) {
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment currentFragment = getCurrentFragment();
        if ((currentFragment instanceof BaseFragment) && ((BaseFragment) currentFragment).onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override
    public void onResume() {
        super.onResume();
        ZZY.h();
    }

    @Override
    public void onStart() {
        super.onStart();
        ZZY.h();
    }

    @Override
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).onWindowFocusChanged(z);
        }
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commitAllowingStateLoss();
    }

    public void statusBarTextDarkLight(boolean z) {
        fl.h(this, !z);
    }
}
