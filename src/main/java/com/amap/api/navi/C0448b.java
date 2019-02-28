package com.amap.api.navi;

/* compiled from: AMapHudView */
/* renamed from: com.amap.api.navi.b */
class C0448b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AMapHudView f2687a;

    C0448b(AMapHudView aMapHudView) {
        this.f2687a = aMapHudView;
    }

    public void run() {
        try {
            this.f2687a.loadHideHudTitleAnimation();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
