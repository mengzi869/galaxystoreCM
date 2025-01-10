package com.clean888.cleansuper.cleaner.utils;

import android.app.Activity;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

public final class si {

//    @NotNull
//    public static final si a = new si();
//
//    /* loaded from: classes2.dex */
//    public static final class a implements Application.ActivityLifecycleCallbacks {
//        a() {
//        }
//
//        @Override // android.app.Application.ActivityLifecycleCallbacks
//        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
//            Intrinsics.checkNotNullParameter(activity, "activity");
//            if (si.c(activity, "in_app") == null) {
//                si.e(activity);
//            }
//        }
//
//        @Override // android.app.Application.ActivityLifecycleCallbacks
//        public void onActivityDestroyed(@NotNull Activity activity) {
//            Intrinsics.checkNotNullParameter(activity, "activity");
//        }
//
//        @Override // android.app.Application.ActivityLifecycleCallbacks
//        public void onActivityPaused(@NotNull Activity activity) {
//            Intrinsics.checkNotNullParameter(activity, "activity");
//        }
//
//        @Override // android.app.Application.ActivityLifecycleCallbacks
//        public void onActivityResumed(@NotNull Activity activity) {
//            Intrinsics.checkNotNullParameter(activity, "activity");
//        }
//
//        @Override // android.app.Application.ActivityLifecycleCallbacks
//        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
//            Intrinsics.checkNotNullParameter(activity, "activity");
//            Intrinsics.checkNotNullParameter(outState, "outState");
//        }
//
//        @Override // android.app.Application.ActivityLifecycleCallbacks
//        public void onActivityStarted(@NotNull Activity activity) {
//            Intrinsics.checkNotNullParameter(activity, "activity");
//        }
//
//        @Override // android.app.Application.ActivityLifecycleCallbacks
//        public void onActivityStopped(@NotNull Activity activity) {
//            Intrinsics.checkNotNullParameter(activity, "activity");
//        }
//    }
//
//    private si() {
//    }
//
//    @JvmStatic
//    @NotNull
//    public static final Pair<Drawable, String> a(@NotNull Context context) {
//        Object obj;
//        Object first;
//        Intrinsics.checkNotNullParameter(context, "context");
//        List<ResolveInfo> b = b(context);
//        if (b.isEmpty()) {
//            Drawable drawable = ContextCompat.getDrawable(context, R.mipmap.ic_waiguang);
//            Intrinsics.checkNotNull(drawable);
//            return new Pair<>(drawable, "Browser");
//        }
//        Iterator it = b.iterator();
//        while (true) {
//            if (!it.hasNext()) {
//                obj = null;
//                break;
//            }
//            obj = it.next();
//            if (((ResolveInfo) obj).isDefault) {
//                break;
//            }
//        }
//        ResolveInfo resolveInfo = (ResolveInfo) obj;
//        if (resolveInfo == null) {
//            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) b);
//            resolveInfo = (ResolveInfo) first;
//        }
//        return new Pair<>(resolveInfo.loadIcon(context.getPackageManager()), resolveInfo.loadLabel(context.getPackageManager()).toString());
//    }
//
//    @JvmStatic
//    @NotNull
//    public static final List<ResolveInfo> b(@NotNull Context context) {
//        List<ResolveInfo> queryIntentActivities;
//        Intrinsics.checkNotNullParameter(context, "context");
//        PackageManager packageManager = context.getPackageManager();
//        Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
//        Intent intent = new Intent("android.intent.action.VIEW");
//        intent.setData(Uri.parse("http://"));
//        if (Build.VERSION.SDK_INT >= 23) {
//            queryIntentActivities = packageManager.queryIntentActivities(intent, 131072);
//        } else {
//            queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
//        }
//        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "if (Build.VERSION.SDK_IN…H_DEFAULT_ONLY)\n        }");
//        return queryIntentActivities;
//    }

    @JvmStatic
    @Nullable
    public static final String c(@NotNull Activity activity, @NotNull String key) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128).metaData.getString(key);
        } catch (Exception unused) {
            return null;
        }
    }
//
//    @JvmStatic
//    public static final void d(@NotNull Application application) {
//        Intrinsics.checkNotNullParameter(application, "application");
//        application.registerActivityLifecycleCallbacks(new a());
//    }
//
//    @JvmStatic
//    public static final void e(@NotNull Activity activity) {
//        Intrinsics.checkNotNullParameter(activity, "activity");
//        try {
//            Pair<Drawable, String> a2 = a(activity);
//            activity.setTaskDescription(new ActivityManager.TaskDescription(a2.getSecond(), DrawableKt.toBitmap$default(a2.getFirst(), 0, 0, null, 7, null)));
//        } catch (Exception unused) {
//        }
//    }
}
