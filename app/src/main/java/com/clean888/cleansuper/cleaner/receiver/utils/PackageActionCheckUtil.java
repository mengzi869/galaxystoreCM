package com.clean888.cleansuper.cleaner.receiver.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fr2;
import com.clean888.cleansuper.cleaner.utils.pj;
import com.clean888.cleansuper.cleaner.utils.rc;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.service.PackageActionService;


// ni
/* loaded from: classes2.dex */
public class PackageActionCheckUtil {
    private static final String TAG = "PackageActionCheckUtil";

    public static void checkInstallApp(Context context, Intent intent) {
        L.e(TAG, "checkInstallApp");
        if (check(context, true)) {
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) PackageActionService.class);
        intent2.putExtra(MainActivity.IS_INSTALL, true);
        intent2.putExtra(MainActivity.PACKAGE, intent.getData().getSchemeSpecificPart());
        try {
            context.startService(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkUninstallApp(Context context, Intent intent) {
        L.e(TAG, "checkUninstallApp");
        if (check(context, false)) {
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) PackageActionService.class);
        intent2.putExtra(MainActivity.IS_INSTALL, false);
        intent2.putExtra(MainActivity.PACKAGE, intent.getDataString());
        try {
            context.startService(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean check(Context context, boolean isInstall) {
        String tag = isInstall ? "应用安装" : "应用卸载";

        if (isInstall) {
            if (!a_mmkv.h().n()) {
                L.d(TAG, tag + " -> 设置关闭");
                return true;
            }
        } else {
            if (!a_mmkv.h().v()) {
                L.d(TAG, tag + " -> 设置关闭");
                return true;
            }
        }
        if (context.getResources().getConfiguration().orientation != 1) {
            L.d(TAG, tag + " -> orientation != 1");
            return true;
        }

        if (!a_mmkv.h().o() && bj.o(context)) {
            L.d(TAG, tag + " -> 锁屏状态");
            return true;
        }

        if (!bj.p()) {
            L.d(TAG, tag + " -> 没超过安装时长");
//            return true; 先不验证
        }


        boolean m = rc.m(context); // 是否有悬浮窗权限
        L.d(TAG, tag + " -> 悬浮窗权限：" + m);
        if (Build.VERSION.SDK_INT > 33) {
            if (bj.f() && !bj.d(context) && !m) {
                L.d(TAG, tag + " -> 没通知栏权限 且 没有悬浮置顶权限");
                return true;
            } else if (bj.f() && !bj.d(context)) {
                L.d(TAG, tag + " -> 没通知栏权限");
                return true;
            }
        }

        long currentTimeMillis = System.currentTimeMillis();
        if (isInstall) {
            if (!bj.checkTimes(TAG, currentTimeMillis, fr2.a * 3, "install_time", "安装应用间隔时间:", "trigger_failedtime_limit", "1")) {
                L.d(TAG, tag + " -> 时间间隔不满足");
//                return true;
            }
            pj.c("install_time", currentTimeMillis);
        } else {
            if (!bj.checkTimes(TAG, currentTimeMillis, fr2.a * 3, "uninstall_time", "卸载应用间隔时间:", "trigger_failedtime_limit", "2")) {
                L.d(TAG, tag + " -> 时间间隔不满足");
//                return true;
            }
            pj.c("uninstall_time", currentTimeMillis);
        }

        L.d(TAG, tag + " -> 条件满足 执行跳转");

        return false;
    }


}