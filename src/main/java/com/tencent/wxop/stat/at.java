package com.tencent.wxop.stat;

class at implements C1179h {
    /* renamed from: a */
    final /* synthetic */ aq f5382a;

    at(aq aqVar) {
        this.f5382a = aqVar;
    }

    /* renamed from: a */
    public void mo1913a() {
        StatServiceImpl.m8120c();
        if (au.m8213b().f5386a > 0) {
            StatServiceImpl.commitEvents(this.f5382a.f5378d, -1);
        }
    }

    /* renamed from: b */
    public void mo1914b() {
        au.m8213b().m8228a(this.f5382a.f5375a, null, this.f5382a.f5377c, true);
        StatServiceImpl.m8121d();
    }
}
