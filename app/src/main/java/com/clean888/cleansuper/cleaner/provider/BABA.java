package com.clean888.cleansuper.cleaner.provider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.nf_ViewUtils;
import com.clean888.cleansuper.cleaner.utils.y41;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.ui.widget.ZZJ;

public class BABA extends AppWidgetProvider {
    public static void a(Context context, AppWidgetManager appWidgetManager, int i) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_battery);
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_circle_progress, (ViewGroup) null, false);
        int k = bj.k(context);
        ((ZZJ) inflate.findViewById(R.id.phone_status)).a(k, ZZJ.enumType.BATTERY);
        remoteViews.setTextViewText(R.id.tv_battery, k + "%");
        Bitmap a = nf_ViewUtils.view2Bitmap(inflate);
        if (a != null) {
            remoteViews.setImageViewBitmap(R.id.iv_battery, a);
        }
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.putExtra("widgetType", 2);
        remoteViews.setOnClickPendingIntent(R.id.tv_save, PendingIntent.getActivities(context, 17, new Intent[]{new Intent(context, (Class<?>) MainActivity.class), intent}, y41.a(167772160)));
        appWidgetManager.updateAppWidget(i, remoteViews);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i, bundle);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
//        i4.a().i("s_widget").commit();
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onRestored(Context context, int[] iArr, int[] iArr2) {
        super.onRestored(context, iArr, iArr2);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : iArr) {
            a(context, appWidgetManager, i);
        }
    }
}
