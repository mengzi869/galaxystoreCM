package com.clean888.cleansuper.cleaner.utils;


import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.List;

public class n32 {
//    private List a;
//
//    public n32(PackageManager arg2) {
//        if(arg2 != null) {
//            try {
//                this.a = arg2.getInstalledApplications(0x2000);
//            }
//            catch(Exception v2) {
//                v2.printStackTrace();
//            }
//
//            return;
//        }
//    }
//
//    public ApplicationInfo a(String arg5) {
//        if(arg5 != null) {
//            List v1 = this.a;
//            if(v1 != null) {
//                for(Object v2: v1) {
//                    ApplicationInfo v2_1 = (ApplicationInfo)v2;
//                    if(v2_1 == null || !arg5.equals(v2_1.processName)) {
//                        continue;
//                    }
//
//                    return v2_1;
//                }
//            }
//        }
//
//        return null;
//    }


    private List<ApplicationInfo> applicationInfoList;

    public n32(PackageManager packageManager) {
        if (packageManager != null) {
            try {
                this.applicationInfoList = packageManager.getInstalledApplications(8192);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ApplicationInfo getApplicationInfo(String str) {
        List<ApplicationInfo> list;
        if (str != null && (list = this.applicationInfoList) != null) {
            for (ApplicationInfo applicationInfo : list) {
                if (applicationInfo != null && str.equals(applicationInfo.processName)) {
                    return applicationInfo;
                }
            }
        }
        return null;
    }

}

