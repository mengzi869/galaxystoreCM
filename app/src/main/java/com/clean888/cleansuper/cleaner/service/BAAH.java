package com.clean888.cleansuper.cleaner.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.TextUtilsCompat;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.BuildConfig;
import com.clean888.cleansuper.cleaner.R;
import com.clean888.cleansuper.cleaner.SuperApplication;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.cj;
import com.clean888.cleansuper.cleaner.utils.di;
import com.clean888.cleansuper.cleaner.utils.nr1;
import com.clean888.cleansuper.cleaner.utils.pj;
import com.clean888.cleansuper.cleaner.utils.rc;
import com.clean888.cleansuper.cleaner.ui.fragment.result.FuncFinishTitleModel;
import com.clean888.cleansuper.cleaner.utils.y41;
import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.ui.SplashActivity;
import com.clean888.cleansuper.cleaner.ui.ViewModel.BAEX;
import com.clean888.cleansuper.cleaner.ui.activity.BAAE;
import com.clean888.cleansuper.cleaner.receiver.PackageActionReceiver;
import com.clean888.cleansuper.cleaner.receiver.WidgetReceiver;
import com.clean888.cleansuper.cleaner.receiver.BatteryActionReceiver;
import com.clean888.cleansuper.cleaner.receiver.ScreenActionReceiver;
import com.clean888.cleansuper.cleaner.ui.widget.ZZF;

import java.text.DecimalFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class BAAH extends Service {
    private static final String TAG = "Service-BAAH";
    private ScreenActionReceiver screenReceiver;
    private BatteryActionReceiver batteryReceiver;
    private WidgetReceiver widgetReceiver;
    private PackageActionReceiver packageReceiver;
    private cj f;

    /* renamed from: g, reason: collision with root package name */
    private NotificationManager f93g;
    private NotificationChannel h;
    private NotificationCompat.Builder i;
    private RemoteViews j;
    private Notification k;
    private boolean m;
    private Handler l = new c(Looper.getMainLooper());
    private nr1.b n = new nr1.b() { // from class: pa
        @Override // nr1.b
        public final void a(nr1.d dVar) {
            BAAH.this.l(dVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Context context, boolean z) {
            BAAH.this.i(z, context);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                di diVar = new di(this.a);
                final Context context = this.a;
                diVar.j(new di.a() { // from class: bfj.fqiumlkcse.qoz.niiwgu.a
                    @Override // di.a
                    public final void a(boolean z) {
                        BAAH.a.this.b(context, z);
                    }
                }).g();
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    BAAH.this.i(false, this.a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b implements MessageQueue.IdleHandler {
        final long a;
        final Context b;

        b(long j, Context context) {
            this.a = j;
            this.b = context;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            Context context = this.b;
            try {
                ContextCompat.startForegroundService(context, new Intent(context, (Class<?>) BAAH.class));
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 101) {
                BAAH.this.l.removeMessages(101);
                BAAH.this.o(Boolean.FALSE);
            }
            super.handleMessage(message);
        }
    }

    public static void f(Context context) {
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Looper.myQueue().addIdleHandler(new b(System.currentTimeMillis(), context));
        } else {
            try {
                ContextCompat.startForegroundService(context, new Intent(context, (Class<?>) BAAH.class));
            } catch (Exception unused) {
            }
        }
    }

    private Bitmap g(nr1.d dVar) {
        String valueOf;
        if (dVar == null || dVar.d < 70) {
            return null;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.notify_progressbar, (ViewGroup) null, false);
        ZZF zzf = (ZZF) inflate.findViewById(R.id.notify_progress_bar);
        TextView textView = (TextView) inflate.findViewById(R.id.notify_progress_tv);
        zzf.setMaxNum(100.0f);
        try {
            valueOf = new DecimalFormat("0").format(dVar.d);
        } catch (Exception unused) {
            valueOf = String.valueOf(dVar.d);
        }
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            textView.setText("%" + valueOf);
        } else {
            textView.setText(valueOf + "%");
        }
        zzf.setTextView(textView);
        zzf.j(dVar.d, 0);
        zzf.setProgressColor(getResources().getColor(R.color.notify_warn_color));
        zzf.setBGsColor(getResources().getColor(R.color.notify_warn_bg));
        textView.setTextColor(getResources().getColor(R.color.notify_warn_color));
        if (dVar.d <= 0) {
            return null;
        }
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        inflate.buildDrawingCache();
        return inflate.getDrawingCache();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean h(BAEX r7, FuncFinishTitleModel type, java.lang.String r9) {


        long r0;
        long r2 = 60000;

        // 根据 uf 枚举的不同值来计算 r0
        if (type == FuncFinishTitleModel.CpuCooler) {
            r0 = 180;
            r0 = r0 * r2;
        } else if (type == FuncFinishTitleModel.JunkClean) {
            r0 = 180;
            r0 = r0 * r2;
        } else if (type == FuncFinishTitleModel.BatterySaver) {
            r0 = 60;
            r0 = r0 * r2;
        } else {
            r0 = 1000000L;  // 默认值
        }

        // 获取当前时间和某些历史时间
        long currentTime = System.currentTimeMillis();
        long lastTime = r7.getLastFinishTime(type);

        if (type == FuncFinishTitleModel.JunkClean) {
            lastTime = r7.getLastEnterTime(type);
        }


        long timeDiff = currentTime - lastTime;
        long absTimeDiff = Math.abs(timeDiff);
        L.d(TAG, "BAAH h start r8:(" + type.Id + "," + SuperApplication.getContext().getString(type.TitleResId) + ") r9:" + r9 + "\nr0:" + r0 + " currentTime:" + currentTime + " lastTime:" + lastTime + "\ntimeDiff:" + timeDiff + " absTimeDiff:" + absTimeDiff + " absTimeDiff >= r0 :" + (absTimeDiff >= r0));

        // 打印调试信息
        if (BuildConfig.DEBUG) {
            StringBuilder logMessage = new StringBuilder();
            logMessage.append(r9)
                    .append(bj.h(absTimeDiff))
                    .append("--needTime:")
                    .append(bj.h(r0))
                    .append("--isOverTime:");
            // 判断是否超时
            boolean isOverTime = absTimeDiff >= r0;
            logMessage.append(isOverTime ? 1 : 0);

            // 输出日志
//            L.d(TAG, "BAAH h " + logMessage.toString());
        }

        // 返回是否超时
        return absTimeDiff >= r0;


        /*
            uf r0 = defpackage.uf.j
            if (r8 != r0) goto L10
            oj r0 = defpackage.kj.b()
            int r0 = r0.f
            long r0 = (long) r0
            long r2 = defpackage.fr2.a
        Ld:
            long r0 = r0 * r2
            goto L2f
        L10:
            uf r0 = defpackage.uf.f
            if (r8 != r0) goto L1e
            oj r0 = defpackage.kj.b()
            int r0 = r0.d
            long r0 = (long) r0
            long r2 = defpackage.fr2.a
            goto Ld
        L1e:
            uf r0 = defpackage.uf.k
            if (r8 != r0) goto L2c
            oj r0 = defpackage.kj.b()
            int r0 = r0.c
            long r0 = (long) r0
            long r2 = defpackage.fr2.a
            goto Ld
        L2c:
            r0 = 1000000(0xf4240, double:4.940656E-318)
        L2f:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r7.getLastFinishTime(r8)
            uf r6 = defpackage.uf.f
            if (r8 != r6) goto L3f
            long r4 = r7.getLastEnterTime(r8)
        L3f:
            long r2 = r2 - r4
            long r7 = java.lang.Math.abs(r2)
            boolean r2 = defpackage.md1.e()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L7f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.String r9 = defpackage.bj.h(r7)
            r2.append(r9)
            java.lang.String r9 = "--needTime:"
            r2.append(r9)
            java.lang.String r9 = defpackage.bj.h(r0)
            r2.append(r9)
            java.lang.String r9 = "--isOverTime:"
            r2.append(r9)
            int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r9 < 0) goto L72
            r9 = 1
            goto L73
        L72:
            r9 = 0
        L73:
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r2 = "BAIH"
            defpackage.md1.b(r2, r9)
        L7f:
            int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r9 < 0) goto L84
            goto L85
        L84:
            r3 = 0
        L85:
            return r3
        */

//        throw new UnsupportedOperationException("Method not decompiled: bfj.fqiumlkcse.qoz.niiwgu.BAAH.h(bfj.ckdk.wazpqdu.cjzk.ssnwrh.BAEX, uf, java.lang.String):boolean");
//        return true;
    }


    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, Context context) {
//        if (ji.c(context, 7)) {
//            return;
//        }
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.putExtra(MainActivity.PAGE, 2);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
//        i4.a().i("phone_shaking").putEbKey1(1).commit();
//        i4.a().i("s_phone_shaking").commit();
//        i4.a().i("s_pop_up_bgactivity").putEbKey1(4).commit();
    }

    private void j() {
        n();
        t(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Context context) {
        if (context.getResources().getConfiguration().orientation != 1) {
//            i4.a().i("phone_shaking").putEbKey1(0).putEbKey2(0).commit();
            return;
        }
        if (!a_mmkv.h().r()) {
//            if (md1.e()) {
            L.d(TAG, "k() Shake->设置关闭");
//            }
//            i4.a().i("phone_shaking").putEbKey1(0).putEbKey2(1).commit();
            return;
        }
        if (!a_mmkv.h().o() && bj.o(context)) {
//            if (md1.e()) {
            L.d(TAG, "k() Shake->锁屏状态");
//            }
//            i4.a().i("phone_shaking").putEbKey1(0).putEbKey2(2).commit();
            return;
        }
        if (!bj.p()) {
//            if (md1.e()) {
            L.d(TAG, "k() Shake->没超过安装时长");
//            }
//            i4.a().i("phone_shaking").putEbKey1(0).putEbKey2(3).commit();
            return;
        }
        boolean r = bj.r();
        boolean m = r ? rc.m(context) : false;
        if (Build.VERSION.SDK_INT <= 33) {
//            md1.b("BAIH", "摇一摇：<=33版本，直接走通知");
            i(false, context);
        } else if (!bj.f()) {
            i(false, context);
        } else if (r && m) {
            ThreadUtils.runOnUiThread(new a(context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(nr1.d dVar) {
        if (dVar != null) {
            t(dVar);
        }
    }

    public static void m(Context context) {
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) BAAI.class), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) BAAI.class), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    @SuppressLint("RestrictedApi")
    private void n() {
        NotificationManager notificationManager;
        this.f93g = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.h == null) {
                NotificationChannel notificationChannel = new NotificationChannel("Setting", "Notification", NotificationManager.IMPORTANCE_LOW);
                this.h = notificationChannel;
                notificationChannel.enableLights(true);
                this.h.setLightColor(SupportMenu.CATEGORY_MASK);
                this.h.setShowBadge(true);
            }
            NotificationManager notificationManager2 = this.f93g;
            if (notificationManager2 == null || notificationManager2.getNotificationChannel("Setting") != null || (notificationManager = this.f93g) == null) {
                return;
            }
            notificationManager.createNotificationChannel(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Boolean bool) {
        if (bool.booleanValue()) {
            this.l.removeMessages(101);
            this.l.sendEmptyMessageDelayed(101, 0L);
        } else {
            this.l.sendEmptyMessageDelayed(101, 3000L);
        }
    }

    private void p() {
        this.screenReceiver = new ScreenActionReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_USER_PRESENT);
        intentFilter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        if (Build.VERSION.SDK_INT >= 26) {
            registerReceiver(this.screenReceiver, intentFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.screenReceiver, intentFilter);
        }
        m(this);
    }

    private void q() {
        this.widgetReceiver = new WidgetReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        intentFilter.addAction(Intent.ACTION_DATE_CHANGED);
        if (Build.VERSION.SDK_INT >= 26) {
            registerReceiver(this.widgetReceiver, intentFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.widgetReceiver, intentFilter);
        }
    }

    private void r() {
        if (this.packageReceiver == null) {
            this.packageReceiver = new PackageActionReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
            intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            intentFilter.addDataScheme(MainActivity.PACKAGE);
            if (Build.VERSION.SDK_INT >= 26) {
                registerReceiver(this.packageReceiver, intentFilter, Context.RECEIVER_EXPORTED);
            } else {
                registerReceiver(this.packageReceiver, intentFilter);
            }
        }
    }

    private void s() {
        cj cjVar = new cj(this);
        this.f = cjVar;
        cjVar.a(new cj.a() { // from class: oa
            @Override // cj.a
            public final void a() {
                BAAH.this.k(BAAH.this);
            }
        });
    }

    private void t(nr1.d dVar) {
        System.currentTimeMillis();
        this.j = new RemoteViews(getPackageName(), R.layout.notify_ly);
        Intent intent = new Intent(this, (Class<?>) SplashActivity.class);
        intent.putExtra(MainActivity.PAGE, 1);
        intent.putExtra("anyly_click", "c_junkclean_icon");
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.j.setOnClickPendingIntent(R.id.clean, PendingIntent.getActivity(this, 5, intent, y41.a(134217728)));
        Intent intent2 = new Intent(this, (Class<?>) SplashActivity.class);
        intent2.putExtra(MainActivity.PAGE, 2);
        intent2.putExtra("anyly_click", "c_boost_icon");
        intent2.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.j.setOnClickPendingIntent(R.id.boost, PendingIntent.getActivity(this, 6, intent2, y41.a(134217728)));
        Intent intent3 = new Intent(this, (Class<?>) SplashActivity.class);
        intent3.putExtra(MainActivity.PAGE, 4);
        intent3.putExtra("anyly_click", "c_cpucooler_icon");
        intent3.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.j.setOnClickPendingIntent(R.id.cpu, PendingIntent.getActivity(this, 7, intent3, y41.a(134217728)));
        Intent intent4 = new Intent(this, (Class<?>) SplashActivity.class);
        intent4.putExtra(MainActivity.PAGE, 5);
        intent4.putExtra("anyly_click", "c_batterysaver_icon");
        intent4.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.j.setOnClickPendingIntent(R.id.battery, PendingIntent.getActivity(this, 8, intent4, y41.a(134217728)));
        Intent intent5 = new Intent(this, (Class<?>) SplashActivity.class);
        intent5.putExtra(MainActivity.PAGE, 3);
        intent5.putExtra("anyly_click", "c_security_icon");
        intent5.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.j.setOnClickPendingIntent(R.id.security, PendingIntent.getActivity(this, 10, intent5, y41.a(134217728)));
        Intent intent6 = new Intent(this, (Class<?>) BAAE.class);
        intent6.putExtra(MainActivity.PAGE, 9);
        intent6.putExtra("anyly_click", "c_flashlight_icon");
        intent6.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.j.setOnClickPendingIntent(R.id.lamp, PendingIntent.getActivity(this, 11, intent6, y41.a(134217728)));
        Bitmap g2 = g(dVar);
        if (g2 != null) {
            this.j.setImageViewBitmap(R.id.boost_iv, g2);
        } else {
            this.j.setImageViewResource(R.id.boost_iv, R.mipmap.ic_reminder_boost);
        }
        BAEX baex = new BAEX(getApplication());
        this.j.setViewVisibility(R.id.cpu_point, h(baex, FuncFinishTitleModel.CpuCooler, "通知栏cup间隔时间:") ? View.VISIBLE : View.GONE);
        int leave;
        boolean isCharging;
        if (this.batteryReceiver != null) {
            isCharging = this.batteryReceiver.isCharging();
            leave = this.batteryReceiver.getLevel();
        } else {
            leave = bj.k(this);
            isCharging = false;
        }
        this.j.setViewVisibility(R.id.battery_point, h(baex, FuncFinishTitleModel.BatterySaver, "通知栏电池间隔时间:") && !isCharging && leave < 32 ? View.VISIBLE : View.GONE);
//        if (md1.e()) {
//            md1.b("BAIH", "充电中？" + z + ",电量：" + k);
//        }
        this.j.setViewVisibility(R.id.clean_point, h(baex, FuncFinishTitleModel.JunkClean, "通知栏文件间隔时间:") ? View.VISIBLE : View.GONE);
        this.i = new NotificationCompat.Builder(this, "Setting");
        Intent intent7 = new Intent(this, (Class<?>) SplashActivity.class);
        intent7.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.i.setContentIntent(PendingIntent.getActivity(this, 9, intent7, y41.a(134217728)));
        this.i.setSmallIcon(R.mipmap.ic_reminder_battery);
        this.i.setAutoCancel(false).setSound(null).setVibrate(new long[]{0}).setOnlyAlertOnce(true);
        this.i.setContent(this.j);
        this.i.setCustomBigContentView(this.j);
        this.i.setCustomHeadsUpContentView(this.j);
        this.i.setCustomContentView(this.j);
        this.i.setOngoing(true);
        this.i.setOnlyAlertOnce(true);
        this.i.setPriority(2);
        this.i.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        Notification build = this.i.build();
        this.k = build;
        v(build);
    }

    private void u() {
        this.batteryReceiver = new BatteryActionReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        if (Build.VERSION.SDK_INT >= 26) {
            registerReceiver(this.batteryReceiver, intentFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.batteryReceiver, intentFilter);
        }
    }

    @SuppressLint("ForegroundServiceType")
    private void v(Notification notification) {
        try {
            boolean d = bj.d(this);
            n();
            if (a_mmkv.h().p() && pj.b()) {
                if (notification == null) {
                    notification = new NotificationCompat.Builder(this, "Setting").build();
                }
                startForeground(4130, notification);
            } else {
                stopForeground(true);
                if (notification == null) {
                    notification = new NotificationCompat.Builder(this, "Setting").build();
                }
                startForeground(4130, notification);
                this.m = false;
                d = false;
            }
            if (!d || this.m) {
                return;
            }
            this.m = true;
//            i4.a().i("s_cpucooler_icon").commit();
//            i4.a().i("s_batterysaver_icon").commit();
//            i4.a().i("s_security_icon").commit();
//            i4.a().i("s_junkclean_icon").commit();
//            i4.a().i("s_boost_icon").commit();
//            i4.a().i("s_flashlight_icon").commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        v(null);
        j();
        p();
        u();
        q();
        s();
        nr1.k().g(this.n);
        nr1.k().i(this.n);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.screenReceiver != null) {
            unregisterReceiver(this.screenReceiver);
        }
        if (this.batteryReceiver != null) {
            unregisterReceiver(this.batteryReceiver);
        }
        if (this.widgetReceiver != null) {
            unregisterReceiver(this.widgetReceiver);
        }
        if (this.packageReceiver != null) {
            unregisterReceiver(this.packageReceiver);
        }
        cj cjVar = this.f;
        if (cjVar != null) {
            cjVar.c();
        }
        nr1.k().r(this.n);
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @SuppressLint("ForegroundServiceType")
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            n();
            startForeground(4130, new NotificationCompat.Builder(this, "Setting").build());
        } catch (Exception unused) {
        }
        j();
        o(Boolean.TRUE);
        r();
        return START_NOT_STICKY;
    }
}
