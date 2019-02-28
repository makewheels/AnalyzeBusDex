package com.tencent.wxop.stat;

import android.content.Context;
import java.util.Map;

final class af implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5349a;
    /* renamed from: b */
    final /* synthetic */ Map f5350b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5351c;

    af(Context context, Map map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5349a = context;
        this.f5350b = map;
        this.f5351c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            new Thread(new ap(this.f5349a, this.f5350b, this.f5351c), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5349a, th);
        }
    }
}
