package com.clean888.cleansuper.cleaner.bean;

import android.app.PendingIntent;
import android.graphics.Bitmap;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class cc implements Serializable {
    public String appName = "";
    public String packageName = "";
    public CharSequence title = "";
    public CharSequence text = "";
    public Bitmap bitmap;

    /* renamed from: g, reason: collision with root package name */
    public long f112g;
    public PendingIntent pendingIntent;


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(CharSequence title) {
        this.title = title;
    }

    public CharSequence getText() {
        return text;
    }

    public void setText(CharSequence text) {
        this.text = text;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public long getF112g() {
        return f112g;
    }

    public void setF112g(long f112g) {
        this.f112g = f112g;
    }

    public PendingIntent getPendingIntent() {
        return pendingIntent;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    @Override
    public String toString() {
        return "cc{" +
                "appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", title=" + title +
                ", text=" + text +
                ", f112g=" + f112g +
                '}';
    }
}