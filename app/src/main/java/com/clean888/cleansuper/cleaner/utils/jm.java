package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;

import java.security.MessageDigest;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class jm<T> extends lm<T> {
    protected static String o = StringFog.decrypt("BDAmDC8CXxg=");
    protected List<T> m;
    protected a<T> n;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void c();

        void d(b91 b91Var);

        void e(T t);
    }

    public jm(Context context, a<T> aVar) {
        super(context);
        this.n = aVar;
    }

    public static String t(String str) {
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

    @Override // defpackage.fn
    protected void b() {
        a<T> aVar = this.n;
        if (aVar != null) {
            aVar.c();
        }
        this.n = null;
    }

    @Override // defpackage.fn
    protected void c() {
        this.n = null;
    }

    protected boolean u() {
        return xl2.c(this.a);
    }
}