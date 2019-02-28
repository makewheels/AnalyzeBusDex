package com.tencent.wxop.stat;

import java.util.List;

class av implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f5397a;
    /* renamed from: b */
    final /* synthetic */ int f5398b;
    /* renamed from: c */
    final /* synthetic */ boolean f5399c;
    /* renamed from: d */
    final /* synthetic */ boolean f5400d;
    /* renamed from: e */
    final /* synthetic */ au f5401e;

    av(au auVar, List list, int i, boolean z, boolean z2) {
        this.f5401e = auVar;
        this.f5397a = list;
        this.f5398b = i;
        this.f5399c = z;
        this.f5400d = z2;
    }

    public void run() {
        this.f5401e.m8209a(this.f5397a, this.f5398b, this.f5399c);
        if (this.f5400d) {
            this.f5397a.clear();
        }
    }
}
