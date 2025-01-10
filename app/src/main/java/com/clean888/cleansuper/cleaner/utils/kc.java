package com.clean888.cleansuper.cleaner.utils;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class kc {
    public static String a(long j, long j2) {
        if (j2 < 100000000000L) {
            j2 *= 1000;
        }
        if (j < 1000000000000L) {
            j *= 1000;
        }
        long j3 = (j2 - j) / 1000;
        if (j3 <= 0) {
            return SuperApplication.getContext().getString(R.string.notification_sec_ago, "1");
        }
        if (j3 < 60) {
            return SuperApplication.getContext().getString(R.string.notification_sec_ago, j3 + "");
        }
        long j4 = j3 / 60;
        if (j4 <= 60) {
            return SuperApplication.getContext().getString(R.string.notification_min_ago, j4 + "");
        }
        long j5 = j3 / 3600;
        if (j5 >= 1) {
            return SuperApplication.getContext().getString(R.string.notification_hour_ago, j5 + "");
        }
        return b(j, "yyyy-MM-dd");
    }

    public static String b(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }
}