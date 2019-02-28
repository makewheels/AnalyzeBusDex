package com.tencent.wxop.stat;

import android.content.Context;

final class ae implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5348a;

    ae(Context context) {
        this.f5348a = context;
    }

    public final void run() {
        try {
            new Thread(new ap(this.f5348a, null, null), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5348a, th);
        }
    }
}
