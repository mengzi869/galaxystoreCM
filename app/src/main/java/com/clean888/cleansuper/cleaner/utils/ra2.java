package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.unity3d.player.StringFog;


/* loaded from: classes2.dex */
public class ra2 extends jm<gm> {
    public static String s = StringFog.decrypt("BDAmDC8CXxgkNjAvBw==");
    private static final Object t = new Object();
    private String p;
    private long q;
    private long r;

    public ra2(Context context, jm.a<gm> aVar) {
        super(context, aVar);
        this.p = StringFog.decrypt("sO/Uh8jv1O3kss/5WEU=");
        this.r = 0L;
    }

    private void A(HashMap<String, String> hashMap) {
        List<Long> a;
        if (hashMap == null || hashMap.isEmpty() || (a = i10.a(hashMap.keySet())) == null || a.isEmpty()) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = a91.e().g().g(a);
                while (cursor.moveToNext() && !g()) {
                    hashMap.put(Long.toString(cursor.getLong(0)), cursor.getString(1));
                }
                if (cursor.isClosed()) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    private void B(MessageDigest messageDigest, HashMap<String, String> hashMap, String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str) || hashMap == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null && file2.exists() && file2.isDirectory()) {
                String str2 = null;
                try {
                    str2 = d91.c().d().get(file2.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = ws.a(messageDigest, file2.getName());
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        d91.c().d().put(file2.getName(), str2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    hashMap.put(str2, file2.getAbsolutePath());
                }
            }
        }
    }

    private List<m81> C() {
        synchronized (t) {
            ArrayList arrayList = new ArrayList();
            try {
                Context context = this.a;
                if (context != null) {
                    PackageManager packageManager = context.getPackageManager();
                    List<PackageInfo> installedPackages = this.a.getPackageManager().getInstalledPackages(0);
                    int size = installedPackages.size();
                    Long l = null;
                    for (int i = 0; i < size; i++) {
                        if (g()) {
                            break;
                        }
                        PackageInfo packageInfo = installedPackages.get(i);
                        m81 m81Var = new m81(null, 1005);
                        try {
                            l = d91.c().e().get(packageInfo.packageName);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (g()) {
                            return null;
                        }
                        if (l != null) {
                            m81Var.s(l.longValue());
                            m81Var.t(packageInfo.packageName);
                            m81Var.p(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                            arrayList.add(m81Var);
                            Log.d(s, "ra2 123" + packageInfo.packageName + " " + m81Var.k());
                        }
                    }
                }
            } catch (Exception unused) {
            }

            Log.d(s, "ra2 arrayList.size(): " + arrayList.size());
            return arrayList;
        }
    }

    private HashMap<String, String> D() {
        HashMap<String, String> hashMap = new HashMap<>();
        MessageDigest d = ws.d();
        List<String> b = xl2.b();
        if (!b.isEmpty()) {
            Iterator<String> it = b.iterator();
            while (it.hasNext()) {
                B(d, hashMap, it.next());
            }
        }
        return hashMap;
    }

    private void E(HashMap<String, String> hashMap, n81 n81Var, String str) {
        try {
            String[] split = str.split(StringFog.decrypt("C3g="));
            if (split.length > 0) {
                n81Var.C(split[0]);
                hashMap.put(split[0], null);
            }
            if (split.length > 1) {
                n81Var.D(split[1]);
                hashMap.put(split[1], null);
            }
            if (split.length > 2) {
                n81Var.B(split[2]);
            }
            if (split.length > 3) {
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < split.length; i++) {
                    sb.append(split[i]);
                }
                n81Var.B(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<m81> v(List<m81> list) {
        PackageManager packageManager;
        boolean z;
        String replace;
        int lastIndexOf;
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        n81 n81Var = null;
        try {
            packageManager = this.a.getPackageManager();
        } catch (Exception e) {
            e.printStackTrace();
            packageManager = null;
        }
        List<String> b = xl2.b();
        if (!b.isEmpty()) {
            for (String str : b) {
                if (g()) {
                    break;
                }
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append(StringFog.decrypt("Fj0jEAoeVQ=="));
                    sb.append(str2);
                    sb.append(StringFog.decrypt("MzIzAw=="));
                    sb.append(str2);
                    String sb2 = sb.toString();
                    if (new File(sb2).exists()) {
                        Iterator<m81> it = list.iterator();
                        while (it.hasNext() && !g()) {
                            m81 next = it.next();
                            File file = new File(sb2 + next.o() + File.separator);
                            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                                z = false;
                            } else {
                                int length = listFiles.length;
                                int i = 0;
                                z = false;
                                while (i < length) {
                                    File file2 = listFiles[i];
                                    String name = file2.getName();
                                    String lowerCase = name.substring(name.lastIndexOf(StringFog.decrypt("eQ==")) + 1, name.length()).toLowerCase();
                                    if (!lowerCase.contains(StringFog.decrypt("Iz43")) && !lowerCase.contains(StringFog.decrypt("IzYqEg==")) && !lowerCase.contains(StringFog.decrypt("Ozwg"))) {
                                        lowerCase.contains(StringFog.decrypt("NDIkCgA="));
                                    }
                                    n81 n81Var2 = new n81(file2, 1005);
                                    next.m().add(n81Var2);
                                    i++;
                                    n81Var = n81Var2;
                                    z = true;
                                }
                            }
                            if (z) {
                                try {
                                    if (TextUtils.isEmpty(n81Var.o()) && (lastIndexOf = (replace = n81Var.b().replace(sb2, "")).lastIndexOf(File.separator)) > 0) {
                                        n81Var.t(replace.substring(0, lastIndexOf));
                                    }
                                    if (packageManager != null) {
                                        n81Var.p(packageManager.getApplicationInfo(n81Var.o(), 0).loadLabel(packageManager).toString());
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    Log.d(s,"ra2 239" + e2.getMessage());
                                }
                                arrayList.add(n81Var);
                            }
                        }
                    }
                }
            }
        }
        Log.d(s,"ra2 arrayList.size(): " + arrayList.size());
        return arrayList;
    }

    private List<m81> x(List<m81> list, List<m81> list2, HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2;
        long j;
        HashMap<String, String> hashMap3;
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null && !list.isEmpty()) {
            HashMap<String, String> D = D();
            if (this.i) {
                p(this.p, currentTimeMillis, StringFog.decrypt("MDYzMQEnUAcPETo1EREzWAEqMx4mEg=="));
            }
            int i = 0;
            while (i < list.size()) {
                if (g()) {
                    return null;
                }
                m81 m81Var = list.get(i);
                List<n81> m = m81Var.m();
                if (m == null || m.isEmpty()) {
                    hashMap2 = D;
                    j = 0;
                } else {
                    j = 0;
                    for (n81 n81Var : m) {
                        String v = n81Var.v();
                        String w = n81Var.w();
                        String u = n81Var.u();
                        boolean z = n81Var.z();
                        int x = n81Var.x();
                        if (!TextUtils.isEmpty(v)) {
                            String str = hashMap.get(v);
                            if (!TextUtils.isEmpty(str) && D.containsKey(str)) {
                                String str2 = D.get(str);
                                hashMap3 = D;
                                if (!TextUtils.isEmpty(w) && !TextUtils.isEmpty(str2)) {
                                    HashMap<String, String> hashMap4 = new HashMap<>();
                                    B(ws.d(), hashMap4, str2);
                                    String str3 = hashMap.get(w);
                                    if (!TextUtils.isEmpty(str3) && hashMap4.containsKey(str3)) {
                                        String str4 = hashMap4.get(str3);
                                        if (!TextUtils.isEmpty(u) && !TextUtils.isEmpty(str4)) {
                                            try {
                                                String str5 = str4 + File.separator + u;
                                                if (!z) {
                                                    File file = new File(str5);
                                                    if (file.exists()) {
                                                        if (x != 1 && x != 2 && x != 5 && x != 6) {
                                                            try {
                                                                n81Var.f(file.length());
                                                                n81Var.e(str5);
                                                            } catch (Exception e) {
                                                                e.printStackTrace();
                                                            }
                                                        } else {
                                                            long d = mr0.d(file);
                                                            n81Var.e(str5);
                                                            n81Var.f(d);
                                                        }
                                                    }
                                                } else {
                                                    h81.a(n81Var, str5);
                                                }
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                } else if (!z) {
                                    File file2 = new File(str2);
                                    if (file2.exists()) {
                                        if (x != 1 && x != 2 && x != 5 && x != 6) {
                                            try {
                                                n81Var.f(file2.length());
                                                n81Var.e(str2);
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                        } else {
                                            long d2 = mr0.d(file2);
                                            n81Var.e(str2);
                                            n81Var.f(d2);
                                        }
                                    }
                                } else {
                                    h81.a(n81Var, str2);
                                }
                                j += n81Var.c();
                                D = hashMap3;
                            }
                        }
                        hashMap3 = D;
                        j += n81Var.c();
                        D = hashMap3;
                    }
                    hashMap2 = D;
                }
                m81Var.f(j);
                if (j <= 0) {
                    m81Var.m().clear();
                    list2.add(m81Var);
                }
                i++;
                D = hashMap2;
            }
        }

        Log.d(s,"ra2 list.size(): " + list.size());

        return list;
    }

    private List<m81> y(List<m81> arg11, List<m81> arg12) {
        /*int i = 0;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            while (i < list.size()) {
                m81 m81Var = list.get(i);
                Cursor cursor = null;
                if (g()) {
                    return null;
                }
                try {
                    try {
                        cursor = a91.e().g().d(Long.valueOf(m81Var.n()));
                        if (cursor.moveToNext()) {
                            long j = cursor.getLong(1);
                            String string = cursor.getString(2);
                            if (j != 0 && j != -1) {
                                if (string.split(StringFog.decrypt("ew==")).length > 0) {
                                    m81Var.q(string);
                                    arrayList.add(m81Var);
                                }
                            }
                            list2.add(m81Var);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d(s, "ra2 " + e.getMessage());
                        if (cursor != null) {
                            if (!cursor.isClosed()) {
                                cursor.close();
                            }
                        }
                    }
                    i = cursor.isClosed() ? i + 1 : 0;
                    cursor.close();
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
        return arrayList;*/

        ArrayList v0 = new ArrayList();
        if(arg11 != null && arg11.size() > 0) {
            int v1;
            for(v1 = 0; v1 < arg11.size(); ++v1) {
                m81 v2 = (m81)arg11.get(v1);
                Cursor v4 = null;
                if(this.g()) {
                    return null;
                }

                try {
                    v4 = a91.e().g().d(Long.valueOf(v2.n()));
                    if(v4.moveToNext()) {
                        long v5 = v4.getLong(1);
                        String v3 = v4.getString(2);
                        if(v5 == 0L || v5 == -1L) {
                            arg12.add(v2);
                        }
                        else if(v3.split(StringFog.decrypt("ew==")).length > 0) {
                            v2.q(v3);
                            v0.add(v2);
                        }
                    }
                }
                catch(Exception v2_1) {
                    v2_1.printStackTrace();
                }
                finally {
                    if(v4 != null && !v4.isClosed()) {
                        v4.close();
                    }
                }
            }
        }

        return v0;
    }

    private List<m81> z(List<m81> list, HashMap<String, String> hashMap) {
        int i = 0;
        String string = "";
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                Cursor cursor = null;
                if (g()) {
                    return null;
                }
                m81 m81Var = list.get(i3);
                ArrayList arrayList3 = new ArrayList();
                arrayList2.clear();
                if (m81Var != null) {
                    String l = m81Var.l();
                    if (!TextUtils.isEmpty(l)) {
                        for (String str : l.split(StringFog.decrypt("ew=="))) {
                            try {
                                arrayList2.add(Long.valueOf(Long.parseLong(str.trim())));
                            } catch (NumberFormatException e) {
                                Log.d(s,e.getMessage());
                            }
                        }
                        try {
                            try {
                                Cursor c = a91.e().g().c(arrayList2);
                                while (c.moveToNext()) {
                                    try {
                                        try {
                                            i = c.getInt(i2);
                                            string = c.getString(1);
                                        } catch (Exception e2) {
                                            Log.d(s, e2.getMessage());
//                                            e = e2;
                                        }
                                        try {
                                            n81 n81Var = new n81(null, 1005);
                                            n81Var.E(i);
                                            if (string.contains(StringFog.decrypt("eHw="))) {
                                                try {
                                                    String[] split = string.split(StringFog.decrypt("eHw="));
                                                    if (split.length == 2) {
                                                        n81Var.A(true);
                                                        E(hashMap, n81Var, split[0]);
                                                        n81Var.F(split[1]);
                                                    }
                                                    i2 = 0;
                                                } catch (Exception e3) {
//                                                    e = e3;
                                                    cursor = c;
                                                    i2 = 0;
//                                                    e.printStackTrace();
                                                    if (cursor != null && !cursor.isClosed()) {
                                                        cursor.close();
                                                    }
                                                    m81Var.r(arrayList3);
                                                    arrayList.add(m81Var);
                                                    Log.d(s,e3.getMessage());
                                                }
                                            } else {
                                                i2 = 0;
                                                n81Var.A(false);
                                                E(hashMap, n81Var, string);
                                            }
                                            arrayList3.add(n81Var);
                                        } catch (Exception e4) {
//                                            e = e4;
                                            i2 = 0;
                                            cursor = c;
                                            e4.printStackTrace();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            m81Var.r(arrayList3);
                                            arrayList.add(m81Var);
                                            Log.d(s,e4.getMessage());
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = c;
                                        if (cursor != null && !cursor.isClosed()) {
                                            cursor.close();
                                        }
                                        Log.d(s,th.getMessage());
                                        throw th;
                                    }
                                }
                                if (!c.isClosed()) {
                                    c.close();
                                }
                            } catch (Throwable th2) {
                                Log.d(s,th2.getMessage());
//                                th = th2;
                            }
                        } catch (Exception e5) {
//                            e = e5;
                            Log.d(s,e5.getMessage());
                        }
                        m81Var.r(arrayList3);
                        arrayList.add(m81Var);
                    }
                }
            }
        }

        Log.d(s, "515 arrayList.size() " + arrayList.size());
        return arrayList;
    }

    @Override // defpackage.fn
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void i(Integer num) {
        Log.d(s,"i(Integer num): begin " + num.toString());
        if (this.i) {
            p(this.p, this.q, StringFog.decrypt("OD0XDRYDdAsCNCYzB18xWB0OJDsGDgkjWB4C"));
        }
        if (g()) {
            return;
        }
        if (this.i) {
            Log.d(jm.o, this.p + mr0.a((float) this.r, 2));
            Log.d(s,this.p + mr0.a((float) this.r, 2));
        }
        if (this.n == null || g()) {
            return;
        }
        Log.d(s,"i(Integer num): end " + num.toString());
        this.n.d(new b91(this.r, this.m, 1005));
    }

    @Override // defpackage.fn
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void k(gm... gmVarArr) {
        gm gmVar;
        if (g() || (gmVar = gmVarArr[0]) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList();
        }
        if (gmVar.c() > 0) {
            this.m.add(gmVar);
            this.r += gmVar.c();
            if (this.n == null || g()) {
                return;
            }
            this.n.e(gmVar);
        }
    }

    @Override // defpackage.jm, defpackage.fn
    protected void b() {
        super.b();
        if (this.i) {
            Log.d(jm.o, this.p + StringFog.decrypt("stzRhNP/EScPJTYmBiwTDA==") + q());
        }
    }

    @Override // defpackage.fn
    public void j() {
        this.q = System.currentTimeMillis();
    }

    @Override // defpackage.lm
    protected String n() {
        return s;
    }

    @Override // defpackage.fn
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Integer e(Void... voidArr) {
        if (g()) {
            return this.h;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!u()) {
            return this.h;
        }
        if (this.i) {
            currentTimeMillis = p(this.p, currentTimeMillis, StringFog.decrypt("FDsiAQ4nVAEKPiA0CwoZ"));
        }
        List<m81> C = C();
        if (this.i) {
            currentTimeMillis = p(this.p, currentTimeMillis, StringFog.decrypt("MDYzKwsERRILOzYjMg4QfBdS"));
        }
        if (C != null && !C.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            if (g()) {
                return this.h;
            }
            List<m81> y = y(C, arrayList);
            if (this.i) {
                currentTimeMillis = p(this.p, currentTimeMillis, StringFog.decrypt("MTopBikeXxgCMxcmFgQ="));
            }
            if (g()) {
                return this.h;
            }
            if (y != null && !y.isEmpty()) {
                HashMap<String, String> hashMap = new HashMap<>();
                List<m81> z = z(y, hashMap);
                if (g()) {
                    return this.h;
                }
                if (this.i) {
                    currentTimeMillis = p(this.p, currentTimeMillis, StringFog.decrypt("MTopBjUWRRsuMw=="));
                }
                if (g()) {
                    return this.h;
                }
                A(hashMap);
                if (g()) {
                    return this.h;
                }
                if (this.i) {
                    currentTimeMillis = p(this.p, currentTimeMillis, StringFog.decrypt("MTopBjUWRRsuOTUo"));
                }
                List<m81> x = x(z, arrayList, hashMap);
                if (g()) {
                    return this.h;
                }
                if (this.i) {
                    currentTimeMillis = p(this.p, currentTimeMillis, StringFog.decrypt("MTopBiQbXTALMjIpMgQDWQ=="));
                }
                if (g()) {
                    return this.h;
                }
                long j = 0;
                if (x != null) {
                    try {
                        this.a.getPackageManager();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (m81 m81Var : x) {
                        if (g()) {
                            return this.h;
                        }
                        if (this.i) {
                            String str = jm.o + StringFog.decrypt("HiciDw==");
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.p);
                            sb.append(m81Var.c() > j ? StringFog.decrypt("d213hf/zEQ==") : "");
                            sb.append(StringFog.decrypt("st/+i+D6cCM3d7bL54DnvE4="));
                            sb.append(m81Var.o());
                            sb.append(StringFog.decrypt("dy9n"));
                            sb.append(mr0.a((float) m81Var.c(), 2));
                            sb.append(StringFog.decrypt("dy9nh8jn2cTIv+Toh9vz1+bXag=="));
                            sb.append(m81Var.m() != null ? m81Var.m().size() : 0);
                            Log.d(str, sb.toString());
                        }
                        l(m81Var);
                        j = 0;
                    }
                }
                if (this.i) {
                    currentTimeMillis = p(this.p, currentTimeMillis, StringFog.decrypt("JzggIQQUWRYrPiAz"));
                }
                List<m81> v = v(arrayList);
                if (g()) {
                    return this.h;
                }
                if (this.i) {
                    p(this.p, currentTimeMillis, StringFog.decrypt("JDopBQkSchIEPzYLCxYD"));
                }
                for (m81 m81Var2 : v) {
                    if (g()) {
                        return this.h;
                    }
                    if (this.i && m81Var2.c() > 0) {
                        String str2 = jm.o + StringFog.decrypt("HiciDw==");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.p);
                        sb2.append(m81Var2.c() > 0 ? StringFog.decrypt("d213hf/zEQ==") : "");
                        sb2.append(StringFog.decrypt("st/+i+D6dRITNrT78YDaqVOC29ai8uhK"));
                        sb2.append(m81Var2.o());
                        sb2.append(StringFog.decrypt("dy9n"));
                        sb2.append(mr0.a((float) m81Var2.c(), 2));
                        sb2.append(StringFog.decrypt("dy9n"));
                        sb2.append(m81Var2.b());
                        Log.d(str2, sb2.toString());
                    }
                    l(m81Var2);
                }
            }
        }
        return this.f1903g;
    }
}
