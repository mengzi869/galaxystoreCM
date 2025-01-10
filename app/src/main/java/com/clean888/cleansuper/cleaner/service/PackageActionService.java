package com.clean888.cleansuper.cleaner.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.clean888.cleansuper.cleaner.ui.MainActivity;
import com.clean888.cleansuper.cleaner.utils.fj;

// BAAT
public class PackageActionService extends Service {
    private Context a;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = this;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            boolean isInstall = intent.getBooleanExtra(MainActivity.IS_INSTALL, true);
            String extraPackage = intent.getStringExtra(MainActivity.PACKAGE);
            Log.e("PackageActionService", "onStartCommand isInstall:"+isInstall+" package:"+extraPackage);
            if (isInstall) {
                fj.installPackage(this.a, extraPackage);
            } else {
                fj.uninstallPackage(this.a, extraPackage);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("PackageActionService", "onDestroy");
    }
}
