package com.amap.api.mapcore;

import android.graphics.Color;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapNativeRenderer;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: ArcDelegateImp */
/* renamed from: com.amap.api.mapcore.i */
class C0335i implements C0334v {
    /* renamed from: a */
    float f1757a;
    /* renamed from: b */
    float f1758b;
    /* renamed from: c */
    float f1759c;
    /* renamed from: d */
    float f1760d;
    /* renamed from: e */
    private LatLng f1761e;
    /* renamed from: f */
    private LatLng f1762f;
    /* renamed from: g */
    private LatLng f1763g;
    /* renamed from: h */
    private float f1764h = 10.0f;
    /* renamed from: i */
    private int f1765i = -16777216;
    /* renamed from: j */
    private float f1766j = 0.0f;
    /* renamed from: k */
    private boolean f1767k = true;
    /* renamed from: l */
    private String f1768l;
    /* renamed from: m */
    private C0313u f1769m;
    /* renamed from: n */
    private float[] f1770n;
    /* renamed from: o */
    private int f1771o = 0;
    /* renamed from: p */
    private boolean f1772p = false;
    /* renamed from: q */
    private double f1773q = 0.0d;
    /* renamed from: r */
    private double f1774r = 0.0d;
    /* renamed from: s */
    private double f1775s = 0.0d;

    public C0335i(C0313u c0313u) {
        this.f1769m = c0313u;
        try {
            this.f1768l = mo468c();
        } catch (Throwable e) {
            az.m3143a(e, "ArcDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean mo463a() {
        return true;
    }

    /* renamed from: b */
    public void mo465b() throws RemoteException {
        this.f1769m.mo385a(mo468c());
        this.f1769m.mo401e(false);
    }

    /* renamed from: c */
    public String mo468c() throws RemoteException {
        if (this.f1768l == null) {
            this.f1768l = C0350r.m2938a("Arc");
        }
        return this.f1768l;
    }

    /* renamed from: a */
    public void mo458a(float f) throws RemoteException {
        this.f1766j = f;
        this.f1769m.mo335H();
        this.f1769m.mo401e(false);
    }

    /* renamed from: d */
    public float mo469d() throws RemoteException {
        return this.f1766j;
    }

    /* renamed from: a */
    public void mo462a(boolean z) throws RemoteException {
        this.f1767k = z;
        this.f1769m.mo401e(false);
    }

    /* renamed from: e */
    public boolean mo470e() throws RemoteException {
        return this.f1767k;
    }

    /* renamed from: a */
    public boolean mo464a(ab abVar) throws RemoteException {
        if (equals(abVar) || abVar.mo468c().equals(mo468c())) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int mo471f() throws RemoteException {
        return 0;
    }

    /* renamed from: g */
    public void mo472g() throws RemoteException {
        int i = 0;
        if (this.f1761e != null && this.f1762f != null && this.f1763g != null && this.f1767k) {
            try {
                this.f1772p = false;
                MapProjection c = this.f1769m.mo395c();
                FPoint fPoint;
                if (m2832l()) {
                    DPoint m = m2833m();
                    int abs = (int) ((Math.abs(this.f1775s - this.f1774r) * 180.0d) / 3.141592653589793d);
                    double d = (this.f1775s - this.f1774r) / ((double) abs);
                    FPoint[] fPointArr = new FPoint[(abs + 1)];
                    this.f1770n = new float[(fPointArr.length * 3)];
                    for (int i2 = 0; i2 <= abs; i2++) {
                        MapProjection mapProjection;
                        if (i2 == abs) {
                            fPoint = new FPoint();
                            this.f1769m.mo352a(this.f1763g.latitude, this.f1763g.longitude, fPoint);
                            fPointArr[i2] = fPoint;
                        } else {
                            mapProjection = c;
                            fPointArr[i2] = m2831a(mapProjection, (((double) i2) * d) + this.f1774r, m.f3635x, m.f3636y);
                        }
                        mapProjection = c;
                        fPointArr[i2] = m2831a(mapProjection, (((double) i2) * d) + this.f1774r, m.f3635x, m.f3636y);
                        this.f1770n[i2 * 3] = fPointArr[i2].f3637x;
                        this.f1770n[(i2 * 3) + 1] = fPointArr[i2].f3638y;
                        this.f1770n[(i2 * 3) + 2] = 0.0f;
                    }
                    this.f1771o = fPointArr.length;
                    return;
                }
                FPoint[] fPointArr2 = new FPoint[3];
                this.f1770n = new float[(fPointArr2.length * 3)];
                fPoint = new FPoint();
                this.f1769m.mo352a(this.f1761e.latitude, this.f1761e.longitude, fPoint);
                fPointArr2[0] = fPoint;
                fPoint = new FPoint();
                this.f1769m.mo352a(this.f1762f.latitude, this.f1762f.longitude, fPoint);
                fPointArr2[1] = fPoint;
                fPoint = new FPoint();
                this.f1769m.mo352a(this.f1763g.latitude, this.f1763g.longitude, fPoint);
                fPointArr2[2] = fPoint;
                while (i < 3) {
                    this.f1770n[i * 3] = fPointArr2[i].f3637x;
                    this.f1770n[(i * 3) + 1] = fPointArr2[i].f3638y;
                    this.f1770n[(i * 3) + 2] = 0.0f;
                    i++;
                }
                this.f1771o = fPointArr2.length;
            } catch (Throwable th) {
                az.m3143a(th, "ArcDelegateImp", "calMapFPoint");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private FPoint m2831a(MapProjection mapProjection, double d, double d2, double d3) {
        int cos = (int) ((Math.cos(d) * this.f1773q) + d2);
        int i = (int) (d3 + ((-Math.sin(d)) * this.f1773q));
        FPoint fPoint = new FPoint();
        mapProjection.geo2Map(cos, i, fPoint);
        return fPoint;
    }

    /* renamed from: l */
    private boolean m2832l() {
        if (Math.abs(((this.f1761e.latitude - this.f1762f.latitude) * (this.f1762f.longitude - this.f1763g.longitude)) - ((this.f1761e.longitude - this.f1762f.longitude) * (this.f1762f.latitude - this.f1763g.latitude))) < 1.0E-6d) {
            return false;
        }
        return true;
    }

    /* renamed from: m */
    private DPoint m2833m() {
        IPoint iPoint = new IPoint();
        this.f1769m.mo353a(this.f1761e.latitude, this.f1761e.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f1769m.mo353a(this.f1762f.latitude, this.f1762f.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f1769m.mo353a(this.f1763g.latitude, this.f1763g.longitude, iPoint3);
        double d = (double) iPoint.f3639x;
        double d2 = (double) iPoint.f3640y;
        double d3 = (double) iPoint2.f3639x;
        double d4 = (double) iPoint2.f3640y;
        double d5 = (double) iPoint3.f3639x;
        double d6 = (double) iPoint3.f3640y;
        double d7 = (((d6 - d2) * ((((d4 * d4) - (d2 * d2)) + (d3 * d3)) - (d * d))) + ((d4 - d2) * ((((d2 * d2) - (d6 * d6)) + (d * d)) - (d5 * d5)))) / (((2.0d * (d3 - d)) * (d6 - d2)) - ((2.0d * (d5 - d)) * (d4 - d2)));
        double d8 = (((d5 - d) * ((((d3 * d3) - (d * d)) + (d4 * d4)) - (d2 * d2))) + ((d3 - d) * ((((d * d) - (d5 * d5)) + (d2 * d2)) - (d6 * d6)))) / (((2.0d * (d4 - d2)) * (d5 - d)) - ((2.0d * (d6 - d2)) * (d3 - d)));
        this.f1773q = Math.sqrt(((d - d7) * (d - d7)) + ((d2 - d8) * (d2 - d8)));
        this.f1774r = m2830a(d7, d8, d, d2);
        d = m2830a(d7, d8, d3, d4);
        this.f1775s = m2830a(d7, d8, d5, d6);
        if (this.f1774r < this.f1775s) {
            if (d <= this.f1774r || d >= this.f1775s) {
                this.f1775s -= 6.283185307179586d;
            }
        } else if (d <= this.f1775s || d >= this.f1774r) {
            this.f1775s += 6.283185307179586d;
        }
        return new DPoint(d7, d8);
    }

    /* renamed from: a */
    private double m2830a(double d, double d2, double d3, double d4) {
        double d5 = (d2 - d4) / this.f1773q;
        if (Math.abs(d5) > 1.0d) {
            d5 = Math.signum(d5);
        }
        d5 = Math.asin(d5);
        if (d5 >= 0.0d) {
            if (d3 < d) {
                return 3.141592653589793d - Math.abs(d5);
            }
            return d5;
        } else if (d3 < d) {
            return 3.141592653589793d - d5;
        } else {
            return d5 + 6.283185307179586d;
        }
    }

    /* renamed from: a */
    public void mo461a(GL10 gl10) throws RemoteException {
        if (this.f1761e != null && this.f1762f != null && this.f1763g != null && this.f1767k) {
            if (this.f1770n == null || this.f1771o == 0) {
                mo472g();
            }
            if (this.f1770n != null && this.f1771o > 0) {
                AMapNativeRenderer.nativeDrawLineByTextureID(this.f1770n, this.f1770n.length, this.f1769m.mo395c().getMapLenWithWin((int) this.f1764h), this.f1769m.mo386b(), this.f1758b, this.f1759c, this.f1760d, this.f1757a, this.f1769m.mo395c().getMapLenWithWin(1), false, true);
            }
            this.f1772p = true;
        }
    }

    /* renamed from: b */
    public void mo558b(float f) throws RemoteException {
        this.f1764h = f;
        this.f1769m.mo401e(false);
    }

    /* renamed from: h */
    public float mo559h() throws RemoteException {
        return this.f1764h;
    }

    /* renamed from: a */
    public void mo557a(int i) throws RemoteException {
        this.f1765i = i;
        this.f1757a = ((float) Color.alpha(i)) / 255.0f;
        this.f1758b = ((float) Color.red(i)) / 255.0f;
        this.f1759c = ((float) Color.green(i)) / 255.0f;
        this.f1760d = ((float) Color.blue(i)) / 255.0f;
        this.f1769m.mo401e(false);
    }

    /* renamed from: i */
    public int mo560i() throws RemoteException {
        return this.f1765i;
    }

    /* renamed from: j */
    public void mo475j() {
        try {
            this.f1761e = null;
            this.f1762f = null;
            this.f1763g = null;
        } catch (Throwable th) {
            az.m3143a(th, "ArcDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "ArcDelegateImp destroy");
        }
    }

    /* renamed from: k */
    public boolean mo476k() {
        return this.f1772p;
    }

    /* renamed from: a */
    public void m2836a(LatLng latLng) {
        this.f1761e = latLng;
    }

    /* renamed from: b */
    public void m2843b(LatLng latLng) {
        this.f1762f = latLng;
    }

    /* renamed from: c */
    public void m2845c(LatLng latLng) {
        this.f1763g = latLng;
    }
}
