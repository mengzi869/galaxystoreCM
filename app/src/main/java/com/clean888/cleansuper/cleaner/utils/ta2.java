package com.clean888.cleansuper.cleaner.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

import com.unity3d.player.StringFog;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class ta2 extends jm<gm> {
    public static String r = StringFog.decrypt("BDAmDC8CXxg1MiAuBhAWXQ==");
    private String p;
    private long q;

    public ta2(Context context, jm.a<gm> aVar) {
        super(context, aVar);
        this.p = StringFog.decrypt("st7/itjK193ssMbeWEU=");
        this.q = 0L;
    }


    @Override
    protected String n() {
        return r;
    }

    @Override
    public Integer e(Void... paramsArr) {

        Cursor v4 = null;
        if(this.g()) {
            return this.h;
        }

        if(!this.u()) {
            return this.h;
        }

        if(this.a != null) {
            List v12 = this.w();
            ArrayList v0 = new ArrayList();
            HashMap v1 = i91.a(this.a);
            if(v1 != null && v1.size() > 0) {
                try {
                    v4 = a91.e().h().f(i10.b(v1.keySet()));
                    while(v4.moveToNext()) {
                        j91 v5 = new j91(null, 1004);
                        v5.f = v4.getString(1);
                        v5.f1869g = v4.getString(2);
                        v5.h = v4.getString(3);
                        v0.add(v5);
                    }
                }
                catch(Exception v3) {
                    v3.printStackTrace();
                }
                finally {
                    if(!v4.isClosed()) {
                        v4.close();
                    }
                }
            }

            if(v0.size() > 0 && v12 != null && v12.size() > 0) {
                HashSet v3_1 = new HashSet();
                Iterator v4_1 = v0.iterator();
                while(true) {
                    label_81:
                    if(!v4_1.hasNext()) {
                        break;
                    }

                    Object v5_1 = v4_1.next();
                    j91 v5_2 = (j91)v5_1;
                    try {
                        int v6 = 0;
                        String[] v7 = v5_2.h.split(StringFog.decrypt("ew=="));
                        while(true) {
                            label_91:
                            if(v6 >= v7.length) {
                                break ;
                            }

                            if(!v12.contains(v7[v6])) {
                                break;
                            }

                            v3_1.add(v5_2.f);
                            v6++;
                        }
                    }
                    catch(Exception v5_3) {
                        v5_3.printStackTrace();
                    }
                }

                HashSet v12_2 = new HashSet();
                for(Object v4_2: v0) {
                    j91 v4_3 = (j91)v4_2;
                    if((v3_1.contains(v4_3.f)) || (v12_2.contains(v4_3.f)) || (TextUtils.isEmpty(v4_3.f))) {
                        continue;
                    }

                    try {
                        v12_2.add(v4_3.f);
                        String v5_4 = (String)v1.get(v4_3.f);
                        if(TextUtils.isEmpty(v5_4)) {
                            continue;
                        }

                        v4_3.f = v5_4;
                        File v5_5 = new File(v4_3.f);
                        if(v5_5.exists()) {
                            v4_3.g(v5_5);
                        }

                        this.l(new gm[]{v4_3});
                    }
                    catch(Exception v4_4) {
                        v4_4.printStackTrace();
                    }
                }
            }
        }

        return this.f1903g;
//        return ;
    }

    @Override
    public void i(Integer integer) {
        if (g()) {
            return;
        }
        if (this.i) {
            Log.d(jm.o, this.p + mr0.a((float) this.q, 2));
        }
        if (this.n == null || g()) {
            return;
        }
        this.n.d(new b91(this.q, this.m, 1004));
    }

    @Override
    public void k(gm... progressArr) {
        gm gmVar;
        if (g() || (gmVar = progressArr[0]) == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(gmVar);
        this.q += gmVar.c();
        if (this.n == null || g()) {
            return;
        }
        this.n.e(gmVar);
    }

    private List<String> w(){
        ArrayList v0 = new ArrayList();
        try {
            Context v2_1 = this.a;
            if(v2_1 != null) {
                List v2_2 = v2_1.getPackageManager().getInstalledPackages(0);
                int v3;
                for(v3 = 0; true; ++v3) {
                    label_8:
                    if(v3 >= v2_2.size()) {
                        break;
                    }

                    v0.add(((PackageInfo)v2_2.get(v3)).packageName);
                }
            }
        }
        catch(Exception v2) {
            v2.printStackTrace();
        }


        ArrayList v2_3 = new ArrayList();
        Cursor v3_1 = null;
        try {
            v3_1 = a91.e().h().a(v0);
            while(v3_1.moveToNext()) {
                v2_3.add("" + v3_1.getInt(0));
            }
        }
        catch(Exception v0_2) {
            v0_2.printStackTrace();
            return v2_3;
        }
        finally {
            if(v3_1 != null && !v3_1.isClosed()) {
                v3_1.close();
            }
        }

        return v2_3;
    }
}