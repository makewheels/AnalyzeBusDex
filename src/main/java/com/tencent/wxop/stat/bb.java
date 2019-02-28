package com.tencent.wxop.stat;

class bb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f5418a;
    /* renamed from: b */
    final /* synthetic */ au f5419b;

    bb(au auVar, int i) {
        this.f5419b = auVar;
        this.f5418a = i;
    }

    public void run() {
        this.f5419b.m8214b(this.f5418a, true);
        this.f5419b.m8214b(this.f5418a, false);
    }
}
