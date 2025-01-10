package com.shenren.aps.apps;

import android.os.Parcel;
import android.os.Parcelable;
import com.unity3d.player.StringFog;
import java.io.IOException;

/* loaded from: classes6.dex */
public final class Stat extends ProcFile {
    public final Creator<Stat> CREATOR = new a();
    private final String[] b;

    /* loaded from: classes6.dex */
    class a implements Creator<Stat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Stat createFromParcel(Parcel parcel) {
            return new Stat(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Stat[] newArray(int i) {
            return new Stat[i];
        }
    }

    /* synthetic */
    Stat(Parcel parcel, Boolean aVar) {
        this(parcel);
    }

    public static Stat b(int i) throws IOException {
        return new Stat(String.format(StringFog.decrypt("eCM1DQZYFBdIJCcmFg=="), Integer.valueOf(i)));
    }

    @Override // com.shenren.aps.apps.ProcFile, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.b[1].replace(StringFog.decrypt("fw=="), "").replace(StringFog.decrypt("fg=="), "");
    }

    @Override // com.shenren.aps.apps.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringArray(this.b);
    }

    private Stat(String str) throws IOException {
        super(str);
        this.b = this.a.split(StringFog.decrypt("CyBs"));
    }

    private Stat(Parcel parcel) {
        super(parcel);
        this.b = parcel.createStringArray();
    }
}
