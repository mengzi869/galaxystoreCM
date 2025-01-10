package com.clean888.cleansuper.cleaner.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.util.Random;
import com.clean888.cleansuper.cleaner.databinding.FragmentScanBinding;

public class ZZN extends BaseFragment{
    private ValueAnimator animator = ValueAnimator.ofInt(0, 1000);
    private FragmentScanBinding binding;

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ZZN.this.replaceFragment(ZZO.newInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(ValueAnimator valueAnimator) {
        this.binding.progressBar.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public static ZZN newInstance() {
        return new ZZN();
    }

    @SuppressLint("RestrictedApi")
    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(true);
        this.binding = FragmentScanBinding.inflate(layoutInflater);
        this.animator.setDuration(new Random().nextInt(PathInterpolatorCompat.MAX_NUM_POINTS) + 5000);
        this.binding.progressBar.setMax(1000);
        this.animator.addListener(new a());
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p43
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZZN.this.lambda$onCreateView$0(valueAnimator);
            }
        });
        this.animator.start();
//        i4.a().i("s_junkclean_enter").commit();
//        i4.a().i("s_first_scan_animation").commit();
        return this.binding.getRoot();
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}