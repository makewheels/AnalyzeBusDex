package com.tencent.wxop.stat;

import com.tencent.wxop.stat.p053a.C1166e;

class ay implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1166e f5407a;
    /* renamed from: b */
    final /* synthetic */ C1179h f5408b;
    /* renamed from: c */
    final /* synthetic */ boolean f5409c;
    /* renamed from: d */
    final /* synthetic */ boolean f5410d;
    /* renamed from: e */
    final /* synthetic */ au f5411e;

    ay(au auVar, C1166e c1166e, C1179h c1179h, boolean z, boolean z2) {
        this.f5411e = auVar;
        this.f5407a = c1166e;
        this.f5408b = c1179h;
        this.f5409c = z;
        this.f5410d = z2;
    }

    public void run() {
        this.f5411e.m8215b(this.f5407a, this.f5408b, this.f5409c, this.f5410d);
    }
}
