package com.clean888.cleansuper.cleaner.utils.AboutMe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.clean888.cleansuper.cleaner.utils.AppInfoUtil;
import com.clean888.cleansuper.cleaner.ui.activity.AgreemenUrlActivity;

public class AgreementUtil {
    public static String privacyUrl = "https://sites.google.com/view/cleanmaster2025-privacy-policy/%E9%A6%96%E9%A1%B5";
    public static String termserviceUrl = "https://sites.google.com/view/cleanmaster2025-term/%E9%A6%96%E9%A1%B5";

    public static void goPrivacyPolicy(Context context) {
        AgreemenUrlActivity.goAgreementUrl(context, privacyUrl);
    }

    public static void goTermsService(Context context) {
        AgreemenUrlActivity.goAgreementUrl(context, termserviceUrl);
    }

    public static void goEmail(Context context, String str) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.intent.action.SEND");
        int appVersionCode = AppInfoUtil.getAppVersionCode(context, packageName);
        String appVersionName = AppInfoUtil.getAppVersionName(context, packageName);
        String applicationLabel = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            if (applicationInfo != null) {
                applicationLabel = packageManager.getApplicationLabel(applicationInfo).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int currentTime = (int) (System.currentTimeMillis() / 1000);
        String model = Build.MODEL;
        String releaseVersion = Build.VERSION.RELEASE;
        String subjectStr = "[Feedback_" + applicationLabel + "_" + appVersionName + "]";
        String textStr = "\n\n[GP]-[" + applicationLabel + "]-[V" + appVersionName + "(" + appVersionCode + ")_D" + currentTime + "]-[" + model + "_" + releaseVersion + "]";
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", subjectStr);
        intent.putExtra("android.intent.extra.TEXT", textStr);
        try {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
