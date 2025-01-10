package com.clean888.cleansuper.cleaner.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.view.WindowManager;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.RequiresApi;

import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class rc {
    private static boolean a(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        if (q(intent, context, activityResultLauncher)) {
            return true;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        return q(intent, context, activityResultLauncher);
    }

    private static boolean b(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        try {
            Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            q(intent, context, activityResultLauncher);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean c(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.setClassName("com.yulong.android.seccenter", "com.yulong.android.seccenter.dataprotection.ui.AppListActivity");
        return q(intent, context, activityResultLauncher);
    }

    private static boolean d(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        try {
            try {
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
                if (!q(intent, context, activityResultLauncher)) {
                    intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                    context.startActivity(intent);
                }
                return true;
            } catch (ActivityNotFoundException e) {
                try {
                    Intent intent2 = new Intent();
                    intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
                    context.startActivity(intent2);
                    return true;
                } catch (Exception unused) {
//                    if (md1.e()) {
//                        Log.e("BACS", "Huawei跳转失败2" + e);
//                    }
                    return n(context, activityResultLauncher);
                }
            } catch (SecurityException unused2) {
                Intent intent3 = new Intent();
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
                context.startActivity(intent3);
                return true;
            } catch (Exception unused3) {
                return n(context, activityResultLauncher);
            }
        } catch (Exception e2) {
//            if (md1.e()) {
//                Log.e("BACS", "Huawei跳转失败1" + e2);
//            }
            return n(context, activityResultLauncher);
        }
    }

    private static boolean e(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.setClassName("com.lenovo.safecenter", "com.lenovo.safecenter.MainTab.LeSafeMainActivity");
        return q(intent, context, activityResultLauncher);
    }

    private static boolean f(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.setClassName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AppActivity");
        return q(intent, context, activityResultLauncher);
    }

    private static boolean g(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.setAction("miui.intent.action.APP_PERM_EDITOR");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return q(intent, context, activityResultLauncher);
    }

    private static boolean h(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.putExtra(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME, context.getPackageName());
        intent.setAction("com.oppo.safe");
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (!q(intent, context, activityResultLauncher)) {
            intent.setAction("com.color.safecenter");
            intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
            if (!q(intent, context, activityResultLauncher)) {
                intent.setAction("com.coloros.safecenter");
                intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
                return q(intent, context, activityResultLauncher);
            }
        }
        return true;
    }

    private static boolean i(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent("com.smartisanos.security.action.SWITCHED_PERMISSIONS_NEW");
        intent.setClassName("com.smartisanos.security", "com.smartisanos.security.SwitchedPermissions");
        intent.putExtra("index", 17);
        if (q(intent, context, activityResultLauncher)) {
            return true;
        }
        Intent intent2 = new Intent("com.smartisanos.security.action.SWITCHED_PERMISSIONS");
        intent2.setClassName("com.smartisanos.security", "com.smartisanos.security.SwitchedPermissions");
        intent2.putExtra("permission", new String[]{"android.permission.SYSTEM_ALERT_WINDOW"});
        return q(intent2, context, activityResultLauncher);
    }

    private static boolean j(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        intent.setAction("com.vivo.permissionmanager");
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return q(intent, context, activityResultLauncher);
        }
        intent.setAction("com.iqoo.secure");
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return q(intent, context, activityResultLauncher);
        }
        intent.setAction("com.iqoo.secure");
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return q(intent, context, activityResultLauncher);
        }
        return q(intent, context, activityResultLauncher);
    }

    private static boolean k(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.setAction("com.zte.heartyservice.intent.action.startActivity.PERMISSION_SCANNER");
        return q(intent, context, activityResultLauncher);
    }

    @RequiresApi(api = 19)
    private static boolean l(Context context) {
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService == null) {
                return false;
            }
            Class<?> cls = systemService.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOp", cls2, cls2, String.class);
            if (method == null) {
                return false;
            }
            if (((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName())).intValue() != 0) {
                if (qc.e()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean m(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return l(context);
    }

    public static boolean n(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(MainActivity.PACKAGE, context.getPackageName(), null));
        return q(intent, context, activityResultLauncher);
    }

    public static WindowManager.LayoutParams o(Context context, boolean z, boolean z2) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            layoutParams.type = 2038;
            if (i >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
        } else if (i < 23) {
            layoutParams.type = 2005;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.packageName = context.getApplicationContext().getPackageName();
        int i2 = layoutParams.flags | 16777216;
        layoutParams.flags = i2;
        if (z2) {
            layoutParams.flags = i2 | 40;
        } else {
            layoutParams.flags = i2 | 24;
        }
        if (z) {
            layoutParams.flags |= 66816;
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.flags |= 65792;
            layoutParams.width = -2;
            layoutParams.height = -2;
        }
        layoutParams.format = -2;
        return layoutParams;
    }

    public static boolean p(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static boolean q(Intent intent, Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        try {
            if (!p(intent, context)) {
                return false;
            }
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
                return true;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
//            if (md1.e()) {
//                Log.e("BACS", "启动Activity失败！！！！！！");
//            }
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0086, code lost:

        if (r0.equals("LENOVO") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean r(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.Nullable androidx.activity.result.ActivityResultLauncher<android.content.Intent> r6) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rc.r(android.content.Context, androidx.activity.result.ActivityResultLauncher):boolean");
    }
}
