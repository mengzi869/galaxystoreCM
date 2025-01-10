package com.clean888.cleansuper.cleaner.ui.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fj;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.ui.lifecycle.BAGG;

import java.lang.ref.WeakReference;
import java.util.Random;

/* loaded from: classes2.dex */
public class BAAP extends Activity {
    private TextView a;
    private ImageView b;
    private Button c;
    private ImageView d;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<Handler> f97g;
    private String h;
    private String i;
    private BAGG j;
    private Handler f = new Handler(Looper.getMainLooper());
    private Runnable k = new a();
    private boolean l = false;
    private boolean m = false;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            finish();
        }
    }

    private void h() {
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = Gravity.TOP;
        attributes.width = bj.a(this) - bj.i(18);
        getWindow().setLayout(-1, -2);
        getWindow().setAttributes(attributes);
        getWindow().setFlags(32, 32);
    }

    @SuppressLint({"SetTextI18n"})
    private void i(final int i, int i2) {
        ImageView imageView = (ImageView) findViewById(R.id.reminder_close);
        this.d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ua
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k(view);
            }
        });
        this.a = (TextView) findViewById(R.id.reminder_text);
        this.b = (ImageView) findViewById(R.id.reminder_image);
        Button button = (Button) findViewById(R.id.reminder_button);
        this.c = button;
        if (this.j == null) {
            BAGG bagg = new BAGG(button, null);
            this.j = bagg;
            bagg.start();
        }
        if (i == 1) {
            Resources resources = getResources();
            this.a.setText(resources.getString(R.string.reminder_text_clean_1, "" + ((new Random().nextInt(50000) + 20000) / 100.0f)));
            this.c.setText(R.string.reminder_button_clean);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: wa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p(i, view);
                }
            });
            this.b.setImageResource(R.mipmap.ic_reminder_clean);
            return;
        }
        if (i == 2) {
            int nextInt = new Random().nextInt(19) + 2;
            this.a.setText(this.a.getContext().getResources().getString(R.string.reminder_text_boost_2, "" + nextInt));
            if (i2 > 0) {
                String str = i2 + "%";
                String string = getString(R.string.finishpage_boost_des, new Object[]{str});
                int indexOf = string.indexOf(str);
                int length = str.length() + indexOf;
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF5A43")), indexOf, length, 17);
                this.a.setText(spannableString);
            }
            this.c.setText(R.string.reminder_button_boost_2);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m(i, view);
                }
            });
            this.b.setImageResource(R.mipmap.ic_reminder_boost);
            return;
        }
        if (i == 3) {
            this.a.setText(R.string.reminder_text_security);
            this.c.setText(R.string.reminder_button_security);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: ya
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q(i, view);
                }
            });
            this.b.setImageResource(R.mipmap.ic_reminder_security);
            return;
        }
        if (i == 4) {
            this.a.setText(R.string.reminder_text_cpu);
            this.c.setText(R.string.reminder_button_cpu);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: za
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l(i, view);
                }
            });
            this.b.setImageResource(R.mipmap.ic_reminder_cpu);
            return;
        }
        if (i != 5) {
            if (i != 7) {
                return;
            }
            Resources resources2 = getResources();
            this.a.setText(resources2.getString(R.string.reminder_text_clean_1, "" + ((new Random().nextInt(50000) + 20000) / 100.0f)));
            this.c.setText(R.string.reminder_button_clean);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: xa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o(i, view);
                }
            });
            this.b.setImageResource(R.mipmap.ic_reminder_clean);
            return;
        }
        this.a.setText(R.string.reminder_text_battery_1);
        if (i2 > 0) {
            int nextInt2 = new Random().nextInt(19) + 2;
            this.a.setText(this.a.getContext().getResources().getString(R.string.reminder_text_battery_2, "" + nextInt2));
        }
        this.c.setText(R.string.reminder_button_battery);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: va
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n(i, view);
            }
        });
        this.b.setImageResource(R.mipmap.ic_reminder_battery);
    }

    private void j(int i) {
        sh.f(getIntent());
        this.l = true;
        this.m = true;
        Intent intent = new Intent(this, (Class<?>) SplashActivity.class);
        sh.e(intent, sh.a(getIntent()));
        intent.putExtra(MainActivity.PAGE, i);
        intent.putExtra("anyly_click", this.h);
        intent.putExtra("analy_rearch", this.i);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        if (!TextUtils.isEmpty(this.h)) {
//            i4.a().i(this.h).putEbKey1(2).commit();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i, View view) {
        j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i, View view) {
        j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i, View view) {
        j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(int i, View view) {
        j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i, View view) {
        j(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(int i, View view) {
        j(i);
    }

    @Override // android.app.Activity
    public void finish() {
        Handler handler;
        WeakReference<Handler> weakReference = this.f97g;
        if (weakReference != null && (handler = weakReference.get()) != null) {
            handler.removeCallbacks(this.k);
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
            setContentView(R.layout.activity_remind_window);
//            qh.a();
            sh.h(getIntent());
            this.h = getIntent().getStringExtra("anyly_click");
            this.i = getIntent().getStringExtra("analy_rearch");
            h();
            int intExtra = getIntent().getIntExtra(MainActivity.PAGE, -1);
            i(intExtra, getIntent().getIntExtra("value", -1));
            if (intExtra == -1) {
                finish();
            } else {
                this.f97g = new WeakReference<>(this.f);
                this.f.postDelayed(this.k, 60000L);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BAGG bagg = this.j;
        if (bagg != null) {
            bagg.onDestroy();
        }
        if (this.l) {
            return;
        }
        sh.g(getIntent(), false);
        this.l = false;
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
        sh.h(getIntent());
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
        } catch (Throwable unused) {
        }
        BAGG bagg = this.j;
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
        BAGG bagg = this.j;
        if (bagg != null) {
            bagg.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.m) {
            return;
        }
        sh.g(getIntent(), true);
        this.m = false;
    }
}
