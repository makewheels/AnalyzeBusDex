package com.amap.api.mapcore;

import android.content.Context;
import android.view.View;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: TileOverlayView */
public class bf extends View {
    /* renamed from: a */
    CopyOnWriteArrayList<ah> f1706a = new CopyOnWriteArrayList();
    /* renamed from: b */
    C0325a f1707b = new C0325a();
    /* renamed from: c */
    CopyOnWriteArrayList<Integer> f1708c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private C0313u f1709d;

    /* compiled from: TileOverlayView */
    /* renamed from: com.amap.api.mapcore.bf$a */
    static class C0325a implements Comparator<Object>, Serializable {
        C0325a() {
        }

        public int compare(Object obj, Object obj2) {
            ah ahVar = (ah) obj;
            ah ahVar2 = (ah) obj2;
            if (!(ahVar == null || ahVar2 == null)) {
                try {
                    if (ahVar.mo530d() > ahVar2.mo530d()) {
                        return 1;
                    }
                    if (ahVar.mo530d() < ahVar2.mo530d()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "TileOverlayView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public bf(Context context) {
        super(context);
    }

    public bf(Context context, C0313u c0313u) {
        super(context);
        this.f1709d = c0313u;
    }

    /* renamed from: a */
    C0313u m2776a() {
        return this.f1709d;
    }

    /* renamed from: a */
    public void m2778a(GL10 gl10) {
        Iterator it = this.f1708c.iterator();
        while (it.hasNext()) {
            C0405u.m3465a(gl10, ((Integer) it.next()).intValue());
        }
        this.f1708c.clear();
        it = this.f1706a.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            if (ahVar.mo531e()) {
                ahVar.mo523a(gl10);
            }
        }
    }

    /* renamed from: b */
    public void m2780b() {
        Iterator it = this.f1706a.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            if (ahVar != null) {
                ahVar.mo521a();
            }
        }
        this.f1706a.clear();
    }

    /* renamed from: c */
    void m2783c() {
        Object[] toArray = this.f1706a.toArray();
        Arrays.sort(toArray, this.f1707b);
        this.f1706a.clear();
        for (Object obj : toArray) {
            this.f1706a.add((ah) obj);
        }
    }

    /* renamed from: a */
    public void m2777a(ah ahVar) {
        m2782b(ahVar);
        this.f1706a.add(ahVar);
        m2783c();
    }

    /* renamed from: b */
    public boolean m2782b(ah ahVar) {
        return this.f1706a.remove(ahVar);
    }

    /* renamed from: a */
    public void m2779a(boolean z) {
        Iterator it = this.f1706a.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            if (ahVar != null && ahVar.mo531e()) {
                ahVar.mo527b(z);
            }
        }
    }

    /* renamed from: d */
    public void m2784d() {
        Iterator it = this.f1706a.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            if (ahVar != null) {
                ahVar.mo533g();
            }
        }
    }

    /* renamed from: e */
    public void m2785e() {
        Iterator it = this.f1706a.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            if (ahVar != null) {
                ahVar.mo534h();
            }
        }
    }

    /* renamed from: b */
    public void m2781b(boolean z) {
        Iterator it = this.f1706a.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            if (ahVar != null) {
                ahVar.mo529c(z);
            }
        }
    }
}
