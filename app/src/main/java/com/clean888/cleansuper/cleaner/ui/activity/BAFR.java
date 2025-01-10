package com.clean888.cleansuper.cleaner.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.ui.base.BaseActivity;
import com.clean888.cleansuper.cleaner.ui.dialog.Dialog11SdcardRequest;
import com.clean888.cleansuper.cleaner.ui.dialog.DialogSdcardRequest;
import com.clean888.cleansuper.cleaner.utils.mc;
import com.clean888.cleansuper.cleaner.utils.lc;
import com.clean888.cleansuper.cleaner.utils.gf;
import com.clean888.cleansuper.cleaner.utils.fi;

import java.util.ArrayList;
import java.util.Map;

public class BAFR extends BaseActivity {
    private Dialog11SdcardRequest android11RequestDialog;
    private ActivityResultLauncher<String[]> launcher;
    private ActivityResultLauncher<Intent> launcher11ForActResult;
    private ActivityResultLauncher<Intent> launcherForActResult;
    private DialogSdcardRequest normalRequestDialog;
    private int perSDFromIndex;
    private Runnable normalDialogOK = new Runnable() { // from class: xg
        @Override // java.lang.Runnable
        public final void run() {
            BAFR.this.lambda$new$2();
        }
    };
    private final ActivityResultCallback<Map<String, Boolean>> normalResultCallback = new ActivityResultCallback() { // from class: wg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            BAFR.this.lambda$new$3((Map) obj);
        }
    };
    private final ActivityResultCallback<ActivityResult> androidResultIntentCallback = new ActivityResultCallback() { // from class: ug
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            BAFR.this.lambda$new$4((ActivityResult) obj);
        }
    };
    private Runnable android11DialogOK = new Runnable() { // from class: ah
        @Override // java.lang.Runnable
        public final void run() {
            BAFR.this.lambda$new$5();
        }
    };
    private final ActivityResultCallback<ActivityResult> android11ResultIntentCallback = new ActivityResultCallback() { // from class: vg
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            BAFR.this.lambda$new$6((ActivityResult) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void lambda$new$2() {

        if (checkFinish()){
            return;
        }
        /*
            r4 = this;
            boolean r0 = r4.checkFinish()
            if (r0 == 0) goto L7
            return
        L7:
            r0 = 0
            java.lang.String[] r1 = defpackage.lc.a
            java.util.ArrayList r2 = defpackage.mc.a(r1)
            boolean r2 = defpackage.mc.r(r4, r2)
            r3 = 1
            if (r2 == 0) goto L21
            androidx.activity.result.ActivityResultLauncher<android.content.Intent> r1 = r4.launcherForActResult
            boolean r1 = defpackage.gf.b(r1, r4)
            if (r1 == 0) goto L27
            defpackage.fi.a()
            goto L26
        L21:
            androidx.activity.result.ActivityResultLauncher<java.lang.String[]> r0 = r4.launcher
            r0.launch(r1)
        L26:
            r0 = 1
        L27:
            if (r0 == 0) goto L42
            t4 r0 = defpackage.i4.a()
            java.lang.String r1 = "s_sd"
            ol0 r0 = r0.i(r1)
            int r1 = r4.perSDFromIndex
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            okhttp3.internal.connection.j r0 = r0.putEbKey1(r1)
            ol0 r0 = (defpackage.ol0) r0
            r0.commit()
        L42:
            return
        */
//        throw new UnsupportedOperationException("Method not decompiled: bfj.ckdk.wazpqdu.cjzk.nysf.BAFR.lambda$new$2():void");

        if (checkFinish()) {
            return;
        }

        String[] data = lc.a;
        ArrayList<String> list = mc.a(data);
        boolean result = mc.r(this, list);

        if (result) {
            if (gf.b(launcherForActResult, this)) {
                fi.a();
            }
        } else {
            launcher.launch(data);
        }

//        if (result) {
//            t4 instance = defpackage.i4.a();
//            String key = "s_sd";
//            ol0 olInstance = instance.i(key);
//            Integer index = Integer.valueOf(perSDFromIndex);
//            olInstance.putEbKey1(index).commit();
//        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(Map map) {
        if (checkFinish()) {
            return;
        }
        boolean m = mc.m(this, mc.a(lc.a));
//        i4.a().i(m ? "c_sd_allow" : "c_sd_deny").putEbKey1(Integer.valueOf(this.perSDFromIndex)).commit();
        onPerRequestBack(m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(ActivityResult activityResult) {
        if (checkFinish()) {
            return;
        }
        if (activityResult != null) {
            boolean m = mc.m(this, mc.a(lc.a));
//            i4.a().i(m ? "c_sd_allow" : "c_sd_deny").putEbKey1(Integer.valueOf(this.perSDFromIndex)).commit();
            onPerRequestBack(m);
            return;
        }
        onPerRequestBack(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5() {
        if (!checkFinish() && gf.a(this.launcher11ForActResult, this)) {
            fi.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(ActivityResult activityResult) {
        if (checkFinish()) {
            return;
        }
        if (activityResult != null) {
            boolean o = mc.o(this);
//            i4.a().i(ServerTimeListener ? "c_android11_ok" : "s_android11_cancel").putEbKey1(Integer.valueOf(this.perSDFromIndex)).commit();
            onPerRequestBack(o);
            return;
        }
        onPerRequestBack(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show11SDCardRequestDialog$0() {
//        i4.a().i("s_android11_cancel").putEbKey1(Integer.valueOf(this.perSDFromIndex)).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSDCardRequestDialog$1() {
//        i4.a().i("c_sd_deny").putEbKey1(Integer.valueOf(this.perSDFromIndex)).commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkFinish() {
        return isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkStoragePermissionDialog(int i, Runnable runnable, boolean z) {
        if (checkFinish()) {
            return;
        }
        if (mc.o(this)) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (z) {
            this.perSDFromIndex = i;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (z) {
                show11SDCardRequestDialog();
            }
        } else if (z) {
            showSDCardRequestDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bfj.ckdk.wazpqdu.cjzk.nysf.BAFS, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.launcher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), this.normalResultCallback);
        this.launcherForActResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this.androidResultIntentCallback);
        this.launcher11ForActResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this.android11ResultIntentCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPerRequestBack(boolean z) {
    }

    void show11SDCardRequestDialog() {
        if (checkFinish()) {
            return;
        }
        if (this.android11RequestDialog == null) {
            this.android11RequestDialog = new Dialog11SdcardRequest(this, this.android11DialogOK, new Runnable() { // from class: yg
                @Override // java.lang.Runnable
                public final void run() {
                    BAFR.this.lambda$show11SDCardRequestDialog$0();
                }
            });
        }
        if (this.android11RequestDialog.isShowing()) {
            return;
        }
//        i4.a().i("s_android11").putEbKey1(Integer.valueOf(this.perSDFromIndex)).commit();
        this.android11RequestDialog.show();
    }

    void showSDCardRequestDialog() {
        if (checkFinish()) {
            return;
        }
        if (this.normalRequestDialog == null) {
            this.normalRequestDialog = new DialogSdcardRequest(this, this.normalDialogOK, new Runnable() { // from class: zg
                @Override // java.lang.Runnable
                public final void run() {
                    BAFR.this.lambda$showSDCardRequestDialog$1();
                }
            });
        }
        if (this.normalRequestDialog.isShowing()) {
            return;
        }
        this.normalRequestDialog.c(false);
    }
}
