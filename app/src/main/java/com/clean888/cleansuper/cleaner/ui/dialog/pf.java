package com.clean888.cleansuper.cleaner.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import androidx.appcompat.widget.AppCompatImageView;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.databinding.DialogEvaluateLayoutBinding;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.hi;
import com.clean888.cleansuper.cleaner.utils.AboutMe.AgreementUtil;
import com.clean888.cleansuper.cleaner.ui.base.BaseDialog;
import com.tencent.mmkv.MMKV;

import java.util.concurrent.TimeUnit;

public class pf extends BaseDialog implements View.OnClickListener {
    private DialogEvaluateLayoutBinding a;
    private boolean b;
    private boolean c;
    private final int d;
    private int f;

    public pf(Context context, int i) {
        super(context, R.style.transparent_dialog);
        this.b = true;
        this.c = false;
        this.d = i;
    }

    public static boolean c() {
        if (e()) {
            L.d("ZZR", "评分引导已评价,不再显示");
            return false;
        }
        if (System.currentTimeMillis() - g() < TimeUnit.HOURS.toMillis(8L)) {
            L.d("ZZR", "评分引导，8小时内,不再显示");
            return false;
        }
//        if (li.d("fun_rate_switch", "").isEmpty()) {
//            L.d("ZZR", "评分引导，没获取到AB");
//            return false;
//        }
//        int c = li.c("fun_rate_switch", 2);
//        if (md1.e()) {
//            Object[] objArr = new Object[2];
//            objArr[0] = "评分引导，AB开关:";
//            objArr[1] = Boolean.valueOf(c == 1);
//            md1.c("ZZR", objArr);
//        }
//        return c == 1;
        return true;
    }

    private static void d() {
        MMKV.mmkvWithID("evaluate").putBoolean("finish", true);
    }

    private static boolean e() {
        return MMKV.mmkvWithID("evaluate").getBoolean("finish", false);
    }

    public void f() {
        this.a.close.setVisibility(View.VISIBLE);
    }

    private static long g() {
        return MMKV.mmkvWithID("evaluate").getLong("lastShowTime", 0L);
    }

    private void h(View view) {
        DialogEvaluateLayoutBinding dialogEvaluateLayoutBinding = this.a;
        AppCompatImageView appCompatImageView = dialogEvaluateLayoutBinding.star1;
        if (view == appCompatImageView) {
            appCompatImageView.setSelected(true);
            this.a.star1.setSelected(true);
            this.a.star2.setSelected(false);
            this.a.star3.setSelected(false);
            this.a.star4.setSelected(false);
            this.a.star5.setSelected(false);
            this.f = 1;
        } else if (view == dialogEvaluateLayoutBinding.star2) {
            appCompatImageView.setSelected(true);
            this.a.star2.setSelected(true);
            this.a.star3.setSelected(false);
            this.a.star4.setSelected(false);
            this.a.star5.setSelected(false);
            this.f = 2;
        } else if (view == dialogEvaluateLayoutBinding.star3) {
            appCompatImageView.setSelected(true);
            this.a.star2.setSelected(true);
            this.a.star3.setSelected(true);
            this.a.star4.setSelected(false);
            this.a.star5.setSelected(false);
            this.f = 3;
        } else if (view == dialogEvaluateLayoutBinding.star4) {
            appCompatImageView.setSelected(true);
            this.a.star2.setSelected(true);
            this.a.star3.setSelected(true);
            this.a.star4.setSelected(true);
            this.a.star5.setSelected(false);
            this.f = 4;
        } else if (view == dialogEvaluateLayoutBinding.star5) {
            appCompatImageView.setSelected(true);
            this.a.star2.setSelected(true);
            this.a.star3.setSelected(true);
            this.a.star4.setSelected(true);
            this.a.star5.setSelected(true);
            this.f = 5;
        } else {
            this.f = 0;
        }
        int i = this.f;
        if (i == 5) {
            this.a.text.setText(R.string.evaluate_text2);
        } else if (i >= 1) {
            this.a.text.setText(R.string.evaluate_text3);
        }
        this.a.hand.setVisibility(View.INVISIBLE);
        this.a.hand.setAnimation(null);
//        i4.a().i("rate_rate").putEbKey1(Integer.valueOf(this.d)).putEbKey2(Integer.valueOf(this.f)).commit();
    }

    private static void i() {
        MMKV.mmkvWithID("evaluate").putLong("lastShowTime", System.currentTimeMillis());
    }

    public static void j(Context context, int i) {
        new pf(context, i).show();
    }

    private void k() {
        this.a.btn.setVisibility(View.VISIBLE);
        this.a.close.setVisibility(View.VISIBLE);
        this.c = false;
        this.a.btn.setText(R.string.evaluate_us);
        this.b = false;
    }

    private void l() {
        this.a.btn.setVisibility(View.VISIBLE);
        this.a.close.setVisibility(View.VISIBLE);
        this.a.btn.setText(R.string.evaluate_feedback);
        this.c = true;
        this.b = false;
    }

    @Override
    public void dismiss() {
        super.dismiss();
//        i4.a().i("rate_close").putEbKey1(Integer.valueOf(this.d)).putEbKey2(Integer.valueOf(this.f > 0 ? 1 : 2)).commit();
    }

    @Override
    public void onClick(View view) {
        DialogEvaluateLayoutBinding dialogEvaluateLayoutBinding = this.a;
        if (view != dialogEvaluateLayoutBinding.star1 && view != dialogEvaluateLayoutBinding.star2 && view != dialogEvaluateLayoutBinding.star3 && view != dialogEvaluateLayoutBinding.star4 && view != dialogEvaluateLayoutBinding.star5) {
            if (view == dialogEvaluateLayoutBinding.btn) {
                if (this.c) {
                    AgreementUtil.goEmail(getContext(), "appjoy.tech@gmail.com");
//                    i4.a().i("rate_feedback").putEbKey1(Integer.valueOf(this.d)).commit();
                } else {
                    hi.a.a(getContext(), getContext().getPackageName());
//                    i4.a().i("rate_evaluation").putEbKey1(Integer.valueOf(this.d)).commit();
                }
                d();
                dismiss();
                return;
            }
            if (view == dialogEvaluateLayoutBinding.close) {
                dismiss();
                return;
            }
            return;
        }
        if (this.b) {
            h(view);
            if (view == this.a.star5) {
                k();
            } else {
                l();
            }
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogEvaluateLayoutBinding inflate = DialogEvaluateLayoutBinding.inflate(LayoutInflater.from(getContext()));
        this.a = inflate;
        setContentView(inflate.getRoot());
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        super.onCreate(bundle);
        setCancelable(false);
        this.a.star1.setOnClickListener(this);
        this.a.star2.setOnClickListener(this);
        this.a.star3.setOnClickListener(this);
        this.a.star4.setOnClickListener(this);
        this.a.star5.setOnClickListener(this);
        this.a.btn.setOnClickListener(this);
        this.a.close.setOnClickListener(this);
        this.a.text.setText(R.string.evaluate_text);
        this.a.hand.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rate_scale_anim));
    }

    @Override
    public void show() {
        super.show();
        if (this.a.close.getVisibility() != View.VISIBLE) {
            this.a.close.postDelayed(new Runnable() {
                @Override
                public final void run() {
                    pf.this.f();
                }
            }, 5000L);
        }
        i();
//        i4.a().i("rate_show").putEbKey1(Integer.valueOf(this.d)).commit();
    }
}
