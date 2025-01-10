package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.util.Log;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class eu extends hm<b91> {
    public static String o = StringFog.decrypt("FD8iAws9RB0MECEoFxU=");

    public eu(Context context, List<b91> list, hm.a<b91> aVar) {
        super(context, list, aVar);
    }

    @Override // defpackage.hm, defpackage.fn
    protected void b() {
        super.b();
        if (af1.b()) {
            Log.d(StringFog.decrypt("FD8iAws9RB0M"), StringFog.decrypt("d3Oi/OaSrc2B79ag8uNNEZbowbXx6kUjWQECNjcOBlg=") + q());
        }
    }

    @Override // defpackage.fn
    public void j() {
    }

    @Override // defpackage.lm
    protected String n() {
        return o;
    }

    @Override // defpackage.fn
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Integer e(Void... voidArr) {
        long j;
        if (g()) {
            return this.h;
        }
        Collection collection = this.m;
        if (collection != null) {
            synchronized (collection) {
                List<b91> list = this.m;
                if (list != null && list.size() > 0) {
                    Iterator it = this.m.iterator();
                    while (it.hasNext()) {
                        b91 b91Var = (b91) it.next();
                        if (b91Var != null) {
                            it.remove();
                            if (b91Var.a()) {
                                if (g()) {
                                    return this.h;
                                }
                                List<? extends gm> list2 = b91Var.c;
                                if (list2 != null) {
                                    Iterator<? extends gm> it2 = list2.iterator();
                                    j = 0;
                                    while (it2.hasNext()) {
                                        if (g()) {
                                            return this.h;
                                        }
                                        gm next = it2.next();
                                        if (!next.i()) {
                                            j += next.c();
                                        } else {
                                            it2.remove();
                                            next.h();
                                        }
                                    }
                                } else {
                                    j = 0;
                                }
                                if (j > 0) {
                                    b91Var.a = j;
                                } else {
                                    b91Var.a = 0L;
                                }
                                l(b91Var);
                            }
                        }
                    }
                }
            }
        }
        return this.f1903g;
    }

    @Override // defpackage.fn
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void i(Integer num) {
        if (af1.b()) {
            Log.d(StringFog.decrypt("FD8iAws9RB0M"), StringFog.decrypt("d3Oi/OaSrc2B79ag8uNNEZbJ27XP8g=="));
        }
        hm.a<b91> aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // defpackage.fn
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void k(b91... b91VarArr) {
        b91 b91Var;
        if (g() || (b91Var = b91VarArr[0]) == null) {
            return;
        }
        if (af1.b()) {
            Log.d(StringFog.decrypt("FD8iAws9RB0M"), StringFog.decrypt("d3Oi/OaSrc2B79ag8uNNESceJzZ9") + b91Var.d);
        }
        hm.a<b91> aVar = this.n;
        if (aVar != null) {
            aVar.c(b91Var);
        }
    }
}
