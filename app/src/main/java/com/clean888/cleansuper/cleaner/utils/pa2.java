package com.clean888.cleansuper.cleaner.utils;


import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

import com.unity3d.player.StringFog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class pa2 extends jm {
    private String p;
    private long q;
    public static String r;

    static {
        pa2.r = StringFog.decrypt("BDAmDC8CXxgmEw==");
    }

    public pa2(Context arg1, a arg2) {
        super(arg1, arg2);
        this.p = StringFog.decrypt("sur4h/T91O3kss/5WEU=");
        this.q = 0L;
    }

    @Override  // jm
    protected void b() {
        super.b();
        if(this.i) {
            Log.d(o, this.p + StringFog.decrypt("stzRhNP/EScPJTYmBiwTDA==") + this.q());
        }
    }

    @Override  // fn
    public Object e(Object[] arg1) {
        return this.w(((Void[])arg1));
    }

    @Override  // fn
    public void i(Object arg1) {
        this.y(((Integer)arg1));
    }

    @Override  // fn
    public void j() {
    }

    @Override  // fn
    public void k(Object[] arg1) {
        this.z(((gm[])arg1));
    }

    @Override  // lm
    protected String n() {
        return pa2.r;
    }

    public Integer w(Void[] arg10) {
        if(this.g()) {
            return this.h;
        }

        if(!this.u()) {
            return this.h;
        }

        if(this.a != null) {
            List v10 = xl2.b();
            if(!v10.isEmpty()) {
                HashSet v10_1 = new HashSet();
                ArrayList v0 = new ArrayList();
                Cursor v1 = null;
                try {
                    v1 = a91.e().f().a(null);
                    while(v1.moveToNext()) {
                        String v2 = v1.getString(0);
                        String v3 = v1.getString(1);
                        String v4 = cr1.d(v3);
                        if(TextUtils.isEmpty(v4)) {
                            continue;
                        }

                        File v5 = new File(v4);
                        if(!v5.exists() || (v10_1.contains(v4))) {
                            continue;
                        }

                        v10_1.add(v4);
                        f81 v4_1 = new f81(v5, 1001);
                        v4_1.f = v2;
                        v4_1.f1783g = v3;
                        v0.add(v4_1);
                    }

                    if(v0.size() > 0) {
                        Collections.sort(v0, (f81 arg0, f81 arg1) -> pa2.x(arg0, arg1));
                        Iterator v10_4 = v0.iterator();
                        while(true) {
                            label_50:
                            if(!v10_4.hasNext()) {
                                break;
                            }

                            Object v0_1 = v10_4.next();
                            f81 v0_2 = (f81)v0_1;
                            if(v0_2.c() <= 0L) {
                                continue;
                            }

//                            this.l(new gm[]{v0_2});
                            this.l(v0_2);
                        }
                    }

//                    goto label_75;
                    if(!v1.isClosed()) {
                        v1.close();
                        return this.f1903g;
                    }
                }
                catch(Exception v10_2) {
                }
                catch(Throwable v10_3) {
//                    goto label_69;
                }


                if(v1 == null || (v1.isClosed())) {
                    return this.f1903g;
                }

                v1.close();
            }
        }

        return this.f1903g;
    }

    private static int x(f81 arg2, f81 arg3) {
        return (int)(arg3.c() - arg2.c());
    }

    public void y(Integer arg6) {
        if(this.g()) {
            return;
        }

        if(this.i) {
            Log.d(o, this.p + mr0.a(this.q, 2));
        }

        if(this.n != null && !this.g()) {
            this.n.d(new b91(this.q, this.m, 1001));
        }
    }

    public void z(gm[] arg5) {
        if(this.g()) {
            return;
        }

        gm v5 = arg5[0];
        if(v5 != null) {
            if(this.m == null) {
                this.m = new ArrayList();
            }

            this.m.add(v5);
            long v2 = v5.c();
            this.q += v2;
            if(this.n != null && !this.g()) {
                this.n.e(v5);
            }
        }
    }
}

