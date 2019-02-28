package com.amap.api.p015a;

import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.p015a.C0262t.C0261a;
import com.autonavi.amap.mapcore2d.IPoint;

/* compiled from: AMapCallback */
/* renamed from: com.amap.api.a.a */
class C0205a {
    /* renamed from: a */
    IPoint f601a = new IPoint();
    /* renamed from: b */
    int f602b;
    /* renamed from: c */
    IPoint f603c = new IPoint();
    /* renamed from: d */
    private C0222b f604d;

    public C0205a(C0222b c0222b) {
        this.f604d = c0222b;
    }

    /* renamed from: a */
    protected void m812a(C0262t c0262t) throws RemoteException {
        int f = (int) this.f604d.mo130f();
        if (c0262t.f1137a == C0261a.scrollBy) {
            this.f604d.f722a.m1090c((int) c0262t.f1138b, (int) c0262t.f1139c);
            this.f604d.postInvalidate();
        } else if (c0262t.f1137a == C0261a.zoomIn) {
            this.f604d.m1176D().m1091c();
        } else if (c0262t.f1137a == C0261a.zoomOut) {
            this.f604d.m1176D().m1092d();
        } else if (c0262t.f1137a == C0261a.zoomTo) {
            this.f604d.m1176D().m1089c((int) c0262t.f1140d);
        } else if (c0262t.f1137a == C0261a.zoomBy) {
            int a = this.f604d.m1192a((int) (c0262t.f1141e + ((float) f)));
            Point point = c0262t.f1149m;
            float f2 = (float) (a - f);
            if (point != null) {
                this.f604d.m1203a(f2, point, false);
            } else {
                this.f604d.m1176D().m1089c(a);
            }
        } else if (c0262t.f1137a == C0261a.newCameraPosition) {
            r1 = c0262t.f1144h;
            this.f604d.m1176D().m1089c((int) r1.zoom);
            this.f604d.m1176D().m1083a(new ac((int) (r1.target.latitude * 1000000.0d), (int) (r1.target.longitude * 1000000.0d)));
        } else if (c0262t.f1137a == C0261a.changeCenter) {
            r1 = c0262t.f1144h;
            this.f604d.m1176D().m1083a(new ac((int) (r1.target.latitude * 1000000.0d), (int) (r1.target.longitude * 1000000.0d)));
        } else if (c0262t.f1137a == C0261a.newLatLngBounds || c0262t.f1137a == C0261a.newLatLngBoundsWithSize) {
            this.f604d.m1249c(c0262t);
        } else {
            c0262t.f1151o = true;
        }
        if (f != this.f602b && this.f604d.mo142q().mo240a()) {
            this.f604d.m1184L();
        }
    }
}
