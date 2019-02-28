package com.amap.api.maps;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.mapcore.ae;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

public class Projection {
    /* renamed from: a */
    private final ae f2234a;

    Projection(ae aeVar) {
        this.f2234a = aeVar;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.f2234a.mo501a(point);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.f2234a.mo500a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public PointF toMapLocation(LatLng latLng) {
        try {
            return this.f2234a.mo505b(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public PointF toOpenGLLocation(LatLng latLng) {
        try {
            return this.f2234a.mo505b(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float toOpenGLWidth(int i) {
        try {
            return this.f2234a.mo499a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.f2234a.mo504a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) {
        try {
            return this.f2234a.mo503a(latLngBounds, i, i2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLngBounds getMapBounds(LatLng latLng, float f) {
        try {
            return this.f2234a.mo502a(latLng, f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
