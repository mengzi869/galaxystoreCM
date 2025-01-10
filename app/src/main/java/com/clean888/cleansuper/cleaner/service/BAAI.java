package com.clean888.cleansuper.cleaner.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Observer;

import com.clean888.cleansuper.cleaner.BuildConfig;
import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.fc;
import com.clean888.cleansuper.cleaner.utils.gc;
import com.clean888.cleansuper.cleaner.utils.hb_NotificationListUtils;
import com.clean888.cleansuper.cleaner.utils.hc_PackageManagerUtil;
import com.clean888.cleansuper.cleaner.utils.jc;
import com.clean888.cleansuper.cleaner.bean.cc;
import com.clean888.cleansuper.cleaner.bean.dc_packageInfo;
import com.clean888.cleansuper.cleaner.ui.activity.BAAX;
import com.clean888.cleansuper.cleaner.ui.activity.BAAY;
import com.jeremyliao.liveeventbus.LiveEventBus;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@RequiresApi(api = 19)
@SuppressLint({"OverrideAbstract"})
/* loaded from: classes2.dex */
public class BAAI extends NotificationListenerService {
    private static final String TAG = "Notification-BAAI";

    private static boolean c = false;
    public static boolean d = false;
    private Handler a = new Handler();
    private Observer<Boolean> b = new a();


    /* loaded from: classes2.dex */
    class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            L.e(TAG, "onChanged "+bool);
            if (bool.booleanValue()) {
                BAAI.this.onStartCommand(new Intent("action.notification_update"), 0, 0);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        L.e(TAG, "onCreate");
        LiveEventBus.get("resident_update_event", Boolean.class).observeForever(this.b);
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public IBinder onBind(Intent intent) {
        L.e(TAG, "onBind setFlag(true)");
        hb_NotificationListUtils.getInstance().setFlag(true);
        return super.onBind(intent);
    }

    @SuppressLint("ForegroundServiceType")
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            L.e(TAG, "onStartCommand action:"+action);

            if ("action.notification_clean".equals(action)) {
                bj.g(SuperApplication.getContext());
                String l = bj.l(this);
                if (bj.j(this, BAAY.class.getName()).equals(l) || bj.j(this, BAAX.class.getName()).equals(l)) {
                    return START_NOT_STICKY;
                }
//                i4.a().i("c_ncleaner").commit();
                jc.a();
                BAAX.startNotificationCleanActivity(this);
            } else if ("action.notification_list".equals(action)) {
                bj.g(SuperApplication.getContext());
                String l2 = bj.l(this);
                if (bj.j(this, BAAY.class.getName()).equals(l2) || bj.j(this, BAAX.class.getName()).equals(l2)) {
                    return START_NOT_STICKY;
                }
//                i4.a().i("c_ncleaner").commit();
                jc.a();
                BAAX.startNotificationCleanActivity(this);
            } else if ("action.notification_update".equals(action)) {
                if (hb_NotificationListUtils.getInstance().getList().size() > 0) {
                    Notification g2 = hb_NotificationListUtils.getInstance().createBlockedNotification(this);
                    if (g2 != null) {
                        startForeground(2, g2);
                    }
                } else {
                    stopForeground(true);
                }
            }
        }else {
            L.e(TAG, "onStartCommand intent is Null");
        }
        return START_STICKY;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        L.e(TAG, "onUnbind setFlag(false)");
        hb_NotificationListUtils.getInstance().setFlag(false);
        hb_NotificationListUtils.getInstance().j(this);
        return super.onUnbind(intent);
    }


    @SuppressLint("ForegroundServiceType")
    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        L.e(TAG, "onNotificationPosted");
        if (!c) {
            e();
            c = true;
        }
        cc c2 = c(statusBarNotification);
        if (c2 != null) {
            hb_NotificationListUtils.getInstance().add(c2);
            Notification g2 = hb_NotificationListUtils.getInstance().createBlockedNotification(this);

            if (g2 != null) {
//                i4.a().i("s_ncleaner").commit();
                try {
                    if (Build.VERSION.SDK_INT >= 34) {
                        startForeground(2, g2, ServiceInfo.FOREGROUND_SERVICE_TYPE_REMOTE_MESSAGING);
                    } else {
                        startForeground(2, g2);
                    }
                } catch (Exception unused) {
                    unused.printStackTrace();

                }
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        L.e(TAG, "onNotificationRemoved");
        if (statusBarNotification != null && BuildConfig.APPLICATION_ID.equals(statusBarNotification.getPackageName()) && statusBarNotification.getId() == 2) {
            clear();
        }
    }


    @Override // android.service.notification.NotificationListenerService
    @RequiresApi(api = 21)
    public void onListenerConnected() {
        L.e(TAG, "onListenerConnected");
        e();
        c = true;
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        L.e(TAG, "onListenerDisconnected");
    }


    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        L.e(TAG, "onDestroy");
        LiveEventBus.get("resident_update_event", Boolean.class).removeObserver(this.b);
    }


    private void cancel(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            return;
        }
        try {
            cancelNotification(statusBarNotification.getKey());
        } catch (Throwable unused) {
        }
    }

    private void clear() {
        int size = hb_NotificationListUtils.getInstance().getList().size();
        if (size > 0) {
            hb_NotificationListUtils.getInstance().clear();
            stopForeground(true);
            LiveEventBus.get("notification_clean_event").post(Integer.valueOf(size));
        }
    }

    private cc c(StatusBarNotification statusBarNotification) {
        L.e(TAG, "获取通知详细信息 start");
        Notification notification;
        Bundle bundle;
        ArrayList<String> g2;
        if (statusBarNotification == null || !statusBarNotification.isClearable() || !a_mmkv.h().l() || (notification = statusBarNotification.getNotification()) == null || (bundle = notification.extras) == null) {
            return null;
        }
        PendingIntent pendingIntent = notification.contentIntent;
        String packageName = statusBarNotification.getPackageName();
        ConcurrentHashMap<String, dc_packageInfo> a2 = gc.a();
        String group = notification.getGroup();
        if (!"ranker_group".equals(group) && !"ranker_bundle".equals(group)) {
            if (fc.a(group) && !group.equals(packageName) && a2.keySet().contains(group)) {
                packageName = group;
            }
            if (BuildConfig.APPLICATION_ID.equals(packageName)) {
                if (statusBarNotification.getId() == 1) {
                    cancel(statusBarNotification);
                }
                return null;
            }
            String str = "";
            String charSequence = (String) bundle.getCharSequence(NotificationCompat.EXTRA_TITLE, "");
            String charSequence2 = (String) bundle.getCharSequence(NotificationCompat.EXTRA_TEXT, "");
            if (TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(charSequence2) && (g2 = g(notification.contentView)) != null && g2.size() >= 2) {
                charSequence = g2.get(0);
                charSequence2 = g2.get(1);
            }
            try {
                PackageManager packageManager = getPackageManager();
                str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128)).toString();
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                charSequence = str;
            }

            Set<String> e = a_mmkv.h().e();
            if (e != null && e.contains(packageName)) {
                d = true;
                return null;
            }
            cc ccVar = new cc();
            ccVar.packageName = packageName;
            ccVar.title = charSequence;
            ccVar.text = charSequence2;
            ccVar.pendingIntent = pendingIntent;
            ccVar.f112g = statusBarNotification.getPostTime();
            ccVar.appName = str;
            try {
                Parcelable parcelable = bundle.getParcelable(NotificationCompat.EXTRA_LARGE_ICON);
                Bitmap bitmap = parcelable instanceof Bitmap ? (Bitmap) parcelable : null;
                Bitmap b = hc_PackageManagerUtil.b(this, ccVar.packageName);
                if (b != null) {
                    ccVar.bitmap = b;
                } else if (bitmap != null) {
                    ccVar.bitmap = bitmap;
                } else {
                    ccVar.bitmap = f(this, statusBarNotification.getPackageName(), bundle.getInt(NotificationCompat.EXTRA_SMALL_ICON, 0));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            cancel(statusBarNotification);
            L.e(TAG, "获取通知详细信息 result："+ccVar.toString());
            return ccVar;
        }
        return null;
    }

    private ArrayList<cc> getAll(StatusBarNotification... statusBarNotificationArr) {
        ArrayList<cc> arrayList = new ArrayList<>();
        if (statusBarNotificationArr != null) {
            L.e(TAG,"getAll size = "+statusBarNotificationArr.length);
            for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
                cc c2 = c(statusBarNotification);
                if (c2 != null) {
                    arrayList.add(c2);
                }
            }
        }
        return arrayList;
    }

    private Bitmap f(Context context, String str, int i) {
        try {
            Drawable drawable = context.createPackageContext(str, 0).getResources().getDrawable(i);
            if (drawable != null) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void h(Context context) {
        if (context != null) {
            LiveEventBus.get("resident_update_event").post(Boolean.TRUE);
        }
    }

    @SuppressLint("ForegroundServiceType")
    public void e() {
        Notification g2;
        try {
            d = false;
            hb_NotificationListUtils.getInstance().addAll(getAll(getActiveNotifications()));
            if (hb_NotificationListUtils.getInstance().getList().size() <= 0 || (g2 = hb_NotificationListUtils.getInstance().createBlockedNotification(this)) == null) {
                return;
            }
            startForeground(2, g2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ArrayList<String> g(RemoteViews remoteViews) {
        if (remoteViews == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Field declaredField = remoteViews.getClass().getDeclaredField("mActions");
            declaredField.setAccessible(true);
            Iterator it = ((ArrayList) declaredField.get(remoteViews)).iterator();
            while (it.hasNext()) {
                Parcelable parcelable = (Parcelable) it.next();
                Parcel obtain = Parcel.obtain();
                parcelable.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                if (obtain.readInt() == 2) {
                    obtain.readInt();
                    String readString = obtain.readString();
                    if (readString != null) {
                        if (readString.equals("setText")) {
                            obtain.readInt();
                            arrayList.add(((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain)).toString().trim());
                        }
                        obtain.recycle();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }


}