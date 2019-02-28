package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: TileOverlayView */
/* renamed from: com.amap.api.a.bv */
public class bv extends View {
    /* renamed from: a */
    CopyOnWriteArrayList<ap> f952a = new CopyOnWriteArrayList();
    /* renamed from: b */
    C0235a f953b = new C0235a(this);
    /* renamed from: c */
    CopyOnWriteArrayList<Integer> f954c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private af f955d;

    /* compiled from: TileOverlayView */
    /* renamed from: com.amap.api.a.bv$a */
    class C0235a implements Comparator<Object> {
        /* renamed from: a */
        final /* synthetic */ bv f951a;

        C0235a(bv bvVar) {
            this.f951a = bvVar;
        }

        public int compare(Object obj, Object obj2) {
            ap apVar = (ap) obj;
            ap apVar2 = (ap) obj2;
            if (!(apVar == null || apVar2 == null)) {
                try {
                    if (apVar.mo217d() > apVar2.mo217d()) {
                        return 1;
                    }
                    if (apVar.mo217d() < apVar2.mo217d()) {
                        return -1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
    }

    public bv(Context context, af afVar) {
        super(context);
        this.f955d = afVar;
    }

    /* renamed from: a */
    af m1536a() {
        return this.f955d;
    }

    /* renamed from: a */
    protected void m1537a(Canvas canvas) {
        Iterator it = this.f952a.iterator();
        while (it.hasNext()) {
            ap apVar = (ap) it.next();
            if (apVar.mo218e()) {
                apVar.mo211a(canvas);
            }
        }
    }

    /* renamed from: b */
    protected boolean m1540b() {
        if (this.f952a.size() > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    void m1542c() {
        Object[] toArray = this.f952a.toArray();
        Arrays.sort(toArray, this.f953b);
        this.f952a.clear();
        for (Object obj : toArray) {
            this.f952a.add((ap) obj);
        }
    }

    /* renamed from: a */
    public void m1538a(ap apVar) {
        m1541b(apVar);
        this.f952a.add(apVar);
        m1542c();
    }

    /* renamed from: b */
    public boolean m1541b(ap apVar) {
        return this.f952a.remove(apVar);
    }

    /* renamed from: a */
    public void m1539a(boolean z) {
        Iterator it = this.f952a.iterator();
        while (it.hasNext()) {
            ap apVar = (ap) it.next();
            if (apVar != null && apVar.mo218e()) {
                apVar.mo215b(z);
            }
        }
    }
}
