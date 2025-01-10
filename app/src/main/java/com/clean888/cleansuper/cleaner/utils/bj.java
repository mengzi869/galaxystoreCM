package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;

import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class bj {

    private static final String TAG = "BAIH-bj";

    public static int a(Activity activity) {
        try {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point.x;
        } catch (Exception unused) {
            return Resources.getSystem().getDisplayMetrics().widthPixels;
        }
    }

    public static int b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static boolean c(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 1).size() > 0;
    }

    public static boolean d(Context context) {
        return NotificationManagerCompat.from(context.getApplicationContext()).areNotificationsEnabled();
    }

    public static boolean e(Context context) {
//        if (Constants.REFERRER_API_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
        if ("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.android.settings", "com.miui.securitycenter.permission.AppPermissionsEditor");
        if (c(context, intent)) {
            return true;
        }
        boolean equalsIgnoreCase = "miui".equalsIgnoreCase(Build.ID);
        if ("xiaomi".equalsIgnoreCase(Build.BRAND)) {
            equalsIgnoreCase = true;
        }
        String str = Build.MODEL;
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains("xiaomi")) {
                equalsIgnoreCase = true;
            }
            if (lowerCase.contains("miui")) {
                return true;
            }
        }
        return equalsIgnoreCase;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT > 28;
    }

    @SuppressLint({"WrongConstant"})
    public static void g(Context context) {
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("statusbar");
        try {
            Method method = Class.forName("android.app.StatusBarManager").getMethod("collapsePanels", new Class[0]);
            method.setAccessible(true);
            method.invoke(systemService, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String h(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        return String.format("%02d小时%02d分钟%02d秒", Long.valueOf(j3), Long.valueOf(j4 / 60), Long.valueOf(j4 % 60));
    }

    public static int i(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static String j(Context context, String str) {
        try {
            return ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getRunningTasks(1).get(0).topActivity.getPackageName() + str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int k(Context context) {
        return ((BatteryManager) context.getSystemService(Context.BATTERY_SERVICE)).getIntProperty(4);
    }

    public static String l(Context context) {
        try {
            ComponentName componentName = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getRunningTasks(1).get(0).topActivity;
            return componentName.getPackageName() + componentName.getShortClassName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static int m(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(memoryInfo);
        long j = memoryInfo.totalMem;
        long j2 = memoryInfo.availMem;
        if (j != 0) {
            return (int) ((1.0f - ((((float) j2) * 1.0f) / ((float) j))) * 100.0f);
        }
        return 0;
    }

    public static boolean n(Context context) {
        return ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public static boolean o(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (powerManager != null && !powerManager.isScreenOn()) {
            return true;
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean p() {
//        long c = mi.c();
//        n nVar = n.a;
//        long s = nVar.s();
//        if (!nVar.E()) {
//            if (md1.e()) {
//                md1.b("BAIH", "服务器时间失败，本地时间");
//            }
//            c = nVar.s();
//            s = System.currentTimeMillis();
//        }
//        long abs = Math.abs(s - c);
//        long j = kj.b().f1951g * fr2.a;
//        if (md1.e()) {
//            StringBuilder sb = new StringBuilder();
//            sb.append("安装时间间隔");
//            sb.append(h(abs));
//            sb.append("--needTime:");
//            sb.append(h(j));
//            sb.append("--isOverTime:");
//            sb.append(abs >= j);
//            md1.b("BAIH", sb.toString());
//        }
//        return abs >= j;
        return true;
    }

    public static boolean checkTimes(String tag, long curTime, long configTime, String key, String str2, String str3, String str4) {
        long pja = pj.a(key);
        long abs = Math.abs(curTime - pja);
        boolean z = abs >= configTime;
        L.d(TAG, "       检查时间间隔 " + key + ":" + h(abs) + ", need:" + h(configTime) + " isOverTime:" + z + "   curTime:" + curTime + " configTime:" + configTime + " mmkvTime:" + pja);
        L.d(tag, "       检查时间间隔 " + key + ":" + h(abs) + ", need:" + h(configTime) + " isOverTime:" + z + "   curTime:" + curTime + " configTime:" + configTime + " mmkvTime:" + pja);

        if (!z && !TextUtils.isEmpty(str3)) {
//            i4.a().i(str3).putEbKey1(str4).putEbKey2(((abs / 1000) / 60) + "").commit();
        }
        return z;
    }

    public static boolean r() {
//        boolean z = kj.b().h;
//        if (md1.e()) {
//            Log.d("PopHelp", "PopHelp open = " + z);
//        }
//        return z;

        return true;
    }
}