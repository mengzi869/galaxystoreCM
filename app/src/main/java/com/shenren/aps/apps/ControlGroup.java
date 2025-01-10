package com.shenren.aps.apps;

import android.os.Parcel;
import android.os.Parcelable;
import com.unity3d.player.StringFog;

/* loaded from: classes6.dex */
public class ControlGroup implements Parcelable {
    public final Creator<ControlGroup> CREATOR = new a();
    public final int a;
    public final String b;
    public final String c;


    /* loaded from: classes6.dex */
    class a implements Creator<ControlGroup> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlGroup createFromParcel(Parcel parcel) {
            return new ControlGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ControlGroup[] newArray(int i) {
            return new ControlGroup[i];
        }
    }

    protected ControlGroup(String str) throws NumberFormatException, IndexOutOfBoundsException {
        String[] split = str.split(StringFog.decrypt("bQ=="));
        this.a = Integer.parseInt(split[0]);
        this.b = split[1];
        this.c = split[2];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    protected ControlGroup(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
