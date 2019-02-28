package com.tencent.wxop.stat.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tencent.wxop.stat.common.e */
public class C1186e {
    /* renamed from: a */
    ExecutorService f5461a;

    public C1186e() {
        this.f5461a = null;
        this.f5461a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    public void m8255a(Runnable runnable) {
        this.f5461a.execute(runnable);
    }
}
