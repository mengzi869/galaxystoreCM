package com.clean888.overseas.topon;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.anythink.banner.api.ATBannerListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;

import java.util.concurrent.atomic.AtomicBoolean;

public class BannerAdHelper {
    private static final String TAG = "BannerAdHelper";
    private static final String AD_UNIT_ID = "cc134c3b9dbdd014";

    private ATBannerView adView;

    private FrameLayout mParent;

    private AtomicBoolean bannerIsLoading = new AtomicBoolean(false);

    private static final class Holder {
        private static final BannerAdHelper instance = new BannerAdHelper();
    }

    public static BannerAdHelper getInstance() {
        return Holder.instance;
    }


    public void preInit(Activity act, FrameLayout adContainer) {
        adView = new ATBannerView(act);
        adView.setVisibility(View.GONE);
        adView.setPlacementId(AD_UNIT_ID);
        int width = act.getResources().getDisplayMetrics().widthPixels;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        adView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
        adView.setAdRevenueListener(atAdInfo -> {

        });
        adView.setBannerAdListener(atBannerListener);
        adContainer.addView(adView);
        this.mParent = adContainer;
    }

    private void load() {
        if (bannerIsLoading.get()) {
            return;
        }
        adView.setVisibility(View.VISIBLE);
        bannerIsLoading.set(true);
        adView.loadAd();
    }

    public void onDestory() {
        if (adView != null) {
            adView.destroy();
        }

        if (mParent != null) {
            mParent.removeAllViews();
        }

    }


    ATBannerListener atBannerListener = new ATBannerListener() {
        @Override
        public void onBannerLoaded() {
            bannerIsLoading.set(false);
        }

        @Override
        public void onBannerFailed(AdError adError) {

        }

        @Override
        public void onBannerClicked(ATAdInfo atAdInfo) {

        }

        @Override
        public void onBannerShow(ATAdInfo atAdInfo) {

        }

        @Override
        public void onBannerClose(ATAdInfo atAdInfo) {
            if (adView != null && adView.getParent() != null) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
        }

        @Override
        public void onBannerAutoRefreshed(ATAdInfo atAdInfo) {

        }

        @Override
        public void onBannerAutoRefreshFail(AdError adError) {

        }
    };


}
