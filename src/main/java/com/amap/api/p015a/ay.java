package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.autonavi.amap.mapcore2d.IPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MapOverlayImageView */
/* renamed from: com.amap.api.a.ay */
class ay extends View {
    /* renamed from: a */
    C0222b f680a;
    /* renamed from: b */
    private CopyOnWriteArrayList<aj> f681b = new CopyOnWriteArrayList();
    /* renamed from: c */
    private IPoint f682c;
    /* renamed from: d */
    private aj f683d;
    /* renamed from: e */
    private final Handler f684e = new Handler();
    /* renamed from: f */
    private CopyOnWriteArrayList<Integer> f685f = new CopyOnWriteArrayList();

    /* compiled from: MapOverlayImageView */
    /* renamed from: com.amap.api.a.ay$1 */
    class C02121 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ay f679a;

        C02121(ay ayVar) {
            this.f679a = ayVar;
        }

        public void run() {
            this.f679a.m1110g();
        }
    }

    /* renamed from: a */
    public C0222b m1113a() {
        return this.f680a;
    }

    public ay(Context context, AttributeSet attributeSet, C0222b c0222b) {
        super(context, attributeSet);
        this.f680a = c0222b;
    }

    /* renamed from: a */
    public aj m1112a(String str) throws RemoteException {
        Iterator it = this.f681b.iterator();
        while (it.hasNext()) {
            aj ajVar = (aj) it.next();
            if (ajVar != null && ajVar.mo167e().equals(str)) {
                return ajVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    protected int m1117b() {
        return this.f681b.size();
    }

    /* renamed from: c */
    public void m1120c() {
        if (this.f681b != null) {
            Iterator it = this.f681b.iterator();
            while (it.hasNext()) {
                ((aj) it.next()).mo176n();
            }
            this.f681b.clear();
        }
    }

    /* renamed from: a */
    public void m1115a(aj ajVar) {
        m1125e(ajVar);
        this.f681b.remove(ajVar);
        this.f681b.add(ajVar);
    }

    /* renamed from: b */
    public boolean m1119b(aj ajVar) {
        m1125e(ajVar);
        return this.f681b.remove(ajVar);
    }

    /* renamed from: c */
    public void m1121c(aj ajVar) {
        int size = this.f681b.size() - 1;
        this.f681b.set(this.f681b.indexOf(ajVar), this.f681b.get(size));
        this.f681b.set(size, ajVar);
    }

    /* renamed from: d */
    public void m1123d(aj ajVar) {
        if (this.f682c == null) {
            this.f682c = new IPoint();
        }
        Rect b = ajVar.mo161b();
        this.f682c = new IPoint(b.left + (ajVar.mo179q() / 2), b.top);
        this.f683d = ajVar;
        try {
            this.f680a.m1210a(m1122d());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m1125e(aj ajVar) {
        if (m1127f(ajVar)) {
            this.f680a.m1276t();
            this.f683d = null;
        }
    }

    /* renamed from: f */
    public boolean m1127f(aj ajVar) {
        return this.f680a.m1244b(ajVar);
    }

    /* renamed from: a */
    public void m1114a(Canvas canvas) {
        this.f684e.postDelayed(new C02121(this), 0);
        Iterator it = this.f681b.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).mo152a(canvas, this.f680a);
        }
    }

    /* renamed from: g */
    private void m1110g() {
        Iterator it = this.f681b.iterator();
        while (it.hasNext()) {
            aj ajVar = (aj) it.next();
            if (this.f683d != null && this.f683d.mo167e().equals(ajVar.mo167e())) {
                Rect b = ajVar.mo161b();
                this.f682c = new IPoint((ajVar.mo179q() / 2) + b.left, b.top);
                this.f680a.m1277u();
            }
        }
    }

    /* renamed from: d */
    public aj m1122d() {
        return this.f683d;
    }

    /* renamed from: a */
    public aj m1111a(MotionEvent motionEvent) {
        for (int size = this.f681b.size() - 1; size >= 0; size--) {
            aj ajVar = (aj) this.f681b.get(size);
            if (m1116a(ajVar.mo161b(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                return ajVar;
            }
        }
        return null;
    }

    /* renamed from: e */
    public void m1124e() {
        try {
            Iterator it = this.f681b.iterator();
            while (it.hasNext()) {
                aj ajVar = (aj) it.next();
                if (ajVar != null) {
                    ajVar.mo176n();
                }
            }
            m1120c();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("amapApi", "MapOverlayImageView clear erro" + e.getMessage());
        }
    }

    /* renamed from: b */
    public boolean m1118b(MotionEvent motionEvent) {
        for (int size = this.f681b.size() - 1; size >= 0; size--) {
            aj ajVar = (aj) this.f681b.get(size);
            Rect b = ajVar.mo161b();
            boolean a = m1116a(b, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a) {
                this.f682c = new IPoint(b.left + (ajVar.mo179q() / 2), b.top);
                this.f683d = ajVar;
                return a;
            }
        }
        return false;
    }

    /* renamed from: f */
    public List<Marker> m1126f() {
        List<Marker> arrayList = new ArrayList();
        Rect rect = new Rect(0, 0, this.f680a.mo121c(), this.f680a.mo125d());
        IPoint iPoint = new IPoint();
        for (int i = 0; i < this.f681b.size(); i++) {
            LatLng d = ((aj) this.f681b.get(i)).mo166d();
            this.f680a.mo115b(d.latitude, d.longitude, iPoint);
            if (m1116a(rect, iPoint.f3652x, iPoint.f3653y)) {
                arrayList.add(new Marker((aj) this.f681b.get(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean m1116a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }
}
