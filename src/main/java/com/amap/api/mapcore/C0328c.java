package com.amap.api.mapcore;

import com.amap.api.mapcore.util.C0400q;
import com.amap.api.mapcore.util.C0401r;
import com.amap.api.mapcore.util.C0408x;
import com.amap.api.mapcore.util.ad;
import com.amap.api.mapcore.util.ad.C0356a;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.MapsInitializer;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.mapcore.c */
class C0328c extends Thread {
    /* renamed from: a */
    final /* synthetic */ AMapDelegateImpGLSurfaceView f1750a;

    C0328c(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1750a = aMapDelegateImpGLSurfaceView;
    }

    public void run() {
        boolean z = false;
        while (!MapsInitializer.getNetWorkEnable()) {
            try {
                Thread.currentThread();
                Thread.sleep(2000);
            } catch (Throwable th) {
                interrupt();
                az.m3143a(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
                th.printStackTrace();
                return;
            }
        }
        C0401r a = new C0400q(this.f1750a.f1444t).m3427a();
        C0356a a2 = new C0356a(C0344n.f1879b, "V2.5.1", C0344n.f1880c).m3031a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore"});
        if (a != null) {
            z = a.m3432a();
        }
        ad a3 = a2.m3030a(z).m3032a();
        C0344n.f1882e = a3;
        az.m3139a(this.f1750a.f1444t, a3);
        C0408x.m3500a(this.f1750a.f1444t, a3);
        interrupt();
        if (C0408x.f2198a == 0) {
            this.f1750a.f1433i.sendEmptyMessage(2);
        }
        this.f1750a.mo401e(false);
    }
}
