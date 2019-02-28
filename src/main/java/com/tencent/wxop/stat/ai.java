package com.tencent.wxop.stat;

import android.content.Context;

final class ai implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5356a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5357b;

    ai(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5356a = context;
        this.f5357b = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            StatServiceImpl.stopSession();
            StatServiceImpl.m8105a(this.f5356a, true, this.f5357b);
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5356a, th);
        }
    }
}
