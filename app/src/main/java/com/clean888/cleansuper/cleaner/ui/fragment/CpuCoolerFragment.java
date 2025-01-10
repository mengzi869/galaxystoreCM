package com.clean888.cleansuper.cleaner.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentAnimCpuCoolerBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.ViewModel.CpuCoolerViewModel;
import com.clean888.cleansuper.cleaner.ui.dialog.StopDialog;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CpuCoolerFragment extends BaseFragment implements View.OnClickListener {
    private FragmentAnimCpuCoolerBinding binding;
    private boolean keepGoing;
    private Animator.AnimatorListener listener = new AnimListener();
    private CpuCoolerViewModel mViewModel;
    private int pageFrom;
    private StopDialog stopDialog;

    class AnimListener extends AnimatorListenerAdapter {
        AnimListener() {
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (CpuCoolerFragment.this.stopDialog != null && CpuCoolerFragment.this.stopDialog.isShowing()) {
                CpuCoolerFragment.this.keepGoing = true;
            } else {
                CpuCoolerFragment.this.goNextPage();
            }
        }
    }

    public void goNextPage() {
        List<BADJ.c> animShowInfo = this.mViewModel.getAnimShowInfo();
        if (animShowInfo.size() > 0) {
            replaceFragment(new BADJ.b().d(animShowInfo).c(new BADJ.b.a() {
                @Override
                public final Object a() {
                    return BAEY.newInstance(FuncFinishTitleModel.CpuCooler);
                }
            }).a());
        } else {
            replaceFragment(BAEY.newInstance(FuncFinishTitleModel.CpuCooler));
        }
    }

    public static CpuCoolerFragment newInstance() {
        return new CpuCoolerFragment();
    }

    private void showStopDialog() {
        if (this.stopDialog == null) {
            this.stopDialog = new StopDialog(getActivity(), new Runnable() {
                @Override
                public final void run() {
                    finishActivity();
                }
            }, new Runnable() {
                @Override
                public final void run() {
                    if (keepGoing) {
                        goNextPage();
                    }
                }
            });
        }
        if (this.stopDialog.isShowing()) {
            return;
        }
        this.stopDialog.show();
    }

    @Override
    public void onClick(View view) {
        if (view == this.binding.back) {
            showStopDialog();
        }
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        this.mViewModel = (CpuCoolerViewModel) new ViewModelProvider(this).get(CpuCoolerViewModel.class);
        mViewModel.doScan(getContext());
        this.binding = FragmentAnimCpuCoolerBinding.inflate(layoutInflater);
        this.binding.back.setOnClickListener(this);
        this.binding.animBg.addAnimatorListener(this.listener);
        this.binding.animBg.playAnimation();
        ArrayList arrayList = new ArrayList();
        arrayList.add(AnimationUtils.loadAnimation(getContext(), R.anim.cpu_cooler_anim1));
        arrayList.add(AnimationUtils.loadAnimation(getContext(), R.anim.cpu_cooler_anim2));
        arrayList.add(AnimationUtils.loadAnimation(getContext(), R.anim.cpu_cooler_anim3));
        arrayList.add(AnimationUtils.loadAnimation(getContext(), R.anim.cpu_cooler_anim4));
        arrayList.add(AnimationUtils.loadAnimation(getContext(), R.anim.cpu_cooler_anim5));
        arrayList.add(AnimationUtils.loadAnimation(getContext(), R.anim.cpu_cooler_anim6));
        Random random = new Random();
        this.binding.snow1.startAnimation((Animation) arrayList.remove(random.nextInt(arrayList.size())));
        this.binding.snow2.startAnimation((Animation) arrayList.remove(random.nextInt(arrayList.size())));
        this.binding.snow3.startAnimation((Animation) arrayList.remove(random.nextInt(arrayList.size())));
        this.binding.snow4.startAnimation((Animation) arrayList.remove(random.nextInt(arrayList.size())));
        this.binding.snow5.startAnimation((Animation) arrayList.remove(random.nextInt(arrayList.size())));
        this.binding.snow6.startAnimation((Animation) arrayList.remove(random.nextInt(arrayList.size())));

        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(16000L);
        duration.addUpdateListener(valueAnimator -> binding.animBg.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue()));
        duration.start();

        this.pageFrom = getActivity().getIntent().getIntExtra(MainActivity.FROM, 0);
        return this.binding.getRoot();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showStopDialog();
            return true;
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}