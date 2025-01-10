package com.clean888.cleansuper.cleaner.utils;


import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/* loaded from: classes2.dex */
public class kh {
    private HashMap<String, WeakReference<Drawable>> a = new HashMap<>();
    private HashMap<String, Disposable> b = new HashMap<>();
    private Drawable c;
    private c d;
    PackageManager e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Drawable> {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // defpackage.mx1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(Drawable drawable) {
            try {
                if (this.a.b != null && drawable != null) {
                    kh.this.a.put(this.a.b, new WeakReference(drawable));
                    kh.this.l(this.a.a.get());
                }
                kh.this.o(this.a);
            } catch (Throwable unused) {
            }
        }

        @Override // defpackage.mx1
        public void onSubscribe(Disposable rf0Var) {
            try {
                kh.this.b.put(this.a.b, rf0Var);
            } catch (Throwable unused) {
            }
        }

        @Override // defpackage.mx1
        public void onComplete() {
        }

        @Override // defpackage.mx1
        public void onError(Throwable th) {
            try {
                kh.this.o(this.a);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        WeakReference<ImageView> a;
        String b;

        public b(ImageView imageView, String str) {
            this.a = new WeakReference<>(imageView);
            this.b = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(ImageView imageView, Drawable drawable);
    }

    public kh(Drawable drawable) {
        this.c = drawable;
    }

    private void g(final ImageView imageView, final Drawable drawable) {
        if (Looper.myLooper() != Looper.getMainLooper() || imageView == null) {
            return;
        }
        if (this.d != null) {
            imageView.post(new Runnable() { // from class: jh
                @Override // java.lang.Runnable
                public final void run() {
                    kh.this.i(imageView, drawable);
                }
            });
            return;
        }
        try {
            imageView.setImageDrawable(drawable);
            imageView.setAdjustViewBounds(true);
        } catch (Exception unused) {
        }
    }

    private Observer<Drawable> h(final b bVar, Observer<Drawable> mx1Var) {
//        dx1.c(new jx1() { // from class: ih
//            @Override // defpackage.jx1
//            public final void a(gx1 gx1Var) {
//                kh.this.j(bVar, gx1Var);
//            }
//        }).l(mb2.b()).f(j5.c()).subscribe(mx1Var);

        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Throwable {
                kh.this.j(bVar, emitter);
            }
        }).subscribe(mx1Var);
        return mx1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ImageView imageView, Drawable drawable) {
        try {
            this.d.a(imageView, drawable);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(b bVar, ObservableEmitter gx1Var) throws Throwable {
        Drawable drawable = null;
        try {
            PackageManager packageManager = this.e;
            if (packageManager != null) {
                drawable = packageManager.getApplicationInfo(bVar.b, 0).loadIcon(this.e);
            }
        } catch (Exception unused) {
        }
        //gx1Var.a(drawable);
        gx1Var.onNext(drawable);
        gx1Var.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(ImageView imageView) {
        String str;
        WeakReference<Drawable> weakReference;
        Drawable drawable;
        if (imageView != null) {
            try {
                if (imageView.getContext() != null && (imageView.getContext() instanceof Activity) && !((Activity) imageView.getContext()).isFinishing() && Looper.myLooper() == Looper.getMainLooper() && imageView.getTag() != null && (imageView.getTag() instanceof String) && (str = (String) imageView.getTag()) != null && (weakReference = this.a.get(str)) != null && (drawable = weakReference.get()) != null) {
                    g(imageView, drawable);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void m(b bVar) {
        if (bVar != null) {
            synchronized (this.b) {
                if (this.b.get(bVar.b) == null) {
                    h(bVar, new a(bVar));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(b bVar) {
        try {
            this.b.get(bVar.b).dispose();
        } catch (Exception unused) {
        }
        try {
            this.b.remove(bVar.b);
        } catch (Exception unused2) {
        }
    }

    public synchronized void k(ImageView imageView, String str) {
        Drawable drawable;
        try {
            try {
                if (!TextUtils.isEmpty(str) && imageView != null && imageView.getContext() != null && (imageView.getContext() instanceof Activity) && !((Activity) imageView.getContext()).isFinishing()) {
                    if (str.equals(imageView.getTag()) && imageView.getDrawable() != null) {
                        return;
                    }
                    imageView.setTag(str);
                    try {
                        if (this.e == null) {
                            this.e = imageView.getContext().getPackageManager();
                        }
                    } catch (Exception unused) {
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        WeakReference<Drawable> weakReference = this.a.get(str);
                        if (weakReference != null && (drawable = weakReference.get()) != null) {
                            g(imageView, drawable);
                        } else if (this.b.get(str) == null) {
                            m(new b(imageView, str));
                        }
                    }
                }
            } catch (Throwable unused2) {
                if (Looper.myLooper() == Looper.getMainLooper() && imageView.getDrawable() == null) {
                    imageView.setTag(str);
                    if (this.e == null) {
                        this.e = imageView.getContext().getPackageManager();
                    }
                    Drawable loadIcon = this.e.getApplicationInfo(str, 0).loadIcon(this.e);
                    g(imageView, loadIcon);
                    this.a.put(str, new WeakReference<>(loadIcon));
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public void n() {
        try {
            this.a.clear();
        } catch (Exception unused) {
        }
        try {
            synchronized (this.b) {
                Iterator<String> it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    try {
                        this.b.get(it.next()).dispose();
                    } catch (Exception unused2) {
                    }
                }
            }
            this.b.clear();
        } catch (Exception unused3) {
        }
    }
}
