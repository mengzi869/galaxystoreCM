package com.clean888.cleansuper.cleaner;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.ThreadUtils;
import com.clean888.cleansuper.cleaner.utils.ConWrapper;
import com.clean888.cleansuper.cleaner.utils.L;
import com.clean888.cleansuper.cleaner.utils.a_mmkv;
import com.clean888.cleansuper.cleaner.utils.af1;
import com.clean888.cleansuper.cleaner.utils.bj;
import com.clean888.cleansuper.cleaner.utils.d91;
import com.clean888.cleansuper.cleaner.utils.dj;
import com.clean888.cleansuper.cleaner.utils.fi;
import com.clean888.cleansuper.cleaner.utils.gi;
import com.clean888.cleansuper.cleaner.utils.kj;
import com.clean888.cleansuper.cleaner.utils.rc;
import com.clean888.cleansuper.cleaner.utils.sf;
import com.clean888.cleansuper.cleaner.utils.z22;
import com.clean888.cleansuper.cleaner.ui.fragment.BAHT;
import com.clean888.overseas.OverseasSupportApp;
import com.mbridge.msdk.k_cor.KSManager;
import com.nb.Hba;
import com.tencent.mmkv.MMKV;

//ZZR
public class SuperApplication extends Application implements a_mmkv.b {
    private static Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends ThreadUtils.SimpleTask<String> {
        a() {
        }

        @Override
        public String doInBackground() throws Throwable {
//            String b = ni.b();
//            CrashReport.initCrashReport(SuperApplication.this, b, false);
//            return b;
            return null;
        }

        @Override
        public void onSuccess(String result) {

        }
    }

    public static Context getContext() {
        return context;
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 26) {
            Hba.a(kba(this, "com.purple.files.manager.king"));
        }
    }

    private static Context kba(Context context, String str) {
        Log.i("SDKTypeConfig", "getSdkFactory:" + str);
        if (TextUtils.isEmpty(str)) {
            Log.i("SDKTypeConfig", "getSdkFactory:--origin");
            return context;
        }
        Log.i("SDKTypeConfig", "getSdkFactory:--back");
        return new ConWrapper(context, str);
    }

    private void c() {
        ThreadUtils.executeByIo(new a());
    }

    private void d() {
        try {
            KSManager.init(this, BuildConfig.class.getName());
//            i4.a().i("i_account").commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void e() {
        if (z22.a(this)) {
            sf.a().b();
            boolean q = a_mmkv.h().q();
            L.e("BAIH", "守护AB:" + Boolean.valueOf(q) + "," + "8版本前老用户:" + Boolean.TRUE);
            if (q) {
                d();
                a_mmkv.h().N(this);
            } else {
                a_mmkv.h().B(this);
            }
        }
    }

    @Override // bfj.ckdk.wazpqdu.cjzk.fcuqxatg.a.b
    public void onChanged() {
        e();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        context = this;
        if (z22.a(this)) {
//            oi.c(this);
            BAHT.l(this);
            MMKV.initialize(this);
//            e11.a.f(this);
//            f11.a.h(this);
//            mi.b();
            af1.a(getApplicationContext());
            d91.c();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                registerActivityLifecycleCallbacks(new gi());
                registerActivityLifecycleCallbacks(new fi());
            }
            new dj(this).b();
            b();
            boolean m = rc.m(this);
            boolean d = bj.d(this);
            int i = (m && d) ? 3 : m ? 2 : d ? 1 : -1;
            if (i != -1) {
//                i4.a().i("push_yes").putEbKey1(Integer.valueOf(i)).commit();
            }
//            wh.c(ni.a().d(), false, null);
//            yh.f(false);
        }
        kj.d(this);
        e();
        c();

        OverseasSupportApp.INSTANCE().onCreate(this);
    }
}
