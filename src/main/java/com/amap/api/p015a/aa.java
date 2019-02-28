package com.amap.api.p015a;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLOverlay */
/* renamed from: com.amap.api.a.aa */
public abstract class aa {
    /* renamed from: a */
    private af f605a;

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);

    public void destroy() {
        if (this.f605a != null) {
            this.f605a.mo91a(this);
        }
    }
}
