package com.clean888.cleansuper.cleaner.receiver.utils;

import android.content.Context;
import android.os.Build;

import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fj;
import com.clean888.cleansuper.cleaner.utils.fr2;
import com.clean888.cleansuper.cleaner.utils.gi;
import com.clean888.cleansuper.cleaner.utils.pj;
import com.clean888.cleansuper.cleaner.utils.rc;

// qj
public class ScreenActionCheckUtil {

    private static final String TAG = "ScreenActionCheckUtil";

    public static void checkUserPresentAndScreenOn(Context context, String str, String str2, String str3, String str4, boolean isScreenOn, boolean z2) {
        L.e(TAG, "checkUserPresentAndScreenOn str:" + str + " str2:" + str2 + " str3:" + str3 + " str4:" + str4 + " isScreenOn:" + isScreenOn + " z2:" + z2);

        if (context == null) {
            return;
        }
        String tag = isScreenOn ? "解锁" : "Home";

        if (context.getResources().getConfiguration().orientation != 1) {
            L.d(TAG, tag + " -> orientation != 1");
            return;
        }
        if (!a_mmkv.h().j()) {
            L.d(TAG, tag + " -> 设置关闭");
            return;
        }
        if (!a_mmkv.h().o() && bj.o(context)) {
            L.d(TAG, tag + " -> 锁屏状态");
            return;
        }
        if (!bj.p()) {
            L.d(TAG, tag + " -> 没超过安装时间");
            return;
        }

        boolean m = rc.m(context);
        L.d(TAG, tag + " -> 悬浮窗权限：" + m);

        if (Build.VERSION.SDK_INT > 33) {
            if (bj.f() && !bj.d(context) && !m) {
                L.d(TAG, tag + " -> 没通知栏权限 且 没有悬浮置顶权限");
                return;
            } else if (bj.f() && !bj.d(context)) {
                L.d(TAG, tag + " -> 没通知栏权限");
                return;
            }
        }
        if (!a_mmkv.h().m() && bj.n(context)) {
            L.d(TAG, tag + " -> 应用在前台");
            return;
        }

        long currentTimeMillis = System.currentTimeMillis();
        long configTime = isScreenOn ? 30 * fr2.a : 30 * fr2.a; //     j = kj.b().j * fr2.a;
        String key = isScreenOn ? "unlock_time" : "home_key_time";
        String str6 = isScreenOn ? "6" : "5";
        L.d(TAG, tag + " -> 配置时间间隔:" + configTime + " key:" + key + " str6:" + str6);

        if (configTime <= 0) {
            L.d(TAG, tag + " -> 配置间隔:" + configTime + "<0 关闭场景");
            return;
        }

        if (!bj.checkTimes(TAG, currentTimeMillis, configTime, key, tag + " -> 间隔时间:", "trigger_failedtime_limit", str6)) {
            L.d(TAG, tag + " -> 时间间隔不满足");
            return;
        }
        if (!isScreenOn && !gi.a()) {
            L.d(TAG, tag + " -> 应用内时间间隔不满足");
            return;
        }

        L.d(TAG, tag + " -> 条件满足");
        fj.screenOn(context, str2, str3, str4, isScreenOn);

        if (z2) {
            return;
        }
        pj.c(key, currentTimeMillis);

    }
}