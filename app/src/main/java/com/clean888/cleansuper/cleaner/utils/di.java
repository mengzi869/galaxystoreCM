package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.view.View;

import com.clean888.cleansuper.cleaner.ui.widget.BAHA;

public class di extends ei {
    private a l;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z);
    }

    public di(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        try {
            f();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.ei
    public void a() {
        super.a();
        if (d()) {
            try {
                this.i = 4;
                this.h = 8388627;
                c(new BAHA(this.c));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // defpackage.ei
    protected void e(boolean z, Throwable th) {
        View view;
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(z);
        }
        try {
            if (!d() || (view = this.b) == null) {
                return;
            }
            view.postDelayed(new Runnable() { // from class: ci
                @Override // java.lang.Runnable
                public final void run() {
                    di.this.i();
                }
            }, 50L);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // defpackage.ei
    public void f() {
        try {
            super.f();
            this.l = null;
        } catch (Throwable unused) {
        }
    }

    public di j(a aVar) {
        this.l = aVar;
        return this;
    }
}
