package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.clean888.cleansuper.cleaner.SuperApplication;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class BAFC {
    private static final String a0 = System.getProperty("line.separator");
    private String A;
    private Typeface B;
    private Layout.Alignment C;
    private int D;
    private ClickableSpan E;
    private String F;
    private float G;
    private BlurMaskFilter.Blur H;
    private Shader I;
    private float J;
    private float K;
    private float L;
    private int M;
    private Object[] N;
    private Bitmap O;
    private Drawable P;
    private Uri Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private g V;
    private int W;
    private final int X;
    private final int Y;
    private final int Z;
    private TextView a;
    private CharSequence b;
    private int c;
    private int d;
    private int e;
    private int f;

    /* renamed from: g, reason: collision with root package name */
    private int f89g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private float r;
    private float s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ParcelCreator"})
    /* loaded from: classes2.dex */
    public static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface a;

        private void a(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            a(textPaint, this.a);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            a(textPaint, this.a);
        }

        private CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.a = typeface;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements LeadingMarginSpan {
        private final int a;
        private final int b;
        private final int c;
        private Path d;

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i6) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setColor(this.a);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.d == null) {
                        Path path = new Path();
                        this.d = path;
                        path.addCircle(0.0f, 0.0f, this.b, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate(i + (i2 * this.b), (i3 + i5) / 2.0f);
                    canvas.drawPath(this.d, paint);
                    canvas.restore();
                } else {
//                    canvas.drawCircle(i + (i2 * r10), (i3 + i5) / 2.0f, this.b, paint);
                }
                paint.setColor(color);
                paint.setStyle(style);
            }
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return (this.b * 2) + this.c;
        }

        private b(int i, int i2, int i3) {
            this.d = null;
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* loaded from: classes2.dex */
    static abstract class c extends ReplacementSpan {
        final int a;
        private WeakReference<Drawable> b;

        private Drawable a() {
            WeakReference<Drawable> weakReference = this.b;
            Drawable drawable = weakReference != null ? weakReference.get() : null;
            if (drawable != null) {
                return drawable;
            }
            Drawable b = b();
            this.b = new WeakReference<>(b);
            return b;
        }

        public abstract Drawable b();

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            int height = 0;
            float height2;
            Drawable a = a();
            Rect bounds = a.getBounds();
            canvas.save();
            if (bounds.height() < i5 - i3) {
                int i6 = this.a;
                if (i6 == 3) {
                    height2 = i3;
                } else {
                    if (i6 == 2) {
                        height = ((i5 + i3) - bounds.height()) / 2;
                    } else if (i6 == 1) {
                        height2 = i4 - bounds.height();
                    } else {
                        height = i5 - bounds.height();
                    }
                    height2 = height;
                }
                canvas.translate(f, height2);
            } else {
                canvas.translate(f, i3);
            }
            a.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            int i3;
            Rect bounds = a().getBounds();
            if (fontMetricsInt != null && (i3 = fontMetricsInt.bottom - fontMetricsInt.top) < bounds.height()) {
                int i4 = this.a;
                if (i4 == 3) {
                    fontMetricsInt.top = fontMetricsInt.top;
                    fontMetricsInt.bottom = bounds.height() + fontMetricsInt.top;
                } else if (i4 == 2) {
                    int i5 = i3 / 4;
                    fontMetricsInt.top = ((-bounds.height()) / 2) - i5;
                    fontMetricsInt.bottom = (bounds.height() / 2) - i5;
                } else {
                    int i6 = -bounds.height();
                    int i7 = fontMetricsInt.bottom;
                    fontMetricsInt.top = i6 + i7;
                    fontMetricsInt.bottom = i7;
                }
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
            return bounds.right;
        }

        private c(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e implements LineHeightSpan {
        static Paint.FontMetricsInt c;
        private final int a;
        final int b;

        e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            Paint.FontMetricsInt fontMetricsInt2 = c;
            if (fontMetricsInt2 == null) {
                Paint.FontMetricsInt fontMetricsInt3 = new Paint.FontMetricsInt();
                c = fontMetricsInt3;
                fontMetricsInt3.top = fontMetricsInt.top;
                fontMetricsInt3.ascent = fontMetricsInt.ascent;
                fontMetricsInt3.descent = fontMetricsInt.descent;
                fontMetricsInt3.bottom = fontMetricsInt.bottom;
                fontMetricsInt3.leading = fontMetricsInt.leading;
            } else {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
                fontMetricsInt.leading = fontMetricsInt2.leading;
            }
            int i5 = this.a;
            int i6 = fontMetricsInt.descent;
            int i7 = fontMetricsInt.ascent;
            int i8 = i5 - (((i4 + i6) - i7) - i3);
            if (i8 > 0) {
                int i9 = this.b;
                if (i9 == 3) {
                    fontMetricsInt.descent = i6 + i8;
                } else if (i9 == 2) {
                    int i10 = i8 / 2;
                    fontMetricsInt.descent = i6 + i10;
                    fontMetricsInt.ascent = i7 - i10;
                } else {
                    fontMetricsInt.ascent = i7 - i8;
                }
            }
            int i11 = fontMetricsInt.bottom;
            int i12 = fontMetricsInt.top;
            int i13 = i5 - (((i4 + i11) - i12) - i3);
            if (i13 > 0) {
                int i14 = this.b;
                if (i14 == 3) {
                    fontMetricsInt.bottom = i11 + i13;
                } else if (i14 == 2) {
                    int i15 = i13 / 2;
                    fontMetricsInt.bottom = i11 + i15;
                    fontMetricsInt.top = i12 - i15;
                } else {
                    fontMetricsInt.top = i12 - i13;
                }
            }
            if (i2 == ((Spanned) charSequence).getSpanEnd(this)) {
                c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f implements LeadingMarginSpan {
        private final int a;
        private final int b;
        private final int c;

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.a);
            canvas.drawRect(i, i3, i + (this.b * i2), i5, paint);
            paint.setStyle(style);
            paint.setColor(color);
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return this.b + this.c;
        }

        private f(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g extends SpannableStringBuilder implements Serializable {
        private g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h extends CharacterStyle implements UpdateAppearance {
        private Shader a;

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.a);
        }

        private h(Shader shader) {
            this.a = shader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i extends CharacterStyle implements UpdateAppearance {
        private float a;
        private float b;
        private float c;
        private int d;

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.a, this.b, this.c, this.d);
        }

        private i(float f, float f2, float f3, int i) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class j extends ReplacementSpan {
        private final int a;
        private final Paint b;

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            canvas.drawRect(f, i3, f + this.a, i5, this.b);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            return this.a;
        }

        private j(int i, int i2) {
            Paint paint = new Paint();
            this.b = paint;
            this.a = i;
            paint.setColor(i2);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class k extends ReplacementSpan {
        final int a;

        k(int i) {
            this.a = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i, i2);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), paint);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(charSequence.subSequence(i, i2).toString());
        }
    }

    private BAFC(TextView textView) {
        this();
        this.a = textView;
    }

    private void d(int i2) {
        e();
        this.W = i2;
    }

    private void e() {
        int i2 = this.W;
        if (i2 == 0) {
            j();
        } else if (i2 == 1) {
            k();
        } else if (i2 == 2) {
            l();
        }
        g();
    }

    private void g() {
        this.c = 33;
        this.d = -16777217;
        this.e = -16777217;
        this.f = -1;
        this.h = -16777217;
        this.k = -1;
        this.m = -16777217;
        this.p = -1;
        this.r = -1.0f;
        this.s = -1.0f;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = -1;
        this.E = null;
        this.F = null;
        this.G = -1.0f;
        this.I = null;
        this.J = -1.0f;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.T = -1;
    }

    private void j() {
        if (this.b.length() == 0) {
            return;
        }
        int length = this.V.length();
        if (length == 0 && this.f != -1) {
            this.V.append((CharSequence) Character.toString((char) 2)).append((CharSequence) "\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
            length = 2;
        }
        this.V.append(this.b);
        int length2 = this.V.length();
        if (this.D != -1) {
            this.V.setSpan(new k(this.D), length, length2, this.c);
        }
        if (this.d != -16777217) {
            this.V.setSpan(new ForegroundColorSpan(this.d), length, length2, this.c);
        }
        if (this.e != -16777217) {
            this.V.setSpan(new BackgroundColorSpan(this.e), length, length2, this.c);
        }
        if (this.k != -1) {
            this.V.setSpan(new LeadingMarginSpan.Standard(this.k, this.l), length, length2, this.c);
        }
        int i2 = this.h;
        if (i2 != -16777217) {
            this.V.setSpan(new f(i2, this.i, this.j), length, length2, this.c);
        }
        int i3 = this.m;
        if (i3 != -16777217) {
            this.V.setSpan(new b(i3, this.n, this.o), length, length2, this.c);
        }
        if (this.p != -1) {
            this.V.setSpan(new AbsoluteSizeSpan(this.p, this.q), length, length2, this.c);
        }
        if (this.r != -1.0f) {
            this.V.setSpan(new RelativeSizeSpan(this.r), length, length2, this.c);
        }
        if (this.s != -1.0f) {
            this.V.setSpan(new ScaleXSpan(this.s), length, length2, this.c);
        }
        int i4 = this.f;
        if (i4 != -1) {
            this.V.setSpan(new e(i4, this.f89g), length, length2, this.c);
        }
        if (this.t) {
            this.V.setSpan(new StrikethroughSpan(), length, length2, this.c);
        }
        if (this.u) {
            this.V.setSpan(new UnderlineSpan(), length, length2, this.c);
        }
        if (this.v) {
            this.V.setSpan(new SuperscriptSpan(), length, length2, this.c);
        }
        if (this.w) {
            this.V.setSpan(new SubscriptSpan(), length, length2, this.c);
        }
        if (this.x) {
            this.V.setSpan(new StyleSpan(1), length, length2, this.c);
        }
        if (this.y) {
            this.V.setSpan(new StyleSpan(2), length, length2, this.c);
        }
        if (this.z) {
            this.V.setSpan(new StyleSpan(3), length, length2, this.c);
        }
        if (this.A != null) {
            this.V.setSpan(new TypefaceSpan(this.A), length, length2, this.c);
        }
        if (this.B != null) {
            this.V.setSpan(new CustomTypefaceSpan(this.B), length, length2, this.c);
        }
        if (this.C != null) {
            this.V.setSpan(new AlignmentSpan.Standard(this.C), length, length2, this.c);
        }
        ClickableSpan clickableSpan = this.E;
        if (clickableSpan != null) {
            this.V.setSpan(clickableSpan, length, length2, this.c);
        }
        if (this.F != null) {
            this.V.setSpan(new URLSpan(this.F), length, length2, this.c);
        }
        if (this.G != -1.0f) {
            this.V.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.G, this.H)), length, length2, this.c);
        }
        if (this.I != null) {
            this.V.setSpan(new h(this.I), length, length2, this.c);
        }
        if (this.J != -1.0f) {
            this.V.setSpan(new i(this.J, this.K, this.L, this.M), length, length2, this.c);
        }
        Object[] objArr = this.N;
        if (objArr != null) {
            for (Object obj : objArr) {
                this.V.setSpan(obj, length, length2, this.c);
            }
        }
    }

    private void k() {
        int length = this.V.length();
        this.b = "<img>";
        j();
        int length2 = this.V.length();
        if (this.O != null) {
            this.V.setSpan(new d(this.O, this.S), length, length2, this.c);
            return;
        }
        if (this.P != null) {
            this.V.setSpan(new d(this.P, this.S), length, length2, this.c);
        } else if (this.Q != null) {
            this.V.setSpan(new d(this.Q, this.S), length, length2, this.c);
        } else if (this.R != -1) {
            this.V.setSpan(new d(this.R, this.S), length, length2, this.c);
        }
    }

    private void l() {
        int length = this.V.length();
        this.b = "< >";
        j();
        this.V.setSpan(new j(this.T, this.U), length, this.V.length(), this.c);
    }

    public static BAFC m(TextView textView) {
        return new BAFC(textView);
    }

    public BAFC a(@NonNull CharSequence charSequence) {
        d(0);
        this.b = charSequence;
        return this;
    }

    public BAFC b(@DrawableRes int i2) {
        return c(i2, 0);
    }

    public BAFC c(@DrawableRes int i2, int i3) {
        d(1);
        this.R = i2;
        this.S = i3;
        return this;
    }

    public SpannableStringBuilder f() {
        e();
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(this.V);
        }
        return this.V;
    }

    public BAFC h(@IntRange(from = 0) int i2, boolean z) {
        this.p = i2;
        this.q = z;
        return this;
    }

    public BAFC i(@ColorInt int i2) {
        this.d = i2;
        return this;
    }

    public BAFC() {
        this.X = 0;
        this.Y = 1;
        this.Z = 2;
        this.V = new g();
        this.b = "";
        this.W = -1;
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d extends c {
        private Drawable c;
        private Uri d;
        private int f;

        @Override // bfj.ckdk.wazpqdu.cjzk.vpfgiz.BAFC.c
        public Drawable b() {
            Drawable drawable;
            InputStream openInputStream = null;
            BitmapDrawable bitmapDrawable = null;
            Drawable drawable2 = this.c;
            if (drawable2 != null) {
                return drawable2;
            }
            BitmapDrawable bitmapDrawable2 = null;
            if (this.d != null) {
                try {
                    openInputStream = SuperApplication.getContext().getContentResolver().openInputStream(this.d);
                    bitmapDrawable = new BitmapDrawable(SuperApplication.getContext().getResources(), BitmapFactory.decodeStream(openInputStream));
                } catch (Exception e) {
                 //   e = e;
                }
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    return bitmapDrawable;
                } catch (Exception e2) {
                //    e = e2;
                    bitmapDrawable2 = bitmapDrawable;
//                    Log.e("sms", "Failed to loaded content " + this.d, e);
                    return bitmapDrawable2;
                }
            }
            try {
                drawable = ContextCompat.getDrawable(SuperApplication.getContext(), this.f);
            } catch (Exception unused) {
                drawable = null;
            }
            try {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            } catch (Exception unused2) {
                Log.e("sms", "Unable to find resource: " + this.f);
                return drawable;
            }

//            return null;
        }

        private d(Bitmap bitmap, int i) {
            super(i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(SuperApplication.getContext().getResources(), bitmap);
            this.c = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), this.c.getIntrinsicHeight());
        }

        private d(Drawable drawable, int i) {
            super(i);
            this.c = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.c.getIntrinsicHeight());
        }

        private d(Uri uri, int i) {
            super(i);
            this.d = uri;
        }

        private d(@DrawableRes int i, int i2) {
            super(i2);
            this.f = i;
        }
    }
}
