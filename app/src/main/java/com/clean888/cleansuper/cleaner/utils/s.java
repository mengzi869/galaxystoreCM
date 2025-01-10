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
public class s extends im implements g11 {
    private static String c = StringFog.decrypt("FhcYCwsEVAETAzI1BQADeAcCOg==");

    /* loaded from: classes2.dex */
    private static class instance {
        private static final s a = new s();
    }

    public static s r() {
        return instance.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Observer gx1Var) throws Throwable {
        try {
            this.a = true;
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = zx.b(l(), R.raw.a_a).getJSONArray(StringFog.decrypt("JTwwEQ=="));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = (JSONArray) jSONArray.get(i);
                arrayList.add(new ro2(jSONArray2.get(1).toString(), jSONArray2.get(3).toString(), 0L));
            }
            s(arrayList);
        } catch (Exception e) {
            this.a = false;
            i(c, e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(List list) {
        ev.a().b().a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(List list, Observer gx1Var) throws Throwable {
        String str;
        if (list == null || list.size() <= 0) {
            str = "";
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ro2) it.next()).a);
            }
            str = StringFog.decrypt("ND0zQlhX") + arrayList.size();
            n(c, arrayList, new im.a() { // from class: p
                @Override // im.a
                public final void a(List list2) {
                    s.u(list2);
                }
            });
        }
        m().edit().putBoolean(h(c), true).apply();
        k(c, str);
        gx1Var.onComplete();
    }

    @Override // defpackage.g11
    @WorkerThread
    public Cursor a(List<String> list) {
        return ev.a().b().b();
    }

    @Override // defpackage.j11
    public boolean b() {
        return m().getBoolean(h(c), false);
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
                    s.this.t((Observer) emitter);
                }
            }).subscribe();

        } else {
            j(c);
        }
    }

    @MainThread
    public void s(final List<ro2> list) {
        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @SuppressLint("CheckResult")
            @Override
            public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Throwable {
                s.this.v(list,(Observer) emitter);
            }
        }).subscribe();

    }

    private s() {
    }
}