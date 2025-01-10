package com.clean888.cleansuper.cleaner.receiver;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.clean888.cleansuper.cleaner.receiver.utils.mj;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.provider.BABA;
import com.clean888.cleansuper.cleaner.provider.BABB;
import com.clean888.cleansuper.cleaner.provider.BABC;
import com.clean888.cleansuper.cleaner.provider.BABD;
import com.clean888.cleansuper.cleaner.service.BAAH;

// BAFK
public class WidgetReceiver extends BroadcastReceiver {

    private static final String TAG = "Widget-Receiver-BAFK";

    private void a(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) BABD.class));
        if (appWidgetIds.length > 0) {
            for (int i : appWidgetIds) {
                BABD.a(context, appWidgetManager, i);
            }
        }
    }

    private void b(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) BABA.class));
        if (appWidgetIds.length > 0) {
            for (int i : appWidgetIds) {
                BABA.a(context, appWidgetManager, i);
            }
        }
    }

    private void c(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) BABB.class));
        if (appWidgetIds.length > 0) {
            for (int i : appWidgetIds) {
                BABB.a(context, appWidgetManager, i);
            }
        }
    }

    private void d(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) BABC.class));
        if (appWidgetIds.length > 0) {
            for (int i : appWidgetIds) {
                BABC.a(context, appWidgetManager, i);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            L.d(TAG,"onReceive intent == null || intent.getAction() == null so return");
            return;
        }
        String action = intent.getAction();
        L.d(TAG,"onReceive action = "+action);
        if (!action.equals(Intent.ACTION_TIME_TICK) && !action.equals("customer.intent.action.TIME_TICK")) {
            if (intent.getAction().equals(Intent.ACTION_DATE_CHANGED)) {
                BAAH.f(context);
            }
        } else {
            mj.a(context);
            BAAH.f(context);
            a(context);
            c(context);
            b(context);
            d(context);
        }
    }
}
