package com.amap.api.mapcore;

import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.C0388i;
import com.amap.api.mapcore.util.C0403t;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: PolygonDelegateImp */
class aw implements ac {
    /* renamed from: p */
    private static float f1575p = 1.0E10f;
    /* renamed from: a */
    private C0313u f1576a;
    /* renamed from: b */
    private float f1577b = 0.0f;
    /* renamed from: c */
    private boolean f1578c = true;
    /* renamed from: d */
    private String f1579d;
    /* renamed from: e */
    private float f1580e;
    /* renamed from: f */
    private int f1581f;
    /* renamed from: g */
    private int f1582g;
    /* renamed from: h */
    private List<LatLng> f1583h;
    /* renamed from: i */
    private CopyOnWriteArrayList<IPoint> f1584i = new CopyOnWriteArrayList();
    /* renamed from: j */
    private FloatBuffer f1585j;
    /* renamed from: k */
    private FloatBuffer f1586k;
    /* renamed from: l */
    private int f1587l = 0;
    /* renamed from: m */
    private int f1588m = 0;
    /* renamed from: n */
    private LatLngBounds f1589n = null;
    /* renamed from: o */
    private boolean f1590o = false;

    public aw(C0313u c0313u) {
        this.f1576a = c0313u;
        try {
            this.f1579d = mo468c();
        } catch (Throwable e) {
            az.m3143a(e, "PolygonDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo465b() throws RemoteException {
        this.f1576a.mo385a(mo468c());
        this.f1576a.mo401e(false);
    }

    /* renamed from: c */
    public String mo468c() throws RemoteException {
        if (this.f1579d == null) {
            this.f1579d = C0350r.m2938a(SearchBound.POLYGON_SHAPE);
        }
        return this.f1579d;
    }

    /* renamed from: a */
    public void mo480a(List<LatLng> list) throws RemoteException {
        this.f1583h = list;
        m2596b((List) list);
        this.f1576a.mo401e(false);
    }

    /* renamed from: l */
    public List<LatLng> mo486l() throws RemoteException {
        return this.f1583h;
    }

    /* renamed from: a */
    public void mo458a(float f) throws RemoteException {
        this.f1577b = f;
        this.f1576a.mo335H();
        this.f1576a.mo401e(false);
    }

    /* renamed from: d */
    public float mo469d() throws RemoteException {
        return this.f1577b;
    }

    /* renamed from: a */
    public void mo462a(boolean z) throws RemoteException {
        this.f1578c = z;
        this.f1576a.mo401e(false);
    }

    /* renamed from: e */
    public boolean mo470e() throws RemoteException {
        return this.f1578c;
    }

    /* renamed from: a */
    public boolean mo464a(ab abVar) throws RemoteException {
        if (equals(abVar) || abVar.mo468c().equals(mo468c())) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    void m2596b(List<LatLng> list) throws RemoteException {
        Builder builder = LatLngBounds.builder();
        this.f1584i.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    IPoint iPoint = new IPoint();
                    this.f1576a.mo353a(latLng.latitude, latLng.longitude, iPoint);
                    this.f1584i.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.f1584i.size();
            if (size > 1) {
                IPoint iPoint2 = (IPoint) this.f1584i.get(0);
                IPoint iPoint3 = (IPoint) this.f1584i.get(size - 1);
                if (iPoint2.f3639x == iPoint3.f3639x && iPoint2.f3640y == iPoint3.f3640y) {
                    this.f1584i.remove(size - 1);
                }
            }
        }
        this.f1589n = builder.build();
        if (this.f1585j != null) {
            this.f1585j.clear();
        }
        if (this.f1586k != null) {
            this.f1586k.clear();
        }
        this.f1587l = 0;
        this.f1588m = 0;
        this.f1576a.mo401e(false);
    }

    /* renamed from: g */
    public void mo472g() throws RemoteException {
        int i = 0;
        this.f1590o = false;
        FPoint[] fPointArr = new FPoint[this.f1584i.size()];
        float[] fArr = new float[(this.f1584i.size() * 3)];
        Iterator it = this.f1584i.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            fPointArr[i2] = new FPoint();
            this.f1576a.mo390b(iPoint.f3640y, iPoint.f3639x, fPointArr[i2]);
            fArr[i2 * 3] = fPointArr[i2].f3637x;
            fArr[(i2 * 3) + 1] = fPointArr[i2].f3638y;
            fArr[(i2 * 3) + 2] = 0.0f;
            i2++;
        }
        FPoint[] a = m2584a(fPointArr);
        if (a.length == 0) {
            if (f1575p == 1.0E10f) {
                f1575p = 1.0E8f;
            } else {
                f1575p = 1.0E10f;
            }
            a = m2584a(fPointArr);
        }
        float[] fArr2 = new float[(a.length * 3)];
        int length = a.length;
        i2 = 0;
        while (i < length) {
            FPoint fPoint = a[i];
            fArr2[i2 * 3] = fPoint.f3637x;
            fArr2[(i2 * 3) + 1] = fPoint.f3638y;
            fArr2[(i2 * 3) + 2] = 0.0f;
            i2++;
            i++;
        }
        this.f1587l = fPointArr.length;
        this.f1588m = a.length;
        this.f1585j = C0405u.m3461a(fArr);
        this.f1586k = C0405u.m3461a(fArr2);
    }

    /* renamed from: f */
    public int mo471f() throws RemoteException {
        return super.hashCode();
    }

    /* renamed from: a */
    public boolean mo463a() {
        if (this.f1589n == null) {
            return false;
        }
        LatLngBounds B = this.f1576a.mo331B();
        if (B == null) {
            return true;
        }
        if (this.f1589n.contains(B) || this.f1589n.intersects(B)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo461a(GL10 gl10) throws RemoteException {
        if (this.f1584i != null && this.f1584i.size() != 0) {
            if (this.f1585j == null || this.f1586k == null || this.f1587l == 0 || this.f1588m == 0) {
                mo472g();
            }
            if (this.f1585j != null && this.f1586k != null && this.f1587l > 0 && this.f1588m > 0) {
                C0347p.m2935a(gl10, this.f1581f, this.f1582g, this.f1585j, this.f1580e, this.f1586k, this.f1587l, this.f1588m);
            }
            this.f1590o = true;
        }
    }

    /* renamed from: b */
    public void mo482b(float f) throws RemoteException {
        this.f1580e = f;
        this.f1576a.mo401e(false);
    }

    /* renamed from: h */
    public float mo484h() throws RemoteException {
        return this.f1580e;
    }

    /* renamed from: a */
    public void mo479a(int i) throws RemoteException {
        this.f1581f = i;
        this.f1576a.mo401e(false);
    }

    /* renamed from: i */
    public int mo485i() throws RemoteException {
        return this.f1581f;
    }

    /* renamed from: b */
    public void mo483b(int i) throws RemoteException {
        this.f1582g = i;
        this.f1576a.mo401e(false);
    }

    /* renamed from: m */
    public int mo487m() throws RemoteException {
        return this.f1582g;
    }

    /* renamed from: a */
    static FPoint[] m2584a(FPoint[] fPointArr) {
        int i = 0;
        int length = fPointArr.length;
        float[] fArr = new float[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2 * 2] = fPointArr[i2].f3637x * f1575p;
            fArr[(i2 * 2) + 1] = fPointArr[i2].f3638y * f1575p;
        }
        C0403t a = new C0388i().m3340a(fArr);
        length = a.f2185b;
        FPoint[] fPointArr2 = new FPoint[length];
        while (i < length) {
            fPointArr2[i] = new FPoint();
            fPointArr2[i].f3637x = fArr[a.m3434a(i) * 2] / f1575p;
            fPointArr2[i].f3638y = fArr[(a.m3434a(i) * 2) + 1] / f1575p;
            i++;
        }
        return fPointArr2;
    }

    /* renamed from: j */
    public void mo475j() {
        try {
            if (this.f1585j != null) {
                this.f1585j.clear();
                this.f1585j = null;
            }
            if (this.f1586k != null) {
                this.f1586k = null;
            }
        } catch (Throwable th) {
            az.m3143a(th, "PolygonDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolygonDelegateImp destroy");
        }
    }

    /* renamed from: a */
    public boolean mo481a(LatLng latLng) throws RemoteException {
        try {
            return C0405u.m3468a(latLng, mo486l());
        } catch (Throwable th) {
            az.m3143a(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: k */
    public boolean mo476k() {
        return this.f1590o;
    }
}
