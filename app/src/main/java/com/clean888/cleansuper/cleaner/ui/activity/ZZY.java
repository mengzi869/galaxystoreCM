package com.clean888.cleansuper.cleaner.ui.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.fl;
import com.clean888.cleansuper.cleaner.utils.vh0;
import com.clean888.cleansuper.cleaner.databinding.ActivityPermissionGuideBinding;


/* loaded from: classes2.dex */
public class ZZY extends Activity implements View.OnClickListener {
    private static ZZY h;
    private static boolean i;
    private static Runnable j;
    private static b k;
    private ActivityPermissionGuideBinding a;
    private ValueAnimator b = ValueAnimator.ofFloat(0.0f, 1.0f);
    private int c = 0;
    private int d = 0;
    private long f = 0;

    /* renamed from: g, reason: collision with root package name */
    private HomeBroadcastReceiver f87g = null;

    /* loaded from: classes2.dex */
    public class HomeBroadcastReceiver extends BroadcastReceiver {
        public HomeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) || (stringExtra = intent.getStringExtra("reason")) == null) {
                return;
            }
            if (stringExtra.equals("homekey") || stringExtra.equals("fs_gesture")) {
                if (ZZY.this.d == 0) {
                    ZZY.this.d = 1;
//                    i4.a().i("c_permisclose").putEbKey1(Integer.valueOf(ZZY.this.d)).commit();
//                    i4.a().i("c_home").putEbKey1(Long.valueOf(Math.max((System.currentTimeMillis() - ZZY.this.f) / 1000, 0L))).commit();
                }
                try {
                    ZZY.this.finishAndRemoveTask();
                } catch (Exception unused) {
                    ZZY.this.finish();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NonNull Animator animator) {
            ZZY.d(ZZY.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator) {
//            i4.a().i("s_permispup").commit();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a();
    }

    static /* synthetic */ int d(ZZY zzy) {
        int i2 = zzy.c;
        zzy.c = i2 + 1;
        return i2;
    }

    public static void h() {
        i = true;
        ThreadUtils.getMainHandler().removeCallbacks(j);
        ZZY zzy = h;
        if (zzy == null || zzy.isFinishing()) {
            return;
        }
        h.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(float f, float f2, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue > 0.5f) {
            if (!this.a.switchCompat.isChecked()) {
                this.a.switchCompat.setChecked(true);
            }
        } else if (this.a.switchCompat.isChecked()) {
            this.a.switchCompat.setChecked(false);
        }
        this.a.hand.setTranslationX(f + (floatValue * f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(b bVar, Context context) {
        try {
            k = bVar;
            Class cls = ZZY.class;
            if (Build.VERSION.SDK_INT == 26) {
                cls = ZZZ.class;
            }
            Intent intent = new Intent(context, (Class<?>) cls);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Throwable unused) {
            unused.printStackTrace();
            k = null;
        }
    }

    private void m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        if (this.f87g == null) {
            HomeBroadcastReceiver homeBroadcastReceiver = new HomeBroadcastReceiver();
            this.f87g = homeBroadcastReceiver;
            if (Build.VERSION.SDK_INT >= 26) {
                registerReceiver(homeBroadcastReceiver, intentFilter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(homeBroadcastReceiver, intentFilter);
            }
        }
    }

    public static void n(final Context context, final b bVar) {
        i = false;
        Runnable runnable = new Runnable() { // from class: z43
            @Override // java.lang.Runnable
            public final void run() {
                ZZY.l(bVar, context);
            }
        };
        j = runnable;
        ThreadUtils.runOnUiThreadDelayed(runnable, 1000L);
    }

    private void o() {
        HomeBroadcastReceiver homeBroadcastReceiver = this.f87g;
        if (homeBroadcastReceiver != null) {
            unregisterReceiver(homeBroadcastReceiver);
        }
        this.f87g = null;
    }

    @Override // android.app.Activity
    /* renamed from: finish, reason: merged with bridge method [inline-methods] */
    public void finish() {
        if (isFinishing()) {
            return;
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        b bVar = k;
        if (bVar != null && bVar.a()) {
            finish();
        } else {
            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: bfj.ckdk.wazpqdu.cjzk.mhiggthrrh.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZZY.this.i();
                }
            }, 200L);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c > 0) {
            this.d = 3;
//            i4.a().i("c_permisclose").putEbKey1(Integer.valueOf(this.d)).commit();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h = this;
        ActivityPermissionGuideBinding inflate = ActivityPermissionGuideBinding.inflate(LayoutInflater.from(this));
        this.a = inflate;
        if (i) {
            finish();
            return;
        }
        setContentView(inflate.getRoot());
        this.f = System.currentTimeMillis();
//        i4.a().i("s_permispup").commit();
        fl.o(this);
        m();
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.BOTTOM;
        attributes.width = vh0.c() - vh0.b(18);
        getWindow().setLayout(-1, -1);
        getWindow().setAttributes(attributes);
        getWindow().setFlags(32, 32);
        this.a.title.setText(String.format(getString(R.string.find_and_turn_on), getString(R.string.app_name_main)));
        this.a.close.setOnClickListener(this);
        this.b.setDuration(800L);
        this.b.setRepeatCount(-1);
        this.b.setInterpolator(new AccelerateDecelerateInterpolator());
        this.b.setRepeatMode(ValueAnimator.REVERSE);
        this.b.addListener(new a());
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: a53
            @Override // java.lang.Runnable
            public final void run() {
                ZZY.this.finish();
            }
        }, 8000L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancel();
        this.a.hand.clearAnimation();
        k = null;
        h = null;
        o();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        final float translationX = this.a.hand.getTranslationX();
        final float b2 = vh0.b(30);
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: y43
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZZY.this.k(translationX, b2, valueAnimator);
            }
        });
        this.b.start();
        i();
    }
}