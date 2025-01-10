package com.clean888.cleansuper.cleaner.utils;

import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.SpannableStringBuilder;
import androidx.annotation.RequiresApi;
import com.clean888.cleansuper.cleaner.R;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes2.dex */
public class tf {
    private static int[] a = {R.string.sizeUnit_B, R.string.sizeUnit_kb, R.string.sizeUnit_Mb, R.string.sizeUnit_Gb, R.string.sizeUnit_Tb};
    private static int[] b = {R.string.sizeUnit_B, R.string.sizeUnit_k, R.string.sizeUnit_M, R.string.sizeUnit_G, R.string.sizeUnit_T};

    public static SpannableStringBuilder a(Context context) {
        long j;
        long j2;
        StorageManager storageManager;
        long longValue;
        StorageManager storageManager2 = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            try {
                StorageVolume[] storageVolumeArr = (StorageVolume[]) StorageManager.class.getDeclaredMethod("getVolumeList", new Class[0]).invoke(storageManager2, new Object[0]);
                if (storageVolumeArr != null) {
                    Method method = null;
                    long j3 = 0;
                    long j4 = 0;
                    for (StorageVolume storageVolume : storageVolumeArr) {
                        if (method == null) {
                            method = storageVolume.getClass().getDeclaredMethod("getPathFile", new Class[0]);
                        }
                        File file = (File) method.invoke(storageVolume, new Object[0]);
                        j4 += file.getTotalSpace();
                        j3 += file.getUsableSpace();
                    }
                    j = j3;
                    j2 = j4;
                } else {
                    j = 0;
                    j2 = 0;
                }
                StringBuilder sb = new StringBuilder();
                float f = (float) (j2 - j);
                sb.append(h(f, 1000.0f));
                sb.append(g(f, 1000.0f, context));
                sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
                sb.append(d((float) j2, 1000.0f, context));
                return new SpannableStringBuilder(sb.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } else {
            try {
                long j5 = 0;
                long j6 = 0;
                for (Object obj : (List) StorageManager.class.getDeclaredMethod("getVolumes", new Class[0]).invoke(storageManager2, new Object[0])) {
                    int i2 = obj.getClass().getField("type").getInt(obj);
                    if (i2 == 1) {
                        if (i >= 26) {
                            longValue = f(context, (String) obj.getClass().getDeclaredMethod("getFsUuid", new Class[0]).invoke(obj, new Object[0]));
                        } else {
                            longValue = i >= 25 ? ((Long) StorageManager.class.getMethod("getPrimaryStorageSize", new Class[0]).invoke(storageManager2, new Object[0])).longValue() : 0L;
                        }
                        storageManager = storageManager2;
                        if (((Boolean) obj.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            File file2 = (File) obj.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
                            if (longValue == 0) {
                                longValue = file2.getTotalSpace();
                            }
                            file2.getTotalSpace();
                            j5 += longValue - file2.getFreeSpace();
                            j6 += longValue;
                        }
                    } else {
                        storageManager = storageManager2;
                        if (i2 == 0 && ((Boolean) obj.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            File file3 = (File) obj.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
                            j5 += file3.getTotalSpace() - file3.getFreeSpace();
                            j6 += file3.getTotalSpace();
                        }
                    }
                    storageManager2 = storageManager;
                }
                StringBuilder sb2 = new StringBuilder();
                float f2 = (float) j5;
                sb2.append(h(f2, 1000.0f));
                sb2.append(g(f2, 1000.0f, context));
                sb2.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
                sb2.append(d((float) j6, 1000.0f, context));
                return new SpannableStringBuilder(sb2.toString());
            } catch (SecurityException unused) {
            } catch (Exception e4) {
                e4.printStackTrace();
                b();
            }
        }
        return new SpannableStringBuilder("");
    }

    public static void b() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        statFs.getBlockCount();
        statFs.getBlockSize();
        statFs.getAvailableBlocks();
        statFs.getFreeBlocks();
    }

    public static float c(Context context) {
        long j;
        long j2;
        long longValue;
        StorageManager storageManager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            try {
                StorageVolume[] storageVolumeArr = (StorageVolume[]) StorageManager.class.getDeclaredMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
                if (storageVolumeArr != null) {
                    Method method = null;
                    long j3 = 0;
                    long j4 = 0;
                    for (StorageVolume storageVolume : storageVolumeArr) {
                        if (method == null) {
                            method = storageVolume.getClass().getDeclaredMethod("getPathFile", new Class[0]);
                        }
                        File file = (File) method.invoke(storageVolume, new Object[0]);
                        j3 += file.getTotalSpace();
                        j4 += file.getUsableSpace();
                    }
                    j = j3;
                    j2 = j4;
                } else {
                    j = 0;
                    j2 = 0;
                }
                return (((float) j2) * 1.0f) / ((float) j);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return 0.0f;
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                return 0.0f;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return 0.0f;
            }
        }
        try {
            long j5 = 0;
            long j6 = 0;
            for (Object obj : (List) StorageManager.class.getDeclaredMethod("getVolumes", new Class[0]).invoke(storageManager, new Object[0])) {
                int i2 = obj.getClass().getField("type").getInt(obj);
                if (i2 == 1) {
                    if (i >= 26) {
                        longValue = f(context, (String) obj.getClass().getDeclaredMethod("getFsUuid", new Class[0]).invoke(obj, new Object[0]));
                    } else {
                        longValue = i >= 25 ? ((Long) StorageManager.class.getMethod("getPrimaryStorageSize", new Class[0]).invoke(storageManager, new Object[0])).longValue() : 0L;
                    }
                    if (((Boolean) obj.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                        File file2 = (File) obj.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
                        if (longValue == 0) {
                            longValue = file2.getTotalSpace();
                        }
                        file2.getTotalSpace();
                        j5 += longValue - file2.getFreeSpace();
                        j6 += longValue;
                    }
                } else if (i2 == 0 && ((Boolean) obj.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                    File file3 = (File) obj.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
                    j5 += file3.getTotalSpace() - file3.getFreeSpace();
                    j6 += file3.getTotalSpace();
                }
            }
            Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), "roboto_bold.ttf");
            StringBuilder sb = new StringBuilder();
            sb.append(context.getString(R.string.storage_tip));
            sb.append(" ");
            sb.append(e((float) j5, 1000.0f, context));
            sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
            float f = (float) j6;
            sb.append(e(f, 1000.0f, context));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
            long j7 = j6 - j5;
            long j8 = j7 / j6;
            spannableStringBuilder.setSpan(new BAEQ("", createFromAsset), context.getString(R.string.storage_tip).length() + 1, spannableStringBuilder.length() - 1, 34);
            return (((float) j7) * 1.0f) / f;
        } catch (SecurityException unused) {
            return 0.0f;
        } catch (Exception e4) {
            e4.printStackTrace();
            b();
            return 0.0f;
        }
    }

    public static String d(float f, float f2, Context context) {
        int i = 0;
        while (f > f2 && i < 4) {
            f /= f2;
            i++;
        }
        return String.format(Locale.getDefault(), "%.0f%s", Float.valueOf(f), context.getString(b[i]));
    }

    public static String e(float f, float f2, Context context) {
        int i = 0;
        while (f > f2 && i < 4) {
            f /= f2;
            i++;
        }
        return String.format(Locale.getDefault(), " %.2f %s ", Float.valueOf(f), context.getString(a[i]));
    }

    @RequiresApi(26)
    public static long f(Context context, String str) {
        UUID fromString;
        try {
            if (str == null) {
                fromString = StorageManager.UUID_DEFAULT;
            } else {
                fromString = UUID.fromString(str);
            }
            return ((StorageStatsManager) context.getSystemService(StorageStatsManager.class)).getTotalBytes(fromString);
        } catch (IOException | NoClassDefFoundError | NoSuchFieldError | NullPointerException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static String g(float f, float f2, Context context) {
        int i = 0;
        while (f > f2 && i < 4) {
            f /= f2;
            i++;
        }
        return String.format(Locale.getDefault(), "%s", context.getString(b[i]));
    }

    public static String h(float f, float f2) {
        for (int i = 0; f > f2 && i < 4; i++) {
            f /= f2;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f));
    }
}