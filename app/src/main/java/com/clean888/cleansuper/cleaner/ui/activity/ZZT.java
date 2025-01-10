package com.clean888.cleansuper.cleaner.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.utils.b;
import com.clean888.cleansuper.cleaner.ui.fragment.DeepCleanGuideFragment;
import com.clean888.cleansuper.cleaner.ui.fragment.JunkScanSelectFragment;

public class ZZT extends BaseFMActivity {
    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE
    public Fragment createFragment() {
        if (b.b()) {
            return JunkScanSelectFragment.newInstance();
        }
        return new DeepCleanGuideFragment.b().b(new DeepCleanGuideFragment.b.a() { // from class: x43
            @Override // bfj.ckdk.wazpqdu.cjzk.bvmp.BAFY.b.a
            public final Object a() {
                return JunkScanSelectFragment.newInstance();
            }
        }).a();
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE, bfj.ckdk.wazpqdu.cjzk.nysf.BAFS, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }
}
