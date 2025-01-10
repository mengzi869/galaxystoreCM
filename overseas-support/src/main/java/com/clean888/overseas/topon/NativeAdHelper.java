package com.clean888.overseas.topon;

import static com.clean888.overseas.topon.RevenueReportUtils.handleAdjustRevenueReport;

import android.app.Activity;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeEventListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.NativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.clean888.overseas.Constants;

import java.util.concurrent.atomic.AtomicBoolean;

public class NativeAdHelper extends MaxNativeAdListener {
    private static final String TAG = "BannerAdHelper";
    private static final String AD_UNIT_ID = Constants.AD_TOPON_NATIVE_ID;
    private Activity mAct;

    private ATNative atNative;

    private NativeAd mNativeAd;

    private ATNativeAdView mATNativeAdView;


    private AtomicBoolean nativeIsLoading = new AtomicBoolean(false);

    private static final class Holder {
        private static final NativeAdHelper instance = new NativeAdHelper();
    }

    public static NativeAdHelper getInstance() {
        return Holder.instance;
    }

    public void init(Activity act, ATNativeAdView atNativeAdView) {
        //初始化广告加载对象
        atNative = new ATNative(act, AD_UNIT_ID, new ATNativeNetworkListener() {
            @Override
            public void onNativeAdLoaded() {
            }

            @Override
            public void onNativeAdLoadFail(AdError adError) {
                //注意：禁止在此回调中执行广告的加载方法进行重试，否则会引起很多无用请求且可能会导致应用卡顿
            }
        });
        this.mATNativeAdView = atNativeAdView;
    }

    public void load() {
        if (atNative != null) {
            //发起广告请求
            if (nativeIsLoading.get()) {
                return;
            }
            nativeIsLoading.set(true);
            atNative.makeAdRequest();
        }
    }

    public void show() {
        if (atNative != null) {
            mNativeAd = atNative.getNativeAd();
            if (mNativeAd != null) {
                mNativeAd.setNativeEventListener(new ATNativeEventListener() {
                    @Override
                    public void onAdImpressed(ATNativeAdView view, ATAdInfo atAdInfo) {
                    }

                    @Override
                    public void onAdClicked(ATNativeAdView view, ATAdInfo atAdInfo) {
                    }

                    @Override
                    public void onAdVideoStart(ATNativeAdView view) {
                    }

                    @Override
                    public void onAdVideoEnd(ATNativeAdView view) {
                    }

                    @Override
                    public void onAdVideoProgress(ATNativeAdView view, int progress) {
                    }
                });
                mNativeAd.setAdRevenueListener(atAdInfo -> {
                    handleAdjustRevenueReport(atAdInfo);
                });
                if (mNativeAd.isNativeExpress()) {
                    //模板渲染
                    nativeIsLoading.set(false);
                    mNativeAd.renderAdContainer(mATNativeAdView, null);
                    mNativeAd.prepare(mATNativeAdView, null);
                }
            }
        }

    }


    public void releaseAd() {
        if (mNativeAd != null) {
            mNativeAd.destory();
        }
        if (atNative != null) {
            atNative.setAdListener(null);
            atNative.setAdSourceStatusListener(null);
            atNative.setAdMultipleLoadedListener(null);
        }
    }
}

