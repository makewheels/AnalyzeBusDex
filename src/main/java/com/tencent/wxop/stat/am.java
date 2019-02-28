package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1172g;

final class am implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StatGameUser f5366a;
    /* renamed from: b */
    final /* synthetic */ Context f5367b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5368c;

    am(StatGameUser statGameUser, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5366a = statGameUser;
        this.f5367b = context;
        this.f5368c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5366a == null) {
            StatServiceImpl.f5275q.error((Object) "The gameUser of StatService.reportGameUser() can not be null!");
        } else if (this.f5366a.getAccount() == null || this.f5366a.getAccount().length() == 0) {
            StatServiceImpl.f5275q.error((Object) "The account of gameUser on StatService.reportGameUser() can not be null or empty!");
        } else {
            try {
                new aq(new C1172g(this.f5367b, StatServiceImpl.m8105a(this.f5367b, false, this.f5368c), this.f5366a, this.f5368c)).m8190a();
            } catch (Throwable th) {
                StatServiceImpl.f5275q.m8242e(th);
                StatServiceImpl.m8111a(this.f5367b, th);
            }
        }
    }
}
