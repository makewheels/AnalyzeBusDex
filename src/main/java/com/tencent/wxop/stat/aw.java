package com.tencent.wxop.stat;

import java.util.List;

class aw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f5402a;
    /* renamed from: b */
    final /* synthetic */ boolean f5403b;
    /* renamed from: c */
    final /* synthetic */ boolean f5404c;
    /* renamed from: d */
    final /* synthetic */ au f5405d;

    aw(au auVar, List list, boolean z, boolean z2) {
        this.f5405d = auVar;
        this.f5402a = list;
        this.f5403b = z;
        this.f5404c = z2;
    }

    public void run() {
        this.f5405d.m8210a(this.f5402a, this.f5403b);
        if (this.f5404c) {
            this.f5402a.clear();
        }
    }
}
