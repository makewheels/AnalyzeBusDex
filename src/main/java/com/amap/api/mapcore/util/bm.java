package com.amap.api.mapcore.util;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class bm implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ bl f2075a;

    bm(bl blVar) {
        this.f2075a = blVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return m3276a();
    }

    /* renamed from: a */
    public Void m3276a() throws Exception {
        synchronized (this.f2075a) {
            if (this.f2075a.f2069k == null) {
            } else {
                this.f2075a.m3268j();
                if (this.f2075a.m3266h()) {
                    this.f2075a.m3265g();
                    this.f2075a.f2071m = 0;
                }
            }
        }
        return null;
    }
}
