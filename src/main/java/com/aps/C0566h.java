package com.aps;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
/* renamed from: com.aps.h */
class C0566h implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ C0565g f3501a;

    C0566h(C0565g c0565g) {
        this.f3501a = c0565g;
    }

    public /* synthetic */ Object call() throws Exception {
        return m4528a();
    }

    /* renamed from: a */
    public Void m4528a() throws Exception {
        synchronized (this.f3501a) {
            if (this.f3501a.f3496k == null) {
            } else {
                this.f3501a.m4523h();
                if (this.f3501a.m4521f()) {
                    this.f3501a.m4518e();
                    this.f3501a.f3498m = 0;
                }
            }
        }
        return null;
    }
}
