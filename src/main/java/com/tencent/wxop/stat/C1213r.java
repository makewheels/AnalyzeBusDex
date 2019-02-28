package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1170d;

/* renamed from: com.tencent.wxop.stat.r */
final class C1213r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Throwable f5536a;
    /* renamed from: b */
    final /* synthetic */ Context f5537b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5538c;

    C1213r(Throwable th, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5536a = th;
        this.f5537b = context;
        this.f5538c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5536a == null) {
            StatServiceImpl.f5275q.error((Object) "The Throwable error message of StatService.reportException() can not be null!");
        } else {
            new aq(new C1170d(this.f5537b, StatServiceImpl.m8105a(this.f5537b, false, this.f5538c), 1, this.f5536a, this.f5538c)).m8190a();
        }
    }
}
