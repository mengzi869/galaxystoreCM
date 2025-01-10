package com.clean888.cleansuper.cleaner.utils;
import com.tencent.mmkv.MMKV;
public class pj {
    public static long a(String str) {
        return MMKV.mmkvWithID("kpkkvm").getLong(str, 0L);
    }

    public static boolean b() {
        return MMKV.mmkvWithID("kpkkvm").getBoolean("is_enter_main", false);
    }

    public static void c(String str, long j) {
        MMKV.mmkvWithID("kpkkvm").putLong(str, j);
    }

    public static void d(boolean z) {
        MMKV.mmkvWithID("kpkkvm").putBoolean("is_enter_main", z);
    }
}
