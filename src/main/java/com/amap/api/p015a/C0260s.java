package com.amap.api.p015a;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CameraChangeFinishObserver */
/* renamed from: com.amap.api.a.s */
public class C0260s {
    /* renamed from: a */
    private static C0260s f1122a = new C0260s();
    /* renamed from: b */
    private ArrayList<C0220a> f1123b = new ArrayList();

    /* compiled from: CameraChangeFinishObserver */
    /* renamed from: com.amap.api.a.s$a */
    public interface C0220a {
        /* renamed from: Q */
        void mo77Q();
    }

    /* renamed from: a */
    public static C0260s m1682a() {
        return f1122a;
    }

    /* renamed from: b */
    public void m1684b() {
        Iterator it = this.f1123b.iterator();
        while (it.hasNext()) {
            C0220a c0220a = (C0220a) it.next();
            if (c0220a != null) {
                c0220a.mo77Q();
            }
        }
    }

    /* renamed from: a */
    public void m1683a(C0220a c0220a) {
        if (c0220a != null) {
            this.f1123b.add(c0220a);
        }
    }

    /* renamed from: b */
    public void m1685b(C0220a c0220a) {
        if (c0220a != null) {
            this.f1123b.remove(c0220a);
        }
    }
}
