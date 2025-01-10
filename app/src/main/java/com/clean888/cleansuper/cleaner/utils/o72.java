package com.clean888.cleansuper.cleaner.utils;


import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.drawable.Drawable;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

import com.clean888.cleansuper.cleaner.R;
import com.unity3d.player.StringFog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;

/* loaded from: classes2.dex */
public class o72 extends im implements x11 {
    private static String c = StringFog.decrypt("BRYYCwsEVAETBzgg");
    private static String d = StringFog.decrypt("BRYYCwsEVAETFTYmDA==");

    /* loaded from: classes2.dex */
    private static class instance {
        private static final o72 a = new o72();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(List list, Observer gx1Var) throws Throwable {
        String str;
        if (list == null || list.isEmpty()) {
            str = null;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((vo2) it.next()).a);
            }
            str = StringFog.decrypt("ND0zQlhX") + arrayList.size();
            n(d, arrayList, new im.a() { // from class: j72
                @Override // im.a
                public final void a(List list2) {
                    o72.z(list2);
                }
            });
        }
        m().edit().putBoolean(h(d), true).apply();
        k(d, str);
        gx1Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(List list) {
        ev.a().f().a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(List list, Observer gx1Var) throws Throwable {
        String str;
        if (list == null || list.isEmpty()) {
            str = null;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((wo2) it.next()).a);
            }
            str = StringFog.decrypt("ND0zQlhX") + arrayList.size();
            n(c, arrayList, new im.a() { // from class: i72
                @Override // im.a
                public final void a(List list2) {
                    o72.B(list2);
                }
            });
        }
        m().edit().putBoolean(h(c), true).apply();
        k(c, str);
        gx1Var.onComplete();
    }

    public static o72 u() {
        return instance.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Observer gx1Var) throws Throwable {
        try {
            this.a = true;
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = zx.b(l(), R.raw.d_a).getJSONArray(StringFog.decrypt("JTwwEQ=="));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray v4 = (JSONArray)jSONArray.get(i);

                arrayList.add(new wo2(Integer.parseInt(v4.get(0).toString()), p72.b(((JSONArray) jSONArray.get(i)).get(1).toString())));
            }
            w(arrayList);
        } catch (Exception e) {
            this.a = false;
            i(c, e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Observer gx1Var) throws Throwable {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = zx.b(l(), R.raw.d_c).getJSONArray(StringFog.decrypt("JTwwEQ=="));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i);
                arrayList.add(new vo2(p72.b(jSONArray2.get(1).toString()), jSONArray2.get(3).toString(), jSONArray2.get(4).toString()));
            }
            v(arrayList);
        } catch (Exception e) {
            i(d, e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(List list) {
        ev.a().g().a(list);
    }

    @Override // defpackage.x11
    @WorkerThread
    public Cursor a(List<String> list) {
        return ev.a().f().b(list);
    }

    @Override // defpackage.j11
    public boolean b() {
        return m().getBoolean(h(c), false) && m().getBoolean(h(d), false);
    }

    @Override // defpackage.j11
    public void e() {
        if (this.a) {
            return;
        }
        if (!m().getBoolean(h(c), false)) {

            Observable.create(new ObservableOnSubscribe<Drawable>() {
                @SuppressLint("CheckResult")
                @Override
                public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Throwable {
                    o72.this.x((Observer) emitter);
                }
            }).subscribe();


        } else {
            j(c);
        }
        if (!m().getBoolean(h(d), false)) {

            Observable.create(new ObservableOnSubscribe<Drawable>() {
                @SuppressLint("CheckResult")
                @Override
                public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Throwable {
                    o72.this.y((Observer) emitter);
                }
            }).subscribe();


        } else {
            j(d);
        }
    }

    @Override // defpackage.x11
    @WorkerThread
    public Cursor f(List<String> list) {
        return ev.a().g().b(list);
    }

    @MainThread
    public void v(final List<vo2> list) {

        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @SuppressLint("CheckResult")
            @Override
            public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Throwable {
                o72.this.A(list,(Observer) emitter);
            }
        }).subscribe();


    }

    @MainThread
    public void w(final List<wo2> list) {

        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @SuppressLint("CheckResult")
            @Override
            public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Throwable {
                o72.this.C(list,(Observer) emitter);
            }
        }).subscribe();

    }

    private o72() {
    }
}