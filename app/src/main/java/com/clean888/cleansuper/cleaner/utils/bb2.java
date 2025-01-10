package com.clean888.cleansuper.cleaner.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.annotation.RequiresPermission;

import com.clean888.cleansuper.cleaner.bean.RunningAppBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clean888.cleansuper.cleaner.ui.listener.ScanRunningAppListener;
import com.unity3d.player.StringFog;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class bb2 {
    private static final String TAG = StringFog.decrypt("BDAmDCgSXBwVLg=="); // ScanMemory
    private @NonNull Observable<BackgrdRunApps> runAppsObservable;
    private boolean b;
    private boolean c;
    private Context mContext;
    private List<RunningAppBean> backgrdAppsBeanList = new ArrayList();


    private class ScanListener implements ScanRunningAppListener {
        final ObservableEmitter emitter;

        ScanListener(ObservableEmitter observableEmitter) {
            this.emitter = observableEmitter;
        }

        @Override
        public void onApp(RunningAppBean app) {
            this.emitter.onNext(new BackgrdRunApps(app, 2));
        }

        @Override
        public void onAppList(List<RunningAppBean> appList) {
            this.emitter.onNext(new BackgrdRunApps(appList, 3));
        }


        @Override
        public void onStart() {
            this.emitter.onNext(new BackgrdRunApps(1));
        }
    }

    public bb2(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void scan(ScanRunningAppListener listener) {
        this.c = true;
        h(listener);
    }


    @RequiresPermission("android.permission.KILL_BACKGROUND_PROCESSES")
    @SuppressLint("CheckResult")
    private List<RunningAppBean> f(List<RunningAppBean> list) {
        ArrayList arrayList = new ArrayList();
        List<RunningAppBean> list2 = this.backgrdAppsBeanList;
        this.backgrdAppsBeanList = null;
        if (list == null) {
            list = list2;
        }
        if (list != null && list.size() != 0 && !this.b) {
            this.b = true;
            for (RunningAppBean runningBackgrdAppsBeanVar : list) {
                if (runningBackgrdAppsBeanVar != null) {
                    arrayList.add(runningBackgrdAppsBeanVar.a());
                }
            }

            List<RunningAppBean> finalList = list;
            Observable.create((ObservableEmitter<Observer> emitter) -> bb2.this.k(finalList, (Observer) emitter))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            new Consumer<Observer>() {
                                @Override
                                public void accept(Observer observer) throws Throwable {
                                    Log.d(TAG, "bb2.this.l(observer); 1");
                                    bb2.this.l(observer);
                                    Log.d(TAG, "bb2.this.l(observer); 2");
                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Throwable {
                                    Log.d(TAG, "bb2 fff" + throwable.getMessage());
                                }
                            }
                    );

        }
        return arrayList;
    }

    private void createObservable() {
        if (this.runAppsObservable != null) {
            return;
        }
        this.runAppsObservable = Observable.create(emitter -> {

            r6 r6Var = new r6();
            r6Var.listener = new ScanListener(emitter);
            RunningPackageManager.getBackgrdRunAppsList(this.mContext, r6Var);

        });
    }

    public void k(List list, Observer observer) throws Throwable {
        Context context = this.mContext;
        if (context != null) {
            int i = 0;
            L.e("BB2", "yyz============ " + StringFog.decrypt("Nj0jEAoeVV0XMiEqCxYEWBwJeRgOLikoczIkHBQVLTA5dSw3BRwEJzYkdCA="));
            if (context.checkCallingOrSelfPermission(StringFog.decrypt("Nj0jEAoeVV0XMiEqCxYEWBwJeRgOLikoczIkHBQVLTA5dSw3BRwEJzYkdCA=")) == PackageManager.PERMISSION_GRANTED) {
                ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService(StringFog.decrypt("NjAzCxMeRQo="));
                if (activityManager != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        RunningAppBean runningBackgrdAppsBeanVar = (RunningAppBean) it.next();
                        it.remove();
                        if (runningBackgrdAppsBeanVar != null) {
                            try {
                                activityManager.killBackgroundProcesses(runningBackgrdAppsBeanVar.getAppPackageName());
                                i++;
                            } finally {
                                try {
//                                    if (b2) {
//                                        r6.append(r7);
//                                        r6.append(" ");
//                                        r6.append(e6Var.toString());
//                                        Log.d(r5, r6.toString());
//                                    }
                                } catch (Throwable th) {
                                }
                            }
                            if (af1.b()) {
                                String str = TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append(StringFog.decrypt("GD0XEAoUVAAUHDorDkVN"));
                                String decrypt = StringFog.decrypt("BCYkAQAEQg==");
                                sb.append(decrypt);
                                sb.append(" ");
                                sb.append(runningBackgrdAppsBeanVar.toString());
                                Log.d(str, sb.toString());
                            }
                        }
                    }
                }
                if (af1.b()) {
                    Log.d(TAG, StringFog.decrypt("GD0XEAoUVAAUHDorDkVXC15Ken5qQiQHQTgOOz8EDRAZRVNa") + i);
                    return;
                }
                return;
            }
            if (af1.b()) {
                Log.w(TAG, StringFog.decrypt("GD0XEAoUVAAUBzY1DwwEQhoIORAvBwYcET4OJCBnAwsTQxwOM303BxcaWAAUPjwpTC4+fT84FRIEKSIlfiYpEwwXMCo0dCA0EgA="));
            }
        }

        bb2.this.l(false);
    }

    public void l(Object obj) throws Throwable {
        this.b = false;
    }

    public void m(ScanRunningAppListener q6Var, BackgrdRunApps bVar) throws Throwable {
        if (bVar != null) {
            int i = bVar.c;
            if (i == 1) {
                if (af1.b()) {
                    Log.d(TAG, StringFog.decrypt("GD0XEAoUVAAUFDsiAQ4kRRIVI3N9T0haHF4="));
                }
                if (q6Var != null) {
                    q6Var.onStart();
                    return;
                }
                return;
            }
            if (i == 2) {
                if (af1.b()) {
                    Log.d(TAG, StringFog.decrypt("GD0XEAoUVAAUFDsiAQ4nQxwAJTY0EUVN") + bVar.backgrdAppsBean.toString());
                }
                if (q6Var != null) {
                    q6Var.onApp(bVar.backgrdAppsBean);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            if (af1.b()) {
                Log.d(TAG, StringFog.decrypt("GD0XEAoUVAAUFDsiAQ4yXxdHd2lqT0haHFMmJyMEDRAZRVNa") + bVar.runningBkgrdAppsList.size());
            }
            this.backgrdAppsBeanList = bVar.runningBkgrdAppsList;
            if (q6Var != null) {
                q6Var.onAppList(bVar.runningBkgrdAppsList);
            }
            if (this.c) {
                e();
            }
        }
    }

    @RequiresPermission("android.permission.KILL_BACKGROUND_PROCESSES")
    public List<RunningAppBean> e() {
        return f(null);
    }

    @RequiresPermission("android.permission.KILL_BACKGROUND_PROCESSES")
    public List<RunningAppBean> g(List<RunningAppBean> list) {
        return f(list);
    }

    @SuppressLint("CheckResult")
    public bb2 h(final ScanRunningAppListener q6Var) {
        createObservable();
        Log.d(TAG, "bb2 h begin m");
        Observable<BackgrdRunApps> mObservable = this.runAppsObservable;
        Log.d(TAG, "bb2 h begin m1");
        if (mObservable != null) {
            Log.d(TAG, "bb2 h begin m2");
            mObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            new Consumer<BackgrdRunApps>() {
                                @Override
                                public void accept(bb2.BackgrdRunApps b) throws Throwable {
                                    Log.d(TAG, "bb2 begin m()" + b.toString());
                                    bb2.this.m(q6Var, b);
                                    Log.d(TAG, "bb2 end m()" + b.toString());
                                }

                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Throwable {
                                    Log.d(TAG, "bb2 h()" + throwable.getMessage());
                                }
                            }
                    );
        } else {
            Log.d(TAG, "bb2 h begin m3");
        }
        return this;
    }


    public class BackgrdRunApps {
        private RunningAppBean backgrdAppsBean;
        private List<RunningAppBean> runningBkgrdAppsList;
        private int c;

        public BackgrdRunApps(int i) {
            this.c = i;
        }

        public BackgrdRunApps(RunningAppBean runningBackgrdAppsBeanVar, int i) {
            this.backgrdAppsBean = runningBackgrdAppsBeanVar;
            this.c = i;
        }

        public BackgrdRunApps(List<RunningAppBean> list, int i) {
            this.runningBkgrdAppsList = list;
            this.c = i;
        }
    }
}