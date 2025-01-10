package com.clean888.cleansuper.cleaner.utils;

import android.text.TextUtils;

import com.clean888.cleansuper.cleaner.utils.AboutMe.ServerTimeListener;
import com.tencent.mmkv.MMKV;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class a_mmkv {
    static a_mmkv d;
    private sf b = sf.a();
    private ArrayList<b> c = new ArrayList<>();
    private MMKV a = MMKV.mmkvWithID("app_settings");

    class ServerTimeHandler implements ServerTimeListener {
        ServerTimeHandler() {
        }

        @Override
        public void onServerTimeReceived(long j) {
        }

        @Override
        public void onProcessComplete() {
            sf a = sf.a();
            a.b();
            a_mmkv.this.b = a;
            a_mmkv.this.A();
//            oj.a().b();
            a_mmkv.this.z();
        }
    }


    public interface b {
        void onChanged();
    }

    private a_mmkv() {
//        n.a.f(new ServerTimeHandler());
        new ServerTimeHandler().onProcessComplete();
    }

    public void A() {
        if (!this.a.encode("is_notification" + x(), false)) {
            H(this.b.a);
        }
        if (!this.a.encode("is_auto_boost" + x(), false)) {
            D(this.b.b);
        }
        if (!this.a.encode("is_shake_boost" + x(), false)) {
            I(this.b.c);
        }
        if (!this.a.encode("is_uninstall_clean" + x(), false)) {
            M(this.b.d);
        }
        if (!this.a.encode("is_install_scan" + x(), false)) {
            G(this.b.e);
        }
        if (this.a.encode("is_battery_clean" + x(), false)) {
            return;
        }
        G(this.b.f);
    }

    private Set<String> f() {
        return new HashSet();
    }

    public static a_mmkv h() {
        if (d == null) {
            d = new a_mmkv();
        }
        return d;
    }

    private String x() {
        return "setting";
    }

    private String y() {
//        if (!p3.a.m()) {
//            return "";
//        }
        return Calendar.getInstance().get(6) + "";
    }

    public void B(b bVar) {
        if (this.c.contains(bVar)) {
            return;
        }
        this.c.add(bVar);
    }

    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Set<String> g2 = g(new HashSet());
        if (g2.contains(str)) {
            HashSet hashSet = new HashSet(g2);
            hashSet.remove(str);
            this.a.encode("key_disable_clean_package", hashSet);
        }
    }

    public void D(boolean z) {
        this.a.encode("is_auto_boost" + x(), true);
        if (z == this.a.decodeBool("is_auto_boost" + y(), this.b.b)) {
            return;
        }
        this.a.encode("is_auto_boost" + y(), z);
        z();
    }

    public void E(boolean z) {
        this.a.encode("is_battery_clean" + x(), true);
        if (z == this.a.decodeBool("is_battery_clean" + y(), this.b.f)) {
            return;
        }
        this.a.encode("is_battery_clean" + y(), z);
        z();
    }

    public void F(boolean z) {
        this.a.encode("key_enable_clean_notification", z);
    }

    public void G(boolean z) {
        this.a.encode("is_install_scan" + x(), true);
        if (z == this.a.decodeBool("is_install_scan" + y(), this.b.e)) {
            return;
        }
        this.a.encode("is_install_scan" + y(), z);
        z();
    }

    public void H(boolean z) {
        this.a.encode("is_notification" + x(), true);
        if (z == this.a.decodeBool("is_notification" + y(), this.b.a)) {
            return;
        }
        this.a.encode("is_notification" + y(), z);
        z();
    }

    public void I(boolean z) {
        this.a.encode("is_shake_boost" + x(), true);
        if (z == this.a.decodeBool("is_shake_boost" + y(), this.b.c)) {
            return;
        }
        this.a.encode("is_shake_boost" + y(), z);
        z();
    }

    public void J() {
        if (2 == this.a.decodeInt("shake_sensitivity" + y(), 0)) {
            return;
        }
        this.a.encode("shake_sensitivity" + y(), 2);
        z();
    }

    public void K() {
        if (1 == this.a.decodeInt("shake_sensitivity" + y(), 0)) {
            return;
        }
        this.a.encode("shake_sensitivity" + y(), 1);
        z();
    }

    public void L() {
        if (this.a.decodeInt("shake_sensitivity" + y(), 0) == 0) {
            return;
        }
        this.a.encode("shake_sensitivity" + y(), 0);
        z();
    }

    public void M(boolean z) {
        this.a.encode("is_uninstall_clean" + x(), true);
        if (z == this.a.decodeBool("is_uninstall_clean" + y(), this.b.d)) {
            return;
        }
        this.a.encode("is_uninstall_clean" + y(), z);
        z();
    }

    public void N(b bVar) {
        this.c.remove(bVar);
    }

    public void c(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        HashSet hashSet = new HashSet(g(new HashSet()));
        boolean z = false;
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && hashSet.add(str)) {
                z = true;
            }
        }
        if (z) {
            this.a.encode("key_disable_clean_package", hashSet);
        }
    }

    public void d(long j) {
        if (j > 0) {
            this.a.encode("key_notify_clean_count", i() + j);
        }
    }

    public Set<String> e() {
        Set<String> g2 = g(null);
        if (g2 != null) {
            return g2;
        }
        Set<String> f = f();
        c((String[]) f.toArray(new String[0]));
        return f;
    }

    public Set<String> g(Set<String> set) {
        return this.a.decodeStringSet("key_disable_clean_package", set);
    }

    public long i() {
        return this.a.decodeLong("key_notify_clean_count", 0L);
    }

    public boolean j() {
        return this.a.decodeBool("is_auto_boost" + y(), this.b.b);
    }

    public boolean k() {
        return this.a.decodeBool("is_battery_clean" + y(), this.b.f);
    }

    public boolean l() {
        return this.a.decodeBool("key_enable_clean_notification", true);
    }

    public boolean m() {
        return this.b.l;
    }

    public boolean n() {
        return this.a.decodeBool("is_install_scan" + y(), this.b.e);
    }

    public boolean o() {
        return this.b.m;
    }

    public boolean p() {
        return this.a.decodeBool("is_notification" + y(), this.b.a);
    }

    public boolean q() {
        return this.b.i;
    }

    public boolean r() {
        return this.a.decodeBool("is_shake_boost" + y(), this.b.c);
    }

    public boolean s() {
        MMKV mmkv = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("shake_sensitivity");
        sb.append(y());
        return mmkv.decodeInt(sb.toString(), 0) == 2;
    }

    public boolean t() {
        MMKV mmkv = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("shake_sensitivity");
        sb.append(y());
        return mmkv.decodeInt(sb.toString(), 0) == 1;
    }

    public boolean u() {
        MMKV mmkv = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("shake_sensitivity");
        sb.append(y());
        return mmkv.decodeInt(sb.toString(), 0) == 0;
    }

    public boolean v() {
        return this.a.decodeBool("is_uninstall_clean" + y(), this.b.d);
    }

    public boolean w() {
        return this.b.f2044g;
    }

    public void z() {
        for (b bVar : (b[]) this.c.toArray(new b[0])) {
            bVar.onChanged();
        }
    }
}