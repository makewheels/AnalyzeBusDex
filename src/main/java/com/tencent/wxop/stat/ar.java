package com.tencent.wxop.stat;

class ar implements C1179h {
    /* renamed from: a */
    final /* synthetic */ aq f5380a;

    ar(aq aqVar) {
        this.f5380a = aqVar;
    }

    /* renamed from: a */
    public void mo1913a() {
        StatServiceImpl.m8120c();
        if (au.m8213b().m8226a() >= StatConfig.getMaxBatchReportCount()) {
            au.m8213b().m8227a(StatConfig.getMaxBatchReportCount());
        }
    }

    /* renamed from: b */
    public void mo1914b() {
        StatServiceImpl.m8121d();
    }
}
