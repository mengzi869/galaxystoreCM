package com.clean888.cleansuper.cleaner.utils;


import android.content.Context;
import com.unity3d.player.StringFog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class i91 {
    public static HashMap<String, String> a(Context context) {
        String[] list;
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> b = xl2.b();
        if (b != null && b.size() > 0) {
            Iterator<String> it = b.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists() && (list = file.list()) != null && list.length > 0) {
                    for (String str : list) {
                        hashMap.put(StringFog.decrypt("eA==") + str, file + StringFog.decrypt("eA==") + str);
                        String[] list2 = new File(file + StringFog.decrypt("eA==") + str).list();
                        if (list2 != null && list2.length > 0) {
                            for (String str2 : list2) {
                                hashMap.put(StringFog.decrypt("eA==") + str + StringFog.decrypt("eA==") + str2, file + StringFog.decrypt("eA==") + str + StringFog.decrypt("eA==") + str2);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }
}