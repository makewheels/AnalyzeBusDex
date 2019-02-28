package com.amap.api.mapcore;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.mapcore.e */
class C0330e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AMapDelegateImpGLSurfaceView f1752a;

    C0330e(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1752a = aMapDelegateImpGLSurfaceView;
    }

    public void run() {
        if (this.f1752a.f1416R != null) {
            this.f1752a.f1419U = true;
            if (this.f1752a.f1418T != null) {
                this.f1752a.f1418T.mo291b(false);
            }
        }
    }
}
