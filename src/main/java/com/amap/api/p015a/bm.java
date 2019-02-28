package com.amap.api.p015a;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.VisibleRegion;
import com.autonavi.amap.mapcore2d.DPoint;
import com.autonavi.amap.mapcore2d.FPoint;
import com.autonavi.amap.mapcore2d.IPoint;

/* compiled from: ProjectionDelegateImp */
/* renamed from: com.amap.api.a.bm */
class bm implements an {
    /* renamed from: a */
    private af f903a;

    public bm(af afVar) {
        this.f903a = afVar;
    }

    /* renamed from: a */
    public LatLng mo205a(Point point) throws RemoteException {
        DPoint dPoint = new DPoint();
        this.f903a.mo89a(point.x, point.y, dPoint);
        return new LatLng(dPoint.f3649y, dPoint.f3648x);
    }

    /* renamed from: a */
    public Point mo204a(LatLng latLng) throws RemoteException {
        IPoint iPoint = new IPoint();
        this.f903a.mo115b(latLng.latitude, latLng.longitude, iPoint);
        return new Point(iPoint.f3652x, iPoint.f3653y);
    }

    /* renamed from: a */
    public VisibleRegion mo206a() throws RemoteException {
        int c = this.f903a.mo121c();
        int d = this.f903a.mo125d();
        LatLng a = mo205a(new Point(0, 0));
        LatLng a2 = mo205a(new Point(c, 0));
        LatLng a3 = mo205a(new Point(0, d));
        LatLng a4 = mo205a(new Point(c, d));
        return new VisibleRegion(a3, a4, a, a2, LatLngBounds.builder().include(a3).include(a4).include(a).include(a2).build());
    }

    /* renamed from: b */
    public PointF mo207b(LatLng latLng) throws RemoteException {
        FPoint fPoint = new FPoint();
        this.f903a.mo87a(latLng.latitude, latLng.longitude, fPoint);
        return new PointF(fPoint.f3650x, fPoint.f3651y);
    }
}
