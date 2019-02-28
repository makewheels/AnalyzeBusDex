package com.autonavi.tbt;

import com.autonavi.tbt.ba.C0611a;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: ThreadPool */
public final class az {
    /* renamed from: a */
    private static az f3773a = null;
    /* renamed from: b */
    private ExecutorService f3774b;
    /* renamed from: c */
    private ConcurrentHashMap<ba, Future<?>> f3775c = new ConcurrentHashMap();
    /* renamed from: d */
    private C0611a f3776d = new bb(this);

    /* renamed from: a */
    public static synchronized az m4801a(int i) {
        az azVar;
        synchronized (az.class) {
            if (f3773a == null) {
                f3773a = new az(i);
            }
            azVar = f3773a;
        }
        return azVar;
    }

    private az(int i) {
        try {
            this.f3774b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            ae.m4671a(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m4808a(ba baVar) throws C0618h {
        try {
            if (!m4807b(baVar) && this.f3774b != null && !this.f3774b.isShutdown()) {
                baVar.f3662m = this.f3776d;
                Future submit = this.f3774b.submit(baVar);
                if (submit != null) {
                    m4804a(baVar, submit);
                }
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
            ae.m4671a(th, "TPool", "addTask");
            C0618h c0618h = new C0618h("thread pool has exception");
        }
    }

    /* renamed from: a */
    public static synchronized void m4802a() {
        synchronized (az.class) {
            try {
                if (f3773a != null) {
                    f3773a.m4806b();
                    f3773a = null;
                }
            } catch (Throwable th) {
                ae.m4671a(th, "TPool", "onDestroy");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m4806b() {
        try {
            for (Entry key : this.f3775c.entrySet()) {
                Future future = (Future) this.f3775c.get((ba) key.getKey());
                if (future != null) {
                    future.cancel(true);
                }
            }
            this.f3775c.clear();
            this.f3774b.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            ae.m4671a(th, "TPool", "destroy");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private synchronized boolean m4807b(ba baVar) {
        boolean z;
        z = false;
        try {
            z = this.f3775c.containsKey(baVar);
        } catch (Throwable th) {
            ae.m4671a(th, "TPool", "contain");
            th.printStackTrace();
        }
        return z;
    }

    /* renamed from: a */
    private synchronized void m4804a(ba baVar, Future<?> future) {
        try {
            this.f3775c.put(baVar, future);
        } catch (Throwable th) {
            ae.m4671a(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private synchronized void m4805a(ba baVar, boolean z) {
        try {
            Future future = (Future) this.f3775c.remove(baVar);
            if (z && future != null) {
                future.cancel(true);
            }
        } catch (Throwable th) {
            ae.m4671a(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
