package com.amap.api.mapcore;

import com.amap.api.mapcore.util.az;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: GLOverlayLayer */
/* renamed from: com.amap.api.mapcore.s */
class C0351s implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0350r f1891a;

    C0351s(C0350r c0350r) {
        this.f1891a = c0350r;
    }

    public void run() {
        try {
            synchronized (this.f1891a) {
                Collection arrayList = new ArrayList(this.f1891a.f1888c);
                Collections.sort(arrayList, this.f1891a.f1887a);
                this.f1891a.f1888c = new CopyOnWriteArrayList(arrayList);
            }
        } catch (Throwable th) {
            az.m3143a(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }
}
