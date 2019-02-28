package com.tencent.wxop.stat;

import java.util.List;

class ba implements C1179h {
    /* renamed from: a */
    final /* synthetic */ List f5415a;
    /* renamed from: b */
    final /* synthetic */ boolean f5416b;
    /* renamed from: c */
    final /* synthetic */ au f5417c;

    ba(au auVar, List list, boolean z) {
        this.f5417c = auVar;
        this.f5415a = list;
        this.f5416b = z;
    }

    /* renamed from: a */
    public void mo1913a() {
        StatServiceImpl.m8120c();
        this.f5417c.m8231a(this.f5415a, this.f5416b, true);
    }

    /* renamed from: b */
    public void mo1914b() {
        StatServiceImpl.m8121d();
        this.f5417c.m8230a(this.f5415a, 1, this.f5416b, true);
    }
}
