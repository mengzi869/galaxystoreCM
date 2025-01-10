package com.clean888.cleansuper.cleaner.utils;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.utils.AboutSplash.sh;
import com.clean888.cleansuper.cleaner.ui.activity.BAAM;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAJ;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAK;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAL;
import com.clean888.cleansuper.cleaner.ui.dialog.BAAP;
import com.clean888.cleansuper.cleaner.ui.dialog.ZZA;
import com.clean888.cleansuper.cleaner.receiver.BAAN;

import java.lang.reflect.Field;
import java.util.Random;

// fj
public class fj {


    private static Intent[] B(Context context, int i, String str, String str2, int i2, String str3, int i3) {
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.putExtra("is_from_notif", true);
        intent.putExtra("notif_scene", i3);
        intent.putExtra(MainActivity.PAGE, i);
        intent.putExtra("anyly_click", str);
        intent.putExtra("analy_rearch", str3);
        intent.putExtra("scene_type", str2);
        intent.putExtra("notify_id", i2);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("anyly_click", str);
        return new Intent[]{intent};
    }

    public static void C(Context context, RemoteViews remoteViews, boolean z, String str) {
        Bitmap bitmap;
        PackageManager packageManager = context.getPackageManager();
        String str2 = "New App";
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            str2 = applicationInfo.loadLabel(packageManager).toString();
            Drawable loadIcon = applicationInfo.loadIcon(packageManager);
            if (loadIcon instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) loadIcon).getBitmap();
            } else {
                bitmap = u(loadIcon);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            bitmap = null;
        }
        String string = context.getString(R.string.install_reminder_zero, str2);
        if (z) {
            remoteViews.setTextViewText(R.id.reminder_text, string);
            if (bitmap != null) {
                remoteViews.setImageViewBitmap(R.id.reminder_image, bitmap);
            }
        } else {
            remoteViews.setTextViewText(R.id.tv_uninstall_reminder, string);
            if (bitmap != null) {
                remoteViews.setImageViewBitmap(R.id.img_uninstall_clean, bitmap);
            }
        }
        Intent intent = new Intent(context, (Class<?>) BAAM.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("notifyID", 105);
        intent.putExtra("anyly_click", "c_installed");
        Intent intent2 = new Intent(context, (Class<?>) SplashActivity.class);
        intent2.putExtra("is_from_notif", true);
        intent2.putExtra("notif_scene", 1);
        intent2.putExtra(MainActivity.PAGE, 8);
        intent2.putExtra(MainActivity.PACKAGE, str);
        intent2.putExtra("anyly_click", "c_installed");
        intent2.putExtra("analy_rearch", "r_installed");
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra(MainActivity.PACKAGE, str);
        }
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent activities = PendingIntent.getActivities(context, 0, new Intent[]{intent2, intent}, y41.a(134217728));
        if (z) {
            remoteViews.setOnClickPendingIntent(R.id.reminder_button, activities);
            remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, activities);
            return;
        }
        remoteViews.setOnClickPendingIntent(R.id.tv_uninstall_rightaction, activities);
        remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, activities);
        Intent intent3 = new Intent(context, (Class<?>) BAAN.class);
        intent3.putExtra("notifyID", 105);
        intent3.putExtra("anyly_click", "c_installed");
        remoteViews.setOnClickPendingIntent(R.id.tv_uninstall_leftactioin, PendingIntent.getBroadcast(context, 1, intent3, y41.a(268435456)));
    }

    public static void D(Context context, NotificationManagerCompat notificationManagerCompat, RemoteViews remoteViews, PendingIntent pendingIntent, Intent intent) {
        PendingIntent activity = PendingIntent.getActivity(context, y(), intent, y41.a(268435456));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            N(context, notificationManagerCompat, remoteViews, pendingIntent, "10413", 105, activity);
            return;
        }
        if (i >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("10413", "noti_push_channel", 4);
            notificationChannel.setDescription("Remind Push Notification");
            if (notificationManagerCompat != null) {
                notificationManagerCompat.createNotificationChannel(notificationChannel);
            }
        }
        Notification build = new NotificationCompat.Builder(context, "10413").setSmallIcon(R.mipmap.icon).setPriority(1).setCustomContentView(remoteViews).setFullScreenIntent(activity, true).build();
        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(105, build);
        }
    }


    public static void H(android.content.Context r14, int r15, int r16, android.widget.RemoteViews r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fj.H(android.content.Context, int, int, android.widget.RemoteViews, boolean):void");
    }


    public static void J(Context context, NotificationManagerCompat notificationManagerCompat, RemoteViews remoteViews, PendingIntent pendingIntent, Intent intent) {
        PendingIntent activity = PendingIntent.getActivity(context, y(), intent, y41.a(268435456));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            N(context, notificationManagerCompat, remoteViews, pendingIntent, "10213", 103, activity);
            return;
        }
        if (i >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("10213", "noti_push_channel", 4);
            notificationChannel.setDescription("Remind Push Notification");
            if (notificationManagerCompat != null) {
                notificationManagerCompat.createNotificationChannel(notificationChannel);
            }
        }
        Notification build = new NotificationCompat.Builder(context, "10213").setSmallIcon(R.mipmap.icon).setPriority(1).setCustomContentView(remoteViews).setFullScreenIntent(activity, true).build();
        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(103, build);
        }
    }


    public static void M(NotificationCompat.Builder builder, PendingIntent pendingIntent) {
        builder.setFullScreenIntent(pendingIntent, true);
    }

    @RequiresApi(api = 31)
    private static void N(Context context, NotificationManagerCompat notificationManagerCompat, RemoteViews remoteViews, PendingIntent pendingIntent, String str, int i, PendingIntent pendingIntent2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, "push_channel", 4);
        notificationChannel.setDescription("Push Notification");
        if (notificationManagerCompat != null) {
            notificationChannel.setBypassDnd(true);
            notificationChannel.setSound(null, null);
            notificationChannel.setLockscreenVisibility(1);
            notificationManagerCompat.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder groupSummary = new NotificationCompat.Builder(context, str).setSmallIcon(R.mipmap.icon).setPriority(1).setCustomContentView(remoteViews).setCustomBigContentView(remoteViews).setCustomHeadsUpContentView(remoteViews).setCategory(NotificationCompat.CATEGORY_ALARM).setStyle(new NotificationCompat.BigPictureStyle()).setContentIntent(pendingIntent).setOngoing(false).setOnlyAlertOnce(false).setVisibility(1).setAutoCancel(true).setDefaults(-1).setGroupSummary(false);
        M(groupSummary, pendingIntent2);
        Notification build = groupSummary.build();
        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(i, build);
        }
    }

    public static void O(Context context, RemoteViews remoteViews, boolean z, String str) {
        String string = context.getString(R.string.uninstall_reminder_zero);
        if (z) {
            remoteViews.setTextViewText(R.id.reminder_text, string);
        } else {
            remoteViews.setTextViewText(R.id.tv_uninstall_reminder, string);
        }
        Intent intent = new Intent(context, (Class<?>) BAAM.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("notifyID", 104);
        intent.putExtra("anyly_click", "c_uninstall");
        Intent intent2 = new Intent(context, (Class<?>) SplashActivity.class);
        intent2.putExtra("is_from_notif", true);
        intent2.putExtra("notif_scene", 2);
        intent2.putExtra(MainActivity.PAGE, 1);
        intent2.putExtra(MainActivity.PACKAGE, str);
        intent2.putExtra("anyly_click", "c_uninstall");
        intent2.putExtra("analy_rearch", "r_uninstall");
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent activities = PendingIntent.getActivities(context, 0, new Intent[]{intent2, intent}, y41.a(134217728));
        if (z) {
            remoteViews.setOnClickPendingIntent(R.id.reminder_button, activities);
            remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, activities);
            return;
        }
        remoteViews.setOnClickPendingIntent(R.id.tv_uninstall_rightaction, activities);
        remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, activities);
        Intent intent3 = new Intent(context, (Class<?>) BAAN.class);
        intent3.putExtra("notifyID", 104);
        intent3.putExtra("anyly_click", "c_uninstall");
        remoteViews.setOnClickPendingIntent(R.id.tv_uninstall_leftactioin, PendingIntent.getBroadcast(context, 1, intent3, y41.a(268435456)));
    }

    public static void P(Context context, NotificationManagerCompat notificationManagerCompat, RemoteViews remoteViews, PendingIntent pendingIntent, Intent intent) {
        PendingIntent activity = PendingIntent.getActivity(context, y(), intent, y41.a(268435456));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            N(context, notificationManagerCompat, remoteViews, pendingIntent, "10413", 104, activity);
            return;
        }
        if (i >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("10413", "noti_push_channel", 4);
            notificationChannel.setDescription("Remind Push Notification");
            if (notificationManagerCompat != null) {
                notificationManagerCompat.createNotificationChannel(notificationChannel);
            }
        }
        Notification build = new NotificationCompat.Builder(context, "10413").setSmallIcon(R.mipmap.icon).setPriority(1).setCustomContentView(remoteViews).setFullScreenIntent(activity, true).build();
        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(104, build);
        }
    }


    public static void j(Context context, RemoteViews remoteViews, boolean z) {
        Intent[] B = B(context, 5, "c_battery", "", 101, "r_battery", 3);
        if (B != null) {
            remoteViews.setOnClickPendingIntent(R.id.charging_improver_improver, PendingIntent.getActivities(context, 0, B, y41.a(134217728)));
            remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, PendingIntent.getActivities(context, 0, B, y41.a(134217728)));
        }
        if (!z) {
            Intent intent = new Intent(context, (Class<?>) BAAN.class);
            intent.putExtra("notifyID", 101);
            intent.putExtra("anyly_click", "c_battery");
            remoteViews.setOnClickPendingIntent(R.id.charging_improver_later, PendingIntent.getBroadcast(context, 1, intent, y41.a(268435456)));
        }
        Intent[] B2 = B(context, 6, "c_battery", "", 101, "r_battery", 3);
        if (B2 != null) {
            remoteViews.setOnClickPendingIntent(R.id.charging_improver_setting, PendingIntent.getActivities(context, 2, B2, y41.a(134217728)));
            remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, PendingIntent.getActivities(context, 2, B2, y41.a(134217728)));
        }
    }

    public static void k(Context context, NotificationManagerCompat notificationManagerCompat, RemoteViews remoteViews, PendingIntent pendingIntent, Intent intent) {
        PendingIntent activity = PendingIntent.getActivity(context, y(), intent, y41.a(134217728));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            N(context, notificationManagerCompat, remoteViews, pendingIntent, "10113", 101, activity);
            return;
        }
        if (i >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("10113", "noti_push_channel", 4);
            notificationChannel.setDescription("Remind Push Notification");
            if (notificationManagerCompat != null) {
                notificationManagerCompat.createNotificationChannel(notificationChannel);
            }
        }
        Notification build = new NotificationCompat.Builder(context, "10113").setSmallIcon(R.mipmap.icon).setPriority(1).setCustomContentView(remoteViews).setFullScreenIntent(activity, true).build();
        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(101, build);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */


    public static void n(Context context, RemoteViews remoteViews, boolean z, String str, String str2, boolean z2) {
        int i = z2 ? 6 : 5;
        Intent[] B = B(context, 2, str, "", 102, str2, i);
        if (B != null) {
            remoteViews.setOnClickPendingIntent(R.id.clean, PendingIntent.getActivities(context, 0, B, y41.a(134217728)));
            remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, PendingIntent.getActivities(context, 0, B, y41.a(134217728)));
        }
        if (!z) {
            Intent intent = new Intent(context, (Class<?>) BAAN.class);
            intent.putExtra("notifyID", 102);
            intent.putExtra("anyly_click", str);
            remoteViews.setOnClickPendingIntent(R.id.later, PendingIntent.getBroadcast(context, 1, intent, y41.a(268435456)));
        }
        Intent[] B2 = B(context, 6, str, "", 102, str2, i);
        if (B2 != null) {
            remoteViews.setOnClickPendingIntent(R.id.setting, PendingIntent.getActivities(context, 2, B2, y41.a(134217728)));
            remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, PendingIntent.getActivities(context, 2, B2, y41.a(134217728)));
        }
    }

    public static void o(Context context, NotificationManagerCompat notificationManagerCompat, RemoteViews remoteViews, PendingIntent pendingIntent, Intent intent) {
        PendingIntent activity = PendingIntent.getActivity(context, y(), intent, y41.a(134217728));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            N(context, notificationManagerCompat, remoteViews, pendingIntent, "10313", 102, activity);
            return;
        }
        if (i >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("10313", "noti_push_channel", 4);
            notificationChannel.setDescription("Remind Push Notification");
            if (notificationManagerCompat != null) {
                notificationManagerCompat.createNotificationChannel(notificationChannel);
            }
        }
        Notification build = new NotificationCompat.Builder(context, "10313").setSmallIcon(R.mipmap.icon).setPriority(1).setCustomContentView(remoteViews).setFullScreenIntent(activity, true).build();
        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(102, build);
        }
    }



    /* JADX INFO: Access modifiers changed from: private */


    public static void r(Context context) {
        if (Build.VERSION.SDK_INT > 33 || (context instanceof SplashActivity)) {
            NotificationManagerCompat.from(context).cancel(101);
            NotificationManagerCompat.from(context).cancel(102);
            NotificationManagerCompat.from(context).cancel(103);
            NotificationManagerCompat.from(context).cancel(104);
            NotificationManagerCompat.from(context).cancel(105);
        }
    }

    public static void t() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap.size() < 1) {
                return;
            }
            for (Object obj : arrayMap.values()) {
                try {
                    Class<?> cls2 = obj.getClass();
//                    Field declaredField2 = cls2.getDeclaredField(f8.h.e0);
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if ((activity instanceof BAAJ) || (activity instanceof BAAK) || (activity instanceof ZZA) || (activity instanceof BAAL) || (activity instanceof BAAP)) {
                            activity.finish();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Bitmap u(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != PixelFormat.UNKNOWN ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }


    public static int y() {
        String str = System.currentTimeMillis() + "";
        int nextInt = new Random().nextInt(10000);
        try {
            return Integer.parseInt(str.substring(str.length() - 5));
        } catch (Exception e2) {
            e2.printStackTrace();
            return nextInt;
        }
    }


    // ============================ package =========================================== Package =========================================

    private static String TAG_package = "PackageAction-fi";

    public static void installPackage(Context context, String str) {
        try {
            boolean d2 = bj.d(context);// areNotificationsEnabled

            L.d(TAG_package, "installPackage 开关:" + d2 + " SDK_INT:" + Build.VERSION.SDK_INT + " str:" + str);
            if (Build.VERSION.SDK_INT <= 33) {
                if (d2) {
                    try {
                        L.d(TAG_package, "installPackage <=33 & 开关打开 installPackageNotify startInstallPackageDialog");
                        installPackageNotify(context, str);
                    } catch (Exception unused) {
                        unused.printStackTrace();
                    }
                }
                rc.m(context);
                startInstallPackageDialog(false, context, str);
            } else {
                boolean rcm = rc.m(context);
                if (rcm) {
                    L.d(TAG_package, "installPackage >33 & canDrawOverlays:" + rcm + " RunnablePackageInstallAction");
                    ThreadUtils.runOnUiThread(new RunnablePackageInstallAction(context, str, d2));
                } else if (d2) {
                    L.d(TAG_package, "installPackage >33 & canDrawOverlays:" + rcm + " 开关:" + d2 + " installPackageNotify");
                    installPackageNotify(context, str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void uninstallPackage(Context context, String str) {
        try {
            boolean d2 = bj.d(context);// areNotificationsEnabled

            L.d(TAG_package, "uninstallPackage 开关:" + d2 + " SDK_INT:" + Build.VERSION.SDK_INT + " str:" + str);
            if (Build.VERSION.SDK_INT <= 33) {
                if (d2) {
                    try {
                        L.d(TAG_package, "uninstallPackage <=33 & 开关打开 uninstallPackageNotify startUninstallPackageDialog");
                        uninstallPackageNotify(context, str);
                    } catch (Exception unused) {
                        unused.printStackTrace();
                    }
                }
                rc.m(context);
                startUninstallPackageDialog(false, context, str);
            } else {
                boolean rcm = rc.m(context);
                if (rcm) {
                    L.d(TAG_package, "uninstallPackage >33 & canDrawOverlays:" + rcm + " RunnablePackageUninstallAction");
                    ThreadUtils.runOnUiThread(new RunnablePackageUninstallAction(context, str, d2));
                } else if (d2) {
                    L.d(TAG_package, "uninstallPackage >33 & canDrawOverlays:" + rcm + " 开关:" + d2 + " uninstallPackageNotify");
                    uninstallPackageNotify(context, str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void installPackageNotify(Context context, String str) {
        int i;
        boolean z;
        Intent intent = new Intent(context, (Class<?>) ZZA.class);
        intent.putExtra(MainActivity.PACKAGE, str);
        intent.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        if (from != null) {
            from.cancelAll();
        }
        PendingIntent activities = PendingIntent.getActivities(context, 56214, new Intent[]{intent}, y41.a(134217728));
        if (bj.e(context)) {
            i = R.layout.notification_install_window_simple;
            z = true;
        } else {
            i = R.layout.notifiy_install_reminder;
            z = false;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i);
        remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, null);
        if (Build.VERSION.SDK_INT >= 28) {
            if (bj.e(context)) {
                remoteViews.setInt(R.id.reminder_button, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            } else {
                remoteViews.setInt(R.id.tv_uninstall_rightaction, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            }
        }
        C(context, remoteViews, z, str);
        D(context, from, remoteViews, activities, getInstallPackageDialogIntent(false, context, str));
//        i4.a().i("s_installed").commit();
//        i4.a().i("s_pop_up_push").putEbKey1(1).commit();
    }

    public static void uninstallPackageNotify(Context context, String str) {
        int i;
        Intent intent = new Intent(context, (Class<?>) BAAL.class);
        intent.putExtra(MainActivity.PACKAGE, str);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        if (from != null) {
            from.cancelAll();
        }
        boolean z = true;
        PendingIntent activities = PendingIntent.getActivities(context, 56214, new Intent[]{intent}, y41.a(134217728));
        if (bj.e(context)) {
            i = R.layout.notification_uninstall_window_simple;
        } else {
            i = R.layout.notifiy_uninstall_reminder;
            z = false;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i);
        remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, null);
        if (Build.VERSION.SDK_INT >= 28) {
            if (bj.e(context)) {
                remoteViews.setInt(R.id.reminder_button, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            } else {
                remoteViews.setInt(R.id.tv_uninstall_rightaction, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            }
        }
        O(context, remoteViews, z, str);
        P(context, from, remoteViews, activities, getUninstallPackageDialogIntent(false, context, str));
//        i4.a().i("s_uninstall").commit();
//        i4.a().i("s_pop_up_push").putEbKey1(2).commit();
    }

    public static void startInstallPackageDialog(boolean z, Context context, String str) {
//        if (ji.c(context, 6)) {
//            return;
//        }
        Intent x = getInstallPackageDialogIntent(z, context, str);
        sh.d(x, 1);
        context.startActivity(x);
//        i4.a().i("s_installed").commit();
//        i4.a().i("s_pop_up_bgactivity").putEbKey1(1).commit();
    }

    public static void startUninstallPackageDialog(boolean z, Context context, String str) {
//        if (ji.c(context, 5)) {
//            return;
//        }
        Intent A = getUninstallPackageDialogIntent(z, context, str);
        sh.d(A, 2);
        context.startActivity(A);
//        i4.a().i("s_uninstall").commit();
//        i4.a().i("s_pop_up_bgactivity").putEbKey1(2).commit();
    }

    private static Intent getInstallPackageDialogIntent(boolean z, Context context, String str) {
//        Intent a2 = ji.a(context, 6);
//        if (a2 != null) {
//            return a2;
//        }
        t();
        Intent intent = new Intent(context, (Class<?>) ZZA.class);
        intent.putExtra(MainActivity.PACKAGE, str);
        intent.putExtra("anyly_click", "c_installed");
        intent.putExtra("analy_rearch", "r_installed");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    public static Intent getUninstallPackageDialogIntent(boolean z, Context context, String str) {
//        Intent a2 = ji.a(context, 5);
//        if (a2 != null) {
//            return a2;
//        }
        t();
        Intent intent = new Intent(context, (Class<?>) BAAL.class);
        intent.putExtra(MainActivity.PACKAGE, str);
        intent.putExtra("anyly_click", "c_uninstall");
        intent.putExtra("analy_rearch", "r_uninstall");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }


    public static class RunnablePackageInstallAction implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        RunnablePackageInstallAction(Context context, String str, boolean z) {
            this.a = context;
            this.b = str;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Context context, String str, boolean z, boolean z2) {
            if (z2) {
                fj.startInstallPackageDialog(true, context, str);
            } else if (z) {
                fj.installPackageNotify(context, str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                di diVar = new di(this.a);
                final Context context = this.a;
                final String str = this.b;
                final boolean z = this.c;
                diVar.j(new di.a() { // from class: jj
                    @Override // di.a
                    public final void a(boolean z2) {
                        RunnablePackageInstallAction.b(context, str, z, z2);
                    }
                }).g();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.c) {
                        fj.installPackageNotify(this.a, this.b);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }


    public static class RunnablePackageUninstallAction implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        RunnablePackageUninstallAction(Context context, String str, boolean z) {
            this.a = context;
            this.b = str;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Context context, String str, boolean z, boolean z2) {
            if (z2) {
                fj.startUninstallPackageDialog(true, context, str);
            } else if (z) {
                fj.uninstallPackageNotify(context, str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                di diVar = new di(this.a);
                final Context context = this.a;
                final String str = this.b;
                final boolean z = this.c;
                diVar.j(new di.a() { // from class: ij
                    @Override // di.a
                    public final void a(boolean z2) {
                        RunnablePackageUninstallAction.b(context, str, z, z2);
                    }
                }).g();
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (this.c) {
                        fj.uninstallPackageNotify(this.a, this.b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ============================ Battery =========================================== Battery =========================================

    private static String TAG_battery = "BatteryAction-fi";

    public static void powerConnected(Context context) {
        try {
            boolean d2 = bj.d(context);
            if (Build.VERSION.SDK_INT <= 33) {
//                md1.b("BAIH", "充电：<=33版本，直接走通知");
                rc.m(context);
                if (d2) {
                    try {
                        powerConnectedNotify(context);
                    } catch (Exception unused) {
                        unused.printStackTrace();
                    }
                }
                startPowerConnectedDialog(false, context);
                return;
            }
            boolean m = rc.m(context);
            if (!bj.f()) {
                startPowerConnectedDialog(false, context);
                return;
            }
            if (m) {
                ThreadUtils.runOnUiThread(new RunnablePowerConnectedAction(context, d2));
            } else if (d2) {
                powerConnectedNotify(context);
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void powerConnectedNotify(Context context) {
        int i;
        Intent intent = new Intent(context, (Class<?>) BAAJ.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        if (from != null) {
            from.cancelAll();
        }
        boolean z = true;
        PendingIntent activities = PendingIntent.getActivities(context, 56214, new Intent[]{intent}, y41.a(134217728));
        if (bj.e(context)) {
            i = R.layout.notification_charing_window_simple;
        } else {
            i = R.layout.notification_charging_improver;
            z = false;
        }
        int k = bj.k(context);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i);
        if (k > 0 && k <= 32) {
            remoteViews.setTextViewText(R.id.charging_improver_text, context.getString(R.string.charging_boost_tip_low));
        }
        remoteViews.setTextViewText(R.id.charging_improver_text, context.getString(R.string.charging_boost_tip_low));
        remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, null);
        if (Build.VERSION.SDK_INT >= 28) {
            if (bj.e(context)) {
                remoteViews.setInt(R.id.charging_improver_improver, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            } else {
                remoteViews.setInt(R.id.charging_improver_improver, "setBackgroundResource", R.drawable.bg_notif_btn_big_animation);
            }
        }
        j(context, remoteViews, z);
        k(context, from, remoteViews, activities, getPowerConnectedIntent(false, context));
//        i4.a().i("s_battery").commit();
//        i4.a().i("s_pop_up_push").putEbKey1(3).commit();
    }

    public static void startPowerConnectedDialog(boolean z, Context context) {
//        if (ji.c(context, 1)) {
//            return;
//        }
        Intent v = getPowerConnectedIntent(z, context);
        sh.d(v, 3);
        context.startActivity(v);
//        i4.a().i("s_battery").commit();
//        i4.a().i("s_pop_up_bgactivity").putEbKey1(3).commit();
    }

    public static Intent getPowerConnectedIntent(boolean z, Context context) {
//        Intent a2 = ji.a(context, 1);
//        if (a2 != null) {
//            return a2;
//        }
        t();
        Intent intent = new Intent(context, (Class<?>) BAAJ.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("anyly_click", "c_battery");
        intent.putExtra("anyly_click", "r_battery");
        return intent;
    }

    static class RunnablePowerConnectedAction implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;

        RunnablePowerConnectedAction(Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Context context, boolean z, boolean z2) {
            if (z2) {
                fj.startPowerConnectedDialog(true, context);
            } else if (z) {
                fj.powerConnectedNotify(context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                di diVar = new di(this.a);
                final Context context = this.a;
                final boolean z = this.b;
                diVar.j(new di.a() { // from class: ej
                    @Override // di.a
                    public final void a(boolean z2) {
                        RunnablePowerConnectedAction.b(context, z, z2);
                    }
                }).g();
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (this.b) {
                        fj.powerConnectedNotify(this.a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ============================ Screen =========================================== Screen =========================================

    public static void screenOn(Context context, String str, String str2, String str3, boolean z) {
        try {
            boolean r = bj.r();
            boolean d2 = bj.d(context);
            if (Build.VERSION.SDK_INT <= 33) {
//                md1.b("BAIH", (z ? "解锁" : "Home") + "：<=33版本，直接走通知");
                if (d2) {
                    try {
                        screenOnNotify(context, str, str2, str3, z);
                    } catch (Exception unused) {
                    }
                }
                if (r) {
                    rc.m(context);
                }
                startScreenOnDialog(false, context, str, str2, str3, z);
                return;
            }
            boolean m = r ? rc.m(context) : false;
            if (!bj.f()) {
                startScreenOnDialog(false, context, str, str2, str3, z);
                return;
            }
            if (r && m) {
                ThreadUtils.runOnUiThread(new RunnableScrenOnAction(context, str, str2, str3, z, d2));
            } else if (d2) {
                screenOnNotify(context, str, str2, str3, z);
            }
        } catch (Exception unused2) {
        }
    }

    public static void screenOnNotify(Context context, String str, String str2, String str3, boolean z) {
        int i;
        Intent intent = new Intent(context, (Class<?>) BAAK.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        if (from != null) {
            from.cancelAll();
        }
        boolean z2 = true;
        PendingIntent activities = PendingIntent.getActivities(context, 56214, new Intent[]{intent}, y41.a(134217728));
        if (bj.e(context)) {
            i = R.layout.notification_clean_window_simple;
        } else {
            i = R.layout.notification_clean_improver;
            z2 = false;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i);
        remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, null);
        if (Build.VERSION.SDK_INT >= 28) {
            if (bj.e(context)) {
                remoteViews.setInt(R.id.clean, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            } else {
                remoteViews.setInt(R.id.clean, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            }
        }
        n(context, remoteViews, z2, str2, str3, z);
        o(context, from, remoteViews, activities, getScreenOnDialogIntent(false, context, str, str2, str3, z));
//        i4.a().i(str).commit();
//        i4.a().i("s_pop_up_push").putEbKey1(Integer.valueOf(z ? 6 : 5)).commit();
    }

    public static void startScreenOnDialog(boolean z, Context context, String str, String str2, String str3, boolean z2) {
//        if (ji.c(context, z2 ? 2 : 3)) {
//            return;
//        }
        Intent w = getScreenOnDialogIntent(z, context, str, str2, str3, z2);
        sh.d(w, z2 ? 6 : 5);
        context.startActivity(w);
//        i4.a().i(str).commit();
//        i4.a().i("s_pop_up_bgactivity").putEbKey1(Integer.valueOf(z2 ? 6 : 5)).commit();
    }

    public static Intent getScreenOnDialogIntent(boolean z, Context context, String str, String str2, String str3, boolean z2) {
//        Intent a2 = ji.a(context, z2 ? 2 : 3);
//        if (a2 != null) {
//            return a2;
//        }
        t();
        Intent intent = new Intent(context, (Class<?>) BAAK.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("anyly_click", str2);
        intent.putExtra("analy_rearch", str3);
        return intent;
    }

    static class RunnableScrenOnAction implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ boolean f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f1786g;

        RunnableScrenOnAction(Context context, String str, String str2, String str3, boolean z, boolean z2) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.f = z;
            this.f1786g = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Context context, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
            if (z3) {
                fj.startScreenOnDialog(true, context, str, str2, str3, z);
            } else if (z2) {
                fj.screenOnNotify(context, str, str2, str3, z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    di diVar = new di(this.a);
                    final Context context = this.a;
                    final String str = this.b;
                    final String str2 = this.c;
                    final String str3 = this.d;
                    final boolean z = this.f;
                    final boolean z2 = this.f1786g;
                    diVar.j(new di.a() { // from class: gj
                        @Override // di.a
                        public final void a(boolean z3) {
                            RunnableScrenOnAction.b(context, str, str2, str3, z, z2, z3);
                        }
                    }).g();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable unused) {
                if (this.f1786g) {
                    fj.screenOnNotify(this.a, this.b, this.c, this.d, this.f);
                }
            }
        }
    }

    // ============================ unknow =========================================== Screen =========================================

    public static void I(Context context, int page, int value, String key, long curtime) {
        try {
            boolean r = bj.r();
            boolean d2 = bj.d(context);
            if (Build.VERSION.SDK_INT <= 33) {
//                md1.b("BAIH", "其他提现:page=" + i + "：<=33版本，直接走通知");
                if (d2) {
                    try {
                        L(context, page, value, key, curtime);
                    } catch (Exception unused) {
                    }
                }
                if (r) {
                    rc.m(context);
                }
                K(false, context, page, value, key, curtime);
                return;
            }
            boolean m = r ? rc.m(context) : false;
            if (!bj.f()) {
                K(false, context, page, value, key, curtime);
                return;
            }
            if (r && m) {
                ThreadUtils.runOnUiThread(new c(context, page, value, key, curtime, d2));
            } else if (d2) {
                L(context, page, value, key, curtime);
            }
        } catch (Exception unused2) {
        }
    }

    public static void L(Context context, int i, int i2, String str, long j) {
        int i3;
        Intent intent = new Intent(context, (Class<?>) BAAP.class);
        intent.putExtra(MainActivity.PAGE, i);
        intent.putExtra("value", i2);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        if (from != null) {
            from.cancelAll();
        }
        boolean z = true;
        PendingIntent activities = PendingIntent.getActivities(context, 56214, new Intent[]{intent}, y41.a(134217728));
        if (bj.e(context)) {
            i3 = R.layout.notification_remind_window_simple;
        } else {
            i3 = R.layout.notification_remind_window;
            z = false;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i3);
        remoteViews.setOnClickPendingIntent(R.id.remind_notification_layout, null);
        if (Build.VERSION.SDK_INT >= 28) {
            if (bj.e(context)) {
                remoteViews.setInt(R.id.reminder_button, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            } else {
                remoteViews.setInt(R.id.reminder_button, "setBackgroundResource", R.drawable.bg_notif_btn_small_animation);
            }
        }
        H(context, i, i2, remoteViews, z);
        J(context, from, remoteViews, activities, z(false, context, i, i2, str, j));
        if (!TextUtils.isEmpty(str)) {
            pj.c(str, j);
        }
//        i4.a().i("s_timedscene").putEbKey1(Integer.valueOf(i)).commit();
//        i4.a().i("s_pop_up_push").putEbKey1(7).commit();
    }

    public static void K(boolean z, Context context, int i, int i2, String str, long j) {
//        if (ji.c(context, 4)) {
//            return;
//        }
        Intent z2 = z(z, context, i, i2, str, j);
        sh.d(z2, 7);
        context.startActivity(z2);
        if (!TextUtils.isEmpty(str)) {
            pj.c(str, j);
        }
//        i4.a().i("s_timedscene").putEbKey1(Integer.valueOf(i)).commit();
//        i4.a().i("s_pop_up_bgactivity").putEbKey1(7).commit();
    }

    public static Intent z(boolean z, Context context, int i, int i2, String str, long j) {
//        Intent a2 = ji.a(context, 4);
//        if (a2 != null) {
//            return a2;
//        }
        t();
        Intent intent = new Intent(context, (Class<?>) BAAP.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(MainActivity.PAGE, i);
        intent.putExtra("value", i2);
        intent.putExtra("anyly_click", "c_timedscene");
        intent.putExtra("analy_rearch", "r_timedscene");
        return intent;
    }

    public static class c implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ long f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f1787g;

        c(Context context, int i, int i2, String str, long j, boolean z) {
            this.a = context;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.f = j;
            this.f1787g = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Context context, int i, int i2, String str, long j, boolean z, boolean z2) {
            if (z2) {
                fj.K(true, context, i, i2, str, j);
            } else if (z) {
                fj.L(context, i, i2, str, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                di diVar = new di(this.a);
                final Context context = this.a;
                final int i = this.b;
                final int i2 = this.c;
                final String str = this.d;
                final long j = this.f;
                final boolean z = this.f1787g;
                diVar.j(new di.a() { // from class: hj
                    @Override // di.a
                    public final void a(boolean z2) {
                        fj.c.b(context, i, i2, str, j, z, z2);
                    }
                }).g();
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (this.f1787g) {
                        fj.L(this.a, this.b, this.c, this.d, this.f);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}