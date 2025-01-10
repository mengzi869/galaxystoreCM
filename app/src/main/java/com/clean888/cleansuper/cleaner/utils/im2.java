package com.clean888.cleansuper.cleaner.utils;

import java.nio.charset.StandardCharsets;

import com.blankj.utilcode.util.EncodeUtils;

/* loaded from: classes4.dex */
public final class im2 {
    private static byte[] d(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (i2 >= length2) {
                i2 = 0;
            }
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i2));
            i++;
            i2++;
        }
        return bArr;
    }

    public String a(String str, String str2) {
        return new String(d(EncodeUtils.base64Decode(str), str2), StandardCharsets.UTF_8);
    }

    public String b(String str, String str2) {
        return new String(EncodeUtils.base64Encode(d(str.getBytes(StandardCharsets.UTF_8), str2)));
    }

    public boolean c(String str, String str2) {
        return str != null && (str.length() * 4) / 3 >= 65535;
    }
}
