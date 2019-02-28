package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES10;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.bz;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: MarkerDelegateImp */
class ar implements C0294z {
    /* renamed from: a */
    private static int f1501a = 0;
    /* renamed from: A */
    private an f1502A;
    /* renamed from: B */
    private FloatBuffer f1503B;
    /* renamed from: C */
    private Object f1504C;
    /* renamed from: D */
    private boolean f1505D = false;
    /* renamed from: E */
    private CopyOnWriteArrayList<BitmapDescriptor> f1506E = null;
    /* renamed from: F */
    private boolean f1507F = false;
    /* renamed from: G */
    private boolean f1508G = false;
    /* renamed from: H */
    private boolean f1509H = true;
    /* renamed from: I */
    private int f1510I = 0;
    /* renamed from: J */
    private int f1511J = 20;
    /* renamed from: K */
    private boolean f1512K = false;
    /* renamed from: L */
    private int f1513L;
    /* renamed from: M */
    private int f1514M;
    /* renamed from: b */
    private boolean f1515b = false;
    /* renamed from: c */
    private boolean f1516c = false;
    /* renamed from: d */
    private boolean f1517d = false;
    /* renamed from: e */
    private float f1518e = 0.0f;
    /* renamed from: f */
    private float f1519f = 0.0f;
    /* renamed from: g */
    private boolean f1520g = false;
    /* renamed from: h */
    private int f1521h = 0;
    /* renamed from: i */
    private int f1522i = 0;
    /* renamed from: j */
    private int f1523j = 0;
    /* renamed from: k */
    private int f1524k = 0;
    /* renamed from: l */
    private FPoint f1525l = new FPoint();
    /* renamed from: m */
    private float[] f1526m;
    /* renamed from: n */
    private int[] f1527n = null;
    /* renamed from: o */
    private float f1528o = 0.0f;
    /* renamed from: p */
    private boolean f1529p = false;
    /* renamed from: q */
    private FloatBuffer f1530q = null;
    /* renamed from: r */
    private String f1531r;
    /* renamed from: s */
    private LatLng f1532s;
    /* renamed from: t */
    private LatLng f1533t;
    /* renamed from: u */
    private String f1534u;
    /* renamed from: v */
    private String f1535v;
    /* renamed from: w */
    private float f1536w = 0.5f;
    /* renamed from: x */
    private float f1537x = 1.0f;
    /* renamed from: y */
    private boolean f1538y = false;
    /* renamed from: z */
    private boolean f1539z = true;

    /* renamed from: c */
    private static String m2476c(String str) {
        f1501a++;
        return str + f1501a;
    }

    /* renamed from: a */
    public void mo277a(float f) {
        this.f1519f = f;
        this.f1518e = (((-f) % 360.0f) + 360.0f) % 360.0f;
        if (mo306n()) {
            this.f1502A.m2465e(this);
            this.f1502A.m2462d(this);
        }
        m2471L();
    }

    /* renamed from: x */
    public boolean mo316x() {
        return this.f1529p;
    }

    /* renamed from: y */
    public synchronized void mo317y() {
        if (this.f1529p) {
            try {
                mo292b();
                if (this.f1506E != null) {
                    Iterator it = this.f1506E.iterator();
                    while (it.hasNext()) {
                        Bitmap bitmap = ((BitmapDescriptor) it.next()).getBitmap();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                    }
                    this.f1506E = null;
                }
                if (this.f1503B != null) {
                    this.f1503B.clear();
                    this.f1503B = null;
                }
                if (this.f1530q != null) {
                    this.f1530q.clear();
                    this.f1530q = null;
                }
                this.f1532s = null;
                this.f1504C = null;
            } catch (Throwable th) {
                az.m3143a(th, "MarkerDelegateImp", "realdestroy");
                th.printStackTrace();
                Log.d("destroy erro", "MarkerDelegateImp destroy");
            }
        }
        return;
    }

    /* renamed from: p */
    public void mo308p() {
        try {
            this.f1529p = true;
            if (!(this.f1502A == null || this.f1502A.f1485a == null)) {
                this.f1502A.m2465e(this);
                this.f1502A.f1485a.mo336I();
            }
            this.f1527n = null;
        } catch (Throwable th) {
            az.m3143a(th, "MarkerDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    /* renamed from: a */
    synchronized void m2488a() {
        if (this.f1506E == null) {
            this.f1506E = new CopyOnWriteArrayList();
        } else {
            this.f1506E.clear();
        }
    }

    /* renamed from: b */
    public synchronized void m2503b(ArrayList<BitmapDescriptor> arrayList) {
        m2488a();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) it.next();
                if (bitmapDescriptor != null) {
                    this.f1506E.add(bitmapDescriptor);
                }
            }
        }
    }

    public ar(MarkerOptions markerOptions, an anVar) {
        this.f1502A = anVar;
        this.f1507F = markerOptions.isGps();
        if (markerOptions.getPosition() != null) {
            if (this.f1507F) {
                try {
                    double[] a = bz.m3310a(markerOptions.getPosition().longitude, markerOptions.getPosition().latitude);
                    this.f1533t = new LatLng(a[1], a[0]);
                } catch (Throwable th) {
                    az.m3143a(th, "MarkerDelegateImp", "create");
                    this.f1533t = markerOptions.getPosition();
                }
            }
            this.f1532s = markerOptions.getPosition();
            mo310r();
        }
        this.f1536w = markerOptions.getAnchorU();
        this.f1537x = markerOptions.getAnchorV();
        this.f1521h = markerOptions.getInfoWindowOffsetX();
        this.f1522i = markerOptions.getInfoWindowOffsetY();
        this.f1511J = markerOptions.getPeriod();
        this.f1528o = markerOptions.getZIndex();
        m2503b(markerOptions.getIcons());
        this.f1539z = markerOptions.isVisible();
        this.f1535v = markerOptions.getSnippet();
        this.f1534u = markerOptions.getTitle();
        this.f1538y = markerOptions.isDraggable();
        this.f1531r = mo300h();
        this.f1505D = markerOptions.isPerspective();
        this.f1520g = markerOptions.isFlat();
    }

    /* renamed from: I */
    public int m2485I() {
        try {
            return m2487K().getWidth();
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: J */
    public int m2486J() {
        try {
            return m2487K().getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: d */
    public Rect mo295d() {
        if (this.f1526m == null) {
            return new Rect(0, 0, 0, 0);
        }
        try {
            Rect rect;
            MapProjection c = this.f1502A.f1485a.mo395c();
            int I = m2485I();
            int J = m2486J();
            IPoint iPoint = new IPoint();
            IPoint iPoint2 = new IPoint();
            c.map2Win(this.f1525l.f3637x, this.f1525l.f3638y, iPoint);
            if (this.f1520g) {
                c.map2Win(this.f1526m[0], this.f1526m[1], iPoint2);
                rect = new Rect(iPoint2.f3639x, iPoint2.f3640y, iPoint2.f3639x, iPoint2.f3640y);
                c.map2Win(this.f1526m[3], this.f1526m[4], iPoint2);
                rect.union(iPoint2.f3639x, iPoint2.f3640y);
                c.map2Win(this.f1526m[6], this.f1526m[7], iPoint2);
                rect.union(iPoint2.f3639x, iPoint2.f3640y);
                c.map2Win(this.f1526m[9], this.f1526m[10], iPoint2);
                rect.union(iPoint2.f3639x, iPoint2.f3640y);
            } else {
                m2473a((-this.f1536w) * ((float) I), (this.f1537x - 1.0f) * ((float) J), iPoint2);
                rect = new Rect(iPoint.f3639x + iPoint2.f3639x, iPoint.f3640y - iPoint2.f3640y, iPoint.f3639x + iPoint2.f3639x, iPoint.f3640y - iPoint2.f3640y);
                m2473a((-this.f1536w) * ((float) I), this.f1537x * ((float) J), iPoint2);
                rect.union(iPoint.f3639x + iPoint2.f3639x, iPoint.f3640y - iPoint2.f3640y);
                m2473a((1.0f - this.f1536w) * ((float) I), this.f1537x * ((float) J), iPoint2);
                rect.union(iPoint.f3639x + iPoint2.f3639x, iPoint.f3640y - iPoint2.f3640y);
                m2473a((1.0f - this.f1536w) * ((float) I), (this.f1537x - 1.0f) * ((float) J), iPoint2);
                rect.union(iPoint.f3639x + iPoint2.f3639x, iPoint.f3640y - iPoint2.f3640y);
            }
            this.f1523j = rect.centerX() - iPoint.f3639x;
            this.f1524k = rect.top - iPoint.f3640y;
            return rect;
        } catch (Throwable th) {
            az.m3143a(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    /* renamed from: b */
    public synchronized boolean mo292b() {
        m2471L();
        this.f1539z = false;
        return this.f1502A.m2459b((C0294z) this);
    }

    /* renamed from: L */
    private void m2471L() {
        if (this.f1502A.f1485a != null) {
            this.f1502A.f1485a.mo401e(false);
        }
    }

    /* renamed from: e */
    public LatLng mo297e() {
        if (this.f1525l == null) {
            return this.f1532s;
        }
        DPoint dPoint = new DPoint();
        IPoint iPoint = new IPoint();
        this.f1502A.f1485a.mo355a(this.f1525l.f3637x, this.f1525l.f3638y, iPoint);
        MapProjection.geo2LonLat(iPoint.f3639x, iPoint.f3640y, dPoint);
        return new LatLng(dPoint.f3636y, dPoint.f3635x);
    }

    /* renamed from: h */
    public String mo300h() {
        if (this.f1531r == null) {
            this.f1531r = m2476c("Marker");
        }
        return this.f1531r;
    }

    /* renamed from: a */
    public void mo282a(LatLng latLng) {
        if (this.f1507F) {
            try {
                double[] a = bz.m3310a(latLng.longitude, latLng.latitude);
                this.f1533t = new LatLng(a[1], a[0]);
            } catch (Throwable th) {
                this.f1533t = latLng;
            }
        }
        this.f1532s = latLng;
        this.f1512K = false;
        mo310r();
        m2471L();
    }

    /* renamed from: a */
    public void mo284a(String str) {
        this.f1534u = str;
        m2471L();
    }

    /* renamed from: i */
    public String mo301i() {
        return this.f1534u;
    }

    /* renamed from: b */
    public void mo290b(String str) {
        this.f1535v = str;
        m2471L();
    }

    /* renamed from: j */
    public String mo302j() {
        return this.f1535v;
    }

    /* renamed from: a */
    public void mo287a(boolean z) {
        this.f1538y = z;
        m2471L();
    }

    /* renamed from: a */
    public synchronized void mo285a(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            try {
                if (this.f1506E != null) {
                    m2503b((ArrayList) arrayList);
                    this.f1508G = false;
                    this.f1515b = false;
                    if (this.f1503B != null) {
                        this.f1503B.clear();
                        this.f1503B = null;
                    }
                    this.f1527n = null;
                    if (mo306n()) {
                        this.f1502A.m2465e(this);
                        this.f1502A.m2462d(this);
                    }
                    m2471L();
                }
            } catch (Throwable th) {
                az.m3143a(th, "MarkerDelegateImp", "setIcons");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: w */
    public synchronized ArrayList<BitmapDescriptor> mo315w() {
        ArrayList<BitmapDescriptor> arrayList;
        if (this.f1506E == null || this.f1506E.size() <= 0) {
            arrayList = null;
        } else {
            ArrayList<BitmapDescriptor> arrayList2 = new ArrayList();
            Iterator it = this.f1506E.iterator();
            while (it.hasNext()) {
                arrayList2.add((BitmapDescriptor) it.next());
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void mo281a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.f1506E != null) {
                    this.f1506E.clear();
                    this.f1506E.add(bitmapDescriptor);
                    this.f1508G = false;
                    this.f1515b = false;
                    this.f1527n = null;
                    if (this.f1503B != null) {
                        this.f1503B.clear();
                        this.f1503B = null;
                    }
                    if (mo306n()) {
                        this.f1502A.m2465e(this);
                        this.f1502A.m2462d(this);
                    }
                    m2471L();
                }
            } catch (Throwable th) {
                az.m3143a(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: K */
    public synchronized BitmapDescriptor m2487K() {
        BitmapDescriptor K;
        try {
            if (this.f1506E == null || this.f1506E.size() == 0) {
                m2488a();
                this.f1506E.add(BitmapDescriptorFactory.defaultMarker());
            } else if (this.f1506E.get(0) == null) {
                this.f1506E.clear();
                K = m2487K();
            }
            K = (BitmapDescriptor) this.f1506E.get(0);
        } catch (Throwable th) {
            az.m3143a(th, "MarkerDelegateImp", "getBitmapDescriptor");
            th.printStackTrace();
            K = null;
        }
        return K;
    }

    /* renamed from: k */
    public boolean mo303k() {
        return this.f1538y;
    }

    /* renamed from: l */
    public void mo304l() {
        if (this.f1539z) {
            this.f1502A.m2462d(this);
            m2471L();
        }
    }

    /* renamed from: m */
    public void mo305m() {
        if (mo306n()) {
            this.f1502A.m2465e(this);
            m2471L();
        }
    }

    /* renamed from: n */
    public boolean mo306n() {
        return this.f1502A.m2467f(this);
    }

    /* renamed from: b */
    public void mo291b(boolean z) {
        if (this.f1539z != z) {
            this.f1539z = z;
            if (!z && mo306n()) {
                this.f1502A.m2465e(this);
            }
            m2471L();
        }
    }

    /* renamed from: o */
    public boolean mo307o() {
        return this.f1539z;
    }

    /* renamed from: a */
    public void mo278a(float f, float f2) {
        if (this.f1536w != f || this.f1537x != f2) {
            this.f1536w = f;
            this.f1537x = f2;
            if (mo306n()) {
                this.f1502A.m2465e(this);
                this.f1502A.m2462d(this);
            }
            m2471L();
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
        if (this.f1512K) {
            this.f1502A.f1485a.mo395c().win2Map(this.f1513L, this.f1514M, this.f1525l);
        } else if (this.f1507F && this.f1533t != null) {
            this.f1502A.f1485a.mo352a(this.f1533t.latitude, this.f1533t.longitude, this.f1525l);
        } else if (this.f1532s != null) {
            this.f1502A.f1485a.mo352a(this.f1532s.latitude, this.f1532s.longitude, this.f1525l);
        }
        return true;
    }

    /* renamed from: a */
    private void m2475a(C0313u c0313u) throws RemoteException {
        float[] a = C0405u.m3470a(c0313u, this.f1520g ? 1 : 0, this.f1525l, this.f1518e, m2485I(), m2486J(), this.f1536w, this.f1537x);
        this.f1526m = (float[]) a.clone();
        if (this.f1530q == null) {
            this.f1530q = C0405u.m3461a(a);
        } else {
            this.f1530q = C0405u.m3462a(a, this.f1530q);
        }
        if (this.f1506E != null && this.f1506E.size() > 0) {
            this.f1510I++;
            if (this.f1510I >= this.f1511J * this.f1506E.size()) {
                this.f1510I = 0;
            }
            int i = this.f1510I / this.f1511J;
            if (!this.f1509H) {
                m2471L();
            }
            if (this.f1527n != null && this.f1527n.length > 0) {
                m2474a(this.f1527n[i % this.f1506E.size()], this.f1530q, this.f1503B);
            }
        }
    }

    /* renamed from: a */
    private void m2473a(float f, float f2, IPoint iPoint) {
        float f3 = (float) ((3.141592653589793d * ((double) this.f1518e)) / 180.0d);
        iPoint.f3639x = (int) ((((double) f) * Math.cos((double) f3)) + (((double) f2) * Math.sin((double) f3)));
        iPoint.f3640y = (int) ((((double) f2) * Math.cos((double) f3)) - (((double) f) * Math.sin((double) f3)));
    }

    /* renamed from: a */
    private void m2474a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i != 0 && floatBuffer != null && floatBuffer2 != null) {
            GLES10.glEnable(3042);
            GLES10.glBlendFunc(1, 771);
            GLES10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GLES10.glEnable(3553);
            GLES10.glEnableClientState(32884);
            GLES10.glEnableClientState(32888);
            GLES10.glBindTexture(3553, i);
            GLES10.glVertexPointer(3, 5126, 0, floatBuffer);
            GLES10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            GLES10.glDrawArrays(6, 0, 4);
            GLES10.glDisableClientState(32884);
            GLES10.glDisableClientState(32888);
            GLES10.glDisable(3553);
            GLES10.glDisable(3042);
        }
    }

    /* renamed from: a */
    public void mo286a(GL10 gl10, C0313u c0313u) {
        int i = 0;
        if (!this.f1539z) {
            return;
        }
        if (this.f1532s == null && !this.f1512K) {
            return;
        }
        if (m2487K() != null || this.f1506E != null) {
            int i2;
            int i3;
            BitmapDescriptor bitmapDescriptor;
            if (!this.f1508G) {
                try {
                    if (this.f1506E != null) {
                        this.f1527n = new int[this.f1506E.size()];
                        i2 = VERSION.SDK_INT >= 12 ? 1 : 0;
                        Iterator it = this.f1506E.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            bitmapDescriptor = (BitmapDescriptor) it.next();
                            if (i2 != 0) {
                                i = this.f1502A.m2451a(bitmapDescriptor);
                            }
                            if (i == 0) {
                                Bitmap bitmap = bitmapDescriptor.getBitmap();
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    i = m2472a(gl10);
                                    if (i2 != 0) {
                                        this.f1502A.m2453a(new av(bitmapDescriptor, i));
                                    }
                                    C0405u.m3474b(gl10, i, bitmap, false);
                                }
                            }
                            int i4 = i;
                            this.f1527n[i3] = i4;
                            i3++;
                            i = i4;
                        }
                        if (this.f1506E.size() == 1) {
                            this.f1509H = true;
                        } else {
                            this.f1509H = false;
                        }
                        this.f1508G = true;
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "MarkerDelegateImp", "loadtexture");
                    th.printStackTrace();
                    return;
                }
            }
            try {
                if (!this.f1515b) {
                    if (this.f1503B == null) {
                        bitmapDescriptor = m2487K();
                        if (bitmapDescriptor != null) {
                            i = bitmapDescriptor.getWidth();
                            i3 = bitmapDescriptor.getHeight();
                            i2 = bitmapDescriptor.getBitmap().getHeight();
                            float width = ((float) i) / ((float) bitmapDescriptor.getBitmap().getWidth());
                            float f = ((float) i3) / ((float) i2);
                            this.f1503B = C0405u.m3461a(new float[]{0.0f, f, width, f, width, 0.0f, 0.0f, 0.0f});
                        } else {
                            return;
                        }
                    }
                    mo310r();
                    this.f1515b = true;
                }
                if (this.f1512K) {
                    c0313u.mo360a(this.f1513L, this.f1514M, this.f1525l);
                }
                m2475a(c0313u);
            } catch (Throwable th2) {
                az.m3143a(th2, "MarkerDelegateImp", "drawMarker");
            }
        }
    }

    /* renamed from: a */
    private int m2472a(GL10 gl10) {
        int F = this.f1502A.f1485a.mo333F();
        if (F != 0) {
            return F;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: c */
    public boolean mo294c() {
        return this.f1509H;
    }

    /* renamed from: a */
    public void mo279a(int i) {
        if (i <= 1) {
            this.f1511J = 1;
        } else {
            this.f1511J = i;
        }
    }

    /* renamed from: a */
    public void mo283a(Object obj) {
        this.f1504C = obj;
    }

    /* renamed from: s */
    public Object mo311s() {
        return this.f1504C;
    }

    /* renamed from: c */
    public void mo293c(boolean z) {
        this.f1505D = z;
    }

    /* renamed from: t */
    public boolean mo312t() {
        return this.f1505D;
    }

    /* renamed from: v */
    public int mo314v() {
        return this.f1511J;
    }

    /* renamed from: g */
    public LatLng mo299g() {
        if (!this.f1512K) {
            return this.f1507F ? this.f1533t : this.f1532s;
        } else {
            this.f1502A.f1485a.mo395c().win2Map(this.f1513L, this.f1514M, this.f1525l);
            DPoint dPoint = new DPoint();
            this.f1502A.f1485a.mo359a(this.f1513L, this.f1514M, dPoint);
            return new LatLng(dPoint.f3636y, dPoint.f3636y);
        }
    }

    /* renamed from: z */
    public void mo318z() {
        this.f1502A.m2461c(this);
    }

    /* renamed from: d */
    public void mo296d(boolean z) throws RemoteException {
        this.f1520g = z;
        m2471L();
    }

    /* renamed from: A */
    public boolean mo269A() {
        return this.f1520g;
    }

    /* renamed from: u */
    public float mo313u() {
        return this.f1519f;
    }

    /* renamed from: B */
    public int mo270B() {
        return this.f1521h;
    }

    /* renamed from: C */
    public int mo271C() {
        return this.f1522i;
    }

    /* renamed from: a */
    public void mo280a(int i, int i2) {
        int i3 = 1;
        this.f1513L = i;
        this.f1514M = i2;
        this.f1512K = true;
        mo310r();
        try {
            C0313u c0313u = this.f1502A.f1485a;
            if (!this.f1520g) {
                i3 = 0;
            }
            this.f1526m = C0405u.m3470a(c0313u, i3, this.f1525l, this.f1518e, m2485I(), m2486J(), this.f1536w, this.f1537x);
        } catch (Throwable th) {
            az.m3143a(th, "MarkerDelegateImp", "setPositionByPixels");
        }
        m2471L();
        if (mo306n()) {
            mo304l();
        }
    }

    /* renamed from: D */
    public int mo272D() {
        return this.f1523j;
    }

    /* renamed from: E */
    public int mo273E() {
        return this.f1524k;
    }

    /* renamed from: f */
    public FPoint mo298f() {
        return this.f1525l;
    }

    /* renamed from: F */
    public boolean mo274F() {
        return this.f1512K;
    }

    /* renamed from: b */
    public void mo289b(float f) {
        this.f1528o = f;
        this.f1502A.m2470i();
    }

    /* renamed from: G */
    public float mo275G() {
        return this.f1528o;
    }

    /* renamed from: H */
    public boolean mo276H() {
        LatLngBounds B = this.f1502A.f1485a.mo331B();
        if (this.f1512K || B == null) {
            return true;
        }
        if (this.f1507F && this.f1533t != null) {
            return B.contains(this.f1533t);
        }
        if (this.f1532s != null) {
            return B.contains(this.f1532s);
        }
        return true;
    }
}
