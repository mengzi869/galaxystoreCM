package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

/* loaded from: classes2.dex */
public abstract class fn<Params, Progress, Result> {
    protected static final boolean f = false;//af1.b();
    protected Context a;
    private boolean b;
    private boolean c;
    private final Handler d = new Handler(Looper.getMainLooper());
    protected a e;

    /* loaded from: classes2.dex */
    public interface a<Params, Progress, Result> {
        void a(Progress... progressArr);
    }

    public fn(Context context) {
        this.a = context;
    }

    public void a(a<Params, Progress, Result> aVar) {
        this.e = aVar;
    }

    @MainThread
    protected abstract void b();

    @MainThread
    protected abstract void c();

    public void d() {
        boolean z = !g();
        this.b = true;
        if (h() || !z) {
            return;
        }
        this.d.post(new Runnable() { // from class: dn
            @Override // java.lang.Runnable
            public final void run() {
                fn.this.b();
            }
        });
    }

    @WorkerThread
    public abstract Result e(Params... paramsArr);

    public void f() {
        boolean z = !h();
        this.c = true;
        if (z) {
            this.d.post(new Runnable() { // from class: en
                @Override // java.lang.Runnable
                public final void run() {
                    fn.this.c();
                }
            });
        }
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.c;
    }

    @MainThread
    public abstract void i(Result result);

    @MainThread
    public void j() {
    }

    @MainThread
    public abstract void k(Progress... progressArr);

    @WorkerThread
    protected void l(Progress... progressArr) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(progressArr);
        }
    }
}