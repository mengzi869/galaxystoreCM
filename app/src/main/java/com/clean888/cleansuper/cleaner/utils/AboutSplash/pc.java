package com.clean888.cleansuper.cleaner.utils.AboutSplash;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.utils.qc;
import com.clean888.cleansuper.cleaner.utils.rc;

/* loaded from: classes2.dex */
public class pc {
    private static final ComponentName[] a = {ComponentName.unflattenFromString("com.vivo.permissionmanager/.activity.SoftPermissionDetailActivity"), ComponentName.unflattenFromString("com.iqoo.secure/.safeguard.SoftPermissionDetailActivity"), new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"), new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"), new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"), new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")};

    private static boolean a(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (g(intent, context, activityResultLauncher)) {
            return true;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        if (g(intent2, context, activityResultLauncher)) {
            return true;
        }
        Intent intent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent3.setPackage("com.miui.securitycenter");
        intent3.putExtra("extra_pkgname", context.getPackageName());
        return g(intent3, context, activityResultLauncher);
    }

    private static boolean b(Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        int i = 0;
        while (true) {
            ComponentName[] componentNameArr = a;
            if (i >= componentNameArr.length) {
                return false;
            }
            try {
                intent.setComponent(componentNameArr[i]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (g(intent, context, activityResultLauncher)) {
                return true;
            }
            i++;
        }
    }

    public static boolean c(Context context) {
        if (qc.m()) {
            return e(context);
        }
        if (qc.j()) {
            return f(context);
        }
        return true;
    }

    public static boolean d(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
//    @android.annotation.SuppressLint({com.mbridge.msdk.foundation.download.Command.HTTP_HEADER_RANGE})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(android.content.Context r10) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = r10.getPackageName()     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "content://com.vivo.permissionmanager.provider.permission/start_bg_activity"
            android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r7 = "pkgname = ?"
            java.lang.String[] r8 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L39
            r8[r0] = r2     // Catch: java.lang.Throwable -> L39
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L39
            r6 = 0
            r9 = 0
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L39
            if (r10 == 0) goto L37
            boolean r2 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L34
            java.lang.String r2 = "currentstate"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L39
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> L39
            r10.close()     // Catch: java.lang.Throwable -> L32
            goto L3e
        L32:
            r10 = move-exception
            goto L3b
        L34:
            r10.close()     // Catch: java.lang.Throwable -> L39
        L37:
            r2 = 1
            goto L3e
        L39:
            r10 = move-exception
            r2 = 1
        L3b:
            r10.printStackTrace()
        L3e:
            if (r2 != 0) goto L41
            r0 = 1
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pc.e(android.content.Context):boolean");
    }

    private static boolean f(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, 10021, Integer.valueOf(Process.myUid()), context.getPackageName())).intValue() == 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean g(Intent intent, Context context, ActivityResultLauncher<Intent> activityResultLauncher) {
        try {
            if (!d(intent, context)) {
                return false;
            }
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
                return true;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
          /*  if (md1.e()) {
                Log.e("BACQ", "启动Activity失败！！！！！！");
            }*/
            return false;
        }
    }

    public static boolean h(@NonNull Context context, @Nullable ActivityResultLauncher<Intent> activityResultLauncher) {
        if (qc.m()) {
            return b(context, activityResultLauncher);
        }
        if (qc.j()) {
            return a(context, activityResultLauncher) || rc.n(context, activityResultLauncher);
        }
        return rc.n(context, activityResultLauncher);
    }
}
