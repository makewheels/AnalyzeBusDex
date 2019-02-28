package com.amap.api.mapcore;

import android.graphics.Color;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapNativeRenderer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: NavigateArrowDelegateImp */
class at implements aa {
    /* renamed from: a */
    float f1553a;
    /* renamed from: b */
    float f1554b;
    /* renamed from: c */
    float f1555c;
    /* renamed from: d */
    float f1556d;
    /* renamed from: e */
    float f1557e;
    /* renamed from: f */
    float f1558f;
    /* renamed from: g */
    float f1559g;
    /* renamed from: h */
    float f1560h;
    /* renamed from: i */
    float[] f1561i;
    /* renamed from: j */
    private C0313u f1562j;
    /* renamed from: k */
    private float f1563k = 10.0f;
    /* renamed from: l */
    private int f1564l = -16777216;
    /* renamed from: m */
    private int f1565m = -16777216;
    /* renamed from: n */
    private float f1566n = 0.0f;
    /* renamed from: o */
    private boolean f1567o = true;
    /* renamed from: p */
    private String f1568p;
    /* renamed from: q */
    private CopyOnWriteArrayList<IPoint> f1569q = new CopyOnWriteArrayList();
    /* renamed from: r */
    private int f1570r = 0;
    /* renamed from: s */
    private boolean f1571s = false;
    /* renamed from: t */
    private LatLngBounds f1572t = null;

    public at(C0313u c0313u) {
        this.f1562j = c0313u;
        try {
            this.f1568p = mo468c();
        } catch (Throwable e) {
            az.m3143a(e, "NavigateArrowDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    void m2561b(List<LatLng> list) throws RemoteException {
        Builder builder = LatLngBounds.builder();
        this.f1569q.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!(latLng == null || latLng.equals(r1))) {
                    IPoint iPoint = new IPoint();
                    this.f1562j.mo353a(latLng.latitude, latLng.longitude, iPoint);
                    this.f1569q.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
        }
        this.f1572t = builder.build();
        this.f1570r = 0;
        this.f1562j.mo401e(false);
    }

    /* renamed from: b */
    public void mo465b() throws RemoteException {
        this.f1562j.mo385a(mo468c());
        this.f1562j.mo401e(false);
    }

    /* renamed from: c */
    public String mo468c() throws RemoteException {
        if (this.f1568p == null) {
            this.f1568p = C0350r.m2938a("NavigateArrow");
        }
        return this.f1568p;
    }

    /* renamed from: a */
    public void mo460a(List<LatLng> list) throws RemoteException {
        m2561b((List) list);
    }

    /* renamed from: m */
    public List<LatLng> mo478m() throws RemoteException {
        return m2550n();
    }

    /* renamed from: n */
    private List<LatLng> m2550n() throws RemoteException {
        if (this.f1569q == null) {
            return null;
        }
        List<LatLng> arrayList = new ArrayList();
        Iterator it = this.f1569q.iterator();
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            if (iPoint != null) {
                DPoint dPoint = new DPoint();
                this.f1562j.mo389b(iPoint.f3639x, iPoint.f3640y, dPoint);
                arrayList.add(new LatLng(dPoint.f3636y, dPoint.f3635x));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo466b(float f) throws RemoteException {
        this.f1563k = f;
        this.f1562j.mo401e(false);
    }

    /* renamed from: h */
    public float mo473h() throws RemoteException {
        return this.f1563k;
    }

    /* renamed from: a */
    public void mo459a(int i) throws RemoteException {
        this.f1564l = i;
        this.f1553a = ((float) Color.alpha(i)) / 255.0f;
        this.f1554b = ((float) Color.red(i)) / 255.0f;
        this.f1555c = ((float) Color.green(i)) / 255.0f;
        this.f1556d = ((float) Color.blue(i)) / 255.0f;
        this.f1562j.mo401e(false);
    }

    /* renamed from: i */
    public int mo474i() throws RemoteException {
        return this.f1564l;
    }

    /* renamed from: b */
    public void mo467b(int i) throws RemoteException {
        this.f1565m = i;
        this.f1557e = ((float) Color.alpha(i)) / 255.0f;
        this.f1558f = ((float) Color.red(i)) / 255.0f;
        this.f1559g = ((float) Color.green(i)) / 255.0f;
        this.f1560h = ((float) Color.blue(i)) / 255.0f;
        this.f1562j.mo401e(false);
    }

    /* renamed from: l */
    public int mo477l() throws RemoteException {
        return this.f1565m;
    }

    /* renamed from: a */
    public void mo458a(float f) throws RemoteException {
        this.f1566n = f;
        this.f1562j.mo335H();
        this.f1562j.mo401e(false);
    }

    /* renamed from: d */
    public float mo469d() throws RemoteException {
        return this.f1566n;
    }

    /* renamed from: a */
    public void mo462a(boolean z) throws RemoteException {
        this.f1567o = z;
        this.f1562j.mo401e(false);
    }

    /* renamed from: e */
    public boolean mo470e() throws RemoteException {
        return this.f1567o;
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
        if (this.f1572t == null) {
            return false;
        }
        LatLngBounds B = this.f1562j.mo331B();
        if (B == null) {
            return true;
        }
        if (B.contains(this.f1572t) || this.f1572t.intersects(B)) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public void mo472g() throws RemoteException {
        this.f1571s = false;
        FPoint fPoint = new FPoint();
        this.f1561i = new float[(this.f1569q.size() * 3)];
        Iterator it = this.f1569q.iterator();
        int i = 0;
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            this.f1562j.mo390b(iPoint.f3640y, iPoint.f3639x, fPoint);
            this.f1561i[i * 3] = fPoint.f3637x;
            this.f1561i[(i * 3) + 1] = fPoint.f3638y;
            this.f1561i[(i * 3) + 2] = 0.0f;
            i++;
        }
        this.f1570r = this.f1569q.size();
    }

    /* renamed from: a */
    public void mo461a(GL10 gl10) throws RemoteException {
        if (this.f1569q != null && this.f1569q.size() != 0 && this.f1563k > 0.0f) {
            if (this.f1570r == 0) {
                mo472g();
            }
            if (this.f1561i != null && this.f1570r > 0) {
                AMapNativeRenderer.nativeDrawArrowLineWithPoints(this.f1561i, this.f1561i.length, this.f1562j.mo395c().getMapLenWithWin((int) this.f1563k), this.f1554b, this.f1555c, this.f1556d, this.f1553a, this.f1558f, this.f1559g, this.f1560h, this.f1557e, this.f1562j.mo395c().getMapLenWithWin(1));
            }
            this.f1571s = true;
        }
    }

    /* renamed from: j */
    public void mo475j() {
        try {
            if (this.f1561i != null) {
                this.f1561i = null;
            }
        } catch (Throwable th) {
            az.m3143a(th, "NavigateArrowDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "NavigateArrowDelegateImp destroy");
        }
    }

    /* renamed from: k */
    public boolean mo476k() {
        return this.f1571s;
    }
}
