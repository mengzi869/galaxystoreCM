package com.clean888.cleansuper.cleaner.utils;


import android.app.ActivityManager;
import android.content.Context;
import com.unity3d.player.StringFog;

/* loaded from: classes6.dex */
public class fr1 {
    public static long[] a(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(StringFog.decrypt("NjAzCxMeRQo="));
        if (activityManager == null) {
            return new long[]{0, 0};
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return new long[]{b(memoryInfo.availMem, i), b(memoryInfo.totalMem, i)};
    }

    private static long b(long j, int i) {
        return (i == 1 || i == 1024 || i == 1048576 || i == 1073741824) ? (long) ((j * 1.0d) / i) : j;
    }
}
