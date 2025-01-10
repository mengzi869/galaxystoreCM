package com.clean888.cleansuper.cleaner.utils;

/* loaded from: classes6.dex */
public final class StringFog {
    private static final im2 IMPL = new im2();

    public static String decrypt(String str) {
        return IMPL.a(str, "WSGbew1sg");
    }

    public static String encrypt(String str) {
        return IMPL.b(str, "WSGbew1sg");
    }

    public static boolean overflow(String str) {
        return IMPL.c(str, "WSGbew1sg");
    }
}
