package com.clean888.cleansuper.cleaner.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.clean888.cleansuper.cleaner.receiver.utils.mj;

/* loaded from: classes2.dex */
public class BAAS extends IntentService {
    private Context a;

    public BAAS() {
        super("TimeTickService");
    }

    @Override // android.app.IntentService, android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = this;
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        mj.b(this.a);
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
