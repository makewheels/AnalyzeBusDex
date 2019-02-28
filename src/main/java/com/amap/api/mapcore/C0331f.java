package com.amap.api.mapcore;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.mapcore.f */
class C0331f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AMapDelegateImpGLSurfaceView f1753a;

    C0331f(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1753a = aMapDelegateImpGLSurfaceView;
    }

    public void run() {
        if (this.f1753a.f1416R != null) {
            this.f1753a.f1419U = false;
            this.f1753a.f1416R.setVisibility(8);
        }
    }
}
