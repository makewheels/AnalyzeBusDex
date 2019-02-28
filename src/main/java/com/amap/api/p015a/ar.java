package com.amap.api.p015a;

import com.amap.api.p015a.C0253m.C0252a;

/* compiled from: InprocessingTiles */
/* renamed from: com.amap.api.a.ar */
class ar extends bq<C0252a> {
    ar() {
    }

    /* renamed from: a */
    synchronized void m1058a(C0252a c0252a) {
        remove((Object) c0252a);
    }

    /* renamed from: b */
    synchronized boolean m1059b(C0252a c0252a) {
        boolean z = true;
        synchronized (this) {
            if (contains(c0252a)) {
                z = false;
            } else {
                m1057a(c0252a);
            }
        }
        return z;
    }
}
