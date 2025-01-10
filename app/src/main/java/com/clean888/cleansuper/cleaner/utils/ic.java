package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;

//import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;

import java.util.HashSet;

/* loaded from: classes2.dex */
public class ic {
    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toLowerCase();
    }

    public static HashSet<String> b(Context context, String str) {
        HashSet<String> hashSet = new HashSet<>();
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo != null) {
                    int i = 0;
                    while (true) {
                        Signature[] signatureArr = packageInfo.signatures;
                        if (i >= signatureArr.length) {
                            break;
                        }
                        String c = c(signatureArr[i].toByteArray());
                        if (!TextUtils.isEmpty(c)) {
                            hashSet.add(c);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashSet;
    }

    public static String c(byte[] bArr) {
        /*try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509).generateCertificate(new ByteArrayInputStream(bArr));
//            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(x509Certificate.getEncoded());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (CertificateException e2) {
            e2.printStackTrace();
            return null;
        }*/

        return null;
    }
}