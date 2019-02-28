package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.amap.api.mapcore.util.C0408x;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.mapcore.d */
class C0329d extends Handler {
    /* renamed from: a */
    final /* synthetic */ AMapDelegateImpGLSurfaceView f1751a;

    C0329d(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f1751a = aMapDelegateImpGLSurfaceView;
    }

    public void handleMessage(Message message) {
        if (message != null && !this.f1751a.ap.booleanValue()) {
            this.f1751a.mo401e(false);
            CameraPosition cameraPosition;
            C0338k c0338k;
            switch (message.what) {
                case 2:
                    Toast.makeText(this.f1751a.f1444t, C0408x.f2199b, 0).show();
                    break;
                case 10:
                    cameraPosition = (CameraPosition) message.obj;
                    if (!(cameraPosition == null || this.f1751a.f1408J == null)) {
                        this.f1751a.f1408J.onCameraChange(cameraPosition);
                        break;
                    }
                case 11:
                    if (this.f1751a.av != null) {
                        try {
                            this.f1751a.mo362a(this.f1751a.av);
                        } catch (Throwable th) {
                            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "onMapLoaded");
                            th.printStackTrace();
                        }
                    }
                    if (this.f1751a.f1407I != null) {
                        this.f1751a.f1407I.onMapLoaded();
                        break;
                    }
                    break;
                case 12:
                    c0338k = (C0338k) message.obj;
                    if (c0338k != null) {
                        this.f1751a.f1425a.m2443a(c0338k);
                        break;
                    }
                    break;
                case 13:
                    if (this.f1751a.af != null && this.f1751a.af.m2871h()) {
                        switch (this.f1751a.af.m2873j()) {
                            case 2:
                                c0338k = C0338k.m2886a(new IPoint(this.f1751a.af.m2864b(), this.f1751a.af.m2866c()), this.f1751a.af.m2867d(), this.f1751a.af.m2868e(), this.f1751a.af.m2869f());
                                if (this.f1751a.af.m2863a()) {
                                    c0338k.f1851p = true;
                                }
                                c0338k.f1849n = this.f1751a.af.m2874k();
                                this.f1751a.f1425a.m2443a(c0338k);
                                break;
                            default:
                                int b = this.f1751a.af.m2864b() - this.f1751a.ag;
                                int c = this.f1751a.af.m2866c() - this.f1751a.ah;
                                this.f1751a.ag = this.f1751a.af.m2864b();
                                this.f1751a.ah = this.f1751a.af.m2866c();
                                FPoint fPoint = new FPoint((float) (b + (this.f1751a.getWidth() / 2)), (float) (c + (this.f1751a.getHeight() / 2)));
                                FPoint fPoint2 = new FPoint();
                                this.f1751a.f1446v.win2Map((int) fPoint.f3637x, (int) fPoint.f3638y, fPoint2);
                                IPoint iPoint = new IPoint();
                                this.f1751a.f1446v.map2Geo(fPoint2.f3637x, fPoint2.f3638y, iPoint);
                                c0338k = C0338k.m2885a(iPoint);
                                if (this.f1751a.af.m2863a()) {
                                    c0338k.f1851p = true;
                                }
                                this.f1751a.f1425a.m2443a(c0338k);
                                break;
                        }
                    }
                case 14:
                    if (this.f1751a.f1402D != null) {
                        this.f1751a.f1402D.m2931b();
                        break;
                    }
                    return;
                case 15:
                    this.f1751a.m2270g();
                    break;
                case 16:
                    Bitmap bitmap = (Bitmap) message.obj;
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        if (this.f1751a.f1400B != null) {
                            this.f1751a.f1400B.onDraw(canvas);
                        }
                        if (!(this.f1751a.f1416R == null || this.f1751a.f1417S == null)) {
                            Bitmap drawingCache = this.f1751a.f1416R.getDrawingCache(true);
                            if (drawingCache != null) {
                                canvas.drawBitmap(drawingCache, (float) this.f1751a.f1416R.getLeft(), (float) this.f1751a.f1416R.getTop(), new Paint());
                            }
                        }
                        if (this.f1751a.as != null) {
                            this.f1751a.as.onMapPrint(new BitmapDrawable(this.f1751a.getResources(), bitmap));
                        }
                        if (this.f1751a.at != null) {
                            this.f1751a.at.onMapScreenShot(bitmap);
                        }
                    } else {
                        if (this.f1751a.as != null) {
                            this.f1751a.as.onMapPrint(null);
                        }
                        if (this.f1751a.at != null) {
                            this.f1751a.at.onMapScreenShot(null);
                        }
                    }
                    this.f1751a.as = null;
                    this.f1751a.at = null;
                    break;
                case 17:
                    if (!(this.f1751a.f1416R == null || this.f1751a.f1418T == null)) {
                        this.f1751a.f1416R.setVisibility(0);
                    }
                    if (this.f1751a.ai == null || !this.f1751a.aj) {
                        this.f1751a.m2247a(true, null);
                    }
                    if (this.f1751a.ai != null) {
                        this.f1751a.al = true;
                        this.f1751a.ai.onFinish();
                        this.f1751a.al = false;
                    }
                    if (!this.f1751a.am) {
                        this.f1751a.ai = null;
                        break;
                    } else {
                        this.f1751a.am = false;
                        break;
                    }
                case 18:
                    int width = this.f1751a.getWidth();
                    int height = this.f1751a.getHeight();
                    if (width > 0 && height > 0) {
                        try {
                            cameraPosition = this.f1751a.mo413l();
                            MapProjection.lonlat2Geo(cameraPosition.target.longitude, cameraPosition.target.latitude, new IPoint());
                            MapProjection mapProjection = new MapProjection(this.f1751a.f1443s);
                            mapProjection.setCameraHeaderAngle(cameraPosition.tilt);
                            mapProjection.setMapAngle(cameraPosition.bearing);
                            mapProjection.setMapZoomer(cameraPosition.zoom);
                            mapProjection.recalculate();
                            DPoint dPoint = new DPoint();
                            this.f1751a.m2138a(mapProjection, 0, 0, dPoint);
                            LatLng latLng = new LatLng(dPoint.f3636y, dPoint.f3635x, false);
                            this.f1751a.m2138a(mapProjection, width, 0, dPoint);
                            LatLng latLng2 = new LatLng(dPoint.f3636y, dPoint.f3635x, false);
                            this.f1751a.m2138a(mapProjection, 0, height, dPoint);
                            LatLng latLng3 = new LatLng(dPoint.f3636y, dPoint.f3635x, false);
                            this.f1751a.m2138a(mapProjection, width, height, dPoint);
                            this.f1751a.aW = LatLngBounds.builder().include(latLng3).include(new LatLng(dPoint.f3636y, dPoint.f3635x, false)).include(latLng).include(latLng2).build();
                            mapProjection.recycle();
                            break;
                        } catch (Throwable th2) {
                            break;
                        }
                    }
                    this.f1751a.aW = null;
                    break;
                case 19:
                    try {
                        this.f1751a.m2185C();
                        this.f1751a.m2279j(true);
                        break;
                    } catch (Throwable th3) {
                        az.m3143a(th3, "AMapDelegateImpGLSurfaceView", "CREATEMAP");
                        th3.printStackTrace();
                        break;
                    }
                case 20:
                    if (this.f1751a.af.m2863a() || !(this.f1751a.af.m2873j() == 1 || this.f1751a.f1428d == null)) {
                        this.f1751a.f1428d.m2781b(false);
                    }
                    if (this.f1751a.f1428d != null) {
                        this.f1751a.f1428d.m2779a(message.arg1 != 0);
                        break;
                    }
                    break;
                case 21:
                    if (this.f1751a.f1427c != null) {
                        this.f1751a.f1427c.m2825a(this.f1751a.mo430z());
                        break;
                    }
                    break;
                case 22:
                    this.f1751a.m2116S();
                    break;
            }
            this.f1751a.mo401e(false);
        }
    }
}
