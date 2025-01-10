package com.clean888.cleansuper.cleaner.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class qc {
    public static String a() {
        return j() ? "MIUI" : f() ? "EMUI" : m() ? "VIVO" : k() ? "OPPO" : i() ? "FLYME" : l() ? "SMARTISAN" : c() ? "QIKU" : h() ? "LETV" : g() ? "LENOVO" : n() ? "ZTE" : d() ? "COOLPAD" : "UNKNOWN";
    }

    private static String b(String str) {
        return sc.b(str, null);
    }

    public static boolean c() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains("QIKU");
    }

    public static boolean d() {
        String str = Build.MODEL;
        String str2 = Build.FINGERPRINT;
        return (!TextUtils.isEmpty(str) && str.toLowerCase().contains("COOLPAD")) || (!TextUtils.isEmpty(str2) && str2.toLowerCase().contains("COOLPAD"));
    }

    public static boolean e() {
        return j() || f() || i() || c() || k() || m() || h() || n() || g() || d();
    }

    public static boolean f() {
        return !TextUtils.isEmpty(b("ro.build.version.emui"));
    }

    public static boolean g() {
        return !TextUtils.isEmpty(b("ro.lenovo.lvp.version"));
    }

    public static boolean h() {
        return !TextUtils.isEmpty(b("ro.letv.eui"));
    }

    public static boolean i() {
        String b = b("ro.build.display.id");
        return !TextUtils.isEmpty(b) && b.toUpperCase().contains("FLYME");
    }

    public static boolean j() {
        return !TextUtils.isEmpty(b("ro.miui.ui.version.name"));
    }

    public static boolean k() {
        return !TextUtils.isEmpty(b("ro.build.version.opporom"));
    }

    public static boolean l() {
        return !TextUtils.isEmpty(b("ro.smartisan.version"));
    }

    public static boolean m() {
        return !TextUtils.isEmpty(b("ro.vivo.os.version"));
    }

    public static boolean n() {
        String str = Build.MANUFACTURER;
        String str2 = Build.FINGERPRINT;
        return (!TextUtils.isEmpty(str) && (str2.toLowerCase().contains("NUBIA") || str2.toLowerCase().contains("ZTE"))) || (!TextUtils.isEmpty(str2) && (str2.toLowerCase().contains("NUBIA") || str2.toLowerCase().contains("ZTE")));
    }
}
