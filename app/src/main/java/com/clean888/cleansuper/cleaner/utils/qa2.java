package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class qa2 extends jm<gm> {
    public static String s = StringFog.decrypt("BDAmDC8CXxglPjQBCwkS");
    private final long p;
    private String q;
    private long r;

    public qa2(Context context, jm.a<gm> aVar) {
        super(context, aVar);
        this.p = 10485760L;
        this.q = StringFog.decrypt("svfghPPw1cjRbXM=");
        this.r = 0L;
    }

    private void v(File file) {
        if (file != null && file.exists() && file.isFile()) {
            i81 i81Var = new i81(file, 1007);
            if (i81Var.c() >= 10485760) {
                i81Var.k();
                l(i81Var);
            }
        }
    }

    private void w(List<File> list, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        while (i < i2) {
            File file = list.get(i);
            if (file.isDirectory()) {
                linkedList.add(file);
            } else {
                v(file);
            }
            i++;
        }
        while (!linkedList.isEmpty()) {
            File[] listFiles = ((File) linkedList.removeFirst()).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        linkedList.add(file2);
                    } else {
                        v(file2);
                    }
                }
            }
        }
    }

    @Override // defpackage.jm, defpackage.fn
    protected void b() {
        super.b();
        if (this.i) {
            Log.d(jm.o, this.q + StringFog.decrypt("stzRhNP/EScPJTYmBiwTDA==") + q());
        }
    }

    @Override // defpackage.fn
    public void j() {
    }

    @Override // defpackage.lm
    protected String n() {
        return s;
    }

    @Override // defpackage.fn
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Integer e(Void... voidArr) {
        List<String> b;
        File[] listFiles;
        if (!g() && u()) {
            if (this.a != null && (b = xl2.b()) != null && b.size() > 0) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<String> it = b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File file = new File(it.next());
                        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                            for (File file2 : listFiles) {
                                if (file2.isDirectory()) {
                                    arrayList.add(file2);
                                } else {
                                    v(file2);
                                }
                            }
                        }
                    }
                    w(arrayList, 0, arrayList.size() / 3);
                    w(arrayList, arrayList.size() / 3, (arrayList.size() / 3) * 2);
                    w(arrayList, (arrayList.size() / 3) * 2, arrayList.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.f1903g;
        }
        return this.h;
    }

    @Override // defpackage.fn
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void i(Integer num) {
        if (g()) {
            return;
        }
        if (this.i) {
            Log.d(jm.o, this.q + mr0.a((float) this.r, 2));
        }
        if (this.n == null || g()) {
            return;
        }
        this.n.d(new b91(this.r, this.m, 1007));
    }

    @Override // defpackage.fn
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void k(gm... gmVarArr) {
        gm gmVar;
        if (g() || (gmVar = gmVarArr[0]) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(gmVar);
        this.r += gmVar.c();
        if (this.n == null || g()) {
            return;
        }
        this.n.e(gmVar);
    }
}
