package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

/* loaded from: classes2.dex */
public class d91 {
    private volatile HashMap<String, Long> a;
    private volatile HashMap<String, String> b;
    private volatile boolean c;

    /* loaded from: classes2.dex */
    private static class instance {
        private static final d91 a = new d91();
    }

    private void b() {

//        Observable.create((ObservableEmitter<Observer> emitter) -> this.f(emitter)).subscribe();

        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @SuppressLint("CheckResult")
            @Override
            public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Throwable {
                d91.this.f(emitter);
            }
        }).subscribe();

    }

    public static d91 c() {
        return instance.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(ObservableEmitter gx1Var) throws Throwable {
        Context c = af1.c();
        if (c != null) {
            this.c = true;
            c.getPackageManager();
            List<PackageInfo> installedPackages = c.getPackageManager().getInstalledPackages(0);
            int size = installedPackages.size();
            for (int i = 0; i < size; i++) {
                PackageInfo packageInfo = installedPackages.get(i);
                Long l = null;
                try {
                    l = this.a.get(packageInfo.packageName);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (l == null) {
                    l = Long.valueOf(sp2.c(packageInfo.packageName));
                }
                if (l != null) {
                    try {
                        if (this.a == null) {
                            this.a = new HashMap<>();
                        }
                        this.a.put(packageInfo.packageName, l);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    public HashMap<String, String> d() {
        return this.b;
    }

    public HashMap<String, Long> e() {
        if (!this.c) {
            b();
        }
        return this.a;
    }

    private d91() {
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        b();
    }
}