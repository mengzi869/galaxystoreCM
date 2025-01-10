package com.nb;


import android.content.Context;

/* loaded from: classes6.dex */
public class Hba {
    static {
        try {
            System.loadLibrary("tomato");
        } catch (Exception unused) {
        }
    }

    public static void a(Context context) {
        cvd(context);
    }

    public static native void cvd(Context context);
}
