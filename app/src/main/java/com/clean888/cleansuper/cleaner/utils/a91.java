package com.clean888.cleansuper.cleaner.utils;


import android.util.Log;
import androidx.lifecycle.Observer;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: classes2.dex */
public class a91 {
    public static final String c = StringFog.decrypt("HSYpCSE1");
    private b a;
    private Observer<Object> b;

    /* loaded from: classes2.dex */
    class a implements Observer<Object> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            if (a91.this.a()) {
                LiveEventBus.get(StringFog.decrypt("EzEIEjYDVAMhPj0uEQ0=")).removeObserver(a91.this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    private static class instance {
        private static final a91 a = new a91();
    }

    /* synthetic */
//    a91(a aVar) {
//        this();
//    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
/*        boolean b2 = h().b();
        if (!f().b()) {
            b2 = false;
        }
        boolean z = g().b() ? b2 : false;*/
        boolean z = true;
        if (z) {
            if (af1.b()) {
                Log.d(c, StringFog.decrypt("FDsiAQ4xWB0OJDtqT0haHF4="));
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.b();
            }
        }
        return z;
    }

    public static a91 e() {
        return instance.a;
    }

    public void b(b bVar) {
        if (af1.b()) {
            Log.d(c, StringFog.decrypt("FDsiAQ4+XxoTen5qT0ha"));
        }
        this.a = bVar;
        if (bVar != null) {
            bVar.a();
        }
        boolean z = true;
        boolean z2 = false;
        /*if (!h().b()) {
            h().e();
            z = false;
        }
        if (!f().b()) {
            f().e();
            z = false;
        }
        if (g().b()) {
            z2 = z;
        } else {
            g().e();
        }
        if (z2) {
            if (af1.b()) {
                Log.d(c, StringFog.decrypt("FDsiAQ4xWB0OJDtqT0haHF5HPiBnIwkbESECNjc+QiYYXAMLMici"));
            }
            if (bVar != null) {
                bVar.b();
            }
            try {
                LiveEventBus.get(StringFog.decrypt("EzEIEjYDVAMhPj0uEQ0=")).removeObserver(this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    public g11 f() {
        return s.r();
    }

    public i11 g() {
        return z5.x();
    }

    public x11 h() {
        return o72.u();
    }

    private a91() {
        this.b = new a();
        LiveEventBus.get(StringFog.decrypt("EzEIEjYDVAMhPj0uEQ0=")).observeForever(this.b);
    }
}
