package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1166e;
import com.tencent.wxop.stat.p053a.C1168b;
import com.tencent.wxop.stat.p053a.C1169c;

/* renamed from: com.tencent.wxop.stat.z */
final class C1221z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5558a;
    /* renamed from: b */
    final /* synthetic */ C1169c f5559b;
    /* renamed from: c */
    final /* synthetic */ Context f5560c;
    /* renamed from: d */
    final /* synthetic */ StatSpecifyReportedInfo f5561d;

    C1221z(String str, C1169c c1169c, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5558a = str;
        this.f5559b = c1169c;
        this.f5560c = context;
        this.f5561d = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m8113a(this.f5558a)) {
                StatServiceImpl.f5275q.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            Long l = (Long) StatServiceImpl.f5263e.remove(this.f5559b);
            if (l != null) {
                C1166e c1168b = new C1168b(this.f5560c, StatServiceImpl.m8105a(this.f5560c, false, this.f5561d), this.f5559b.f5299a, this.f5561d);
                c1168b.m8147b().f5301c = this.f5559b.f5301c;
                l = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c1168b.m8145a(Long.valueOf(l.longValue() <= 0 ? 1 : l.longValue()).longValue());
                new aq(c1168b).m8190a();
                return;
            }
            StatServiceImpl.f5275q.warn("No start time found for custom event: " + this.f5559b.toString() + ", lost trackCustomBeginKVEvent()?");
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5560c, th);
        }
    }
}
