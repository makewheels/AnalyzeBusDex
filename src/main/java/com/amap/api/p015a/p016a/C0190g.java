package com.amap.api.p015a.p016a;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
/* renamed from: com.amap.api.a.a.g */
class C0190g implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ C0189f f561a;

    C0190g(C0189f c0189f) {
        this.f561a = c0189f;
    }

    public /* synthetic */ Object call() throws Exception {
        return m709a();
    }

    /* renamed from: a */
    public Void m709a() throws Exception {
        synchronized (this.f561a) {
            if (this.f561a.f555i == null) {
            } else {
                this.f561a.m702i();
                if (this.f561a.m700g()) {
                    this.f561a.m699f();
                    this.f561a.f557k = 0;
                }
            }
        }
        return null;
    }
}
