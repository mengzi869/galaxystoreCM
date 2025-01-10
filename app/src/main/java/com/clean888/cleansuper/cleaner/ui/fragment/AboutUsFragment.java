package com.clean888.cleansuper.cleaner.ui.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.databinding.FragmentAboutUsBinding;
import com.clean888.cleansuper.cleaner.utils.AppInfoUtil;
import com.clean888.cleansuper.cleaner.ui.ViewModel.AboutUsViewModel;

public class AboutUsFragment extends BaseFragment implements View.OnClickListener {
    private FragmentAboutUsBinding binding;
    private AboutUsViewModel mViewModel;

    public static AboutUsFragment newInstance() {
        return new AboutUsFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mViewModel = (AboutUsViewModel) new ViewModelProvider(this).get(AboutUsViewModel.class);
    }

    @Override
    public void onClick(View view) {
        FragmentAboutUsBinding fragmentAboutBinding = this.binding;
        if (view == fragmentAboutBinding.privacyPolicy) {
            this.mViewModel.goPrivacyPolicy(getContext());
        } else if (view == fragmentAboutBinding.termsOfService) {
            this.mViewModel.goTermsOfService(getContext());
        } else if (view == fragmentAboutBinding.back) {
            finishActivity();
        }
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        FragmentAboutUsBinding inflate = FragmentAboutUsBinding.inflate(layoutInflater);
        this.binding = inflate;
        inflate.privacyPolicy.setOnClickListener(this);
        this.binding.termsOfService.setOnClickListener(this);
        this.binding.back.setOnClickListener(this);
        this.binding.appVersion.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + AppInfoUtil.getAppVersionName(getActivity(), getActivity().getPackageName()));
        try {
            this.binding.privacyPolicy.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
            this.binding.termsOfService.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.binding.getRoot();
    }
}
