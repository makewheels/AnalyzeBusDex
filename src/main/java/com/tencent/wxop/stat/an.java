package com.tencent.wxop.stat;

import android.content.Context;

final class an implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5369a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5370b;

    an(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5369a = context;
        this.f5370b = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            StatServiceImpl.m8105a(this.f5369a, false, this.f5370b);
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
        }
    }
}
