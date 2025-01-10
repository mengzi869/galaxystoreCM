package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.format.Formatter;

import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.bean.dc_packageInfo;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class gc {
    private static ConcurrentHashMap<String, dc_packageInfo> allPackageInfos = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, dc_packageInfo> systemPackageInfos = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, dc_packageInfo> personalPackageInfos = new ConcurrentHashMap<>();
    private static volatile HashSet<String> d;

    public static ConcurrentHashMap<String, dc_packageInfo> a() {
        if (personalPackageInfos.isEmpty()) {
            createMap();
        }
        return personalPackageInfos;
    }

    private static Set<String> b() {
        try {
            if ((d == null || d.isEmpty()) && (d == null || d.isEmpty())) {
                d = ic.b(SuperApplication.getContext(), "android");
            }
        } catch (Throwable unused) {
        }
        return d;
    }

    private static boolean c(dc_packageInfo dcVar) {
        try {
            Set<String> b2 = b();
            if (b2 == null) {
                return false;
            }
            Iterator<String> it = dcVar.i_signatures.iterator();
            while (it.hasNext()) {
                if (b2.contains(it.next())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private static void createMap() {
        List<PackageInfo> a2;
        ConcurrentHashMap<String, dc_packageInfo> allHashMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, dc_packageInfo> systemHashMap2 = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, dc_packageInfo> personalHashMap3 = new ConcurrentHashMap<>();
        PackageManager packageManager = SuperApplication.getContext().getPackageManager();
        if (packageManager == null || (a2 = hc_PackageManagerUtil.getPackageInfoList(SuperApplication.getContext())) == null) {
            return;
        }
        for (PackageInfo packageInfo : a2) {
            if (packageInfo != null && packageInfo.applicationInfo != null) {
                dc_packageInfo dcVar = new dc_packageInfo();
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                dcVar.a_uid = applicationInfo.uid;
                dcVar.e_label = applicationInfo.loadLabel(packageManager).toString();
                String str = packageInfo.versionName;
                if (str == null) {
                    str = "";
                }
                dcVar.c_versionName = str;
                dcVar.d_versionCode = packageInfo.versionCode;
                dcVar.b_packageName = packageInfo.packageName;
                dcVar.l_flags = applicationInfo.flags;
                dcVar.h_lastUpdateTime = packageInfo.lastUpdateTime;
                dcVar.i_signatures = new HashSet<>();
                int i = 0;
                if (packageInfo.signatures != null) {
                    int i2 = 0;
                    while (true) {
                        Signature[] signatureArr = packageInfo.signatures;
                        if (i2 >= signatureArr.length) {
                            break;
                        }
                        dcVar.i_signatures.add(ic.c(signatureArr[i2].toByteArray()));
                        i2++;
                    }
                }
                String str2 = applicationInfo.sourceDir;
                if (str2 != null) {
                    File file = new File(str2);
                    if (file.exists()) {
                        dcVar.f1759g = file.length();
                        dcVar.f_formatFileSize = Formatter.formatFileSize(SuperApplication.getContext(), dcVar.f1759g);
                    }
                    dcVar.n_sourceDir = str2;
                    if (!str2.contains("/system/app") && !str2.contains("/data/app")) {
                        i = 1;
                    }
                    dcVar.m = i;
                }
                // applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM 是一个位操作，检查应用是否有 FLAG_SYSTEM 标记。具体来说，这里的 & 是按位与操作。
                // 意味着应用 没有 设置 FLAG_SYSTEM 标记，也就是说它 不是 系统应用，而是第三方应用。
                if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                    dcVar.k = 1;
                    dcVar.j = c(dcVar);
                    personalHashMap3.put(dcVar.b_packageName, dcVar);
//                    allHashMap.put(dcVar.b_packageName, dcVar);
                } else {
//                    systemHashMap2.put(dcVar.b_packageName, dcVar);
//                    allHashMap.put(dcVar.b_packageName, dcVar);
                }
            }
        }
        personalPackageInfos = personalHashMap3;
        systemPackageInfos = systemHashMap2;
        allPackageInfos = allHashMap;
    }
}