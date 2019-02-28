package com.tencent.wxop.stat;

import java.util.List;

/* renamed from: com.tencent.wxop.stat.k */
class C1206k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f5523a;
    /* renamed from: b */
    final /* synthetic */ C1179h f5524b;
    /* renamed from: c */
    final /* synthetic */ C1204i f5525c;

    C1206k(C1204i c1204i, List list, C1179h c1179h) {
        this.f5525c = c1204i;
        this.f5523a = list;
        this.f5524b = c1179h;
    }

    public void run() {
        this.f5525c.m8355a(this.f5523a, this.f5524b);
    }
}
