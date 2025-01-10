package com.shenren.aps.apps;

import com.unity3d.player.StringFog;
import java.io.IOException;

/* loaded from: classes6.dex */
public final class Status extends ProcFile {
    private Status(String str) throws IOException {
        super(str);
    }

    public static Status b(int i) throws IOException {
        return new Status(String.format(StringFog.decrypt("eCM1DQZYFBdIJCcmFhAE"), Integer.valueOf(i)));
    }

    public int e() {
        try {
            return Integer.parseInt(f(StringFog.decrypt("Ajoj")).split(StringFog.decrypt("CyBs"))[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String f(String str) {
        for (String str2 : this.a.split("\n")) {
            if (str2.startsWith(str + StringFog.decrypt("bQ=="))) {
                return str2.split(str + StringFog.decrypt("bQ=="))[1].trim();
            }
        }
        return null;
    }
}
