package com.amap.api.maps.model;

public class RoutePara {
    /* renamed from: a */
    private int f2365a = 0;
    /* renamed from: b */
    private int f2366b = 0;
    /* renamed from: c */
    private LatLng f2367c;
    /* renamed from: d */
    private LatLng f2368d;
    /* renamed from: e */
    private String f2369e;
    /* renamed from: f */
    private String f2370f;

    public int getDrivingRouteStyle() {
        return this.f2365a;
    }

    public void setDrivingRouteStyle(int i) {
        if (i >= 0 && i < 9) {
            this.f2365a = i;
        }
    }

    public int getTransitRouteStyle() {
        return this.f2366b;
    }

    public void setTransitRouteStyle(int i) {
        if (i >= 0 && i < 6) {
            this.f2366b = i;
        }
    }

    public LatLng getStartPoint() {
        return this.f2367c;
    }

    public void setStartPoint(LatLng latLng) {
        this.f2367c = latLng;
    }

    public LatLng getEndPoint() {
        return this.f2368d;
    }

    public void setEndPoint(LatLng latLng) {
        this.f2368d = latLng;
    }

    public String getEndName() {
        return this.f2370f;
    }

    public void setEndName(String str) {
        this.f2370f = str;
    }

    public String getStartName() {
        return this.f2369e;
    }

    public void setStartName(String str) {
        this.f2369e = str;
    }
}
