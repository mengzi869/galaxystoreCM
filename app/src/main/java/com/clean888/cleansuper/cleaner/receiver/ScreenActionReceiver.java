package com.clean888.cleansuper.cleaner.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.clean888.cleansuper.cleaner.receiver.utils.ScreenActionCheckUtil;
import com.clean888.cleansuper.cleaner.utils.L;

// BAHE
public final class ScreenActionReceiver extends BroadcastReceiver {

    private static final String TAG = "ScreenActionReceiver";

    private Context bontext;
    private Handler handler = new Handler();
    private Runnable runnable = new a();

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScreenActionReceiver bahe = ScreenActionReceiver.this;
            bahe.c(bahe.bontext, "home_press", "s_home_press", "c_home_press", "r_home_press", false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, String str2, String str3, String str4, boolean isScreenOn, boolean z2) {
        ScreenActionCheckUtil.checkUserPresentAndScreenOn(context, str, str2, str3, str4, isScreenOn, z2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.bontext = context;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_USER_PRESENT)) { // 解锁
            L.e(TAG,"onReceive action = "+action);
            c(context, "phone_unlock", "s_phone_unlock", "c_phone_unlock", "r_phone_unlock", true, false);
            return;
        }
        if (action.equals(Intent.ACTION_SCREEN_ON)) {// 屏幕开启时
            L.e(TAG,"onReceive action = "+action);
            c(context, "phone_unlock", "s_phone_unlock", "c_phone_unlock", "r_phone_unlock", true, true);
            return;
        }
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) { // Home
            String stringExtra = intent.getStringExtra("reason");
            L.e(TAG,"onReceive action = "+action+" stringExtra:"+stringExtra);
            if (stringExtra != null) {
                if (stringExtra.equals("homekey")) {
                    this.handler.removeCallbacks(this.runnable);
                    this.handler.postDelayed(this.runnable, 3000L);
                    return;
                } else {
                    stringExtra.equals("recentapps");
                    return;
                }
            }
            return;
        }

    }
}
