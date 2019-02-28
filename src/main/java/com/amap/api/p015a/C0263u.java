package com.amap.api.p015a;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CancelAnimObserver */
/* renamed from: com.amap.api.a.u */
public class C0263u {
    /* renamed from: a */
    private static C0263u f1152a = new C0263u();
    /* renamed from: b */
    private ArrayList<C0221a> f1153b = new ArrayList();

    /* compiled from: CancelAnimObserver */
    /* renamed from: com.amap.api.a.u$a */
    public interface C0221a {
        /* renamed from: O */
        void mo75O();
    }

    /* renamed from: a */
    public static C0263u m1701a() {
        return f1152a;
    }

    /* renamed from: b */
    public synchronized void m1703b() {
        Iterator it = this.f1153b.iterator();
        while (it.hasNext()) {
            C0221a c0221a = (C0221a) it.next();
            if (c0221a != null) {
                c0221a.mo75O();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m1702a(C0221a c0221a) {
        if (c0221a != null) {
            this.f1153b.add(c0221a);
        }
    }

    /* renamed from: b */
    public synchronized void m1704b(C0221a c0221a) {
        if (c0221a != null) {
            this.f1153b.remove(c0221a);
        }
    }
}
