package com.clean888.cleansuper.cleaner.utils;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class m81 extends gm {
    protected String f;

    /* renamed from: g, reason: collision with root package name */
    protected String f1913g;
    protected long h;
    protected String i;
    protected List<n81> j;

    public m81(@Nullable File file, int i) {
        super(file, i);
        this.j = new ArrayList();
    }

    @Override // defpackage.gm
    public boolean h() {
        List<n81> list = this.j;
        if (list == null) {
            return true;
        }
        Iterator<n81> it = list.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
        return true;
    }

    public String k() {
        return this.f1913g;
    }

    public String l() {
        return this.i;
    }

    public List<n81> m() {
        return this.j;
    }

    public long n() {
        return this.h;
    }

    public String o() {
        return this.f;
    }

    public void p(String str) {
        this.f1913g = str;
    }

    public void q(String str) {
        this.i = str;
    }

    public void r(List<n81> list) {
        this.j = list;
    }

    public void s(long j) {
        this.h = j;
    }

    public void t(String str) {
        this.f = str;
    }
}
