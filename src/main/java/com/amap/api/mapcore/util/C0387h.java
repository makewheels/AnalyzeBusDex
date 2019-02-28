package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;

/* compiled from: Bounds */
/* renamed from: com.amap.api.mapcore.util.h */
public class C0387h {
    /* renamed from: a */
    public final double f2128a;
    /* renamed from: b */
    public final double f2129b;
    /* renamed from: c */
    public final double f2130c;
    /* renamed from: d */
    public final double f2131d;
    /* renamed from: e */
    public final double f2132e;
    /* renamed from: f */
    public final double f2133f;

    public C0387h(double d, double d2, double d3, double d4) {
        this.f2128a = d;
        this.f2129b = d3;
        this.f2130c = d2;
        this.f2131d = d4;
        this.f2132e = (d + d2) / 2.0d;
        this.f2133f = (d3 + d4) / 2.0d;
    }

    /* renamed from: a */
    public boolean m3326a(double d, double d2) {
        return this.f2128a <= d && d <= this.f2130c && this.f2129b <= d2 && d2 <= this.f2131d;
    }

    /* renamed from: a */
    public boolean m3329a(DPoint dPoint) {
        return m3326a(dPoint.f3635x, dPoint.f3636y);
    }

    /* renamed from: a */
    public boolean m3327a(double d, double d2, double d3, double d4) {
        return d < this.f2130c && this.f2128a < d2 && d3 < this.f2131d && this.f2129b < d4;
    }

    /* renamed from: a */
    public boolean m3328a(C0387h c0387h) {
        return m3327a(c0387h.f2128a, c0387h.f2130c, c0387h.f2129b, c0387h.f2131d);
    }

    /* renamed from: b */
    public boolean m3330b(C0387h c0387h) {
        return c0387h.f2128a >= this.f2128a && c0387h.f2130c <= this.f2130c && c0387h.f2129b >= this.f2129b && c0387h.f2131d <= this.f2131d;
    }
}
