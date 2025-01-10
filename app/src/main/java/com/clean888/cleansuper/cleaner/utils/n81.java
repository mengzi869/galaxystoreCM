package com.clean888.cleansuper.cleaner.utils;

import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes2.dex */
public class n81 extends m81 {
    private int k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private String p;

    public n81(@Nullable File file, int i) {
        super(file, i);
    }

    public void A(boolean z) {
        this.o = z;
    }

    public void B(String str) {
        this.n = str;
    }

    public void C(String str) {
        this.l = str;
    }

    public void D(String str) {
        this.m = str;
    }

    public void E(int i) {
        this.k = i;
    }

    public void F(String str) {
        this.p = str;
    }

    @Override // defpackage.m81, defpackage.gm
    public boolean h() {
        return ar0.c(b());
    }

    public String u() {
        return this.n;
    }

    public String v() {
        return this.l;
    }

    public String w() {
        return this.m;
    }

    public int x() {
        return this.k;
    }

    public String y() {
        return this.p;
    }

    public boolean z() {
        return this.o;
    }
}
