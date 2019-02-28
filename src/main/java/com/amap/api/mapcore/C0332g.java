package com.amap.api.mapcore;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.mapcore.g */
class C0332g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AMapDelegateImpGLSurfaceView f1754a;

    C0332g(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1754a = aMapDelegateImpGLSurfaceView;
    }

    public synchronized void run() {
        if (this.f1754a.aG) {
            this.f1754a.aF = true;
            this.f1754a.aG = false;
        }
    }
}
