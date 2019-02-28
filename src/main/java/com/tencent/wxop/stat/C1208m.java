package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C1192k;

/* renamed from: com.tencent.wxop.stat.m */
final class C1208m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5527a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5528b;

    C1208m(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5527a = context;
        this.f5528b = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5527a == null) {
            StatServiceImpl.f5275q.error((Object) "The Context of StatService.onPause() can not be null!");
        } else {
            StatServiceImpl.trackEndPage(this.f5527a, C1192k.m8297h(this.f5527a), this.f5528b);
        }
    }
}
