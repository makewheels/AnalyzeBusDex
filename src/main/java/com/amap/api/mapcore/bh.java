package com.amap.api.mapcore;

import android.os.Handler;
import android.os.Message;

/* compiled from: UiSettingsDelegateImp */
class bh extends Handler {
    /* renamed from: a */
    final /* synthetic */ bg f1722a;

    bh(bg bgVar) {
        this.f1722a = bgVar;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 0:
                    this.f1722a.f1711b.mo384a(this.f1722a.f1717h);
                    return;
                case 1:
                    this.f1722a.f1711b.mo399d(this.f1722a.f1719j);
                    return;
                case 2:
                    this.f1722a.f1711b.mo396c(this.f1722a.f1718i);
                    return;
                case 3:
                    this.f1722a.f1711b.mo392b(this.f1722a.f1715f);
                    return;
                default:
                    return;
            }
        }
    }
}
