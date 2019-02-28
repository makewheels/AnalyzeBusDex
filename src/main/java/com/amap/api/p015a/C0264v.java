package com.amap.api.p015a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.LatLng;

/* compiled from: CircleDelegateImp */
/* renamed from: com.amap.api.a.v */
class C0264v implements ag {
    /* renamed from: l */
    private static float f1154l = 4.0075016E7f;
    /* renamed from: m */
    private static int f1155m = 256;
    /* renamed from: n */
    private static int f1156n = 20;
    /* renamed from: a */
    private LatLng f1157a = null;
    /* renamed from: b */
    private double f1158b = 0.0d;
    /* renamed from: c */
    private float f1159c = 10.0f;
    /* renamed from: d */
    private int f1160d = -16777216;
    /* renamed from: e */
    private int f1161e = 0;
    /* renamed from: f */
    private float f1162f = 0.0f;
    /* renamed from: g */
    private boolean f1163g = true;
    /* renamed from: h */
    private String f1164h;
    /* renamed from: i */
    private C0222b f1165i;
    /* renamed from: j */
    private int f1166j = 0;
    /* renamed from: k */
    private int f1167k = 0;

    public C0264v(C0222b c0222b) {
        this.f1165i = c0222b;
        try {
            this.f1164h = mo47c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean mo43a() {
        return true;
    }

    /* renamed from: b */
    public void mo45b() throws RemoteException {
        this.f1165i.mo112a(mo47c());
        this.f1165i.postInvalidate();
    }

    /* renamed from: c */
    public String mo47c() throws RemoteException {
        if (this.f1164h == null) {
            this.f1164h = ab.m813a("Circle");
        }
        return this.f1164h;
    }

    /* renamed from: a */
    public void mo36a(float f) throws RemoteException {
        this.f1162f = f;
        this.f1165i.postInvalidate();
    }

    /* renamed from: d */
    public float mo49d() throws RemoteException {
        return this.f1162f;
    }

    /* renamed from: a */
    public void mo42a(boolean z) throws RemoteException {
        this.f1163g = z;
        this.f1165i.postInvalidate();
    }

    /* renamed from: e */
    public boolean mo51e() throws RemoteException {
        return this.f1163g;
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
        return 0;
    }

    /* renamed from: a */
    public void mo38a(Canvas canvas) throws RemoteException {
        if (mo263h() != null && this.f1158b > 0.0d && mo51e()) {
            float a = this.f1165i.mo84a().f836a.m1401a((float) mo264i());
            ac acVar = new ac((int) (this.f1157a.latitude * 1000000.0d), (int) (this.f1157a.longitude * 1000000.0d));
            Point point = new Point();
            this.f1165i.mo144s().mo182a(acVar, point);
            Paint paint = new Paint();
            paint.setColor(mo267l());
            paint.setAntiAlias(true);
            paint.setStyle(Style.FILL);
            canvas.drawCircle((float) point.x, (float) point.y, a, paint);
            paint.setColor(mo266k());
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth(mo265j());
            canvas.drawCircle((float) point.x, (float) point.y, a, paint);
        }
    }

    /* renamed from: g */
    void m1721g() {
        this.f1166j = 0;
        this.f1167k = 0;
    }

    /* renamed from: a */
    public void mo259a(LatLng latLng) throws RemoteException {
        this.f1157a = latLng;
        m1721g();
    }

    /* renamed from: h */
    public LatLng mo263h() throws RemoteException {
        return this.f1157a;
    }

    /* renamed from: a */
    public void mo257a(double d) throws RemoteException {
        this.f1158b = d;
        m1721g();
    }

    /* renamed from: i */
    public double mo264i() throws RemoteException {
        return this.f1158b;
    }

    /* renamed from: b */
    public void mo260b(float f) throws RemoteException {
        this.f1159c = f;
    }

    /* renamed from: j */
    public float mo265j() throws RemoteException {
        return this.f1159c;
    }

    /* renamed from: a */
    public void mo258a(int i) throws RemoteException {
        this.f1160d = i;
    }

    /* renamed from: k */
    public int mo266k() throws RemoteException {
        return this.f1160d;
    }

    /* renamed from: b */
    public void mo261b(int i) throws RemoteException {
        this.f1161e = i;
    }

    /* renamed from: l */
    public int mo267l() throws RemoteException {
        return this.f1161e;
    }

    /* renamed from: m */
    public void mo58m() {
        this.f1157a = null;
    }

    /* renamed from: b */
    public boolean mo262b(LatLng latLng) throws RemoteException {
        if (this.f1158b >= ((double) AMapUtils.calculateLineDistance(this.f1157a, latLng))) {
            return true;
        }
        return false;
    }
}
