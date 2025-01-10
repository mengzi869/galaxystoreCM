package com.clean888.cleansuper.cleaner.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.clean888.cleansuper.cleaner.receiver.utils.PackageActionCheckUtil;
import com.clean888.cleansuper.cleaner.utils.L;

// BABE
public class PackageActionReceiver extends BroadcastReceiver {

    private static final String TAG = "PackageActionReceiver";
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        L.e(TAG,"onReceive action = "+intent.getAction());
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) {
            PackageActionCheckUtil.checkInstallApp(context, intent);
        } else if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)) {
            PackageActionCheckUtil.checkUninstallApp(context, intent);
        }
    }

    // BABE 接收通知 -> nj.a 判断是否满足条件，若满足则调用 BAAT ->
}
