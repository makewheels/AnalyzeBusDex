package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.ay.C0357a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: ThreadPool */
public final class aw {
    /* renamed from: a */
    private static aw f1989a = null;
    /* renamed from: b */
    private ExecutorService f1990b;
    /* renamed from: c */
    private ConcurrentHashMap<ay, Future<?>> f1991c = new ConcurrentHashMap();
    /* renamed from: d */
    private C0357a f1992d = new ax(this);

    /* renamed from: a */
    public static synchronized aw m3128a(int i) {
        aw awVar;
        synchronized (aw.class) {
            if (f1989a == null) {
                f1989a = new aw(i);
            }
            awVar = f1989a;
        }
        return awVar;
    }

    private aw(int i) {
        try {
            this.f1990b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            az.m3143a(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private synchronized void m3130a(ay ayVar, boolean z) {
        try {
            Future future = (Future) this.f1991c.remove(ayVar);
            if (z && future != null) {
                future.cancel(true);
            }
        } catch (Throwable th) {
            az.m3143a(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
