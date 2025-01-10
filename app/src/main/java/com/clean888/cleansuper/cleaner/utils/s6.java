package com.clean888.cleansuper.cleaner.utils;


import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Binder;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
//import com.unity3d.player.R;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.bean.RunningAppBean;
import com.unity3d.player.StringFog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class s6 {
    private static final List<String> arrayList;
    private static final List<String> arrayList2;

    static {
        arrayList = new ArrayList();
        arrayList.add(StringFog.decrypt("Nj0jEAoeVQ=="));
        arrayList.add(StringFog.decrypt("NDwqTAIYXhQLMn0mDAEFXhoDeTQ0BA=="));
        arrayList.add(StringFog.decrypt("NDwqTAIYXhQLMn0mDAEFXhoDeTQ0BEsbXhQOOQ=="));
        arrayList.add(StringFog.decrypt("NDwqTAQZVQEIPjdpERwERRYKIjo="));
        arrayList.add(StringFog.decrypt("NDwqTAIYXhQLMn0mDAEFXhoDeSMmAQ4WVhYOOSAzAwkbVAE="));
        arrayList.add(StringFog.decrypt("NDwqTAQZVQEIPjdpEQADRRoJMCA="));
        arrayList.add(StringFog.decrypt("NDwqTAIYXhQLMn0mDAEFXhoDeTQqEQ=="));

        arrayList2 = new ArrayList();
        arrayList2.add(StringFog.decrypt("Pj03FxE="));
        arrayList2.add(StringFog.decrypt("IzoqBw=="));
        arrayList2.add(StringFog.decrypt("ND8oAQ4="));
        arrayList2.add(StringFog.decrypt("JyEoFAwTVAE="));
        arrayList2.add(StringFog.decrypt("JCo0FgAa"));
        arrayList2.add(StringFog.decrypt("OzIyDAYfVAE="));
        arrayList2.add(StringFog.decrypt("JzIkCQQQVA=="));
    }

    public static List<RunningAppBean> a(Context context, @NonNull r6 r6Var) {
        int a2 = r6Var == null ? -1 : r6Var.a();
        List<RunningAppBean> b2 = b(context, arrayList, arrayList2);
        Collections.shuffle(b2);
        if (a2 > 0 && b2.size() > a2) {
            b2 = b2.subList(0, a2);
        }
        long j = -1;
        try {
            j = (long) (((ActivityManager) context.getSystemService(StringFog.decrypt("NjAzCxMeRQo="))).getProcessMemoryInfo(new int[]{Binder.getCallingPid()})[0].dalvikPrivateDirty * 1024.0d * 2.0d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        for (RunningAppBean runningBackgrdAppsBeanVar : b2) {
            if (j > 0 && runningBackgrdAppsBeanVar.getAppMemoryInfo() <= 0) {
                runningBackgrdAppsBeanVar.getAppMemoryInfo(j);
                runningBackgrdAppsBeanVar.g(0.2f, 2.0f);
            }
        }
        return b2;
    }

    private static List<RunningAppBean> b(Context context, List<String> list, List<String> list2) {
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        List<PackageInfo> arrayList2 = new ArrayList<>();
        try {
            PackageManager packageManager = context.getPackageManager();
            try {
                arrayList2 = packageManager.getInstalledPackages(0);
            } catch (Exception unused) {
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            try {
                arrayList3 = c(context);
            } catch (Exception unused2) {
            }
            if (packageManager != null && arrayList2 != null && arrayList2.size() != 0) {
                for (int i = 0; i < arrayList2.size(); i++) {
                    PackageInfo packageInfo = arrayList2.get(i);
                    int i2 = packageInfo.applicationInfo.flags;
                    boolean z = (i2 & 1) > 0;
                    boolean z2 = (2097152 & i2) > 0;
                    boolean z3 = (i2 & 8) > 0;
                    if (!z2 && !z && !z3) {
                        if (list2 != null) {
                            Iterator<String> it = list2.iterator();
                            while (it.hasNext() && !packageInfo.packageName.contains(it.next())) {
                            }
                        }
                        if ((list == null || !list.contains(packageInfo.packageName)) && !context.getPackageName().equals(packageInfo.packageName)) {
                            try {
                                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageInfo.packageName, 0);
                                RunningAppBean runningBackgrdAppsBeanVar = new RunningAppBean();
                                runningBackgrdAppsBeanVar.setAppIcon(applicationInfo.loadIcon(packageManager));
                                runningBackgrdAppsBeanVar.setAppName(applicationInfo.loadLabel(packageManager).toString());
                                runningBackgrdAppsBeanVar.setAppPackageName(applicationInfo.packageName);
                                runningBackgrdAppsBeanVar.i(arrayList3.contains(applicationInfo.packageName));
                                arrayList.add(runningBackgrdAppsBeanVar);
                            } catch (PackageManager.NameNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            do {
            } while (arrayList2.size() > 0);
            return arrayList;
        }
    }

    private static ArrayList<String> c(Context context) throws IOException, XmlPullParserException {
        XmlResourceParser xml = context.getResources().getXml(R.xml.app_lock_recommend);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        ArrayList<String> arrayList = new ArrayList<>();
        while (xml.getEventType() != 1) {
            if (xml.getEventType() == 2) {
                if (xml.getName().equals(StringFog.decrypt("OzwkCSQHQQ=="))) {
                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, new int[]{R.attr.appPackageName, R.attr.appRank, R.attr.categoryId});
                    int i = obtainStyledAttributes.getInt(2, 0);
                    if (i == 1 || i == 5) {
                        arrayList.add(obtainStyledAttributes.getString(0));
                    }
                    obtainStyledAttributes.recycle();
                }
            } else if (xml.getEventType() != 3) {
                xml.getEventType();
            }
            xml.next();
        }
        return arrayList;
    }
}


