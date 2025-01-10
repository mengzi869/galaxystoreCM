package com.clean888.cleansuper.cleaner.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.Dialog11SdcardRequestBinding;
import com.blankj.utilcode.util.AppUtils;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;

/* renamed from: if, reason: invalid class name */
/* loaded from: classes2.dex */
// Cif
public class Dialog11SdcardRequest extends BaseDialog implements View.OnClickListener {
    private Dialog11SdcardRequestBinding a;
    private Runnable b;
    private Runnable c;
    private boolean d;

    public Dialog11SdcardRequest(@NonNull Context context, Runnable runnable, Runnable runnable2) {
        this(context, runnable, runnable2, true);
    }

    @Override  // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog11SdcardRequestBinding dialog11SdcardRequestBinding = this.a;
        if (view == dialog11SdcardRequestBinding.button) {
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
            this.a.button.postDelayed(new Runnable() { // from class: hf
                @Override // java.lang.Runnable
                public final void run() {
                    Dialog11SdcardRequest.this.dismiss();
                }
            }, 500L);
            return;
        }
        if (view == dialog11SdcardRequestBinding.buttonCancel) {
            Runnable runnable2 = this.c;
            if (runnable2 != null) {
                runnable2.run();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Dialog11SdcardRequestBinding inflate = Dialog11SdcardRequestBinding.inflate(LayoutInflater.from(getContext()));
        this.a = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(this.d);
        this.a.button.setOnClickListener(this);
        this.a.buttonCancel.setOnClickListener(this);
        this.a.text.setText(String.format(a().getString(R.string.permission_an11_request_text), AppUtils.getAppName()));
    }

    public Dialog11SdcardRequest(@NonNull Context context, Runnable runnable, Runnable runnable2, boolean z) {
        super(context, R.style.transparent_dialog);
        this.b = runnable;
        this.c = runnable2;
        this.d = z;
    }
}
