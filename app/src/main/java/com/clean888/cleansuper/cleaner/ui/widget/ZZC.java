package com.clean888.cleansuper.cleaner.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import com.clean888.cleansuper.cleaner.utils.a_TextViewCanvas;

public class ZZC extends TextView {
    public ZZC(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        a_TextViewCanvas.b(this, canvas);
        super.onDraw(canvas);
    }

    public ZZC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
