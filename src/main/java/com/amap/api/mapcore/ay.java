package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: PopupOverlay */
class ay implements C0294z {
    /* renamed from: a */
    private boolean f1329a = false;
    /* renamed from: b */
    private int f1330b = 0;
    /* renamed from: c */
    private int f1331c = 0;
    /* renamed from: d */
    private FloatBuffer f1332d = null;
    /* renamed from: e */
    private String f1333e;
    /* renamed from: f */
    private FPoint f1334f;
    /* renamed from: g */
    private BitmapDescriptor f1335g;
    /* renamed from: h */
    private boolean f1336h = true;
    /* renamed from: i */
    private FloatBuffer f1337i;
    /* renamed from: j */
    private Object f1338j;
    /* renamed from: k */
    private int f1339k;
    /* renamed from: l */
    private C0313u f1340l = null;
    /* renamed from: m */
    private MapProjection f1341m = null;
    /* renamed from: n */
    private float f1342n = 0.5f;
    /* renamed from: o */
    private float f1343o = 1.0f;
    /* renamed from: p */
    private boolean f1344p;
    /* renamed from: q */
    private boolean f1345q = false;
    /* renamed from: r */
    private boolean f1346r = true;
    /* renamed from: s */
    private int f1347s = 20;

    /* renamed from: x */
    public boolean mo316x() {
        return this.f1329a;
    }

    /* renamed from: y */
    public void mo317y() {
        if (this.f1329a) {
            try {
                mo292b();
                if (this.f1335g != null) {
                    Bitmap bitmap = this.f1335g.getBitmap();
                    if (bitmap != null) {
                        bitmap.recycle();
                        this.f1335g = null;
                    }
                }
                if (this.f1337i != null) {
                    this.f1337i.clear();
                    this.f1337i = null;
                }
                if (this.f1332d != null) {
                    this.f1332d.clear();
                    this.f1332d = null;
                }
                this.f1334f = null;
                this.f1338j = null;
                this.f1339k = 0;
            } catch (Throwable th) {
                az.m3143a(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
                Log.d("destroy erro", "MarkerDelegateImp destroy");
            }
        }
    }

    /* renamed from: b */
    private void m1922b(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f1339k = 0;
            this.f1335g = bitmapDescriptor;
        }
    }

    public ay(MarkerOptions markerOptions, C0313u c0313u) {
        this.f1340l = c0313u;
        this.f1341m = c0313u.mo395c();
        m1922b(markerOptions.getIcon());
        this.f1330b = markerOptions.getInfoWindowOffsetX();
        this.f1331c = markerOptions.getInfoWindowOffsetY();
        this.f1336h = markerOptions.isVisible();
        this.f1333e = mo300h();
        mo310r();
    }

    /* renamed from: I */
    public int m1931I() {
        try {
            return m1933K().getWidth();
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: J */
    public int m1932J() {
        try {
            return m1933K().getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: d */
    public Rect mo295d() {
        return null;
    }

    /* renamed from: b */
    public boolean mo292b() {
        m1919L();
        if (this.f1339k != 0) {
            this.f1340l.mo402f(this.f1339k);
        }
        return true;
    }

    /* renamed from: L */
    private void m1919L() {
        if (this.f1340l != null) {
            this.f1340l.mo401e(false);
        }
    }

    /* renamed from: e */
    public LatLng mo297e() {
        return null;
    }

    /* renamed from: h */
    public String mo300h() {
        if (this.f1333e == null) {
            this.f1333e = "PopupOverlay";
        }
        return this.f1333e;
    }

    /* renamed from: a */
    public void m1941a(FPoint fPoint) {
        if (!fPoint.equals(this.f1334f)) {
            this.f1334f = fPoint;
        }
    }

    /* renamed from: a */
    public void mo282a(LatLng latLng) {
    }

    /* renamed from: a */
    public void mo284a(String str) {
    }

    /* renamed from: i */
    public String mo301i() {
        return null;
    }

    /* renamed from: b */
    public void mo290b(String str) {
    }

    /* renamed from: j */
    public String mo302j() {
        return null;
    }

    /* renamed from: a */
    public void mo287a(boolean z) {
    }

    /* renamed from: a */
    public void mo285a(ArrayList<BitmapDescriptor> arrayList) {
    }

    /* renamed from: w */
    public ArrayList<BitmapDescriptor> mo315w() {
        return null;
    }

    /* renamed from: a */
    public void mo281a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f1335g = bitmapDescriptor;
            this.f1345q = false;
            if (this.f1337i != null) {
                this.f1337i.clear();
                this.f1337i = null;
            }
            m1919L();
        }
    }

    /* renamed from: K */
    public BitmapDescriptor m1933K() {
        return this.f1335g;
    }

    /* renamed from: k */
    public boolean mo303k() {
        return false;
    }

    /* renamed from: l */
    public void mo304l() {
    }

    /* renamed from: m */
    public void mo305m() {
    }

    /* renamed from: n */
    public boolean mo306n() {
        return false;
    }

    /* renamed from: b */
    public void mo291b(boolean z) {
        if (!this.f1336h && z) {
            this.f1344p = true;
        }
        this.f1336h = z;
    }

    /* renamed from: o */
    public boolean mo307o() {
        return this.f1336h;
    }

    /* renamed from: a */
    public void mo278a(float f, float f2) {
        if (this.f1342n != f || this.f1343o != f2) {
            this.f1342n = f;
            this.f1343o = f2;
            m1919L();
        }
    }

    /* renamed from: a */
    public boolean mo288a(C0294z c0294z) throws RemoteException {
        if (equals(c0294z) || c0294z.mo300h().equals(mo300h())) {
            return true;
        }
        return false;
    }

    /* renamed from: q */
    public int mo309q() {
        return super.hashCode();
    }

    /* renamed from: r */
    public boolean mo310r() {
        if (this.f1334f == null) {
            return false;
        }
        IPoint iPoint = new IPoint();
        this.f1340l.mo395c().map2Win(this.f1334f.f3637x, this.f1334f.f3638y, iPoint);
        int I = m1931I();
        int J = m1932J();
        int i = (int) (((float) (iPoint.f3639x + this.f1330b)) - (((float) I) * this.f1342n));
        int i2 = (int) (((float) (iPoint.f3640y + this.f1331c)) + (((float) J) * (1.0f - this.f1343o)));
        if (i - I > this.f1340l.mo406h() || i < (-I) * 2 || i2 < (-J) * 2 || i2 - J > this.f1340l.mo409i() || this.f1335g == null) {
            return false;
        }
        I = this.f1335g.getWidth();
        float width = ((float) I) / ((float) this.f1335g.getBitmap().getWidth());
        float height = ((float) this.f1335g.getHeight()) / ((float) this.f1335g.getBitmap().getHeight());
        if (this.f1337i == null) {
            this.f1337i = C0405u.m3461a(new float[]{0.0f, height, width, height, width, 0.0f, 0.0f, 0.0f});
        }
        float[] fArr = new float[]{(float) i, (float) (this.f1340l.mo409i() - i2), 0.0f, (float) (i + I), (float) (this.f1340l.mo409i() - i2), 0.0f, (float) (I + i), (float) ((this.f1340l.mo409i() - i2) + J), 0.0f, (float) i, (float) ((this.f1340l.mo409i() - i2) + J), 0.0f};
        if (this.f1332d == null) {
            this.f1332d = C0405u.m3461a(fArr);
        } else {
            this.f1332d = C0405u.m3462a(fArr, this.f1332d);
        }
        return true;
    }

    /* renamed from: a */
    private void m1920a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(3042);
            gl10.glBlendFunc(1, 771);
            gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
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

    /* renamed from: a */
    public void m1945a(GL10 gl10) {
        if (this.f1336h && this.f1334f != null && m1933K() != null) {
            if (!this.f1345q) {
                try {
                    if (this.f1339k != 0) {
                        gl10.glDeleteTextures(1, new int[]{this.f1339k}, 0);
                        this.f1340l.mo402f(this.f1339k);
                    }
                    this.f1339k = m1921b(gl10);
                    if (this.f1335g != null) {
                        Bitmap bitmap = this.f1335g.getBitmap();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            C0405u.m3445a(gl10, this.f1339k, bitmap);
                        }
                        this.f1345q = true;
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "PopupOverlay", "drawMarker");
                    th.printStackTrace();
                    return;
                }
            }
            if (mo310r()) {
                gl10.glLoadIdentity();
                gl10.glViewport(0, 0, this.f1340l.mo406h(), this.f1340l.mo409i());
                gl10.glMatrixMode(5889);
                gl10.glLoadIdentity();
                gl10.glOrthof(0.0f, (float) this.f1340l.mo406h(), 0.0f, (float) this.f1340l.mo409i(), 1.0f, -1.0f);
                m1920a(gl10, this.f1339k, this.f1332d, this.f1337i);
                if (this.f1344p) {
                    mo319a();
                    this.f1344p = false;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo319a() {
    }

    /* renamed from: b */
    private int m1921b(GL10 gl10) {
        int F = this.f1340l.mo333F();
        if (F != 0) {
            return F;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: c */
    public boolean mo294c() {
        return this.f1346r;
    }

    /* renamed from: a */
    public void mo279a(int i) {
        if (i <= 1) {
            this.f1347s = 1;
        } else {
            this.f1347s = i;
        }
    }

    /* renamed from: a */
    public void mo283a(Object obj) {
        this.f1338j = obj;
    }

    /* renamed from: s */
    public Object mo311s() {
        return this.f1338j;
    }

    /* renamed from: c */
    public void mo293c(boolean z) {
    }

    /* renamed from: t */
    public boolean mo312t() {
        return false;
    }

    /* renamed from: v */
    public int mo314v() {
        return this.f1347s;
    }

    /* renamed from: g */
    public LatLng mo299g() {
        return null;
    }

    /* renamed from: z */
    public void mo318z() {
    }

    /* renamed from: d */
    public void mo296d(boolean z) throws RemoteException {
        m1919L();
    }

    /* renamed from: A */
    public boolean mo269A() {
        return false;
    }

    /* renamed from: a */
    public void mo277a(float f) throws RemoteException {
    }

    /* renamed from: p */
    public void mo308p() {
    }

    /* renamed from: a */
    public void mo286a(GL10 gl10, C0313u c0313u) {
    }

    /* renamed from: u */
    public float mo313u() {
        return 0.0f;
    }

    /* renamed from: b */
    public void m1950b(int i, int i2) throws RemoteException {
        this.f1330b = i;
        this.f1331c = i2;
    }

    /* renamed from: B */
    public int mo270B() {
        return this.f1330b;
    }

    /* renamed from: C */
    public int mo271C() {
        return this.f1331c;
    }

    /* renamed from: a */
    public void mo280a(int i, int i2) {
    }

    /* renamed from: D */
    public int mo272D() {
        return 0;
    }

    /* renamed from: E */
    public int mo273E() {
        return 0;
    }

    /* renamed from: f */
    public FPoint mo298f() {
        return this.f1334f;
    }

    /* renamed from: F */
    public boolean mo274F() {
        return false;
    }

    /* renamed from: b */
    public void mo289b(float f) {
    }

    /* renamed from: G */
    public float mo275G() {
        return 0.0f;
    }

    /* renamed from: H */
    public boolean mo276H() {
        return false;
    }
}
