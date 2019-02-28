package com.amap.api.mapcore.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
/* renamed from: com.amap.api.mapcore.util.g */
class C0386g implements ThreadFactory {
    /* renamed from: a */
    private final AtomicInteger f2127a = new AtomicInteger(1);

    C0386g() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.f2127a.getAndIncrement());
    }
}
