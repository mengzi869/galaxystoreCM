package com.clean888.cleansuper.cleaner.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.security.MessageDigest;
import java.util.List;

/* loaded from: classes2.dex */
public class im {
    public static final String b = StringFog.decrypt("EzEIEjYDVAMhPj0uEQ0=");
    protected volatile boolean a;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(List<T> list);
    }

    public static String h(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(StringFog.decrypt("Ghdy"));
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return null;
            }
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            for (int i = 0; i < length; i++) {
                sb.append(StringFog.decrypt("Z2J1UVFCB0RfbjIlAQESVw==").charAt((digest[i] & 240) >>> 4));
                sb.append(StringFog.decrypt("Z2J1UVFCB0RfbjIlAQESVw==").charAt(digest[i] & 15));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public void i(String str, Exception exc) {
        if (af1.b()) {
            String decrypt = StringFog.decrypt("HSYpCSE1");
            StringBuilder sb = new StringBuilder();
            sb.append(StringFog.decrypt("GD0UFgAHdAEVOCF9Qg=="));
            sb.append(str);
            sb.append(StringFog.decrypt("d35qT0haHE1ZaQ=="));
            sb.append(exc != null ? exc.getMessage() : StringFog.decrypt("dz0oQggSQgAGMDY="));
            Log.d(decrypt, sb.toString());
        }
    }

    public void j(String str) {
        k(str, null);
    }

    public void k(String str, String str2) {
        String str3;
        if (af1.b()) {
            String decrypt = StringFog.decrypt("HSYpCSE1");
            StringBuilder sb = new StringBuilder();
            sb.append(StringFog.decrypt("ETopCxYfETclbXM="));
            sb.append(str);
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = StringFog.decrypt("dwgqEQJN") + str2 + StringFog.decrypt("Cg==");
            }
            sb.append(str3);
            Log.d(decrypt, sb.toString());
        }
        LiveEventBus.get(b).post(str);
    }

    public Context l() {
        return af1.c();
    }

    protected SharedPreferences m() {
        return l().getSharedPreferences(h(StringFog.decrypt("PTYjPQEWVywD")), 0);
    }

    protected <T> void n(String str, List<T> list, a<T> aVar) {
        int i;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            i = 0;
        } else {
            int size = list.size();
            i = (size / 200) + 1;
            boolean z = size % 200 == 0;
            while (i2 < i) {
                if (i2 != i - 1) {
                    List<T> subList = list.subList(200 * i2, (i2 + 1) * 200);
                    if (aVar != null) {
                        aVar.a(subList);
                    }
                } else {
                    if (z) {
                        break;
                    }
                    List<T> subList2 = list.subList(200 * i2, size);
                    if (aVar != null) {
                        aVar.a(subList2);
                    }
                }
                i2++;
            }
            i2 = size;
        }
        if (af1.b()) {
            Log.d(StringFog.decrypt("HSYpCSE1"), StringFog.decrypt("GD0UFgAHeB0UMiEzWEU=") + str + StringFog.decrypt("d7XH2YDTlpbX2Lz7+A==") + i2 + StringFog.decrypt("d7bK94PbkJfd3LbNw4DTlpbX2Lz7+A==") + 200 + StringFog.decrypt("d7bP5IzWhJXy57z7+A==") + i);
        }
    }
}
