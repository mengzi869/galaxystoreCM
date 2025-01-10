package com.clean888.cleansuper.cleaner.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.text.TextUtilsCompat;
import java.text.DecimalFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ZZM extends ProgressBar {
    String a;
    Paint b;

    public ZZM(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(-1);
    }

    public static int b(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    private void setText(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        int max = (i * 100) / getMax();
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.a = "%" + decimalFormat.format(max);
            return;
        }
        this.a = decimalFormat.format(max) + "%";
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        Paint paint = this.b;
        String str = this.a;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.b.setTextSize(b(18));
        canvas.drawText(this.a, (getWidth() / 2) - rect.centerX(), (getHeight() / 2) - rect.centerY(), this.b);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        setText(i);
        super.setProgress(i);
    }

    public ZZM(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
