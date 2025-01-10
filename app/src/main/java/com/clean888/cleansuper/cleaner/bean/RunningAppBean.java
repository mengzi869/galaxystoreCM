package com.clean888.cleansuper.cleaner.bean;



import android.graphics.drawable.Drawable;
import com.unity3d.player.StringFog;
import java.util.Random;

public class RunningAppBean {
    private Drawable appIcon;
    private String appName;
    private String appPackageName;
    private String d;
    private long appMemoryInfo;
    private boolean f;

    private boolean f1769g;

    public RunningAppBean a() {
        RunningAppBean app = new RunningAppBean();
        app.setAppIcon(this.appIcon);
        app.setAppName(this.appName);
        app.setAppPackageName(this.appPackageName);
        app.n(this.d);
        app.getAppMemoryInfo(this.appMemoryInfo);
        app.i(this.f);
        app.k(this.f1769g);
        return app;
    }

    public Drawable getAppIcon() {
        return this.appIcon;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public long getAppMemoryInfo() {
        return this.appMemoryInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RunningAppBean runningBackgrdAppsBeanVar = (RunningAppBean) obj;
        String str = this.appPackageName;
        if (str == null) {
            if (runningBackgrdAppsBeanVar.appPackageName != null) {
                return false;
            }
        } else if (!str.equals(runningBackgrdAppsBeanVar.appPackageName)) {
            return false;
        }
        return true;
    }

    public boolean f() {
        return this.f1769g;
    }

    public void g(float arg5, float arg6) {
        int v5 = ((int)Math.abs(arg5)) * 1000;
        int v6 = ((int)Math.abs(arg6)) * 1000;
        float v5_1 = (v6 <= v5 ? ((float)(new Random().nextInt(v5 - v6 + 1) + v6)) : ((float)(new Random().nextInt(v6 - v5 + 1) + v5))) / 1000.0f;
        long v0 = this.appMemoryInfo;
        if(v0 <= 0L) {
            this.appMemoryInfo = (long)((new Random().nextInt(51) + 30) * 0x100000);
            return;
        }

        this.appMemoryInfo = (long)(((float)v0) * v5_1);
    }

    public void setAppIcon(Drawable drawable) {
        this.appIcon = drawable;
    }

    public void i(boolean z) {
        this.f = z;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void k(boolean z) {
        this.f1769g = z;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    public void getAppMemoryInfo(long j) {
        this.appMemoryInfo = j;
    }

    public void n(String str) {
        this.d = str;
    }

    public String toString() {
//        return StringFog.decrypt("FiM3KwsRXlM8OTIqB1g=") + this.appName + StringFog.decrypt("e3M3AwYcfxIKMm4=") + this.appPackageName + StringFog.decrypt("Cg==");\
        return "RunningAppBean{" +
                ", appName='" + appName + '\'' +
                ", appPackageName='" + appPackageName + '\'' +
                ", d='" + d + '\'' +
                ", appMemoryInfo=" + appMemoryInfo +
                ", f=" + f +
                ", f1769g=" + f1769g +
                '}';
    }
}