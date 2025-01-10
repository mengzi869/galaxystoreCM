package com.clean888.cleansuper.cleaner.utils;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class lq2 {
    private ThreadPoolExecutor a;

    /* loaded from: classes2.dex */
    private static class b {
        private static final lq2 a = new lq2();
    }

    public static lq2 a() {
        return b.a;
    }

    public ThreadPoolExecutor b() {
        return this.a;
    }

    private lq2() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.a = new ThreadPoolExecutor(availableProcessors + 1, (availableProcessors * 2) + 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }
}