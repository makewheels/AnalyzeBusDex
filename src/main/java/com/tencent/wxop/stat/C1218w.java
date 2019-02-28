package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.w */
final class C1218w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5548a;
    /* renamed from: b */
    final /* synthetic */ Context f5549b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5550c;

    C1218w(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5548a = str;
        this.f5549b = context;
        this.f5550c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            synchronized (StatServiceImpl.f5273o) {
                if (StatServiceImpl.f5273o.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    StatServiceImpl.f5275q.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    return;
                }
                StatServiceImpl.f5271m = this.f5548a;
                if (StatServiceImpl.f5273o.containsKey(StatServiceImpl.f5271m)) {
                    StatServiceImpl.f5275q.m8241e("Duplicate PageID : " + StatServiceImpl.f5271m + ", onResume() repeated?");
                    return;
                }
                StatServiceImpl.f5273o.put(StatServiceImpl.f5271m, Long.valueOf(System.currentTimeMillis()));
                StatServiceImpl.m8105a(this.f5549b, true, this.f5550c);
            }
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5549b, th);
        }
    }
}
