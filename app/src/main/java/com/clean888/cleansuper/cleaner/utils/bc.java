package com.clean888.cleansuper.cleaner.utils;

import java.util.List;

/* loaded from: classes2.dex */
public class bc {
    public gm a;
    public b91 b;
    public boolean c;

    public bc(gm gmVar, b91 b91Var) {
        this.a = gmVar;
        this.b = b91Var;
    }

    public void a() {
        List<? extends gm> list;
        b91 b91Var = this.b;
        if (b91Var == null || (list = b91Var.c) == null) {
            return;
        }
        long j = 0;
        for (gm gmVar : list) {
            if (gmVar != null && gmVar.i()) {
                j += gmVar.c();
            }
        }
        b91 b91Var2 = this.b;
        b91Var2.b = j;
        if (j <= 0) {
            b91Var2.b(false);
        } else {
            b91Var2.b(true);
        }
    }
}
