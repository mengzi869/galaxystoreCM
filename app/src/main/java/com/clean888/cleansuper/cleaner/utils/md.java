package com.clean888.cleansuper.cleaner.utils;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.LinearInterpolator;

/* loaded from: classes2.dex */
public class md {
    private Handler a;
    private long b;
    private long c;
    private long d;
    private long e;
    private ValueAnimator f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1919g;
    private c h;
    private ValueAnimator.AnimatorUpdateListener i;

    /* loaded from: classes2.dex */
    public static class b {
        private TimeInterpolator a = new LinearInterpolator();
        private long b = 300;
        private c c;

        public md d(c cVar) {
            this.c = cVar;
            return new md(this);
        }

        public b e(long j) {
            if (j > 0) {
                this.b = j;
            }
            return this;
        }

        public b f(TimeInterpolator timeInterpolator) {
            if (timeInterpolator != null) {
                this.a = timeInterpolator;
            }
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void OnSizeAnimUIUpdate(long j, long j2, long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.OnSizeAnimUIUpdate(this.c, this.d, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ValueAnimator valueAnimator) {
        Handler handler;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.f1919g) {
            return;
        }
        try {
            long j = this.e;
            if (j > 0) {
                this.c = (long) (((float) j) * floatValue);
                if (this.d >= j) {
                    if (floatValue <= 1.0f) {
                        this.c = j;
                    }
                } else if (floatValue >= 1.0f) {
                    this.c = j;
                }
            } else {
                this.c = (long) (((float) this.d) * floatValue);
                if (floatValue <= 0.0f) {
                    this.c = j;
                }
            }
            if (this.h == null || (handler = this.a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: ld
                @Override // java.lang.Runnable
                public final void run() {
                    md.this.f();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(long j) {
        float f;
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        long j2 = this.c;
        this.d = j2;
        this.e = j;
        float f2 = 1.0f;
        if (0 != j) {
            f2 = (((float) j2) * 1.0f) / ((float) j);
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        this.f.setFloatValues(f2, f);
        this.f.setDuration(this.b);
        this.f.start();
    }

    public void d(long j) {
        this.c = j;
        c(j);
    }

    public void e() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f1919g = true;
    }

    private md(b bVar) {
        this.b = 300L;
        this.i = new ValueAnimator.AnimatorUpdateListener() { // from class: kd
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                md.this.g(valueAnimator);
            }
        };
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f = valueAnimator;
        valueAnimator.setInterpolator(bVar.a);
        this.h = bVar.c;
        this.b = bVar.b;
        this.f.addUpdateListener(this.i);
        this.a = new Handler(Looper.getMainLooper());
    }
}
