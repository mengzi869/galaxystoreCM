package com.clean888.cleansuper.cleaner.ui.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.clean888.cleansuper.cleaner.R;

/* loaded from: classes2.dex */
public class ZZH extends View implements ValueAnimator.AnimatorUpdateListener {
    private Paint a;
    private RectF b;
    private RectF c;
    private int d;
    private int f;

    /* renamed from: g, reason: collision with root package name */
    private float f98g;
    private int h;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private float o;
    private ValueAnimator p;

    public ZZH(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 10;
        this.f = 190;
        this.i = true;
        this.k = false;
        this.m = Color.parseColor("#1a000000");
        c(context, attributeSet);
    }

    @SuppressLint("ResourceType")
    private void c(Context context, AttributeSet attributeSet) {
        this.l = -1;
        this.h = b(context, 6.0f);
        this.j = b(getContext(), 2.0f);
        this.n = 10;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Z1);
            this.l = obtainStyledAttributes.getColor(0, -1);
            this.h = obtainStyledAttributes.getDimensionPixelSize(4, b(context, 6.0f));
            this.j = obtainStyledAttributes.getInt(2, 2);
            this.m = obtainStyledAttributes.getColor(1, this.m);
//            this.n = obtainStyledAttributes.getInt(3, 10);
            obtainStyledAttributes.recycle();
        }
        this.o = this.n / 4;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(this.l);
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.h);
        this.a.setStrokeCap(Paint.Cap.ROUND);
    }

    private void e() {
    }

    private void g() {
    }

    public void a() {
        if (isAttachedToWindow()) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(60);
                this.p = ofInt;
                ofInt.setDuration(1000L);
                this.p.setRepeatCount(-1);
                this.p.addUpdateListener(this);
                this.p.start();
                return;
            }
            if (valueAnimator.isRunning()) {
                return;
            }
            this.p.start();
        }
    }

    public int b(Context context, float f) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, f, context.getResources().getDisplayMetrics());
    }

    public void d() {
        e();
        a();
        this.k = true;
        invalidate();
    }

    public void f() {
        g();
        invalidate();
        this.k = false;
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public int getLoadingColor() {
        return this.l;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (isAttachedToWindow()) {
            int i = this.d;
            int i2 = this.n;
            int i3 = i + i2;
            this.d = i3;
            int i4 = this.f + i2;
            this.f = i4;
            if (i3 > 360) {
                this.d = i3 - 360;
            }
            if (i4 > 360) {
                this.f = i4 - 360;
            }
            if (this.i) {
                float f = this.f98g;
                if (f < 160.0f) {
                    this.f98g = f + this.o;
                    invalidate();
                }
            } else {
                float f2 = this.f98g;
                if (f2 > i2) {
                    this.f98g = f2 - (this.o * 2.0f);
                    invalidate();
                }
            }
            float f3 = this.f98g;
            if (f3 >= 160.0f || f3 <= 10.0f) {
                this.i = !this.i;
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.k) {
            return;
        }
        d();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            f();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k) {
            this.a.setColor(this.m);
            canvas.drawArc(this.c, 0.0f, 360.0f, false, this.a);
            canvas.drawArc(this.c, 0.0f, 360.0f, false, this.a);
            this.a.setColor(this.l);
            canvas.drawArc(this.b, this.d, this.f98g, false, this.a);
            canvas.drawArc(this.b, this.f, this.f98g, false, this.a);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f98g = 10.0f;
        int i5 = this.h;
        this.b = new RectF(i5 * 2, i5 * 2, i - (i5 * 2), i2 - (i5 * 2));
        int i6 = this.h;
        int i7 = this.j;
        this.c = new RectF((i6 * 2) + i7, (i6 * 2) + i7, (i - (i6 * 2)) + i7, (i2 - (i6 * 2)) + i7);
    }

    public void setLoadingColor(int i) {
        this.l = i;
    }

    public ZZH(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 10;
        this.f = 190;
        this.i = true;
        this.k = false;
        this.m = Color.parseColor("#1a000000");
        c(context, attributeSet);
    }
}