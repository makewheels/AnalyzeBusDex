package com.amap.api.p015a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.LatLngBounds.Builder;
import com.autonavi.amap.mapcore2d.DPoint;
import com.autonavi.amap.mapcore2d.IPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PolylineDelegateImp */
/* renamed from: com.amap.api.a.bk */
class bk implements am {
    /* renamed from: a */
    float f886a;
    /* renamed from: b */
    float f887b;
    /* renamed from: c */
    float f888c;
    /* renamed from: d */
    float f889d;
    /* renamed from: e */
    float[] f890e = new float[480];
    /* renamed from: f */
    float[] f891f = new float[60];
    /* renamed from: g */
    private C0222b f892g;
    /* renamed from: h */
    private float f893h = 10.0f;
    /* renamed from: i */
    private int f894i = -16777216;
    /* renamed from: j */
    private float f895j = 0.0f;
    /* renamed from: k */
    private boolean f896k = true;
    /* renamed from: l */
    private boolean f897l = false;
    /* renamed from: m */
    private boolean f898m = false;
    /* renamed from: n */
    private String f899n;
    /* renamed from: o */
    private List<IPoint> f900o = new ArrayList();
    /* renamed from: p */
    private List<LatLng> f901p = new ArrayList();
    /* renamed from: q */
    private LatLngBounds f902q = null;

    public bk(C0222b c0222b) {
        this.f892g = c0222b;
        try {
            this.f899n = mo47c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    void m1469b(List<LatLng> list) throws RemoteException {
        if (list != null && list.size() != 0) {
            Builder builder = LatLngBounds.builder();
            this.f900o.clear();
            if (list != null) {
                LatLng latLng = null;
                for (LatLng latLng2 : list) {
                    if (!(latLng2 == null || latLng2.equals(latLng))) {
                        IPoint iPoint;
                        if (!this.f898m) {
                            iPoint = new IPoint();
                            this.f892g.m1201a(latLng2.latitude, latLng2.longitude, iPoint);
                            this.f900o.add(iPoint);
                            builder.include(latLng2);
                        } else if (latLng != null) {
                            if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                                iPoint = new IPoint();
                                this.f892g.m1201a(latLng.latitude, latLng.longitude, iPoint);
                                this.f900o.add(iPoint);
                                builder.include(latLng);
                                iPoint = new IPoint();
                                this.f892g.m1201a(latLng2.latitude, latLng2.longitude, iPoint);
                                this.f900o.add(iPoint);
                                builder.include(latLng2);
                            } else {
                                m1461a(latLng, latLng2, this.f900o, builder);
                            }
                        }
                        latLng = latLng2;
                    }
                }
            }
            this.f902q = builder.build();
        }
    }

    /* renamed from: b */
    public void mo45b() throws RemoteException {
        this.f892g.mo112a(mo47c());
    }

    /* renamed from: c */
    public String mo47c() throws RemoteException {
        if (this.f899n == null) {
            this.f899n = ab.m813a("Polyline");
        }
        return this.f899n;
    }

    /* renamed from: a */
    public void mo195a(List<LatLng> list) throws RemoteException {
        if (this.f898m || this.f897l) {
            this.f901p = list;
        }
        m1469b((List) list);
    }

    /* renamed from: i */
    public List<LatLng> mo201i() throws RemoteException {
        if (this.f898m || this.f897l) {
            return this.f901p;
        }
        return m1456l();
    }

    /* renamed from: l */
    private List<LatLng> m1456l() throws RemoteException {
        if (this.f900o == null) {
            return null;
        }
        List<LatLng> arrayList = new ArrayList();
        for (IPoint iPoint : this.f900o) {
            if (iPoint != null) {
                DPoint dPoint = new DPoint();
                this.f892g.m1240b(iPoint.f3652x, iPoint.f3653y, dPoint);
                arrayList.add(new LatLng(dPoint.f3649y, dPoint.f3648x));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo196b(float f) throws RemoteException {
        this.f893h = f;
    }

    /* renamed from: g */
    public float mo199g() throws RemoteException {
        return this.f893h;
    }

    /* renamed from: b */
    public void mo197b(boolean z) {
        this.f897l = z;
    }

    /* renamed from: j */
    public boolean mo202j() {
        return this.f897l;
    }

    /* renamed from: c */
    public void mo198c(boolean z) throws RemoteException {
        if (this.f898m != z) {
            this.f898m = z;
        }
    }

    /* renamed from: k */
    public boolean mo203k() {
        return this.f898m;
    }

    /* renamed from: a */
    public void mo194a(int i) throws RemoteException {
        this.f894i = i;
        this.f886a = ((float) Color.alpha(i)) / 255.0f;
        this.f887b = ((float) Color.red(i)) / 255.0f;
        this.f888c = ((float) Color.green(i)) / 255.0f;
        this.f889d = ((float) Color.blue(i)) / 255.0f;
    }

    /* renamed from: h */
    public int mo200h() throws RemoteException {
        return this.f894i;
    }

    /* renamed from: a */
    public void mo36a(float f) throws RemoteException {
        this.f895j = f;
    }

    /* renamed from: d */
    public float mo49d() throws RemoteException {
        return this.f895j;
    }

    /* renamed from: a */
    public void mo42a(boolean z) throws RemoteException {
        this.f896k = z;
    }

    /* renamed from: e */
    public boolean mo51e() throws RemoteException {
        return this.f896k;
    }

    /* renamed from: a */
    public boolean mo44a(ak akVar) throws RemoteException {
        if (equals(akVar) || akVar.mo47c().equals(mo47c())) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int mo52f() throws RemoteException {
        return super.hashCode();
    }

    /* renamed from: a */
    public boolean mo43a() {
        if (this.f902q == null) {
            return false;
        }
        LatLngBounds x = this.f892g.m1280x();
        if (x == null) {
            return true;
        }
        if (x.contains(this.f902q) || this.f902q.intersects(x)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo38a(Canvas canvas) throws RemoteException {
        if (this.f900o != null && this.f900o.size() != 0 && this.f893h > 0.0f) {
            int i;
            Path path = new Path();
            Point a = this.f892g.mo144s().mo182a(new ac(((IPoint) this.f900o.get(0)).f3653y, ((IPoint) this.f900o.get(0)).f3652x), new Point());
            path.moveTo((float) a.x, (float) a.y);
            for (i = 1; i < this.f900o.size(); i++) {
                a = this.f892g.mo144s().mo182a(new ac(((IPoint) this.f900o.get(i)).f3653y, ((IPoint) this.f900o.get(i)).f3652x), new Point());
                path.lineTo((float) a.x, (float) a.y);
            }
            Paint paint = new Paint();
            paint.setColor(mo200h());
            paint.setAntiAlias(true);
            paint.setStrokeWidth(mo199g());
            paint.setStyle(Style.STROKE);
            if (this.f897l) {
                i = (int) mo199g();
                paint.setPathEffect(new DashPathEffect(new float[]{(float) (i * 3), (float) i, (float) (i * 3), (float) i}, 1.0f));
            }
            canvas.drawPath(path, paint);
        }
    }

    /* renamed from: m */
    public void mo58m() {
    }

    /* renamed from: a */
    IPoint m1457a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d, int i) {
        IPoint iPoint4 = new IPoint();
        double d2 = (double) (iPoint2.f3652x - iPoint.f3652x);
        double d3 = (double) (iPoint2.f3653y - iPoint.f3653y);
        iPoint4.f3653y = (int) (((((double) i) * d) / Math.sqrt(((d3 * d3) / (d2 * d2)) + 1.0d)) + ((double) iPoint3.f3653y));
        iPoint4.f3652x = (int) (((d3 * ((double) (iPoint3.f3653y - iPoint4.f3653y))) / d2) + ((double) iPoint3.f3652x));
        return iPoint4;
    }

    /* renamed from: a */
    void m1463a(List<IPoint> list, List<IPoint> list2, double d) {
        if (list.size() == 3) {
            for (int i = 0; i <= 10; i = (int) (((float) i) + 1.0f)) {
                float f = ((float) i) / 10.0f;
                IPoint iPoint = new IPoint();
                double d2 = ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(0)).f3652x)) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(1)).f3652x)) * d)) + ((double) (((float) ((IPoint) list.get(2)).f3652x) * (f * f)));
                double d3 = ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(0)).f3653y)) + (((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((double) ((IPoint) list.get(1)).f3653y)) * d)) + ((double) (((float) ((IPoint) list.get(2)).f3653y) * (f * f)));
                double d4 = (((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d)) + ((double) (f * f));
                iPoint.f3652x = (int) (d2 / ((((1.0d - ((double) f)) * (1.0d - ((double) f))) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * d)) + ((double) (f * f))));
                iPoint.f3653y = (int) (d3 / d4);
                list2.add(iPoint);
            }
        }
    }

    /* renamed from: a */
    void m1461a(LatLng latLng, LatLng latLng2, List<IPoint> list, Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i = latLng3.latitude > 0.0d ? 1 : -1;
        IPoint iPoint = new IPoint();
        this.f892g.m1201a(latLng.latitude, latLng.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f892g.m1201a(latLng2.latitude, latLng2.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f892g.m1201a(latLng3.latitude, latLng3.longitude, iPoint3);
        double cos = Math.cos(0.5d * abs);
        IPoint a = m1457a(iPoint, iPoint2, iPoint3, (Math.hypot((double) (iPoint.f3652x - iPoint2.f3652x), (double) (iPoint.f3653y - iPoint2.f3653y)) * 0.5d) * Math.tan(0.5d * abs), i);
        List arrayList = new ArrayList();
        arrayList.add(iPoint);
        arrayList.add(a);
        arrayList.add(iPoint2);
        m1463a(arrayList, list, cos);
    }
}
