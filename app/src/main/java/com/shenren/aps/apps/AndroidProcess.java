package com.shenren.aps.apps;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.unity3d.player.StringFog;
import java.io.IOException;

/* loaded from: classes6.dex */
public class AndroidProcess implements Parcelable {
    public  final Creator<AndroidProcess> CREATOR = new a();
    public final String a;
    public final int b;

    /* loaded from: classes6.dex */
    class a implements Creator<AndroidProcess> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AndroidProcess createFromParcel(Parcel parcel) {
            return new AndroidProcess(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AndroidProcess[] newArray(int i) {
            return new AndroidProcess[i];
        }
    }

    public AndroidProcess(int i) throws IOException {
        this.b = i;
        this.a = d(i);
    }

    static String d(int i) throws IOException {
        String str;
        try {
            str = ProcFile.a(String.format(StringFog.decrypt("eCM1DQZYFBdIND4jDgwZVA=="), Integer.valueOf(i))).trim();// /proc/%d/cmdline
        } catch (IOException unused) {
            str = null;
        }
        return (TextUtils.isEmpty(str) || StringFog.decrypt("OSYrDg==").equals(str)) ? Stat.b(i).e() : str;
    }

    public Cgroup c() throws IOException {
        return Cgroup.b(this.b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Status e() throws IOException {
        return Status.b(this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
    }

    protected AndroidProcess(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
    }
}
