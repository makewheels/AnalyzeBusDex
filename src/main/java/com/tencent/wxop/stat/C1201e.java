package com.tencent.wxop.stat;

import com.tencent.wxop.stat.common.C1192k;
import java.util.TimerTask;

/* renamed from: com.tencent.wxop.stat.e */
class C1201e extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ C1200d f5510a;

    C1201e(C1200d c1200d) {
        this.f5510a = c1200d;
    }

    public void run() {
        if (StatConfig.isDebugEnable()) {
            C1192k.m8283b().m8243i("TimerTask run");
        }
        StatServiceImpl.m8124e(this.f5510a.f5509c);
        cancel();
        this.f5510a.m8342a();
    }
}
