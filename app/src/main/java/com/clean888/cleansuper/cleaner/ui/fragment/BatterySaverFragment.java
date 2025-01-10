package com.clean888.cleansuper.cleaner.ui.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.databinding.FragmentAnimBatteryBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BatterySaverViewModel;
import com.clean888.cleansuper.cleaner.ui.dialog.StopDialog;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;

import java.util.List;

public class BatterySaverFragment extends BaseFragment implements View.OnClickListener {
    private FragmentAnimBatteryBinding binding;
    private boolean keepGoing;
    private BatterySaverViewModel mViewModel;
    private int pageFrom;
    private StopDialog stopDialog;

    public void endAnim() {
        if (checkFragmentAlive()) {
            StopDialog dialog = this.stopDialog;
            if (dialog != null && dialog.isShowing()) {
                this.keepGoing = true;
            } else {
                goNextPage();
            }
        }
    }

    private void goNextPage() {
        List<BADJ.c> animShowInfo = this.mViewModel.getAnimShowInfo();
        if (animShowInfo.size() > 0) {
            replaceFragment(new BADJ.b().d(animShowInfo).c(new BADJ.b.a() {
                @Override
                public final Object a() {
                    return BAEY.newInstance(FuncFinishTitleModel.BatterySaver);
                }
            }).a());
        } else {
            replaceFragment(BAEY.newInstance(FuncFinishTitleModel.BatterySaver));
        }
    }

    public static BatterySaverFragment newInstance() {
        return new BatterySaverFragment();
    }

    private void showStopDialog() {
        if (this.stopDialog == null) {
            this.stopDialog = new StopDialog(getActivity(), new Runnable() {
                @Override
                public final void run() {
                    finishActivity();
                }
            }, new Runnable() {
                @Override
                public final void run() {
                    if (keepGoing) {
                        goNextPage();
                    }
                }
            });
        }
        if (this.stopDialog.isShowing()) {
            return;
        }
        this.stopDialog.show();
    }

    @Override
    public void onClick(View view) {
        if (view == this.binding.back) {
            showStopDialog();
        }
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        this.mViewModel = (BatterySaverViewModel) new ViewModelProvider(this).get(BatterySaverViewModel.class);
        FragmentAnimBatteryBinding inflate = FragmentAnimBatteryBinding.inflate(layoutInflater);
        this.binding = inflate;
        inflate.back.setOnClickListener(this);
        this.mViewModel.doScan(getContext());
        ThreadUtils.runOnUiThreadDelayed(() -> BatterySaverFragment.this.endAnim(), 6000L);

        this.pageFrom = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
        return this.binding.getRoot();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showStopDialog();
            return true;
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}