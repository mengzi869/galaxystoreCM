package com.clean888.cleansuper.cleaner.utils;


import android.content.Context;
import com.blankj.utilcode.util.AppUtils;

public class AppInfoUtil {
    public static String getAppName(Context context, String packageName) {
        return AppUtils.getAppName(packageName);
    }

    public static int getAppVersionCode(Context context, String packageName) {
        return AppUtils.getAppVersionCode(packageName);
    }

    public static String getAppVersionName(Context context, String packageName) {
        return AppUtils.getAppVersionName(packageName);
    }
}
