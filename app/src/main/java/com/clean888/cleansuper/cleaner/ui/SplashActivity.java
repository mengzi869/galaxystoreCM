package com.clean888.cleansuper.cleaner.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.fj;
import com.clean888.cleansuper.cleaner.utils.h91;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAFF;
import com.clean888.cleansuper.cleaner.ui.activity.BAAE;
import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.BAFI;
import com.clean888.cleansuper.cleaner.ui.fragment.BAFJ;
import com.clean888.cleansuper.cleaner.ui.fragment.BAHT;

//ZZI
public class SplashActivity extends BaseFMActivity {
    private static final String TAG = "SplashActivityLog";

    public String analyClick;
    public String analyRearch;
    public int goPage;
    private Handler handler;
    private BAFF mViewModel;
    public String packgeName;
    public String sceneType;

    private void analy(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("notify_id", -1);
            if (intExtra > 0) {
                NotificationManagerCompat.from(this).cancel(intExtra);
            }
            this.packgeName = intent.getStringExtra(MainActivity.PACKAGE);
            int intExtra2 = intent.getIntExtra(MainActivity.PAGE, 0);
            this.goPage = intExtra2;
            if (intExtra2 > 0 && Build.VERSION.SDK_INT > 28) {
                fj.r(this);
            }
            this.analyRearch = intent.getStringExtra("analy_rearch");
            this.sceneType = intent.getStringExtra("scene_type");
            String stringExtra = intent.getStringExtra("anyly_click");
            this.analyClick = stringExtra;
            if (this.analyRearch == null) {
                this.analyRearch = "";
            }
            if (this.sceneType == null) {
                this.sceneType = "";
            }
            if (!TextUtils.isEmpty(stringExtra)) {
//                i4.a().i(this.analyClick).putEbKey1(this.sceneType).putEbKey2(Integer.valueOf(this.goPage == 6 ? 3 : 1)).commit();
            }
            sh.i(getIntent(), 1);
//            rh.b(this, 1);
        }
    }

    private boolean goWidget() {

        if (getIntent() == null) {
            L.e(TAG,"goWidget getIntent() == null so return");
            return false;
        }
        int intExtra = getIntent().getIntExtra("widgetType", 0);
        L.e(TAG,"goWidget widgetType = "+intExtra);
        if (intExtra == 1) {
//            i4.a().i("c_widget").commit();
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.putExtra(MainActivity.FROM, 7);
            intent.putExtra(MainActivity.PAGE, 2);
            startActivity(intent);
            finish();
            return true;
        }
        if (intExtra == 2) {
//            i4.a().i("c_widget").commit();
            Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
            intent2.putExtra(MainActivity.FROM, 7);
            intent2.putExtra(MainActivity.PAGE, 5);
            startActivity(intent2);
            finish();
            return true;
        }
        if (intExtra == 3) {
//            i4.a().i("c_widget").commit();
            Intent intent3 = new Intent(this, (Class<?>) MainActivity.class);
            intent3.putExtra(MainActivity.FROM, 7);
            intent3.putExtra(MainActivity.PAGE, 1);
            startActivity(intent3);
            finish();
            return true;
        }
        if (intExtra != 4) {
            return false;
        }
//        i4.a().i("c_widget").commit();
        Intent intent4 = new Intent(this, (Class<?>) MainActivity.class);
        intent4.putExtra(MainActivity.FROM, 7);
        intent4.putExtra(MainActivity.PAGE, 4);
        startActivity(intent4);
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        if (isFinishing()) {
            return;
        }
        h91.Q();
    }

    @Override
    public Fragment createFragment() {
        if (this.mViewModel.isAgreement()) {
            return BAFI.newInstance();
        }
        return BAFJ.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        BAHT.m(this, i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE, bfj.ckdk.wazpqdu.cjzk.nysf.BAFS, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {

        this.mViewModel = (BAFF) new ViewModelProvider(this).get(BAFF.class);
        super.onCreate(bundle);
//        qh.a();
//        qh.b();
        if (BAAE.isLamp) {
            startActivity(new Intent(this, (Class<?>) BAAE.class));
            overridePendingTransition(0, 0);
            finish();
        } else {
            if (goWidget()) {
                return;
            }
            Handler handler = new Handler(Looper.getMainLooper());
            this.handler = handler;
            handler.postDelayed(new Runnable() { // from class: m43
                @Override // java.lang.Runnable
                public final void run() {
                    SplashActivity.this.lambda$onCreate$0();
                }
            }, 1000L);
//            i4.a().i("s_load").commit();
            analy(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
//        qh.b();
        analy(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        BAHT.n(this, i, strArr, iArr);
    }
}