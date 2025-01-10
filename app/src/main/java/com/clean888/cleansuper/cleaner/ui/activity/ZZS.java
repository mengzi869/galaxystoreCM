package com.clean888.cleansuper.cleaner.ui.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.ZZN;

/* loaded from: classes2.dex */
public class ZZS extends BaseFMActivity {
    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE
    public Fragment createFragment() {
        return ZZN.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE, bfj.ckdk.wazpqdu.cjzk.nysf.BAFS, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }
}
