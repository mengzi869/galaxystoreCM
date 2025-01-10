package com.clean888.cleansuper.cleaner.ui.dialog;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.DialogStopBinding;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;

public class StopDialog extends BaseDialog implements View.OnClickListener {
    DialogStopBinding dialogStopBinding;
    Runnable b;
    Runnable c;

    public StopDialog(@NonNull Context context, Runnable runnable, Runnable runnable2) {
        super(context, R.style.transparent_dialog);
        this.b = runnable;
        this.c = runnable2;
    }

    @Override
    public void onClick(View view) {
        if (view == this.dialogStopBinding.stop) {
            dismiss();
            this.b.run();
        } else {
            dismiss();
            this.c.run();
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogStopBinding inflate = DialogStopBinding.inflate(LayoutInflater.from(getContext()));
        this.dialogStopBinding = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(true);
        this.dialogStopBinding.getRoot().setOnClickListener(this);
        this.dialogStopBinding.stop.setOnClickListener(this);
        this.dialogStopBinding.keepGoing.setOnClickListener(this);
    }
}