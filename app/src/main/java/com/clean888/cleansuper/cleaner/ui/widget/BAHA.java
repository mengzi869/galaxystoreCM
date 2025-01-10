package com.clean888.cleansuper.cleaner.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class BAHA extends View {
    public BAHA(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void requestLayout() {
        try {
            super.requestLayout();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public BAHA(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BAHA(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
