package com.clean888.cleansuper.cleaner.ui.dialog;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.utils.vh0;
import com.clean888.cleansuper.cleaner.utils.r6;
import com.clean888.cleansuper.cleaner.utils.s6;
import com.clean888.cleansuper.cleaner.bean.RunningAppBean;
import com.clean888.cleansuper.cleaner.utils.fj;

import com.clean888.cleansuper.cleaner.databinding.ActivityHomeKeyBinding;
import com.clean888.cleansuper.cleaner.ui.lifecycle.BAGG;
import com.clean888.cleansuper.cleaner.ui.vp.BAHC;
import com.clean888.cleansuper.cleaner.ui.vp.BAHD;

import java.util.List;

public class BAAK extends Activity implements View.OnClickListener, Animator.AnimatorListener {
    ActivityHomeKeyBinding a;
    List<RunningAppBean> b;
    private int c;
    private boolean d;
    private String f;

    private String f86g;
    private BAGG h;
    private BAGG i;
    private boolean j = false;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        List<RunningAppBean> list;
        if (isFinishing() || (list = this.b) == null || list.size() <= 0) {
            return;
        }
        this.c = 10;
        BAHD bahd = new BAHD(this, this.b);
        this.a.appsPage.setOffscreenPageLimit(3);
        this.a.appsPage.setPageMargin(50);
        this.a.appsPage.setPageTransformer(false, new BAHC(0.7f));
        this.a.appsPage.setAdapter(bahd);
        this.a.appsPage.setCurrentItem(this.c);
        this.d = true;
        this.a.lottieAnim.addAnimatorListener(this);
    }

    @Override
    public void onAnimationCancel(Animator animator) {
    }

    @Override
    public void onAnimationEnd(Animator animator) {
    }

    @Override
    public void onAnimationRepeat(Animator animator) {
        try {
            if (this.d) {
                int i = this.c + 1;
                this.c = i;
                if (i >= this.a.appsPage.getAdapter().getCount()) {
                    this.c = 1;
                }
                this.a.appsPage.setCurrentItem(this.c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
    }

    @Override
    public void onClick(View view) {
        ActivityHomeKeyBinding activityHomeKeyBinding = this.a;
        if (view == activityHomeKeyBinding.setting) {
            this.j = true;
            this.k = true;
            sh.f(getIntent());
            Intent intent = new Intent(this, (Class<?>) SplashActivity.class);
            sh.e(intent, sh.a(getIntent()));
            intent.putExtra(MainActivity.PAGE, 6);
            intent.putExtra("anyly_click", this.f);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return;
        }
        if (view == activityHomeKeyBinding.clean) {
            this.j = true;
            this.k = true;
            sh.f(getIntent());
            Intent intent2 = new Intent(this, (Class<?>) SplashActivity.class);
            sh.e(intent2, sh.a(getIntent()));
            intent2.putExtra(MainActivity.PAGE, 2);
            intent2.putExtra("anyly_click", this.f);
            intent2.putExtra("analy_rearch", this.f86g);
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent2);
            finish();
            return;
        }
        if (view == activityHomeKeyBinding.later) {
            if (!TextUtils.isEmpty(this.f)) {
//                i4.a().i(this.f).putEbKey1(2).commit();
            }
            finish();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (Build.VERSION.SDK_INT > 28) {
                fj.r(this);
            }
            requestWindowFeature(1);
            ActivityHomeKeyBinding inflate = ActivityHomeKeyBinding.inflate(LayoutInflater.from(this));
            this.a = inflate;
            setContentView(inflate.getRoot());
//            qh.a();
            sh.h(getIntent());
            this.f = getIntent().getStringExtra("anyly_click");
            this.f86g = getIntent().getStringExtra("analy_rearch");
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.gravity = Gravity.BOTTOM;
            attributes.width = vh0.c() - vh0.b(18);
            getWindow().setLayout(-1, -2);
            getWindow().setAttributes(attributes);
            this.a.setting.setOnClickListener(this);
            this.a.clean.setOnClickListener(this);
            this.a.later.setOnClickListener(this);
            if (this.h == null) {
                this.i = new BAGG(this.a.clean, null);
                BAGG bagg = new BAGG(this.a.enter, null);
                this.h = bagg;
                bagg.start();
                this.i.start();
            }
            this.b = s6.a(this, new r6());
            this.a.appsPage.postDelayed(new Runnable() {
                @Override
                public final void run() {
                    BAAK.this.b();
                }
            }, 50L);
        } catch (Throwable unused) {
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.i.onDestroy();
            this.h.onDestroy();
        }
        if (this.j) {
            return;
        }
        sh.g(getIntent(), false);
        this.j = false;
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        qh.a();
        setIntent(intent);
        sh.h(getIntent());
    }

    @Override
    protected void onPause() {
        try {
            super.onPause();
        } catch (Throwable unused) {
        }
        if (this.h != null) {
            this.i.onPause();
            this.h.onPause();
        }
    }

    @Override
    protected void onResume() {
        try {
            super.onResume();
        } catch (Throwable unused) {
        }
        if (this.h != null) {
            this.i.onResume();
            this.h.onResume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (this.k) {
            return;
        }
        sh.g(getIntent(), true);
        this.k = false;
    }
}
