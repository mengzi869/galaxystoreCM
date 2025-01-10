package com.clean888.cleansuper.cleaner.utils;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class ar0 {
    private static boolean b(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.isFile()) {
                    file.delete();
                    e(file.getAbsolutePath());
                    return true;
                }
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return true;
                }
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        b(file2);
                        file2.delete();
                    } else if (file2.exists()) {
                        b(file2);
                        file2.delete();
                        e(file2.getAbsolutePath());
                    }
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return b(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(String str, Uri uri) {
    }

    private static void e(String str) {
        if (af1.c() != null) {
            try {
                MediaScannerConnection.scanFile(af1.c(), new String[]{str}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: zq0
                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                    public final void onScanCompleted(String str2, Uri uri) {
                        ar0.d(str2, uri);
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}