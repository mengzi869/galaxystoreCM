package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;

import com.clean888.cleansuper.cleaner.BuildConfig;
import com.jeremyliao.liveeventbus.LiveEventBus;
//import com.unity3d.player.StringFog;

/* loaded from: classes2.dex */
public class af1 {
    private static Context a;

    public static void a(Context context) {
        a = context.getApplicationContext();
        nu2.a = context.getApplicationContext();
        LiveEventBus.config().enableLogger(false);
    }

    public static boolean b() {
        return BuildConfig.DEBUG;
//        return ce0.a(StringFog.decrypt("Ozwg"));
    }

    public static Context c() {
        return a;
    }
}
