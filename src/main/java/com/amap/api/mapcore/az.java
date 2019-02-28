package com.amap.api.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: ProjectionDelegateImp */
class az implements ae {
    /* renamed from: a */
    private C0313u f1618a;

    public az(C0313u c0313u) {
        this.f1618a = c0313u;
    }

    /* renamed from: a */
    public LatLng mo501a(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint dPoint = new DPoint();
        this.f1618a.mo359a(point.x, point.y, dPoint);
        return new LatLng(dPoint.f3636y, dPoint.f3635x);
    }

    /* renamed from: a */
    public Point mo500a(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint iPoint = new IPoint();
        this.f1618a.mo387b(latLng.latitude, latLng.longitude, iPoint);
        return new Point(iPoint.f3639x, iPoint.f3640y);
    }

    /* renamed from: a */
    public VisibleRegion mo504a() throws RemoteException {
        int h = this.f1618a.mo406h();
        int i = this.f1618a.mo409i();
        LatLng a = mo501a(new Point(0, 0));
        LatLng a2 = mo501a(new Point(h, 0));
        LatLng a3 = mo501a(new Point(0, i));
        LatLng a4 = mo501a(new Point(h, i));
        return new VisibleRegion(a3, a4, a, a2, LatLngBounds.builder().include(a3).include(a4).include(a).include(a2).build());
    }

    /* renamed from: b */
    public PointF mo505b(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint fPoint = new FPoint();
        this.f1618a.mo352a(latLng.latitude, latLng.longitude, fPoint);
        return new PointF(fPoint.f3637x, fPoint.f3638y);
    }

    /* renamed from: a */
    public float mo499a(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        return this.f1618a.mo394c(i);
    }

    /* renamed from: a */
    public TileProjection mo503a(LatLngBounds latLngBounds, int i, int i2) throws RemoteException {
        if (latLngBounds == null || i < 0 || i > 20 || i2 <= 0) {
            return null;
        }
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        this.f1618a.mo353a(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, iPoint);
        this.f1618a.mo353a(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, iPoint2);
        int i3 = (iPoint.f3639x >> (20 - i)) / i2;
        int i4 = (iPoint2.f3640y >> (20 - i)) / i2;
        return new TileProjection((iPoint.f3639x - ((i3 << (20 - i)) * i2)) >> (20 - i), (iPoint2.f3640y - ((i4 << (20 - i)) * i2)) >> (20 - i), i3, (iPoint2.f3639x >> (20 - i)) / i2, i4, (iPoint.f3640y >> (20 - i)) / i2);
    }

    /* renamed from: a */
    public LatLngBounds mo502a(LatLng latLng, float f) throws RemoteException {
        if (this.f1618a == null || latLng == null) {
            return null;
        }
        return this.f1618a.mo347a(latLng, C0405u.m3473b(f));
    }
}
