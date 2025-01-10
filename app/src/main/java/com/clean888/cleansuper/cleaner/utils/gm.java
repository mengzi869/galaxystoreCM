package com.clean888.cleansuper.cleaner.utils;

import androidx.annotation.Nullable;
//import com.unity3d.player.StringFog;

import java.io.File;
//import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class gm extends rz1 {
    public int d;
    private boolean e;

    public gm(@Nullable File file, int i) {
        super(file);
        this.e = true;
        this.d = i;
    }

    public boolean h() {
        return ar0.c(b());
    }

    public boolean i() {
        return this.e;
    }

    public void j(boolean z) {
        this.e = z;
    }

/*    public String toString() {
        return StringFog.decrypt("FTI0By8CXxgcJzIzClhQ") + this.b + '\'' + StringFog.decrypt("e3MpAwgSDFQ=") + this.a + '\'' + StringFog.decrypt("e3M0Cx8SDA==") + this.c + AbstractJsonLexerKt.END_OBJ;
    }*/
}
