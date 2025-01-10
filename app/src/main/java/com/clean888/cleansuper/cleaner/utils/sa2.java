package com.clean888.cleansuper.cleaner.utils;


import android.content.Context;
import android.util.Log;

import com.unity3d.player.StringFog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class sa2 extends jm<gm> {
    public static String z = StringFog.decrypt("BDAmDC8CXxgkOD4qDQs=");
    private String p;
    private String q;
    private String r;
    private int s;
    private long t;
    private long u;
    private long v;
    protected List<e91> w;
    protected List<m91> x;
    protected List<g81> y;

    public sa2(Context context, jm.a<gm> aVar) {
        super(context, aVar);
        this.p = StringFog.decrypt("sv3Oisby1P/ibXM=");
        this.q = StringFog.decrypt("s+vzhPLB1+Xgs+jxWEU=");
        this.r = StringFog.decrypt("scTih9rgC1M=");
        this.s = 4;
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
    }

    private void v(File file, int i) {
        File[] listFiles;
        if (file == null || !file.exists() || i > this.s || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        try {
            for (File file2 : listFiles) {
                try {
                    String name = file2.getName();
                    if (file2.isFile()) {
                        gm gmVar = null;
                        if (name.endsWith(StringFog.decrypt("eTI3CQ=="))) {
                            gmVar = new g81(file2, 1006);
                        } else if (name.endsWith(StringFog.decrypt("eT8oBQ=="))) {
                            gmVar = new e91(file2, 1002);
                        } else if (name.endsWith(StringFog.decrypt("eScqEg=="))) {
                            gmVar = new m91(file2, 1003);
                        }
                        if (gmVar != null) {
                            l(gmVar);
                        }
                    } else if (i < this.s) {
                        int i2 = i + 1;
                        try {
                            v(file2, i);
                        } catch (Exception e) {
                            try {
                                if (this.i) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e2) {
                                e = e2;
                                i = i2;
                                if (this.i) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        i = i2;
                    }
                } catch (Exception e3) {
//                    e = e3;
                }
            }
        } catch (Exception e4) {
            if (this.i) {
                e4.printStackTrace();
            }
        }
    }

    @Override // defpackage.jm, defpackage.fn
    protected void b() {
        super.b();
        if (this.i) {
            Log.d(jm.o, this.p + StringFog.decrypt("stzRhNP/EScPJTYmBiwTDA==") + q());
            Log.d(jm.o, this.q + StringFog.decrypt("stzRhNP/EScPJTYmBiwTDA==") + q());
            Log.d(jm.o, this.r + StringFog.decrypt("stzRhNP/EScPJTYmBiwTDA==") + q());
        }
    }

    @Override // defpackage.fn
    public void j() {
    }

    @Override // defpackage.lm
    protected String n() {
        return z;
    }

    @Override // defpackage.fn
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Integer e(Void... voidArr) {
        List<String> b;
        File[] listFiles;
        if (!g() && u()) {
            if (this.a != null && (b = xl2.b()) != null && !b.isEmpty() && this.s >= 0) {
                Iterator<String> it = b.iterator();
                while (it.hasNext()) {
                    File file = new File(it.next());
                    if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.exists()) {
                                try {
                                    if (file2.isFile()) {
                                        String name = file2.getName();
                                        gm gmVar = null;
                                        if (name.endsWith(StringFog.decrypt("eTI3CQ=="))) {
                                            gmVar = new g81(file2, 1006);
                                        } else {
                                            if (!name.endsWith(StringFog.decrypt("eT8oBQ==")) && !name.endsWith(StringFog.decrypt("eSsrDQI="))) {
                                                if (name.endsWith(StringFog.decrypt("eScqEg=="))) {
                                                    gmVar = new m91(file2, 1003);
                                                }
                                            }
                                            gmVar = new e91(file2, 1002);
                                        }
                                        if (gmVar != null) {
                                            l(gmVar);
                                        }
                                    } else if (!StringFog.decrypt("Fj0jEAoeVQ==").equalsIgnoreCase(file2.getName()) && this.s > 0) {
                                        try {
                                            v(file2, 1);
                                        } catch (Exception e) {
                                            if (this.i) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    if (this.i) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return this.f1903g;
        }
        return this.h;
    }

    @Override // defpackage.fn
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void i(Integer num) {
        if (g()) {
            return;
        }
        if (this.i) {
            Log.d(jm.o, this.p + mr0.a((float) this.v, 2));
            Log.d(jm.o, this.q + mr0.a((float) this.u, 2));
            Log.d(jm.o, this.r + mr0.a((float) this.t, 2));
        }
        if (this.n == null || g()) {
            return;
        }
        this.n.d(new b91(this.t, this.w, 1002));
        this.n.d(new b91(this.u, this.x, 1003));
        this.n.d(new b91(this.v, this.y, 1006));
    }

    @Override // defpackage.fn
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void k(gm... gmVarArr) {
        gm gmVar;
        if (g() || (gmVar = gmVarArr[0]) == null) {
            return;
        }
        if (gmVar instanceof g81) {
            this.v += gmVar.c();
            this.y.add((g81) gmVar);
            if (this.n == null || g()) {
                return;
            }
            this.n.e(gmVar);
            return;
        }
        if (gmVar instanceof m91) {
            this.u += gmVar.c();
            this.x.add((m91) gmVar);
            if (this.n == null || g()) {
                return;
            }
            this.n.e(gmVar);
            return;
        }
        if (gmVar instanceof e91) {
            this.t += gmVar.c();
            this.w.add((e91) gmVar);
            if (this.n == null || g()) {
                return;
            }
            this.n.e(gmVar);
        }
    }
}