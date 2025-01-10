package com.clean888.cleansuper.cleaner.utils;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class i10 {
    public static List<Long> a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Long.valueOf(Long.parseLong(it.next())));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static List<String> b(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(set);
        return arrayList;
    }
}