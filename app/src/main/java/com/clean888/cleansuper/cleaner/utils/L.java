package com.clean888.cleansuper.cleaner.utils;

import android.util.Log;

import com.clean888.cleansuper.cleaner.BuildConfig;

public class L {

    public static void e(String message) {
        if (!BuildConfig.DEBUG) return;
        Log.e("", message);
    }

    public static void d(String message) {
        if (!BuildConfig.DEBUG) return;
        Log.e("", message);
    }

    public static void e(String tag, String message) {
        if (!BuildConfig.DEBUG) return;
        Log.e(tag, message);
    }

    public static void d(String tag, String message) {
        if (!BuildConfig.DEBUG) return;
        Log.d(tag, message);
    }

    public static void w(String tag, String message) {
        if (!BuildConfig.DEBUG) return;
        Log.w(tag, message);
    }

    public static void v(String tag, String message) {
        if (!BuildConfig.DEBUG) return;
        Log.v(tag, message);
    }
}
