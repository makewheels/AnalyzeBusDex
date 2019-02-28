package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.C0376e;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GroundOverlayDelegateImp */
/* renamed from: com.amap.api.mapcore.t */
public class C0353t implements C0352x {
    /* renamed from: a */
    private C0313u f1892a;
    /* renamed from: b */
    private BitmapDescriptor f1893b;
    /* renamed from: c */
    private LatLng f1894c;
    /* renamed from: d */
    private float f1895d;
    /* renamed from: e */
    private float f1896e;
    /* renamed from: f */
    private LatLngBounds f1897f;
    /* renamed from: g */
    private float f1898g;
    /* renamed from: h */
    private float f1899h;
    /* renamed from: i */
    private boolean f1900i = true;
    /* renamed from: j */
    private float f1901j = 0.0f;
    /* renamed from: k */
    private float f1902k = 0.5f;
    /* renamed from: l */
    private float f1903l = 0.5f;
    /* renamed from: m */
    private String f1904m;
    /* renamed from: n */
    private FloatBuffer f1905n = null;
    /* renamed from: o */
    private FloatBuffer f1906o;
    /* renamed from: p */
    private int f1907p;
    /* renamed from: q */
    private boolean f1908q = false;
    /* renamed from: r */
    private boolean f1909r = false;

    public C0353t(C0313u c0313u) {
        this.f1892a = c0313u;
        try {
            this.f1904m = mo468c();
        } catch (Throwable e) {
            az.m3143a(e, "GroundOverlayDelegateImp", "create");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo465b() throws RemoteException {
        this.f1892a.mo402f(this.f1907p);
        this.f1892a.mo385a(mo468c());
        this.f1892a.mo401e(false);
    }

    /* renamed from: c */
    public String mo468c() throws RemoteException {
        if (this.f1904m == null) {
            this.f1904m = C0350r.m2938a("GroundOverlay");
        }
        return this.f1904m;
    }

    /* renamed from: a */
    public void mo458a(float f) throws RemoteException {
        this.f1899h = f;
        this.f1892a.mo335H();
        this.f1892a.mo401e(false);
    }

    /* renamed from: d */
    public float mo469d() throws RemoteException {
        return this.f1899h;
    }

    /* renamed from: a */
    public void mo462a(boolean z) throws RemoteException {
        this.f1900i = z;
        this.f1892a.mo401e(false);
    }

    /* renamed from: e */
    public boolean mo470e() throws RemoteException {
        return this.f1900i;
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

    /* renamed from: g */
    public void mo472g() throws RemoteException {
        this.f1909r = false;
        if (this.f1894c == null) {
            m2966q();
        } else if (this.f1897f == null) {
            m2965p();
        } else {
            m2967r();
        }
    }

    /* renamed from: p */
    private void m2965p() {
        if (this.f1894c != null) {
            double cos = ((double) this.f1895d) / ((6371000.79d * Math.cos(this.f1894c.latitude * 0.01745329251994329d)) * 0.01745329251994329d);
            double d = ((double) this.f1896e) / 111194.94043265979d;
            this.f1897f = new LatLngBounds(new LatLng(this.f1894c.latitude - (((double) (1.0f - this.f1903l)) * d), this.f1894c.longitude - (((double) this.f1902k) * cos)), new LatLng((d * ((double) this.f1903l)) + this.f1894c.latitude, (cos * ((double) (1.0f - this.f1902k))) + this.f1894c.longitude));
            m2967r();
        }
    }

    /* renamed from: q */
    private void m2966q() {
        if (this.f1897f != null) {
            LatLng latLng = this.f1897f.southwest;
            LatLng latLng2 = this.f1897f.northeast;
            this.f1894c = new LatLng(latLng.latitude + (((double) (1.0f - this.f1903l)) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (((double) this.f1902k) * (latLng2.longitude - latLng.longitude)));
            this.f1895d = (float) (((6371000.79d * Math.cos(this.f1894c.latitude * 0.01745329251994329d)) * (latLng2.longitude - latLng.longitude)) * 0.01745329251994329d);
            this.f1896e = (float) (((latLng2.latitude - latLng.latitude) * 6371000.79d) * 0.01745329251994329d);
            m2967r();
        }
    }

    /* renamed from: r */
    private void m2967r() {
        if (this.f1897f != null) {
            float[] fArr = new float[12];
            FPoint fPoint = new FPoint();
            FPoint fPoint2 = new FPoint();
            FPoint fPoint3 = new FPoint();
            FPoint fPoint4 = new FPoint();
            this.f1892a.mo352a(this.f1897f.southwest.latitude, this.f1897f.southwest.longitude, fPoint);
            this.f1892a.mo352a(this.f1897f.southwest.latitude, this.f1897f.northeast.longitude, fPoint2);
            this.f1892a.mo352a(this.f1897f.northeast.latitude, this.f1897f.northeast.longitude, fPoint3);
            this.f1892a.mo352a(this.f1897f.northeast.latitude, this.f1897f.southwest.longitude, fPoint4);
            if (this.f1898g != 0.0f) {
                double d = (double) (fPoint2.f3637x - fPoint.f3637x);
                double d2 = (double) (fPoint2.f3638y - fPoint3.f3638y);
                DPoint dPoint = new DPoint();
                dPoint.f3635x = ((double) fPoint.f3637x) + (((double) this.f1902k) * d);
                dPoint.f3636y = ((double) fPoint.f3638y) - (((double) (1.0f - this.f1903l)) * d2);
                m2963a(dPoint, 0.0d, 0.0d, d, d2, fPoint);
                m2963a(dPoint, d, 0.0d, d, d2, fPoint2);
                m2963a(dPoint, d, d2, d, d2, fPoint3);
                m2963a(dPoint, 0.0d, d2, d, d2, fPoint4);
            }
            fArr[0] = fPoint.f3637x;
            fArr[1] = fPoint.f3638y;
            fArr[2] = 0.0f;
            fArr[3] = fPoint2.f3637x;
            fArr[4] = fPoint2.f3638y;
            fArr[5] = 0.0f;
            fArr[6] = fPoint3.f3637x;
            fArr[7] = fPoint3.f3638y;
            fArr[8] = 0.0f;
            fArr[9] = fPoint4.f3637x;
            fArr[10] = fPoint4.f3638y;
            fArr[11] = 0.0f;
            if (this.f1905n == null) {
                this.f1905n = C0405u.m3461a(fArr);
                return;
            }
            this.f1905n = C0405u.m3462a(fArr, this.f1905n);
        }
    }

    /* renamed from: a */
    private void m2963a(DPoint dPoint, double d, double d2, double d3, double d4, FPoint fPoint) {
        double d5 = d - (((double) this.f1902k) * d3);
        double d6 = (((double) (1.0f - this.f1903l)) * d4) - d2;
        double d7 = ((double) (-this.f1898g)) * 0.01745329251994329d;
        fPoint.f3637x = (float) (dPoint.f3635x + ((Math.cos(d7) * d5) + (Math.sin(d7) * d6)));
        fPoint.f3638y = (float) (((d6 * Math.cos(d7)) - (d5 * Math.sin(d7))) + dPoint.f3636y);
    }

    /* renamed from: s */
    private void m2968s() {
        if (this.f1893b != null) {
            int width = this.f1893b.getWidth();
            float width2 = ((float) width) / ((float) this.f1893b.getBitmap().getWidth());
            float height = ((float) this.f1893b.getHeight()) / ((float) this.f1893b.getBitmap().getHeight());
            this.f1906o = C0405u.m3461a(new float[]{0.0f, height, width2, height, width2, 0.0f, 0.0f, 0.0f});
        }
    }

    /* renamed from: a */
    public void mo461a(GL10 gl10) throws RemoteException {
        if (!this.f1900i) {
            return;
        }
        if ((this.f1894c != null || this.f1897f != null) && this.f1893b != null) {
            if (!this.f1908q) {
                Bitmap bitmap = this.f1893b.getBitmap();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    if (this.f1907p == 0) {
                        this.f1907p = this.f1892a.mo333F();
                        if (this.f1907p == 0) {
                            int[] iArr = new int[]{0};
                            gl10.glGenTextures(1, iArr, 0);
                            this.f1907p = iArr[0];
                        }
                    } else {
                        gl10.glDeleteTextures(1, new int[]{this.f1907p}, 0);
                    }
                    C0405u.m3445a(gl10, this.f1907p, bitmap);
                }
                this.f1908q = true;
            }
            if (this.f1895d != 0.0f || this.f1896e != 0.0f) {
                m2964a(gl10, this.f1907p, this.f1905n, this.f1906o);
                this.f1909r = true;
            }
        }
    }

    /* renamed from: a */
    private void m2964a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(3042);
            gl10.glTexEnvf(8960, 8704, 8448.0f);
            gl10.glBlendFunc(1, 771);
            gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f - this.f1901j);
            gl10.glEnable(3553);
            gl10.glEnableClientState(32884);
            gl10.glEnableClientState(32888);
            gl10.glBindTexture(3553, i);
            gl10.glVertexPointer(3, 5126, 0, floatBuffer);
            gl10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            gl10.glDrawArrays(6, 0, 4);
            gl10.glDisableClientState(32884);
            gl10.glDisableClientState(32888);
            gl10.glDisable(3553);
            gl10.glDisable(3042);
        }
    }

    /* renamed from: j */
    public void mo475j() {
        try {
            mo465b();
            if (this.f1893b != null) {
                Bitmap bitmap = this.f1893b.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    this.f1893b = null;
                }
            }
            if (this.f1906o != null) {
                this.f1906o.clear();
                this.f1906o = null;
            }
            if (this.f1905n != null) {
                this.f1905n.clear();
                this.f1905n = null;
            }
            this.f1894c = null;
            this.f1897f = null;
        } catch (Throwable th) {
            az.m3143a(th, "GroundOverlayDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "GroundOverlayDelegateImp destroy");
        }
    }

    /* renamed from: a */
    public boolean mo463a() {
        if (this.f1897f == null) {
            return false;
        }
        LatLngBounds B = this.f1892a.mo331B();
        if (B == null) {
            return true;
        }
        if (B.contains(this.f1897f) || this.f1897f.intersects(B)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo574a(LatLng latLng) throws RemoteException {
        this.f1894c = latLng;
        m2965p();
        this.f1892a.mo401e(false);
    }

    /* renamed from: h */
    public LatLng mo579h() throws RemoteException {
        return this.f1894c;
    }

    /* renamed from: b */
    public void mo576b(float f) throws RemoteException {
        C0376e.m3324b(f >= 0.0f, "Width must be non-negative");
        if (!this.f1908q || this.f1895d == f) {
            this.f1895d = f;
            this.f1896e = f;
        } else {
            this.f1895d = f;
            this.f1896e = f;
            m2965p();
        }
        this.f1892a.mo401e(false);
    }

    /* renamed from: a */
    public void mo572a(float f, float f2) throws RemoteException {
        boolean z = true;
        C0376e.m3324b(f >= 0.0f, "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        C0376e.m3324b(z, "Height must be non-negative");
        if (!this.f1908q || this.f1895d == f || this.f1896e == f2) {
            this.f1895d = f;
            this.f1896e = f2;
        } else {
            this.f1895d = f;
            this.f1896e = f2;
            m2965p();
        }
        this.f1892a.mo401e(false);
    }

    /* renamed from: i */
    public float mo580i() throws RemoteException {
        return this.f1895d;
    }

    /* renamed from: l */
    public float mo581l() throws RemoteException {
        return this.f1896e;
    }

    /* renamed from: a */
    public void mo575a(LatLngBounds latLngBounds) throws RemoteException {
        this.f1897f = latLngBounds;
        m2966q();
        this.f1892a.mo401e(false);
    }

    /* renamed from: m */
    public LatLngBounds mo582m() throws RemoteException {
        return this.f1897f;
    }

    /* renamed from: c */
    public void mo577c(float f) throws RemoteException {
        float f2 = ((f % 360.0f) + 360.0f) % 360.0f;
        if (!this.f1908q || ((double) Math.abs(this.f1898g - f2)) <= 1.0E-7d) {
            this.f1898g = f2;
        } else {
            this.f1898g = f2;
            m2967r();
        }
        this.f1892a.mo401e(false);
    }

    /* renamed from: n */
    public float mo583n() throws RemoteException {
        return this.f1898g;
    }

    /* renamed from: d */
    public void mo578d(float f) throws RemoteException {
        boolean z = f >= 0.0f && f <= 1.0f;
        C0376e.m3324b(z, "Transparency must be in the range [0..1]");
        this.f1901j = f;
        this.f1892a.mo401e(false);
    }

    /* renamed from: o */
    public float mo584o() throws RemoteException {
        return this.f1901j;
    }

    /* renamed from: a */
    public void mo573a(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        this.f1893b = bitmapDescriptor;
        m2968s();
        if (this.f1908q) {
            this.f1908q = false;
        }
        this.f1892a.mo401e(false);
    }

    /* renamed from: b */
    public void m2980b(float f, float f2) throws RemoteException {
        this.f1902k = f;
        this.f1903l = f2;
        this.f1892a.mo401e(false);
    }

    /* renamed from: k */
    public boolean mo476k() {
        return this.f1909r;
    }
}
