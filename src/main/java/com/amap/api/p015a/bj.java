package com.amap.api.p015a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.LatLngBounds.Builder;
import com.amap.api.p015a.p016a.C0204q;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import com.autonavi.amap.mapcore2d.DPoint;
import com.autonavi.amap.mapcore2d.IPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PolygonDelegateImp */
/* renamed from: com.amap.api.a.bj */
class bj implements al {
    /* renamed from: a */
    private C0222b f875a;
    /* renamed from: b */
    private float f876b = 0.0f;
    /* renamed from: c */
    private boolean f877c = true;
    /* renamed from: d */
    private String f878d;
    /* renamed from: e */
    private float f879e;
    /* renamed from: f */
    private int f880f;
    /* renamed from: g */
    private int f881g;
    /* renamed from: h */
    private List<IPoint> f882h = new ArrayList();
    /* renamed from: i */
    private int f883i = 0;
    /* renamed from: j */
    private int f884j = 0;
    /* renamed from: k */
    private LatLngBounds f885k = null;

    public bj(C0222b c0222b) {
        this.f875a = c0222b;
        try {
            this.f878d = mo47c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo45b() throws RemoteException {
        this.f875a.mo112a(mo47c());
    }

    /* renamed from: c */
    public String mo47c() throws RemoteException {
        if (this.f878d == null) {
            this.f878d = ab.m813a(SearchBound.POLYGON_SHAPE);
        }
        return this.f878d;
    }

    /* renamed from: a */
    public void mo186a(List<LatLng> list) throws RemoteException {
        m1445b((List) list);
    }

    /* renamed from: i */
    public List<LatLng> mo192i() throws RemoteException {
        return m1454k();
    }

    /* renamed from: a */
    public void mo36a(float f) throws RemoteException {
        this.f876b = f;
    }

    /* renamed from: d */
    public float mo49d() throws RemoteException {
        return this.f876b;
    }

    /* renamed from: a */
    public void mo42a(boolean z) throws RemoteException {
        this.f877c = z;
    }

    /* renamed from: e */
    public boolean mo51e() throws RemoteException {
        return this.f877c;
    }

    /* renamed from: a */
    public boolean mo44a(ak akVar) throws RemoteException {
        if (equals(akVar) || akVar.mo47c().equals(mo47c())) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    void m1445b(List<LatLng> list) throws RemoteException {
        Builder builder = LatLngBounds.builder();
        this.f882h.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    IPoint iPoint = new IPoint();
                    this.f875a.m1201a(latLng.latitude, latLng.longitude, iPoint);
                    this.f882h.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.f882h.size();
            if (size > 1) {
                IPoint iPoint2 = (IPoint) this.f882h.get(0);
                IPoint iPoint3 = (IPoint) this.f882h.get(size - 1);
                if (iPoint2.f3652x == iPoint3.f3652x && iPoint2.f3653y == iPoint3.f3653y) {
                    this.f882h.remove(size - 1);
                }
            }
        }
        this.f885k = builder.build();
        this.f883i = 0;
        this.f884j = 0;
    }

    /* renamed from: k */
    List<LatLng> m1454k() throws RemoteException {
        if (this.f882h == null) {
            return null;
        }
        List<LatLng> arrayList = new ArrayList();
        for (IPoint iPoint : this.f882h) {
            if (iPoint != null) {
                DPoint dPoint = new DPoint();
                this.f875a.m1240b(iPoint.f3652x, iPoint.f3653y, dPoint);
                arrayList.add(new LatLng(dPoint.f3649y, dPoint.f3648x));
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public int mo52f() throws RemoteException {
        return super.hashCode();
    }

    /* renamed from: a */
    public boolean mo43a() {
        if (this.f885k == null) {
            return false;
        }
        LatLngBounds x = this.f875a.m1280x();
        if (x == null) {
            return true;
        }
        if (this.f885k.contains(x) || this.f885k.intersects(x)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo38a(Canvas canvas) throws RemoteException {
        if (this.f882h != null && this.f882h.size() != 0) {
            Path path = new Path();
            Point a = this.f875a.mo144s().mo182a(new ac(((IPoint) this.f882h.get(0)).f3653y, ((IPoint) this.f882h.get(0)).f3652x), new Point());
            path.moveTo((float) a.x, (float) a.y);
            for (int i = 1; i < this.f882h.size(); i++) {
                a = this.f875a.mo144s().mo182a(new ac(((IPoint) this.f882h.get(i)).f3653y, ((IPoint) this.f882h.get(i)).f3652x), new Point());
                path.lineTo((float) a.x, (float) a.y);
            }
            Paint paint = new Paint();
            paint.setColor(mo191h());
            paint.setAntiAlias(true);
            path.close();
            paint.setStyle(Style.FILL);
            canvas.drawPath(path, paint);
            paint.setStyle(Style.STROKE);
            paint.setColor(mo193j());
            paint.setStrokeWidth(mo190g());
            canvas.drawPath(path, paint);
        }
    }

    /* renamed from: b */
    public void mo188b(float f) throws RemoteException {
        this.f879e = f;
    }

    /* renamed from: g */
    public float mo190g() throws RemoteException {
        return this.f879e;
    }

    /* renamed from: a */
    public void mo185a(int i) throws RemoteException {
        this.f880f = i;
    }

    /* renamed from: h */
    public int mo191h() throws RemoteException {
        return this.f880f;
    }

    /* renamed from: b */
    public void mo189b(int i) throws RemoteException {
        this.f881g = i;
    }

    /* renamed from: j */
    public int mo193j() throws RemoteException {
        return this.f881g;
    }

    /* renamed from: m */
    public void mo58m() {
    }

    /* renamed from: a */
    public boolean mo187a(LatLng latLng) throws RemoteException {
        return C0204q.m805a(latLng, mo192i());
    }
}
