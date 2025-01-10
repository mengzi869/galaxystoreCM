package com.clean888.cleansuper.cleaner.utils;

import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes2.dex */
public class rz1 {
    protected String a;
    protected String b;
    protected long c;

    public rz1(@Nullable File file) {
        this.a = "";
        this.b = "";
        if (file == null || !file.exists()) {
            return;
        }
        this.a = file.getName();
        this.b = file.getAbsolutePath();
        this.c = mr0.d(file);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(String str) {
        this.b = str;
    }

    public void f(long j) {
        this.c = j;
    }

    public void g(@Nullable File file) {
        if (file == null || !file.exists()) {
            return;
        }
        this.a = file.getName();
        this.b = file.getAbsolutePath();
        this.c = mr0.d(file);
    }
}
