package com.clean888.cleansuper.cleaner.ui.fragment.lamp;

import android.content.Context;
import android.os.Build;

/* loaded from: classes2.dex */
public class zc {
    private static zc b;
    private ed a;

    public static zc a() {
        if (b == null) {
            b = new zc();
        }
        return b;
    }

    public void b(Context context) {
        if (this.a == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.a = new ad(context);
            } else {
                this.a = new fd(context);
            }
        }
    }

    public synchronized void c() {
        this.a.e();
    }

    public synchronized void d(boolean z) {
        this.a.f(z);
    }
}
