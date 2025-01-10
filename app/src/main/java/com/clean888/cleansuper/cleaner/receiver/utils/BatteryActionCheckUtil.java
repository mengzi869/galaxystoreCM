package com.clean888.cleansuper.cleaner.receiver.utils;

import android.content.Context;
import android.os.Build;

import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fj;
import com.clean888.cleansuper.cleaner.utils.rc;

// lj
public class BatteryActionCheckUtil {

    private static final String TAG = "BatteryActionCheckUtil";

    public static void checkPowerConnected(Context context) {
        L.e(TAG, "checkPowerConnected");
        if (context.getResources().getConfiguration().orientation != 1) {
            L.d(TAG, "充电 -> orientation != 1");
            return;
        }
        if (!a_mmkv.h().k()) {
            L.d(TAG, "充电 -> 设置关闭");
            return;
        }
        if (!a_mmkv.h().o() && bj.o(context)) {
            L.d(TAG, "充电 -> 锁屏状态");
            return;
        }
        if (!bj.p()) {
            L.d(TAG, "充电 -> 没超过安装时间");
//            return;
        }

        boolean m = rc.m(context);
        L.d(TAG, "充电 -> 悬浮窗权限：" + m);
        if (Build.VERSION.SDK_INT > 33) {
            if (bj.f() && !bj.d(context) && !m) {
                L.d(TAG, "充电 -> 没通知栏权限 且 没有悬浮置顶权限");
                return;
            } else if (bj.f() && !bj.d(context)) {
                L.d(TAG, "充电 -> 没通知栏权限");
                return;
            }
        }
        L.d(TAG, "充电 -> 条件满足");
        fj.powerConnected(context);
    }
}
