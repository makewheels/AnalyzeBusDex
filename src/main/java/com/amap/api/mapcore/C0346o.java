package com.amap.api.mapcore;

import com.amap.api.mapcore.util.az;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: CustomGLOverlayLayer */
/* renamed from: com.amap.api.mapcore.o */
class C0346o {
    /* renamed from: a */
    C0345a f1883a = new C0345a();
    /* renamed from: b */
    private CopyOnWriteArrayList<C0348q> f1884b = new CopyOnWriteArrayList();

    /* compiled from: CustomGLOverlayLayer */
    /* renamed from: com.amap.api.mapcore.o$a */
    static class C0345a implements Comparator<Object>, Serializable {
        C0345a() {
        }

        public int compare(Object obj, Object obj2) {
            C0348q c0348q = (C0348q) obj;
            C0348q c0348q2 = (C0348q) obj2;
            if (!(c0348q == null || c0348q2 == null)) {
                try {
                    if (c0348q.getZIndex() > c0348q2.getZIndex()) {
                        return 1;
                    }
                    if (c0348q.getZIndex() < c0348q2.getZIndex()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "CustomGLOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    C0346o() {
    }

    /* renamed from: a */
    public boolean m2933a(C0348q c0348q) {
        if (this.f1884b.contains(c0348q)) {
            return this.f1884b.remove(c0348q);
        }
        return false;
    }

    /* renamed from: a */
    public void m2932a(GL10 gl10) {
        Iterator it = this.f1884b.iterator();
        while (it.hasNext()) {
            ((C0348q) it.next()).onDrawFrame(gl10);
        }
    }
}
