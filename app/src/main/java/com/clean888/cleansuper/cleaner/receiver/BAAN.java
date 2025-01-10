package com.clean888.cleansuper.cleaner.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import androidx.core.app.NotificationManagerCompat;

import com.clean888.cleansuper.cleaner.utils.L;

public class BAAN extends BroadcastReceiver {

    private static final String TAG = "Receiver-BAAN";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("notifyID", -1);
            L.e(TAG, "onReceive notifyID = " + intExtra);
            if (intExtra > 0) {
                NotificationManagerCompat.from(context).cancel(intExtra);
            }
            String stringExtra = intent.getStringExtra("anyly_click");
            L.e(TAG, "onReceive anyly_click = " + stringExtra);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
//            i4.a().i(stringExtra).putEbKey2(2).commit();
        }
    }
}
