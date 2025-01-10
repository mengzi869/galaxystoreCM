package com.clean888.cleansuper.cleaner.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

import androidx.annotation.NonNull;

import com.clean888.cleansuper.cleaner.receiver.utils.BatteryActionCheckUtil;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.service.BAAH;

// BAGY
public final class BatteryActionReceiver extends BroadcastReceiver {

    private static final String TAG = "BatteryActionReceiver";

    private boolean aisCharging;
    private int blevel = 100;

    public int getLevel() {
        return this.blevel;
    }

    public boolean isCharging() {
        return this.aisCharging;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();

        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            L.e(TAG, "onReceive action = " + action);
            BatteryActionCheckUtil.checkPowerConnected(context);
            return;
        }
        if (action.equals(Intent.ACTION_BATTERY_CHANGED)) { // 电池状态的变化
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1); // 获取电池的状态，可能的值包括：
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1); // 获取当前电池的电量百分比。
            int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0); // 获取当前的充电方式
            boolean z = status == 2 || status == 5;
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;
            String pluggedType = getPluggedType(plugged);

            L.e(TAG, "onReceive action = " + action + " status:" + status + " isCharging:" + isCharging + " level:" + level + " pluggedType:" + pluggedType+" z:"+z);

            if (this.aisCharging != isCharging) {
                this.aisCharging = isCharging;
                L.d(TAG,"aisCharging != isCharging  BAAH.f(context) aisCharging:"+aisCharging);
                BAAH.f(context);
            } else if (!isCharging && this.blevel != level) {
                this.blevel = level;
                L.d(TAG,"!isCharging && this.blevel != level  BAAH.f(context) blevel:"+blevel);
                BAAH.f(context);
            }
            this.blevel = level;
        }
    }

    @NonNull
    private static String getPluggedType(int plugged) {
        String pluggedType = "unknow";
        if (plugged == BatteryManager.BATTERY_PLUGGED_AC) { // 交流电充电
            pluggedType = "AC";
        } else if (plugged == BatteryManager.BATTERY_PLUGGED_USB) { // USB充电
            pluggedType = "USB";
        } else if (plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS) { // 无线充电
            pluggedType = "Wireless";
        } else if (plugged == BatteryManager.BATTERY_PLUGGED_DOCK) { // 底座充电‌
            pluggedType = "Dock";
        }
        return pluggedType;
    }
}
