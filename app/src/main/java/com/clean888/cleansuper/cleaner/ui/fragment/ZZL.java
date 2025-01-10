package com.clean888.cleansuper.cleaner.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.AppUtils;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentAppScanBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;

/* loaded from: classes2.dex */
public class ZZL extends BaseFragment implements View.OnClickListener {
    private FragmentAppScanBinding binding;
    private String packgeName;
    private int pageFrom;

    public static ZZL newInstance() {
        return new ZZL();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        FragmentAppScanBinding fragmentAppScanBinding = this.binding;
        if (view == fragmentAppScanBinding.button) {
            try {
                str = getActivity().getPackageManager().getApplicationInfo(this.packgeName, 0).loadLabel(getActivity().getPackageManager()).toString();
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            replaceFragment(BAEY.newInstance(FuncFinishTitleModel.AppScan.setExtras(str)));
            return;
        }
        if (view == fragmentAppScanBinding.back) {
            finishActivity();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        FragmentAppScanBinding inflate = FragmentAppScanBinding.inflate(layoutInflater);
        this.binding = inflate;
        inflate.back.setOnClickListener(this);
        this.binding.button.setOnClickListener(this);
        this.binding.text1.setText(String.format(getString(R.string.app_scan_text), AppUtils.getAppName()));
        this.pageFrom = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
        this.packgeName = getActivity().getIntent().getStringExtra(MainActivity.PACKAGE);
//        i4.a().i("s_app_scan").putEbKey1(Integer.valueOf(this.pageFrom)).commit();
//        qh.c();
        return this.binding.getRoot();
    }
}
