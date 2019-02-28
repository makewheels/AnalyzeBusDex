package com.amap.api.navi.model;

/* compiled from: NaviLocation */
/* renamed from: com.amap.api.navi.model.c */
public class C0461c {
    /* renamed from: a */
    public AMapNaviLocation f2771a = new AMapNaviLocation();
    /* renamed from: b */
    private float f2772b;
    /* renamed from: c */
    private float f2773c;
    /* renamed from: d */
    private long f2774d;
    /* renamed from: e */
    private int f2775e;
    /* renamed from: f */
    private NaviLatLng f2776f;

    /* renamed from: a */
    public void m3924a(float f) {
        this.f2772b = f;
        this.f2771a.setBearing(f);
    }

    /* renamed from: b */
    public void m3928b(float f) {
        this.f2773c = f;
        this.f2771a.setSpeed(f);
    }

    /* renamed from: a */
    public void m3926a(long j) {
        this.f2774d = j;
        this.f2771a.setTime(j);
    }

    /* renamed from: a */
    public void m3925a(int i) {
        this.f2775e = i;
        this.f2771a.setMatchStatus(i);
    }

    /* renamed from: a */
    public void m3927a(NaviLatLng naviLatLng) {
        this.f2776f = naviLatLng;
        this.f2771a.setCoord(this.f2776f);
    }
}
