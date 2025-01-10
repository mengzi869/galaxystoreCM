package com.clean888.cleansuper.cleaner.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.DialogPopRequestBinding;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;

public class dg extends BaseDialog implements View.OnClickListener {
    private DialogPopRequestBinding a;
    private Runnable b;
    private Runnable c;

    public dg(@NonNull Context context, Runnable runnable, Runnable runnable2) {
        super(context, R.style.transparent_dialog);
        this.b = runnable;
        this.c = runnable2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DialogPopRequestBinding dialogPopRequestBinding = this.a;
        if (view == dialogPopRequestBinding.btnNo) {
            dismiss();
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (view == dialogPopRequestBinding.btnOk) {
            dismiss();
            Runnable runnable2 = this.b;
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogPopRequestBinding inflate = DialogPopRequestBinding.inflate(LayoutInflater.from(getContext()));
        this.a = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(false);
        this.a.btnNo.setOnClickListener(this);
        this.a.btnOk.setOnClickListener(this);
    }
}