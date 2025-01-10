package com.clean888.cleansuper.cleaner.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;

import com.clean888.cleansuper.cleaner.ui.MainActivity;

/* loaded from: classes2.dex */
public class gf {
    public static boolean a(ActivityResultLauncher<Intent> activityResultLauncher, Activity activity) {
        try {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.fromParts(MainActivity.PACKAGE, activity.getPackageName(), null));
                activityResultLauncher.launch(intent);
                return true;
            } catch (Exception unused) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                activityResultLauncher.launch(intent2);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(ActivityResultLauncher<Intent> activityResultLauncher, Context context) {
        Intent intent = new Intent();
        try {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts(MainActivity.PACKAGE, context.getPackageName(), null));
            activityResultLauncher.launch(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
