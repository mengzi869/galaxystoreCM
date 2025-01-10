package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.util.Log;

import com.clean888.cleansuper.cleaner.R;
import com.unity3d.player.StringFog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes2.dex */
public class ua2 extends jm<gm> {
    public static String r = StringFog.decrypt("BDAmDC8CXxg0LiAzBwg0UBAPMg==");
    private String p;
    private long q;

    public ua2(Context context, jm.a<gm> aVar) {
        super(context, aVar);
        this.p = StringFog.decrypt("sOD8hd7o1O3kss/5WEU=");
        this.q = 0L;
    }

    private long w(long j) {
        try {
            return this.a.getApplicationContext().getSharedPreferences(jm.t(StringFog.decrypt("JAwkPQ8oQiwEZmJ1UFZA")), 0).getLong(jm.t(StringFog.decrypt("OzI0FjoEUhIJCCAuGAA=")), j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    private void z(long j) {
        try {
            this.a.getApplicationContext().getSharedPreferences(jm.t(StringFog.decrypt("JAwkPQ8oQiwEZmJ1UFZA")), 0).edit().putLong(jm.t(StringFog.decrypt("OzI0FjoEUhIJCCAuGAA=")), j).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.jm, defpackage.fn
    protected void b() {
        super.b();
        if (this.i) {
            Log.d(jm.o, this.p + StringFog.decrypt("stzRhNP/EScPJTYmBiwTDA==") + q());
        }
    }

    @Override // defpackage.fn
    public void j() {
    }

    @Override // defpackage.lm
    protected String n() {
        return r;
    }

    @Override // defpackage.fn
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Integer e(Void... voidArr) {
        ua2 ua2Var;
        long j;
        long j2;
        long j3;
        if (g()) {
            return this.h;
        }
        if (this.a != null) {
            long W = h91.Q().W();
            long currentTimeMillis = System.currentTimeMillis();
            long abs = Math.abs(currentTimeMillis - W);
            long w = w(-1L);
            if (abs < 240000) {
                w = 0;
                j3 = 0;
                j2 = 0;
            } else {
                if (w > 0) {
                    j = 0;
                } else {
                    w = (new Random().nextInt(901) + 100) * 1048576;
                    j = w;
                }
                j2 = j;
                j3 = w;
            }
            z(w);
            double nextDouble = new Random().nextInt(2) > 0 ? 1.0d - (new Random().nextDouble() * 0.10000000149011612d) : (new Random().nextDouble() * 0.10000000149011612d) + 1.0d;
            long j4 = (long) (j3 * nextDouble);
            if (this.i) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(StringFog.decrypt("Gh5pBgFXeTtdOj59ERY="), Locale.getDefault());
                Log.d(jm.o, this.p + StringFog.decrypt("d7X/54Lnt5rw47rd9lg=") + String.format(StringFog.decrypt("cn11BILQow=="), Double.valueOf(abs / 1000.0d)) + StringFog.decrypt("d7Tb/YDZr5bowbbH3lg=") + mr0.a((float) j4, 2) + StringFog.decrypt("f7bJ/Q==") + mr0.a((float) j3, 2) + StringFog.decrypt("d7XyzID9mQ==") + String.format(StringFog.decrypt("cn11BA=="), Double.valueOf(nextDouble)) + StringFog.decrypt("fnOu+OqRrcmC1+96") + mr0.a((float) j2, 2) + StringFog.decrypt("d7T78YDaqZbn624=") + mr0.a((float) w, 2) + StringFog.decrypt("d7TJ0oDrmZXw4brQ1lg=") + simpleDateFormat.format(Long.valueOf(currentTimeMillis)) + StringFog.decrypt("d7f/6IPbkJXw4brQ1lg=") + simpleDateFormat.format(Long.valueOf(W)));
            }
            if (j4 > 0) {
                l91 l91Var = new l91(null, 100);
                l91Var.f(j4);
                ua2Var = this;
                l91Var.d(ua2Var.a.getString(R.string.clean_item_title2));
                ua2Var.l(l91Var);
            } else {
                ua2Var = this;
            }
        } else {
            ua2Var = this;
        }
        return ua2Var.f1903g;
    }

    @Override // defpackage.fn
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void i(Integer num) {
        if (g()) {
            return;
        }
        if (this.i) {
            Log.d(jm.o, this.p + mr0.a((float) this.q, 2));
        }
        if (this.n == null || g()) {
            return;
        }
        this.n.d(new b91(this.q, this.m, 100));
    }

    @Override // defpackage.fn
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void k(gm... gmVarArr) {
        gm gmVar;
        if (g() || (gmVar = gmVarArr[0]) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(gmVar);
        this.q += gmVar.c();
        if (this.n == null || g()) {
            return;
        }
        this.n.e(gmVar);
    }
}
