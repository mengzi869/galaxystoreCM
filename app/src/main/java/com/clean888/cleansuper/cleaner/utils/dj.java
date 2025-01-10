package com.clean888.cleansuper.cleaner.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

import com.clean888.cleansuper.cleaner.receiver.WidgetReceiver;

/* loaded from: classes2.dex */
public class dj {
    private Application a;

    public dj(Application application) {
        this.a = application;
    }

    public void a() {
        WidgetReceiver bafk = new WidgetReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("customer.intent.action.TIME_TICK");
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.registerReceiver(bafk, intentFilter, Context.RECEIVER_EXPORTED);
        } else {
            this.a.registerReceiver(bafk, intentFilter);
        }
    }

    public void b() {
        try {
            a();
            c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        Intent intent = new Intent();
        intent.setAction("customer.intent.action.TIME_TICK");
        this.a.sendBroadcast(intent);
    }
}
