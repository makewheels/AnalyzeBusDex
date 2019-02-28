package com.amap.api.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

/* compiled from: IProjectionDelegate */
public interface ae {
    /* renamed from: a */
    float mo499a(int i) throws RemoteException;

    /* renamed from: a */
    Point mo500a(LatLng latLng) throws RemoteException;

    /* renamed from: a */
    LatLng mo501a(Point point) throws RemoteException;

    /* renamed from: a */
    LatLngBounds mo502a(LatLng latLng, float f) throws RemoteException;

    /* renamed from: a */
    TileProjection mo503a(LatLngBounds latLngBounds, int i, int i2) throws RemoteException;

    /* renamed from: a */
    VisibleRegion mo504a() throws RemoteException;

    /* renamed from: b */
    PointF mo505b(LatLng latLng) throws RemoteException;
}
