package com.clean888.cleansuper.cleaner.ui.fragment.lamp;


import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes2.dex */
public class cd extends ed {
    protected CameraManager h;

    /* JADX INFO: Access modifiers changed from: protected */
    public cd(Context context) {
        super(context);
        this.h = (CameraManager) this.c.getSystemService("camera");
    }

    public synchronized void g() {
        if (this.a == null) {
            HandlerThread handlerThread = new HandlerThread(ed.f1770g, 8);
            handlerThread.start();
            this.a = new Handler(handlerThread.getLooper());
        }
    }

    @TargetApi(21)
    public String h() throws CameraAccessException {
        for (String str : this.h.getCameraIdList()) {
            CameraCharacteristics cameraCharacteristics = this.h.getCameraCharacteristics(str);
            Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (bool != null && bool.booleanValue() && num != null && num.intValue() == 1) {
                return str;
            }
        }
        return null;
    }

    @TargetApi(21)
    public void i() {
        try {
            String h = h();
            this.b = h;
            if (h != null) {
                g();
            }
        } catch (CameraAccessException unused) {
        } catch (SecurityException unused2) {
            b(17);
        } catch (Throwable unused3) {
            b(32);
        }
    }
}
