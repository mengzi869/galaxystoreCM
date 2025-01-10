package com.clean888.cleansuper.cleaner.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
//import bfj.fqiumlkcse.qoz.niiwgu.BAAH;

/* loaded from: classes2.dex */
public class kj {
    private static String a(Context context) {
        int myPid = Process.myPid();
        String str = "";
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        str = runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }
//
//    public static oj b() {
//        oj a = oj.a();
//        return a == null ? new oj() : a;
//    }

    public static boolean c(Context context) {
        try {
            return context.getApplicationContext().getPackageName().equals(a(context));
        } catch (Exception unused) {
            return false;
        }
    }

    public static void d(Context context) {
//        if (z22.a(context) && c(context)) {
//            BAAH.f(context.getApplicationContext());
//            hb.f().k();
//        }
        hb_NotificationListUtils.getInstance().perStart();
    }
}