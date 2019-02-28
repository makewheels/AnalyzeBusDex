package com.amap.api.p015a;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.VisibleRegion;

/* compiled from: IProjectionDelegate */
/* renamed from: com.amap.api.a.an */
public interface an {
    /* renamed from: a */
    Point mo204a(LatLng latLng) throws RemoteException;

    /* renamed from: a */
    LatLng mo205a(Point point) throws RemoteException;

    /* renamed from: a */
    VisibleRegion mo206a() throws RemoteException;

    /* renamed from: b */
    PointF mo207b(LatLng latLng) throws RemoteException;
}
