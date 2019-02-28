package com.autonavi.tbt;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class am implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ al f3744a;

    am(al alVar) {
        this.f3744a = alVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return m4760a();
    }

    /* renamed from: a */
    public Void m4760a() throws Exception {
        synchronized (this.f3744a) {
            if (this.f3744a.f3738k == null) {
            } else {
                this.f3744a.m4752j();
                if (this.f3744a.m4750h()) {
                    this.f3744a.m4749g();
                    this.f3744a.f3740m = 0;
                }
            }
        }
        return null;
    }
}
