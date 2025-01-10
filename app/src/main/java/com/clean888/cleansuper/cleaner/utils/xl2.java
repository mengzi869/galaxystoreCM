package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class xl2 {
    private static wl2 a;
    private static final Object b = new Object();

    private static wl2 a() {
        wl2 wl2Var;
        synchronized (b) {
            if (a == null) {
                a = new wl2();
            }
            wl2Var = a;
        }
        return wl2Var;
    }

    public static List<String> b() {
        List<String> a2 = a().a();
        if (a2 != null) {
            return a2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Environment.getExternalStorageDirectory().getPath());
        return arrayList;
    }

    public static boolean c(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return Environment.isExternalStorageManager();
        }
        if (i >= 23) {
            return context.checkSelfPermission(StringFog.decrypt("Nj0jEAoeVV0XMiEqCxYEWBwJeQECIyEodCszEgEJIykoYicoBRIAJw==")) == 0 && context.checkSelfPermission(StringFog.decrypt("Nj0jEAoeVV0XMiEqCxYEWBwJeQQVKzEybjY/AxYVLCQ7biAzGAEGJSA=")) == 0;
        }
        return true;
    }
}
