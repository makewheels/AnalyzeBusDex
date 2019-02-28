package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.tencent.wxop.stat.b */
class C1180b extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ C1178a f5414a;

    C1180b(C1178a c1178a) {
        this.f5414a = c1178a;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f5414a.f5335e != null) {
            this.f5414a.f5335e.m8255a(new C1181c(this));
        }
    }
}
