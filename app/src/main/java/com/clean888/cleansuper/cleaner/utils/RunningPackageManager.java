package com.clean888.cleansuper.cleaner.utils;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.clean888.cleansuper.cleaner.bean.RunningAppBean;
import com.clean888.cleansuper.cleaner.ui.listener.ScanRunningAppListener;
import com.shenren.aps.apps.AndroidA;
import com.shenren.aps.apps.AndroidAppProcess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RunningPackageManager {

    private static final String TAG = "RunningPackageManager";

    private static RunningAppBean getRunningApps(ApplicationInfo applicationInfo, PackageManager packageManager, int i, ActivityManager activityManager) {
        RunningAppBean bean = new RunningAppBean();
        bean.setAppIcon(applicationInfo.loadIcon(packageManager));
        bean.setAppName(applicationInfo.loadLabel(packageManager).toString());
        bean.setAppPackageName(applicationInfo.packageName);
        bean.getAppMemoryInfo((long) (activityManager.getProcessMemoryInfo(new int[]{i})[0].dalvikPrivateDirty * 1024.0d * 2.0d));// 脏内存
//        L.v(TAG, "getRunningApps " + bean);
        return bean;
    }

    public static List<RunningAppBean> getBackgrdRunAppsList(Context context, r6 arg11) {
        ScanRunningAppListener listener;
        List runningAppList;
        int sdkInt = Build.VERSION.SDK_INT;
        L.v(TAG, "getBackgrdRunAppsList sdkInt=" + sdkInt);
        if (sdkInt >= 26) {
            runningAppList = getAndroid8UpList(context, arg11); // SDK >= 26
        } else if (sdkInt >= 24) {
            runningAppList = d(context, arg11); // SDK >= 24 && < 26
        } else {
            runningAppList = c(context, arg11); // SDK < 24
        }

        if (!runningAppList.isEmpty()) {
            L.e(TAG, "getBackgrdRunAppsList runningAppList =" + runningAppList.size());
            return runningAppList;
        }

        L.e(TAG, "getBackgrdRunAppsList runningAppList isEmpty");
        if (arg11 == null) {
            listener = null;
        } else {
            listener = arg11.listener;
            if (listener == null) {
                listener = null;
            }
        }

        int random = new Random().nextInt(5) + 3; //3-7
        int index = 0;
        if (listener != null) {
            L.v(TAG, "getBackgrdRunAppsList onStart");
            listener.onStart();
        }

        ActivityManager activityManager = null;
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo;

        List<RunningAppBean> list = s6.a(context, arg11);
        if (list != null) {
            try {
                activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                packageManager = context.getPackageManager();
            } catch (Exception v5) {
                v5.printStackTrace();
            }
            for (RunningAppBean bean : list) {
                // ------------ 这个if逻辑感觉没啥卵用 ------------
                if (index <= random) {
                    ++index;
                    try {
                        assert packageManager != null;
                        applicationInfo = packageManager.getApplicationInfo(bean.getAppPackageName(), 0x80);
                        getRunningApps(applicationInfo, packageManager, Binder.getCallingPid(), activityManager);
                    } catch (Throwable ignored) {
                        ignored.printStackTrace();
                    }
                }
                // ----------------------------------------------
                if (listener != null) {
                    L.v(TAG, "getBackgrdRunAppsList listener.onApp() " + bean);
                    listener.onApp(bean);
                }
            }
            if (listener != null) {
                L.e(TAG, "getBackgrdRunAppsList listener.onAppList() " + list.size());
                listener.onAppList(list);
            }
        }
        return list;

    }

    private static List<RunningAppBean> c(Context context, r6 r6Var) {
        ScanRunningAppListener listener;

        if (r6Var == null || (listener = r6Var.listener) == null) {
            listener = null;
        }
        if (listener != null) {
            listener.onStart();
        }

        ArrayList arrayList = new ArrayList();

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            if (listener != null) {
                listener.onAppList(arrayList);
            }
            return arrayList;
        }

        List<AndroidAppProcess> processList = AndroidA.a();
        if (processList == null || processList.size() == 0) {
            if (listener != null) {
                listener.onAppList(arrayList);
            }
            return arrayList;
        }


        PackageManager packageManager = context.getPackageManager();
        n32 n32Var = new n32(packageManager);
        ApplicationInfo applicationInfo;
        for (AndroidAppProcess androidAppProcess : processList) {
            if (androidAppProcess != null && (applicationInfo = n32Var.getApplicationInfo(androidAppProcess.a)) != null && !context.getPackageName().equals(applicationInfo.packageName) && (applicationInfo.flags & 1) <= 0) {
                RunningAppBean a3 = getRunningApps(applicationInfo, packageManager, androidAppProcess.b, activityManager);
                arrayList.add(a3);
                if (listener != null) {
                    listener.onApp(a3);
                }
            }
        }
        if (listener != null) {
            listener.onAppList(arrayList);
        }
        return arrayList;
    }

    private static List<RunningAppBean> d(Context context, r6 r6Var) {
        ScanRunningAppListener q6Var;
        ApplicationInfo applicationInfo;
        if (r6Var == null || (q6Var = r6Var.listener) == null) {
            q6Var = null;
        }
        int a2 = r6Var == null ? -1 : r6Var.a();
        if (q6Var != null) {
            q6Var.onStart();
        }
        ArrayList arrayList = new ArrayList();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            if (q6Var != null) {
                q6Var.onAppList(arrayList);
            }
            return arrayList;
        }
        PackageManager packageManager = context.getPackageManager();
        n32 n32Var = new n32(packageManager);
        List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
        if (runningServices != null && runningServices.size() > 0) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo != null && (applicationInfo = n32Var.getApplicationInfo(runningServiceInfo.process)) != null && !context.getPackageName().equals(applicationInfo.packageName) && (applicationInfo.flags & 1) <= 0) {
                    RunningAppBean a3 = getRunningApps(applicationInfo, packageManager, runningServiceInfo.pid, activityManager);
                    if (!arrayList.contains(a3)) {
                        arrayList.add(a3);
                        if (q6Var != null) {
                            q6Var.onApp(a3);
                        }
                        if (a2 > 0 && arrayList.size() > a2) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (q6Var != null) {
            q6Var.onAppList(arrayList);
        }
        return arrayList;
    }

    @RequiresApi(api = 26)
    private static List<RunningAppBean> getAndroid8UpList(Context arg20, r6 arg21) {
        L.e(TAG, "getAndroid8UpList start");
        ApplicationInfo v0_5 = null;
        String v3_1;
        ApplicationInfo v8;
        ScanRunningAppListener v19;
        long v10;
        ScanRunningAppListener v3 = null;
        if (arg21 == null) {
            v3 = null;
        } else {
            v3 = arg21.listener;
            if (v3 == null) {
                v3 = null;
            }
        }

        int v4 = arg21 == null ? -1 : arg21.a();
        if (v3 != null) {
            v3.onStart();
        }

        ArrayList v5 = new ArrayList();
        ActivityManager v6 = (ActivityManager) arg20.getSystemService(Context.ACTIVITY_SERVICE);
        if (v6 == null) {
            if (v3 != null) {
                L.d(TAG, "getAndroid8UpList v3.onAppList(v5) "+v5.size());
                v3.onAppList(v5);
            }
            return v5;
        }

        L.d(TAG, "getAndroid8UpList 1");
        PackageManager v7 = arg20.getPackageManager();
        UsageStatsManager v9 = (UsageStatsManager) arg20.getSystemService(Context.USAGE_STATS_SERVICE);
        if (v9 != null && v7 != null) {
            try {
                long v13 = System.currentTimeMillis();
                long v15 = -1L;
                if (arg21 == null) {
                    v19 = null;
                    v10 = 86400000L;
                } else {
                    v10 = arg21.b;
                    v19 = v3;
                    if (Long.compare(v10, 0L) <= 0) {
                        v10 = 86400000L;
                    }

                    long v2 = arg21.c;
                    if (v2 > 0L) {
                        v15 = v2;
                    }
                }

                List v0_1 = v9.queryUsageStats(0, v13 - v10, v13);
                if (v0_1 != null && v0_1.size() > 0) {
                    Iterator v2_1 = v0_1.iterator();
                    v8 = null;
                    while (true) {
                        label_60:
                        if (!v2_1.hasNext()) {
                            v3 = v19;
                            break;
                        }

                        Object v0_2 = v2_1.next();
                        UsageStats v0_3 = (UsageStats) v0_2;
                        v3_1 = v0_3.getPackageName();
                        if (v15 <= 0L) {
                            v0_5 = v7.getApplicationInfo(v3_1, 0x80);
                        }

                        long v9_1 = v0_3.getTotalTimeInForeground();
                        if (v9_1 <= v15) {
                            continue;
                        }
                        v8 = v0_5;
                        if (v8 != null && (!arg20.getPackageName().equals(v8.packageName) && (v8.flags & 1) <= 0)) {
                            RunningAppBean v0_6 = getRunningApps(v8, v7, Binder.getCallingPid(), v6);
                            v0_6.g(0.2f, 2.0f);
                            if (v5.contains(v0_6)) {
                                v3 = v19;
                                v19 = v3;
                                continue;
                            }

                            v5.add(v0_6);
                            if (v19 == null) {
                                v3 = null;
                            } else {
                                v3 = v19;
                                v3.onApp(v0_6);
                            }

                            L.e("BB2", "aaa============== 2 " + (v4 > 0) + ", " + (v5.size() > v4));
                            L.e("BB2", "aaa============== 3 :v4=" + v4 + ", v5.size()=" + v5.size());

                           /* if (v4 > 0 && v5.size() > v4) {
                                if (v3 != null) {
                                    v3.b(v5);
                                }
                            }*/
                            if (v4 > 0 && v5.size() > 0) {
                                if (v3 != null) {
                                    v3.onAppList(v5);
                                }
                            }

                            v19 = v3;

                        }
                    }
                }

                return v5;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return v5;
    }
}