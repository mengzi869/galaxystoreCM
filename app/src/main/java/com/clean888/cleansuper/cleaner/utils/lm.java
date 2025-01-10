package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Observer;

import com.clean888.cleansuper.cleaner.BuildConfig;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class lm<T> extends fn<Void, T, Integer> {
    public static final String l = StringFog.decrypt("HRETNg0FVBIDCBYRPTU2YzYpAw==");

    /* renamed from: g, reason: collision with root package name */
    public Integer f1903g;
    public Integer h;
    protected boolean i = BuildConfig.DEBUG;
    private String j;
    private Observer<String> k;

    public lm(Context context) {
        super(context);
        this.f1903g = 10000;
        this.h = -10000;
        this.k = new Observer() { // from class: km
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                lm.this.r((String) obj);
            }
        };
        String n = n();
        if (TextUtils.isEmpty(n)) {
            return;
        }
        try {
            this.j = n + StringFog.decrypt("CA==") + new SimpleDateFormat(StringFog.decrypt("Lio+Gyg6VRcvHz4qERY="), Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str) {
        if (TextUtils.isEmpty(this.j) || !this.j.equalsIgnoreCase(str)) {
            return;
        }
        if (this.i) {
            Log.d(StringFog.decrypt("HSYpCTEfQxYGMw=="), StringFog.decrypt("DBYxBwsDZQEOMDQiEDhN") + this.j);
        }
        if (g()) {
            return;
        }
        d();
    }

    protected abstract String n();

    protected void o() {
        try {
            if (this.i) {
                Log.d(StringFog.decrypt("HSYpCTEfQxYGMw=="), StringFog.decrypt("DBYxBwsDcxoJMw59") + this.j);
            }
            LiveEventBus.get(l, String.class).observeForever(this.k);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected long p(String str, long j, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.i) {
            Log.d(StringFog.decrypt("AxoKJzo0eTYkHGk=") + str, str2 + " " + (((float) (currentTimeMillis - j)) / 1000.0f) + StringFog.decrypt("JA=="));
        }
        return currentTimeMillis;
    }

    public String q() {
        return this.j;
    }

    public void s() {
        if (this.k != null) {
            try {
                LiveEventBus.get(l, String.class).removeObserver(this.k);
                if (this.i) {
                    Log.d(StringFog.decrypt("HSYpCTEfQxYGMw=="), StringFog.decrypt("DBYxBwsDYxYKOCUiBjhN") + this.j);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}