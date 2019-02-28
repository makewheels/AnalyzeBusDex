package com.amap.api.services.district;

import android.os.Handler;
import android.os.Message;

/* compiled from: DistrictSearch */
/* renamed from: com.amap.api.services.district.c */
class C0500c extends Handler {
    /* renamed from: a */
    final /* synthetic */ DistrictSearch f2979a;

    C0500c(DistrictSearch districtSearch) {
        this.f2979a = districtSearch;
    }

    public void handleMessage(Message message) {
        if (this.f2979a.f2970d != null) {
            this.f2979a.f2970d.onDistrictSearched((DistrictResult) message.obj);
        }
    }
}
