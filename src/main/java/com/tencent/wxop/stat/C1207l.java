package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C1192k;

/* renamed from: com.tencent.wxop.stat.l */
final class C1207l implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5526a;

    C1207l(Context context) {
        this.f5526a = context;
    }

    public final void run() {
        C1178a.m8165a(StatServiceImpl.f5278t).m8180h();
        C1192k.m8272a(this.f5526a, true);
        au.m8199a(this.f5526a);
        C1204i.m8353b(this.f5526a);
        StatServiceImpl.f5276r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new ao());
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) {
            StatServiceImpl.commitEvents(this.f5526a, -1);
        }
        if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f5275q.m8240d("Init MTA StatService success.");
        }
    }
}
