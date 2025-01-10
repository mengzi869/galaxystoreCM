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

import androidx.exifinterface.media.ExifInterface;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.nf_ViewUtils;
import com.clean888.cleansuper.cleaner.utils.y41;
import com.clean888.cleansuper.cleaner.ui.widget.ZZJ;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.tf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BABD extends AppWidgetProvider {
    private static final String TAG = "Widget-BABD";
    public static void a(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        L.e(TAG,"a() appWidgetId = "+appWidgetId);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_all);
        b(context, remoteViews);
        Calendar calendar = Calendar.getInstance();
        Locale locale = Locale.ENGLISH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy", locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(ExifInterface.LONGITUDE_EAST, locale);
        remoteViews.setTextViewText(R.id.tv_time, simpleDateFormat2.format(calendar.getTime()));
        remoteViews.setTextViewText(R.id.tv_date, simpleDateFormat.format(calendar.getTime()));
        remoteViews.setTextViewText(R.id.tv_week, simpleDateFormat3.format(calendar.getTime()));
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_circle_progress, (ViewGroup) null, false);
        ((ZZJ) inflate.findViewById(R.id.phone_status)).a(bj.m(context), ZZJ.enumType.BOOST);
        Bitmap a = nf_ViewUtils.view2Bitmap(inflate);
        if (a != null) {
            remoteViews.setImageViewBitmap(R.id.iv_phone_boost, a);
        }
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.widget_circle_progress, (ViewGroup) null, false);
        ((ZZJ) inflate2.findViewById(R.id.phone_status)).a(100 - ((int) (tf.c(context) * 100.0f)), ZZJ.enumType.CLEAN);
        remoteViews.setTextViewText(R.id.tv_clean, tf.a(context));
        Bitmap a2 = nf_ViewUtils.view2Bitmap(inflate2);
        if (a2 != null) {
            remoteViews.setImageViewBitmap(R.id.iv_clean, a2);
        }
        View inflate3 = LayoutInflater.from(context).inflate(R.layout.widget_circle_progress, (ViewGroup) null, false);
        ((ZZJ) inflate3.findViewById(R.id.phone_status)).a(bj.k(context), ZZJ.enumType.BATTERY);
        Bitmap a3 = nf_ViewUtils.view2Bitmap(inflate3);
        if (a3 != null) {
            remoteViews.setImageViewBitmap(R.id.iv_battery, a3);
        }
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }


    private static void b(Context context, RemoteViews remoteViews) {
        L.d(TAG,"b()");
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.putExtra("widgetType", 1);
        remoteViews.setOnClickPendingIntent(R.id.fl_booster, PendingIntent.getActivities(context, 16, new Intent[]{new Intent(context, (Class<?>) MainActivity.class), intent}, y41.a(PendingIntent.FLAG_UPDATE_CURRENT)));
        Intent intent2 = new Intent(context, (Class<?>) SplashActivity.class);
        intent2.putExtra("widgetType", 2);
        remoteViews.setOnClickPendingIntent(R.id.fl_battery, PendingIntent.getActivities(context, 17, new Intent[]{new Intent(context, (Class<?>) MainActivity.class), intent2}, y41.a(PendingIntent.FLAG_UPDATE_CURRENT)));
        Intent intent3 = new Intent(context, (Class<?>) SplashActivity.class);
        intent3.putExtra("widgetType", 3);
        remoteViews.setOnClickPendingIntent(R.id.ll_clean, PendingIntent.getActivities(context, 18, new Intent[]{new Intent(context, (Class<?>) MainActivity.class), intent3}, y41.a(PendingIntent.FLAG_UPDATE_CURRENT)));
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
        L.e(TAG,"onUpdate() iArr.length = "+iArr.length);
        for (int i : iArr) {
            L.d(TAG,"onUpdate() iArr[] = "+i);
            a(context, appWidgetManager, i);
        }
    }
}
