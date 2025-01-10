package com.clean888.cleansuper.cleaner.receiver.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import com.clean888.cleansuper.cleaner.BuildConfig;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fr2;
import com.clean888.cleansuper.cleaner.utils.pj;
import com.clean888.cleansuper.cleaner.utils.rc;
import com.clean888.cleansuper.cleaner.service.BAAS;


/* loaded from: classes2.dex */
public class mj {
    private static final String TAG = "mj";

    public static void a(Context context) {
        if (!a_mmkv.h().o() && bj.o(context)) {
            L.d(TAG, "时间场景->锁屏状态");
//            i4.a().i("timedscene").putEbKey1(0).putEbKey2(2).commit();
            return;
        }
        if (context.getResources().getConfiguration().orientation != 1) {
//            i4.a().i("timedscene").putEbKey1(0).putEbKey2(0).commit();
            return;
        }
        if (!a_mmkv.h().j()) {
            L.d(TAG, "时间场景->设置关闭");
//            i4.a().i("timedscene").putEbKey1(0).putEbKey2(1).commit();
            return;
        }
        if (!bj.p()) {
            L.d(TAG, "时间场景->没超过安装时长");
//            i4.a().i("timedscene").putEbKey1(0).putEbKey2(3).commit();
            return;
        }
        boolean r = bj.r();
        boolean m = rc.m(context);
        if (Build.VERSION.SDK_INT > 33) {
            if (r) {
                if (bj.f() && !bj.d(context) && !m) {
                    L.d(TAG, "时间场景->没通知栏权限 且 没有悬浮置顶权限");
//                    i4.a().i("timedscene").putEbKey1(0).putEbKey2(4).commit();
                    return;
                }
            } else if (bj.f() && !bj.d(context)) {
                L.d(TAG, "时间场景->没通知栏权限");
//                i4.a().i("timedscene").putEbKey1(0).putEbKey2(4).commit();
                return;
            }
        }
        if (!a_mmkv.h().m() && bj.n(context)) {
            L.d(TAG, "时间场景->应用在前台");
//            i4.a().i("timedscene").putEbKey1(0).putEbKey2(5).commit();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!bj.checkTimes(TAG, currentTimeMillis, fr2.a * 10, "scene_time", "通用间隔间隔时间:", "trigger_failedtime_limit", "7")) {
//            i4.a().i("timedscene").putEbKey1(0).putEbKey2(6).commit();
            L.d(TAG, "时间场景->通用间隔时间");
//            return;
        }
        L.d(TAG, "时间场景->条件满足");
//        i4.a().i("timedscene").putEbKey1(1).commit();
        try {
            context.startService(new Intent(context, (Class<?>) BAAS.class));
            pj.c("scene_time", currentTimeMillis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r22) {
        L.d(TAG, "mj.b");
        // TODO: 2024/11/24
        if (BuildConfig.DEBUG) {
            Toast.makeText(r22, "=== mj ===", Toast.LENGTH_SHORT).show();
        }

    }
}
