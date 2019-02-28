package com.amap.api.maps.model;

import com.amap.api.mapcore.util.C0387h;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: PointQuadTree */
/* renamed from: com.amap.api.maps.model.a */
class C0416a {
    /* renamed from: a */
    private final C0387h f2400a;
    /* renamed from: b */
    private final int f2401b;
    /* renamed from: c */
    private List<WeightedLatLng> f2402c;
    /* renamed from: d */
    private List<C0416a> f2403d;

    protected C0416a(C0387h c0387h) {
        this(c0387h, 0);
    }

    private C0416a(double d, double d2, double d3, double d4, int i) {
        this(new C0387h(d, d2, d3, d4), i);
    }

    private C0416a(C0387h c0387h, int i) {
        this.f2403d = null;
        this.f2400a = c0387h;
        this.f2401b = i;
    }

    /* renamed from: a */
    protected void m3587a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f2400a.m3326a(point.f3635x, point.f3636y)) {
            m3584a(point.f3635x, point.f3636y, weightedLatLng);
        }
    }

    /* renamed from: a */
    private void m3584a(double d, double d2, WeightedLatLng weightedLatLng) {
        if (this.f2403d == null) {
            if (this.f2402c == null) {
                this.f2402c = new ArrayList();
            }
            this.f2402c.add(weightedLatLng);
            if (this.f2402c.size() > 50 && this.f2401b < 40) {
                m3583a();
            }
        } else if (d2 < this.f2400a.f2133f) {
            if (d < this.f2400a.f2132e) {
                ((C0416a) this.f2403d.get(0)).m3584a(d, d2, weightedLatLng);
            } else {
                ((C0416a) this.f2403d.get(1)).m3584a(d, d2, weightedLatLng);
            }
        } else if (d < this.f2400a.f2132e) {
            ((C0416a) this.f2403d.get(2)).m3584a(d, d2, weightedLatLng);
        } else {
            ((C0416a) this.f2403d.get(3)).m3584a(d, d2, weightedLatLng);
        }
    }

    /* renamed from: a */
    private void m3583a() {
        this.f2403d = new ArrayList(4);
        this.f2403d.add(new C0416a(this.f2400a.f2128a, this.f2400a.f2132e, this.f2400a.f2129b, this.f2400a.f2133f, this.f2401b + 1));
        this.f2403d.add(new C0416a(this.f2400a.f2132e, this.f2400a.f2130c, this.f2400a.f2129b, this.f2400a.f2133f, this.f2401b + 1));
        this.f2403d.add(new C0416a(this.f2400a.f2128a, this.f2400a.f2132e, this.f2400a.f2133f, this.f2400a.f2131d, this.f2401b + 1));
        this.f2403d.add(new C0416a(this.f2400a.f2132e, this.f2400a.f2130c, this.f2400a.f2133f, this.f2400a.f2131d, this.f2401b + 1));
        List<WeightedLatLng> list = this.f2402c;
        this.f2402c = null;
        for (WeightedLatLng weightedLatLng : list) {
            m3584a(weightedLatLng.getPoint().f3635x, weightedLatLng.getPoint().f3636y, weightedLatLng);
        }
    }

    /* renamed from: a */
    protected Collection<WeightedLatLng> m3586a(C0387h c0387h) {
        Collection<WeightedLatLng> arrayList = new ArrayList();
        m3585a(c0387h, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m3585a(C0387h c0387h, Collection<WeightedLatLng> collection) {
        if (!this.f2400a.m3328a(c0387h)) {
            return;
        }
        if (this.f2403d != null) {
            for (C0416a a : this.f2403d) {
                a.m3585a(c0387h, collection);
            }
        } else if (this.f2402c == null) {
        } else {
            if (c0387h.m3330b(this.f2400a)) {
                collection.addAll(this.f2402c);
                return;
            }
            for (WeightedLatLng weightedLatLng : this.f2402c) {
                if (c0387h.m3329a(weightedLatLng.getPoint())) {
                    collection.add(weightedLatLng);
                }
            }
        }
    }
}
