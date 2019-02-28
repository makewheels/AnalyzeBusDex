package com.autonavi.amap.mapcore;

import java.util.Vector;

/* compiled from: ConnectionManager */
/* renamed from: com.autonavi.amap.mapcore.c */
class C0593c extends Vector {
    /* renamed from: a */
    protected int f3643a = -1;

    C0593c() {
    }

    /* renamed from: a */
    public synchronized void m4647a(Object obj) {
        if (this.f3643a > 0 && size() > this.f3643a) {
            m4646a();
        }
        super.addElement(obj);
    }

    /* renamed from: a */
    public synchronized Object m4646a() {
        Object obj;
        if (m4648b()) {
            obj = null;
        } else {
            obj = super.elementAt(0);
            super.removeElementAt(0);
        }
        return obj;
    }

    /* renamed from: b */
    public boolean m4648b() {
        return super.isEmpty();
    }

    public synchronized void clear() {
        super.removeAllElements();
    }

    public synchronized boolean equals(Object obj) {
        return super.equals(obj);
    }

    public synchronized int hashCode() {
        return super.hashCode();
    }
}
