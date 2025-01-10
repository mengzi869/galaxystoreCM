package com.clean888.overseas;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.anythink.core.api.ATSDK;
import com.clean888.overseas.util.LOG;

import java.util.HashMap;
import java.util.Map;

public class OverseasSupportApp {

    private static final String TAG_ADJUST = "TAG_ADJUST";
    private static final String TAG_TOPON = "TAG_TOPON";

    private static Application context = null;
    private volatile static OverseasSupportApp instance = null;

    public static OverseasSupportApp INSTANCE() {
        if (instance == null) {
            synchronized (OverseasSupportApp.class) {
                if (instance == null) {
                    instance = new OverseasSupportApp();
                }
            }
        }
        return instance;
    }

    public void onCreate(Application ctx) {
        context = ctx;

        //Android 9及以上必须设置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            String processName = context.getProcessName();
            if (!context.getPackageName().equals(processName)) {
                WebView.setDataDirectorySuffix(processName);
            }
        }
        initAdjust();
        initTopOn();
        initLifecycle();
    }


    private void initAdjust() {

        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        if (!BuildConfig.DEBUG) {
            environment = AdjustConfig.ENVIRONMENT_PRODUCTION;
        }
        AdjustConfig config = new AdjustConfig(context, Constants.adjustAppToken, environment);
        config.setSendInBackground(true);// 启用后台记录
        config.setLogLevel(LogLevel.VERBOSE); // 设置日志级别
        //config.setExternalDeviceId("");// 设置外部设备标识符

        config.setOnAttributionChangedListener(adjustAttribution -> { // 发生归因变化时触发函数
            //TODO 用户归因
            LOG.E(TAG_ADJUST, "onAttributionChanged " + adjustAttribution.toString());
            attributionChanged(adjustAttribution);
        });
        // 会话回传 success 回传
        config.setOnSessionTrackingSucceededListener(adjustSessionSuccess ->
                LOG.D(TAG_ADJUST, "onFinishedSessionTrackingSucceeded " + adjustSessionSuccess.toString())
        );
        // 会话回传 failure 回传
        config.setOnSessionTrackingFailedListener(adjustSessionFailure ->
                LOG.D(TAG_ADJUST, "onFinishedSessionTrackingFailed " + adjustSessionFailure.toString())
        );
        // 事件回传 success 回传
        config.setOnEventTrackingSucceededListener(adjustEventSuccess -> {
            LOG.D(TAG_ADJUST, "onFinishedEventTrackingSucceeded " + adjustEventSuccess.toString());
        });
        // 事件回传 failure 回传
        config.setOnEventTrackingFailedListener(adjustEventFailure -> {
            LOG.D(TAG_ADJUST, "onFinishedEventTrackingFailed " + adjustEventFailure.toString());
        });

        Adjust.onCreate(config);

        Adjust.setEnabled(true);// 禁用或启用 SDK
        String adid = Adjust.getAdid();// Adjust 设备标识符
        Adjust.getGoogleAdId(context, s -> { // Google Play 服务广告 ID

        });
    }

    private static void initTopOn() {
        ATSDK.init(context, Constants.toponAppId, Constants.toponAppKey);
    }


    private static void attributionChanged(AdjustAttribution adjustAttribution) {
        if (adjustAttribution == null) {
            return;
        }
//        boolean adjusted = WaterKV.getKVValue(Const.ADJUST_INIT, false);
//        if (adjusted) {
//            return;
//        }
//        try {
//            setNetwork(adjustAttribution.network);
//            setCampaign(adjustAttribution.campaign);
//            setAdgroup(adjustAttribution.adgroup);
//            Map<String, Object> obj = new HashMap<>();
//            Map<String, Object> commonInfo = new HashMap<>();
//            Map<String, Object> extendParam = new HashMap<>();
//            commonInfo.put("appId", Const.TAG);
//            commonInfo.put("userId", getUserId());
//            commonInfo.put("registerTime", getRegisterTime());
//            commonInfo.put("vn", getVersionName());
//            obj.put("commonInfo", commonInfo);
//            extendParam.put("adgroup", getAdgroup());
//            extendParam.put("adid", adjustAttribution.adid);
//            extendParam.put("clickLabel", adjustAttribution.clickLabel);
//            extendParam.put("campaign", getCampaign());
//            if (Double.isNaN(adjustAttribution.costAmount)) {
//                extendParam.put("costAmount", 0);
//            } else {
//                extendParam.put("costAmount", adjustAttribution.costAmount);
//            }
//            extendParam.put("costCurrency", adjustAttribution.costCurrency);
//            extendParam.put("costType", adjustAttribution.costType);
//            extendParam.put("creative", adjustAttribution.creative);
//            extendParam.put("event", "active");
//            extendParam.put("network", getNetwork());
//            extendParam.put("trackerName", adjustAttribution.trackerName);
//            extendParam.put("trackerToken", adjustAttribution.trackerToken);
//            extendParam.put("deepLinkUrl", "");
//            extendParam.put("ggClickTime", "");
//            extendParam.put("fbInstallReferrer", adjustAttribution.fbInstallReferrer);
//            extendParam.put("clientTime", System.currentTimeMillis());
//            obj.put("extendParam", extendParam);
//            String params = GsonUtils.toJson(obj);
//            Log.e("attributionChanged ---> " + params);
//            WRequest request = new WRequest();
//            request.setSign(XXXXTEA.encryptToBase64String(params));
//            params = GsonUtils.toJson(request);
//            WaterOKHttp.INSTANCE().post(Const.USER_ATTRS, params, new OKCallback() {
//                @Override
//                public void ok(String result) {
//                    try {
//                        if (getNetwork().contains("organic")) {
//
//                        } else {
//                            WaterKV.setKVValue(Const.ADJUST_INIT, true);
//                        }
//                    } catch (Throwable throwable) {
//
//                    }
//                }
//
//                @Override
//                public void opps(String error) {
//
//                }
//            });
//        } catch (Throwable throwable) {
//
//        }
    }

    private static void initLifecycle() {
        context.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Adjust.onResume();
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                Adjust.onPause();
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }


}
