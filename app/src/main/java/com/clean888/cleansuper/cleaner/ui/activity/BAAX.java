package com.clean888.cleansuper.cleaner.ui.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.clean888.cleansuper.cleaner.ui.base.BaseFMActivity;
import com.clean888.cleansuper.cleaner.ui.fragment.BADU;


/* loaded from: classes2.dex */
public class BAAX extends BaseFMActivity {
    public static void startNotificationCleanActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) BAAX.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.ZZE
    public Fragment createFragment() {
        return BADU.newInstance();
    }
}