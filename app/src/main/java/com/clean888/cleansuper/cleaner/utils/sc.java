package com.clean888.cleansuper.cleaner.utils;

import android.text.TextUtils;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class sc {
    private static final Method a = d(c("android.os.SystemProperties"));

    private static String a(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String b(String str, String str2) {
        Method method = a;
        if (method != null) {
            try {
                return a(f((String) method.invoke(null, str)), str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }

    private static Class<?> c(String str) {

        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            try {
                return ClassLoader.getSystemClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused2) {
                return null;
            }

        }

    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("get", String.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    private static String f(String str) {
        String e = e(str);
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        return e;
    }
}
