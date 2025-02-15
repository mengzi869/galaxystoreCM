package com.clean888.cleansuper.cleaner.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class sf {
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2044g = false;
    public boolean h = true;
    public boolean i = false;
    public int j = 5;
    public int k = 30;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;

    /* loaded from: classes2.dex */
    class a implements Function1<StringBuilder, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(StringBuilder sb) {
            sb.append("当前的功能开关：");
            sb.append(sf.this.toString());
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private static final class b_b {
        static final sf a = new sf();
    }

    public static sf a() {
        return  b_b.a;
    }

    public void b() {
//        this.a = li.c("notification_state", 1) == 1;
//        this.b = li.c("auto_boost_state", 1) == 1;
//        this.c = li.c("shake_boost_state", 1) == 1;
//        this.d = li.c("uninstall_clean_state", 1) == 1;
//        this.e = li.c("install_scan_state", 1) == 1;
//        this.f = li.c("battery_state", 1) == 1;
//        this.f2044g = li.c("wallpaper_boost_state", 2) == 1;
//        this.h = li.c("first_clean_state", 1) == 1;
//        boolean z = li.c("protect_state", 1) == 1;
//        this.i = z;
//        if (!z) {
//            this.i = li.c("revive_state", 1) == 1;
//        }
//        this.j = li.c("load_time", this.j);
//        this.k = li.c("mission_board_time", this.k);
//        int min = Math.min(30, this.j);
//        this.j = min;
//        this.j = Math.max(1, min);
//        this.k = Math.max(0, this.k);
//        this.l = li.c("front_state", 2) == 1;
//        this.m = li.c("lockscreen_state", 2) == 1;
//        this.n = li.b("skip_activity_pop", false);
//        th.a("AB功能开关打印", new a());

        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.f2044g = true;//
        this.h = true;
        boolean z =true;
        this.i = z;
        if (!z) {
            this.i = true;
        }
        this.j = 5;
        this.k = 30;
        int min = Math.min(30, this.j);
        this.j = min;
        this.j = Math.max(1, min);
        this.k = Math.max(0, this.k);
        this.l = true;
        this.m = true;
        this.n = true;
//        th.a("AB功能开关打印", new a());
    }

    public String toString() {
        return "BAEP{isNotification=" + this.a + ", isAutoBoost=" + this.b + ", isShakeBoost=" + this.c + ", isUninstallClean=" + this.d + ", isInstallScan=" + this.e + ", isBatteryClean=" + this.f + ", isWallpaperClean=" + this.f2044g + ", isFirstClean=" + this.h + ", isProtect=" + this.i + ", loadTime=" + this.j + ", missionBoardTime=" + this.k + ", isFrontCanShowExternalScene=" + this.l + ", isLockScreenCanShowExternalScene=" + this.m + "}";
    }
}
