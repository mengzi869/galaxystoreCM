package com.shenren.aps.apps;

import android.os.Parcel;
import android.os.Parcelable;
import com.unity3d.player.StringFog;
import java.io.IOException;

/* loaded from: classes6.dex */
public class AndroidAppProcess extends AndroidProcess {
    public  final Creator<AndroidAppProcess> CREATOR = new a();
    public boolean c;
    public int d;
    private final Cgroup f;

    /* loaded from: classes6.dex */
    public static final class NotAndroidAppProcessException extends Exception {
        public NotAndroidAppProcessException(int i) {
            super(String.format(StringFog.decrypt("AzsiQhUFXhACJCBnRwFXVRwCJHMpDRFXUxYLOD0gQhEYERIJLnMmEhUbWBAGIzooDA=="), Integer.valueOf(i)));
        }
    }

    /* loaded from: classes6.dex */
    class a implements Creator<AndroidAppProcess> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AndroidAppProcess createFromParcel(Parcel parcel) {
            return new AndroidAppProcess(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AndroidAppProcess[] newArray(int i) {
            return new AndroidAppProcess[i];
        }
    }

    public AndroidAppProcess(int arg5) throws IOException, NotAndroidAppProcessException {
        super(arg5);
        Cgroup v0 = super.c();
        this.f = v0;
        ControlGroup v1 = v0.c(StringFog.decrypt("NCMyAwYURQ=="));
        ControlGroup v0_1 = v0.c(StringFog.decrypt("NCMy"));
        if(v0_1 != null && v1 != null) {
            String v3 = StringFog.decrypt("JzojPQ==");
            if(v1.c.contains(v3)) {
                String v0_2 = StringFog.decrypt("NTQYDAoZbhoJIzY1AwYDWAUC");
                this.c = v0_1.c.contains(v0_2);
                try {
                    String v1_1 = StringFog.decrypt("eA==");
                    this.d = Integer.parseInt(v1.c.split(v1_1)[1].replace(StringFog.decrypt("IjojPQ=="), ""));
                }
                catch(Exception unused_ex) {
                    this.d = this.e().e();
                }

                return;
            }
        }

        throw new NotAndroidAppProcessException(arg5);
    }

//    public AndroidAppProcess(int i) throws IOException, NotAndroidAppProcessException {
//        super(i);
//        Cgroup c = super.c();
//        this.f = c;
//        ControlGroup c2 = c.c(StringFog.decrypt("NCMyAwYURQ=="));
//        if (c.c(StringFog.decrypt("NCMy")) != null && c2 != null && c2.c.contains(StringFog.decrypt("JzojPQ=="))) {
//            this.c = !r0.c.contains(StringFog.decrypt("NTQYDAoZbhoJIzY1AwYDWAUC"));
//            try {
//                this.d = Integer.parseInt(c2.c.split(StringFog.decrypt("eA=="))[1].replace(StringFog.decrypt("IjojPQ=="), ""));
//                return;
//            } catch (Exception unused) {
//                this.d = e().e();
//                return;
//            }
//        }
//        throw new NotAndroidAppProcessException(i);
//    }

    @Override // com.shenren.aps.apps.AndroidProcess, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f, i);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
    }

    protected AndroidAppProcess(Parcel parcel) {
        super(parcel);
        this.f = (Cgroup) parcel.readParcelable(Cgroup.class.getClassLoader());
        this.c = parcel.readByte() != 0;
    }
}
