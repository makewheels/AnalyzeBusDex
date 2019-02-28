package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1166e;
import com.tencent.wxop.stat.p053a.C1176k;

final class ah implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5353a;
    /* renamed from: b */
    final /* synthetic */ String f5354b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5355c;

    ah(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5353a = context;
        this.f5354b = str;
        this.f5355c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            Long l;
            StatServiceImpl.flushDataToDB(this.f5353a);
            synchronized (StatServiceImpl.f5273o) {
                l = (Long) StatServiceImpl.f5273o.remove(this.f5354b);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String j = StatServiceImpl.f5272n;
                if (j != null && j.equals(this.f5354b)) {
                    j = "-";
                }
                C1166e c1176k = new C1176k(this.f5353a, j, this.f5354b, StatServiceImpl.m8105a(this.f5353a, false, this.f5355c), valueOf, this.f5355c);
                if (!this.f5354b.equals(StatServiceImpl.f5271m)) {
                    StatServiceImpl.f5275q.warn("Invalid invocation since previous onResume on diff page.");
                }
                new aq(c1176k).m8190a();
                StatServiceImpl.f5272n = this.f5354b;
                return;
            }
            StatServiceImpl.f5275q.m8241e("Starttime for PageID:" + this.f5354b + " not found, lost onResume()?");
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5353a, th);
        }
    }
}
