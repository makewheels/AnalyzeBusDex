package com.amap.api.p015a.p016a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
/* renamed from: com.amap.api.a.a.c */
class C0182c implements ThreadFactory {
    /* renamed from: a */
    private final AtomicInteger f521a = new AtomicInteger(1);

    C0182c() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.f521a.getAndIncrement());
    }
}
