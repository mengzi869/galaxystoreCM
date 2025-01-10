package com.shenren.aps.apps;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes6.dex */
public class ProcFile extends File implements Parcelable {
    public  final Creator<ProcFile> CREATOR = new a();
    public final String a;

    /* loaded from: classes6.dex */
    class a implements Creator<ProcFile> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProcFile createFromParcel(Parcel parcel) {
            return new ProcFile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProcFile[] newArray(int i) {
            return new ProcFile[i];
        }
    }

    protected ProcFile(String str) throws IOException {
        super(str);
        this.a = a(str);
    }

    protected static String a(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        sb.append(bufferedReader.readLine());
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append('\n');
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.io.File
    public long length() {
        return this.a.length();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.a);
    }

    protected ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.a = parcel.readString();
    }
}
