package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

import com.blankj.utilcode.util.Utils;

/* loaded from: classes3.dex */
public final class qb2 {
    public static int a() {
        WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService(Context.WINDOW_SERVICE);
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int b() {
        WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService(Context.WINDOW_SERVICE);
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }
}