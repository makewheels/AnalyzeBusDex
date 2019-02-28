package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C1192k;

final class aj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5358a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5359b;

    aj(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5358a = context;
        this.f5359b = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5358a == null) {
            StatServiceImpl.f5275q.error((Object) "The Context of StatService.onResume() can not be null!");
        } else {
            StatServiceImpl.trackBeginPage(this.f5358a, C1192k.m8297h(this.f5358a), this.f5359b);
        }
    }
}
