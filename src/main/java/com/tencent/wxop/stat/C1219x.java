package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1166e;
import com.tencent.wxop.stat.p053a.C1168b;
import com.tencent.wxop.stat.p053a.C1169c;

/* renamed from: com.tencent.wxop.stat.x */
final class C1219x implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5551a;
    /* renamed from: b */
    final /* synthetic */ C1169c f5552b;
    /* renamed from: c */
    final /* synthetic */ Context f5553c;
    /* renamed from: d */
    final /* synthetic */ StatSpecifyReportedInfo f5554d;

    C1219x(String str, C1169c c1169c, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5551a = str;
        this.f5552b = c1169c;
        this.f5553c = context;
        this.f5554d = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m8113a(this.f5551a)) {
                StatServiceImpl.f5275q.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            Long l = (Long) StatServiceImpl.f5263e.remove(this.f5552b);
            if (l != null) {
                C1166e c1168b = new C1168b(this.f5553c, StatServiceImpl.m8105a(this.f5553c, false, this.f5554d), this.f5552b.f5299a, this.f5554d);
                c1168b.m8147b().f5300b = this.f5552b.f5300b;
                l = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c1168b.m8145a(Long.valueOf(l.longValue() == 0 ? 1 : l.longValue()).longValue());
                new aq(c1168b).m8190a();
                return;
            }
            StatServiceImpl.f5275q.error("No start time found for custom event: " + this.f5552b.toString() + ", lost trackCustomBeginEvent()?");
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5553c, th);
        }
    }
}
