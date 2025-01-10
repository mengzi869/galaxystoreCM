package com.clean888.cleansuper.cleaner.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class a_TextViewCanvas {

    private static void a(TextView textView, Canvas canvas, Drawable drawable, int i) {
        int compoundDrawablePadding = textView.getCompoundDrawablePadding();
        int i2 = -1;
        if (i == 3) {
            i2 = 1;
        } else if (i != 5) {
            if (i == 48) {
                i2 = 1;
            } else if (i != 80) {
                return;
            }
            Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
            canvas.translate(0.0f, (i2 * (textView.getHeight() - (((((fontMetrics.descent - fontMetrics.ascent) + drawable.getIntrinsicHeight()) + compoundDrawablePadding) + textView.getPaddingTop()) + textView.getPaddingBottom()))) / 2.0f);
            return;
        }
        canvas.translate((i2 * (textView.getWidth() - ((((textView.getPaint().measureText(textView.getText().toString()) + drawable.getIntrinsicWidth()) + compoundDrawablePadding) + textView.getPaddingLeft()) + textView.getPaddingRight()))) / 2.0f, 0.0f);
    }

    public static void b(TextView textView, Canvas canvas) {
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (compoundDrawables != null) {
            if (compoundDrawables[0] != null) {
                textView.setGravity(19);
                a(textView, canvas, compoundDrawables[0], 3);
                return;
            }
            if (compoundDrawables[1] != null) {
                textView.setGravity(49);
                a(textView, canvas, compoundDrawables[1], 48);
            } else if (compoundDrawables[2] != null) {
                textView.setGravity(21);
                a(textView, canvas, compoundDrawables[2], 5);
            } else if (compoundDrawables[3] != null) {
                textView.setGravity(81);
                a(textView, canvas, compoundDrawables[3], 80);
            }
        }
    }
}
