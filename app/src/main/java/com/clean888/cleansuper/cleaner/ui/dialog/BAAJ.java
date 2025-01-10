package com.clean888.cleansuper.cleaner.ui.dialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fj;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.ui.lifecycle.BAGG;
import com.clean888.cleansuper.cleaner.ui.widget.ZZM;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class BAAJ extends Activity {
    private ZZM a;
    private View b;
    private ImageView c;
    private LottieAnimationView d;
    private TextView f;
    private WeakReference<Handler> h;
    private String j;
    private String k;
    private BAGG l;

    /* renamed from: g, reason: collision with root package name */
    private Handler f85g = new Handler(Looper.getMainLooper());
    private Runnable i = new c();
    private boolean m = false;
    private boolean n = false;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BAAJ.this.a.setProgress(Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BAAJ.this.a.setVisibility(View.GONE);
            BAAJ.this.b.setVisibility(View.VISIBLE);
            BAAJ.this.d.setVisibility(View.GONE);
            BAAJ.this.d.cancelAnimation();
            BAAJ.this.c.setVisibility(View.VISIBLE);
            BAAJ.this.c.setImageResource(R.mipmap.ic_charging_improver_image);
            int k = bj.k(BAAJ.this);
            if (k > 0 && k <= 32) {
                BAAJ.this.f.setText(BAAJ.this.getString(R.string.charging_boost_tip_low));
            } else {
                BAAJ.this.f.setText(BAAJ.this.getString(R.string.charging_boost_tip));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BAAJ.this.finish();
        }
    }

    private void i() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.TOP;
        attributes.width = bj.a(this) - bj.i(18);
        getWindow().setLayout(-1, -2);
        getWindow().setAttributes(attributes);
        getWindow().setFlags(32, 32);
    }

    private void j() {
        findViewById(R.id.charging_improver_setting).setOnClickListener(new View.OnClickListener() { // from class: sa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BAAJ.this.l(view);
            }
        });
        findViewById(R.id.charging_improver_later).setOnClickListener(new View.OnClickListener() { // from class: ra
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BAAJ.this.m(view);
            }
        });
        ZZM zzm = (ZZM) findViewById(R.id.charging_improver_progressbar);
        this.a = zzm;
        zzm.setProgress(0);
        View findViewById = findViewById(R.id.charging_improver_improver);
        if (this.l == null) {
            BAGG bagg = new BAGG(findViewById, null);
            this.l = bagg;
            bagg.start();
        }
        this.b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: qa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BAAJ.this.n(view);
            }
        });
        this.a.setVisibility(View.VISIBLE);
        this.b.setVisibility(View.GONE);
        ImageView imageView = (ImageView) findViewById(R.id.charging_improver_image);
        this.c = imageView;
        imageView.setImageResource(R.mipmap.ic_guide_charging_improver);
        this.c.setVisibility(View.GONE);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.charging_improver_lottie);
        this.d = lottieAnimationView;
        lottieAnimationView.setVisibility(View.VISIBLE);
        TextView textView = (TextView) findViewById(R.id.charging_improver_text);
        this.f = textView;
        textView.setText(R.string.analyzing_power);
        ValueAnimator ofInt = ObjectAnimator.ofInt(0, 100);
        ofInt.setDuration(5000L);
        ofInt.addUpdateListener(new a());
        ofInt.addListener(new b());
        ofInt.start();
    }

    private void k(int i) {
        this.m = true;
        this.n = true;
        sh.f(getIntent());
        Intent intent = new Intent(this, (Class<?>) SplashActivity.class);
        sh.e(intent, sh.a(getIntent()));
        intent.putExtra(MainActivity.PAGE, i);
        intent.putExtra("anyly_click", this.j);
        intent.putExtra("analy_rearch", this.k);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        k(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        if (!TextUtils.isEmpty(this.j)) {
//            i4.a().i(this.j).putEbKey1(2).commit();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        k(5);
    }

    @Override // android.app.Activity
    public void finish() {
        Handler handler;
        WeakReference<Handler> weakReference = this.h;
        if (weakReference != null && (handler = weakReference.get()) != null) {
            handler.removeCallbacks(this.i);
        }
        super.finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (Build.VERSION.SDK_INT > 28) {
                fj.r(this);
            }
            requestWindowFeature(1);
            setContentView(R.layout.activity_charging_improver);
//            qh.a();
            sh.h(getIntent());
            this.j = getIntent().getStringExtra("anyly_click");
            this.k = getIntent().getStringExtra("analy_rearch");
            i();
            j();
            this.h = new WeakReference<>(this.f85g);
            this.f85g.postDelayed(this.i, 60000L);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BAGG bagg = this.l;
        if (bagg != null) {
            bagg.onDestroy();
        }
        if (this.m) {
            return;
        }
        sh.g(getIntent(), false);
        this.m = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        qh.a();
        setIntent(intent);
        j();
        sh.h(getIntent());
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
        } catch (Throwable unused) {
        }
        BAGG bagg = this.l;
        if (bagg != null) {
            bagg.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
        } catch (Throwable unused) {
        }
        BAGG bagg = this.l;
        if (bagg != null) {
            bagg.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.n) {
            return;
        }
        sh.g(getIntent(), true);
        this.n = false;
    }
}
