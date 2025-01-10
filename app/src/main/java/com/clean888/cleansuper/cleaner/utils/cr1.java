package com.clean888.cleansuper.cleaner.utils;


import android.text.TextUtils;
import com.unity3d.player.StringFog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class cr1 {
    private static volatile q91 a = null;
    private static volatile q91 b = null;
    private static boolean d = false;
    private static final Object c = new Object();
    private static List<String> e = new ArrayList();

    private static void a() {
        String[] list;
        if (a == null) {
            a = new q91();
            a.b(StringFog.decrypt("NDsiAQ4jXyc="));
            d = false;
        }
        if (d) {
            return;
        }
        List<String> b2 = xl2.b();
        e = b2;
        if (b2 != null && b2.size() > 0) {
            Iterator<String> it = e.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists() && (list = file.list()) != null && list.length > 0) {
                    for (String str : list) {
                        a.a(c(str), file.getAbsolutePath() + File.separator + str);
                    }
                }
            }
        }
        d = true;
    }

    private static String b(File file, String str) {
        String[] list;
        if (file == null || !file.exists() || TextUtils.isEmpty(str) || (list = file.list()) == null || list.length <= 0) {
            return null;
        }
        for (String str2 : list) {
            if (str.equals(c(str2))) {
                return str2;
            }
        }
        return null;
    }

    private static String c(String str) {
        if (b == null) {
            b = new q91();
        }
        String b2 = b.b(str);
        if (TextUtils.isEmpty(b2)) {
            b2 = sp2.d(str);
            if (!TextUtils.isEmpty(b2)) {
                b.a(str, b2);
            }
        }
        return b2;
    }

    public static String d(String str) {
        String[] split;
        synchronized (c) {
            a();
            if (!TextUtils.isEmpty(str)) {
                String b2 = a.b(str);
                if (!TextUtils.isEmpty(b2)) {
                    return b2;
                }
                if (str.contains(StringFog.decrypt("fA==")) && (split = str.split(StringFog.decrypt("C3g="))) != null) {
                    int length = split.length;
                    String b3 = a.b(split[0]);
                    if (!TextUtils.isEmpty(b3)) {
                        String str2 = "";
                        int i = 1;
                        for (int i2 = 1; i2 < split.length; i2++) {
                            String b4 = b(new File(b3), split[i2]);
                            if (TextUtils.isEmpty(b4)) {
                                break;
                            }
                            str2 = b3 + File.separator + b4;
                            i++;
                        }
                        if (!TextUtils.isEmpty(str2) && i >= length) {
                            a.a(str, str2);
                            return str2;
                        }
                    }
                }
            }
            return "";
        }
    }
}
