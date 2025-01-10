package com.clean888.cleansuper.cleaner.utils;


import android.annotation.SuppressLint;
import android.util.Log;

import com.tencent.mmkv.MMKV;
import com.unity3d.player.StringFog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
//import io.reactivex.rxjava3.

/* loaded from: classes6.dex */
public class nr1 {

    private static String TAG = "nr1";
    /* renamed from: g, reason: collision with root package name */
    static final String f1940g = StringFog.decrypt("OjYqDRcObgACIycuDAIE");
    static final String h = StringFog.decrypt("IzoqBw==");
    private final String a;
    private final int b;
    private Observable c;
    private Disposable d;
    private List<b> e;
    private volatile d f;

    /* loaded from: classes6.dex */
    public interface b {
        void a(d dVar);
    }

    /* loaded from: classes6.dex */
    private static class instance {
        private static final nr1 a = new nr1();
    }

    /* loaded from: classes6.dex */
    public static class d {
        public long a;
        public long b;
        public long c;
        public int d;

        public d(long j, long j2, long j3, int i) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = i;
        }

        public String toString() {
            return StringFog.decrypt("ADI1Eh4CQhYDBDo9B1g=") + this.a + StringFog.decrypt("e3MmFAQeXSAOLTZ6") + this.b + StringFog.decrypt("e3MzDREWXSAOLTZ6") + this.c + StringFog.decrypt("e3M3BxcUVB0Tag==") + this.d + "}";
        }
    }

    private void h(int i) {
        if (this.c == null) {
            Observable<Long> f = Observable.interval(i, TimeUnit.SECONDS);
            this.c = f;
            this.d = f.subscribe(new Consumer<Object>() {
                @Override
                public void accept(Object obj) throws Throwable {
                    Log.d(TAG, " nr1 h() begin");
                    nr1.this.q((Long) obj);
                    Log.d(TAG, " nr1 h() end");
                } // from class: jr1
            });
        }
    }

    private d j() {
        int i;
        long[] a2 = fr1.a(af1.c(), 1024);
        long j = a2[1];
        long j2 = a2[0];
        long j3 = j - j2;
        boolean l = l();
        if (j != 0) {
            int i2 = (int) (((j3 * 1.0d) / j) * 100.0d);
            if (l) {
                int nextInt = new Random().nextInt(10) + 1;
                if (i2 < 70) {
                    i = nextInt + 70;
                }
                i = i2;
            } else {
                int nextInt2 = new Random().nextInt(20) + 1;
                if (i2 >= 70) {
                    i = 70 - nextInt2;
                }
                i = i2;
            }
        } else {
            i = 0;
        }
        d dVar = new d(j3, j2, j, i);
        if (af1.b()) {
            Log.d(TAG, StringFog.decrypt("dxwpIQ0SUhhddw==") + dVar.toString() + StringFog.decrypt("en4uESoBVAEzPj4iWA==") + l);
        }
        return dVar;
    }

    public static nr1 k() {
        return instance.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Observer gx1Var) throws Throwable {
        gx1Var.onNext(j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(d dVar) throws Throwable {
        this.f = dVar;
        synchronized (this.e) {
            List<b> list = this.e;
            if (list != null) {
                Iterator<b> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(dVar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(Observer gx1Var) throws Throwable {
        gx1Var.onNext(new d(0L, 0L, 0L, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(b bVar, d dVar) throws Throwable {
        synchronized (bVar) {
            if (this.f != null) {
                bVar.a(this.f);
            } else {
                f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Long l) throws Throwable {
        List<b> list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        f();
    }

    @SuppressLint("CheckResult")
    public void f() {
//        dx1.c(new jx1() { // from class: lr1
//            @Override // defpackage.jx1
//            public final void a(gx1 gx1Var) {
//                nr1.this.m(gx1Var);
//            }
//        }).l(mb2.a()).f(j5.c()).i(new iy() { // from class: ir1
//            @Override // defpackage.iy
//            public final void accept(Object obj) {
//                nr1.this.n((nr1.d) obj);
//            }
//        });

//        Observable.create(new ObservableOnSubscribe<Object>() {
//                    @Override
//                    public void subscribe(@NonNull ObservableEmitter<Object> gx1Var) throws Throwable {
//                        nr1.this.m(gx1Var);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object obj) throws Throwable {
//                        nr1.this.n((nr1.d) obj);
//                    }
//                });

        try {
            nr1.this.n(j());
        } catch (Throwable e) {
        }

    }

    @SuppressLint("CheckResult")
    public void g(final b bVar) {
//        dx1.c(new jx1() { // from class: mr1
//            @Override // defpackage.jx1
//            public final void a(gx1 gx1Var) {
//                nr1.ServerTimeListener(gx1Var);
//            }
//        }).l(mb2.a()).f(j5.c()).i(new iy() { // from class: kr1
//            @Override // defpackage.iy
//            public final void accept(Object obj) {
//                nr1.this.p(bVar, (nr1.d) obj);
//            }
//        });

//        Observable.create(new ObservableOnSubscribe<Object>() {
//                    @Override
//                    public void subscribe(@NonNull ObservableEmitter<Object> gx1Var) throws Throwable {
//                        nr1.ServerTimeListener(  gx1Var);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object obj) throws Throwable {
//                        nr1.this.p(bVar, (nr1.d) obj);
//                    }
//                } );

        try {
            nr1.this.p(bVar, new d(0, 0, 0, 0));
        } catch (Throwable e) {
        }
    }

    public nr1 i(b bVar) {
        if (bVar == null) {
            return this;
        }
        synchronized (this.e) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            if (!this.e.contains(bVar)) {
                this.e.add(bVar);
            }
        }
        return this;
    }

    public boolean l() {
        return Math.abs(System.currentTimeMillis() - MMKV.mmkvWithID(f1940g).getLong(h, 0L)) >= fr2.a * 5;
    }

    public nr1 r(b bVar) {
        if (bVar == null) {
            return this;
        }
        synchronized (this.e) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            if (this.e.contains(bVar)) {
                this.e.remove(bVar);
            }
        }
        return this;
    }

    public void s() {
        MMKV.mmkvWithID(f1940g).putLong(h, System.currentTimeMillis());
    }

    private nr1() {
        this.a = StringFog.decrypt("GjYqDRcOYhodMhAvBwYcfBQV");
        this.b = 180;//Opcodes.GETFIELD;
        this.e = new ArrayList();
        h(this.b);
    }
}