package com.clean888.cleansuper.cleaner.ui.ViewModel;

import static com.blankj.utilcode.util.AppUtils.getAppPackageName;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.clean888.cleansuper.cleaner.utils.AboutMe.AgreementUtil;
import com.blankj.utilcode.util.Utils;
import com.clean888.cleansuper.cleaner.utils.L;

public class MeViewModel extends ViewModel {
    public int getInstallDay() {
        try {
            long firstInstallTime = Utils.getApp().getPackageManager().getPackageInfo(getAppPackageName(), 0).firstInstallTime;
            long dis = (System.currentTimeMillis() - firstInstallTime) / (24 * 60 * 60 * 1000) + 1;
            L.e("MeViewModel", "yyz====== dis: " + dis + ", firstInstallTime= " + firstInstallTime);
            if (dis >= 0) {
                return (int) dis;
            }
            return 1;
        } catch (Exception e) {
            return 1;
        }
    }

    public void goPrivacyPolicy(Context context) {
        AgreementUtil.goPrivacyPolicy(context);
    }

    public void goTermsOfService(Context context) {
        AgreementUtil.goTermsService(context);
    }
}
