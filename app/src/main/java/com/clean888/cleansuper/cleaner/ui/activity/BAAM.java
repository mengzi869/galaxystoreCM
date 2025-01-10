package com.clean888.cleansuper.cleaner.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

/* loaded from: classes2.dex */
public class BAAM extends Activity {
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int intExtra;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && (intExtra = intent.getIntExtra("notifyID", -1)) > 0) {
            NotificationManagerCompat.from(this).cancel(intExtra);
        }
        finish();
    }
}
