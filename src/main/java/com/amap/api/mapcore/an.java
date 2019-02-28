package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VTMCDataCache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: MapOverlayImageView */
class an extends View {
    /* renamed from: a */
    C0313u f1485a;
    /* renamed from: b */
    C0319a f1486b = new C0319a();
    /* renamed from: c */
    private CopyOnWriteArrayList<C0294z> f1487c = new CopyOnWriteArrayList(new ArrayList(VTMCDataCache.MAXSIZE));
    /* renamed from: d */
    private List<av> f1488d = Collections.synchronizedList(new ArrayList());
    /* renamed from: e */
    private IPoint f1489e;
    /* renamed from: f */
    private C0294z f1490f;
    /* renamed from: g */
    private Handler f1491g = new Handler();
    /* renamed from: h */
    private Runnable f1492h = new ao(this);
    /* renamed from: i */
    private final Handler f1493i = new Handler();
    /* renamed from: j */
    private final Runnable f1494j = new ap(this);

    /* compiled from: MapOverlayImageView */
    /* renamed from: com.amap.api.mapcore.an$a */
    static class C0319a implements Comparator<Object>, Serializable {
        C0319a() {
        }

        public int compare(Object obj, Object obj2) {
            C0294z c0294z = (C0294z) obj;
            C0294z c0294z2 = (C0294z) obj2;
            if (!(c0294z == null || c0294z2 == null)) {
                try {
                    if (c0294z.mo275G() > c0294z2.mo275G()) {
                        return 1;
                    }
                    if (c0294z.mo275G() < c0294z2.mo275G()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "MapOverlayImageView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public an(Context context) {
        super(context);
    }

    public an(Context context, AttributeSet attributeSet, C0313u c0313u) {
        super(context, attributeSet);
        this.f1485a = c0313u;
    }

    /* renamed from: a */
    protected synchronized int m2450a() {
        return this.f1487c.size();
    }

    /* renamed from: b */
    public synchronized void m2457b() {
        try {
            Iterator it = this.f1487c.iterator();
            while (it.hasNext()) {
                ((C0294z) it.next()).mo292b();
            }
        } catch (Throwable e) {
            az.m3143a(e, "MapOverlayImageView", "clear");
            e.printStackTrace();
        }
        this.f1487c.clear();
    }

    /* renamed from: a */
    public synchronized void m2454a(C0294z c0294z) {
        this.f1487c.add(c0294z);
        m2470i();
    }

    /* renamed from: b */
    public synchronized boolean m2459b(C0294z c0294z) {
        m2465e(c0294z);
        return this.f1487c.remove(c0294z);
    }

    /* renamed from: c */
    public synchronized void m2461c(C0294z c0294z) {
        try {
            if (this.f1487c.remove(c0294z)) {
                m2449j();
                this.f1487c.add(c0294z);
            }
        } catch (Throwable th) {
            az.m3143a(th, "MapOverlayImageView", "set2Top");
        }
    }

    /* renamed from: d */
    public void m2462d(C0294z c0294z) {
        if (this.f1489e == null) {
            this.f1489e = new IPoint();
        }
        Rect d = c0294z.mo295d();
        this.f1489e = new IPoint(d.left + (d.width() / 2), d.top);
        this.f1490f = c0294z;
        try {
            this.f1485a.mo366a(this.f1490f);
        } catch (Throwable e) {
            az.m3143a(e, "MapOverlayImageView", "showInfoWindow");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m2465e(C0294z c0294z) {
        if (m2467f(c0294z)) {
            this.f1485a.mo429y();
            this.f1490f = null;
        }
    }

    /* renamed from: f */
    public boolean m2467f(C0294z c0294z) {
        try {
            return this.f1485a.mo393b(c0294z);
        } catch (Throwable e) {
            az.m3143a(e, "MapOverlayImageView", "isInfoWindowShown");
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: c */
    public synchronized void m2460c() {
        Iterator it = this.f1487c.iterator();
        while (it.hasNext()) {
            C0294z c0294z = (C0294z) it.next();
            try {
                if (c0294z.mo307o()) {
                    c0294z.mo310r();
                }
            } catch (Throwable th) {
                az.m3143a(th, "MapOverlayImageView", "calFPoint");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: j */
    private void m2449j() {
        try {
            Collection arrayList = new ArrayList(this.f1487c);
            Collections.sort(arrayList, this.f1486b);
            this.f1487c = new CopyOnWriteArrayList(arrayList);
        } catch (Throwable th) {
            az.m3143a(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    /* renamed from: a */
    public void m2455a(GL10 gl10) {
        this.f1493i.post(this.f1494j);
        Iterator it = this.f1487c.iterator();
        while (it.hasNext()) {
            C0294z c0294z = (C0294z) it.next();
            if (c0294z.mo276H() || c0294z.mo306n()) {
                c0294z.mo286a(gl10, this.f1485a);
            }
        }
    }

    /* renamed from: d */
    public synchronized boolean m2463d() {
        boolean z;
        Iterator it = this.f1487c.iterator();
        while (it.hasNext()) {
            if (!((C0294z) it.next()).mo294c()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    /* renamed from: e */
    public C0294z m2464e() {
        return this.f1490f;
    }

    /* renamed from: a */
    public C0294z m2452a(MotionEvent motionEvent) {
        Iterator it = this.f1487c.iterator();
        while (it.hasNext()) {
            C0294z c0294z = (C0294z) it.next();
            if ((c0294z instanceof ar) && m2456a(c0294z.mo295d(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f1490f = c0294z;
                return this.f1490f;
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void m2453a(av avVar) {
        if (avVar != null) {
            if (avVar.m2583b() != 0) {
                this.f1488d.add(avVar);
            }
        }
    }

    /* renamed from: a */
    public synchronized int m2451a(BitmapDescriptor bitmapDescriptor) {
        int b;
        if (bitmapDescriptor != null) {
            if (!(bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled())) {
                for (int i = 0; i < this.f1488d.size(); i++) {
                    av avVar = (av) this.f1488d.get(i);
                    if (avVar.m2582a().equals(bitmapDescriptor)) {
                        b = avVar.m2583b();
                        break;
                    }
                }
                b = 0;
            }
        }
        b = 0;
        return b;
    }

    /* renamed from: f */
    public synchronized void m2466f() {
        try {
            Iterator it = this.f1487c.iterator();
            while (it.hasNext()) {
                C0294z c0294z = (C0294z) it.next();
                if (c0294z != null) {
                    c0294z.mo308p();
                }
            }
            m2457b();
            for (av a : this.f1488d) {
                a.m2582a().recycle();
            }
            this.f1488d.clear();
        } catch (Throwable th) {
            az.m3143a(th, "MapOverlayImageView", "destroy");
            th.printStackTrace();
            Log.d("amapApi", "MapOverlayImageView clear erro" + th.getMessage());
        }
        return;
    }

    /* renamed from: b */
    public boolean m2458b(MotionEvent motionEvent) {
        Iterator it = this.f1487c.iterator();
        while (it.hasNext()) {
            C0294z c0294z = (C0294z) it.next();
            if (c0294z instanceof ar) {
                Rect d = c0294z.mo295d();
                boolean a = m2456a(d, (int) motionEvent.getX(), (int) motionEvent.getY());
                if (a) {
                    this.f1489e = new IPoint(d.left + (d.width() / 2), d.top);
                    this.f1490f = c0294z;
                    return a;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2456a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    /* renamed from: g */
    public synchronized List<Marker> m2468g() {
        List<Marker> arrayList;
        arrayList = new ArrayList();
        try {
            Rect rect = new Rect(0, 0, this.f1485a.mo406h(), this.f1485a.mo409i());
            IPoint iPoint = new IPoint();
            Iterator it = this.f1487c.iterator();
            while (it.hasNext()) {
                C0294z c0294z = (C0294z) it.next();
                if (!(c0294z instanceof bc)) {
                    LatLng g = c0294z.mo299g();
                    if (g != null) {
                        this.f1485a.mo387b(g.latitude, g.longitude, iPoint);
                        if (m2456a(rect, iPoint.f3639x, iPoint.f3640y)) {
                            arrayList.add(new Marker(c0294z));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            az.m3143a(th, "MapOverlayImageView", "getMapScreenMarkers");
            th.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: h */
    public synchronized void m2469h() {
        Iterator it = this.f1487c.iterator();
        while (it.hasNext()) {
            C0294z c0294z = (C0294z) it.next();
            if (c0294z.mo316x()) {
                c0294z.mo317y();
            }
        }
    }

    /* renamed from: i */
    protected synchronized void m2470i() {
        this.f1491g.removeCallbacks(this.f1492h);
        this.f1491g.postDelayed(this.f1492h, 10);
    }
}
