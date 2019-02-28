package com.tencent.wxop.stat;

import android.content.Context;

final class ad implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5346a;
    /* renamed from: b */
    final /* synthetic */ int f5347b;

    ad(Context context, int i) {
        this.f5346a = context;
        this.f5347b = i;
    }

    public final void run() {
        try {
            StatServiceImpl.flushDataToDB(this.f5346a);
            au.m8199a(this.f5346a).m8227a(this.f5347b);
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
            StatServiceImpl.m8111a(this.f5346a, th);
        }
    }
}
