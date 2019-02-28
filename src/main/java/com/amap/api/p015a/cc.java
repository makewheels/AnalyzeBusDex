package com.amap.api.p015a;

import android.os.Handler;
import android.os.Message;

/* compiled from: UiSettingsDelegateImp */
/* renamed from: com.amap.api.a.cc */
class cc extends Handler {
    /* renamed from: a */
    final /* synthetic */ cb f993a;

    cc(cb cbVar) {
        this.f993a = cbVar;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 0:
                    this.f993a.f984b.mo127d(this.f993a.f988f);
                    return;
                case 1:
                    this.f993a.f984b.mo133g(this.f993a.f990h);
                    return;
                case 2:
                    this.f993a.f984b.mo131f(this.f993a.f989g);
                    return;
                case 3:
                    this.f993a.f984b.mo129e(this.f993a.f986d);
                    return;
                default:
                    return;
            }
        }
    }
}
