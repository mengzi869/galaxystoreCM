package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class hc {
    @SuppressLint({"NewApi"})
    public static synchronized List<PackageInfo> a(Context context) {
        synchronized (hc.class) {
            if (context == null) {
                return null;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<PackageInfo> linkedList = new LinkedList<>();
            int i = 0;
            try {
                linkedList = packageManager.getInstalledPackages(64);
                i = linkedList.size();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (i <= 10) {
                List<PackageInfo> c = c(packageManager);
                if (c.size() > i) {
                    linkedList = c;
                }
            }
            return linkedList;
        }
    }

    public static Bitmap b(Context context, String str) {
        Bitmap bitmap = null;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Drawable applicationIcon = context.getPackageManager().getApplicationIcon(str);
            int intrinsicWidth = applicationIcon.getIntrinsicWidth();
            int intrinsicHeight = applicationIcon.getIntrinsicHeight();
            bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, applicationIcon.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            applicationIcon.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            applicationIcon.draw(new Canvas(bitmap));
            return bitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:

        if (r2 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static List<PackageInfo> c(PackageManager r6) {
        BufferedReader v3;
        Process v2 = null;
        LinkedList v0 = new LinkedList();
        try {
            v2 = Runtime.getRuntime().exec("pm list packages");
            v3 = new BufferedReader(new InputStreamReader(v2.getInputStream()));
            while(true) {
                String v1 = v3.readLine();
                if(v1 == null) {
                    break;
                }

                v0.add(r6.getPackageInfo(v1.substring(v1.indexOf(58) + 1), 0x40));
            }

            v2.waitFor();
        }
        catch(Throwable v6) {
            try {
                v6.printStackTrace();
            }
            catch(Throwable v6_1) {
                if(v2 != null) {
                    v2.destroy();
                }

                throw v6_1;
            }

            if(v2 != null) {
                v2.destroy();
                return v0;
            }

            return v0;
        }

        try {
            v3.close();
        }
        catch(IOException v6_2) {
            v6_2.printStackTrace();
            v2.destroy();
            return v0;
        }

        v2.destroy();
        return v0;
    }
}