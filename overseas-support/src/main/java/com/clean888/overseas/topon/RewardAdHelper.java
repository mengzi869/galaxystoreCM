package com.clean888.overseas.topon;


import static com.clean888.overseas.topon.RevenueReportUtils.handleAdjustRevenueReport;

import android.app.Activity;
import android.util.Log;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.clean888.overseas.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RewardAdHelper {
    private static final String TAG = "RewardAdHelper";
    private volatile String AD_UNIT_ID = Constants.AD_TOPON_REWARD_ID;

    private ATRewardVideoAd atRewardVideoAd;


    private static final class Holder {
        private static final RewardAdHelper instance = new RewardAdHelper();
    }

    public static RewardAdHelper getInstance() {
        return Holder.instance;
    }


    public void init(Activity activity) {
        atRewardVideoAd = new ATRewardVideoAd(activity, AD_UNIT_ID);
        setRewardExtra();
        atRewardVideoAd.setAdListener(atRewardVideoListener);
        atRewardVideoAd.setAdRevenueListener(atAdInfo -> {
            handleAdjustRevenueReport(atAdInfo);
        });
    }


    public void load(Activity act) {
        if (atRewardVideoAd == null) {
            init(act);
        } else {
            atRewardVideoAd.load();
        }
    }

    public void show(Activity act) {
        if (atRewardVideoAd.isAdReady()) {
            atRewardVideoAd.show(act, getATShowConfig());
        }
    }

    private ATShowConfig getATShowConfig() {
        ATShowConfig.Builder builder = new ATShowConfig.Builder();
        builder.scenarioId("reward_video_ad_show_1");
        builder.showCustomExt("reward_video_ad_show_custom_ext");
        return builder.build();
    }

    ATRewardVideoListener atRewardVideoListener = new ATRewardVideoListener() {

        @Override
        public void onRewardedVideoAdLoaded() {
            //如果没有缓存，可以修改为直接加载显示
            Log.d(TAG," onRewardedVideoAdLoaded");
        }

        @Override
        public void onRewardedVideoAdFailed(AdError adError) {
            //注意：禁止在此回调中执行广告的加载方法进行重试，否则会引起很多无用请求且可能会导致应用卡顿
            Log.d(TAG,"onRewardedVideoAdFailed " + adError.toString());
        }

        @Override
        public void onRewardedVideoAdPlayStart(ATAdInfo atAdInfo) {
            Log.d(TAG,"onRewardedVideoAdPlayStart: " + atAdInfo.toString());
            Object showCustomExt = getUserCustomDataOnLoaded(atAdInfo);
            //建议在此回调中调用load进行广告的加载，方便下一次广告的展示（不需要调用isAdReady()）
            if (atRewardVideoAd != null) {
                atRewardVideoAd.load();
            }
        }

        @Override
        public void onRewardedVideoAdPlayEnd(ATAdInfo atAdInfo) {

        }

        @Override
        public void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo atAdInfo) {
            Log.d(TAG,"onRewardedVideoAdPlayFailed" + adError.toString());

        }

        @Override
        public void onRewardedVideoAdClosed(ATAdInfo atAdInfo) {

        }

        @Override
        public void onRewardedVideoAdPlayClicked(ATAdInfo atAdInfo) {

        }

        @Override
        public void onReward(ATAdInfo atAdInfo) {
            //建议在此回调中下发奖励
        }
    };


    public static long getLoadAdDelayMillis(int retryAttempt) {
        if (retryAttempt == 0) {
            return 0L;
        }
        long pow = (long) Math.pow(2, retryAttempt);
        if (pow >= 5 * 64) {
            pow = 5 * 64;
        }
        return TimeUnit.SECONDS.toMillis(pow);
    }

    private void setRewardExtra() {
        String userdata = "test_userdata_001";
        Map<String, Object> localMap = new HashMap<>();
        localMap.put(ATAdConst.KEY.USER_CUSTOM_DATA, userdata);
        if (atRewardVideoAd != null) {
            //在广告加载前设置激励相关参数
            atRewardVideoAd.setLocalExtra(localMap);
        }
    }

    private Object getUserCustomDataOnLoaded(ATAdInfo adInfo) {
        if (adInfo != null) {
            Map localExtraMap = adInfo.getLocalExtra();
            if (localExtraMap != null) {
                //通过key（和广告加载前设置的key一致）获取自定义的参数
                Object userCustomData = localExtraMap.get(ATAdConst.KEY.USER_CUSTOM_DATA);
                //利用自定义参数userCustomData处理您的逻辑
                //...

                return userCustomData;
            }
        }
        return null;
    }


}
