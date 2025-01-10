package com.clean888.cleansuper.cleaner.ui.fragment;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.clean888.cleansuper.cleaner.utils.qi;
//import com.clean888.cleansuper.cleaner.ui.Utils.pi;
import com.tencent.mmkv.MMKV;

/* loaded from: classes2.dex */
public final class BAHT {

    private static String strMapID = "baht";
    private static String strKey = "is_first_should_show_request_permission_rationale";

    @Nullable
    private static ActivityResultLauncher<String[]> b;

    @NotNull
    public static final BAHT a = new BAHT();

    @NotNull
    private static WeakHashMap<Activity, Runnable> c = new WeakHashMap<>();

    @NotNull
    private static WeakHashMap<Activity, Function1<Boolean, Unit>> d = new WeakHashMap<>();

    @NotNull
    private static WeakHashMap<Activity, ActivityResultLauncher<String[]>> e = new WeakHashMap<>();

    @NotNull
    private static final LifecycleEventObserver f = new LifecycleEventObserver() { // from class: bfj.cjzk.vicnp.BAHT$mLifecycleEventObserver$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
            ActivityResultLauncher activityResultLauncher;
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_DESTROY) {
                activityResultLauncher = BAHT.b;
                if (activityResultLauncher != null) {
                    activityResultLauncher.unregister();
                }
                source.getLifecycle().removeObserver(this);
                if (source instanceof Activity) {
                    BAHT.a.i((Activity) source);
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public static final class aa implements Application.ActivityLifecycleCallbacks {
        aa() {
        }


        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Activity activity, Map permissions) {
            Iterator withIndex;
            Intrinsics.checkNotNullParameter(activity, "$activity");
            int[] iArr = new int[permissions.size()];
            Intrinsics.checkNotNullExpressionValue(permissions, "permissions");
            withIndex = CollectionsKt.withIndex(permissions.entrySet().iterator());
            while (withIndex.hasNext()) {
                IndexedValue indexedValue = (IndexedValue) withIndex.next();
                iArr[indexedValue.getIndex()] = ((Boolean) ((Map.Entry) indexedValue.getValue()).getValue()).booleanValue() ? 1 : 0;
            }
            BAHT baht = BAHT.a;
            ArrayList arrayList = new ArrayList(permissions.size());
            Iterator it = permissions.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Map.Entry) it.next()).getKey());
            }
            baht.o(activity, 1002, (String[]) arrayList.toArray(new String[0]), iArr);
        }


        private final void b(final Activity activity) {
            if (!(activity instanceof FragmentActivity) || BAHT.e.containsKey(activity)) {
                return;
            }
            ActivityResultLauncher registerForActivityResult = ((FragmentActivity) activity).registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ti
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    BAHT.aa.c(activity, (Map) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activity.registerForActi}");
            BAHT.e.put(activity, registerForActivityResult);
        }


        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (BAHT.e.containsKey(activity)) {
                BAHT.e.remove(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    private BAHT() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:

        if ((androidx.core.content.ContextCompat.checkSelfPermission(r4, "android.permission.POST_NOTIFICATIONS") != 0) != false) goto L11;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int e(@org.jetbrains.annotations.NotNull android.app.Activity arg4) {
        Intrinsics.checkNotNullParameter(arg4, "activity");
        int v1 = Build.VERSION.SDK_INT >= 33 &&
                ContextCompat.checkSelfPermission(arg4, "android.permission.POST_NOTIFICATIONS") != 0 ? 0 : 1;
        return v1 != 1 || (qi.a.a(arg4)) ? v1 : -1;
    }

    private final List<Boolean> f(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (!(strArr.length == 0)) {
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    arrayList.add(Boolean.FALSE);
                } else {
                    arrayList.add(Boolean.TRUE);
                }
            }
        }
        return arrayList;
    }

    private final boolean g(Context context, String[] strArr) {
        List<Boolean> f2 = f(context, strArr);
        if (f2.isEmpty()) {
            return false;
        }
        if (!f2.isEmpty()) {
            Iterator<Boolean> it = f2.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void h(Activity activity) {
        c.remove(activity);
        d.remove(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Activity activity) {
        h(activity);
        ActivityResultLauncher<String[]> activityResultLauncher = b;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
        b = null;
        if (activity instanceof FragmentActivity) {
            try {
                ((FragmentActivity) activity).getLifecycle().removeObserver(f);
            } catch (Exception unused) {
            }
        }
    }

    private final void j(Activity activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getLifecycle().addObserver(f);
                ActivityResultLauncher<String[]> activityResultLauncher = e.get(activity);
                b = activityResultLauncher;
                if (activityResultLauncher != null) {
                    activityResultLauncher.launch(new String[]{"android.permission.POST_NOTIFICATIONS"});
                    return;
                }
                return;
            }
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1002);
        }
    }

    private final void k(Activity activity, Runnable runnable, Function1<? super Boolean, Unit> function1) {
        h(activity);
        if (runnable != null) {
            c.put(activity, runnable);
        }
        d.put(activity, (Function1<Boolean, Unit>) function1);
    }

    @JvmStatic
    public static final void l(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(new aa());
    }

    @JvmStatic
    public static final void m(@NotNull Activity activity, int i, int i2, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (i == 1003) {
            BAHT baht = a;
            if (e(activity) == 1) {
                baht.p(activity, true);
            } else {
                baht.p(activity, false);
            }
            baht.i(activity);
        }
    }

    @JvmStatic
    public static final void n(@NotNull Activity activity, int i, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (b == null) {
            a.o(activity, i, permissions, grantResults);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Activity activity, int i, String[] strArr, int[] iArr) {
        if (i == 1002) {
            if (g(activity, strArr)) {
//                pi.a.c(true);
                MMKV.mmkvWithID(strMapID).putBoolean(strKey,true);
                p(activity, true);
                return;
            }
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACTIVITY_RECOGNITION")) {

                if (MMKV.mmkvWithID(strMapID).getBoolean(strKey,true)) {
                    p(activity, false);
//                    piVar.c(false);
                    MMKV.mmkvWithID(strMapID).putBoolean(strKey,false);
                    i(activity);
                    return;
                } else {
                    Runnable runnable = c.get(activity);
                    if (runnable != null) {
                        runnable.run();
                    }
                    if (c.get(activity) == null) {
                        i(activity);
                        return;
                    }
                    return;
                }
            }
            p(activity, false);
            i(activity);
        }
    }

    private final void p(Activity activity, boolean z) {
        Function1<Boolean, Unit> function1 = d.get(activity);
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    @JvmStatic
    public static final void q(@NotNull Activity activity, @Nullable Runnable runnable, @NotNull Function1<? super Boolean, Unit> callBack) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        BAHT baht = a;
        baht.k(activity, runnable, callBack);
        int e2 = e(activity);
        if (e2 == -1) {
            if (runnable != null) {
                runnable.run();
            }
            if (runnable == null) {
                baht.i(activity);
                return;
            }
            return;
        }
        if (e2 != 0) {
//            pi.a.c(true);
            MMKV.mmkvWithID(strMapID).putBoolean(strKey,true);
            callBack.invoke(Boolean.TRUE);
            baht.i(activity);
            return;
        }
        baht.j(activity);
    }
}
