package com.clean888.cleansuper.cleaner.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.service.BAAH;

public class BAAO extends BroadcastReceiver {
    private static final String TAG = "Receiver-BAAO";
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        L.e(TAG,"onReceive");
        BAAH.f(context);
    }
}
