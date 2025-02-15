package com.clean888.cleansuper.cleaner.ui.fragment;

import android.animation.Animator;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.databinding.FragmentAnimFinishBinding;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;

import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import com.clean888.cleansuper.cleaner.ui.fragment.result.BAES;
import com.clean888.cleansuper.cleaner.ui.fragment.result.BAEU;
import com.clean888.cleansuper.cleaner.utils.a_NotificationUtils;
import com.clean888.cleansuper.cleaner.ui.dialog.pf;
import com.clean888.overseas.topon.InterstitialAdHelper;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class BAEY extends BaseFragment implements Animator.AnimatorListener, View.OnClickListener {
    private FragmentAnimFinishBinding binding;
    private boolean isOpenStepBtn;
    private FuncFinishTitleModel type;
    private BAEX vm;

    private BAEY(FuncFinishTitleModel ufVar) {
        this.type = ufVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextPage$0(Fragment fragment) {
        if (checkFragmentAlive()) {
            replaceFragment(fragment);
        }
    }

    public static BAEY newInstance(FuncFinishTitleModel ufVar) {
        return new BAEY(ufVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21, types: [bfj.ckdk.wazpqdu.cjzk.ssnwrh.BAEU] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    public void nextPage() {
        L.e("BAEY-Log", "nextPage start");
        if (checkFragmentAlive()) {
            HashMap hashMap = new HashMap();
            hashMap.put("ext_key1", "fl_" + this.type.Id);

            Fragment r1 = null;
            FuncFinishTitleModel ufVar = FuncFinishTitleModel.PhoneBoost;
            FuncFinishTitleModel ufVar2 = this.type;
            boolean z = false;
            if ((ufVar == ufVar2 || FuncFinishTitleModel.Antivirus == ufVar2) && !a_NotificationUtils.isEnable(getContext()) && getContext() != null) {
                L.d("BAEY-Log", "step 1");
                boolean isFirstFinish = this.vm.isFirstFinish(this.type);
                Log.e("BAEY-Log", "nextPage isFirstFinish:" + isFirstFinish);
//                if (md1.e()) {
//                    md1.c("ZZR", "完成页是否有缓存：", Boolean.FALSE, "，是否第一次：", Boolean.valueOf(isFirstFinish));
//                }
                FuncFinishTitleModel ufVar3 = this.type;
                boolean z2 = (ufVar3 == ufVar || ufVar3 == FuncFinishTitleModel.JunkClean || ufVar3 == FuncFinishTitleModel.Antivirus) && pf.c();
                BAES newInstance = BAES.newInstance(this.type);
                newInstance.setShowEvaluate(z2);
                if (!z2) {
                    InterstitialAdHelper.getInstance().showInterstitialAd(requireActivity(),null);
//                    if (zh.d()) {
//                        zh.f(hashMap);
//                    } else {
//                        xh.f(hashMap);
//                    }
                }
                r1 = newInstance;
            }
            if (r1 == null) {
                L.d("BAEY-Log", "step a");
                FuncFinishTitleModel ufVar4 = this.type;
                if ((ufVar4 == ufVar || ufVar4 == FuncFinishTitleModel.JunkClean || ufVar4 == FuncFinishTitleModel.Antivirus) && pf.c()) {
                    z = true;
                }
                r1 = BAEU.newInstance(this.type);
                ((BAEU) r1).setShowEvaluate(z);
                if (!z) {
//                    if (zh.d()) {
//                        zh.f(hashMap);
//                    } else {
//                        xh.f(hashMap);
//                    }
                }
            }
            Fragment finalR = r1;
            this.binding.anim.postDelayed(new Runnable() { // from class: zf
                @Override // java.lang.Runnable
                public final void run() {
                    L.d("BAEY-Log", "step replaceFragment "+finalR);
                    BAEY.this.lambda$nextPage$0(finalR);
                }
            }, 500L);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (checkFragmentAlive()) {
            if (this.isOpenStepBtn) {
                this.binding.btnOk.setVisibility(View.VISIBLE);
            } else {
                this.binding.anim.postDelayed(new Runnable() { // from class: yf
                    @Override // java.lang.Runnable
                    public final void run() {
                        BAEY.this.nextPage();
                    }
                }, 500L);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.binding.btnOk) {
            nextPage();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FuncFinishTitleModel ufVar;
        this.vm = (BAEX) new ViewModelProvider(this).get(BAEX.class);
        statusBarTextDarkLight(false);
        FragmentAnimFinishBinding inflate = FragmentAnimFinishBinding.inflate(layoutInflater);
        this.binding = inflate;
        inflate.btnOk.setVisibility(View.GONE);
        this.isOpenStepBtn = true;/* wf.a();*/
        if (this.type == null && (ufVar = this.vm.type) != null) {
            this.type = ufVar;
        }
        BAEX baex = this.vm;
        FuncFinishTitleModel ufVar2 = this.type;
        baex.type = ufVar2;
        if (ufVar2 != null) {
            this.binding.anim.addAnimatorListener(this);
            this.binding.btnOk.setOnClickListener(this);
        } else {
            finishActivity();
        }
        return this.binding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
//        ai.a.b(ni.a().e());
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFQ
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        HashMap hashMap = new HashMap();
        hashMap.put("ext_key1", "na_1");
//        ai.f(ni.a().e(), false, this.binding.flContainer, hashMap, null);
    }

    public BAEY() {
    }
}