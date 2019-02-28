package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.mapcore.C0338k;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        return new CameraUpdate(C0338k.m2887b());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(C0338k.m2889c());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(C0338k.m2877a(f, f2));
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(C0338k.m2876a(f));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(C0338k.m2888b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(C0338k.m2878a(f, point));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(C0338k.m2879a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(C0338k.m2880a(latLng));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        return new CameraUpdate(C0338k.m2881a(latLng, f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return new CameraUpdate(C0338k.m2883a(latLngBounds, i));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        return new CameraUpdate(C0338k.m2885a(iPoint));
    }

    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(C0338k.m2891d(f % 360.0f));
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(C0338k.m2890c(f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        return new CameraUpdate(C0338k.m2884a(latLngBounds, i, i2, i3));
    }
}
