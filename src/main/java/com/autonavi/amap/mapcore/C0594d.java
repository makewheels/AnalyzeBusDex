package com.autonavi.amap.mapcore;

import java.util.Hashtable;

/* compiled from: TilesProcessingCtrl */
/* renamed from: com.autonavi.amap.mapcore.d */
class C0594d {
    /* renamed from: a */
    private Hashtable f3644a = new Hashtable();

    /* renamed from: a */
    public void m4649a(String str) {
        this.f3644a.remove(str);
    }

    /* renamed from: b */
    public boolean m4650b(String str) {
        return this.f3644a.get(str) != null;
    }

    /* renamed from: c */
    public void m4651c(String str) {
        this.f3644a.put(str, new C0592b(str, 0));
    }
}
