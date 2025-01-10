package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class l81 {
    private Context a;
    private i92 b;
    private h92 c;
    private b91 d;
    private int e;
    private final int f;

    /* renamed from: g */
    private y81 f1897g;
    private int h;
    private int i;
    private jm.a<gm> j;
    private hm.a<b91> k;
    private static final String n = StringFog.decrypt("PQwlCwIofBQ=");
    private static volatile int l = 10;
    private static volatile int m = 10;

    /* loaded from: classes2.dex */
    class a implements jm.a<gm> {
        a() {
        }

        @Override // jm.a
        /* renamed from: a */
        public void e(gm gmVar) {
            if (gmVar != null) {
                l81.this.f1897g.e(gmVar.d, gmVar);
            }
            l81.this.f1897g.h(l81.this.C(true));
        }

        @Override // jm.a
        public void c() {
            l81.this.f1897g.c();
            l81.this.f1897g.h(l81.this.C(true));
        }

        @Override // jm.a
        public void d(b91 b91Var) {
            l81.p(l81.this);
            if (b91Var != null) {
                if (b91Var.d == 1007) {
                    l81.this.d = b91Var;
                }
                l81.this.f1897g.j(b91Var.d, b91Var);
            }
            if (af1.b()) {
                Log.d(StringFog.decrypt("BDAmDC8CXxglNjAs"), StringFog.decrypt("en5qT0gjSAMCbQ==") + b91Var.d + "  " + mr0.a((float) b91Var.a, 2));
            }
            if (af1.b()) {
                Log.d(StringFog.decrypt("BDAmDC8CXxglNjAs"), StringFog.decrypt("en5qT0hXYhAGOTopBUVfEQ==") + l81.this.e + StringFog.decrypt("eA==") + 1 + StringFog.decrypt("fg=="));
            }
            if (l81.this.e < 1 || l81.l != 20) {
                return;
            }
            l81.u(l81.this);
            int unused = l81.l = 40;
            l81.this.f1897g.f(new b91[]{l81.this.d});
            l81.this.f1897g.h(l81.this.C(true));
            if (af1.b()) {
                Log.d(StringFog.decrypt("BDAmDC8CXxglNjAs"), StringFog.decrypt("en5qT0hXYhAGORUuDAwEWQ=="));
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements hm.a<b91> {
        b() {
        }

        @Override // hm.a
        public void a() {
            l81 l81Var = l81.this;
            l81Var.d = l81Var.x(l81Var.d);
            int unused = l81.m = 70;
            l81.this.f1897g.a();
            l81.this.f1897g.h(l81.this.C(true));
        }

        @Override // hm.a
        public void b() {
            int unused = l81.m = 60;
            l81.this.f1897g.b();
            l81.this.f1897g.h(l81.this.C(true));
        }

        @Override // hm.a
        /* renamed from: d */
        public void c(b91 b91Var) {
            if (b91Var != null) {
                if (b91Var.d == 1007) {
                    l81 l81Var = l81.this;
                    l81Var.d = l81Var.x(b91Var);
                }
                l81.this.f1897g.g(b91Var);
            }
            l81.this.f1897g.h(l81.this.C(true));
        }
    }

    /* loaded from: classes2.dex */
    private static class l81Instance {
        private static final l81 a = new l81();
    }

    /* synthetic */
//    l81(a aVar) {
//        this();
//    }

    public /* synthetic */ hm[] E() {
        return new hm[]{new du(this.a, A(), this.k)};
    }

    public /* synthetic */ jm[] F() {
        return new jm[]{new qa2(this.a, this.j)};
    }

    private void G(long j) {
        try {
            this.a.getApplicationContext().getSharedPreferences(g(n), 0).edit().putLong(g(StringFog.decrypt("PSYpCToEWAkCCD8mERE=")), j).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String g(String str) {
        return jm.t(str);
    }

    private void j(boolean z) {
        if (z) {
            m(true);
            l = 10;
        }
        if (l == 10 || l == 30 || l == 40) {
            this.h++;
            l = 20;
            this.e = 0;
            this.f1897g.i();
            this.f1897g.h(0L);
            this.b.a(new bn.a() { // from class: j81
                @Override // bn.a
                public final Object[] a() {
                    jm[] F;
                    F = l81.this.F();
                    return F;
                }
            });
        }
    }

    static /* synthetic */ int p(l81 l81Var) {
        int i = l81Var.e;
        l81Var.e = i + 1;
        return i;
    }

    static /* synthetic */ int u(l81 l81Var) {
        int i = l81Var.i;
        l81Var.i = i + 1;
        return i;
    }

    public b91 x(b91 b91Var) {
        if (b91Var == null || b91Var.a <= 0) {
            return null;
        }
        return b91Var;
    }

    public static l81 y() {
        return l81Instance.a;//c.a;
    }

    public List<b91> A() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.d);
        return arrayList;
    }

    public long B() {
        return C(false);
    }

    public long C(boolean z) {
        List<b91> A = A();
        long j = 0;
        if (A != null) {
            for (b91 b91Var : A) {
                if (b91Var != null) {
                    j += b91Var.a;
                }
            }
        }
        if (z) {
            G(j);
        }
        return j;
    }

    public boolean D() {
        return l == 40 && this.i > 0;
    }

    public l81 c(va2 va2Var) {
        return d(va2Var, true);
    }

    public l81 d(va2 va2Var, boolean z) {
        this.f1897g.t(va2Var);
        if (z) {
            if (this.h > 0 && l == 20) {
                this.f1897g.i();
            }
            if (this.i > 0 && l == 40) {
                this.f1897g.f(new b91[]{this.d});
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */


    public void e() {
        b91 v5_1;
        long v3 = 0L;
        try {
            List<b91> v2_1 = this.A();
            if(v2_1 != null) {
                Iterator v2_2 = v2_1.iterator();
                v3 = 0L;
                while(true) {
                    if(!v2_2.hasNext()) {
                        break;
                    }

                    Object v5 = v2_2.next();
                    v5_1 = (b91)v5;
                    if(v5_1 != null) {
                        v3 += v5_1.b;
                    }
                }
            }
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }

        y81 v2_3 = this.f1897g;
        if(v3 < 0L) {
            v3 = this.B();
        }
        v2_3.d(v3);
    }

    public void f() {
        if (m != 50) {
            m = 50;
            this.c.a(new bn.a() { // from class: k81
                @Override // bn.a
                public final Object[] a() {
                    hm[] E;
                    E = l81.this.E();
                    return E;
                }
            });
            this.f1897g.h(B());
        }
    }

    public l81 h(va2 va2Var) {
        this.f1897g.u(va2Var);
        return this;
    }

    public void i() {
        j(false);
    }

    public void k() {
        j(true);
    }

    public void l() {
        m(false);
    }

    public void m(boolean z) {
        if (z || l == 20) {
            l = 30;
            this.b.b();
            this.f1897g.h(B());
        }
    }

    public long z() {
        long j = 0;
        try {
            j = this.a.getApplicationContext().getSharedPreferences(g(n), 0).getLong(g(StringFog.decrypt("PSYpCToEWAkCCD8mERE=")), 0L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (af1.b()) {
            Log.d(StringFog.decrypt("BDAmDC8CXxg="), StringFog.decrypt("svfghPPw1cjRbXOi6viSlviC28Wg9+merNGBz+2gxt+TifmB+/Kg+OGQjeCC+suixsKSgfxHanM=") + mr0.a((float) j, 2));
        }
        return j;
    }

    private l81() {
        this.e = 0;
        this.f = 1;
        this.f1897g = new y81();
        this.j = new a();
        this.k = new b();
        this.a = af1.c();
        this.b = new i92();
        this.c = new h92();
        l = 10;
    }
}