package com.shenren.aps.apps;

import com.unity3d.player.StringFog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AndroidA {

    // 系统中所有正在运行的 Android 应用进程列表
    public static List<AndroidAppProcess> a() {
        ArrayList arrayList = new ArrayList();
        for (File file : new File(StringFog.decrypt("eCM1DQY=")).listFiles()) {// /proc
            if (file.isDirectory()) {
                try {
                    arrayList.add(new AndroidAppProcess(Integer.parseInt(file.getName())));
                } catch (AndroidAppProcess.NotAndroidAppProcessException | IOException | NumberFormatException unused) {
                }
            }
        }
        return arrayList;
    }
}
