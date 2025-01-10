package com.clean888.cleansuper.cleaner.ui.fragment.lamp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

@TargetApi(21)
/* loaded from: classes2.dex */
public class fd extends cd {
    private Surface i;
    private CameraDevice j;
    private CameraCaptureSession k;
    private SurfaceTexture l;
    private CaptureRequest m;
    private bd n;
    private final Runnable o;
    private final Runnable p;
    private final CameraDevice.StateCallback q;
    private final CameraCaptureSession.StateCallback r;
    private final CameraManager.AvailabilityCallback s;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fd.this.x(false);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                fd.this.e = false;
            }
            fd.this.x(true);
        }
    }

    /* loaded from: classes2.dex */
    class c extends CameraDevice.StateCallback {
        c() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            if (fd.this.j == cameraDevice) {
                fd.this.b(20);
                fd.this.w();
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            if (cameraDevice == fd.this.j || fd.this.j == null) {
                fd.this.s(i == 5 ? 22 : i == 4 ? 23 : i == 3 ? 21 : 20);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            fd.this.j = cameraDevice;
            fd.this.t();
        }
    }

    /* loaded from: classes2.dex */
    class d extends CameraCaptureSession.StateCallback {
        d() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Log.e(ed.f1770g, "Configure failed.");
            if (fd.this.k == null || fd.this.k == cameraCaptureSession) {
                fd.this.s(32);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            fd.this.k = cameraCaptureSession;
            fd.this.t();
        }
    }

    /* loaded from: classes2.dex */
    class e extends CameraManager.AvailabilityCallback {
        e() {
        }

        private void a(boolean z) {
            synchronized (fd.this) {
                boolean z2 = fd.this.d;
                fd.this.d = z;
            }
            fd.this.c(z);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String str) {
            if (str.equals(fd.this.b)) {
                a(true);
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String str) {
            if (str.equals(fd.this.b)) {
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fd(Context context) {
        super(context);
        this.o = new a();
        this.p = new b();
        this.q = new c();
        this.r = new d();
        this.s = new e();
        i();
    }

    private Size r(String str) throws CameraAccessException {
        Size[] outputSizes = ((StreamConfigurationMap) this.h.getCameraCharacteristics(str).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class);
        if (outputSizes != null && outputSizes.length != 0) {
            Size size = outputSizes[0];
            for (Size size2 : outputSizes) {
                if (size.getWidth() >= size2.getWidth() && size.getHeight() >= size2.getHeight()) {
                    size = size2;
                }
            }
            return size;
        }
        throw new IllegalStateException("Camera " + str + "doesn't support any outputSize.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        synchronized (this) {
            this.e = false;
        }
        b(i);
        c(false);
        x(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        g();
        this.a.post(this.o);
    }

    private void u() {
        if (ContextCompat.checkSelfPermission(this.c, "android.permission.CAMERA") != 0) {
            b(19);
            return;
        }
        try {
            this.h.openCamera(this.b, this.q, this.a);
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    private void v() throws CameraAccessException {
        this.l = new SurfaceTexture(0, false);
        Size r = r(this.j.getId());
        this.l.setDefaultBufferSize(r.getWidth(), r.getHeight());
        this.i = new Surface(this.l);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.i);
        this.j.createCaptureSession(arrayList, this.r, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            this.j = null;
            this.k = null;
            this.m = null;
            Surface surface = this.i;
            if (surface != null) {
                surface.release();
                this.l.release();
            }
            this.i = null;
            this.l = null;
            this.e = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        boolean z2;
        try {
            try {
                synchronized (this) {
                    z2 = this.e && !z;
                }
                if (z2) {
                    if (this.j == null) {
                        u();
                        return;
                    }
                    if (this.k == null) {
                        v();
                        return;
                    }
                    CaptureRequest captureRequest = this.m;
                    if (captureRequest == null || ((Integer) captureRequest.get(CaptureRequest.FLASH_MODE)).intValue() != 2) {
                        CaptureRequest.Builder createCaptureRequest = this.j.createCaptureRequest(1);
                        createCaptureRequest.set(CaptureRequest.FLASH_MODE, 2);
                        createCaptureRequest.addTarget(this.i);
                        CaptureRequest build = createCaptureRequest.build();
                        this.k.capture(build, null, this.a);
                        this.m = build;
                        this.e = true;
                    }
                } else if (this.m != null) {
                    CaptureRequest.Builder createCaptureRequest2 = this.j.createCaptureRequest(1);
                    createCaptureRequest2.set(CaptureRequest.FLASH_MODE, 0);
                    createCaptureRequest2.addTarget(this.i);
                    CaptureRequest build2 = createCaptureRequest2.build();
                    this.k.capture(build2, null, this.a);
                    this.m = build2;
                    this.e = false;
                }
                if (z) {
                    CameraDevice cameraDevice = this.j;
                    if (cameraDevice != null) {
                        cameraDevice.close();
                    }
                    w();
                }
            } catch (CameraAccessException | IllegalStateException | UnsupportedOperationException unused) {
                b(32);
            }
        } catch (Throwable unused2) {
            b(32);
        }
    }

    @Override // defpackage.ed
    public void e() {
        synchronized (this) {
            this.e = false;
        }
        this.a.post(this.p);
    }

    @Override // defpackage.ed
    public void f(boolean z) {
        if (TextUtils.isEmpty(this.b)) {
            this.n.f(z);
        } else if (this.e != z) {
            this.e = z;
            t();
        }
    }

    @Override // defpackage.cd
    public void i() {
        super.i();
        if (this.b != null) {
            this.h.registerAvailabilityCallback(this.s, this.a);
        }
        if (TextUtils.isEmpty(this.b)) {
            this.n = new bd(this.c);
        }
    }
}
