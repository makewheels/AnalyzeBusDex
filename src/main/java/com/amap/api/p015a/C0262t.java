package com.amap.api.p015a;

import android.graphics.Point;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.autonavi.amap.mapcore2d.IPoint;

/* compiled from: CameraUpdateFactoryDelegate */
/* renamed from: com.amap.api.a.t */
public class C0262t {
    /* renamed from: a */
    C0261a f1137a = C0261a.none;
    /* renamed from: b */
    float f1138b;
    /* renamed from: c */
    float f1139c;
    /* renamed from: d */
    float f1140d;
    /* renamed from: e */
    float f1141e;
    /* renamed from: f */
    float f1142f;
    /* renamed from: g */
    float f1143g;
    /* renamed from: h */
    CameraPosition f1144h;
    /* renamed from: i */
    LatLngBounds f1145i;
    /* renamed from: j */
    int f1146j;
    /* renamed from: k */
    int f1147k;
    /* renamed from: l */
    int f1148l;
    /* renamed from: m */
    Point f1149m = null;
    /* renamed from: n */
    IPoint f1150n;
    /* renamed from: o */
    boolean f1151o = false;

    /* compiled from: CameraUpdateFactoryDelegate */
    /* renamed from: com.amap.api.a.t$a */
    enum C0261a {
        none,
        zoomIn,
        changeCenter,
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

    private C0262t() {
    }

    /* renamed from: a */
    public static C0262t m1686a() {
        return new C0262t();
    }

    /* renamed from: b */
    public static C0262t m1697b() {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.zoomIn;
        return a;
    }

    /* renamed from: c */
    public static C0262t m1700c() {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.zoomOut;
        return a;
    }

    /* renamed from: a */
    public static C0262t m1688a(float f, float f2) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.scrollBy;
        a.f1138b = f;
        a.f1139c = f2;
        return a;
    }

    /* renamed from: a */
    public static C0262t m1687a(float f) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.zoomTo;
        a.f1140d = f;
        return a;
    }

    /* renamed from: b */
    public static C0262t m1698b(float f) {
        return C0262t.m1689a(f, null);
    }

    /* renamed from: a */
    public static C0262t m1689a(float f, Point point) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.zoomBy;
        a.f1141e = f;
        a.f1149m = point;
        return a;
    }

    /* renamed from: a */
    public static C0262t m1690a(CameraPosition cameraPosition) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.newCameraPosition;
        a.f1144h = cameraPosition;
        return a;
    }

    /* renamed from: a */
    public static C0262t m1691a(LatLng latLng) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.changeCenter;
        a.f1144h = new CameraPosition(latLng, 0.0f, 0.0f, 0.0f);
        return a;
    }

    /* renamed from: b */
    public static C0262t m1699b(LatLng latLng) {
        return C0262t.m1690a(CameraPosition.builder().target(latLng).build());
    }

    /* renamed from: a */
    public static C0262t m1692a(LatLng latLng, float f) {
        return C0262t.m1690a(CameraPosition.builder().target(latLng).zoom(f).build());
    }

    /* renamed from: a */
    public static C0262t m1693a(LatLng latLng, float f, float f2, float f3) {
        return C0262t.m1690a(CameraPosition.builder().target(latLng).zoom(f).bearing(f2).tilt(f3).build());
    }

    /* renamed from: a */
    static C0262t m1696a(IPoint iPoint, float f, float f2, float f3) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.changeGeoCenterZoomTiltBearing;
        a.f1150n = iPoint;
        a.f1140d = f;
        a.f1143g = f2;
        a.f1142f = f3;
        return a;
    }

    /* renamed from: a */
    public static C0262t m1694a(LatLngBounds latLngBounds, int i) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.newLatLngBounds;
        a.f1145i = latLngBounds;
        a.f1146j = i;
        return a;
    }

    /* renamed from: a */
    public static C0262t m1695a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        C0262t a = C0262t.m1686a();
        a.f1137a = C0261a.newLatLngBoundsWithSize;
        a.f1145i = latLngBounds;
        a.f1146j = i3;
        a.f1147k = i;
        a.f1148l = i2;
        return a;
    }
}
