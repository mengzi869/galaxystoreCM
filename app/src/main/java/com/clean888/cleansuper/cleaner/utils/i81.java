package com.clean888.cleansuper.cleaner.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
//import com.unity3d.player.StringFog;

import java.io.File;

public class i81 extends gm {
    public int f;

    public i81(@Nullable File file, int i) {
        super(file, i);
    }

// 101 音乐 NDc=
// 102 图片 gif jpg jpeg png bmp
// 103 视频   rm,3gp
// 104 文档; psd pdf txt doc xls ppt rm
// 105 apk
// 106 压缩包 zip,rar,gz

    public void k() {
        String str = this.a;
        String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
        if (TextUtils.isEmpty(lowerCase)) {
            this.f = 0;
            return;
        }
        this.f = 0;
        if ("apk".equalsIgnoreCase(lowerCase)) {
            this.f = 105;
            return;
        }
        if (!StringFog.decrypt("JyAj").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Jzch").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Iysz").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Mzwk").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("MzwkGg==").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Lz80").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Lz80Gg==").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("JyMz").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("JyMzGg==").equalsIgnoreCase(lowerCase)) {
            if (!StringFog.decrypt("JT4=").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("ZDQ3").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("NiUu").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("OiNz").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Ojwx").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("JT4xAA==").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("OiMg").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("JCQh").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Ojgx").equalsIgnoreCase(lowerCase)) {
                if (!StringFog.decrypt("NDc=").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("NiMi").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("OiN0").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("IDIx").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("ID4m").equalsIgnoreCase(lowerCase)) {
                    if (!StringFog.decrypt("MDoh").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("PSMg").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("PSMiBQ==").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("Jz0g").equalsIgnoreCase(lowerCase) && !StringFog.decrypt("NT43").equalsIgnoreCase(lowerCase)) {
                        if (StringFog.decrypt("LTo3").equalsIgnoreCase(lowerCase) || StringFog.decrypt("JTI1").equalsIgnoreCase(lowerCase) || StringFog.decrypt("MCk=").equalsIgnoreCase(lowerCase)) {
                            this.f = 106;
                            return;
                        }
                        return;
                    }
                    this.f = 102;
                    return;
                }
                this.f = 101;
                return;
            }
            this.f = 103;
            return;
        }
        this.f = 104;
    }
}