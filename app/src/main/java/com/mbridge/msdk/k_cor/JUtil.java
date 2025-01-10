package com.mbridge.msdk.k_cor;

import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import java.lang.reflect.Method;

import com.bytedance.sdk.openadsdk.job_services.MJobService;
import com.clean888.cleansuper.cleaner.utils.oa4;

/* loaded from: classes6.dex */
public class JUtil {
    public static String aM(String str, String str2, String str3) {
        return str.replace(str2, str3);
    }

    public static String bM(Context context) {
        int myPid = -1;
        ActivityManager activityManager = null;
        try {
            myPid = Process.myPid();
            activityManager = (ActivityManager) context.getSystemService(oa4.a("EgcADBMeAwo="));
        } catch (Exception unused) {
        }
        if (activityManager == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean cM(String str) {
        return str == null || TextUtils.isEmpty(str);
    }

    public static boolean dM() {
        return Build.VERSION.SDK_INT <= 22;
    }

    public static void eM(Context context) {
        int i = Build.VERSION.SDK_INT;
        JobInfo.Builder builder = new JobInfo.Builder(1001, new ComponentName(context, (Class<?>) MJobService.class));
        try {
            Class<?> cls = builder.getClass();
            String a = oa4.a("AAEANQAFHhwAHQY=");
            Class<?> cls2 = Long.TYPE;
            Method declaredMethod = cls.getDeclaredMethod(a, cls2);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(builder, 360000);
            if (i >= 24) {
                Method method = builder.getClass().getMethod(oa4.a("AAEANQAFHhwAHQY="), cls2, cls2);
                method.setAccessible(true);
                method.invoke(builder, Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS), 300000L);
            }
            Method declaredMethod2 = builder.getClass().getDeclaredMethod(oa4.a("AAEANQAFBBoXAAAB"), Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(builder, Boolean.TRUE);
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService(oa4.a("GQsWFgYfEhcRGAAX"));
            Method declaredMethod3 = jobScheduler.getClass().getDeclaredMethod(oa4.a("AAccAAECGxY="), JobInfo.class);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(jobScheduler, builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(oa4.a("GgoCCg4SVxYWBgoXRk0="), e.getMessage());
        }
    }
}
