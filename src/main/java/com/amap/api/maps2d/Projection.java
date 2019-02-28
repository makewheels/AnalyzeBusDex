package com.amap.api.maps2d;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.maps2d.model.VisibleRegion;
import com.amap.api.p015a.an;

public class Projection {
    /* renamed from: a */
    private final an f2565a;

    Projection(an anVar) {
        this.f2565a = anVar;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.f2565a.mo205a(point);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.f2565a.mo204a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public PointF toMapLocation(LatLng latLng) {
        try {
            return this.f2565a.mo207b(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.f2565a.mo206a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
