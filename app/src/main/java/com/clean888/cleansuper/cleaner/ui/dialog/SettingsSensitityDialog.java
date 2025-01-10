package com.clean888.cleansuper.cleaner.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.DialogSettingsSensitivityBinding;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;

public class SettingsSensitityDialog extends BaseDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    DialogSettingsSensitivityBinding sensitivityBinding;
    a_mmkv b;

    public SettingsSensitityDialog(@NonNull Context context) {
        super(context, R.style.transparent_dialog);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
//            ol0 i = i4.a().i("c_shakeboost_sen");
            DialogSettingsSensitivityBinding dialogSettingsSensitivityBinding = this.sensitivityBinding;
            AppCompatCheckBox appCompatCheckBox = dialogSettingsSensitivityBinding.heightCheck;
            if (compoundButton == appCompatCheckBox) {
                dialogSettingsSensitivityBinding.midCheck.setChecked(false);
                this.sensitivityBinding.lowCheck.setChecked(false);
                this.b.J();
//                i.putEbKey1(1).commit();
                return;
            }
            if (compoundButton == dialogSettingsSensitivityBinding.midCheck) {
                appCompatCheckBox.setChecked(false);
                this.sensitivityBinding.lowCheck.setChecked(false);
                this.b.L();
//                i.putEbKey1(2).commit();
                return;
            }
            if (compoundButton == dialogSettingsSensitivityBinding.lowCheck) {
                appCompatCheckBox.setChecked(false);
                this.sensitivityBinding.midCheck.setChecked(false);
                this.b.K();
//                i.putEbKey1(3).commit();
            }
        }
    }

    @Override
    public void onClick(View view) {
        DialogSettingsSensitivityBinding dialogSettingsSensitivityBinding = this.sensitivityBinding;
        if (view == dialogSettingsSensitivityBinding.ok) {
            dismiss();
            return;
        }
        if (view == dialogSettingsSensitivityBinding.heightT) {
            dialogSettingsSensitivityBinding.heightCheck.setChecked(true);
        } else if (view == dialogSettingsSensitivityBinding.midT) {
            dialogSettingsSensitivityBinding.midCheck.setChecked(true);
        } else if (view == dialogSettingsSensitivityBinding.lowT) {
            dialogSettingsSensitivityBinding.lowCheck.setChecked(true);
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogSettingsSensitivityBinding inflate = DialogSettingsSensitivityBinding.inflate(LayoutInflater.from(getContext()));
        this.sensitivityBinding = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(true);
        this.sensitivityBinding.ok.setOnClickListener(this);
//        a h = a.h();
//        this.b = h;
        b = a_mmkv.h();
        this.sensitivityBinding.heightCheck.setChecked(this.b.s());
        this.sensitivityBinding.midCheck.setChecked(this.b.u());
        this.sensitivityBinding.lowCheck.setChecked(this.b.t());
        this.sensitivityBinding.heightCheck.setOnCheckedChangeListener(this);
        this.sensitivityBinding.midCheck.setOnCheckedChangeListener(this);
        this.sensitivityBinding.lowCheck.setOnCheckedChangeListener(this);
        this.sensitivityBinding.heightT.setOnClickListener(this);
        this.sensitivityBinding.midT.setOnClickListener(this);
        this.sensitivityBinding.lowT.setOnClickListener(this);
    }
}
