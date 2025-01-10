package com.clean888.cleansuper.cleaner.ui.fragment.lamp;


import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.text.TextUtils;

@TargetApi(23)
/* loaded from: classes2.dex */
public class ad extends cd {
    private boolean i;
    private fd j;
    private final CameraManager.TorchCallback k;

    /* loaded from: classes2.dex */
    class a extends CameraManager.TorchCallback {
        a() {
        }

        private void a(boolean z) {
            synchronized (ad.this) {
                boolean z2 = ad.this.d;
                ad.this.d = z;
            }
        }

        private void b(boolean z) {
            boolean z2;
            synchronized (ad.this) {
                z2 = ad.this.e != z;
                ad.this.e = z;
            }
            if (z2) {
                ad.this.k(z);
            }
        }

        @Override // android.hardware.camera2.CameraManager.TorchCallback
        public void onTorchModeChanged(String str, boolean z) {
            if (TextUtils.equals(str, ad.this.b)) {
                a(true);
                b(z);
            }
        }

        @Override // android.hardware.camera2.CameraManager.TorchCallback
        public void onTorchModeUnavailable(String str) {
            if (TextUtils.equals(str, ad.this.b)) {
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(Context context) {
        super(context);
        this.i = false;
        this.k = new a();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z) {
    }

    @Override // defpackage.ed
    public void e() {
        f(false);
    }

    @Override // defpackage.ed
    public void f(boolean z) {
        if (!TextUtils.isEmpty(this.b) && !this.i) {
            synchronized (this) {
                if (this.e != z) {
                    try {
                        this.h.setTorchMode(this.b, z);
                        this.e = z;
                    } catch (CameraAccessException unused) {
                        this.e = false;
                        this.i = true;
                    } catch (Throwable unused2) {
                        this.e = false;
                        this.i = true;
                    }
                }
            }
        }
        if (this.i) {
            this.j.f(z);
        } else {
            k(this.e);
        }
    }

    @Override // defpackage.cd
    public void i() {
        super.i();
        if (this.b != null) {
            this.h.registerTorchCallback(this.k, this.a);
        }
        this.j = new fd(this.c);
    }
}