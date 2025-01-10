package com.clean888.cleansuper.cleaner.utils;


import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.mmkv.MMKV;

/* loaded from: classes2.dex */
public class ag {
    public static void a(int i) {
        MMKV.mmkvWithID("musre_mm").putInt(c(i), b(i) + 1);
        LiveEventBus.get("ModuleUsedRecord_EVENT_USD_CHANGE", Integer.class).post(Integer.valueOf(i));
    }

    public static int b(int i) {
        return MMKV.mmkvWithID("musre_mm").getInt(c(i), 0);
    }

    private static String c(int i) {
        return "u_" + i;
    }
}