package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class hm<T> extends lm<T> {
    protected List<T> m;
    protected a<T> n;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a();

        void b();

        void c(T t);
    }

    public hm(Context context, List<T> list, a<T> aVar) {
        super(context);
        this.m = list;
        this.n = aVar;
    }

    @Override // defpackage.fn
    protected void b() {
        a<T> aVar = this.n;
        if (aVar != null) {
            aVar.b();
        }
        this.n = null;
    }

    @Override // defpackage.fn
    protected void c() {
        this.n = null;
    }
}