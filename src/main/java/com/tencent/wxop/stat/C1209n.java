package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C1192k;

/* renamed from: com.tencent.wxop.stat.n */
final class C1209n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5529a;

    C1209n(Context context) {
        this.f5529a = context;
    }

    public final void run() {
        if (this.f5529a == null) {
            StatServiceImpl.f5275q.error((Object) "The Context of StatService.onStop() can not be null!");
            return;
        }
        StatServiceImpl.flushDataToDB(this.f5529a);
        if (!StatServiceImpl.m8112a()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (C1192k.m8268B(this.f5529a)) {
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f5275q.m8243i("onStop isBackgroundRunning flushDataToDB");
                }
                StatServiceImpl.commitEvents(this.f5529a, -1);
            }
        }
    }
}
