package com.clean888.cleansuper.cleaner.ui.fragment.result;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.animation.BaseAnimation;

public class uc implements BaseAnimation {


    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(View view) {
        float measuredHeight = view.getMeasuredHeight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", measuredHeight, 0.0f);
        ofFloat2.setDuration(800L);
        ofFloat2.setInterpolator(new DecelerateInterpolator(1.3f));
        ofFloat.start();
        ofFloat2.start();
    }

    @Override // defpackage.ol
    @NonNull
    public Animator[] animators(@NonNull final View view) {
        view.setAlpha(0.0f);
        view.postDelayed(new Runnable() { // from class: tc
            @Override // java.lang.Runnable
            public final void run() {
                uc.c(view);
            }
        }, 50L);
        return new Animator[0];
    }

}
