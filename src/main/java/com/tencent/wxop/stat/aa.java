package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1173h;

final class aa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5339a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5340b;
    /* renamed from: c */
    final /* synthetic */ StatAppMonitor f5341c;

    aa(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, StatAppMonitor statAppMonitor) {
        this.f5339a = context;
        this.f5340b = statSpecifyReportedInfo;
        this.f5341c = statAppMonitor;
    }

    public final void run() {
        try {
            new aq(new C1173h(this.f5339a, StatServiceImpl.m8105a(this.f5339a, false, this.f5340b), this.f5341c, this.f5340b)).m8190a();
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5339a, th);
        }
    }
}
