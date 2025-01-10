package com.clean888.cleansuper.cleaner.ui.dialog;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.DialogSdcardRequestBinding;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;

// eg
public class DialogSdcardRequest extends BaseDialog implements View.OnClickListener, ValueAnimator.AnimatorUpdateListener {
    private DialogSdcardRequestBinding a;
    private ValueAnimator b;
    private int c;
    private Runnable d;
    private Runnable f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1775g;
    private boolean h;

    public DialogSdcardRequest(@NonNull Context context, Runnable runnable, Runnable runnable2) {
        this(context, runnable, runnable2, true);
    }

    private void b() {
        this.b.cancel();
        dismiss();
        Runnable runnable = this.d;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void c(boolean z) {
        this.f1775g = z;
        show();
    }

    @Override // defpackage.tg, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.b.removeAllUpdateListeners();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.dismiss();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    @SuppressLint({"SetTextI18n"})
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        try {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (this.c == intValue) {
                return;
            }
            this.c = intValue;
            String string = getContext().getResources().getString(R.string.permission_request_ok);
            if (intValue >= 4) {
                b();
            } else if (intValue >= 3) {
                this.a.button.setText(string + "(0)");
            } else if (intValue >= 2) {
                this.a.button.setText(string + "(1)");
            } else if (intValue >= 1) {
                this.a.button.setText(string + "(2)");
            } else {
                this.a.button.setText(string + "(3)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.getRoot()) {
            this.b.cancel();
            dismiss();
            Runnable runnable = this.f;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (view == this.a.button) {
            b();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogSdcardRequestBinding inflate = DialogSdcardRequestBinding.inflate(LayoutInflater.from(getContext()));
        this.a = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(this.h);
        this.a.button.setOnClickListener(this);
        this.b.setDuration(4000L);
        this.b.addUpdateListener(this);
        this.a.button.setEnabled(true);
    }

    @Override // defpackage.tg, android.app.Dialog
    public void show() {
        super.show();
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            if (this.f1775g) {
                this.b.start();
            }
        }
        if (this.f1775g) {
            return;
        }
        String string = getContext().getResources().getString(R.string.permission_request_ok);
        this.a.button.setEnabled(true);
        this.a.button.setText(string);
    }

    public DialogSdcardRequest(@NonNull Context context, Runnable runnable, Runnable runnable2, boolean z) {
        super(context, R.style.transparent_dialog);
        this.b = ValueAnimator.ofInt(0, 4);
        this.c = -1;
        this.f1775g = true;
        this.d = runnable;
        this.f = runnable2;
        this.h = z;
    }
}
