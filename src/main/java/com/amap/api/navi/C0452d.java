package com.amap.api.navi;

import android.location.Location;
import android.os.Handler;
import android.os.Message;

/* compiled from: GPSManager */
/* renamed from: com.amap.api.navi.d */
class C0452d extends Handler {
    /* renamed from: a */
    final /* synthetic */ C0451c f2709a;

    C0452d(C0451c c0451c) {
        this.f2709a = c0451c;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        Location location = (Location) message.obj;
        this.f2709a.f2695e.m3881a(2, location.getLongitude(), location.getLatitude());
        this.f2709a.f2695e.m3882a(2, location);
    }
}
