package com.amap.api.services.poisearch;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* compiled from: PoiSearch */
/* renamed from: com.amap.api.services.poisearch.h */
class C0521h extends Handler {
    /* renamed from: a */
    final /* synthetic */ PoiSearch f3155a;

    C0521h(PoiSearch poiSearch) {
        this.f3155a = poiSearch;
    }

    public void handleMessage(Message message) {
        if (this.f3155a.f3138e != null) {
            Bundle data;
            if (message.what == 100) {
                data = message.getData();
                if (data != null) {
                    this.f3155a.f3138e.onPoiSearched((PoiResult) message.obj, data.getInt("errorCode"));
                }
            } else if (message.what == 101) {
                data = message.getData();
                if (data != null) {
                    this.f3155a.f3138e.onPoiItemDetailSearched((PoiItemDetail) message.obj, data.getInt("errorCode"));
                }
            }
        }
    }
}
