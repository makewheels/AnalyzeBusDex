package com.amap.api.services.busline;

import android.os.Handler;
import android.os.Message;

/* compiled from: BusStationSearch */
/* renamed from: com.amap.api.services.busline.d */
class C0474d extends Handler {
    /* renamed from: a */
    final /* synthetic */ BusStationSearch f2903a;

    C0474d(BusStationSearch busStationSearch) {
        this.f2903a = busStationSearch;
    }

    public void handleMessage(Message message) {
        if (this.f2903a.f2897c != null) {
            BusStationResult busStationResult = null;
            if (message.what == 0) {
                busStationResult = (BusStationResult) message.obj;
            }
            this.f2903a.f2897c.onBusStationSearched(busStationResult, message.what);
        }
    }
}
