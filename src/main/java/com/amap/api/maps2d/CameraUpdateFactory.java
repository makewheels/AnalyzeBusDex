package com.amap.api.maps2d;

import android.graphics.Point;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.p015a.C0262t;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        return new CameraUpdate(C0262t.m1697b());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(C0262t.m1700c());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(C0262t.m1688a(f, f2));
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(C0262t.m1687a(f));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(C0262t.m1698b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(C0262t.m1689a(f, point));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(C0262t.m1690a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(C0262t.m1699b(latLng));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        return new CameraUpdate(C0262t.m1692a(latLng, f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return new CameraUpdate(C0262t.m1694a(latLngBounds, i));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        return new CameraUpdate(C0262t.m1691a(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        return new CameraUpdate(C0262t.m1695a(latLngBounds, i, i2, i3));
    }
}
