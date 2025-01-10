package com.clean888.cleansuper.cleaner.utils;


import android.text.TextUtils;
import com.unity3d.player.StringFog;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class h81 {
    public static boolean a(n81 arg22, String arg23) {
        long v12_3 = 0;
        long v20_1;
        long v20;
        File v13_1 = null;
        String v5 = "";
        long v12_1;
        String v0_5;
        long v15;
        ArrayList v3 = new ArrayList();
        File v0 = new File(arg23);
        if(v0.exists()) {
            File[] v0_1 = v0.listFiles();
            if(v0_1 != null && v0_1.length > 0) {
                int v6;
                for(v6 = 0; v6 < v0_1.length; ++v6) {
                    File v7 = v0_1[v6];
                    if((v7.exists()) && (v7.isDirectory())) {
                        v3.add(v7.getName());
                    }
                }
            }
        }

        String v0_2 = arg22.y();
        String[] v6_1 = v0_2.split(StringFog.decrypt("eA=="));
        String v7_1 = "";
        if(v6_1.length == 1) {
            int v8 = 0;
            v15 = 0L;
            while(true) {
                if(v8 >= v3.size()) {
                    v12_3 = v15;
                    break;
                }

                String v0_3 = (String)v3.get(v8);
                if(Pattern.matches(v6_1[0], v0_3)) {
                    try {
                        v0_5 = arg23 + StringFog.decrypt("eA==") + v0_3;
                        File v12 = new File(v0_5);
                        if(v12.exists()) {
                            int v13 = arg22.x();
                            if(v13 != 1 && v13 != 2 && v13 != 5 && v13 != 6) {
                                v15 += v12.length();
                                v7_1 = v0_5;
                            }

                            if((v12.isDirectory()) && v12.list() != null && v12.list().length > 0) {
                                v12_1 = mr0.d(v12);
                            }
                            else if(v12.isFile()) {
                                v12_1 = v12.length();
                            }
                            else {
                                v12_1 = 0L;
                            }
                            if(v12_1 != 0L) {
                                v15 += v12_1;
                            }
                            v7_1 = v0_5;
                        }
                    }
                    catch(Exception v0_4) {
                        v0_4.printStackTrace();
                    }
                }
                ++v8;
            }
        }
        else {
            if(v6_1.length > 1) {
                String v8_1 = v0_2.substring(v0_2.indexOf(StringFog.decrypt("eA==")), v0_2.length());
                v15 = 0L;
                int v12_2 = 0;
                while(v12_2 < v3.size()) {
                    String v0_6 = (String)v3.get(v12_2);
                    if(Pattern.matches(v6_1[0], v0_6)) {
                        try {
                            v5 = arg23 + StringFog.decrypt("eA==") + v0_6 + v8_1;
                            v13_1 = new File(v5);
                            if(v13_1.exists()) {
                                int v0_8 = arg22.x();
                                if(v0_8 != 1 && v0_8 != 2 && v0_8 != 5 && v0_8 != 6) {
                                    v20 = v13_1.length();
                                    v15 += v20;
                                    v7_1 = v5;
                                }
                            }
                        }
                        catch(Exception v0_7) {

                        }
                        if((v13_1.isDirectory()) && v13_1.list() != null && v13_1.list().length > 0) {
                            v20_1 = mr0.d(v13_1);
                        }
                        else if(v13_1.isFile()) {
                            v20_1 = v13_1.length();
                        }
                        else {
                            v20_1 = 0L;
                        }
                        v15 += v20_1;
                        ++v12_2;
                        v7_1 = v5;
                    }
                    ++v12_2;
                    continue;
                }
            }else{
                v12_3 = 0L;
            }
        }

        if(TextUtils.isEmpty(v7_1)) {
            return false;
        }
        arg22.f(v12_3);
        arg22.e(v7_1);
        return true;
    }
}