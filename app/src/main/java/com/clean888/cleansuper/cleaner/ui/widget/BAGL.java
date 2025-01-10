package com.clean888.cleansuper.cleaner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.vh0;
import com.clean888.cleansuper.cleaner.utils.vi;
import com.clean888.cleansuper.cleaner.service.BAAU;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class BAGL extends View {
    public final float a;
    public final Rect b;
    public final e c;
    public final List<Bitmap> d;
    public final Rect f;

    /* renamed from: g, reason: collision with root package name */
    public final RectF f90g;
    public final Paint h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public float n;
    public final float o;
    public float p;
    public final float q;
    public float r;
    public final long s;
    public ValueAnimator t;
    public ValueAnimator u;
    public final String v;
    public final String w;
    public final int x;
    public final int y;

    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            BAGL.c(BAGL.this, valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BAGL bagl = BAGL.this;
            bagl.n = bagl.o;
        }
    }

    /* loaded from: classes2.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            BAGL.a(BAGL.this, valueAnimator);
        }
    }

    /* loaded from: classes2.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BAGL.b(BAGL.this);
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    public BAGL(Context context, AttributeSet attributeSet, e eVar) {
        super(context, null);
        float b2;
        Rect rect = new Rect();
        this.f = rect;
        Paint paint = new Paint();
        this.h = paint;
        this.p = 1.0f;
        this.s = 500L;
        this.x = -1;
        this.y = ViewCompat.MEASURED_STATE_MASK;
        this.c = eVar;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 30) {
            Object systemService = context.getSystemService(Context.WINDOW_SERVICE);
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Rect bounds = ((WindowManager) systemService).getCurrentWindowMetrics().getBounds();
            point.x = bounds.width();
            point.y = bounds.height();
        } else {
            Object systemService2 = context.getSystemService(Context.WINDOW_SERVICE);
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService2).getDefaultDisplay().getRealSize(point);
        }
        int b3 = vh0.b(40);
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_wallpaper_back), b3, b3, true));
        arrayList.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_wallpaper_fan), b3, b3, true));
        arrayList.add(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_wallpaper_rocket), b3, b3, true));
        int i = point.x;
        this.j = i;
        this.i = point.y;
        paint.setAntiAlias(true);
        this.k = 0;
//        d(getContext());
        int statusBarHeight = getStatusBarHeight();
        this.l = statusBarHeight;
        rect.left = (int) (i - ((((Bitmap) arrayList.get(0)).getWidth() * 2.0d) / 3.0d));
//        rect.top = ((int) (((r14 - 0) * 0.6f) - (((Bitmap) arrayList.get(0)).getHeight() / 2))) - statusBarHeight;
        rect.top = ((int) (((j - 0) * 0.6f) - (((Bitmap) arrayList.get(0)).getHeight() / 2))) - statusBarHeight;
        rect.right = ((Bitmap) arrayList.get(0)).getWidth() + rect.left;
        rect.bottom = ((Bitmap) arrayList.get(0)).getHeight() + rect.top;
        int height = rect.height();
        int i2 = vi.a - statusBarHeight;
        rect.top = i2;
        rect.bottom = i2 + height;
//        this.f90g = new RectF(rect.left - 5.0f, rect.top - 5.0f, vh0.b(99) + r12 + 50.0f, rect.bottom + 5.0f);
        this.f90g = new RectF(rect.left - 5.0f, rect.top - 5.0f,rect.right + 50.0f + vh0.b(99) , rect.bottom + 5.0f);
        this.m = ((rect.bottom - rect.top) + 10) / 2;
        float b4 = vh0.b(99) - ((((Bitmap) arrayList.get(0)).getWidth() * 2.0f) / 3.0f);
        this.o = b4;
        this.q = 0.64f;
        this.p = 0.64f;
        Rect rect2 = new Rect(rect);
        this.b = rect2;
        rect2.top -= 20;
        rect2.left = (rect2.left - ((int) b4)) - 20;
        rect2.right += 20;
        rect2.bottom += 20;
        this.v = getResources().getString(R.string.wallpaper_quick);
        this.w = getResources().getString(R.string.wallpaper_boost);
        if (vh0.b(14) > (rect.width() / 2.0f) - 2.0f) {
            b2 = (rect.width() / 2.0f) - 2.0f;
        } else {
            b2 = vh0.b(14);
        }
        this.a = b2;
        paint.setColor(-1);
        paint.setTextSize(b2);
        paint.setTypeface(Typeface.DEFAULT);
    }

    public static final void a(BAGL bagl, ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedValue() != null) {
            bagl.r = (Integer) valueAnimator.getAnimatedValue();
            bagl.postInvalidate();
        }
    }

    public static final void b(BAGL bagl) {
        bagl.getBlock().a();
    }

    public static final void c(BAGL bagl, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            bagl.n = ((Float) animatedValue).floatValue() * bagl.o;
            bagl.postInvalidate();
        }
    }

    private final int getStatusBarHeight() {
        Resources resources = getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:

        if (r0.equalsIgnoreCase("OPPO") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */

    public final List<Bitmap> getBitmap() {
        return this.d;
    }

    public final e getBlock() {
        return this.c;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BAAU.a(this.u);
        BAAU.a(this.t);
        this.u = null;
        this.t = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.clipRect(this.b);
            canvas.save();
            canvas.translate(-this.n, 0.0f);
            this.h.setColor(ViewCompat.MEASURED_STATE_MASK);
            RectF rectF = this.f90g;
            float f = this.m;
            canvas.drawRoundRect(rectF, f, f, this.h);
            this.h.setColor(-1);
            String str = this.v;
            Rect rect = this.f;
            canvas.drawText(str, rect.right + 10.0f, rect.top + this.a, this.h);
            String str2 = this.w;
            Rect rect2 = this.f;
            canvas.drawText(str2, rect2.right + 10.0f, rect2.centerY() + this.a, this.h);
            Rect rect3 = this.f;
            canvas.drawBitmap(getBitmap().get(0), rect3.left, rect3.top, this.h);
            canvas.save();
            canvas.translate(this.f.centerX(), this.f.centerY());
            canvas.rotate(this.r);
            canvas.drawBitmap(getBitmap().get(1), (-getBitmap().get(1).getWidth()) / 2.0f, (-getBitmap().get(1).getHeight()) / 2.0f, this.h);
            canvas.restore();
            canvas.save();
            canvas.translate(this.f.centerX(), this.f.centerY());
            float f2 = this.p;
            canvas.scale(f2, f2);
            canvas.drawBitmap(getBitmap().get(2), (-getBitmap().get(2).getWidth()) / 2.0f, (-getBitmap().get(2).getHeight()) / 2.0f, this.h);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            if (this.u == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setRepeatCount(0);
                ofFloat.setDuration(400L);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new a());
                ofFloat.addListener(new b());
                ofFloat.start();
                this.u = ofFloat;
            }
            if (this.t == null) {
                ValueAnimator ofInt = ObjectAnimator.ofInt(0, 359);
                ofInt.setRepeatCount(-1);
                ofInt.setDuration(500L);
                ofInt.setInterpolator(new LinearInterpolator());
                ofInt.addUpdateListener(new c());
                ofInt.start();
                this.t = ofInt;
                postDelayed(new d(), 1500L);
            }
        }
    }
}