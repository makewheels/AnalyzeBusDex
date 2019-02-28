package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Point;
import android.os.Message;
import android.os.RemoteException;
import com.amap.api.mapcore.C0338k.C0337a;
import com.amap.api.mapcore.util.C0399o;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.BaseMapCallImplement;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapProjection;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: AMapCallback */
/* renamed from: com.amap.api.mapcore.a */
class C0315a extends BaseMapCallImplement {
    /* renamed from: a */
    IPoint f1453a = new IPoint();
    /* renamed from: b */
    float f1454b;
    /* renamed from: c */
    float f1455c;
    /* renamed from: d */
    float f1456d;
    /* renamed from: e */
    IPoint f1457e = new IPoint();
    /* renamed from: f */
    private AMapDelegateImpGLSurfaceView f1458f;
    /* renamed from: g */
    private float f1459g = -1.0f;
    /* renamed from: h */
    private int f1460h;
    /* renamed from: i */
    private int f1461i;

    public String getMapSvrAddress() {
        return "http://mm.amap.com";
    }

    public C0315a(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1458f = aMapDelegateImpGLSurfaceView;
    }

    public void OnMapSurfaceCreate(GL10 gl10, MapCore mapCore) {
        super.OnMapSurfaceCreate(mapCore);
    }

    public void OnMapSurfaceRenderer(GL10 gl10, MapCore mapCore, int i) {
        if (i == 3) {
            this.f1458f.f1431g.m2944a(gl10, true, this.f1458f.mo337L());
            if (this.f1458f.f1430f != null) {
                this.f1458f.f1430f.onDrawFrame(gl10);
            }
        }
    }

    public void OnMapSufaceChanged(GL10 gl10, MapCore mapCore, int i, int i2) {
    }

    public void OnMapProcessEvent(MapCore mapCore) {
        float f = 0.0f;
        if (this.f1458f != null && this.f1458f.m2192J()) {
            this.f1458f.m2193K();
        }
        if (this.f1458f != null) {
            float z = this.f1458f.mo430z();
            m2313a(mapCore);
            while (true) {
                al b = this.f1458f.f1425a.m2444b();
                if (b == null) {
                    break;
                }
                if (b.f1480a == 2) {
                    if (b.m2440a()) {
                        mapCore.setParameter(2010, 4, 0, 0, 0);
                    } else {
                        mapCore.setParameter(2010, 0, 0, 0, 0);
                    }
                }
                if (b.f1480a == 2011) {
                    if (b.f1481b) {
                        mapCore.setParameter(2011, 3, 0, 0, 0);
                    } else {
                        mapCore.setParameter(2011, 0, 0, 0, 0);
                    }
                } else if (b.f1480a == 2012) {
                    this.f1458f.m2281k(b.f1481b);
                }
            }
            mapCore.setMapstate(this.f1458f.mo395c());
            if (!(this.f1454b < this.f1458f.mo416n() || this.f1459g == z || this.f1458f.f1433i == null)) {
                this.f1458f.f1433i.obtainMessage(21).sendToTarget();
            }
            f = z;
        }
        this.f1459g = f;
    }

    /* renamed from: a */
    void m2313a(MapCore mapCore) {
        Object obj = null;
        MapProjection c = this.f1458f.mo395c();
        float mapZoomer = c.getMapZoomer();
        float cameraHeaderAngle = c.getCameraHeaderAngle();
        float mapAngle = c.getMapAngle();
        c.getGeoCenter(this.f1457e);
        int i = 0;
        while (true) {
            C0338k d = this.f1458f.f1425a.m2446d();
            if (d == null) {
                break;
            }
            try {
                m2312a(d);
                i = d.f1851p | i;
            } catch (Throwable e) {
                az.m3143a(e, "AMapCallback", "runMessage");
                e.printStackTrace();
            }
        }
        this.f1454b = c.getMapZoomer();
        this.f1455c = c.getCameraHeaderAngle();
        this.f1456d = c.getMapAngle();
        c.getGeoCenter(this.f1453a);
        if (!(mapZoomer == this.f1454b && this.f1455c == cameraHeaderAngle && this.f1456d == mapAngle && this.f1453a.f3639x == this.f1457e.f3639x && this.f1453a.f3640y == this.f1457e.f3640y)) {
            obj = 1;
        }
        if (obj != null) {
            try {
                this.f1458f.mo401e(false);
                if (this.f1458f.m2294w() != null) {
                    DPoint dPoint = new DPoint();
                    MapProjection.geo2LonLat(this.f1453a.f3639x, this.f1453a.f3640y, dPoint);
                    this.f1458f.m2243a(new CameraPosition(new LatLng(dPoint.f3636y, dPoint.f3635x, false), this.f1454b, this.f1455c, this.f1456d));
                }
                this.f1458f.m2183A();
            } catch (Throwable e2) {
                az.m3143a(e2, "AMapCallback", "runMessage cameraChange");
                e2.printStackTrace();
                return;
            }
        }
        this.f1458f.mo401e(true);
        if (i != 0) {
            if (i != 0) {
                this.f1458f.m2279j(true);
            } else {
                this.f1458f.m2279j(false);
            }
            Message message = new Message();
            message.what = 17;
            this.f1458f.f1433i.sendMessage(message);
        }
        if (!(this.f1455c == cameraHeaderAngle && this.f1456d == mapAngle) && this.f1458f.mo426u().mo542c()) {
            this.f1458f.m2264e();
        }
        if (mapZoomer != this.f1454b && this.f1458f.mo426u().mo537a()) {
            this.f1458f.m2267f();
        }
    }

    /* renamed from: b */
    private void m2307b(C0338k c0338k) {
        MapCore a = this.f1458f.m2209a();
        MapProjection c = this.f1458f.mo395c();
        LatLngBounds latLngBounds = c0338k.f1844i;
        int i = c0338k.f1846k;
        int i2 = c0338k.f1847l;
        int i3 = c0338k.f1845j;
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.northeast.latitude, iPoint);
        MapProjection.lonlat2Geo(latLngBounds.southwest.longitude, latLngBounds.southwest.latitude, iPoint2);
        int i4 = iPoint2.f3640y - iPoint.f3640y;
        int i5 = i - (i3 * 2);
        i = i2 - (i3 * 2);
        if (iPoint.f3639x - iPoint2.f3639x >= 0 || i4 >= 0) {
            if (i5 <= 0) {
                i5 = 1;
            }
            if (i <= 0) {
                i = 1;
            }
            float a2 = m2298a(latLngBounds.northeast, latLngBounds.southwest, i5, i);
            i5 = (iPoint.f3639x + iPoint2.f3639x) / 2;
            int i6 = (iPoint.f3640y + iPoint2.f3640y) / 2;
            c.setMapZoomer(a2);
            c.setGeoCenter(i5, i6);
            c.setCameraHeaderAngle(0.0f);
            c.setMapAngle(0.0f);
            a.setMapstate(c);
        }
    }

    /* renamed from: a */
    private float m2298a(LatLng latLng, LatLng latLng2, int i, int i2) {
        Object obj;
        float b;
        MapProjection c = this.f1458f.mo395c();
        c.setMapAngle(0.0f);
        c.setCameraHeaderAngle(0.0f);
        c.recalculate();
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        this.f1458f.mo387b(latLng.latitude, latLng.longitude, iPoint);
        this.f1458f.mo387b(latLng2.latitude, latLng2.longitude, iPoint2);
        double d = (double) (iPoint.f3639x - iPoint2.f3639x);
        double d2 = (double) (iPoint2.f3640y - iPoint.f3640y);
        if (d <= 0.0d) {
            d = 1.0d;
        }
        if (d2 <= 0.0d) {
            d2 = 1.0d;
        }
        d = Math.log(((double) i) / d) / Math.log(2.0d);
        double min = Math.min(d, Math.log(((double) i2) / d2) / Math.log(2.0d));
        if (Math.abs(min - d) < 1.0E-7d) {
            obj = 1;
        } else {
            obj = null;
        }
        float b2 = C0405u.m3473b((float) (((double) c.getMapZoomer()) + Math.floor(min)));
        while (true) {
            b = C0405u.m3473b((float) (((double) b2) + 0.1d));
            c.setMapZoomer(b);
            c.recalculate();
            this.f1458f.mo387b(latLng.latitude, latLng.longitude, iPoint);
            this.f1458f.mo387b(latLng2.latitude, latLng2.longitude, iPoint2);
            d2 = (double) (iPoint.f3639x - iPoint2.f3639x);
            d = (double) (iPoint2.f3640y - iPoint.f3640y);
            if (obj != null) {
                if (d2 >= ((double) i)) {
                    break;
                }
                if (b < 20.0f) {
                    return b;
                }
                b2 = b;
            } else {
                if (d >= ((double) i2)) {
                    break;
                }
                if (b < 20.0f) {
                    return b;
                }
                b2 = b;
            }
        }
        return (float) (((double) b) - 0.1d);
    }

    /* renamed from: a */
    void m2312a(C0338k c0338k) throws RemoteException {
        MapCore a = this.f1458f.m2209a();
        MapProjection c = this.f1458f.mo395c();
        c0338k.f1839d = this.f1458f.m2249b(c0338k.f1839d);
        c0338k.f1841f = C0405u.m3443a(c0338k.f1841f);
        float b;
        switch (c0338k.f1836a) {
            case changeCenter:
                if (c0338k.f1849n) {
                    m2304a(c, c0338k.f1850o);
                } else {
                    c.setGeoCenter(c0338k.f1850o.f3639x, c0338k.f1850o.f3640y);
                }
                a.setMapstate(c);
                return;
            case changeBearing:
                if (c0338k.f1849n) {
                    m2310d(c, c0338k);
                } else {
                    c.setMapAngle(c0338k.f1842g);
                }
                a.setMapstate(c);
                return;
            case changeBearingGeoCenter:
                if (c0338k.f1849n) {
                    m2303a(c, c0338k);
                } else {
                    c.setMapAngle(c0338k.f1842g);
                    c.setGeoCenter(c0338k.f1850o.f3639x, c0338k.f1850o.f3640y);
                }
                a.setMapstate(c);
                return;
            case changeTilt:
                if (c0338k.f1849n) {
                    m2309c(c, c0338k);
                } else {
                    c.setCameraHeaderAngle(c0338k.f1841f);
                }
                a.setMapstate(c);
                return;
            case changeGeoCenterZoom:
                if (c0338k.f1849n) {
                    m2308b(c, c0338k);
                } else {
                    c.setGeoCenter(c0338k.f1850o.f3639x, c0338k.f1850o.f3640y);
                    c.setMapZoomer(c0338k.f1839d);
                }
                a.setMapstate(c);
                return;
            case newCameraPosition:
                LatLng latLng = c0338k.f1843h.target;
                IPoint iPoint = new IPoint();
                MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
                float b2 = C0405u.m3473b(c0338k.f1843h.zoom);
                float f = c0338k.f1843h.bearing;
                float a2 = C0405u.m3443a(c0338k.f1843h.tilt);
                if (c0338k.f1849n) {
                    m2305a(c, iPoint, b2, f, a2);
                } else {
                    c.setGeoCenter(iPoint.f3639x, iPoint.f3640y);
                    c.setMapZoomer(b2);
                    c.setMapAngle(f);
                    c.setCameraHeaderAngle(a2);
                }
                a.setMapstate(c);
                return;
            case zoomIn:
                b = this.f1458f.m2249b(c.getMapZoomer() + 1.0f);
                if (c0338k.f1849n) {
                    m2301a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case zoomOut:
                b = this.f1458f.m2249b(c.getMapZoomer() - 1.0f);
                if (c0338k.f1849n) {
                    m2301a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                c.setMapZoomer(b);
                a.setMapstate(c);
                return;
            case zoomTo:
                b = c0338k.f1839d;
                if (c0338k.f1849n) {
                    m2301a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case zoomBy:
                b = this.f1458f.m2249b(c.getMapZoomer() + c0338k.f1840e);
                Point point = c0338k.f1848m;
                if (point != null) {
                    m2302a(c, b, point.x, point.y);
                } else if (c0338k.f1849n) {
                    m2301a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case scrollBy:
                b = c0338k.f1837b;
                b += ((float) this.f1458f.getWidth()) / 2.0f;
                float height = c0338k.f1838c + (((float) this.f1458f.getHeight()) / 2.0f);
                IPoint iPoint2 = new IPoint();
                this.f1458f.m2220a((int) b, (int) height, iPoint2);
                c.setGeoCenter(iPoint2.f3639x, iPoint2.f3640y);
                a.setMapstate(c);
                return;
            case newLatLngBounds:
                c0338k.f1836a = C0337a.newLatLngBoundsWithSize;
                c0338k.f1846k = this.f1458f.getWidth();
                c0338k.f1847l = this.f1458f.getHeight();
                m2307b(c0338k);
                return;
            case newLatLngBoundsWithSize:
                m2307b(c0338k);
                return;
            case changeGeoCenterZoomTiltBearing:
                if (c0338k.f1849n) {
                    m2305a(c, c0338k.f1850o, c0338k.f1839d, c0338k.f1842g, c0338k.f1841f);
                } else {
                    c.setGeoCenter(c0338k.f1850o.f3639x, c0338k.f1850o.f3640y);
                    c.setMapZoomer(c0338k.f1839d);
                    c.setMapAngle(c0338k.f1842g);
                    c.setCameraHeaderAngle(c0338k.f1841f);
                }
                a.setMapstate(c);
                return;
            default:
                a.setMapstate(c);
                return;
        }
    }

    /* renamed from: a */
    private void m2303a(MapProjection mapProjection, C0338k c0338k) {
        mapProjection.setMapAngle(c0338k.f1842g);
        m2304a(mapProjection, c0338k.f1850o);
    }

    /* renamed from: a */
    private void m2301a(MapProjection mapProjection, float f) {
        m2302a(mapProjection, f, this.f1460h, this.f1461i);
    }

    /* renamed from: a */
    private void m2302a(MapProjection mapProjection, float f, int i, int i2) {
        IPoint a = m2300a(mapProjection, i, i2);
        mapProjection.setMapZoomer(f);
        m2306a(mapProjection, a, i, i2);
    }

    /* renamed from: a */
    private void m2305a(MapProjection mapProjection, IPoint iPoint, float f, float f2, float f3) {
        mapProjection.setMapZoomer(f);
        mapProjection.setMapAngle(f2);
        mapProjection.setCameraHeaderAngle(f3);
        m2304a(mapProjection, iPoint);
    }

    /* renamed from: b */
    private void m2308b(MapProjection mapProjection, C0338k c0338k) {
        mapProjection.setMapZoomer(c0338k.f1839d);
        m2304a(mapProjection, c0338k.f1850o);
    }

    /* renamed from: c */
    private void m2309c(MapProjection mapProjection, C0338k c0338k) {
        IPoint a = m2299a(mapProjection);
        mapProjection.setCameraHeaderAngle(c0338k.f1841f);
        m2304a(mapProjection, a);
    }

    /* renamed from: d */
    private void m2310d(MapProjection mapProjection, C0338k c0338k) {
        IPoint a = m2299a(mapProjection);
        mapProjection.setMapAngle(c0338k.f1842g);
        m2304a(mapProjection, a);
    }

    /* renamed from: a */
    private void m2304a(MapProjection mapProjection, IPoint iPoint) {
        m2306a(mapProjection, iPoint, this.f1460h, this.f1461i);
    }

    /* renamed from: a */
    private void m2306a(MapProjection mapProjection, IPoint iPoint, int i, int i2) {
        mapProjection.recalculate();
        IPoint a = m2300a(mapProjection, i, i2);
        IPoint iPoint2 = new IPoint();
        mapProjection.getGeoCenter(iPoint2);
        mapProjection.setGeoCenter((iPoint2.f3639x + iPoint.f3639x) - a.f3639x, (iPoint2.f3640y + iPoint.f3640y) - a.f3640y);
    }

    /* renamed from: a */
    private IPoint m2299a(MapProjection mapProjection) {
        return m2300a(mapProjection, this.f1460h, this.f1461i);
    }

    /* renamed from: a */
    private IPoint m2300a(MapProjection mapProjection, int i, int i2) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        IPoint iPoint = new IPoint();
        mapProjection.map2Geo(fPoint.f3637x, fPoint.f3638y, iPoint);
        return iPoint;
    }

    public void OnMapDestory(GL10 gl10, MapCore mapCore) {
        super.OnMapDestory(mapCore);
    }

    public void OnMapReferencechanged(MapCore mapCore, String str, String str2) {
        try {
            if (this.f1458f.mo426u().mo542c()) {
                this.f1458f.m2264e();
            }
            if (this.f1458f.mo426u().mo537a()) {
                this.f1458f.m2267f();
            }
            this.f1458f.m2279j(true);
        } catch (Throwable e) {
            az.m3143a(e, "AMapCallback", "OnMapReferencechanged");
            e.printStackTrace();
        }
        this.f1458f.m2198P();
    }

    public Context getContext() {
        return this.f1458f.getContext();
    }

    public boolean isMapEngineValid() {
        if (this.f1458f.m2209a() != null) {
            return this.f1458f.m2209a().isMapEngineValid();
        }
        return false;
    }

    public void OnMapLoaderError(int i) {
        C0399o.m3422a("MapCore", "OnMapLoaderError=" + i, ErrorCode.DOWNLOAD_OVER_FLOW);
    }

    public void onSetParameter(MapCore mapCore) {
        this.f1458f.mo401e(false);
    }

    /* renamed from: a */
    public void m2311a(int i, int i2) {
        this.f1460h = i;
        this.f1461i = i2;
    }
}
