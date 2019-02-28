package com.amap.api.mapcore;

import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MapMessageQueue */
class am {
    /* renamed from: a */
    AMapDelegateImpGLSurfaceView f1482a;
    /* renamed from: b */
    private CopyOnWriteArrayList<C0338k> f1483b = new CopyOnWriteArrayList();
    /* renamed from: c */
    private CopyOnWriteArrayList<al> f1484c = new CopyOnWriteArrayList();

    public am(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1482a = aMapDelegateImpGLSurfaceView;
    }

    /* renamed from: a */
    public synchronized void m2441a() {
        if (this.f1483b != null) {
            this.f1483b.clear();
            this.f1483b = null;
        }
        if (this.f1484c != null) {
            this.f1484c.clear();
            this.f1484c = null;
        }
    }

    /* renamed from: a */
    public synchronized void m2442a(al alVar) {
        this.f1482a.mo401e(false);
        this.f1484c.add(alVar);
        this.f1482a.mo401e(false);
    }

    /* renamed from: b */
    public al m2444b() {
        if (m2445c() == 0) {
            return null;
        }
        al alVar = (al) this.f1484c.get(0);
        this.f1484c.remove(alVar);
        return alVar;
    }

    /* renamed from: c */
    public synchronized int m2445c() {
        return this.f1484c.size();
    }

    /* renamed from: a */
    public void m2443a(C0338k c0338k) {
        this.f1482a.mo401e(false);
        this.f1483b.add(c0338k);
        this.f1482a.mo401e(false);
    }

    /* renamed from: d */
    public C0338k m2446d() {
        if (m2447e() == 0) {
            return null;
        }
        C0338k c0338k = (C0338k) this.f1483b.get(0);
        this.f1483b.remove(c0338k);
        this.f1482a.mo401e(false);
        return c0338k;
    }

    /* renamed from: e */
    public int m2447e() {
        return this.f1483b.size();
    }
}
