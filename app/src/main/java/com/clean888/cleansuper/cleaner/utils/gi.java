package com.clean888.cleansuper.cleaner.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class gi implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = "LifecycleCallbacks-gi";

    private static long a;

    public static boolean a() {
        long abs = Math.abs(System.currentTimeMillis() - a);
//        long j = fr2.a;
        long j = 6000;
        boolean z = abs >= j;
//        if (md1.e()) {
            L.e(TAG, "home-应用内-间隔-" + bj.h(abs) + "--needTime:" + bj.h(j) + "--isOverTime:" + z);
//        }
        return z;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        L.e(TAG,"onActivityStopped "+activity +" si.c:"+si.c(activity, "in_app"));
        if (si.c(activity, "in_app") != null) {
            a = System.currentTimeMillis();
//            if (md1.e()) {
            L.e(TAG, "home/解锁的最后时间更新了: " + a);
//            }
        }
    }
}
