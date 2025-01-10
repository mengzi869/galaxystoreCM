package com.clean888.cleansuper.cleaner.utils;


import android.os.Build;
import android.util.Log;
import com.unity3d.player.StringFog;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class p72 {
    private static final String a = StringFog.decrypt("Z2J1UVFCB0RfbhIFISEydw==");
    private static String b = StringFog.decrypt("Pj4GIyQ2cDIINRIAJzI2dzcw").replace(StringFog.decrypt("FhIGIyQ2"), "").replace(StringFog.decrypt("FhQCNSQxdSQ="), "") + StringFog.decrypt("OzoUBQAAQhcGMSIwBAA=").replace(StringFog.decrypt("BDQiFRYTUBUWIA=="), "");
    private static byte[] c;

    private static byte[] a(byte[] bArr) {
        KeyGenerator keyGenerator;
        SecureRandom secureRandom;
        try {
            keyGenerator = KeyGenerator.getInstance(StringFog.decrypt("FhYU"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            keyGenerator = null;
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                try {
                    return p41.b(bArr, 32);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SecureRandom secureRandom2 = SecureRandom.getInstance(StringFog.decrypt("BBsGUzUlfzQ="), StringFog.decrypt("FCE+EhEY"));
                    secureRandom2.setSeed(bArr);
                    keyGenerator.init(256, secureRandom2);
                    return keyGenerator.generateKey().getEncoded();
                }
            }
            try {
                if (i >= 24) {
                    secureRandom = SecureRandom.getInstance(StringFog.decrypt("BBsGUzUlfzQ="), new gw1());
                } else {
                    secureRandom = SecureRandom.getInstance(StringFog.decrypt("BBsGUzUlfzQ="), StringFog.decrypt("FCE+EhEY"));
                }
                secureRandom.setSeed(bArr);
                keyGenerator.init(256, secureRandom);
                return keyGenerator.generateKey().getEncoded();
            } catch (Exception e3) {
                e3.printStackTrace();
                SecureRandom secureRandom22 = SecureRandom.getInstance(StringFog.decrypt("BBsGUzUlfzQ="), StringFog.decrypt("FCE+EhEY"));
                secureRandom22.setSeed(bArr);
                keyGenerator.init(256, secureRandom22);
                return keyGenerator.generateKey().getEncoded();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static String b(String str) throws Exception {
        if (c == null) {
            if (af1.b()) {
                Log.d(StringFog.decrypt("BTY0CwECUB80MjYj"), b);
            }
            c = a(b.getBytes());
        }
        return new String(c(c, d(str)));
    }

    private static byte[] c(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, StringFog.decrypt("FhYU"));
        Cipher cipher = Cipher.getInstance(StringFog.decrypt("FhYU"));
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static byte[] d(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }
}
