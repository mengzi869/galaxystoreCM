package com.clean888.cleansuper.cleaner.ui.fragment;

import android.view.KeyEvent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;

// BAFQ
public abstract class BaseFragment extends Fragment {

    public void addFragment(Fragment fragment) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseFMActivity) {
            ((BaseFMActivity) activity).addFragment(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkFragmentAlive() {
        return (getActivity() == null || getActivity().isFinishing() || getContext() == null || isDetached() || isRemoving()) ? false : true;
    }

    public void finish() {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseFMActivity) {
            ((BaseFMActivity) activity).onFinishFragment(this);
        }
    }

    public void finishActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    public void onAction(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseFMActivity) {
            ((BaseFMActivity) activity).onAction(str);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onWindowFocusChanged(boolean z) {
    }

    public void replaceFragment(Fragment fragment) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseFMActivity) {
            ((BaseFMActivity) activity).replaceFragment(fragment);
        }
    }

    public void statusBarTextDarkLight(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseFMActivity) {
            ((BaseFMActivity) activity).statusBarTextDarkLight(z);
        }
    }
}
