package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1166e;
import com.tencent.wxop.stat.p053a.C1168b;
import com.tencent.wxop.stat.p053a.C1169c;

final class ac implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5342a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5343b;
    /* renamed from: c */
    final /* synthetic */ C1169c f5344c;
    /* renamed from: d */
    final /* synthetic */ int f5345d;

    ac(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C1169c c1169c, int i) {
        this.f5342a = context;
        this.f5343b = statSpecifyReportedInfo;
        this.f5344c = c1169c;
        this.f5345d = i;
    }

    public final void run() {
        try {
            C1166e c1168b = new C1168b(this.f5342a, StatServiceImpl.m8105a(this.f5342a, false, this.f5343b), this.f5344c.f5299a, this.f5343b);
            c1168b.m8147b().f5301c = this.f5344c.f5301c;
            Long valueOf = Long.valueOf((long) this.f5345d);
            c1168b.m8145a(Long.valueOf(valueOf.longValue() <= 0 ? 1 : valueOf.longValue()).longValue());
            new aq(c1168b).m8190a();
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5342a, th);
        }
    }
}
