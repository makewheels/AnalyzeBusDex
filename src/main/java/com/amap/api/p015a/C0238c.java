package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.amap.api.maps2d.model.CameraPosition;
import com.autonavi.amap.mapcore2d.IPoint;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.a.c */
class C0238c extends Handler {
    /* renamed from: a */
    final /* synthetic */ C0222b f982a;

    C0238c(C0222b c0222b) {
        this.f982a = c0222b;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 2:
                    Toast.makeText(this.f982a.f733l, C0248k.f1037b, 0).show();
                    return;
                case 10:
                    if (this.f982a.f704G != null) {
                        this.f982a.f704G.onCameraChange(new CameraPosition(this.f982a.m1186N(), this.f982a.mo130f(), 0.0f, 0.0f));
                        return;
                    }
                    return;
                case 11:
                    if (this.f982a.ad != null) {
                        this.f982a.ad.onMapLoaded();
                        return;
                    }
                    return;
                case 13:
                    if (this.f982a.f705H != null && this.f982a.f705H.m1680g()) {
                        switch (this.f982a.f705H.m1681h()) {
                            case 2:
                                C0262t a = C0262t.m1696a(new IPoint(this.f982a.f705H.m1675b(), this.f982a.f705H.m1676c()), this.f982a.f705H.m1677d(), this.f982a.f705H.m1678e(), this.f982a.f705H.m1679f());
                                if (this.f982a.f705H.m1674a()) {
                                    a.f1151o = true;
                                }
                                this.f982a.f725d.m1108a(a);
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                case 15:
                    this.f982a.m1185M();
                    return;
                case 16:
                    Bitmap createBitmap;
                    try {
                        createBitmap = Bitmap.createBitmap((Bitmap) message.obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        createBitmap = null;
                    }
                    if (createBitmap != null) {
                        Canvas canvas = new Canvas(createBitmap);
                        if (this.f982a.f747z != null) {
                            this.f982a.f747z.onDraw(canvas);
                        }
                        if (!(this.f982a.f711N == null || this.f982a.f714Q == null)) {
                            Bitmap drawingCache = this.f982a.f711N.getDrawingCache(true);
                            if (drawingCache != null) {
                                canvas.drawBitmap(drawingCache, (float) this.f982a.f711N.getLeft(), (float) this.f982a.f711N.getTop(), new Paint());
                            }
                        }
                        if (this.f982a.ah != null) {
                            this.f982a.ah.onMapScreenShot(createBitmap);
                        }
                    } else if (this.f982a.ah != null) {
                        this.f982a.ah.onMapScreenShot(null);
                    }
                    this.f982a.destroyDrawingCache();
                    this.f982a.ah = null;
                    return;
                case 17:
                    if (this.f982a.f704G != null) {
                        this.f982a.m1227a(true, this.f982a.m1151X());
                    }
                    if (this.f982a.f706I != null) {
                        this.f982a.f702E = true;
                        this.f982a.f706I.onFinish();
                        this.f982a.f702E = false;
                    }
                    if (this.f982a.f703F) {
                        this.f982a.f703F = false;
                        return;
                    } else {
                        this.f982a.f706I = null;
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
