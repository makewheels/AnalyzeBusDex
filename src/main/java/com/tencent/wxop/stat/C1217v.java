package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1169c;

/* renamed from: com.tencent.wxop.stat.v */
final class C1217v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5545a;
    /* renamed from: b */
    final /* synthetic */ C1169c f5546b;
    /* renamed from: c */
    final /* synthetic */ Context f5547c;

    C1217v(String str, C1169c c1169c, Context context) {
        this.f5545a = str;
        this.f5546b = c1169c;
        this.f5547c = context;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m8113a(this.f5545a)) {
                StatServiceImpl.f5275q.error((Object) "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (StatConfig.isDebugEnable()) {
                StatServiceImpl.f5275q.m8243i("add begin key:" + this.f5546b.toString());
            }
            if (StatServiceImpl.f5263e.containsKey(this.f5546b)) {
                StatServiceImpl.f5275q.error("Duplicate CustomEvent key: " + this.f5546b.toString() + ", trackCustomBeginEvent() repeated?");
            } else if (StatServiceImpl.f5263e.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                StatServiceImpl.f5263e.put(this.f5546b, Long.valueOf(System.currentTimeMillis()));
            } else {
                StatServiceImpl.f5275q.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
            }
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5547c, th);
        }
    }
}
