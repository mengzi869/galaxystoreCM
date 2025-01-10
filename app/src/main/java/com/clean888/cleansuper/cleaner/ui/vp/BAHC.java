package com.clean888.cleansuper.cleaner.ui.vp;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class BAHC implements ViewPager.PageTransformer {
    private static final float DEFAULT_CENTER = 1.0f;
    private float mMinScale;

    public BAHC() {
        this.mMinScale = 0.7f;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotY(height >> 1);
        view.setPivotX(width >> 1);
        view.setPivotY(height / 2.0f);
        view.setPivotX(width / 2.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        if (f < -1.0f) {
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            return;
        }
        if (f > 1.0f) {
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
        } else {
            if (f < 0.0f) {
                float f2 = this.mMinScale;
                float f3 = ((f + 1.0f) * (1.0f - f2)) + f2;
                view.setScaleX(f3);
                view.setScaleY(f3);
                return;
            }
            float f4 = this.mMinScale;
            float f5 = ((1.0f - f) * (1.0f - f4)) + f4;
            view.setScaleX(f5);
            view.setScaleY(f5);
        }
    }

    public BAHC(float f) {
        this.mMinScale = f;
    }
}
