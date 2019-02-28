package com.amap.api.mapcore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.az;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.mapcore.b */
class C0321b extends Handler {
    /* renamed from: a */
    final /* synthetic */ AMapDelegateImpGLSurfaceView f1619a;

    C0321b(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1619a = aMapDelegateImpGLSurfaceView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            if (this.f1619a.f1410L != null) {
                this.f1619a.f1410L.onTouch((MotionEvent) message.obj);
            }
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "onTouchHandler");
            th.printStackTrace();
        }
    }
}
