package com.clean888.cleansuper.cleaner.utils;

import android.app.PendingIntent;
import android.os.Build;

public class y41 {
    public static int a(int i) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.FLAG_MUTABLE;
        }
        return i;
    }
}

//    PendingIntent.FLAG_ONE_SHOT: 表示该 PendingIntent 只能使用一次，触发后会被自动取消。
//    PendingIntent.FLAG_CANCEL_CURRENT: 表示如果已经存在相同的 PendingIntent，则取消当前的 PendingIntent，并替换为新的。
//    PendingIntent.FLAG_UPDATE_CURRENT: 表示如果已经存在相同的 PendingIntent，则保留之前的 PendingIntent，并更新它。
//    134217728 ==> FLAG_UPDATE_CURRENT
//    167772160 ==> FLAG_ALLOW_UNSAFE_IMPLICIT_INTENT