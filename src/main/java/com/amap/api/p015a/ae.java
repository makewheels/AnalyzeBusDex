package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.p015a.p016a.C0171a;

/* compiled from: GroundOverlayDelegateImp */
/* renamed from: com.amap.api.a.ae */
public class ae implements ah {
    /* renamed from: a */
    final double f615a = 0.01745329251994329d;
    /* renamed from: b */
    final double f616b = 6371000.79d;
    /* renamed from: c */
    private C0222b f617c;
    /* renamed from: d */
    private BitmapDescriptor f618d;
    /* renamed from: e */
    private LatLng f619e;
    /* renamed from: f */
    private float f620f;
    /* renamed from: g */
    private float f621g;
    /* renamed from: h */
    private LatLngBounds f622h;
    /* renamed from: i */
    private float f623i;
    /* renamed from: j */
    private float f624j;
    /* renamed from: k */
    private boolean f625k = true;
    /* renamed from: l */
    private float f626l = 0.0f;
    /* renamed from: m */
    private float f627m = 0.5f;
    /* renamed from: n */
    private float f628n = 0.5f;
    /* renamed from: o */
    private String f629o;
    /* renamed from: p */
    private Bitmap f630p;

    public ae(C0222b c0222b) {
        this.f617c = c0222b;
        try {
            this.f629o = mo47c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo45b() throws RemoteException {
        this.f617c.mo112a(mo47c());
    }

    /* renamed from: c */
    public String mo47c() throws RemoteException {
        if (this.f629o == null) {
            this.f629o = ab.m813a("GroundOverlay");
        }
        return this.f629o;
    }

    /* renamed from: a */
    public void mo36a(float f) throws RemoteException {
        this.f624j = f;
    }

    /* renamed from: d */
    public float mo49d() throws RemoteException {
        return this.f624j;
    }

    /* renamed from: a */
    public void mo42a(boolean z) throws RemoteException {
        this.f625k = z;
    }

    /* renamed from: e */
    public boolean mo51e() throws RemoteException {
        return this.f625k;
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

    /* renamed from: g */
    public void m877g() throws RemoteException {
        if (this.f619e == null) {
            m858p();
        } else if (this.f622h == null) {
            m857o();
        }
    }

    /* renamed from: o */
    private void m857o() {
        double cos = ((double) this.f620f) / ((6371000.79d * Math.cos(this.f619e.latitude * 0.01745329251994329d)) * 0.01745329251994329d);
        double d = ((double) this.f621g) / 111194.94043265979d;
        this.f622h = new LatLngBounds(new LatLng(this.f619e.latitude - (((double) (1.0f - this.f628n)) * d), this.f619e.longitude - (((double) this.f627m) * cos)), new LatLng((d * ((double) this.f628n)) + this.f619e.latitude, (cos * ((double) (1.0f - this.f627m))) + this.f619e.longitude));
    }

    /* renamed from: p */
    private void m858p() {
        LatLng latLng = this.f622h.southwest;
        LatLng latLng2 = this.f622h.northeast;
        this.f619e = new LatLng(latLng.latitude + (((double) (1.0f - this.f628n)) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (((double) this.f627m) * (latLng2.longitude - latLng.longitude)));
        this.f620f = (float) (((6371000.79d * Math.cos(this.f619e.latitude * 0.01745329251994329d)) * (latLng2.longitude - latLng.longitude)) * 0.01745329251994329d);
        this.f621g = (float) (((latLng2.latitude - latLng.latitude) * 6371000.79d) * 0.01745329251994329d);
    }

    /* renamed from: m */
    public void mo58m() {
        try {
            mo45b();
            if (this.f618d != null) {
                Bitmap bitmap = this.f618d.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    this.f618d = null;
                }
            }
            this.f619e = null;
            this.f622h = null;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("destroy erro", "GroundOverlayDelegateImp destroy");
        }
    }

    /* renamed from: a */
    public boolean mo43a() {
        if (this.f622h == null) {
            return false;
        }
        LatLngBounds x = this.f617c.m1280x();
        if (x == null) {
            return true;
        }
        if (x.contains(this.f622h) || this.f622h.intersects(x)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo40a(LatLng latLng) throws RemoteException {
        if (this.f619e == null || this.f619e.equals(latLng)) {
            this.f619e = latLng;
            return;
        }
        this.f619e = latLng;
        m857o();
    }

    /* renamed from: h */
    public LatLng mo53h() throws RemoteException {
        return this.f619e;
    }

    /* renamed from: b */
    public void mo46b(float f) throws RemoteException {
        C0171a.m624b(f >= 0.0f, "Width must be non-negative");
        if (this.f620f != f) {
            this.f620f = f;
            this.f621g = f;
            return;
        }
        this.f620f = f;
        this.f621g = f;
    }

    /* renamed from: a */
    public void mo37a(float f, float f2) throws RemoteException {
        boolean z = true;
        C0171a.m624b(f >= 0.0f, "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        C0171a.m624b(z, "Height must be non-negative");
        if (this.f620f == f || this.f621g == f2) {
            this.f620f = f;
            this.f621g = f2;
            return;
        }
        this.f620f = f;
        this.f621g = f2;
    }

    /* renamed from: i */
    public float mo54i() throws RemoteException {
        return this.f620f;
    }

    /* renamed from: j */
    public float mo55j() throws RemoteException {
        return this.f621g;
    }

    /* renamed from: a */
    public void mo41a(LatLngBounds latLngBounds) throws RemoteException {
        if (this.f622h == null || this.f622h.equals(latLngBounds)) {
            this.f622h = latLngBounds;
            return;
        }
        this.f622h = latLngBounds;
        m858p();
    }

    /* renamed from: k */
    public LatLngBounds mo56k() throws RemoteException {
        return this.f622h;
    }

    /* renamed from: c */
    public void mo48c(float f) throws RemoteException {
        float f2 = (((-f) % 360.0f) + 360.0f) % 360.0f;
        if (Double.doubleToLongBits((double) this.f623i) != Double.doubleToLongBits((double) f2)) {
            this.f623i = f2;
        } else {
            this.f623i = f2;
        }
    }

    /* renamed from: l */
    public float mo57l() throws RemoteException {
        return this.f623i;
    }

    /* renamed from: d */
    public void mo50d(float f) throws RemoteException {
        boolean z = f >= 0.0f && f <= 1.0f;
        C0171a.m624b(z, "Transparency must be in the range [0..1]");
        this.f626l = f;
    }

    /* renamed from: n */
    public float mo59n() throws RemoteException {
        return this.f626l;
    }

    /* renamed from: a */
    public void mo39a(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        this.f618d = bitmapDescriptor;
    }

    /* renamed from: b */
    public void m870b(float f, float f2) throws RemoteException {
        this.f627m = f;
        this.f628n = f2;
    }

    /* renamed from: a */
    public void mo38a(Canvas canvas) throws RemoteException {
        if (!this.f625k) {
            return;
        }
        if ((this.f619e != null || this.f622h != null) && this.f618d != null) {
            m877g();
            if (this.f620f != 0.0f || this.f621g != 0.0f) {
                this.f630p = this.f618d.getBitmap();
                if (this.f630p != null && !this.f630p.isRecycled()) {
                    LatLng latLng = this.f622h.southwest;
                    LatLng latLng2 = this.f622h.northeast;
                    ac b = m856b(latLng);
                    ac b2 = m856b(latLng2);
                    Point point = new Point();
                    Point point2 = new Point();
                    this.f617c.mo144s().mo182a(b, point);
                    this.f617c.mo144s().mo182a(b2, point2);
                    Paint paint = new Paint();
                    RectF rectF = new RectF((float) point.x, (float) point2.y, (float) point2.x, (float) point.y);
                    paint.setAlpha((int) (255.0f - (this.f626l * 255.0f)));
                    paint.setFilterBitmap(true);
                    canvas.drawBitmap(this.f630p, null, rectF, paint);
                }
            }
        }
    }

    /* renamed from: b */
    private ac m856b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new ac((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }
}
