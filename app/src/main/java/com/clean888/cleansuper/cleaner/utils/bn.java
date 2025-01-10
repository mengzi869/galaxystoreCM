package com.clean888.cleansuper.cleaner.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class bn<T> {
    private List<String> a = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a<T> {
        T[] a();
    }

    public void a(a<T> aVar) {
        if (aVar != null) {
            synchronized (this.a) {
                if (aVar != null) {
                    T[] a2 = aVar.a();
                    if (a2 != null) {
                        for (T t : a2) {
                            if (t != null) {
                                String c = c(t);
                                if (!TextUtils.isEmpty(c)) {
                                    this.a.add(c);
                                }
                                d(t);
                            }
                        }
                    }
                }
            }
        }
    }

    public void b() {
        List<String> list = this.a;
        if (list == null || list.size() <= 0) {
            return;
        }
        synchronized (this.a) {
            List<String> list2 = this.a;
            if (list2 != null) {
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        e(str);
                    }
                }
                this.a.clear();
            }
        }
    }

    protected abstract String c(T t);

    protected abstract void d(T t);

    protected abstract void e(String str);
}