package com.clean888.cleansuper.cleaner.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.clean888.cleansuper.cleaner.databinding.FragmentWidgetManuallyBinding;
import com.clean888.cleansuper.cleaner.utils.vh0;

/* loaded from: classes2.dex */
public class BAEJ extends BaseFragment implements View.OnClickListener {
    private FragmentWidgetManuallyBinding binding;

    public static BAEJ newInstance() {
        return new BAEJ();
    }

    private int proportionHeight(int i, int i2, int i3) {
        return (int) (((i * 0.1d) / (i2 * 0.1d)) * i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.binding.icBack) {
            finishActivity();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        FragmentWidgetManuallyBinding inflate = FragmentWidgetManuallyBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        inflate.icBack.setOnClickListener(this);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.binding.ivBg1.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.binding.ivBg2.getLayoutParams();
        int c = vh0.c() - vh0.a(82.0f);
//        int proportionHeight = proportionHeight(c, 278, LossReason.LOSS_REASON_CREATIVE_FILTERED_ANIMATION_TOO_LONG_VALUE);
        int proportionHeight = proportionHeight(c, 278, 211);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = c;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = proportionHeight;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = vh0.a(25.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = vh0.a(25.0f);
        this.binding.ivBg1.setLayoutParams(layoutParams);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = c;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = proportionHeight;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = vh0.a(25.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = vh0.a(25.0f);
        this.binding.ivBg2.setLayoutParams(layoutParams2);
        return this.binding.getRoot();
    }
}
