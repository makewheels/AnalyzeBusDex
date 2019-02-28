package com.amap.api.services.geocoder;

import android.os.Handler;
import android.os.Message;

/* compiled from: GeocodeSearch */
/* renamed from: com.amap.api.services.geocoder.b */
class C0505b extends Handler {
    /* renamed from: a */
    final /* synthetic */ GeocodeSearch f3029a;

    C0505b(GeocodeSearch geocodeSearch) {
        this.f3029a = geocodeSearch;
    }

    public void handleMessage(Message message) {
        GeocodeResult geocodeResult = null;
        if (this.f3029a.f3000c != null) {
            if (message.what == 101) {
                RegeocodeResult regeocodeResult;
                if (message.arg2 == 0) {
                    regeocodeResult = (RegeocodeResult) message.obj;
                }
                this.f3029a.f3000c.onRegeocodeSearched(regeocodeResult, message.arg1);
                return;
            }
            if (message.arg2 == 0) {
                geocodeResult = (GeocodeResult) message.obj;
            }
            this.f3029a.f3000c.onGeocodeSearched(geocodeResult, message.arg1);
        }
    }
}
