package com.clean888.cleansuper.cleaner.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityEventCompat;

import com.blankj.utilcode.util.Utils;
//import com.blankj.utilcode.util.f;

/* loaded from: classes3.dex */
public final class fl {
    public static void a(@NonNull View view) {
        view.setTag("TAG_OFFSET");
        Object tag = view.getTag(-123);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + d(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(-123, Boolean.TRUE);
        }
    }

    private static void b(@NonNull Window window) {
        View findViewWithTag = window.getDecorView().findViewWithTag("TAG_OFFSET");
        if (findViewWithTag == null) {
            return;
        }
        a(findViewWithTag);
    }

    private static String c(int i) {
        try {
            return Utils.getApp().getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int d() {
        Resources resources = Utils.getApp().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    private static void e(@NonNull Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag("TAG_STATUS_BAR");
        if (findViewWithTag == null) {
            return;
        }
        findViewWithTag.setVisibility(View.GONE);
    }

    public static void f(@NonNull Activity activity, boolean z) {
        g(activity.getWindow(), z);
    }

    public static void g(@NonNull Window window, boolean z) {
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(c(id))) {
                childAt.setVisibility(z ? View.VISIBLE : View.INVISIBLE);
            }
        }
        if (z) {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-4611));
        } else {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
        }
    }

    public static void h(@NonNull Activity activity, boolean z) {
        i(activity.getWindow(), z);
    }

    public static void i(@NonNull Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public static void j(@NonNull Activity activity, boolean z) {
        k(activity.getWindow(), z);
    }

    public static void k(@NonNull Window window, boolean z) {
        if (z) {
            window.clearFlags(1024);
            l(window);
            b(window);
        } else {
            window.addFlags(1024);
            e(window);
            n(window);
        }
    }

    private static void l(@NonNull Window window) {
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag("TAG_STATUS_BAR");
        if (findViewWithTag == null) {
            return;
        }
        findViewWithTag.setVisibility(View.VISIBLE);
    }

    public static void m(@NonNull View view) {
        Object tag = view.getTag(-123);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - d(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setTag(-123, Boolean.FALSE);
    }

    private static void n(@NonNull Window window) {
        View findViewWithTag = window.getDecorView().findViewWithTag("TAG_OFFSET");
        if (findViewWithTag == null) {
            return;
        }
        m(findViewWithTag);
    }

    public static void o(@NonNull Activity activity) {
        p(activity.getWindow());
    }

    public static void p(@NonNull Window window) {
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }
}