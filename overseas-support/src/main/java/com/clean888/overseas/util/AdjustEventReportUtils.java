package com.clean888.overseas.util;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;

public class AdjustEventReportUtils {

    public static void trackEvent(String key){
        AdjustEvent adjustEvent = new AdjustEvent(key);
        Adjust.trackEvent(adjustEvent);
    }

}
