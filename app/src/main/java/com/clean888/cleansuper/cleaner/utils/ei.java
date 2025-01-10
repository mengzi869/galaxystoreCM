package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public abstract class ei {
    WindowManager.LayoutParams a;
    View b;
    Context c;
    WindowManager d;
    private boolean e;
    private boolean f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1776g = false;
    int h = 17;
    int i = 4;
    protected int j = 0;
    protected int k = 0;

    public ei(Context context) {
        this.c = context;
        a();
    }

    @CallSuper
    public void a() {
        if (d()) {
            this.d = (WindowManager) this.c.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        }
    }

    protected void b(int i) {
        if (d()) {
            if (i == 1) {
                this.a = rc.o(this.c, true, true);
            } else if (i == 2) {
                this.a = rc.o(this.c, true, false);
            } else if (i == 3) {
                this.a = rc.o(this.c, false, true);
            } else if (i == 4) {
                this.a = rc.o(this.c, false, false);
            }
            if (this.f1776g) {
                this.a.flags &= -9;
            }
            this.a.gravity = this.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public View c(@NonNull View view) {
        if (!d()) {
            return view;
        }
        this.b = view;
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    protected abstract void e(boolean z, Throwable th);

    @CallSuper
    public void f() {
        if (d()) {
            try {
                View view = this.b;
                if (view == null || this.d == null) {
                    return;
                }
                if (view.isAttachedToWindow()) {
                    this.d.removeView(this.b);
                }
                this.e = false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @CallSuper
    public synchronized void g() {
        View view = null;
        if (!d()) {
            e(false, new Exception("CalledFromWrongThreadException"));
            return;
        }
        try {
            view = this.b;
        } catch (Throwable th) {
//            if (md1.e()) {
                Log.e("AbsFloatBase", "添加悬浮窗失败！！！！！！请检查悬浮窗权限");
//            }
            e(false, th);
        }
        if (view != null) {
            if (this.e) {
                view.setVisibility(View.VISIBLE);
                return;
            }
            b(this.i);
            this.b.setVisibility(View.VISIBLE);
            WindowManager.LayoutParams layoutParams = this.a;
            layoutParams.x = this.j;
            layoutParams.y = this.k;
            this.d.addView(this.b, layoutParams);
            this.e = true;
            e(true, null);
            return;
        }
        throw new IllegalStateException("FloatView can not be null");
    }
}
