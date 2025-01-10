package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class wl2 {
    private StorageManager a;
    private Method b;
    private Method c;

    public wl2() {
        Context c = af1.c();
        if (c == null || c.getApplicationContext() == null) {
            return;
        }
        StorageManager storageManager = (StorageManager) c.getSystemService(StringFog.decrypt("JCcoEAQQVA=="));
        this.a = storageManager;
        try {
            storageManager.getClass().getMethod(StringFog.decrypt("MDYzNAobRB4CGzo0Fg=="), new Class[0]);
            this.b = this.a.getClass().getMethod(StringFog.decrypt("MDYzNAobRB4CBzIzChY="), new Class[0]);
            this.c = this.a.getClass().getMethod(StringFog.decrypt("MDYzNAobRB4CBCcmFgA="), String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> b() {
        ArrayList arrayList = new ArrayList();
        if (Environment.getExternalStorageState().equals(StringFog.decrypt("OjwyDBESVQ=="))) {
            arrayList.add(Environment.getExternalStorageDirectory().getPath());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private String[] c() {
        Method method = this.b;
        StorageManager storageManager = this.a;
        if (method != null && storageManager != null) {
            try {
                return (String[]) method.invoke(storageManager, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public List<String> a() {
        String[] c;
        ArrayList arrayList = new ArrayList();
        if (this.c != null && this.a != null && (c = c()) != null && c.length > 0) {
            for (int i = 0; i < c.length; i++) {
                try {
                    if (c[i] != null && this.c.invoke(this.a, c[i]).equals(StringFog.decrypt("OjwyDBESVQ=="))) {
                        arrayList.add(c[i]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList.isEmpty() ? b() : arrayList;
    }
}