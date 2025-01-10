package com.mbridge.msdk.k_cor;

import android.content.Context;

import com.clean888.cleansuper.cleaner.utils.oa4;

public class KSManager {
    static {
        System.loadLibrary(oa4.a("GAE="));
    }

    public static native void aAccount(Context context);

    public static native void init(Context context, String str);

    public static native void sAccount(Context context);
}