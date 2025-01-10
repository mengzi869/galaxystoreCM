package com.clean888.cleansuper.cleaner.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.ui.fragment.lamp.BAFL;

/* loaded from: classes2.dex */
public class BAAE extends BAFT {
    public static boolean isLamp = false;

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE
    public Fragment createFragment() {
        return BAFL.newInstance();
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE, bfj.ckdk.wazpqdu.cjzk.nysf.BAFS, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        isLamp = true;
//        i4.a().i("s_flashlight").commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        isLamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("anyly_click");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
//        i4.a().i(stringExtra).commit();
    }
}
