package com.clean888.cleansuper.cleaner.ui.fragment.lamp;

import android.content.Context;
import android.hardware.Camera;

/* loaded from: classes2.dex */
public class bd extends ed {
    private Camera h;
    private Camera.Parameters i;

    /* JADX INFO: Access modifiers changed from: protected */
    public bd(Context context) {
        super(context);
    }

    private void g() throws Throwable {
        this.i.setFlashMode("off");
        this.h.setParameters(this.i);
        this.h.stopPreview();
        this.h.release();
    }

    private void h() {
        Camera.Parameters parameters = this.i;
        if (parameters != null) {
            parameters.setFlashMode("off");
        }
        Camera camera = this.h;
        if (camera != null) {
            camera.setParameters(this.i);
        }
    }

    private Camera i() {
        if (this.h == null) {
            this.h = Camera.open();
        }
        Camera camera = this.h;
        if (camera == null) {
            return null;
        }
        if (this.i == null) {
            this.i = camera.getParameters();
        }
        this.i.setFlashMode("torch");
        this.h.setParameters(this.i);
        return this.h;
    }

    private Camera k() throws Throwable {
        Camera open = Camera.open();
        this.h = open;
        if (open == null) {
            return null;
        }
        Camera.Parameters parameters = open.getParameters();
        this.i = parameters;
        parameters.setFlashMode("torch");
        this.h.setParameters(this.i);
        this.h.startPreview();
        return this.h;
    }

    @Override // defpackage.ed
    public void e() {
        Camera camera = this.h;
        if (camera != null) {
            if (camera != null) {
                try {
                    g();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.h = null;
        }
    }

    @Override // defpackage.ed
    public void f(boolean z) {
        j(z, true);
    }

    public void j(boolean z, boolean z2) {
        if (z == this.e) {
            return;
        }
        if (z2) {
            if (z) {
                try {
                } catch (SecurityException unused) {
                    this.e = false;
                    b(19);
                } catch (Throwable unused2) {
                    this.e = false;
                    b(20);
                }
                if (i() == null) {
                    this.d = false;
                    this.e = false;
                    b(17);
                    return;
                } else {
                    this.e = true;
                    c(this.e);
                    return;
                }
            }
            try {
                h();
                this.e = false;
            } catch (Throwable unused3) {
            }
            c(this.e);
            return;
        }
        if (z) {
            try {
            } catch (SecurityException unused4) {
                this.e = false;
                b(19);
            } catch (Throwable unused5) {
                this.e = false;
                b(20);
            }
            try {
                if (k() == null) {
                    this.d = false;
                    this.e = false;
                    b(17);
                    return;
                } else {
                    this.e = true;
                    c(this.e);
                    return;
                }
            } catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
        try {
            g();
            this.e = false;
        } catch (Throwable unused6) {
        }
        c(this.e);
    }
}
