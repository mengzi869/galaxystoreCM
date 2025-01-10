package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.tencent.mmkv.MMKV;
import com.clean888.cleansuper.cleaner.utils.AboutMe.AgreementUtil;

/* loaded from: classes2.dex */
public class BAFF extends ViewModel {
    private static final String IS_AGREEMENT = "splash";
    private static final String MMKV_NAME = "splash";
    private MMKV mmkv = MMKV.mmkvWithID("splash");

    /* JADX INFO: Access modifiers changed from: package-private */
    public void agreement() {
//        this.mmkv.ServerTimeListener("splash", true);
        this.mmkv.putBoolean("splash", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void goPrivacyPolicy(Context context) {
        AgreementUtil.goPrivacyPolicy(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void goTermsOfService(Context context) {
        AgreementUtil.goTermsService(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAgreement() {
//        return this.mmkv.c("splash", false);
        return this.mmkv.getBoolean("splash", false);
    }
}
