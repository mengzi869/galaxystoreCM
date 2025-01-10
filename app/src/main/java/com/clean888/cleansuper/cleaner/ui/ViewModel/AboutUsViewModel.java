package com.clean888.cleansuper.cleaner.ui.ViewModel;

import android.content.Context;
import androidx.lifecycle.ViewModel;

import com.clean888.cleansuper.cleaner.utils.AboutMe.AgreementUtil;

public class AboutUsViewModel extends ViewModel {
    public void goPrivacyPolicy(Context context) {
        AgreementUtil.goPrivacyPolicy(context);
    }

    public void goTermsOfService(Context context) {
        AgreementUtil.goTermsService(context);
    }
}
