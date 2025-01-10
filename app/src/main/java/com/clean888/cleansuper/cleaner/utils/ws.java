package com.clean888.cleansuper.cleaner.utils;

import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class ws {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String b = StringFog.decrypt("PwAAMSIkUA==").replace(StringFog.decrypt("BBQUJTY="), "");
    private static final String c = StringFog.decrypt("IBsPKi0/eRg=").replace(StringFog.decrypt("HxsPKi0/"), "");

    public static String a(MessageDigest messageDigest, String str) {
        messageDigest.update((b + b(str) + c).getBytes());
        String c2 = c(messageDigest.digest());
        messageDigest.reset();
        return c2;
    }

    private static String b(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str) || (charArray = str.toCharArray()) == null) {
            return str;
        }
        for (int i = 0; i < charArray.length; i++) {
            char c2 = charArray[i];
            if ('A' <= c2 && c2 <= 'Z') {
                charArray[i] = (char) ((c2 + 'a') - 65);
            }
        }
        return String.valueOf(charArray);
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length == 0) {
            return "";
        }
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(bArr[i] & 240) >>> 4];
            cArr[i2 + 1] = cArr2[bArr[i] & 15];
        }
        return new String(cArr);
    }

    public static MessageDigest d() {
        try {
            return MessageDigest.getInstance(StringFog.decrypt("Ghdy"));
        } catch (Exception unused) {
            return null;
        }
    }
}
