package com.clean888.cleansuper.cleaner.utils;


import java.util.HashMap;

/* loaded from: classes2.dex */
public class q91 {
    private HashMap<String, String> a;
    private final Object b = new Object();

    public boolean a(String str, String str2) {
        try {
            synchronized (this.b) {
                if (this.a == null) {
                    this.a = new HashMap<>();
                }
                this.a.put(str, str2);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String b(String str) {
        String str2;
        try {
            synchronized (this.b) {
                if (this.a == null) {
                    this.a = new HashMap<>();
                }
                str2 = this.a.get(str);
            }
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
