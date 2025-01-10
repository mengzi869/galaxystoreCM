package com.clean888.cleansuper.cleaner.utils;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes2.dex */
public class bi implements ValueAnimator.AnimatorUpdateListener {
    private ValueAnimator a;
    private a b;
    private int c;
    private int d;
    private TimeInterpolator f;

    /* renamed from: g, reason: collision with root package name */
    private long f99g;
    private int h = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    public void a() {
        try {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(a aVar) {
        this.b = aVar;
    }

    public void c() {
        if (this.a == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.a = valueAnimator;
            if (this.d < 0) {
                valueAnimator.setRepeatMode(ValueAnimator.RESTART);
            }
            this.a.setRepeatCount(this.d);
            this.a.setInterpolator(this.f);
            this.a.setIntValues(0, this.c);
            this.a.setDuration(this.f99g);
            this.a.addUpdateListener(this);
        }
        ValueAnimator valueAnimator2 = this.a;
        if (valueAnimator2 == null || valueAnimator2.isRunning()) {
            return;
        }
        this.a.start();
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public bi d(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.c = i;
        return this;
    }

    public bi e(long j) {
        if (j <= 0) {
            j = 0;
        }
        this.f99g = j;
        return this;
    }

    public bi f(TimeInterpolator timeInterpolator) {
        if (timeInterpolator == null) {
            timeInterpolator = new LinearInterpolator();
        }
        this.f = timeInterpolator;
        return this;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i = this.h;
        if (intValue <= i) {
            this.h = intValue;
            return;
        }
        if (i != intValue) {
            this.h = intValue;
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}