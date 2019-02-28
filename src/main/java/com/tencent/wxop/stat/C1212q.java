package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1170d;
import com.tencent.wxop.stat.p053a.C1174i;

/* renamed from: com.tencent.wxop.stat.q */
final class C1212q implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5534a;
    /* renamed from: b */
    final /* synthetic */ Throwable f5535b;

    C1212q(Context context, Throwable th) {
        this.f5534a = context;
        this.f5535b = th;
    }

    public final void run() {
        try {
            if (StatConfig.isEnableStatService()) {
                new aq(new C1170d(this.f5534a, StatServiceImpl.m8105a(this.f5534a, false, null), 99, this.f5535b, C1174i.f5321a)).m8190a();
            }
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8241e("reportSdkSelfException error: " + th);
        }
    }
}
