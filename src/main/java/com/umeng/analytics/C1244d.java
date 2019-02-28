package com.umeng.analytics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: QueuedWork */
/* renamed from: com.umeng.analytics.d */
public class C1244d {
    /* renamed from: a */
    private static ExecutorService f5626a = Executors.newSingleThreadExecutor();
    /* renamed from: b */
    private static long f5627b = 5;
    /* renamed from: c */
    private static ExecutorService f5628c = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public static void m8405a(Runnable runnable) {
        if (f5626a.isShutdown()) {
            f5626a = Executors.newSingleThreadExecutor();
        }
        f5626a.execute(runnable);
    }

    /* renamed from: a */
    public static void m8404a() {
        try {
            if (!f5626a.isShutdown()) {
                f5626a.shutdown();
            }
            if (!f5628c.isShutdown()) {
                f5628c.shutdown();
            }
            f5626a.awaitTermination(f5627b, TimeUnit.SECONDS);
            f5628c.awaitTermination(f5627b, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static void m8406b(Runnable runnable) {
        if (f5628c.isShutdown()) {
            f5628c = Executors.newSingleThreadExecutor();
        }
        f5628c.execute(runnable);
    }
}
