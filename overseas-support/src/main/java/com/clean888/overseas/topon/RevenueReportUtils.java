package com.clean888.overseas.topon;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAdRevenue;
import com.adjust.sdk.AdjustConfig;
import com.anythink.core.api.ATAdInfo;

public class RevenueReportUtils {

    public static void handleAdjustRevenueReport(ATAdInfo atAdInfo) {
        //adjust4.38.1及以上支持
        AdjustAdRevenue adjustAdRevenue = new AdjustAdRevenue(AdjustConfig.AD_REVENUE_TOPON);
        adjustAdRevenue.setRevenue(atAdInfo.getPublisherRevenue(), atAdInfo.getCurrency()); // 记录广告收入额

        //可选配置
        adjustAdRevenue.setAdRevenueNetwork(String.valueOf(atAdInfo.getNetworkFirmId()));// 广告收入渠道
        adjustAdRevenue.setAdRevenueUnit(atAdInfo.getAdsourceId());// 广告收入单元
        adjustAdRevenue.setAdRevenuePlacement(atAdInfo.getPlacementId());// 广告收入位置
        // adjustAdRevenue.addCallbackParameter("key","value"); // 添加回传参数

        //发送收益数据 发送广告收入
        Adjust.trackAdRevenue(adjustAdRevenue);
    }
}
