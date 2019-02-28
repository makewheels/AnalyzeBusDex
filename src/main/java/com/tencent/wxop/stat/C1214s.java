package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1166e;
import com.tencent.wxop.stat.p053a.C1168b;
import com.tencent.wxop.stat.p053a.C1169c;

/* renamed from: com.tencent.wxop.stat.s */
final class C1214s implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5539a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5540b;
    /* renamed from: c */
    final /* synthetic */ C1169c f5541c;

    C1214s(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C1169c c1169c) {
        this.f5539a = context;
        this.f5540b = statSpecifyReportedInfo;
        this.f5541c = c1169c;
    }

    public final void run() {
        try {
            C1166e c1168b = new C1168b(this.f5539a, StatServiceImpl.m8105a(this.f5539a, false, this.f5540b), this.f5541c.f5299a, this.f5540b);
            c1168b.m8147b().f5300b = this.f5541c.f5300b;
            new aq(c1168b).m8190a();
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5539a, th);
        }
    }
}
