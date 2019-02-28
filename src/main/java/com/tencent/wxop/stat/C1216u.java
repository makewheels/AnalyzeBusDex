package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1166e;
import com.tencent.wxop.stat.p053a.C1168b;
import com.tencent.wxop.stat.p053a.C1169c;

/* renamed from: com.tencent.wxop.stat.u */
final class C1216u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5542a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5543b;
    /* renamed from: c */
    final /* synthetic */ C1169c f5544c;

    C1216u(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C1169c c1169c) {
        this.f5542a = context;
        this.f5543b = statSpecifyReportedInfo;
        this.f5544c = c1169c;
    }

    public final void run() {
        try {
            C1166e c1168b = new C1168b(this.f5542a, StatServiceImpl.m8105a(this.f5542a, false, this.f5543b), this.f5544c.f5299a, this.f5543b);
            c1168b.m8147b().f5301c = this.f5544c.f5301c;
            new aq(c1168b).m8190a();
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5542a, th);
        }
    }
}
