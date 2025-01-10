package com.clean888.cleansuper.cleaner.bean;

import java.util.HashSet;

public class dc_packageInfo {
    public int a_uid;
    public int d_versionCode;
    public HashSet<String> i_signatures;
    public boolean j;
    public int k;
    public int l_flags;
    public int m;
    public String n_sourceDir;
    public String b_packageName = "";
    public String c_versionName = "";
    public String e_label = "";
    public String f_formatFileSize = "";

    /* renamed from: g, reason: collision with root package name */
    public long f1759g = 0;
    public long h_lastUpdateTime = 0;

    @Override
    public String toString() {
        return "dc_packageInfo{" +
                "a_uid=" + a_uid +
                ", d_versionCode=" + d_versionCode +
                ", i_signatures=" + i_signatures +
                ", j=" + j +
                ", k=" + k +
                ", l_flags=" + l_flags +
                ", m=" + m +
                ", n_sourceDir='" + n_sourceDir + '\'' +
                ", b_packageName='" + b_packageName + '\'' +
                ", c_versionName='" + c_versionName + '\'' +
                ", e_label='" + e_label + '\'' +
                ", f_formatFileSize='" + f_formatFileSize + '\'' +
                ", f1759g=" + f1759g +
                ", h_lastUpdateTime=" + h_lastUpdateTime +
                '}';
    }
}
