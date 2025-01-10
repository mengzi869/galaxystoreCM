package com.clean888.overseas.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

public final class HandlerManager {

    private final static String TAG = HandlerManager.class.getSimpleName();
    private final Handler defaultWorkHandler;
    private final Handler loadSplashWorkHandler;
    private final Handler mainHandler;
    private final Handler controllerHandler;

    private static class Holder {
        private static final HandlerManager INSTANCE = new HandlerManager();
    }

    public static HandlerManager get() {
        return Holder.INSTANCE;
    }

    private HandlerManager() {
        HandlerThread workThread = new HandlerThread("com.wll.rescue.beauty.thread.work", Thread.MAX_PRIORITY);
        workThread.start();
        this.defaultWorkHandler = new Handler(workThread.getLooper());

        HandlerThread loadSplashWorkThread = new HandlerThread("com.wll.rescue.beauty.thread.loadsplash.work", Thread.MAX_PRIORITY);
        loadSplashWorkThread.start();
        this.loadSplashWorkHandler = new Handler(loadSplashWorkThread.getLooper());

        HandlerThread controllerThread = new HandlerThread("com.wll.rescue.beauty.thread.controller", Thread.MAX_PRIORITY);
        controllerThread.start();
        this.controllerHandler = new Handler(controllerThread.getLooper());

        mainHandler = new Handler(Looper.getMainLooper());
    }

    public Handler getDefaultWorkHandler() {
        return defaultWorkHandler;
    }

    public Handler getLoadSplashWorkHandler() {
        return loadSplashWorkHandler;
    }

    public Handler getMainHandler() {
        return mainHandler;
    }

    public Handler getControllerHandler() {
        return controllerHandler;
    }

    public void isMainThread(String warningText) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Log.d(TAG, warningText);
        }
    }

    public static void mainRun(Runnable op) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            op.run();
        } else {
            get().getMainHandler().post(op);
        }
    }

    public static void mainExecRun(final Executor executor) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            executor.execute();
        } else {
            get().getMainHandler().post(new Runnable() {
                @Override
                public void run() {
                    executor.execute();
                }
            });
        }
    }

    public static void workRun(Runnable run) {
        get().getDefaultWorkHandler().post(run);
    }

    public static void loadSplashWork(Runnable run) {
        get().getLoadSplashWorkHandler().post(run);
    }

    public static void workExecRun(final Executor executor) {
        get().getDefaultWorkHandler().post(new Runnable() {
            @Override
            public void run() {
                executor.execute();
            }
        });
    }

    public static void controllerRun(Runnable run) {
        get().getControllerHandler().post(run);
    }

    public static void controllerRun(final Executor executor) {
        get().getControllerHandler().post(new Runnable() {
            @Override
            public void run() {
                executor.execute();
            }
        });
    }
}
