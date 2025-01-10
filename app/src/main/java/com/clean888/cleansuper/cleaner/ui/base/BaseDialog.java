package com.clean888.cleansuper.cleaner.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

/* loaded from: classes2.dex */
//tg
public class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context, @StyleRes int i) {
        super(context, i);
    }

    public Activity a() {
        Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext instanceof Activity) {
            return (Activity) baseContext;
        }
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Activity a = a();
        if (a == null || a.isFinishing()) {
            return;
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        Activity a = a();
        if (a == null || a.isFinishing()) {
            return;
        }
        super.show();
    }
}