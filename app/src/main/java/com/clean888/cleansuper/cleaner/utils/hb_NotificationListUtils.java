package com.clean888.cleansuper.cleaner.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.service.notification.NotificationListenerService;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.bean.cc;

import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.service.BAAI;
import com.jeremyliao.liveeventbus.LiveEventBus;

import java.util.ArrayList;

/* hb loaded from: classes2.dex */
public class hb_NotificationListUtils {

    private static final String TAG = "Notification-ListUtils";
    private static volatile hb_NotificationListUtils myUtils;
    private ArrayList<cc> list = new ArrayList<>();
    private Handler handler = new Handler();
    private boolean bflag = false;
    private int d = 0;


    private hb_NotificationListUtils() {
    }

    public static hb_NotificationListUtils getInstance() {
        if (myUtils == null) {
            synchronized (hb_NotificationListUtils.class) {
                if (myUtils == null) {
                    myUtils = new hb_NotificationListUtils();
                }
            }
        }
        return myUtils;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class runnable implements Runnable {
        runnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L.e(TAG, "runnable bflag = " + hb_NotificationListUtils.this.bflag);
            if (hb_NotificationListUtils.this.bflag) {
                return;
            }
            hb_NotificationListUtils.this.j(SuperApplication.getContext());
        }
    }


    private void h(cc ccVar) {
        if (ccVar == null || ccVar.pendingIntent == null || ccVar.title == null || !"com.tencent.mobileqq".equals(ccVar.packageName)) {
            return;
        }
        String m = m(ccVar.title.toString());
        if (TextUtils.isEmpty(m)) {
            return;
        }
        PendingIntent pendingIntent = ccVar.pendingIntent;
        for (int i = 0; i < this.list.size(); i++) {
            cc ccVar2 = this.list.get(i);
            if (ccVar2 != null && "com.tencent.mobileqq".equals(ccVar2.packageName) && !TextUtils.isEmpty(ccVar2.title) && m.equals(m(ccVar2.title.toString()))) {
                ccVar2.pendingIntent = pendingIntent;
            }
        }
    }

    private String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(40);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    public void addAll(ArrayList<cc> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.list.addAll(arrayList);
        LiveEventBus.get("notification_clean_event").post(0);
    }

    public void add(cc ccVar) {

        if (ccVar != null) {
            this.list.add(0, ccVar);
            h(ccVar);
            LiveEventBus.get("notification_clean_event").post(0);
        }
    }

    public void clear() {
        int size = this.list.size();
        if (size > 0) {
            this.list.clear();
            a_mmkv.h().d(size);
        }
    }

    public ArrayList<cc> getList() {
        return this.list;
    }


//    public android.app.Notification g(android.content.Context r11) {
//        return null;
////        throw new UnsupportedOperationException("Method not decompiled: defpackage.hb.g(android.content.Context):android.app.Notification");
//    }

    public android.app.Notification createBlockedNotification(android.content.Context context) {

        if (context == null) {
            return null;
        }

        // 获取需要显示的元素数量
        int size = list.size();
        // 创建自定义布局
        android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(
                context.getPackageName(),
                R.layout.layout_notification_clean
        );

        // 设置通知的文字内容
        String countText = String.valueOf(size);
        remoteViews.setTextViewText(R.id.tv_notification_num, countText);

        // 处理自定义数据列表
        ArrayList<cc> filteredList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cc data = list.get(i);
            if (data != null && !TextUtils.isEmpty(data.getTitle())) {
                boolean isDuplicate = false;
                for (cc filteredData : filteredList) {
                    if (filteredData != null && data.getTitle().equals(filteredData.getTitle())) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    filteredList.add(data);
                }
            }
        }

        // 设置显示图片
        int[] viewIds = {R.id.iv_notification_icon_1, R.id.iv_notification_icon_2, R.id.iv_notification_icon_3};
        for (int i = 0; i < filteredList.size() && i < 3; i++) {
            cc data = filteredList.get(i);
            if (data != null && data.getBitmap() != null) {
                remoteViews.setImageViewBitmap(viewIds[i], data.getBitmap());
                remoteViews.setViewVisibility(viewIds[i], View.VISIBLE);
            }
        }

        if (filteredList.size() > 3) {
            remoteViews.setViewVisibility(R.id.iv_more, View.VISIBLE);
        } else {
            remoteViews.setViewVisibility(R.id.iv_more, View.GONE);
        }

        // 创建清除通知的 PendingIntent
        android.content.Intent intent = new android.content.Intent(context, BAAI.class);
        intent.setAction("action.notification_clean");

        int FLAG = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ? PendingIntent.FLAG_IMMUTABLE : PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, FLAG);
        remoteViews.setOnClickPendingIntent(R.id.tv_notification_clean, pendingIntent);

        String channelId = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channelId = createNotificationChannel(context, "default_channel_id", "default_channel_name");
        } else {
            channelId = "default";
        }

        // 使用 NotificationCompat.Builder 创建通知
        androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
                .setContent(remoteViews)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.img_notification_tag)
                .setAutoCancel(true);
        // 构建并返回通知
        return builder.build();
    }

    /**
     * 创建通知通道
     *
     * @param channelId
     * @param channelName
     * @return
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private String createNotificationChannel(android.content.Context context, String channelId, String channelName) {
        NotificationChannel chan = new NotificationChannel(channelId,
                channelName, NotificationManager.IMPORTANCE_DEFAULT);
        chan.setLightColor(Color.BLUE);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager service = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        service.createNotificationChannel(chan);
        return channelId;
    }

    public void i(cc ccVar) {
        if (ccVar != null) {
            this.list.remove(ccVar);
            a_mmkv.h().d(1L);
            LiveEventBus.get("notification_clean_event").post(1);
            BAAI.h(SuperApplication.getContext());
        }
    }

    public void j(Context context) {

        if (context == null || !jc.b()) {
            L.e(TAG, "j return by " + (context == null) + " " + (!jc.b()));
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                NotificationListenerService.requestRebind(new ComponentName(context, (Class<?>) BAAI.class));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) BAAI.class), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) BAAI.class), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            L.e(TAG, "BAAI Service start SUCCESS");
        } catch (Throwable th2) {
            L.e(TAG, "BAAI Service start ERROR");
            th2.printStackTrace();
        }
    }

    public void perStart() {
        L.e(TAG, "perStart " + jc.b());
        if (jc.b()) {
            this.handler.postDelayed(new runnable(), 8000L);
        }
    }

    public void setFlag(boolean z) {
        this.bflag = z;
    }
}