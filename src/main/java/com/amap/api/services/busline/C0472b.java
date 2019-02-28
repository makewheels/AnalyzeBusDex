package com.amap.api.services.busline;

import android.os.Handler;
import android.os.Message;

/* compiled from: BusLineSearch */
/* renamed from: com.amap.api.services.busline.b */
class C0472b extends Handler {
    /* renamed from: a */
    final /* synthetic */ BusLineSearch f2902a;

    C0472b(BusLineSearch busLineSearch) {
        this.f2902a = busLineSearch;
    }

    public void handleMessage(Message message) {
        if (this.f2902a.f2874c != null) {
            BusLineResult busLineResult = null;
            if (message.what == 0) {
                busLineResult = (BusLineResult) message.obj;
            }
            this.f2902a.f2874c.onBusLineSearched(busLineResult, message.what);
        }
    }
}
