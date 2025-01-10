package com.clean888.cleansuper.cleaner.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.activity.AgreemenUrlActivity;
import com.clean888.cleansuper.cleaner.ui.activity.CpuCoolerActivity;
import com.clean888.cleansuper.cleaner.ui.activity.BatterySaverActivity;
import com.clean888.cleansuper.cleaner.ui.activity.BAAD;
import com.clean888.cleansuper.cleaner.ui.activity.BAAE;
import com.clean888.cleansuper.cleaner.ui.activity.BAAM;
import com.clean888.cleansuper.cleaner.ui.activity.ZZT;
import com.clean888.cleansuper.cleaner.ui.activity.LargeFileCleanActivity;
import com.clean888.cleansuper.cleaner.ui.activity.PhoneBoostActivity;
import com.clean888.cleansuper.cleaner.ui.activity.SettingsActivity;
import com.clean888.cleansuper.cleaner.ui.activity.AboutUsActivity;
import com.clean888.cleansuper.cleaner.ui.activity.ZZY;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAJ;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAK;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAL;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAP;
import com.clean888.cleansuper.cleaner.ui.dialog.ZZA;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class fi implements Application.ActivityLifecycleCallbacks, Runnable {

    private static final String TAG = "LifecycleCallbacks-fi-后台回收";
    static fi d;
    private int a = 0;
    private List<WeakReference<Activity>> b = new ArrayList();
    private boolean c;

    public fi() {
        d = this;
    }

    public static void a() {
        if (d != null) {
            L.e(TAG, "disableDestroy 禁用回收机制");
            ThreadUtils.getMainHandler().removeCallbacks(d);
            d.c = true;
        }
    }

    private boolean b(Activity activity) {
        return (activity instanceof MainActivity) || (activity instanceof ZZT) || (activity instanceof LargeFileCleanActivity) || (activity instanceof PhoneBoostActivity) || (activity instanceof SettingsActivity) || (activity instanceof AboutUsActivity) || (activity instanceof AgreemenUrlActivity) || (activity instanceof CpuCoolerActivity) || (activity instanceof BatterySaverActivity) || (activity instanceof BAAD);
    }

    private boolean c(Activity activity) {
        return (activity instanceof BAAJ) || (activity instanceof BAAK) || (activity instanceof ZZA) || (activity instanceof BAAL) || (activity instanceof BAAP) || (activity instanceof BAAE) || (activity instanceof ZZY) || (activity instanceof BAAM);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        L.e(TAG, "onActivityDestroyed 移除：" + activity.getClass());
        if (b(activity)) {
//            for (WeakReference weakReference : new ArrayList(this.b)) {
//                if (activity == ((Activity) weakReference.get())) {
//                    this.b.remove(weakReference);
//                }
//            }
            Iterator<WeakReference<Activity>> iterator = this.b.iterator();
            while (iterator.hasNext()) {
                if (activity == iterator.next().get()) {
                    iterator.remove();
                }
            }
        }
        printList();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (c(activity)) {
            return;
        }
        this.c = false;
        L.e(TAG, "onActivityResumed：" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (c(activity)) {
            return;
        }
        if (b(activity)) {
            this.b.add(new WeakReference<>(activity));
        }
        if (this.a < 0) {
            this.a = 0;
        }
        this.a++;
        L.e(TAG, "onActivityStarted 创建添加：" + activity.getClass());
        L.e(TAG, "取消计时");
        printList();
        ThreadUtils.getMainHandler().removeCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (c(activity)) {
            return;
        }
        this.a--;
        L.e(TAG, "onActivityStopped 个数：" + this.a);
        if (this.a == 0) {
            if (this.c) {
                L.e(TAG, "禁用状态：");
                return;
            }
//            sf a = sf.a();
//            if (a == null) {
//                a = new sf();
//            }
//            L.e(TAG, a.k + "秒后清除全部");
//            sq2.m(this, ((long) a.k) * 1000);
            L.e(TAG, 30 + "秒后清除全部");
            ThreadUtils.runOnUiThreadDelayed(this,((long) 30) * 1000);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c) {
            return;
        }
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (activity != null && !activity.isFinishing()) {
                L.d(TAG,"finish "+activity.getClass());
                activity.finish();
            }
        }
    }

    private void printList() {
        L.e(TAG, "个数：" + this.a + " / " + this.b.size());
        Iterator<WeakReference<Activity>> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next().get();
            L.d(TAG, "      "+activity.getClass().toString());
        }
    }
}
