package com.clean888.cleansuper.cleaner.ui.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fj;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.ui.lifecycle.BAGG;

/* loaded from: classes2.dex */
public class ZZA extends Activity {
    private TextView a;
    private String b;
    private String d;
    private String f;

    /* renamed from: g, reason: collision with root package name */
    private BAGG f96g;
    private Handler c = new Handler(Looper.getMainLooper());
    private Runnable h = new a();
    private boolean i = false;
    private boolean j = false;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L.d("PackageActionDialog","install package dialog activity ZZA finish on run");
            ZZA.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(ZZA.this.d)) {
//                i4.a().i(ZZA.this.d).putEbKey1(2).commit();
            }
            ZZA.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sh.f(ZZA.this.getIntent());
            ZZA.this.i = true;
            ZZA.this.j = true;
            ZZA.this.finish();
            Intent intent = new Intent(ZZA.this, (Class<?>) SplashActivity.class);
            sh.e(intent, sh.a(ZZA.this.getIntent()));
            intent.putExtra(MainActivity.PAGE, 8);
            intent.putExtra(MainActivity.PACKAGE, ZZA.this.b);
            intent.putExtra("anyly_click", ZZA.this.d);
            intent.putExtra("analy_rearch", ZZA.this.f);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ZZA.this.startActivity(intent);
        }
    }

    private void f() {
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.CENTER;
        attributes.width = bj.a(this) - bj.i(18);
        getWindow().setLayout(-1, -2);
        getWindow().setAttributes(attributes);
        getWindow().setFlags(32, 32);
    }

    private void g() {
        View findViewById = findViewById(R.id.tv_uninstall_leftactioin);
        View findViewById2 = findViewById(R.id.tv_uninstall_rightaction);
        if (this.f96g == null) {
            BAGG bagg = new BAGG(findViewById2, null);
            this.f96g = bagg;
            bagg.start();
        }
        this.a = (TextView) findViewById(R.id.tv_uninstall_reminder);
        findViewById.setOnClickListener(new b());
        findViewById2.setOnClickListener(new c());
        ImageView imageView = (ImageView) findViewById(R.id.img_uninstall_clean);
        String str = "New App";
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.b, 0);
            str = applicationInfo.loadLabel(packageManager).toString();
            imageView.setImageDrawable(applicationInfo.loadIcon(packageManager));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.a.setText(getString(R.string.install_reminder_zero, new Object[]{str}));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        try {
            L.d("PackageActionDialog","install package dialog activity ZZA onCreate");
            super.onCreate(bundle);
            if (Build.VERSION.SDK_INT > 28) {
                fj.r(this);
            }
            this.b = getIntent().getStringExtra(MainActivity.PACKAGE);
            this.d = getIntent().getStringExtra("anyly_click");
            this.f = getIntent().getStringExtra("analy_rearch");
            requestWindowFeature(1);
            setContentView(R.layout.activity_install_reminder);
//            qh.a();
            sh.h(getIntent());
            f();
            this.c.postDelayed(this.h, 120000L);
            g();
        } catch (Throwable unused) {
            L.d("PackageActionDialog","install package dialog activity ZZA onCreate error:"+unused.getMessage());
            unused.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        L.d("PackageActionDialog","install package dialog activity ZZA onDestroy");
        super.onDestroy();
        BAGG bagg = this.f96g;
        if (bagg != null) {
            bagg.onDestroy();
        }
        if (this.i) {
            return;
        }
        sh.g(getIntent(), false);
        this.i = false;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        qh.a();
        setIntent(intent);
        sh.h(getIntent());
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
        } catch (Throwable unused) {
        }
        BAGG bagg = this.f96g;
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
        BAGG bagg = this.f96g;
        if (bagg != null) {
            bagg.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.j) {
            return;
        }
        sh.g(getIntent(), true);
        this.j = false;
    }
}
