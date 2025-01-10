package com.clean888.cleansuper.cleaner.utils;

import android.database.Cursor;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

import com.clean888.cleansuper.cleaner.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.Observer;


/* loaded from: classes2.dex */
public class z5 extends im implements i11 {
    private static String c = StringFog.decrypt("FDIkCgAoWB0UMiEzMg4QeAcCOg==");
    private static String d = StringFog.decrypt("FDIkCgAoWB0UMiEzMgQDWTECNj0OFgAa");
    private static String e = StringFog.decrypt("FDIkCgAoWB0UMiEzMgQDWT0IMzYOFgAa");

    /* loaded from: classes2.dex */
    private static class instance {
        private static final z5 a = new z5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Observer gx1Var) throws Throwable {
        try {
            this.a = true;
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = zx.b(l(), R.raw.c_b).getJSONArray(StringFog.decrypt("JTwwEQ=="));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i);
                arrayList.add(new uo2(jSONArray2.getLong(1), jSONArray2.getLong(0), jSONArray2.get(2).toString()));
            }
            A(arrayList);
        } catch (Exception e2) {
            this.a = false;
            i(c, e2);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Observer gx1Var) throws Throwable {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = zx.b(l(), R.raw.c_ec).getJSONArray(StringFog.decrypt("JTwwEQ=="));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i);
                arrayList.add(new so2(jSONArray2.getLong(0), jSONArray2.getLong(1), jSONArray2.get(2).toString()));
            }
            y(arrayList);
        } catch (Exception e2) {
            i(d, e2);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Observer gx1Var) throws Throwable {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = zx.b(l(), R.raw.c_d).getJSONArray(StringFog.decrypt("JTwwEQ=="));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i);
                arrayList.add(new to2(jSONArray2.getLong(0), jSONArray2.getString(1)));
            }
            z(arrayList);
        } catch (Exception e2) {
            i(e, e2);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(List list) {
        ev.a().c().a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(List list, Observer gx1Var) throws Throwable {
        String str;
        if (list == null || list.isEmpty()) {
            str = null;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((so2) it.next()).a);
            }
            str = StringFog.decrypt("ND0zQlhX") + arrayList.size();
            n(d, arrayList, new im.a() { // from class: s5
                @Override // im.a
                public final void a(List list2) {
                    z5.E(list2);
                }
            });
        }
        m().edit().putBoolean(h(d), true).apply();
        k(d, str);
        gx1Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(List list) {
        ev.a().d().a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(List list, Observer gx1Var) throws Throwable {
        String str;
        if (list == null || list.size() <= 0) {
            str = null;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((to2) it.next()).a);
            }
            str = StringFog.decrypt("ND0zQlhX") + arrayList.size();
            n(e, arrayList, new im.a() { // from class: r5
                @Override // im.a
                public final void a(List list2) {
                    z5.G(list2);
                }
            });
        }
        m().edit().putBoolean(h(e), true).apply();
        k(e, str);
        gx1Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(List list) {
        ev.a().e().a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(List list, Observer gx1Var) throws Throwable {
        String str;
        if (list == null || list.size() == 0) {
            str = null;
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((uo2) it.next()).a);
            }
            str = StringFog.decrypt("ND0zQlhX") + arrayList.size();
            n(c, arrayList, new im.a() { // from class: q5
                @Override // im.a
                public final void a(List list2) {
                    z5.I(list2);
                }
            });
        }
        m().edit().putBoolean(h(c), true).apply();
        k(c, str);
        gx1Var.onComplete();
    }

    public static z5 x() {
        return instance.a;
    }

    @MainThread
    public void A(final List<uo2> list) {

        Observable.create((ObservableEmitter<Observer> emitter) -> this.J(list,(Observer) emitter)).subscribe();
    }

    @Override // defpackage.j11
    public boolean b() {
        return m().getBoolean(h(c), false) && m().getBoolean(h(d), false) && m().getBoolean(h(e), false);
    }

    @Override // defpackage.i11
    @WorkerThread
    public Cursor c(List<Long> list) {
        return ev.a().c().b(list);
    }

    @Override // defpackage.i11
    @WorkerThread
    public Cursor d(Long l) {
        return ev.a().e().b(l);
    }

    @Override // defpackage.j11
    public void e() {
        if (this.a) {
            return;
        }
        if (!m().getBoolean(h(c), false)) {
            Observable.create((ObservableEmitter<Observer> emitter) -> this.B((Observer) emitter)).subscribe();
        } else {
            j(c);
        }
        if (!m().getBoolean(h(d), false)) {
            Observable.create((ObservableEmitter<Observer> emitter) -> this.C((Observer) emitter)).subscribe();
        } else {
            j(d);
        }
        if (!m().getBoolean(h(e), false)) {
            Observable.create((ObservableEmitter<Observer> emitter) -> this.D((Observer) emitter)).subscribe();
        } else {
            j(e);
        }
    }

    @Override // defpackage.i11
    @WorkerThread
    public Cursor g(List<Long> list) {
        return ev.a().d().b(list);
    }

    @MainThread
    public void y(final List<so2> list) {
        Observable.create((ObservableEmitter<Observer> emitter) -> this.F(list,(Observer) emitter)).subscribe();
    }

    @MainThread
    public void z(final List<to2> list) {
        Observable.create((ObservableEmitter<Observer> emitter) -> this.H(list,(Observer) emitter)).subscribe();
    }

    private z5() {
    }
}
