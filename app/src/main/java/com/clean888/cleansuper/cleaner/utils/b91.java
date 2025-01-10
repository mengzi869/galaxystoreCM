package com.clean888.cleansuper.cleaner.utils;


import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class b91 {
    public long a;
    public long b;
    public List<? extends gm> c;
    public int d;
    private boolean e = true;

    public b91(long j, List<? extends gm> list, int i) {
        this.c = new ArrayList();
        this.a = j;
        this.c = list == null ? new ArrayList<>() : list;
        this.d = i;
    }

    public boolean a() {
        return this.e;
    }

    public void b(boolean z) {
        this.e = z;
    }
}
