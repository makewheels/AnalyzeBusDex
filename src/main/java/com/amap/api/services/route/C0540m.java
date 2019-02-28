package com.amap.api.services.route;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* compiled from: RouteSearch */
/* renamed from: com.amap.api.services.route.m */
class C0540m extends Handler {
    /* renamed from: a */
    final /* synthetic */ RouteSearch f3253a;

    C0540m(RouteSearch routeSearch) {
        this.f3253a = routeSearch;
    }

    public void handleMessage(Message message) {
        if (this.f3253a.f3237b != null) {
            Bundle data;
            if (message.what == 10) {
                data = message.getData();
                if (data != null) {
                    this.f3253a.f3237b.onBusRouteSearched((BusRouteResult) message.obj, data.getInt("errorCode"));
                }
            } else if (message.what == 11) {
                data = message.getData();
                if (data != null) {
                    this.f3253a.f3237b.onDriveRouteSearched((DriveRouteResult) message.obj, data.getInt("errorCode"));
                }
            } else if (message.what == 12) {
                data = message.getData();
                if (data != null) {
                    this.f3253a.f3237b.onWalkRouteSearched((WalkRouteResult) message.obj, data.getInt("errorCode"));
                }
            }
        }
    }
}
