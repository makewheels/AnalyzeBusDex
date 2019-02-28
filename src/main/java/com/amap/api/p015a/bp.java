package com.amap.api.p015a;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: StopAnimObserver */
/* renamed from: com.amap.api.a.bp */
public class bp {
    /* renamed from: a */
    private static bp f918a = new bp();
    /* renamed from: b */
    private ArrayList<C0219a> f919b = new ArrayList();

    /* compiled from: StopAnimObserver */
    /* renamed from: com.amap.api.a.bp$a */
    public interface C0219a {
        /* renamed from: P */
        void mo76P();
    }

    /* renamed from: a */
    public static bp m1498a() {
        return f918a;
    }

    /* renamed from: b */
    public synchronized void m1500b() {
        Iterator it = this.f919b.iterator();
        while (it.hasNext()) {
            C0219a c0219a = (C0219a) it.next();
            if (c0219a != null) {
                c0219a.mo76P();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m1499a(C0219a c0219a) {
        if (c0219a != null) {
            this.f919b.add(c0219a);
        }
    }

    /* renamed from: b */
    public synchronized void m1501b(C0219a c0219a) {
        if (c0219a != null) {
            this.f919b.remove(c0219a);
        }
    }
}
