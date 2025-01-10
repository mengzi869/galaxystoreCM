package com.clean888.cleansuper.cleaner.utils;

//import com.unity3d.player.StringFog;
import java.io.File;
import java.util.Locale;

/* loaded from: classes2.dex */
public class mr0 {
    private static String[] a = {StringFog.decrypt("FQ=="), StringFog.decrypt("HBE="), StringFog.decrypt("GhE="), StringFog.decrypt("EBE="), StringFog.decrypt("AxE=")};

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, String str3);
    }

    public static String a(float f, int i) {
        if (i <= 0) {
            i = 0;
        }
        int i2 = 0;
        while (f > 1024.0f && i2 < 4) {
            f /= 1024.0f;
            i2++;
        }
        return String.format(Locale.getDefault(), StringFog.decrypt("cn0=") + i + StringFog.decrypt("MXNiEQ=="), Float.valueOf(f), a[i2]);
    }

    public static void b(float f, int i, a aVar) {
        if (f <= 0.0f) {
            f = 0.0f;
        }
        int i2 = 0;
        while (f > 1024.0f && i2 < 4) {
            f /= 1024.0f;
            i2++;
        }
        String format = String.format(Locale.getDefault(), StringFog.decrypt("cn0=") + i + StringFog.decrypt("MQ=="), Float.valueOf(f));
        String format2 = String.format(StringFog.decrypt("ciA="), a[i2]);
        String str = format + format2;
        if (aVar != null) {
            aVar.a(str, format, format2);
        }
    }

    private static long c(File file, int i, int i2) {
        long j = 0;
        if (file != null && file.exists()) {
            if (i2 > 0 && i > i2) {
                return 0L;
            }
            if (file.isFile()) {
                return file.length();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                try {
                    if (file2.isFile()) {
                        j += file2.length();
                    } else {
                        int i3 = i + 1;
                        try {
                            j += c(file2, i, i2);
                            i = i3;
                        } catch (Exception e) {
                            e = e;
                            i = i3;
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
//                    e = e2;
                }
            }
        }
        return j;
    }

    public static long d(File file) {
        return e(file, 5);
    }

    public static long e(File file, int i) {
        return c(file, 0, i);
    }
}
