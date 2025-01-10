package com.clean888.cleansuper.cleaner.utils.AboutSplash;

import android.content.Intent;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class sh {

    @NotNull
    public static final sh a = new sh();

    private sh() {
    }

    @JvmStatic
    public static final int a(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return intent.getIntExtra("track_scene", -1);
    }

    @JvmStatic
    public static final int b(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return intent.getIntExtra("track_scene1", -1);
    }

    @JvmStatic
    public static final void c(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.removeExtra("track_scene1");
    }

    @JvmStatic
    public static final void d(@NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("track_scene", i);
    }

    @JvmStatic
    public static final void e(@NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("track_scene1", i);
    }

    @JvmStatic
    public static final void f(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
//        i4.a().i("c_activity").putEbKey1(Integer.valueOf(a(intent))).commit();
    }

    @JvmStatic
    public static final void g(@NotNull Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        int a2 = a(intent);
//        ol0 i = i4.a().i("close_activity");
//        if (z) {
//            i.putEbKey2(1);
//        } else {
//            i.putEbKey2(2);
//        }
//        i.putEbKey1(Integer.valueOf(a2)).commit();
    }

    @JvmStatic
    public static final void h(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
//        i4.a().i("s_activity").putEbKey1(Integer.valueOf(a(intent))).commit();
    }

    @JvmStatic
    public static final void i(@NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        int b = b(intent);
        if (b != -1) {
//            i4.a().i("s_activity_home").putEbKey1(Integer.valueOf(b)).putEbKey2(Integer.valueOf(i)).commit();
        }
    }
}
