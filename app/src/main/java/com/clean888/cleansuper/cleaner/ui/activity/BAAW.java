package com.clean888.cleansuper.cleaner.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.clean888.cleansuper.cleaner.R;

public final class BAAW extends Activity {
    /* JADX INFO: Access modifiers changed from: private */
//    public /* synthetic */ void b(t4 t4Var, View view) {
//        t4Var.i("c_quickboost_set_back").commit();
//        finish();
//    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        final t4 a = i4.a();
//        a.i("s_quickboost_set").commit();
        setContentView(R.layout.activity_wallpaper_show);
        ((ImageView) findViewById(R.id.wallpaper_back_img)).setOnClickListener(new View.OnClickListener() { // from class: cb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
//                BAAW.this.b(a, view);
                finish();
            }
        });
    }
}
