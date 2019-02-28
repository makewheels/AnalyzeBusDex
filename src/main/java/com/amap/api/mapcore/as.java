package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;

/* compiled from: MyLocationOverlay */
class as {
    /* renamed from: a */
    private C0313u f1540a;
    /* renamed from: b */
    private Marker f1541b;
    /* renamed from: c */
    private C0339w f1542c;
    /* renamed from: d */
    private MyLocationStyle f1543d;
    /* renamed from: e */
    private LatLng f1544e;
    /* renamed from: f */
    private double f1545f;
    /* renamed from: g */
    private Context f1546g;
    /* renamed from: h */
    private bb f1547h;
    /* renamed from: i */
    private int f1548i = 1;
    /* renamed from: j */
    private boolean f1549j = false;
    /* renamed from: k */
    private final String f1550k = "location_map_gps_locked.png";
    /* renamed from: l */
    private final String f1551l = "location_map_gps_3d.png";
    /* renamed from: m */
    private boolean f1552m = false;

    as(C0313u c0313u, Context context) {
        this.f1546g = context;
        this.f1540a = c0313u;
        this.f1547h = new bb(this.f1546g, c0313u);
    }

    /* renamed from: a */
    public void m2547a(MyLocationStyle myLocationStyle) {
        try {
            this.f1543d = myLocationStyle;
            if (this.f1541b != null || this.f1542c != null) {
                m2540i();
                this.f1547h.m2651a(this.f1541b);
                m2542k();
            }
        } catch (Throwable th) {
            az.m3143a(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m2545a(int i) {
        this.f1548i = i;
        this.f1549j = false;
        switch (this.f1548i) {
            case 1:
                m2535d();
                return;
            case 2:
                m2536e();
                return;
            case 3:
                m2537f();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m2543a() {
        if (this.f1547h != null) {
            this.f1547h.m2652b();
        }
    }

    /* renamed from: b */
    public void m2548b() {
        if (this.f1548i == 3 && this.f1547h != null) {
            this.f1547h.m2650a();
        }
    }

    /* renamed from: d */
    private void m2535d() {
        if (this.f1541b != null) {
            m2534c(0.0f);
            this.f1547h.m2652b();
            if (!this.f1552m) {
                this.f1541b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.f1541b.setFlat(false);
            m2532b(0.0f);
        }
    }

    /* renamed from: e */
    private void m2536e() {
        if (this.f1541b != null) {
            m2534c(0.0f);
            this.f1547h.m2652b();
            if (!this.f1552m) {
                this.f1541b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.f1541b.setFlat(false);
            m2532b(0.0f);
        }
    }

    /* renamed from: f */
    private void m2537f() {
        if (this.f1541b != null) {
            this.f1541b.setRotateAngle(0.0f);
            this.f1547h.m2650a();
            if (!this.f1552m) {
                this.f1541b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_3d.png"));
            }
            this.f1541b.setFlat(true);
            try {
                this.f1540a.mo362a(C0338k.m2876a(17.0f));
                m2532b(45.0f);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m2532b(float f) {
        if (this.f1540a != null) {
            try {
                this.f1540a.mo362a(C0338k.m2890c(f));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m2534c(float f) {
        if (this.f1540a != null) {
            try {
                this.f1540a.mo362a(C0338k.m2891d(f));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m2546a(Location location) {
        if (location != null) {
            this.f1544e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f1545f = (double) location.getAccuracy();
            if (this.f1541b == null && this.f1542c == null) {
                m2539h();
            }
            if (this.f1541b != null) {
                this.f1541b.setPosition(this.f1544e);
            }
            if (this.f1542c != null) {
                try {
                    this.f1542c.mo563a(this.f1544e);
                    if (this.f1545f != -1.0d) {
                        this.f1542c.mo561a(this.f1545f);
                    }
                } catch (Throwable e) {
                    az.m3143a(e, "MyLocationOverlay", "setCentAndRadius");
                    e.printStackTrace();
                }
                m2538g();
                if (this.f1548i != 3) {
                    m2533b(location);
                }
                this.f1549j = true;
            }
        }
    }

    /* renamed from: b */
    private void m2533b(Location location) {
        float bearing = location.getBearing() % 360.0f;
        if (bearing > 180.0f) {
            bearing -= 360.0f;
        } else if (bearing < -180.0f) {
            bearing += 360.0f;
        }
        if (this.f1541b != null) {
            this.f1541b.setRotateAngle(-bearing);
        }
    }

    /* renamed from: g */
    private void m2538g() {
        if (this.f1548i != 1 || !this.f1549j) {
            try {
                IPoint iPoint = new IPoint();
                MapProjection.lonlat2Geo(this.f1544e.longitude, this.f1544e.latitude, iPoint);
                this.f1540a.mo391b(C0338k.m2885a(iPoint));
            } catch (Throwable e) {
                az.m3143a(e, "MyLocationOverlay", "locaitonFollow");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    private void m2539h() {
        if (this.f1543d == null) {
            m2541j();
        } else {
            m2542k();
        }
    }

    /* renamed from: c */
    public void m2549c() throws RemoteException {
        m2540i();
        if (this.f1547h != null) {
            this.f1547h.m2652b();
            this.f1547h = null;
        }
    }

    /* renamed from: i */
    private void m2540i() {
        if (this.f1542c != null) {
            try {
                this.f1540a.mo385a(this.f1542c.mo468c());
            } catch (Throwable e) {
                az.m3143a(e, "MyLocationOverlay", "locationIconRemove");
                e.printStackTrace();
            }
            this.f1542c = null;
        }
        if (this.f1541b != null) {
            this.f1541b.remove();
            this.f1541b.destroy();
            this.f1541b = null;
            this.f1547h.m2651a(null);
        }
    }

    /* renamed from: j */
    private void m2541j() {
        try {
            this.f1542c = this.f1540a.mo345a(new CircleOptions().strokeWidth(0.1f).fillColor(Color.argb(50, 0, 0, 180)).strokeColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 0, 0, ErrorCode.COPY_INSTALL_SUCCESS)).center(new LatLng(0.0d, 0.0d)));
            this.f1542c.mo458a(1.0f);
            this.f1542c.mo561a(200.0d);
            this.f1541b = this.f1540a.mo348a(new MarkerOptions().visible(false).anchor(0.5f, 0.5f).position(new LatLng(0.0d, 0.0d)));
            m2545a(this.f1548i);
            this.f1541b.setVisible(true);
            this.f1547h.m2651a(this.f1541b);
        } catch (Throwable e) {
            az.m3143a(e, "MyLocationOverlay", "defaultLocStyle");
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m2542k() {
        if (this.f1543d != null) {
            try {
                this.f1552m = true;
                this.f1542c = this.f1540a.mo345a(new CircleOptions().strokeWidth(this.f1543d.getStrokeWidth()).fillColor(this.f1543d.getRadiusFillColor()).strokeColor(this.f1543d.getStrokeColor()).center(new LatLng(0.0d, 0.0d)).zIndex(1.0f));
                if (this.f1544e != null) {
                    this.f1542c.mo563a(this.f1544e);
                }
                this.f1542c.mo561a(this.f1545f);
                this.f1541b = this.f1540a.mo348a(new MarkerOptions().visible(false).anchor(this.f1543d.getAnchorU(), this.f1543d.getAnchorV()).icon(this.f1543d.getMyLocationIcon()).position(new LatLng(0.0d, 0.0d)));
                m2545a(this.f1548i);
                if (this.f1544e != null) {
                    this.f1541b.setPosition(this.f1544e);
                    this.f1541b.setVisible(true);
                }
                this.f1547h.m2651a(this.f1541b);
            } catch (Throwable e) {
                az.m3143a(e, "MyLocationOverlay", "myLocStyle");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m2544a(float f) {
        if (this.f1541b != null) {
            this.f1541b.setRotateAngle(f);
        }
    }
}
