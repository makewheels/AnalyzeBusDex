package com.tencent.wxop.stat;

import android.content.Context;

final class ak implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5360a;
    /* renamed from: b */
    final /* synthetic */ Context f5361b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5362c;

    ak(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5360a = str;
        this.f5361b = context;
        this.f5362c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5360a == null || this.f5360a.trim().length() == 0) {
            StatServiceImpl.f5275q.m8245w("qq num is null or empty.");
            return;
        }
        StatConfig.f5233f = this.f5360a;
        StatServiceImpl.m8116b(this.f5361b, new StatAccount(this.f5360a), this.f5362c);
    }
}
