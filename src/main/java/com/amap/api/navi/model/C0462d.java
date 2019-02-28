package com.amap.api.navi.model;

import com.amap.api.maps.model.LatLngBounds;
import java.util.List;

/* compiled from: NaviPath */
/* renamed from: com.amap.api.navi.model.d */
public class C0462d {
    /* renamed from: a */
    public AMapNaviPath f2777a = new AMapNaviPath();
    /* renamed from: b */
    public NaviLatLng f2778b;
    /* renamed from: c */
    public LatLngBounds f2779c;
    /* renamed from: d */
    private int f2780d;
    /* renamed from: e */
    private int f2781e;
    /* renamed from: f */
    private int f2782f;
    /* renamed from: g */
    private int f2783g;
    /* renamed from: h */
    private List<AMapNaviStep> f2784h;
    /* renamed from: i */
    private List<NaviLatLng> f2785i;
    /* renamed from: j */
    private NaviLatLng f2786j;
    /* renamed from: k */
    private NaviLatLng f2787k;
    /* renamed from: l */
    private List<NaviLatLng> f2788l;
    /* renamed from: m */
    private NaviLatLng f2789m = new NaviLatLng(0.0d, 0.0d);
    /* renamed from: n */
    private NaviLatLng f2790n = new NaviLatLng(2.147483647E9d, 2.147483647E9d);
    /* renamed from: o */
    private int f2791o = 0;

    /* renamed from: a */
    public void m3933a(List<NaviLatLng> list) {
        this.f2788l = list;
        this.f2777a.setWayPoint(list);
    }

    /* renamed from: a */
    public void m3932a(NaviLatLng naviLatLng) {
        this.f2786j = naviLatLng;
        this.f2777a.setStartPoint(naviLatLng);
    }

    /* renamed from: b */
    public void m3936b(NaviLatLng naviLatLng) {
        this.f2787k = naviLatLng;
        this.f2777a.setEndPoint(naviLatLng);
    }

    /* renamed from: a */
    public NaviLatLng m3929a() {
        return this.f2789m;
    }

    /* renamed from: b */
    public NaviLatLng m3934b() {
        return this.f2790n;
    }

    /* renamed from: c */
    public void m3939c(NaviLatLng naviLatLng) {
        this.f2778b = naviLatLng;
        this.f2777a.setCenter(naviLatLng);
    }

    /* renamed from: a */
    public void m3931a(LatLngBounds latLngBounds) {
        this.f2779c = latLngBounds;
        this.f2777a.setBounds(latLngBounds);
    }

    /* renamed from: b */
    public void m3937b(List<AMapNaviStep> list) {
        this.f2784h = list;
        this.f2777a.setListStep(list);
    }

    /* renamed from: c */
    public void m3940c(List<NaviLatLng> list) {
        this.f2785i = list;
        this.f2777a.setList(list);
    }

    /* renamed from: a */
    public void m3930a(int i) {
        this.f2780d = i;
        this.f2777a.setAllLength(i);
    }

    /* renamed from: b */
    public void m3935b(int i) {
        this.f2781e = i;
        this.f2777a.setStrategy(i);
    }

    /* renamed from: c */
    public void m3938c(int i) {
        this.f2782f = i;
        this.f2777a.setAllTime(i);
    }

    /* renamed from: d */
    public void m3941d(int i) {
        this.f2783g = i;
        this.f2777a.setStepsCount(i);
    }

    /* renamed from: e */
    public void m3942e(int i) {
        this.f2791o = i;
        this.f2777a.setTollCost(this.f2791o);
    }
}
