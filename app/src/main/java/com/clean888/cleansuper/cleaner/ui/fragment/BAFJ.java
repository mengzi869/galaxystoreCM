package com.clean888.cleansuper.cleaner.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.FragmentSplashAgreementBinding;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.pc;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fi;
import com.clean888.cleansuper.cleaner.utils.lc;
import com.clean888.cleansuper.cleaner.utils.mc;
import com.clean888.cleansuper.cleaner.utils.rc;
import com.clean888.cleansuper.cleaner.utils.sf;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAFF;
import com.clean888.cleansuper.cleaner.ui.activity.ZZS;
import com.clean888.cleansuper.cleaner.ui.activity.ZZY;
import com.clean888.cleansuper.cleaner.ui.dialog.DialogSdcardRequest;
import com.clean888.cleansuper.cleaner.ui.dialog.dg;
import com.tencent.mmkv.MMKV;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class BAFJ extends BaseFragment implements View.OnClickListener {
    private Animation animation;
    private ValueAnimator animator;
    private FragmentSplashAgreementBinding binding;
    private DialogSdcardRequest dialog;
    private boolean hadNotificationPermission;
    private boolean isLoadingFinish;
    private boolean isPerBgStartActivity;
    private ActivityResultLauncher<String[]> launcher;
    private ActivityResultLauncher<Intent> launcherForPop;
//    private m71 mBackSelfJob;
//    private cg mNotificationRequestDialog;
    private BAFF mViewModel;
    private dg popRequestDialog;
    private final String KEY_TO_CACHE_F_SHOW = "TO_CACHE_F_SHOW";
    private boolean isCheckedStats = true;

    private CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() { // from class: jg
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            BAFJ.this.lambda$new$2(compoundButton, z);
        }
    };
    private Runnable dialogOk1 = new Runnable() { // from class: hg
        @Override // java.lang.Runnable
        public final void run() {
            BAFJ.this.lambda$new$3();
        }
    };
    private Runnable dialogOk = new Runnable() { // from class: mg
        @Override // java.lang.Runnable
        public final void run() {
            BAFJ.this.lambda$new$4();
        }
    };
    private Runnable dialogNo = new Runnable() { // from class: rg
        @Override // java.lang.Runnable
        public final void run() {
            BAFJ.this.lambda$new$5();
        }
    };
    private final ActivityResultCallback<Map<String, Boolean>> resultCallback = new ActivityResultCallback() { // from class: lg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            BAFJ.this.lambda$new$6((Map) obj);
        }
    };
    private final ActivityResultCallback<ActivityResult> resultCallbackPop = new ActivityResultCallback() { // from class: kg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            BAFJ.this.lambda$new$10((ActivityResult) obj);
        }
    };

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (BAFJ.this.checkFragmentAlive()) {
                BAFJ.this.isLoadingFinish = true;
                BAFJ.this.checkFinishLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BAFJ.this.resultCallback.onActivityResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Function1<Boolean, Unit> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            BAFJ.this.resultCallback.onActivityResult(null);
            return null;
        }
    }

    private void StartCheckPopOld() {
        if (MMKV.defaultMMKV().getInt("TO_CACHE_F_SHOW", 0) == 1) {
            MMKV.defaultMMKV().remove("TO_CACHE_F_SHOW");
            // from class: og
// java.lang.Runnable
            ThreadUtils.runOnUiThreadDelayed(() -> BAFJ.this.lambda$StartCheckPopOld$11(), 100L);
        }
    }

    private void back2Self() {
 /*       m71 m71Var = this.mBackSelfJob;
        if (m71Var != null) {
            m71Var.cancel(null);
            this.mBackSelfJob = null;
        }
        this.mBackSelfJob = ii.a(requireActivity());*/
    }

    private void checkEnter() {
        if (mc.m(getActivity(), mc.a(lc.a))) {
            if (bj.r() && bj.f() && ((this.isPerBgStartActivity && !pc.c(getActivity())) || (!this.isPerBgStartActivity && !rc.m(getActivity())))) {
                if (Build.VERSION.SDK_INT >= 34) {
                    showPopOrTopRequestDialog();
                    return;
                } else {
                    go2Scan();
                    return;
                }
            }
            go2Scan();
            return;
        }
        if (showNotificationTipIfNeed()) {
            return;
        }
        this.resultCallback.onActivityResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFinishLoading() {
        if (!this.binding.checkBox.isChecked()) {
            showHand();
            return;
        }
        hideHand();
        if (this.isLoadingFinish) {
            sf a2 = sf.a();
            if (a2 == null) {
                a2 = new sf();
            }
            if (a2.h) {
                checkEnter();
                return;
            }
            this.mViewModel.agreement();
            Intent intent = new Intent(getContext(), (Class<?>) MainActivity.class);
            sh.e(intent, sh.b(requireActivity().getIntent()));
            sh.c(requireActivity().getIntent());
            startActivity(intent);
            finishActivity();
        }
    }

    private void go2Scan() {
        this.mViewModel.agreement();
        Context context = getContext();
        context.startActivity(new Intent(context, (Class<?>) ZZS.class));
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$StartCheckPopOld$11() {
//        boolean m = rc.m(SuperApplication.a());
//        if (this.isPerBgStartActivity) {
//            m = pc.c(SuperApplication.a());
//        }
//        i4.a().i(m ? "i_floating_succeeded" : "i_floating_failed").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$10(ActivityResult activityResult) {
        if (checkFragmentAlive()) {
            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: ig
                @Override // java.lang.Runnable
                public final void run() {
                    BAFJ.this.lambda$new$9();
                }
            }, 1000L);
            go2Scan();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(CompoundButton compoundButton, boolean z) {
        boolean z2;
        if (this.isLoadingFinish && (z2 = this.isCheckedStats)) {
            this.binding.checkBox.setChecked(z2);
        } else {
            this.isCheckedStats = z;
            changeCheckState(true, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3() {
        BAHT.q(requireActivity(), new b(), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4() {
        if (checkFragmentAlive()) {
            FragmentActivity activity = getActivity();
            String[] strArr = lc.a;
            if (mc.m(activity, mc.a(strArr))) {
                go2Scan();
            } else {
                this.launcher.launch(strArr);
//                i4.a().i("s_first_sd").commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5() {
        checkFragmentAlive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(Map map) {
        if (checkFragmentAlive()) {
//            i4.a().i(mc.m(getActivity(), mc.a(lc.a)) ? "c_first_sd_allow" : "c_first_sd_deny").commit();
            if (bj.r() && bj.f() && ((this.isPerBgStartActivity && !pc.c(getActivity())) || (!this.isPerBgStartActivity && !rc.m(getActivity())))) {
                if (Build.VERSION.SDK_INT >= 34) {
                    showPopOrTopRequestDialog();
                    return;
                } else {
                    go2Scan();
                    return;
                }
            }
            go2Scan();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9() {
//        boolean m = rc.m(SuperApplication.a());
//        if (this.isPerBgStartActivity) {
//            m = pc.c(SuperApplication.a());
//        }
        MMKV.defaultMMKV().remove("TO_CACHE_F_SHOW");
//        i4.a().i(m ? "i_floating_succeeded" : "i_floating_failed").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        if (checkFragmentAlive()) {
            CheckAndChangeTextWith(this.binding.privacyPolicy);
            CheckAndChangeTextWith(this.binding.termsOfService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(ValueAnimator valueAnimator) {
        if (checkFragmentAlive()) {
            this.binding.progressBar.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopOrTopRequestDialog$7() {
        if (checkFragmentAlive()) {
//            i4.a().i("c_floating_y").commit();
            if (this.isPerBgStartActivity) {
                if (!pc.h(getActivity(), this.launcherForPop)) {
                    go2Scan();
                    return;
                }
                fi.a();
                ZZY.n(getActivity(), null);
                back2Self();
                return;
            }
            if (!rc.r(getActivity(), this.launcherForPop)) {
                go2Scan();
                return;
            }
            fi.a();
            ZZY.n(getActivity(), null);
            back2Self();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopOrTopRequestDialog$8() {
        if (checkFragmentAlive()) {
//            i4.a().i("c_floating_n").commit();
            go2Scan();
        }
    }

    public static BAFJ newInstance() {
        return new BAFJ();
    }

    private boolean showNotificationTipIfNeed() {
        boolean d = bj.d(requireContext());
        this.hadNotificationPermission = d;
        if (d) {
            return false;
        }
        this.dialogOk1.run();
        return true;
    }

    void CheckAndChangeTextWith(AppCompatTextView appCompatTextView) {
        float f;
        try {
            int lineCount = appCompatTextView.getLineCount();
            String charSequence = appCompatTextView.getText().toString();
            float measureText = appCompatTextView.getPaint().measureText(charSequence, 0, 1);
            if (lineCount == 1) {
                f = appCompatTextView.getPaint().measureText(charSequence, 0, charSequence.length());
            } else if (!charSequence.contains(" ")) {
                appCompatTextView.getPaint().getTextBounds(charSequence, 0, charSequence.length(), new Rect());
//                f = Math.min(r0.width() + (measureText * 1.5f), appCompatTextView.getWidth());

                Rect r0 = new Rect();
                appCompatTextView.getPaint().getTextBounds(charSequence, 0, charSequence.length(), r0);
                f = Math.min(r0.width() + (measureText * 1.5f), appCompatTextView.getWidth());

            } else {
                String[] split = charSequence.split(" ");
                float measureText2 = appCompatTextView.getPaint().measureText(charSequence, 0, split[0].length());
                if (split.length == lineCount) {
                    for (String str : split) {
                        float measureText3 = appCompatTextView.getPaint().measureText(charSequence, 0, str.length());
                        if (measureText3 > measureText2) {
                            measureText2 = measureText3;
                        }
                    }
                } else {
                    int i = 0;
                    for (String str2 : split) {
                        i += str2.length() + 1;
                        if (i > charSequence.length()) {
                            i = charSequence.length();
                        }
                        float measureText4 = appCompatTextView.getPaint().measureText(charSequence, 0, i);
                        if (measureText4 <= appCompatTextView.getWidth() && measureText4 > measureText2) {
                            measureText2 = measureText4;
                        }
                    }
                }
                f = measureText2 >= ((float) appCompatTextView.getWidth()) ? appCompatTextView.getWidth() : measureText2 + (measureText * 1.5f);
            }
            if (f > 0.0f) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) appCompatTextView.getLayoutParams();
                layoutParams.matchConstraintPercentWidth = (f / (appCompatTextView.getWidth() * 1.0f)) * layoutParams.matchConstraintPercentWidth;
                appCompatTextView.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void changeCheckState(boolean z, boolean z2) {
        if (z) {
//            i4.a().i(z2 ? "c_first_choose_y" : "c_first_choose_n").commit();
        }
        this.binding.tips.setVisibility(z2 ? View.INVISIBLE : View.VISIBLE);
        checkFinishLoading();
    }

    void hideHand() {
        this.binding.hand.setVisibility(View.INVISIBLE);
        this.binding.hand.clearAnimation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentSplashAgreementBinding fragmentSplashAgreementBinding = this.binding;
        if (view == fragmentSplashAgreementBinding.privacyPolicy) {
            this.mViewModel.goPrivacyPolicy(getContext());
            return;
        }
        if (view == fragmentSplashAgreementBinding.termsOfService) {
            this.mViewModel.goTermsOfService(getContext());
        } else if (view == fragmentSplashAgreementBinding.checkBoxLy) {
//            fragmentSplashAgreementBinding.checkBox.setChecked(!r3.isChecked());
            fragmentSplashAgreementBinding.checkBox.setChecked(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        statusBarTextDarkLight(false);
        this.mViewModel = (BAFF) new ViewModelProvider(this).get(BAFF.class);
        FragmentSplashAgreementBinding inflate = FragmentSplashAgreementBinding.inflate(layoutInflater);
        this.binding = inflate;
        inflate.privacyPolicy.setOnClickListener(this);
        this.binding.termsOfService.setOnClickListener(this);
        try {
            this.binding.privacyPolicy.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
            this.binding.termsOfService.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.binding.checkBoxLy.setOnClickListener(this);
        this.binding.checkBox.setOnCheckedChangeListener(this.checkListener);
        this.binding.checkBoxLy.postDelayed(new Runnable() { // from class: pg
            @Override // java.lang.Runnable
            public final void run() {
                BAFJ.this.lambda$onCreateView$0();
            }
        }, 50L);
        hideHand();
        this.animation = AnimationUtils.loadAnimation(getContext(), R.anim.splash_hand_anim);
        this.launcher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), this.resultCallback);
        this.launcherForPop = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this.resultCallbackPop);
        this.isPerBgStartActivity = false;
        this.binding.checkBox.setChecked(this.isCheckedStats);
        changeCheckState(false, this.isCheckedStats);
        this.isLoadingFinish = false;
        this.binding.progressBar.setMax(1000);
        this.binding.progressBar.setProgress(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1000);
        this.animator = ofInt;
        ofInt.setDuration(5000L);
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: gg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BAFJ.this.lambda$onCreateView$1(valueAnimator);
            }
        });
        this.animator.addListener(new a());
        this.animator.start();
//        i4.a().i("s_first_agreement").commit();
//        i4.a().i("i_brand").putEbKey1(Build.BRAND).commit();
        StartCheckPopOld();
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            hideHand();
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.animator.removeAllUpdateListeners();
                this.animator.removeAllListeners();
            }
            DialogSdcardRequest egVar = this.dialog;
            if (egVar != null && egVar.isShowing()) {
                this.dialog.dismiss();
            }
            if (this.popRequestDialog != null && this.popRequestDialog.isShowing()) {
                this.popRequestDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     /*   m71 m71Var = this.mBackSelfJob;
        if (m71Var != null) {
            m71Var.cancel(null);
            this.mBackSelfJob = null;
        }*/
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null || !valueAnimator.isPaused()) {
            return;
        }
        this.animator.resume();
    }

    void showHand() {
        if (this.binding.hand.getVisibility() == View.VISIBLE) {
            return;
        }
        this.binding.hand.setVisibility(View.VISIBLE);
        this.binding.hand.startAnimation(this.animation);
    }

    void showPopOrTopRequestDialog() {
        if (Build.VERSION.SDK_INT >= 34 && sf.a().n && bj.d(requireContext())) {
//            md1.d("startPage", "已有通知权限，不走悬浮窗授权逻辑");
            go2Scan();
            return;
        }
        if (this.popRequestDialog == null) {
            this.popRequestDialog = new dg(getContext(), new Runnable() { // from class: ng
                @Override // java.lang.Runnable
                public final void run() {
                    BAFJ.this.lambda$showPopOrTopRequestDialog$7();
                }
            }, new Runnable() { // from class: qg
                @Override // java.lang.Runnable
                public final void run() {
                    BAFJ.this.lambda$showPopOrTopRequestDialog$8();
                }
            });
        }
        if (this.popRequestDialog.isShowing()) {
            return;
        }
        this.popRequestDialog.show();
        MMKV.defaultMMKV().putInt("TO_CACHE_F_SHOW", 1);
//        i4.a().i("s_floating").commit();
    }

    void showSDCardRequestDialog() {
        if (this.dialog == null) {
            this.dialog = new DialogSdcardRequest(getContext(), this.dialogOk, this.dialogNo, false);
        }
        if (this.dialog.isShowing()) {
            return;
        }
        this.dialog.show();
    }
}
