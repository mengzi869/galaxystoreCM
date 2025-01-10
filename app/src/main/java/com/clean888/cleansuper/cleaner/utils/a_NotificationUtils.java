package com.clean888.cleansuper.cleaner.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.ui.activity.ZZY;


/* loaded from: classes2.dex */
public class a_NotificationUtils {
    public static NotificationCompat.Builder b() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationChannel notificationChannel = new NotificationChannel("MyChannelId", "My Foreground Service", NotificationManager.IMPORTANCE_MIN);
                notificationChannel.enableLights(false);
                notificationChannel.setShowBadge(false);
                notificationChannel.setLightColor(-16776961);
                notificationChannel.setLockscreenVisibility(-1);
                ((NotificationManager) SuperApplication.getContext().getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(notificationChannel);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(SuperApplication.getContext(), "MyChannelId");
                builder.setChannelId("MyChannelId");
                return builder;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return new NotificationCompat.Builder(SuperApplication.getContext());
    }

    public static boolean isEnable(Context context) {
        return NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.getPackageName());
    }

    public static void e(final Context context) {
        Intent intent;
        try {
            if (Build.VERSION.SDK_INT >= 22) {
                intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
            } else {
                intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fi.a();
        ZZY.n(context, new ZZY.b() { // from class: jf
            @Override // bfj.ckdk.wazpqdu.cjzk.mhiggthrrh.ZZY.b
            public final boolean a() {
                boolean c;
                c = a_NotificationUtils.isEnable(context);
                return c;
            }
        });
    }
}