package com.shenren.aps.apps;

import android.os.Parcel;
import android.os.Parcelable;
import com.unity3d.player.StringFog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class Cgroup extends ProcFile {
    public final Creator<Cgroup> CREATOR = new a();
    public final ArrayList<ControlGroup> b;

    /* loaded from: classes6.dex */
    class a implements Creator<Cgroup> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cgroup createFromParcel(Parcel parcel) {
            return new Cgroup(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Cgroup[] newArray(int i) {
            return new Cgroup[i];
        }
    }

    /* synthetic */ Cgroup(Parcel parcel, Boolean aVar) {
        this(parcel);
    }

    public static Cgroup b(int i) throws IOException {
        return new Cgroup(String.format(StringFog.decrypt("eCM1DQZYFBdINDQ1DRAH"), Integer.valueOf(i)));
    }

    public ControlGroup c(String str) {
        Iterator<ControlGroup> it = this.b.iterator();
        while (it.hasNext()) {
            ControlGroup next = it.next();
            for (String str2 : next.b.split(StringFog.decrypt("ew=="))) {
                if (str2.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // com.shenren.aps.apps.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.b);
    }

    private Cgroup(String str) throws IOException {
        super(str);
        String[] split = this.a.split("\n");
        this.b = new ArrayList<>();
        for (String str2 : split) {
            try {
                this.b.add(new ControlGroup(str2));
            } catch (Exception unused) {
            }
        }
    }

    private Cgroup(Parcel parcel) {
        super(parcel);
        this.b = new ArrayList<>();
//        this.b = parcel.createTypedArrayList(ControlGroup.CREATOR);
    }
}
