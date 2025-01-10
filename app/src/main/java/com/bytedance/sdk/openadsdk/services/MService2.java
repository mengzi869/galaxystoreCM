package com.bytedance.sdk.openadsdk.services;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import com.clean888.cleansuper.cleaner.utils.oa4;
import com.mbridge.msdk.k_cor.KSManager;

/* loaded from: classes3.dex */
public class MService2 extends Service {
    public static final Handler rJxGd = new Handler(Looper.getMainLooper());
    public rJxGd oZnPOI;

    /* loaded from: classes3.dex */
    public static class rJxGd extends AbstractThreadedSyncAdapter {

        /* renamed from: com.bytedance.sdk.openadsdk.services.MService2$rJxGd$rJxGd, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0280rJxGd implements Runnable {
            public final Account rJxGd;

            public RunnableC0280rJxGd(Account account) {
                this.rJxGd = account;
            }

            @Override // java.lang.Runnable
            public void run() {
                KSManager.sAccount(rJxGd.this.getContext());
            }
        }

        public rJxGd(Context context, boolean z) {
            super(context, z);
        }

        @Override // android.content.AbstractThreadedSyncAdapter
        public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            try {
                boolean z = bundle.getBoolean(oa4.a("AQEHABE="));
                Handler handler = MService2.rJxGd;
                handler.removeCallbacksAndMessages(oa4.a("BwsfAAs="));
                if (z) {
                    syncResult.stats.numIoExceptions = 0L;
                    KSManager.sAccount(getContext());
                } else {
                    syncResult.stats.numIoExceptions = 1L;
                    handler.postAtTime(new RunnableC0280rJxGd(account), oa4.a("BwsfAAs="), SystemClock.uptimeMillis() + 20000);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(oa4.a("GgoCCg4SVxYWBgoXQk0="), e.getMessage());
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.oZnPOI.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.oZnPOI = new rJxGd(getApplicationContext(), true);
    }
}
