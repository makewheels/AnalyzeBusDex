package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.autonavi.amap.mapcore2d.FPoint;
import com.autonavi.amap.mapcore2d.IPoint;
import com.autonavi.p017a.C0590a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MarkerDelegateImp */
/* renamed from: com.amap.api.a.be */
class be implements aj {
    /* renamed from: a */
    private static int f788a = 0;
    /* renamed from: b */
    private int f789b = 0;
    /* renamed from: c */
    private float f790c = 0.0f;
    /* renamed from: d */
    private CopyOnWriteArrayList<BitmapDescriptor> f791d = null;
    /* renamed from: e */
    private int f792e = 20;
    /* renamed from: f */
    private String f793f;
    /* renamed from: g */
    private LatLng f794g;
    /* renamed from: h */
    private LatLng f795h;
    /* renamed from: i */
    private String f796i;
    /* renamed from: j */
    private String f797j;
    /* renamed from: k */
    private float f798k = 0.5f;
    /* renamed from: l */
    private float f799l = 1.0f;
    /* renamed from: m */
    private boolean f800m = false;
    /* renamed from: n */
    private boolean f801n = true;
    /* renamed from: o */
    private ay f802o;
    /* renamed from: p */
    private Object f803p;
    /* renamed from: q */
    private boolean f804q = false;
    /* renamed from: r */
    private C0224a f805r;

    /* compiled from: MarkerDelegateImp */
    /* renamed from: com.amap.api.a.be$a */
    public class C0224a extends Thread {
        /* renamed from: a */
        final /* synthetic */ be f787a;

        public C0224a(be beVar) {
            this.f787a = beVar;
        }

        public void run() {
            setName("MarkerThread");
            while (!Thread.currentThread().isInterrupted() && this.f787a.f791d != null && this.f787a.f791d.size() > 1) {
                if (this.f787a.f789b == this.f787a.f791d.size() - 1) {
                    this.f787a.f789b = 0;
                } else {
                    this.f787a.f789b = this.f787a.f789b + 1;
                }
                this.f787a.f802o.m1113a().postInvalidate();
                try {
                    Thread.sleep((long) (this.f787a.f792e * 250));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.f787a.f791d == null) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* renamed from: c */
    private static String m1310c(String str) {
        f788a++;
        return str + f788a;
    }

    /* renamed from: n */
    public void mo176n() {
        try {
            mo159a();
            Iterator it = this.f791d.iterator();
            while (it.hasNext()) {
                Bitmap bitmap = ((BitmapDescriptor) it.next()).getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
            this.f791d = null;
            this.f794g = null;
            this.f803p = null;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
        this.f805r = null;
    }

    /* renamed from: t */
    void m1347t() {
        if (this.f791d == null) {
            this.f791d = new CopyOnWriteArrayList();
        } else {
            this.f791d.clear();
        }
    }

    /* renamed from: b */
    public void m1328b(ArrayList<BitmapDescriptor> arrayList) {
        m1347t();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) it.next();
                if (bitmapDescriptor != null) {
                    this.f791d.add(bitmapDescriptor.clone());
                }
            }
            if (arrayList.size() > 1 && this.f805r == null) {
                this.f805r = new C0224a(this);
                this.f805r.start();
            }
        }
    }

    /* renamed from: b */
    private void m1308b(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            m1347t();
            this.f791d.add(bitmapDescriptor.clone());
        }
    }

    public be(MarkerOptions markerOptions, ay ayVar) {
        this.f802o = ayVar;
        this.f804q = markerOptions.isGps();
        if (markerOptions.getPosition() != null) {
            if (this.f804q) {
                try {
                    double[] a = C0590a.m4645a(markerOptions.getPosition().longitude, markerOptions.getPosition().latitude);
                    this.f795h = new LatLng(a[1], a[0]);
                } catch (Exception e) {
                    this.f795h = markerOptions.getPosition();
                }
            }
            this.f794g = markerOptions.getPosition();
        }
        this.f798k = markerOptions.getAnchorU();
        this.f799l = markerOptions.getAnchorV();
        this.f801n = markerOptions.isVisible();
        this.f797j = markerOptions.getSnippet();
        this.f796i = markerOptions.getTitle();
        this.f800m = markerOptions.isDraggable();
        this.f792e = markerOptions.getPeriod();
        this.f793f = mo167e();
        m1328b(markerOptions.getIcons());
        if (this.f791d != null && this.f791d.size() == 0) {
            m1308b(markerOptions.getIcon());
        }
    }

    /* renamed from: u */
    public IPoint m1348u() {
        if (mo165c() == null) {
            return null;
        }
        ac acVar;
        IPoint iPoint = new IPoint();
        if (this.f804q) {
            acVar = new ac((int) (mo166d().latitude * 1000000.0d), (int) (mo166d().longitude * 1000000.0d));
        } else {
            acVar = new ac((int) (mo165c().latitude * 1000000.0d), (int) (mo165c().longitude * 1000000.0d));
        }
        Point point = new Point();
        this.f802o.m1113a().mo144s().mo182a(acVar, point);
        iPoint.f3652x = point.x;
        iPoint.f3653y = point.y;
        return iPoint;
    }

    /* renamed from: q */
    public int mo179q() {
        return m1351x().getWidth();
    }

    /* renamed from: v */
    public int m1349v() {
        return m1351x().getHeight();
    }

    /* renamed from: f */
    public FPoint mo168f() {
        FPoint fPoint = new FPoint();
        if (!(this.f791d == null || this.f791d.size() == 0)) {
            fPoint.f3650x = ((float) mo179q()) * this.f798k;
            fPoint.f3651y = ((float) m1349v()) * this.f799l;
        }
        return fPoint;
    }

    /* renamed from: w */
    public IPoint m1350w() {
        IPoint u = m1348u();
        if (u == null) {
            return null;
        }
        return u;
    }

    /* renamed from: b */
    public Rect mo161b() {
        IPoint w = m1350w();
        if (w == null) {
            return new Rect(0, 0, 0, 0);
        }
        int q = mo179q();
        int v = m1349v();
        Rect rect = new Rect();
        if (this.f790c == 0.0f) {
            rect.top = (int) (((float) w.f3653y) - (((float) v) * this.f799l));
            rect.left = (int) (((float) w.f3652x) - (this.f798k * ((float) q)));
            rect.bottom = (int) ((((float) v) * (1.0f - this.f799l)) + ((float) w.f3653y));
            rect.right = (int) (((float) w.f3652x) + (((float) q) * (1.0f - this.f798k)));
            return rect;
        }
        IPoint b = m1307b((-this.f798k) * ((float) q), (this.f799l - 1.0f) * ((float) v));
        IPoint b2 = m1307b((-this.f798k) * ((float) q), this.f799l * ((float) v));
        IPoint b3 = m1307b((1.0f - this.f798k) * ((float) q), this.f799l * ((float) v));
        IPoint b4 = m1307b(((float) q) * (1.0f - this.f798k), ((float) v) * (this.f799l - 1.0f));
        rect.top = w.f3653y - Math.max(b.f3653y, Math.max(b2.f3653y, Math.max(b3.f3653y, b4.f3653y)));
        rect.left = w.f3652x + Math.min(b.f3652x, Math.min(b2.f3652x, Math.min(b3.f3652x, b4.f3652x)));
        rect.bottom = w.f3653y - Math.min(b.f3653y, Math.min(b2.f3653y, Math.min(b3.f3653y, b4.f3653y)));
        rect.right = w.f3652x + Math.max(b.f3652x, Math.max(b2.f3652x, Math.max(b3.f3652x, b4.f3652x)));
        return rect;
    }

    /* renamed from: b */
    private IPoint m1307b(float f, float f2) {
        float f3 = (float) ((3.141592653589793d * ((double) this.f790c)) / 180.0d);
        IPoint iPoint = new IPoint();
        iPoint.f3652x = (int) ((((double) f) * Math.cos((double) f3)) + (((double) f2) * Math.sin((double) f3)));
        iPoint.f3653y = (int) ((((double) f2) * Math.cos((double) f3)) - (((double) f) * Math.sin((double) f3)));
        return iPoint;
    }

    /* renamed from: a */
    public boolean mo159a() {
        return this.f802o.m1119b((aj) this);
    }

    /* renamed from: c */
    public LatLng mo165c() {
        return this.f794g;
    }

    /* renamed from: e */
    public String mo167e() {
        if (this.f793f == null) {
            this.f793f = be.m1310c("Marker");
        }
        return this.f793f;
    }

    /* renamed from: a */
    public void mo154a(LatLng latLng) {
        if (this.f804q) {
            try {
                double[] a = C0590a.m4645a(latLng.longitude, latLng.latitude);
                this.f795h = new LatLng(a[1], a[0]);
            } catch (Exception e) {
                this.f795h = latLng;
            }
        }
        this.f794g = latLng;
    }

    /* renamed from: b */
    public void mo162b(LatLng latLng) {
        if (this.f804q) {
            this.f795h = latLng;
        } else {
            this.f794g = latLng;
        }
    }

    /* renamed from: a */
    public void mo156a(String str) {
        this.f796i = str;
    }

    /* renamed from: g */
    public String mo169g() {
        return this.f796i;
    }

    /* renamed from: b */
    public void mo163b(String str) {
        this.f797j = str;
    }

    /* renamed from: h */
    public String mo170h() {
        return this.f797j;
    }

    /* renamed from: a */
    public void mo158a(boolean z) {
        this.f800m = z;
    }

    /* renamed from: a */
    public void mo153a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null && this.f791d != null) {
            this.f791d.clear();
            this.f791d.add(bitmapDescriptor);
            if (mo174l()) {
                this.f802o.m1125e(this);
                this.f802o.m1123d(this);
            }
        }
    }

    /* renamed from: x */
    public BitmapDescriptor m1351x() {
        if (this.f791d == null || this.f791d.size() == 0) {
            m1347t();
            this.f791d.add(BitmapDescriptorFactory.defaultMarker());
        } else if (this.f791d.get(0) == null) {
            this.f791d.clear();
            return m1351x();
        }
        return (BitmapDescriptor) this.f791d.get(0);
    }

    /* renamed from: i */
    public boolean mo171i() {
        return this.f800m;
    }

    /* renamed from: j */
    public void mo172j() {
        if (mo175m()) {
            this.f802o.m1123d(this);
        }
    }

    /* renamed from: k */
    public void mo173k() {
        if (mo174l()) {
            this.f802o.m1125e(this);
        }
    }

    /* renamed from: l */
    public boolean mo174l() {
        return this.f802o.m1127f(this);
    }

    /* renamed from: b */
    public void mo164b(boolean z) {
        this.f801n = z;
        if (!z && mo174l()) {
            this.f802o.m1125e(this);
        }
    }

    /* renamed from: m */
    public boolean mo175m() {
        return this.f801n;
    }

    /* renamed from: a */
    public void mo150a(float f, float f2) {
        if (this.f798k != f || this.f799l != f2) {
            this.f798k = f;
            this.f799l = f2;
            if (mo174l()) {
                this.f802o.m1125e(this);
                this.f802o.m1123d(this);
            }
        }
    }

    /* renamed from: y */
    public float m1352y() {
        return this.f798k;
    }

    /* renamed from: z */
    public float m1353z() {
        return this.f799l;
    }

    /* renamed from: a */
    public void mo149a(float f) {
        this.f790c = (((-f) % 360.0f) + 360.0f) % 360.0f;
        if (mo174l()) {
            this.f802o.m1125e(this);
            this.f802o.m1123d(this);
        }
    }

    /* renamed from: a */
    public boolean mo160a(aj ajVar) {
        if (equals(ajVar) || ajVar.mo167e().equals(mo167e())) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public int mo177o() {
        return super.hashCode();
    }

    /* renamed from: a */
    public void mo152a(Canvas canvas, af afVar) {
        if (this.f801n && mo165c() != null && m1351x() != null) {
            IPoint w = m1350w();
            ArrayList s = mo181s();
            if (s != null) {
                Bitmap bitmap = s.size() > 1 ? ((BitmapDescriptor) s.get(this.f789b)).getBitmap() : s.size() == 1 ? ((BitmapDescriptor) s.get(0)).getBitmap() : null;
                if (bitmap != null && !bitmap.isRecycled()) {
                    canvas.save();
                    canvas.rotate(this.f790c, (float) w.f3652x, (float) w.f3653y);
                    canvas.drawBitmap(bitmap, ((float) w.f3652x) - (m1352y() * ((float) bitmap.getWidth())), ((float) w.f3653y) - (m1353z() * ((float) bitmap.getHeight())), null);
                    canvas.restore();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo155a(Object obj) {
        this.f803p = obj;
    }

    /* renamed from: p */
    public Object mo178p() {
        return this.f803p;
    }

    /* renamed from: d */
    public LatLng mo166d() {
        return this.f804q ? this.f795h : this.f794g;
    }

    /* renamed from: a */
    public void mo151a(int i) throws RemoteException {
        if (i <= 1) {
            this.f792e = 1;
        } else {
            this.f792e = i;
        }
    }

    /* renamed from: r */
    public int mo180r() throws RemoteException {
        return this.f792e;
    }

    /* renamed from: a */
    public void mo157a(ArrayList<BitmapDescriptor> arrayList) throws RemoteException {
        if (arrayList != null) {
            m1328b((ArrayList) arrayList);
            if (this.f805r == null) {
                this.f805r = new C0224a(this);
                this.f805r.start();
            }
            if (mo174l()) {
                this.f802o.m1125e(this);
                this.f802o.m1123d(this);
            }
        }
    }

    /* renamed from: s */
    public ArrayList<BitmapDescriptor> mo181s() {
        if (this.f791d == null || this.f791d.size() <= 0) {
            return null;
        }
        ArrayList<BitmapDescriptor> arrayList = new ArrayList();
        Iterator it = this.f791d.iterator();
        while (it.hasNext()) {
            arrayList.add((BitmapDescriptor) it.next());
        }
        return arrayList;
    }
}
