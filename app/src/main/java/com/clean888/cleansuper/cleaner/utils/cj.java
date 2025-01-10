package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class cj implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private a c;
    private Context d;
    private float f;

    /* renamed from: g, reason: collision with root package name */
    private float f114g;
    private float h;
    private long i;
    private long j;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public cj(Context context) {
        this.d = context;
        b();
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void b() {
        SensorManager sensorManager = (SensorManager) this.d.getSystemService("sensor");
        this.a = sensorManager;
        if (sensorManager != null) {
            this.b = sensorManager.getDefaultSensor(1);
        }
        Sensor sensor = this.b;
        if (sensor != null) {
            this.a.registerListener(this, sensor, 1);
        }
    }

    public void c() {
        this.a.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.i;
        if (j < 70) {
            return;
        }
        this.i = currentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = f - this.f;
        float f5 = f2 - this.f114g;
        float f6 = f3 - this.h;
        this.f = f;
        this.f114g = f2;
        this.h = f3;
        double sqrt = (Math.sqrt(((f4 * f4) + (f5 * f5)) + (f6 * f6)) / j) * 10000.0d;
        if (sqrt >= 4000.0d) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 - this.j < 3000) {
                return;
            }
            this.j = currentTimeMillis2;
//            if (md1.e()) {
//                md1.b("BAIH", "onshake:" + sqrt);
//            }
            a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
