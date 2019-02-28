package com.tencent.wxop.stat;

import android.content.Context;

final class al implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StatAccount f5363a;
    /* renamed from: b */
    final /* synthetic */ Context f5364b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5365c;

    al(StatAccount statAccount, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5363a = statAccount;
        this.f5364b = context;
        this.f5365c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5363a == null || this.f5363a.getAccount().trim().length() == 0) {
            StatServiceImpl.f5275q.m8245w("account is null or empty.");
            return;
        }
        StatConfig.setQQ(this.f5364b, this.f5363a.getAccount());
        StatServiceImpl.m8116b(this.f5364b, this.f5363a, this.f5365c);
    }
}
