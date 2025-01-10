package com.clean888.cleansuper.cleaner.utils;

import android.text.TextUtils;
import com.unity3d.player.StringFog;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class sp2 {
    public static MessageDigest a;
    private static String b = StringFog.decrypt("PxIGIwQ=").replace(StringFog.decrypt("FhIG"), "") + StringFog.decrypt("IBEFIA4=").replace(StringFog.decrypt("FREF"), "");

    private static String a(String str) {
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
            return null;
        }
    }

    private static String b(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str) || (charArray = str.toCharArray()) == null) {
            return str;
        }
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && c <= 'Z') {
                charArray[i] = (char) ((c + 'a') - 65);
            }
        }
        return String.valueOf(charArray);
    }

    public static long c(String str) {
        long j = 0;
        if (str != null) {
            try {
                if (a == null) {
                    a = e();
                }
                a.update(str.getBytes());
                byte[] digest = a.digest();
                if (digest != null && digest.length == 16) {
                    long j2 = 0;
                    for (int i = 0; i < 8; i++) {
                        j2 = (j2 << 8) | (digest[i] & 255);
                    }
                    j = j2;
                }
            } catch (Exception unused) {
            }
        }
        a.reset();
        return j;
    }

    public static String d(String str) {
        if (str.startsWith(StringFog.decrypt("eA=="))) {
            str = str.substring(1);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(StringFog.decrypt("eA=="));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i])) {
                sb.append(a(b(split[i]) + b));
            }
            if (i != split.length - 1) {
                sb.append('+');
            }
        }
        return sb.toString();
    }

    public static MessageDigest e() {
        try {
            return MessageDigest.getInstance(StringFog.decrypt("Ghdy"));
        } catch (Exception unused) {
            return null;
        }
    }
}
