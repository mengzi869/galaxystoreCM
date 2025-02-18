package com.clean888.cleansuper.cleaner.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.databinding.FragmentSplashBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAFF;
import com.clean888.overseas.topon.InterstitialAdHelper;
import com.clean888.overseas.util.adCallback;
import com.clean888.overseas.util.y3;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class BAFI extends BaseFragment{
    public String analyRearch;
    private ValueAnimator animator = ValueAnimator.ofInt(0, 1000);
    private FragmentSplashBinding binding;
    private int goPage;
    private boolean hasGoMain;
    private boolean hasShow;
    private BAFF mViewModel;
    public String packgeName;
    public String sceneType;

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BAFI.this.checkShowAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
//    public class b implements n1 {
//        b() {
//        }
//
//        @Override // defpackage.n1
//        public void onAdClicked(@NonNull y3 y3Var) {
//        }
//
//        @Override // defpackage.n1
//        public void onAdClose(@NonNull y3 y3Var) {
//            BAFI.this.goMain();
//        }
//
//        @Override // defpackage.n1
//        public void onAdLoadFailed(@NonNull y3 y3Var, @NonNull r3 r3Var) {
//        }
//
//        @Override // defpackage.n1
//        public void onAdLoaded(@NonNull y3 y3Var) {
//        }
//
//        @Override // defpackage.n1
//        public void onAdShow(@NonNull y3 y3Var) {
//        }
//
//        @Override // defpackage.n1
//        public void onAdShowFailed(@NonNull y3 y3Var, @NonNull r3 r3Var) {
//            BAFI.this.goMain();
//        }
//
//        @Override // defpackage.n1
//        public void onLoadingClose(int i) {
//        }
//    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Function1<StringBuilder, Unit> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(StringBuilder sb) {
//            sb.append("admob的开屏广告是否准备好：" + uh.f());
//            sb.append("非admob的开屏广告是否准备好：" + vh.f());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(ValueAnimator valueAnimator) {
        this.binding.progressBar.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private adCallback mAdCallback = new adCallback() {
        @Override
        public void onAdClicked(@NotNull y3 y3Var) {

        }

        @Override
        public void onAdClose(@NotNull y3 y3Var) {
            goMain();
        }

        @Override
        public void onAdLoadFailed(@NotNull y3 y3Var) {

        }

        @Override
        public void onAdLoaded(@NotNull y3 y3Var) {

        }

        @Override
        public void onAdShow(@NotNull y3 y3Var) {

        }

        @Override
        public void onAdShowFailed(@NotNull y3 y3Var) {

        }

        @Override
        public void onLoadingClose(int i) {

        }
    };

    private void loadAd() {
        InterstitialAdHelper.getInstance().load(getActivity());
//        b bVar = new b();
//        uh.b(this, bVar);
//        if (!uh.f()) {
//            uh.g(false);
//        }
//        vh.b(this, bVar);
//        if (vh.f()) {
//            return;
//        }
//        vh.g(false);
    }

    public static BAFI newInstance() {
        return new BAFI();
    }

    private static int nCount = 0;
    void checkShowAd() {
//        th.a("启动页", new c());
//        if (uh.f()) {
//            HashMap hashMap = new HashMap();
//            hashMap.put("ext_key1", "fl_0");
//            boolean i = uh.i(hashMap);
//            this.hasShow = i;
//            if (i) {
//                return;
//            }
//            goMain();
//            return;
//        }
//        HashMap hashMap2 = new HashMap();
//        hashMap2.put("ext_key1", "fl_0");
//        boolean i2 = vh.i(hashMap2);
//        this.hasShow = i2;
//        if (i2) {
//            return;
//        }
        //展示广告
        nCount++;
        Log.e("showad","goMain() " + nCount);
        if(nCount <= 3){
            goMain();
            return;
        }
        if(!InterstitialAdHelper.getInstance().showInterstitialAd(getActivity(),mAdCallback)){
            Log.e("showad","splashActivity goMain");
            goMain();
            return;
        }
        nCount = 0;
    }

    void goMain() {
        if (this.hasGoMain) {
            return;
        }
        this.hasGoMain = true;
        if (checkFragmentAlive()) {
            Context context = getContext();
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            sh.e(intent, sh.b(requireActivity().getIntent()));
            sh.c(requireActivity().getIntent());
//            intent.putExtras(requireActivity().getIntent());
//            rh.d(requireActivity().getIntent());
            SplashActivity zzi = (SplashActivity) getActivity();
            int i = zzi.goPage;
            this.goPage = i;
            this.analyRearch = zzi.analyRearch;
            this.sceneType = zzi.sceneType;
            this.packgeName = zzi.packgeName;
            if (i != 0) {
                intent.putExtra(MainActivity.PAGE, i);
                intent.putExtra(MainActivity.PACKAGE, this.packgeName);
                intent.putExtra("analy_rearch", this.analyRearch);
                intent.putExtra("scene_type", this.sceneType);
                intent.putExtras(getActivity().getIntent());
            }
            context.startActivity(intent);
            finishActivity();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        this.binding = FragmentSplashBinding.inflate(layoutInflater);
        this.mViewModel = (BAFF) new ViewModelProvider(this).get(BAFF.class);
        loadAd();
        int i = ((SplashActivity) getActivity()).goPage;
        this.goPage = i;
//        if (i <= 0 && !vh.f() && !uh.f()) {
//            sf a2 = sf.a();
//            if (a2 == null) {
//                a2 = new sf();
//            }
//            this.animator.setDuration(a2.j * 1000);
//        } else {
//            this.animator.setDuration(2000L);
//        }
        this.binding.progressBar.setMax(1000);
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: fg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BAFI.this.lambda$onCreateView$0(valueAnimator);
            }
        });
        this.animator.addListener(new a());
        this.animator.start();
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
//        vh.h(this);
//        vh.d();
//        uh.h(this);
//        uh.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.animator.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.animator.isPaused()) {
            this.animator.resume();
        }
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public void onWindowFocusChanged(boolean z) {
        if (this.hasShow && z) {
            goMain();
        }
    }
}
