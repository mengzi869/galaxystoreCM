package com.clean888.cleansuper.cleaner.utils;

import android.annotation.TargetApi;

import androidx.core.app.NotificationManagerCompat;

import com.clean888.cleansuper.cleaner.SuperApplication;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class jc {
    public static void a() {
        try {
            Object systemService = SuperApplication.getContext().getSystemService("statusbar");
            Class<?> cls = Class.forName("android.app.StatusBarManager");
            if (systemService != null) {
                Method method = cls.getMethod("collapsePanels", new Class[0]);
                method.setAccessible(true);
                method.invoke(systemService, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(18)
    public static boolean b() {
        try {
            return NotificationManagerCompat.getEnabledListenerPackages(SuperApplication.getContext()).contains(SuperApplication.getContext().getPackageName());
        } catch (Throwable unused) {
            return false;
        }
    }
}