package com.amap.api.mapcore;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: CameraUpdateFactoryDelegate */
/* renamed from: com.amap.api.mapcore.k */
public class C0338k {
    /* renamed from: a */
    C0337a f1836a = C0337a.none;
    /* renamed from: b */
    float f1837b;
    /* renamed from: c */
    float f1838c;
    /* renamed from: d */
    float f1839d;
    /* renamed from: e */
    float f1840e;
    /* renamed from: f */
    float f1841f;
    /* renamed from: g */
    float f1842g;
    /* renamed from: h */
    CameraPosition f1843h;
    /* renamed from: i */
    LatLngBounds f1844i;
    /* renamed from: j */
    int f1845j;
    /* renamed from: k */
    int f1846k;
    /* renamed from: l */
    int f1847l;
    /* renamed from: m */
    Point f1848m = null;
    /* renamed from: n */
    boolean f1849n = false;
    /* renamed from: o */
    IPoint f1850o;
    /* renamed from: p */
    boolean f1851p = false;

    /* compiled from: CameraUpdateFactoryDelegate */
    /* renamed from: com.amap.api.mapcore.k$a */
    enum C0337a {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    private C0338k() {
    }

    /* renamed from: a */
    public static C0338k m2875a() {
        return new C0338k();
    }

    /* renamed from: b */
    public static C0338k m2887b() {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.zoomIn;
        return a;
    }

    /* renamed from: c */
    public static C0338k m2889c() {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.zoomOut;
        return a;
    }

    /* renamed from: a */
    public static C0338k m2877a(float f, float f2) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.scrollBy;
        a.f1837b = f;
        a.f1838c = f2;
        return a;
    }

    /* renamed from: a */
    public static C0338k m2876a(float f) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.zoomTo;
        a.f1839d = f;
        return a;
    }

    /* renamed from: b */
    public static C0338k m2888b(float f) {
        return C0338k.m2878a(f, null);
    }

    /* renamed from: a */
    public static C0338k m2878a(float f, Point point) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.zoomBy;
        a.f1840e = f;
        a.f1848m = point;
        return a;
    }

    /* renamed from: a */
    public static C0338k m2879a(CameraPosition cameraPosition) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.newCameraPosition;
        a.f1843h = cameraPosition;
        return a;
    }

    /* renamed from: a */
    public static C0338k m2885a(IPoint iPoint) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.changeCenter;
        a.f1850o = iPoint;
        return a;
    }

    /* renamed from: c */
    public static C0338k m2890c(float f) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.changeTilt;
        a.f1841f = f;
        return a;
    }

    /* renamed from: d */
    public static C0338k m2891d(float f) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.changeBearing;
        a.f1842g = f;
        return a;
    }

    /* renamed from: a */
    public static C0338k m2880a(LatLng latLng) {
        return C0338k.m2879a(CameraPosition.builder().target(latLng).build());
    }

    /* renamed from: a */
    public static C0338k m2881a(LatLng latLng, float f) {
        return C0338k.m2879a(CameraPosition.builder().target(latLng).zoom(f).build());
    }

    /* renamed from: a */
    public static C0338k m2882a(LatLng latLng, float f, float f2, float f3) {
        return C0338k.m2879a(CameraPosition.builder().target(latLng).zoom(f).bearing(f2).tilt(f3).build());
    }

    /* renamed from: a */
    static C0338k m2886a(IPoint iPoint, float f, float f2, float f3) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.changeGeoCenterZoomTiltBearing;
        a.f1850o = iPoint;
        a.f1839d = f;
        a.f1842g = f2;
        a.f1841f = f3;
        return a;
    }

    /* renamed from: a */
    public static C0338k m2883a(LatLngBounds latLngBounds, int i) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.newLatLngBounds;
        a.f1844i = latLngBounds;
        a.f1845j = i;
        return a;
    }

    /* renamed from: a */
    public static C0338k m2884a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        C0338k a = C0338k.m2875a();
        a.f1836a = C0337a.newLatLngBoundsWithSize;
        a.f1844i = latLngBounds;
        a.f1845j = i3;
        a.f1846k = i;
        a.f1847l = i2;
        return a;
    }
}
