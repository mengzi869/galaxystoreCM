package com.clean888.cleansuper.cleaner.utils;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class fc {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[a-zA-Z][a-zA-Z0-9_]*(\\.[a-zA-Z][a-zA-Z0-9_]*)+");
    }
}