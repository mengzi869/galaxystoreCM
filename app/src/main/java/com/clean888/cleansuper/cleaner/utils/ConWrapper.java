package com.clean888.cleansuper.cleaner.utils;

import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes2.dex */
public class ConWrapper extends ContextWrapper {
    private final String a;
    private final Context b;

    public ConWrapper(Context context, String str) {
        super(context);
        this.b = context;
        this.a = TextUtils.isEmpty(str) ? context.getPackageName() : str;
    }

    private void a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null || !this.a.equals(component.getPackageName())) {
            return;
        }
        intent.setComponent(new ComponentName(getBaseContext().getPackageName(), component.getClassName()));
    }

    public static String b() {
        return Log.getStackTraceString(new Throwable());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        String b = b();
        if (b.contains("com.google.android.gms")) {
            return super.getPackageManager();
        }
        if (!b.contains("isGooglePlayServicesAvailable")) {
            return new PkgManager(this.b.getPackageManager(), this.a, this.b, "");
        }
        return super.getPackageManager();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        String b = b();
        if (!b.contains("com.google.android.gms.common.zze.zzan") && !b.contains("com.google.android.gms.DynamiteModulesA") && !b.contains("com.google.android.gms.common.internal.zzf.zza")) {
            if (b.contains("com.google.android.gms")) {
                return this.a;
            }
            if (!b.contains("isGooglePlayServicesAvailable")) {
                if (b.contains("android.app.PendingIntent.getActivity")) {
                    return super.getPackageName();
                }
                return this.a;
            }
            return super.getPackageName();
        }
        return getBaseContext().getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.b.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        if (intentArr != null && intentArr.length > 0) {
            for (Intent intent : intentArr) {
                a(intent);
            }
        }
        super.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        a(intent);
        super.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        try {
            super.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.b.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        if (intentArr != null && intentArr.length > 0) {
            for (Intent intent : intentArr) {
                a(intent);
            }
        }
        super.startActivities(intentArr, bundle);
    }
}
