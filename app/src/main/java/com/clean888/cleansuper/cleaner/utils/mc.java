package com.clean888.cleansuper.cleaner.utils;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class mc {
    public static <T> ArrayList<T> a(T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        if (tArr.length == 0) {
            return arrayList;
        }
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean i(Context context) {
        if (g()) {
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    public static boolean j(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean k(Context context) {
        int checkOpNoThrow;
        if (!e()) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        if (b()) {
            checkOpNoThrow = appOpsManager.unsafeCheckOpNoThrow("android:get_usage_stats", context.getApplicationInfo().uid, context.getPackageName());
        } else {
            checkOpNoThrow = appOpsManager.checkOpNoThrow("android:get_usage_stats", context.getApplicationInfo().uid, context.getPackageName());
        }
        return checkOpNoThrow == 0;
    }

    public static boolean l(Context context, String str) {
        if ("android.permission.NOTIFICATION_SERVICE".equals(str)) {
            return j(context);
        }
        if ("android.permission.PACKAGE_USAGE_STATS".equals(str)) {
            return k(context);
        }
        if (!f()) {
            return true;
        }
        if ("android.permission.MANAGE_EXTERNAL_STORAGE".equals(str)) {
            return o(context);
        }
        if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str)) {
            return i(context);
        }
        if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str)) {
            return p(context);
        }
        if ("android.permission.WRITE_SETTINGS".equals(str)) {
            return n(context);
        }
        if (!d()) {
            if ("android.permission.BLUETOOTH_SCAN".equals(str)) {
                return context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == PackageManager.PERMISSION_GRANTED;
            }
            if ("android.permission.BLUETOOTH_CONNECT".equals(str) || "android.permission.BLUETOOTH_ADVERTISE".equals(str)) {
                return true;
            }
        }
        if (!b()) {
            if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str)) {
                return context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == PackageManager.PERMISSION_GRANTED;
            }
            if ("android.permission.ACTIVITY_RECOGNITION".equals(str)) {
                return context.checkSelfPermission("android.permission.BODY_SENSORS") == PackageManager.PERMISSION_GRANTED;
            }
            if ("android.permission.ACCESS_MEDIA_LOCATION".equals(str)) {
                return true;
            }
        }
        if (!h() && "android.permission.ACCEPT_HANDOVER".equals(str)) {
            return true;
        }
        if (!g()) {
            if ("android.permission.ANSWER_PHONE_CALLS".equals(str)) {
                return true;
            }
            if ("android.permission.READ_PHONE_NUMBERS".equals(str)) {
                return context.checkSelfPermission("android.permission.READ_PHONE_STATE") == PackageManager.PERMISSION_GRANTED;
            }
        }
        return context.checkSelfPermission(str) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean m(Context context, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!l(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(Context context) {
        if (f()) {
            return Settings.System.canWrite(context);
        }
        return true;
    }

    public static boolean o(Context context) {
        if (c()) {
            return Environment.isExternalStorageManager();
        }
        return m(context, a(lc.a));
    }

    public static boolean p(Context context) {
        if (f()) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public static boolean q(Activity activity, String str) {
        if (!f() || s(str)) {
            return false;
        }
        if (!d()) {
            if ("android.permission.BLUETOOTH_SCAN".equals(str)) {
                return (l(activity, "android.permission.ACCESS_COARSE_LOCATION") || activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")) ? false : true;
            }
            if ("android.permission.BLUETOOTH_CONNECT".equals(str) || "android.permission.BLUETOOTH_ADVERTISE".equals(str)) {
                return false;
            }
        }
        if (b() && "android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) && !l(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") && !l(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            return !activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION");
        }
        if (!b()) {
            if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str)) {
                return (l(activity, "android.permission.ACCESS_FINE_LOCATION") || activity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) ? false : true;
            }
            if ("android.permission.ACTIVITY_RECOGNITION".equals(str)) {
                return (l(activity, "android.permission.BODY_SENSORS") || activity.shouldShowRequestPermissionRationale("android.permission.BODY_SENSORS")) ? false : true;
            }
            if ("android.permission.ACCESS_MEDIA_LOCATION".equals(str)) {
                return false;
            }
        }
        if (!h() && "android.permission.ACCEPT_HANDOVER".equals(str)) {
            return false;
        }
        if (!g()) {
            if ("android.permission.ANSWER_PHONE_CALLS".equals(str)) {
                return false;
            }
            if ("android.permission.READ_PHONE_NUMBERS".equals(str)) {
                return (l(activity, "android.permission.READ_PHONE_STATE") || activity.shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE")) ? false : true;
            }
        }
        return (l(activity, str) || activity.shouldShowRequestPermissionRationale(str)) ? false : true;
    }

    public static boolean r(Activity activity, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (q(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(String str) {
        return "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str) || "android.permission.REQUEST_INSTALL_PACKAGES".equals(str) || "android.permission.SYSTEM_ALERT_WINDOW".equals(str) || "android.permission.WRITE_SETTINGS".equals(str) || "android.permission.NOTIFICATION_SERVICE".equals(str) || "android.permission.PACKAGE_USAGE_STATS".equals(str);
    }
}