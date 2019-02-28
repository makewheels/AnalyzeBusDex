package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1169c;

/* renamed from: com.tencent.wxop.stat.y */
final class C1220y implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5555a;
    /* renamed from: b */
    final /* synthetic */ C1169c f5556b;
    /* renamed from: c */
    final /* synthetic */ Context f5557c;

    C1220y(String str, C1169c c1169c, Context context) {
        this.f5555a = str;
        this.f5556b = c1169c;
        this.f5557c = context;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m8113a(this.f5555a)) {
                StatServiceImpl.f5275q.error((Object) "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (StatConfig.isDebugEnable()) {
                StatServiceImpl.f5275q.m8243i("add begin key:" + this.f5556b);
            }
            if (StatServiceImpl.f5263e.containsKey(this.f5556b)) {
                StatServiceImpl.f5275q.warn("Duplicate CustomEvent key: " + this.f5556b.toString() + ", trackCustomBeginKVEvent() repeated?");
            } else if (StatServiceImpl.f5263e.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                StatServiceImpl.f5263e.put(this.f5556b, Long.valueOf(System.currentTimeMillis()));
            } else {
                StatServiceImpl.f5275q.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
            }
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5557c, th);
        }
    }
}
