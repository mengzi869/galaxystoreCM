package com.clean888.cleansuper.cleaner.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.service.BAAU;
import com.clean888.cleansuper.cleaner.ui.widget.BAGL;

public final class BAAV extends Activity {

    /* loaded from: classes2.dex */
    class a implements BAGL.e {
        a() {
        }

        @Override // bfj.cuskky.qoz.efwnxtjkj.BAGL.e
        public void a() {
            BAAV baav = BAAV.this;
            Intent intent = new Intent(baav, (Class<?>) MainActivity.class);
            intent.putExtra(MainActivity.PAGE, 2);
            intent.putExtra(MainActivity.FROM, MainActivity.FROM_5);
            baav.startActivity(intent);
            baav.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }
        getWindow().setStatusBarColor(BAAU.b(this, R.color.transparent));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new BAGL(this, null, new a()));
    }
}
