package com.tencent.wxop.stat;

import android.content.Context;

/* renamed from: com.tencent.wxop.stat.o */
final class C1210o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5530a;

    C1210o(Context context) {
        this.f5530a = context;
    }

    public final void run() {
        StatServiceImpl.flushDataToDB(this.f5530a);
    }
}
