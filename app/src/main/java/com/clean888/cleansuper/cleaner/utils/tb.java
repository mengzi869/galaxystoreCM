package com.clean888.cleansuper.cleaner.utils;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class tb extends vl {
    private List<BaseNode> b;
    public b91 c;

    public tb(b91 b91Var) {
        c(false);
        this.c = b91Var;
        b91Var.b(true);
        b91Var.b = b91Var.a;
        if (b91Var.c != null) {
            this.b = new ArrayList();
            for (gm gmVar : b91Var.c) {
                if (gmVar != null && gmVar.c() > 0) {
                    gmVar.j(true);
                    this.b.add(new lb(this, gmVar));
                }
            }
        }
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return this.b;
    }


    public void d(gm gmVar) {
        List<BaseNode> a;
        if (gmVar == null || (a = getChildNode()) == null) {
            return;
        }
        Iterator<BaseNode> it = a.iterator();
        long j = 0;
        while (it.hasNext()) {
            lb lbVar = (lb) it.next();
            if (lbVar != null && lbVar.a.i()) {
                j += lbVar.a.c();
            }
        }
        b91 b91Var = this.c;
        b91Var.b = j;
        if (j <= 0) {
            b91Var.b(false);
        } else {
            b91Var.b(true);
        }
    }

    public void e() {
        b91 b91Var = this.c;
        b91Var.b = b91Var.a() ? this.c.a : 0L;
    }
}