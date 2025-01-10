package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
//import defpackage.a91;
//import defpackage.bn;
//import defpackage.hm;
//import defpackage.jm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes2.dex */
public class h91 {
    private String TAG  = "h91";
    private Context a;
    private boolean b;
    private i92 c;
    private h92 d;
    private b91 e;
    private b91 f;

    /* renamed from: g, reason: collision with root package name */
    private b91 f1812g;
    private b91 h;
    private b91 i;
    private b91 j;
    private b91 k;
    private final int l;
    private int m;
    private int n;
    private int o;
    private volatile long p;
    private volatile boolean q;
    private y81 r;
    private a91.b s;
    private jm.a<gm> t;
    private hm.a<b91> u;
    public final String v;
    private static final String z = StringFog.decrypt("PQwpDQgoWwYJPAwKBQ==");
    private static volatile int w = 10;
    private static volatile int x = -1;
    private static volatile int y = 10;

    /* loaded from: classes2.dex */
    class a implements a91.b {
        a() {
        }

        @Override // a91.b
        public void a() {
        }

        @Override // a91.b
        public void b() {
            h91.this.b = true;
            if (h91.w == 0) {
                h91.w = 10;
            }
            if (h91.w == 10 && h91.x == 20) {
                h91.this.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements jm.a<gm> {
        b() {
        }

        @Override // jm.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(gm gmVar) {
            if (gmVar != null) {
                h91.this.r.e(gmVar.d, gmVar);
            }
            h91.this.r.h(h91.this.U(true));
        }

        @Override // jm.a
        public void c() {
            h91.this.r.c();
            h91.this.r.h(h91.this.U(true));
        }

        @Override // jm.a
        public void d(b91 b91Var) {
            b91 b91Var2;
            h91.I(h91.this);
            if (b91Var != null) {
                int i = b91Var.d;
                if (i != 100) {
                    switch (i) {
                        case 1001:
                            h91.this.h = b91Var;
                            break;
                        case 1002:
                            h91.this.k = b91Var;
                            break;
                        case 1003:
                            h91.this.j = b91Var;
                            break;
                        case 1004:
                            h91.this.f1812g = b91Var;
                            break;
                        case 1005:
                            h91.this.f = b91Var;
                            break;
                        case 1006:
                            h91.this.i = b91Var;
                            break;
                    }
                } else {
                    h91.this.e = b91Var;
                }
                h91.this.r.j(b91Var.d, b91Var);
            }
            if (af1.b()) {
                Log.d(StringFog.decrypt("BDAmDC8CXxglNjAs"), StringFog.decrypt("en5qT0gjSAMCbQ==") + b91Var.d + "  " + mr0.a((float) b91Var.a, 2));
            }
            if (af1.b()) {
                Log.d(StringFog.decrypt("BDAmDC8CXxglNjAs"), StringFog.decrypt("en5qT0hXYhAGOTopBUVfEQ==") + h91.this.m + StringFog.decrypt("eA==") + 7 + StringFog.decrypt("fg=="));
            }
            if (h91.this.m < 7 || h91.w != 20) {
                return;
            }
            h91.x(h91.this);
            int unused = h91.w = 40;
            if (h91.this.q) {
                long V = h91.this.V();
                long j = 0;
                if (V > 0) {
                    List<b91> S = h91.this.S();
                    if (S != null) {
                        b91Var2 = null;
                        for (b91 b91Var3 : S) {
                            if (b91Var3 != null && b91Var3.d != 100) {
                                j += b91Var3.a;
                            } else if (b91Var3 != null && b91Var3.d == 100) {
                                b91Var2 = b91Var3;
                            }
                        }
                    } else {
                        b91Var2 = null;
                    }
                    if (j >= V) {
                        h91.this.e = null;
                    } else {
                        long j2 = V - j;
                        if (b91Var2 != null) {
                            try {
                                List<? extends gm> subList = b91Var2.c.subList(0, 1);
                                b91Var2.c = subList;
                                subList.get(0).f(j2);
                            } catch (Throwable unused2) {
                            }
                            b91Var2.a = j2;
                        }
                    }
                }
            }
            h91.this.r.f((b91[]) h91.this.S().toArray(new b91[0]));
            h91.this.r.h(h91.this.U(true));
            if (af1.b()) {
                Log.d(StringFog.decrypt("BDAmDC8CXxglNjAs"), StringFog.decrypt("en5qT0hXYhAGORUuDAwEWQ=="));
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements hm.a<b91> {
        c() {
        }

        @Override // hm.a
        public void a() {
            h91 h91Var = h91.this;
            h91Var.e = h91Var.P(h91Var.e);
            h91 h91Var2 = h91.this;
            h91Var2.f = h91Var2.P(h91Var2.f);
            h91 h91Var3 = h91.this;
            h91Var3.f1812g = h91Var3.P(h91Var3.f1812g);
            h91 h91Var4 = h91.this;
            h91Var4.h = h91Var4.P(h91Var4.h);
            h91 h91Var5 = h91.this;
            h91Var5.i = h91Var5.P(h91Var5.i);
            h91 h91Var6 = h91.this;
            h91Var6.j = h91Var6.P(h91Var6.j);
            h91 h91Var7 = h91.this;
            h91Var7.k = h91Var7.P(h91Var7.k);
            int unused = h91.y = 70;
            h91.this.r.a();
            h91.this.r.h(h91.this.U(true));
        }

        @Override // hm.a
        public void b() {
            int unused = h91.y = 60;
            h91.this.r.b();
            h91.this.r.h(h91.this.U(true));
        }

        @Override // hm.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(b91 b91Var) {
            if (b91Var != null) {
                int i = b91Var.d;
                if (i != 100) {
                    switch (i) {
                        case 1001:
                            h91 h91Var = h91.this;
                            h91Var.h = h91Var.P(b91Var);
                            break;
                        case 1002:
                            h91 h91Var2 = h91.this;
                            h91Var2.k = h91Var2.P(b91Var);
                            break;
                        case 1003:
                            h91 h91Var3 = h91.this;
                            h91Var3.j = h91Var3.P(b91Var);
                            break;
                        case 1004:
                            h91 h91Var4 = h91.this;
                            h91Var4.f1812g = h91Var4.P(b91Var);
                            break;
                        case 1005:
                            h91 h91Var5 = h91.this;
                            h91Var5.f = h91Var5.P(b91Var);
                            break;
                        case 1006:
                            h91 h91Var6 = h91.this;
                            h91Var6.i = h91Var6.P(b91Var);
                            break;
                    }
                } else {
                    h91 h91Var7 = h91.this;
                    h91Var7.e = h91Var7.P(b91Var);
                    if (h91.this.e == null) {
                        if (h91.this.X()) {
                            h91.this.g();
                        }
                        h91.this.g();
                    }
                }
                h91.this.r.g(b91Var);
            }
            h91.this.r.h(h91.this.U(true));
        }
    }

    /* loaded from: classes2.dex */
    private static class instance {
        private static final h91 a = new h91();
    }

    /* synthetic */
/*    h91() {
        this();
    }*/

    static /* synthetic */ int I(h91 h91Var) {
        int i = h91Var.m;
        h91Var.m = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b91 P(b91 b91Var) {
        if (b91Var == null || b91Var.a <= 0) {
            return null;
        }
        return b91Var;
    }

    public static h91 Q() {
        return instance.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ hm[] Y() {
        return new hm[]{
                new eu(this.a, S(), this.u)
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ jm[] Z() {
        return new jm[]{
                new ra2(this.a, this.t),
                new pa2(this.a, this.t),
                new sa2(this.a, this.t),
                new ta2(this.a, this.t),
                new ua2(this.a, this.t)
        };
    }

    private void b0(long j) {
        try {
            this.a.getApplicationContext().getSharedPreferences(i(z), 0).edit().putLong(i(StringFog.decrypt("PSYpCToEWAkCCD8mERE=")), j).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.q = false;
        this.p = 0L;
        SharedPreferences sharedPreferences = this.a.getApplicationContext().getSharedPreferences(i(StringFog.decrypt("PSYlDAAoVQAA")), 0);
        sharedPreferences.edit().putBoolean(i(StringFog.decrypt("PSYpCToYQRYJCDUm")), false).commit();
        sharedPreferences.edit().remove(i(StringFog.decrypt("PSYpCToEWAkCCDUm"))).commit();
        if (af1.b()) {
            Log.d(StringFog.decrypt("ETIsBy8CXxg="), StringFog.decrypt("dxUuDAwEWVMhNjgiQi8CXxhLdx0oFUUxUBgCdwAuGABXDFM=") + mr0.a((float) V(), 2));
        }
    }

    private void h() {
        SharedPreferences sharedPreferences = this.a.getApplicationContext().getSharedPreferences(i(StringFog.decrypt("PSYlDAAoVQAA")), 0);
        this.q = sharedPreferences.getBoolean(i(StringFog.decrypt("PSYpCToYQRYJCDUm")), true);
        this.p = sharedPreferences.getLong(i(StringFog.decrypt("PSYpCToEWAkCCDUm")), -1L);
        if (this.q && this.p < 0) {
            long nextDouble = (long) ((new Random().nextDouble() + 2.5d) * 1.073741824E9d);
            sharedPreferences.edit().putLong(i(StringFog.decrypt("PSYpCToEWAkCCDUm")), nextDouble).commit();
            this.p = nextDouble;
        }
        if (af1.b()) {
            Log.d(StringFog.decrypt("ETIsBy8CXxg="), StringFog.decrypt("dzopCxFXdxIMMnMNFwscESAOLTZnX0U=") + mr0.a((float) V(), 2));
        }
    }

    private String i(String str) {
        return jm.t(str);
    }

    private void l(boolean z2) {
        Log.d(TAG,"l begin " + this.b + " z2= " + z2);
        b = true;
        if (this.b) {
            if (z2) {
                o(true);
                w = 10;
            }
            if (w == 10 || w == 40) {
                w = 20;
                x = -1;
                this.n++;
                this.m = 0;
                this.r.i();
                this.r.h(0L);
                this.c.a(new bn.a() { // from class: f91
                    @Override // bn.a
                    public final Object[] a() {
                        Log.d(TAG,"bn a begin 1");
                        jm[] Z;
                        Z = h91.this.Z();
                        return Z;
                    }
                });
                return;
            }
            return;
        }
        x = 20;
    }

    static /* synthetic */ int x(h91 h91Var) {
        int i = h91Var.o;
        h91Var.o = i + 1;
        return i;
    }

    public long R() {
        long j = 0;
        try {
            j = this.a.getApplicationContext().getSharedPreferences(i(z), 0).getLong(i(StringFog.decrypt("PSYpCToEWAkCCD8mERE=")), 0L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (af1.b()) {
            Log.d(StringFog.decrypt("BDAmDC8CXxg="), StringFog.decrypt("scrpi+Xt1O3kss/5hN3y1uPhbXOi6viSlviC28Wg9+merNGBz+2gxt+TifmB+/Kg+OGQjeCC+suixsKSgfxHanM=") + mr0.a((float) j, 2));
        }
        return j;
    }

    public List<b91> S() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.e);
        arrayList.add(this.f);
        arrayList.add(this.f1812g);
        arrayList.add(this.h);
        arrayList.add(this.i);
        arrayList.add(this.j);
        arrayList.add(this.k);
        return arrayList;
    }

    public long T() {
        return U(false);
    }

    public long U(boolean z2) {
        List<b91> S = S();
        long j = 0;
        if (S != null) {
            for (b91 b91Var : S) {
                if (b91Var != null) {
                    j += b91Var.a;
                }
            }
        }
        if (z2) {
            b0(j);
        }
        return j;
    }

    public long V() {
        return this.p;
    }

    public long W() {
        try {
            return this.a.getApplicationContext().getSharedPreferences(i(this.v), 0).getLong(i(StringFog.decrypt("OzI0FjoUXRYGOQwzCwgS")), 0L);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public boolean X() {
        return this.q;
    }

    public void a0() {
        try {
            Context context = this.a;
            context.getApplicationContext().getSharedPreferences(i(this.v), 0).edit().putLong(i(StringFog.decrypt("OzI0FjoUXRYGOQwzCwgS")), System.currentTimeMillis()).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public h91 c(va2 va2Var) {
        return d(va2Var, true);
    }

    public h91 d(va2 va2Var, boolean z2) {
        this.r.t(va2Var);
        if (z2) {
            if (this.n > 0 && w == 20) {
                this.r.i();
            }
            if (this.o > 0 && w == 40) {
                this.r.f((b91[]) S().toArray(new b91[0]));
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
            List v2_1 = this.S();
            if(v2_1 == null) {
//                goto label_19;
                v3 = 0L;
            }
            else {
                Iterator v2_2 = v2_1.iterator();
                v3 = 0L;
                while(true) {
                    label_6:
                    if(!v2_2.hasNext()) {
                        break;
                    }

                    Object v5 = v2_2.next();
                    v5_1 = (b91)v5;
                    if(v5_1 == null) {
                       continue;
                    }

                    v3 += v5_1.b;
                }
            }
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }

        y81 v2_3 = this.r;
        if(v3 < 0L) {
            v3 = this.T();
        }

        v2_3.d(v3);
    }

    public void f() {
        if (y != 50) {
            y = 50;
            this.d.a(new bn.a() { // from class: g91
                @Override // bn.a
                public final Object[] a() {
                    hm[] Y;
                    Y = h91.this.Y();
                    return Y;
                }
            });
            this.r.h(T());
            a0();
        }
    }

    public h91 j(va2 va2Var) {
        this.r.u(va2Var);
        return this;
    }

    public void k() {
        l(false);
    }

    public void m() {
        l(true);
    }

    public void n() {
        o(false);
    }

    public void o(boolean z2) {
        if (z2 || w == 20) {
            w = 30;
            this.c.b();
            this.r.h(T());
        }
    }

    private h91() {
        this.b = false;
        this.l = 7;
        this.m = 0;
        this.p = -1L;
        this.r = new y81();
        this.s = new a();
        this.t = new b();
        this.u = new c();
        this.v = StringFog.decrypt("PQwqBToUXSwTCD8YU1NDBUJU");
        this.a = af1.c();
        w = 0;
        this.c = new i92();
        this.d = new h92();
        a91.e().b(this.s);
        h();
    }
}