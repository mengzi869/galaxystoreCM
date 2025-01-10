package com.clean888.cleansuper.cleaner.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.bj;

/* loaded from: classes2.dex */
public class ZZF extends View {
    private Paint a;
    private Paint b;
    private RectF c;
    private a d;
    private float f;

    /* renamed from: g, reason: collision with root package name */
    private float f94g;
    private int h;
    private int i;
    private float j;
    private float k;
    private float l;
    private int m;
    private float n;
    private TextView o;
    private b p;

    /* loaded from: classes2.dex */
    public class a extends Animation {
        public a() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            ZZF zzf = ZZF.this;
            zzf.n = ((zzf.k * f) * ZZF.this.f) / ZZF.this.f94g;
            if (ZZF.this.p != null) {
                if (ZZF.this.o != null) {
                    ZZF.this.o.setText(ZZF.this.p.b(f, ZZF.this.f, ZZF.this.f94g));
                }
                ZZF.this.p.a(ZZF.this.b, f, ZZF.this.f, ZZF.this.f94g);
            }
            ZZF.this.postInvalidate();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(Paint paint, float f, float f2, float f3);

        String b(float f, float f2, float f3);
    }

    public ZZF(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context, attributeSet);
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.bar_width, R.attr.bg_color, R.attr.progress_color, R.attr.start_angle, R.attr.sweep_angle});
        this.h = obtainStyledAttributes.getColor(2, -16711936);
        this.i = obtainStyledAttributes.getColor(1, -7829368);
        this.j = obtainStyledAttributes.getFloat(3, 0.0f);
        this.k = obtainStyledAttributes.getFloat(4, 360.0f);
        this.l = obtainStyledAttributes.getDimension(0, bj.b(context, 2.0f));
        obtainStyledAttributes.recycle();
        this.f = 0.0f;
        this.f94g = 100.0f;
        this.m = bj.b(context, 24.0f);
        this.c = new RectF();
        Paint paint = new Paint();
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b.setColor(this.h);
        this.b.setAntiAlias(true);
        this.b.setStrokeWidth(this.l);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.a = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.a.setColor(this.i);
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(this.l);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.d = new a();
    }

    private int i(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    public void j(float f, int i) {
        this.f = f;
        this.d.setDuration(i);
        startAnimation(this.d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.c, this.j, this.k, false, this.a);
        canvas.drawArc(this.c, this.j, this.n, false, this.b);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(i(this.m, i), i(this.m, i2));
        setMeasuredDimension(min, min);
        float f = min;
        float f2 = this.l;
        if (f >= f2 * 2.0f) {
            float f3 = f2 / 2.0f;
            float f4 = f - f3;
            this.c.set(f3, f3, f4, f4);
        }
    }

    public void setBGsColor(int i) {
        this.i = i;
        this.a.setColor(i);
        invalidate();
    }

    public void setMaxNum(float f) {
        this.f94g = f;
    }

    public void setOnAnimationListener(b bVar) {
        this.p = bVar;
    }

    public void setProgressColor(int i) {
        this.h = i;
        this.b.setColor(i);
        invalidate();
    }

    public void setTextView(TextView textView) {
        this.o = textView;
    }
}
