package com.clean888.cleansuper.cleaner.ui.fragment.lamp;

import android.content.Context;
import android.os.Handler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ed {

    /* renamed from: g, reason: collision with root package name */
    protected static final String f1770g = "ed";
    protected Handler a;
    protected String b;
    protected Context c;
    protected volatile boolean d;
    protected volatile boolean e;
    protected ArrayList<WeakReference<dd>> f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public ed(Context context) {
        this.c = context;
    }

    private void a(dd ddVar) {
        for (int size = this.f.size() - 1; size >= 0; size--) {
            dd ddVar2 = this.f.get(size).get();
            if (ddVar2 == null || ddVar2 == ddVar) {
                this.f.remove(size);
            }
        }
    }

    public void b(int i) {
        d(0, false, i);
    }

    public void c(boolean z) {
        d(3, z, -1);
    }

    protected void d(int i, boolean z, int i2) {
        synchronized (this.f) {
            int size = this.f.size();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                dd ddVar = this.f.get(i3).get();
                if (ddVar == null) {
                    z2 = true;
                } else if (i == 0) {
                    ddVar.b(i2);
                } else if (i == 3) {
                    ddVar.a(z);
                }
            }
            if (z2) {
                a(null);
            }
        }
    }

    public void e() {
        throw null;
    }

    public void f(boolean z) {
        throw null;
    }
}
