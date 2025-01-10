package com.clean888.cleansuper.cleaner.ui.fragment;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentSettingsBinding;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.ui.ViewModel.SettingsViewModel;
import com.clean888.cleansuper.cleaner.ui.dialog.SettingsSensitityDialog;
import com.clean888.cleansuper.cleaner.ui.dialog.SettingWallpaperDialog;
import com.clean888.cleansuper.cleaner.service.BAAH;
import com.clean888.cleansuper.cleaner.service.BAAU;
import io.reactivex.rxjava3.annotations.NonNull;

public class SettingsFragment extends BaseFragment implements Observer<a_mmkv>, CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final String TAG = "SettingsFragment";
    private FragmentSettingsBinding binding;
    private boolean isInit;
    private SettingsSensitityDialog sensitivityDialog;
    private SettingsViewModel settingsViewModel;

    public class ClearWallpaperTask extends ThreadUtils.Task<Object> {
        ClearWallpaperTask() {
        }

        @Override
        public Object doInBackground() throws Throwable {
            try {
                WallpaperManager.getInstance(SettingsFragment.this.getActivity()).clear();
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override
        public void onFail(Throwable th) {
            L.e(TAG,"th=== " + th.getMessage());
        }

        @Override
        public void onSuccess(Object obj) {
            L.e(TAG,"obj=== " + obj.toString());
        }

        @Override
        public void onCancel() {
            L.e(TAG,"onCancel()");
        }
    }

      public void ToClearWallpaper() {
        BAAU.f = false;
        ThreadUtils.executeByIo(new ClearWallpaperTask());
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    private void showSensitivityDialog() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.sensitivityDialog == null) {
            this.sensitivityDialog = new SettingsSensitityDialog(activity);
        }
        this.sensitivityDialog.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//        final t4 a2 = i4.a();
        FragmentSettingsBinding fragmentSettingsBinding = this.binding;
        if (compoundButton == fragmentSettingsBinding.notificationSwitch) {
            a_mmkv.h().H(z);
            BAAH.f(getContext());
//            a2.i(z ? "c_notification_on" : "c_notification_off").commit();
            return;
        }
        if (compoundButton == fragmentSettingsBinding.autoBoostSwitch) {
            a_mmkv.h().D(z);
//            a2.i(z ? "c_autoboost_on" : "c_autoboost_off").commit();
            return;
        }
        if (compoundButton == fragmentSettingsBinding.chargeBoostSwitch) {
            a_mmkv.h().E(z);
//            a2.i(z ? "c_charge_on" : "c_charge_off").commit();
            return;
        }
        if (compoundButton == fragmentSettingsBinding.shakeBoostSwitch) {
            a_mmkv.h().I(z);
//            a2.i(z ? "c_shakeboost_on" : "c_shakeboost_off").commit();
            return;
        }
        if (compoundButton == fragmentSettingsBinding.installScanSwitch) {
            a_mmkv.h().G(z);
//            a2.i(z ? "c_install_on" : "c_install_off").commit();
            return;
        }
        if (compoundButton == fragmentSettingsBinding.uninstallCleanSwitch) {
            a_mmkv.h().M(z);
//            a2.i(z ? "c_uninstall_on" : "c_uninstall_off").commit();
            return;
        }
        if (compoundButton == fragmentSettingsBinding.quickBoostSwitch) {
            if (z) {
                if (BAAU.f) {
                    return;
                }
//                a2.i(z ? "c_quickboost_on" : "c_quickboost_off").commit();
                try {
                    BAAU.d(getActivity(), "3");
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            if (BAAU.f) {
//                a2.i(z ? "c_quickboost_on" : "c_quickboost_off").commit();
//                a2.i("s_quickboost_off_pop").commit();
                new SettingWallpaperDialog(getActivity(), new Runnable() {
                    @Override
                    public final void run() {
                        SettingsFragment.this.ToClearWallpaper();
                    }
                }, new Runnable() {
                    @Override
                    public final void run() {
                        a_mmkv.h().z();
                    }
                }).show();
            }
        }
    }


    @Override
    public void onClick(View view) {
        FragmentSettingsBinding fragmentSettingsBinding = this.binding;
        if (view != fragmentSettingsBinding.sensitivityT && view != fragmentSettingsBinding.sensitivityState) {
            if (view == fragmentSettingsBinding.back) {
                finishActivity();
                return;
            }
            return;
        }
        showSensitivityDialog();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        statusBarTextDarkLight(true);
        this.settingsViewModel = (SettingsViewModel) new ViewModelProvider(this).get(SettingsViewModel.class);
        this.binding = FragmentSettingsBinding.inflate(layoutInflater, viewGroup, false);
        this.settingsViewModel.getData().observe(getViewLifecycleOwner(), this);
        this.binding.back.setOnClickListener(this);
     /*   this.binding.quickBoostSwitch.setVisibility(a_mmkv.h().w() ? View.VISIBLE : View.GONE);
        this.binding.quickBoost.setVisibility(a_mmkv.h().w() ? View.VISIBLE : View.GONE);
        this.binding.quickBoostT1.setVisibility(a_mmkv.h().w() ? View.VISIBLE : View.GONE);*/
        return this.binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        a_mmkv.h().z();
    }

    @Override
    public void onChanged(a_mmkv aVar) {
        this.binding.notificationSwitch.setChecked(aVar.p());
        this.binding.autoBoostSwitch.setChecked(aVar.j());
        this.binding.chargeBoostSwitch.setChecked(aVar.k());
        this.binding.shakeBoostSwitch.setChecked(aVar.r());
        this.binding.quickBoostSwitch.setChecked(BAAU.f);
        this.binding.installScanSwitch.setChecked(aVar.n());
        this.binding.uninstallCleanSwitch.setChecked(aVar.v());
        if (aVar.s()) {
            this.binding.sensitivityState.setText(R.string.setting_sensitivity_high);
        } else if (aVar.t()) {
            this.binding.sensitivityState.setText(R.string.setting_sensitivity_low);
        } else {
            this.binding.sensitivityState.setText(R.string.setting_sensitivity_mid);
        }
        this.binding.sensitivity.setVisibility(aVar.r() ? View.VISIBLE : View.GONE);
        if (this.isInit) {
            return;
        }
        this.isInit = true;
        this.binding.notificationSwitch.setOnCheckedChangeListener(this);
        this.binding.autoBoostSwitch.setOnCheckedChangeListener(this);
        this.binding.chargeBoostSwitch.setOnCheckedChangeListener(this);
        this.binding.shakeBoostSwitch.setOnCheckedChangeListener(this);
        this.binding.quickBoostSwitch.setOnCheckedChangeListener(this);
        this.binding.installScanSwitch.setOnCheckedChangeListener(this);
        this.binding.uninstallCleanSwitch.setOnCheckedChangeListener(this);
        this.binding.sensitivityT.setOnClickListener(this);
        this.binding.sensitivityState.setOnClickListener(this);
    }
}
