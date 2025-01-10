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
public class hc_PackageManagerUtil {

    private static final String TAG = "hc_PackageManagerUtil";

    @SuppressLint({"NewApi"})
    public static synchronized List<PackageInfo> getPackageInfoList(Context context) {
        synchronized (hc_PackageManagerUtil.class) {
            if (context == null) {
                L.d(TAG, "getPackageInfoList context == null return");
                return null;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                L.d(TAG, "getPackageInfoList packageManager == null return");
                return null;
            }

            List<PackageInfo> linkedList = new LinkedList<>();
            linkedList = commonMethod(packageManager);
            if (linkedList.size() <= 10) {
                L.d(TAG, "getPackageInfoList 准备进入 adbMethod");
                List<PackageInfo> fromAdbList = adbMethod(packageManager);
                if (fromAdbList.size() > linkedList.size()) {
                    linkedList = fromAdbList;
                }
            }
            L.e(TAG, "getPackageInfoList SIZE = "+linkedList.size());
            return linkedList;
        }
    }


    public static List<PackageInfo> commonMethod(PackageManager packageManager) {
        L.e(TAG, "commonMethod start");
        List<PackageInfo> linkedList = new LinkedList<>();
        try {
            linkedList = packageManager.getInstalledPackages(PackageManager.GET_SIGNATURES);// GET_META_DATA 128，0x00000040 64
        } catch (Throwable th) {
            L.e(TAG, "commonMethod ERROR:" + th.getMessage());
            th.printStackTrace();
        }
        L.e(TAG, "commonMethod SIZE = "+linkedList.size());
        return linkedList;
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


    private static List<PackageInfo> adbMethod(PackageManager r6) {
        L.e(TAG, "adbMethod start");
        List<PackageInfo> linkedList = new LinkedList<>();
        String str = null;  // 存储每行命令输出的字符串
        Process process = null;
        try {
            Runtime rt = Runtime.getRuntime();// 获取系统的Runtime实例
            process = rt.exec("pm list packages");// 执行命令
            InputStreamReader isr = new InputStreamReader(process.getInputStream());// 通过BufferedReader读取命令的输出
            BufferedReader br = new BufferedReader(isr);
            // 持续读取每一行的输出
            while ((str = br.readLine()) != null) {
                // 每一行的格式是：package:<包名>
                int packageIndex = str.indexOf(":") + 1;  // 找到包名的起始位置
                str = str.substring(packageIndex);  // 获取包名
                try {
                    PackageInfo packageInfo = r6.getPackageInfo(str, PackageManager.GET_META_DATA);
                    linkedList.add(packageInfo);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            // 等待命令执行完成
            process.waitFor();
            // 关闭资源
            br.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            L.e(TAG, "adbMethod ERROR:"+e.getMessage() );
        } finally {
            // 销毁进程
            if (process != null) {
                process.destroy();
            }
        }
        L.e(TAG, "adbMethod SIZE = " + linkedList.size());
        return linkedList;
    }
}