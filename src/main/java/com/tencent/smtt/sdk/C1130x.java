package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.tencent.smtt.sdk.x */
class C1130x extends Handler {
    /* renamed from: a */
    final /* synthetic */ C1129w f5105a;

    C1130x(C1129w c1129w, Looper looper) {
        this.f5105a = c1129w;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 150) {
            this.f5105a.m7895p();
        }
    }
}
