package com.clean888.cleansuper.cleaner.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.R;

/* loaded from: classes2.dex */
public class ZZJ extends View {
    private int a;
    private Context b;
    private int c;
    private int d;
    private Paint f;

    /* loaded from: classes2.dex */
    public enum enumType {
        BOOST,
        CLEAN,
        BATTERY,
        CPU
    }

    public ZZJ(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.f = new Paint();
        this.b = context;
    }

    private int b(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    private void c(int i, enumType aVar) {
        if (aVar == enumType.BATTERY) {
            if (i < 50) {
                this.c = R.mipmap.icon_batter_widget;
                this.a = Color.parseColor("#FF9C2A");
            } else {
                this.c = R.mipmap.icon_batter_widget;
                this.a = Color.parseColor("#ffffff");
            }
        } else if (aVar == enumType.BOOST) {
            if (i < 50) {
                this.c = R.mipmap.icon_boost_widget;
                this.a = Color.parseColor("#ffffff");
            } else {
                this.c = R.mipmap.icon_boost_widget;
                this.a = Color.parseColor("#FF9C2A");
            }
        } else if (aVar == enumType.CLEAN) {
            if (i < 50) {
                this.c = R.mipmap.icon_clean_widget;
                this.a = Color.parseColor("#ffffff");
            } else {
                this.c = R.mipmap.icon_clean_widget;
                this.a = Color.parseColor("#FF9C2A");
            }
        } else if (aVar == enumType.CPU) {
            if (i < 50) {
                this.c = R.mipmap.icon_cpu_widget;
                this.a = Color.parseColor("#ffffff");
            } else {
                this.c = R.mipmap.icon_cpu_widget;
                this.a = Color.parseColor("#FF9C2A");
            }
        }
        this.f.setAntiAlias(true);
        this.f.setColor(Color.parseColor("#4DFFFFFF"));
        this.f.setStrokeWidth(b(5));
    }

    public void a(int i, enumType aVar) {
        this.d = i;
        c(i, aVar);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f.setStyle(Paint.Style.STROKE);
        float b = b(5);
        canvas.drawArc(b, b, getWidth() - b(5), getHeight() - b(5), 0.0f, 360.0f, false, this.f);
        this.f.setColor(this.a);
        float f = (this.d / 100.0f) * 360.0f;
        float b2 = b(5);
        canvas.drawArc(b2, b2, getWidth() - b(5), getHeight() - b(5), 270.0f - f, f, false, this.f);
        canvas.drawBitmap(BitmapFactory.decodeResource(this.b.getResources(), this.c), (Rect) null, new Rect(getLeft() + b(10), getTop() + b(10), getRight() - b(10), getBottom() - b(10)), this.f);
    }
}
