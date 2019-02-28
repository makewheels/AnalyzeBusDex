package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapNativeRenderer;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: PolylineDelegateImp */
class ax implements ad {
    /* renamed from: A */
    private boolean f1591A;
    /* renamed from: a */
    float f1592a;
    /* renamed from: b */
    float f1593b;
    /* renamed from: c */
    float f1594c;
    /* renamed from: d */
    float f1595d;
    /* renamed from: e */
    float[] f1596e;
    /* renamed from: f */
    private C0313u f1597f;
    /* renamed from: g */
    private float f1598g = 10.0f;
    /* renamed from: h */
    private int f1599h = -16777216;
    /* renamed from: i */
    private float f1600i = 0.0f;
    /* renamed from: j */
    private boolean f1601j = true;
    /* renamed from: k */
    private String f1602k;
    /* renamed from: l */
    private ArrayList<IPoint> f1603l = new ArrayList();
    /* renamed from: m */
    private FloatBuffer f1604m;
    /* renamed from: n */
    private int f1605n = 0;
    /* renamed from: o */
    private boolean f1606o = false;
    /* renamed from: p */
    private boolean f1607p = false;
    /* renamed from: q */
    private List<LatLng> f1608q = new ArrayList();
    /* renamed from: r */
    private boolean f1609r = false;
    /* renamed from: s */
    private float f1610s = 0.0f;
    /* renamed from: t */
    private Object f1611t = new Object();
    /* renamed from: u */
    private boolean f1612u = true;
    /* renamed from: v */
    private LatLngBounds f1613v = null;
    /* renamed from: w */
    private int f1614w = 0;
    /* renamed from: x */
    private boolean f1615x = true;
    /* renamed from: y */
    private boolean f1616y = false;
    /* renamed from: z */
    private Bitmap f1617z = null;

    /* renamed from: d */
    public void m2628d(boolean z) {
        this.f1612u = z;
        this.f1597f.mo401e(false);
    }

    /* renamed from: b */
    public void mo492b(boolean z) throws RemoteException {
        this.f1606o = z;
        this.f1597f.mo401e(false);
    }

    /* renamed from: m */
    public boolean mo497m() {
        return this.f1606o;
    }

    /* renamed from: c */
    public void mo493c(boolean z) {
        this.f1607p = z;
        this.f1597f.mo401e(false);
    }

    /* renamed from: n */
    public boolean mo498n() {
        return this.f1607p;
    }

    public ax(C0313u c0313u) {
        this.f1597f = c0313u;
        try {
            this.f1602k = mo468c();
        } catch (Throwable e) {
            az.m3143a(e, "PolylineDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    void m2623b(List<LatLng> list) throws RemoteException {
        Object arrayList = new ArrayList();
        Builder builder = LatLngBounds.builder();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!(latLng2 == null || latLng2.equals(latLng))) {
                    IPoint iPoint;
                    if (!this.f1606o) {
                        iPoint = new IPoint();
                        this.f1597f.mo353a(latLng2.latitude, latLng2.longitude, iPoint);
                        arrayList.add(iPoint);
                        builder.include(latLng2);
                    } else if (latLng != null) {
                        if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                            iPoint = new IPoint();
                            this.f1597f.mo353a(latLng.latitude, latLng.longitude, iPoint);
                            arrayList.add(iPoint);
                            builder.include(latLng);
                            iPoint = new IPoint();
                            this.f1597f.mo353a(latLng2.latitude, latLng2.longitude, iPoint);
                            arrayList.add(iPoint);
                            builder.include(latLng2);
                        } else {
                            m2614a(latLng, latLng2, arrayList, builder);
                        }
                    }
                    latLng = latLng2;
                }
            }
        }
        this.f1603l = arrayList;
        this.f1605n = 0;
        if (this.f1603l.size() > 0) {
            this.f1613v = builder.build();
        }
        this.f1597f.mo401e(false);
    }

    /* renamed from: a */
    IPoint m2610a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d, int i) {
        IPoint iPoint4 = new IPoint();
        double d2 = (double) (iPoint2.f3639x - iPoint.f3639x);
        double d3 = (double) (iPoint2.f3640y - iPoint.f3640y);
        iPoint4.f3640y = (int) (((((double) i) * d) / Math.sqrt(((d3 * d3) / (d2 * d2)) + 1.0d)) + ((double) iPoint3.f3640y));
        iPoint4.f3639x = (int) (((d3 * ((double) (iPoint3.f3640y - iPoint4.f3640y))) / d2) + ((double) iPoint3.f3639x));
        return iPoint4;
    }

    /* renamed from: a */
    void m2616a(List<IPoint> list, List<IPoint> list2, double d) {
        if (list.size() == 3) {
            for (int i = 0; i <= 10; i = (int) (((float) i) + 1.0f)) {
                float f = ((float) i) / 10.0f;
                IPoint iPoint = new IPoint();
                double d2 = ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(0)).f3639x)) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(1)).f3639x)) * d)) + ((double) (((float) ((IPoint) list.get(2)).f3639x) * (f * f)));
                double d3 = ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(0)).f3640y)) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(1)).f3640y)) * d)) + ((double) (((float) ((IPoint) list.get(2)).f3640y) * (f * f)));
                double d4 = (((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d)) + ((double) (f * f));
                iPoint.f3639x = (int) (d2 / ((((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d)) + ((double) (f * f))));
                iPoint.f3640y = (int) (d3 / d4);
                list2.add(iPoint);
            }
        }
    }

    /* renamed from: a */
    void m2614a(LatLng latLng, LatLng latLng2, List<IPoint> list, Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d, false);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i = latLng3.latitude > 0.0d ? -1 : 1;
        IPoint iPoint = new IPoint();
        this.f1597f.mo353a(latLng.latitude, latLng.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f1597f.mo353a(latLng2.latitude, latLng2.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f1597f.mo353a(latLng3.latitude, latLng3.longitude, iPoint3);
        double cos = Math.cos(0.5d * abs);
        IPoint a = m2610a(iPoint, iPoint2, iPoint3, (Math.hypot((double) (iPoint.f3639x - iPoint2.f3639x), (double) (iPoint.f3640y - iPoint2.f3640y)) * 0.5d) * Math.tan(0.5d * abs), i);
        List arrayList = new ArrayList();
        arrayList.add(iPoint);
        arrayList.add(a);
        arrayList.add(iPoint2);
        m2616a(arrayList, list, cos);
    }

    /* renamed from: b */
    public void mo465b() throws RemoteException {
        this.f1597f.mo385a(mo468c());
        this.f1597f.mo401e(false);
    }

    /* renamed from: c */
    public String mo468c() throws RemoteException {
        if (this.f1602k == null) {
            this.f1602k = C0350r.m2938a("Polyline");
        }
        return this.f1602k;
    }

    /* renamed from: a */
    public void mo490a(List<LatLng> list) throws RemoteException {
        try {
            this.f1608q = new ArrayList(list);
            synchronized (this.f1611t) {
                m2623b((List) list);
            }
            this.f1597f.mo401e(false);
        } catch (Throwable th) {
            az.m3143a(th, "PolylineDelegateImp", "setPoints");
            this.f1603l.clear();
            th.printStackTrace();
        }
    }

    /* renamed from: l */
    public List<LatLng> mo496l() throws RemoteException {
        return this.f1608q;
    }

    /* renamed from: b */
    public void mo491b(float f) throws RemoteException {
        this.f1598g = f;
        this.f1597f.mo401e(false);
    }

    /* renamed from: h */
    public float mo494h() throws RemoteException {
        return this.f1598g;
    }

    /* renamed from: a */
    public void mo489a(int i) throws RemoteException {
        this.f1599h = i;
        this.f1592a = ((float) Color.alpha(i)) / 255.0f;
        this.f1593b = ((float) Color.red(i)) / 255.0f;
        this.f1594c = ((float) Color.green(i)) / 255.0f;
        this.f1595d = ((float) Color.blue(i)) / 255.0f;
        this.f1597f.mo401e(false);
    }

    /* renamed from: i */
    public int mo495i() throws RemoteException {
        return this.f1599h;
    }

    /* renamed from: a */
    public void mo458a(float f) throws RemoteException {
        this.f1600i = f;
        this.f1597f.mo335H();
        this.f1597f.mo401e(false);
    }

    /* renamed from: d */
    public float mo469d() throws RemoteException {
        return this.f1600i;
    }

    /* renamed from: a */
    public void mo462a(boolean z) throws RemoteException {
        this.f1601j = z;
        this.f1597f.mo401e(false);
    }

    /* renamed from: e */
    public boolean mo470e() throws RemoteException {
        return this.f1601j;
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
        return super.hashCode();
    }

    /* renamed from: a */
    public boolean mo463a() {
        if (this.f1613v == null) {
            return false;
        }
        LatLngBounds B = this.f1597f.mo331B();
        if (B == null) {
            return true;
        }
        if (B.contains(this.f1613v) || this.f1613v.intersects(B)) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public void mo472g() throws RemoteException {
        this.f1609r = false;
        synchronized (this.f1611t) {
            FPoint fPoint = new FPoint();
            this.f1596e = new float[(this.f1603l.size() * 3)];
            Iterator it = this.f1603l.iterator();
            int i = 0;
            while (it.hasNext()) {
                IPoint iPoint = (IPoint) it.next();
                this.f1597f.mo390b(iPoint.f3640y, iPoint.f3639x, fPoint);
                this.f1596e[i * 3] = fPoint.f3637x;
                this.f1596e[(i * 3) + 1] = fPoint.f3638y;
                this.f1596e[(i * 3) + 2] = 0.0f;
                i++;
            }
        }
        if (!this.f1612u) {
            this.f1604m = C0405u.m3461a(this.f1596e);
        }
        this.f1605n = this.f1603l.size();
    }

    /* renamed from: a */
    public void m2613a(Bitmap bitmap) {
        this.f1615x = false;
        this.f1616y = true;
        this.f1617z = bitmap;
        this.f1597f.mo401e(false);
    }

    /* renamed from: a */
    public void mo461a(GL10 gl10) throws RemoteException {
        float f = 10.0f;
        if (this.f1603l != null && this.f1603l.size() != 0 && this.f1598g > 0.0f) {
            try {
                if (this.f1607p || !this.f1615x) {
                    if (m2608o()) {
                        synchronized (this.f1611t) {
                            this.f1596e = C0405u.m3471a(this.f1597f, this.f1603l);
                        }
                        this.f1605n = this.f1596e != null ? this.f1596e.length / 3 : 0;
                        this.f1591A = true;
                    } else if (this.f1591A) {
                        mo472g();
                        this.f1591A = false;
                    }
                }
                if (this.f1605n == 0) {
                    mo472g();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.f1596e != null && this.f1605n > 0) {
                if (this.f1612u) {
                    float mapLenWithWin;
                    float mapLenWithWin2 = this.f1597f.mo395c().getMapLenWithWin((int) this.f1598g);
                    this.f1610s = this.f1597f.mo395c().getMapZoomer();
                    if (this.f1605n <= 5000 || this.f1610s > 10.0f) {
                        mapLenWithWin = this.f1597f.mo395c().getMapLenWithWin(1);
                    } else {
                        if ((this.f1598g / 2.0f) + (this.f1610s / 2.0f) <= 10.0f) {
                            f = (this.f1598g / 2.0f) + (this.f1610s / 2.0f);
                        }
                        mapLenWithWin = this.f1597f.mo395c().getMapLenWithWin((int) f);
                    }
                    if (this.f1615x) {
                        if (this.f1607p) {
                            this.f1614w = this.f1597f.mo411j();
                        } else {
                            this.f1614w = this.f1597f.mo386b();
                        }
                    } else if (this.f1616y) {
                        if (this.f1614w != 0) {
                            this.f1597f.mo402f(this.f1614w);
                            gl10.glDeleteTextures(1, new int[]{this.f1614w}, 0);
                        }
                        this.f1614w = this.f1597f.mo333F();
                        if (this.f1614w == 0) {
                            int[] iArr = new int[]{0};
                            gl10.glGenTextures(1, iArr, 0);
                            this.f1614w = iArr[0];
                        }
                        if (!(this.f1617z == null || this.f1617z.isRecycled())) {
                            C0405u.m3446a(gl10, this.f1614w, this.f1617z, true);
                        }
                        this.f1616y = false;
                    }
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.f1596e, this.f1596e.length, mapLenWithWin2, this.f1614w, this.f1593b, this.f1594c, this.f1595d, this.f1592a, mapLenWithWin, this.f1607p, this.f1615x);
                } else {
                    if (this.f1604m == null) {
                        this.f1604m = C0405u.m3461a(this.f1596e);
                    }
                    C0347p.m2934a(gl10, 3, this.f1599h, this.f1604m, this.f1598g, this.f1605n);
                }
            }
            this.f1609r = true;
        }
    }

    /* renamed from: o */
    private boolean m2608o() {
        Boolean valueOf = Boolean.valueOf(false);
        try {
            if (this.f1597f.mo413l().zoom <= 10.0f) {
                return false;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            Boolean valueOf2;
            if (this.f1597f != null) {
                Rect rect = new Rect(-100, -100, this.f1597f.mo406h() + 100, this.f1597f.mo409i() + 100);
                LatLng latLng = this.f1613v.northeast;
                LatLng latLng2 = this.f1613v.southwest;
                IPoint iPoint = new IPoint();
                this.f1597f.mo387b(latLng.latitude, latLng2.longitude, iPoint);
                IPoint iPoint2 = new IPoint();
                this.f1597f.mo387b(latLng.latitude, latLng.longitude, iPoint2);
                IPoint iPoint3 = new IPoint();
                this.f1597f.mo387b(latLng2.latitude, latLng.longitude, iPoint3);
                IPoint iPoint4 = new IPoint();
                this.f1597f.mo387b(latLng2.latitude, latLng2.longitude, iPoint4);
                if (rect.contains(iPoint.f3639x, iPoint.f3640y)) {
                    if (rect.contains(iPoint2.f3639x, iPoint2.f3640y)) {
                        if (rect.contains(iPoint3.f3639x, iPoint3.f3640y)) {
                            if (rect.contains(iPoint4.f3639x, iPoint4.f3640y)) {
                                valueOf2 = Boolean.valueOf(false);
                            }
                        }
                    }
                }
                valueOf2 = Boolean.valueOf(true);
            } else {
                valueOf2 = valueOf;
            }
            return valueOf2.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: j */
    public void mo475j() {
        try {
            if (this.f1596e != null) {
                this.f1596e = null;
            }
            if (this.f1604m != null) {
                this.f1604m.clear();
                this.f1604m = null;
            }
        } catch (Throwable th) {
            az.m3143a(th, "PolylineDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolylineDelegateImp destroy");
        }
    }

    /* renamed from: k */
    public boolean mo476k() {
        return this.f1609r;
    }

    /* renamed from: a */
    public LatLng mo488a(LatLng latLng) {
        int i = 0;
        if (latLng == null) {
            return null;
        }
        if (this.f1608q == null || this.f1608q.size() == 0) {
            return null;
        }
        float f = 0.0f;
        int i2 = 0;
        while (i < this.f1608q.size()) {
            try {
                float calculateLineDistance;
                int i3;
                if (i == 0) {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, (LatLng) this.f1608q.get(i));
                    i3 = i2;
                } else {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, (LatLng) this.f1608q.get(i));
                    if (f > calculateLineDistance) {
                        i3 = i;
                    } else {
                        calculateLineDistance = f;
                        i3 = i2;
                    }
                }
                i++;
                i2 = i3;
                f = calculateLineDistance;
            } catch (Throwable th) {
                az.m3143a(th, "PolylineDelegateImp", "getNearestLatLng");
                th.printStackTrace();
                return null;
            }
        }
        return (LatLng) this.f1608q.get(i2);
    }
}
