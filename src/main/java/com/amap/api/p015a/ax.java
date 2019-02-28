package com.amap.api.p015a;

import com.amap.api.mapcore2d.MapMessage;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MapMessageQueue */
/* renamed from: com.amap.api.a.ax */
class ax {
    /* renamed from: a */
    C0222b f676a;
    /* renamed from: b */
    private CopyOnWriteArrayList<C0262t> f677b = new CopyOnWriteArrayList();
    /* renamed from: c */
    private CopyOnWriteArrayList<MapMessage> f678c = new CopyOnWriteArrayList();

    public ax(C0222b c0222b) {
        this.f676a = c0222b;
    }

    /* renamed from: a */
    public void m1108a(C0262t c0262t) {
        this.f677b.add(c0262t);
    }
}
