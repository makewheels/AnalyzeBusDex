package com.amap.api.p015a;

import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CustomGLOverlayLayer */
/* renamed from: com.amap.api.a.z */
class C0272z {
    /* renamed from: a */
    C0271a f1195a = new C0271a(this);
    /* renamed from: b */
    private CopyOnWriteArrayList<aa> f1196b = new CopyOnWriteArrayList();

    /* compiled from: CustomGLOverlayLayer */
    /* renamed from: com.amap.api.a.z$a */
    class C0271a implements Comparator<Object> {
        /* renamed from: a */
        final /* synthetic */ C0272z f1194a;

        C0271a(C0272z c0272z) {
            this.f1194a = c0272z;
        }

        public int compare(Object obj, Object obj2) {
            aa aaVar = (aa) obj;
            aa aaVar2 = (aa) obj2;
            if (!(aaVar == null || aaVar2 == null)) {
                try {
                    if (aaVar.getZIndex() > aaVar2.getZIndex()) {
                        return 1;
                    }
                    if (aaVar.getZIndex() < aaVar2.getZIndex()) {
                        return -1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
    }

    C0272z() {
    }

    /* renamed from: a */
    public boolean m1737a(aa aaVar) {
        if (this.f1196b.contains(aaVar)) {
            return this.f1196b.remove(aaVar);
        }
        return false;
    }
}
