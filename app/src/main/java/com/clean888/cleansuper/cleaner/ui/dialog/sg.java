package com.clean888.cleansuper.cleaner.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.DialogPermissionBinding;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;

public class sg extends BaseDialog {
    private DialogPermissionBinding a;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sg.this.dismiss();
        }
    }

    public sg(Context context) {
        super(context, R.style.transparent_dialog);
    }

    public void b(View.OnClickListener onClickListener) {
        this.a.tvOk.setOnClickListener(onClickListener);
    }

    public void c(String str) {
        this.a.tvContent.setText(str);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        DialogPermissionBinding inflate = DialogPermissionBinding.inflate(LayoutInflater.from(getContext()));
        this.a = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(true);
        this.a.tvCancel.setOnClickListener(new a());
    }
}
