package com.amap.api.mapcore;

import com.amap.api.mapcore.util.az;

/* compiled from: MapOverlayImageView */
class ap implements Runnable {
    /* renamed from: a */
    final /* synthetic */ an f1496a;

    ap(an anVar) {
        this.f1496a = anVar;
    }

    public void run() {
        try {
            this.f1496a.f1485a.mo412k();
        } catch (Throwable th) {
            az.m3143a(th, "MapOverlayImageView", "redrawInfoWindow post");
            th.printStackTrace();
        }
    }
}
