package com.amap.api.mapcore;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLOverlay */
/* renamed from: com.amap.api.mapcore.q */
public abstract class C0348q {
    /* renamed from: a */
    private C0313u f1885a;

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);

    public void destroy() {
        if (this.f1885a != null) {
            this.f1885a.mo365a(this);
        }
    }
}
