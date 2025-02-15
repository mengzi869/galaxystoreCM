package com.clean888.overseas.topon;

import static com.clean888.overseas.topon.RevenueReportUtils.handleAdjustRevenueReport;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.clean888.overseas.thread.ThreadUtils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import com.clean888.overseas.Constants;
import com.clean888.overseas.util.adCallback;
import com.clean888.overseas.util.y3;
public class InterstitialAdHelper {
    private static final String TAG = "InterstitialAdHelper";
    private String AD_UNIT_ID = Constants.AD_TOPON_INTER_ID;

    private static int AD_REQUEST_MAX_COUNT = 2;

    private AtomicInteger interstitialIsLoading = new AtomicInteger(0);

    private static AtomicInteger retryAttemptInter = new AtomicInteger(0);

    private static ConcurrentHashMap<String, List<String>> localADSourceInfo = new ConcurrentHashMap(8);

    private Activity mActivity;

    private adCallback mAdCallback;

    private ATInterstitialListener attInterstitialListener;

    private ATInterstitial attInterstitialAd;

    private static final int MSG_MAX_LOAD_INTERSTITIAL = 0x100;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_MAX_LOAD_INTERSTITIAL:
                    String inter_ad_unitId = (String) msg.obj;
                    loadInterAd(inter_ad_unitId);
                    break;

            }
        }
    };

    private void loadInterAd(String inter_ad_unitId) {
        if (interstitialIsLoading.get() == AD_REQUEST_MAX_COUNT) {
            return;
        }
        Log.d(TAG,"load inter:" + inter_ad_unitId);
        if (attInterstitialAd == null) {
            attInterstitialAd = new ATInterstitial(mActivity, inter_ad_unitId);
        }
        attInterstitialListener = new AttInterstitialListener(inter_ad_unitId);
        attInterstitialAd.setAdListener(attInterstitialListener);
        attInterstitialAd.load();
        int i = interstitialIsLoading.get();
        i++;
        interstitialIsLoading.set(i);
    }


    InterstitialAdHelper() {
    }

    private static final class Holder {
        private static final InterstitialAdHelper instance = new InterstitialAdHelper();
    }

    public static InterstitialAdHelper getInstance() {
        return Holder.instance;
    }

    public void load(Activity act) {
        this.mActivity = act;
        loadInterstitial();
    }

    private void loadInterstitial() {
        if (interstitialIsLoading.get() == AD_REQUEST_MAX_COUNT) {
            return;
        }
        Log.d(TAG,"perload Interstitial5:" + AD_UNIT_ID);
        long waitAdLoadingMillis = getLoadAdDelayMillis(retryAttemptInter.get());
        if (waitAdLoadingMillis > 0 && retryAttemptInter.get() > 0) {
            mHandler.removeMessages(MSG_MAX_LOAD_INTERSTITIAL);
            loadInterAd(AD_UNIT_ID, getLoadAdDelayMillis(retryAttemptInter.get()));
            return;
        }
        loadInterAd(AD_UNIT_ID, 0L);

    }

    public boolean showInterstitialAd(Activity act,adCallback mAdCallback) {
        this.mActivity = act;
        if (attInterstitialAd == null) {
            load(act);
        } else {
            String adUnitId = attInterstitialAd.mPlacementId;
            if (attInterstitialAd.isAdReady()) {
                attInterstitialListener = new AttInterstitialListener(adUnitId);
                attInterstitialAd.setAdListener(attInterstitialListener);
                attInterstitialAd.setAdRevenueListener(atAdInfo -> {
                    //TODO 价值回传，各个平台的广告价值回传
                    handleAdjustRevenueReport(atAdInfo);
                });
                this.mAdCallback = mAdCallback;
                attInterstitialAd.show(act);
                return true;
            } else {
                load(act);
            }
        }
        return false;
    }


    private List<String> getLoadInterstitialId(String locationCode) {
        List<String> adSource = getAdSource(locationCode);
        return adSource;
    }

    public List<String> getAdSource(String code) {
        if (localADSourceInfo == null) {
            localADSourceInfo = new ConcurrentHashMap<>(2);
        }
        code = code == null ? "" : code;
        List<String> adList = localADSourceInfo.get(code);
        if (adList == null) {
            initLocalPlacement();
            adList = localADSourceInfo.get(code);
        }

        return adList;
    }

    private void initLocalPlacement() {
        if (localADSourceInfo == null) {
            localADSourceInfo = new ConcurrentHashMap<>(2);
        }
        initLocalAdSource();

    }


    private void initLocalAdSource() {
        //获取广告配置
    }

    //即时展示插屏广告
    public boolean immediateShow() {
//        if (cacheAdMap.get(AD_UNIT_ID) != null && interstitialAd != null && interstitialAd.isReady()) {
//            interstitialAd.showAd();
//            return true;
//        }
        return false;
    }

    private void loadInterAd(String adId, long waitAdLoadingMillis) {
        if (adId != null) {
            Message message = new Message();
            message.obj = adId;
            message.what = MSG_MAX_LOAD_INTERSTITIAL;
            mHandler.sendMessageDelayed(message, waitAdLoadingMillis);
        }
    }


    private Runnable delayFailCallback = new Runnable() {
        @Override
        public void run() {
            if (interstitialIsLoading.get() == AD_REQUEST_MAX_COUNT) {
                return;
            }
            Log.d(TAG,"load inter:" + AD_UNIT_ID);
            attInterstitialAd = new ATInterstitial(mActivity, AD_UNIT_ID);
            attInterstitialListener = new AttInterstitialListener(AD_UNIT_ID);
            attInterstitialAd.setAdListener(attInterstitialListener);
            attInterstitialAd.load();
            int i = interstitialIsLoading.get();
            i++;
            interstitialIsLoading.set(i);
        }
    };

    private class AttInterstitialListener implements ATInterstitialListener {
        private String adUnitId;

        public AttInterstitialListener(String adUnitId) {
            this.adUnitId = adUnitId;
        }


        @Override
        public void onInterstitialAdLoaded() {
            Log.e(TAG, "onAdLoaded...");
            int i = interstitialIsLoading.get();
            if (i > 0) {
                i--;
            }
            interstitialIsLoading.set(i);
            retryAttemptInter.set(0);
            ThreadUtils.mMainHandler.removeCallbacks(delayFailCallback);
        }

        @Override
        public void onInterstitialAdLoadFail(AdError adError) {
            //TODO 暂时这样写，重试机制，后续测试看效果，如果效果不好，去除改重试机制
//            Log.d(TAG, "onAdLoadFailed..." + adError.getPlatformMSG());
            if (retryAttemptInter == null) {
                retryAttemptInter = new AtomicInteger(0);
            }
            int i = interstitialIsLoading.get();
            if (i > 0) {
                i--;
            }
            interstitialIsLoading.set(i);
            retryAttemptInter.set(retryAttemptInter.get() + 1);
            loadInterstitial();
        }

        @Override
        public void onInterstitialAdClicked(ATAdInfo atAdInfo) {
        }

        @Override
        public void onInterstitialAdShow(ATAdInfo atAdInfo) {

        }

        @Override
        public void onInterstitialAdClose(ATAdInfo atAdInfo) {
            Log.d(TAG, "onAdHidden...");
            loadInterstitial();
            if(mAdCallback != null){
                mAdCallback.onAdClose(new y3(atAdInfo.getAdsourceId(),atAdInfo.getEcpm(),0));
            }
        }

        @Override
        public void onInterstitialAdVideoStart(ATAdInfo atAdInfo) {

        }

        @Override
        public void onInterstitialAdVideoEnd(ATAdInfo atAdInfo) {

        }

        @Override
        public void onInterstitialAdVideoError(AdError adError) {
            loadInterstitial();
        }

    }

    /**
     * 广告请求失败之后，再次请求，会有一个错误时间间隔
     *
     * @param retryAttempt
     * @return
     */
    public long getLoadAdDelayMillis(int retryAttempt) {
        if (retryAttempt == 0) {
            return 0L;
        }
        long pow = (long) Math.pow(2, retryAttempt);
        if (pow >= 5 * 64) {
            pow = 5 * 64;
        }
        return TimeUnit.SECONDS.toMillis(pow);
    }

}
