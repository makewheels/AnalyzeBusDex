package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1170d;

/* renamed from: com.tencent.wxop.stat.p */
final class C1211p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5531a;
    /* renamed from: b */
    final /* synthetic */ Context f5532b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5533c;

    C1211p(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5531a = str;
        this.f5532b = context;
        this.f5533c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m8113a(this.f5531a)) {
                StatServiceImpl.f5275q.error((Object) "Error message in StatService.reportError() is empty.");
            } else {
                new aq(new C1170d(this.f5532b, StatServiceImpl.m8105a(this.f5532b, false, this.f5533c), this.f5531a, 0, StatConfig.getMaxReportEventLength(), null, this.f5533c)).m8190a();
            }
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5532b, th);
        }
    }
}
