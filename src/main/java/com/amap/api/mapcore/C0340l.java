package com.amap.api.mapcore;

import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: CircleDelegateImp */
/* renamed from: com.amap.api.mapcore.l */
class C0340l implements C0339w {
    /* renamed from: m */
    private static float f1852m = 4.0075016E7f;
    /* renamed from: n */
    private static int f1853n = 256;
    /* renamed from: o */
    private static int f1854o = 20;
    /* renamed from: a */
    private LatLng f1855a = null;
    /* renamed from: b */
    private double f1856b = 0.0d;
    /* renamed from: c */
    private float f1857c = 10.0f;
    /* renamed from: d */
    private int f1858d = -16777216;
    /* renamed from: e */
    private int f1859e = 0;
    /* renamed from: f */
    private float f1860f = 0.0f;
    /* renamed from: g */
    private boolean f1861g = true;
    /* renamed from: h */
    private String f1862h;
    /* renamed from: i */
    private C0313u f1863i;
    /* renamed from: j */
    private FloatBuffer f1864j;
    /* renamed from: k */
    private int f1865k = 0;
    /* renamed from: l */
    private boolean f1866l = false;

    public C0340l(C0313u c0313u) {
        this.f1863i = c0313u;
        try {
            this.f1862h = mo468c();
        } catch (Throwable e) {
            az.m3143a(e, "CircleDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean mo463a() {
        return true;
    }

    /* renamed from: b */
    public void mo465b() throws RemoteException {
        this.f1863i.mo385a(mo468c());
        this.f1863i.mo401e(false);
    }

    /* renamed from: c */
    public String mo468c() throws RemoteException {
        if (this.f1862h == null) {
            this.f1862h = C0350r.m2938a("Circle");
        }
        return this.f1862h;
    }

    /* renamed from: a */
    public void mo458a(float f) throws RemoteException {
        this.f1860f = f;
        this.f1863i.mo335H();
        this.f1863i.mo401e(false);
    }

    /* renamed from: d */
    public float mo469d() throws RemoteException {
        return this.f1860f;
    }

    /* renamed from: a */
    public void mo462a(boolean z) throws RemoteException {
        this.f1861g = z;
        this.f1863i.mo401e(false);
    }

    /* renamed from: e */
    public boolean mo470e() throws RemoteException {
        return this.f1861g;
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
        this.f1866l = false;
        LatLng latLng = this.f1855a;
        if (latLng != null) {
            FPoint[] fPointArr = new FPoint[360];
            float[] fArr = new float[(fPointArr.length * 3)];
            double c = m2904c(this.f1855a.latitude) * this.f1856b;
            IPoint iPoint = new IPoint();
            MapProjection c2 = this.f1863i.mo395c();
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            while (i < 360) {
                double d = (((double) i) * 3.141592653589793d) / 180.0d;
                double sin = Math.sin(d) * c;
                int i2 = (int) (sin + ((double) iPoint.f3639x));
                int cos = (int) ((Math.cos(d) * c) + ((double) iPoint.f3640y));
                FPoint fPoint = new FPoint();
                c2.geo2Map(i2, cos, fPoint);
                fPointArr[i] = fPoint;
                fArr[i * 3] = fPointArr[i].f3637x;
                fArr[(i * 3) + 1] = fPointArr[i].f3638y;
                fArr[(i * 3) + 2] = 0.0f;
                i++;
            }
            this.f1865k = fPointArr.length;
            this.f1864j = C0405u.m3461a(fArr);
        }
    }

    /* renamed from: a */
    public void mo461a(GL10 gl10) throws RemoteException {
        if (this.f1855a != null && this.f1856b > 0.0d && this.f1861g) {
            if (this.f1864j == null || this.f1865k == 0) {
                mo472g();
            }
            if (this.f1864j != null && this.f1865k > 0) {
                C0347p.m2936b(gl10, this.f1859e, this.f1858d, this.f1864j, this.f1857c, this.f1865k);
            }
            this.f1866l = true;
        }
    }

    /* renamed from: h */
    void m2922h() {
        this.f1865k = 0;
        if (this.f1864j != null) {
            this.f1864j.clear();
        }
        this.f1863i.mo401e(false);
    }

    /* renamed from: a */
    public void mo563a(LatLng latLng) throws RemoteException {
        this.f1855a = latLng;
        m2922h();
    }

    /* renamed from: i */
    public LatLng mo567i() throws RemoteException {
        return this.f1855a;
    }

    /* renamed from: a */
    public void mo561a(double d) throws RemoteException {
        this.f1856b = d;
        m2922h();
    }

    /* renamed from: l */
    public double mo568l() throws RemoteException {
        return this.f1856b;
    }

    /* renamed from: b */
    public void mo564b(float f) throws RemoteException {
        this.f1857c = f;
        this.f1863i.mo401e(false);
    }

    /* renamed from: m */
    public float mo569m() throws RemoteException {
        return this.f1857c;
    }

    /* renamed from: a */
    public void mo562a(int i) throws RemoteException {
        this.f1858d = i;
    }

    /* renamed from: n */
    public int mo570n() throws RemoteException {
        return this.f1858d;
    }

    /* renamed from: b */
    public void mo565b(int i) throws RemoteException {
        this.f1859e = i;
        this.f1863i.mo401e(false);
    }

    /* renamed from: o */
    public int mo571o() throws RemoteException {
        return this.f1859e;
    }

    /* renamed from: b */
    private float m2903b(double d) {
        return (float) ((Math.cos((3.141592653589793d * d) / 180.0d) * ((double) f1852m)) / ((double) (f1853n << f1854o)));
    }

    /* renamed from: c */
    private double m2904c(double d) {
        return 1.0d / ((double) m2903b(d));
    }

    /* renamed from: j */
    public void mo475j() {
        try {
            this.f1855a = null;
            if (this.f1864j != null) {
                this.f1864j.clear();
                this.f1864j = null;
            }
        } catch (Throwable th) {
            az.m3143a(th, "CircleDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "CircleDelegateImp destroy");
        }
    }

    /* renamed from: b */
    public boolean mo566b(LatLng latLng) throws RemoteException {
        if (this.f1856b >= ((double) AMapUtils.calculateLineDistance(this.f1855a, latLng))) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    public boolean mo476k() {
        return this.f1866l;
    }
}
