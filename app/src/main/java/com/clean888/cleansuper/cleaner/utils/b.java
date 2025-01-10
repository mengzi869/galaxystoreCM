package com.clean888.cleansuper.cleaner.utils;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;

import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.activity.ZZY;

/* loaded from: classes2.dex */
public class b {
    public static void a(Context context) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        if (Build.VERSION.SDK_INT >= 29) {
            intent.setData(Uri.fromParts(MainActivity.PACKAGE, context.getPackageName(), null));
        }
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.android.settings", "com.android.settings.SubSettings"));
            try {
                context.startActivity(intent2);
            } catch (Throwable th2) {
                th2.printStackTrace();
                try {
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$SecuritySettingsActivity"));
                    context.startActivity(intent3);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
        fi.a();
        ZZY.n(context, new ZZY.b() { // from class: kf
            @Override // bfj.ckdk.wazpqdu.cjzk.mhiggthrrh.ZZY.b
            public final boolean a() {
                return b.b();
            }
        });
    }

    public static boolean b() {
        int checkOpNoThrow;
        Context a = SuperApplication.getContext();
        ApplicationInfo applicationInfo = a.getApplicationInfo();
        AppOpsManager appOpsManager = (AppOpsManager) a.getSystemService("appops");
        if (Build.VERSION.SDK_INT >= 29) {
            checkOpNoThrow = appOpsManager.unsafeCheckOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName);
        } else {
            checkOpNoThrow = appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName);
        }
        return checkOpNoThrow == 3 ? a.checkCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS") == 0 : checkOpNoThrow == 0;
    }
}
