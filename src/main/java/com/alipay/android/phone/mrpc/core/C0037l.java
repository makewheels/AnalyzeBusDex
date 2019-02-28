package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/* renamed from: com.alipay.android.phone.mrpc.core.l */
public final class C0037l implements ab {
    /* renamed from: b */
    private static C0037l f42b = null;
    /* renamed from: i */
    private static final ThreadFactory f43i = new C0039n();
    /* renamed from: a */
    Context f44a;
    /* renamed from: c */
    private ThreadPoolExecutor f45c = new ThreadPoolExecutor(10, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f43i, new CallerRunsPolicy());
    /* renamed from: d */
    private C0025b f46d = C0025b.m53a("android");
    /* renamed from: e */
    private long f47e;
    /* renamed from: f */
    private long f48f;
    /* renamed from: g */
    private long f49g;
    /* renamed from: h */
    private int f50h;

    private C0037l(Context context) {
        this.f44a = context;
        try {
            this.f45c.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
        }
        CookieSyncManager.createInstance(this.f44a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    /* renamed from: a */
    public static final C0037l m80a(Context context) {
        return f42b != null ? f42b : C0037l.m81b(context);
    }

    /* renamed from: b */
    private static final synchronized C0037l m81b(Context context) {
        C0037l c0037l;
        synchronized (C0037l.class) {
            if (f42b != null) {
                c0037l = f42b;
            } else {
                c0037l = new C0037l(context);
                f42b = c0037l;
            }
        }
        return c0037l;
    }

    /* renamed from: a */
    public final C0025b m82a() {
        return this.f46d;
    }

    /* renamed from: a */
    public final Future<C0042u> mo21a(C0040t c0040t) {
        long j = 0;
        if (C0046s.m123a(this.f44a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f45c.getActiveCount());
            objArr[1] = Long.valueOf(this.f45c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f45c.getTaskCount());
            objArr[3] = Long.valueOf(this.f49g == 0 ? 0 : ((this.f47e * 1000) / this.f49g) >> 10);
            if (this.f50h != 0) {
                j = this.f48f / ((long) this.f50h);
            }
            objArr[4] = Long.valueOf(j);
            objArr[5] = Long.valueOf(this.f47e);
            objArr[6] = Long.valueOf(this.f48f);
            objArr[7] = Long.valueOf(this.f49g);
            objArr[8] = Integer.valueOf(this.f50h);
            String.format(str, objArr);
        }
        Object c0044q = new C0044q(this, (C0041o) c0040t);
        Object c0038m = new C0038m(this, c0044q, c0044q);
        this.f45c.execute(c0038m);
        return c0038m;
    }

    /* renamed from: a */
    public final void m84a(long j) {
        this.f47e += j;
    }

    /* renamed from: b */
    public final void m85b(long j) {
        this.f48f += j;
        this.f50h++;
    }

    /* renamed from: c */
    public final void m86c(long j) {
        this.f49g += j;
    }
}
