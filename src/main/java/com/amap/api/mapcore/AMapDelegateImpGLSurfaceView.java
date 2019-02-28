package com.amap.api.mapcore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.mapcore.C0338k.C0337a;
import com.amap.api.mapcore.aq.C0320a;
import com.amap.api.mapcore.util.C0360b;
import com.amap.api.mapcore.util.C0360b.C0303a;
import com.amap.api.mapcore.util.C0375c;
import com.amap.api.mapcore.util.C0375c.C0308a;
import com.amap.api.mapcore.util.C0376e;
import com.amap.api.mapcore.util.C0399o;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.OnCacheRemoveListener;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnInfoWindowClickListener;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapLongClickListener;
import com.amap.api.maps.AMap.OnMapScreenShotListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.AMap.OnMarkerDragListener;
import com.amap.api.maps.AMap.OnMyLocationChangeListener;
import com.amap.api.maps.AMap.OnPOIClickListener;
import com.amap.api.maps.AMap.onMapPrintScreenListener;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.offlinemap.OfflineDBDao;
import com.autonavi.amap.mapcore.Convert;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.VTMCDataCache;
import com.e4a.runtime.components.Component;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p054u.aly.bi_常量类;

class AMapDelegateImpGLSurfaceView extends GLSurfaceView implements Renderer, C0313u {
    private static Handler aH = new Handler();
    private static final double ay = Math.log(2.0d);
    /* renamed from: A */
    private aq f1399A;
    /* renamed from: B */
    private bi_常量类 f1400B;
    /* renamed from: C */
    private aj f1401C;
    /* renamed from: D */
    private C0342m f1402D;
    /* renamed from: E */
    private ba f1403E;
    /* renamed from: F */
    private OnMyLocationChangeListener f1404F;
    /* renamed from: G */
    private OnMarkerClickListener f1405G;
    /* renamed from: H */
    private OnMarkerDragListener f1406H;
    /* renamed from: I */
    private OnMapLoadedListener f1407I;
    /* renamed from: J */
    private OnCameraChangeListener f1408J;
    /* renamed from: K */
    private OnMapClickListener f1409K;
    /* renamed from: L */
    private OnMapTouchListener f1410L;
    /* renamed from: M */
    private OnPOIClickListener f1411M;
    /* renamed from: N */
    private OnMapLongClickListener f1412N;
    /* renamed from: O */
    private OnInfoWindowClickListener f1413O;
    /* renamed from: P */
    private InfoWindowAdapter f1414P;
    /* renamed from: Q */
    private InfoWindowAdapter f1415Q;
    /* renamed from: R */
    private View f1416R;
    /* renamed from: S */
    private C0294z f1417S;
    /* renamed from: T */
    private ay f1418T;
    /* renamed from: U */
    private boolean f1419U;
    /* renamed from: V */
    private ae f1420V;
    /* renamed from: W */
    private ai f1421W;
    /* renamed from: X */
    private LocationSource f1422X;
    /* renamed from: Y */
    private Rect f1423Y;
    /* renamed from: Z */
    private boolean f1424Z;
    /* renamed from: a */
    am f1425a;
    private Handler aA;
    private Handler aB;
    private Runnable aC;
    private Runnable aD;
    private C0346o aE;
    private volatile boolean aF;
    private volatile boolean aG;
    private Runnable aI;
    private volatile boolean aJ;
    private boolean aK;
    private boolean aL;
    private boolean aM;
    private boolean aN;
    private Marker aO;
    private C0294z aP;
    private boolean aQ;
    private boolean aR;
    private boolean aS;
    private int aT;
    private boolean aU;
    private Thread aV;
    private LatLngBounds aW;
    private boolean aX;
    private boolean aY;
    private boolean aZ;
    private boolean aa;
    private boolean ab;
    private C0333h ac;
    private C0360b ad;
    private as ae;
    private C0336j af;
    private int ag;
    private int ah;
    private CancelableCallback ai;
    private boolean aj;
    private int ak;
    private boolean al;
    private boolean am;
    private Drawable an;
    private Location ao;
    private Boolean ap;
    private final int[] aq;
    private boolean ar;
    private onMapPrintScreenListener as;
    private OnMapScreenShotListener at;
    private Handler au;
    private C0338k av;
    private Timer aw;
    private TimeChangedReceiver ax;
    private volatile boolean az;
    /* renamed from: b */
    public an f1426b;
    private int ba;
    private int bb;
    /* renamed from: c */
    bj f1427c;
    /* renamed from: d */
    bf f1428d;
    /* renamed from: e */
    boolean f1429e;
    /* renamed from: f */
    CustomRenderer f1430f;
    /* renamed from: g */
    C0350r f1431g;
    /* renamed from: h */
    Runnable f1432h;
    /* renamed from: i */
    final Handler f1433i;
    /* renamed from: j */
    private boolean f1434j;
    /* renamed from: k */
    private int f1435k;
    /* renamed from: l */
    private int f1436l;
    /* renamed from: m */
    private Bitmap f1437m;
    /* renamed from: n */
    private Bitmap f1438n;
    /* renamed from: o */
    private boolean f1439o;
    /* renamed from: p */
    private CopyOnWriteArrayList<Integer> f1440p;
    /* renamed from: q */
    private CopyOnWriteArrayList<Integer> f1441q;
    /* renamed from: r */
    private int f1442r;
    /* renamed from: s */
    private MapCore f1443s;
    /* renamed from: t */
    private Context f1444t;
    /* renamed from: u */
    private C0315a f1445u;
    /* renamed from: v */
    private MapProjection f1446v;
    /* renamed from: w */
    private GestureDetector f1447w;
    /* renamed from: x */
    private ScaleGestureDetector f1448x;
    /* renamed from: y */
    private C0375c f1449y;
    /* renamed from: z */
    private SurfaceHolder f1450z;

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$1 */
    class C02931 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1328a;

        C02931(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1328a = aMapDelegateImpGLSurfaceView;
        }

        public void run() {
            try {
                this.f1328a.mo366a(this.f1328a.f1417S);
            } catch (Throwable e) {
                az.m3143a(e, "AMapDelegateImpGLSurfaceView", "showInfoWindow postDelayed");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$3 */
    class C02963 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1349a;

        C02963(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1349a = aMapDelegateImpGLSurfaceView;
        }

        public void run() {
            try {
                this.f1349a.mo401e(true);
                this.f1349a.f1443s.setParameter(2501, 0, 0, 0, 0);
                this.f1349a.m2120U();
                this.f1349a.f1443s.setParameter(2501, 1, 0, 0, 0);
                this.f1349a.mo401e(false);
            } catch (Throwable th) {
                az.m3143a(th, "AMapDelegateImpGLSurfaceView", "setNightMode");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$6 */
    class C02996 implements InfoWindowAdapter {
        /* renamed from: a */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1354a;

        C02996(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1354a = aMapDelegateImpGLSurfaceView;
        }

        public View getInfoWindow(Marker marker) {
            return null;
        }

        public View getInfoContents(Marker marker) {
            return null;
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$7 */
    class C03007 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1355a;

        C03007(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1355a = aMapDelegateImpGLSurfaceView;
        }

        public void run() {
            this.f1355a.f1433i.obtainMessage(19).sendToTarget();
        }
    }

    public class TimeChangedReceiver extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1365a;

        public TimeChangedReceiver(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1365a = aMapDelegateImpGLSurfaceView;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.DATE_CHANGED".equals(action)) {
            }
            if ("android.intent.action.TIME_SET".equals(action)) {
                this.f1365a.f1433i.sendEmptyMessage(22);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$a */
    private class C0304a implements C0303a {
        /* renamed from: a */
        Float f1366a;
        /* renamed from: b */
        Float f1367b;
        /* renamed from: c */
        IPoint f1368c;
        /* renamed from: d */
        float f1369d;
        /* renamed from: e */
        C0338k f1370e;
        /* renamed from: f */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1371f;
        /* renamed from: g */
        private float f1372g;
        /* renamed from: h */
        private float f1373h;
        /* renamed from: i */
        private float f1374i;
        /* renamed from: j */
        private float f1375j;
        /* renamed from: k */
        private float f1376k;

        private C0304a(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1371f = aMapDelegateImpGLSurfaceView;
            this.f1366a = null;
            this.f1367b = null;
            this.f1368c = new IPoint();
            this.f1369d = 0.0f;
            this.f1370e = C0338k.m2875a();
        }

        /* renamed from: a */
        public void mo326a(float f, float f2, float f3, float f4, float f5) {
            this.f1372g = f2;
            this.f1374i = f3;
            this.f1373h = f4;
            this.f1375j = f5;
            this.f1376k = (this.f1375j - this.f1374i) / (this.f1373h - this.f1372g);
            this.f1366a = null;
            this.f1367b = null;
            if (this.f1371f.aZ) {
                this.f1370e.f1836a = C0337a.changeGeoCenterZoomTiltBearing;
                this.f1371f.m2220a(this.f1371f.ba, this.f1371f.bb, this.f1368c);
                this.f1370e.f1850o = this.f1368c;
                this.f1370e.f1849n = this.f1371f.aZ;
            } else {
                this.f1370e.f1836a = C0337a.changeTilt;
            }
            this.f1370e.f1839d = this.f1371f.f1446v.getMapZoomer();
            this.f1370e.f1842g = this.f1371f.f1446v.getMapAngle();
        }

        /* renamed from: a */
        public boolean mo327a(MotionEvent motionEvent, float f, float f2, float f3, float f4) {
            try {
                if (!this.f1371f.f1421W.mo550g() || this.f1371f.aM || this.f1371f.aR) {
                    return true;
                }
                if (this.f1367b == null) {
                    this.f1367b = Float.valueOf(f4);
                }
                if (this.f1366a == null) {
                    this.f1366a = Float.valueOf(f2);
                }
                float f5 = this.f1374i - f2;
                float f6 = this.f1375j - f4;
                float f7 = this.f1372g - f;
                float f8 = this.f1373h - f3;
                if (((double) Math.abs(this.f1376k - ((f4 - f2) / (f3 - f)))) >= 0.2d || (((f5 <= 0.0f || f6 <= 0.0f) && (f5 >= 0.0f || f6 >= 0.0f)) || ((f7 < 0.0f || f8 < 0.0f) && (f7 > 0.0f || f8 > 0.0f)))) {
                    return false;
                }
                f5 = (this.f1366a.floatValue() - f2) / 4.0f;
                this.f1371f.aL = true;
                this.f1369d = this.f1371f.f1446v.getCameraHeaderAngle() - f5;
                this.f1370e.f1841f = this.f1369d;
                this.f1371f.f1425a.m2443a(this.f1370e);
                this.f1371f.mo412k();
                this.f1366a = Float.valueOf(f2);
                this.f1367b = Float.valueOf(f4);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        }

        /* renamed from: a */
        public void mo325a() {
            if (!this.f1371f.aM) {
                try {
                    if (!this.f1371f.f1421W.mo548f()) {
                        return;
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                try {
                    this.f1371f.mo391b(C0338k.m2889c());
                } catch (Throwable e2) {
                    az.m3143a(e2, "AMapDelegateImpGLSurfaceView", "onMultiTouchSingleTap");
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$b */
    private class C0306b implements OnDoubleTapListener {
        /* renamed from: a */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1379a;

        private C0306b(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1379a = aMapDelegateImpGLSurfaceView;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onDoubleTap(android.view.MotionEvent r6) {
            /*
            r5 = this;
            r4 = 1;
            r0 = r5.f1379a;	 Catch:{ RemoteException -> 0x000e }
            r0 = r0.f1421W;	 Catch:{ RemoteException -> 0x000e }
            r0 = r0.mo548f();	 Catch:{ RemoteException -> 0x000e }
            if (r0 != 0) goto L_0x0012;
        L_0x000d:
            return r4;
        L_0x000e:
            r0 = move-exception;
            r0.printStackTrace();
        L_0x0012:
            r0 = r5.f1379a;
            r0 = r0.aT;
            if (r0 > r4) goto L_0x000d;
        L_0x001a:
            r0 = r5.f1379a;
            r0.aS = r4;
            r0 = r5.f1379a;
            r0 = r0.f1446v;
            r0 = r0.getMapZoomer();
            r1 = r5.f1379a;
            r1 = r1.mo415m();
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 == 0) goto L_0x000d;
        L_0x0033:
            r0 = r6.getX();
            r1 = r6.getY();
            r0 = (int) r0;
            r1 = (int) r1;
            r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r3 = new android.graphics.Point;
            r3.<init>(r0, r1);
            r0 = com.amap.api.mapcore.C0338k.m2878a(r2, r3);
            r1 = r5.f1379a;	 Catch:{ RemoteException -> 0x004e }
            r1.mo391b(r0);	 Catch:{ RemoteException -> 0x004e }
            goto L_0x000d;
        L_0x004e:
            r0 = move-exception;
            r1 = "AMapDelegateImpGLSurfaceView";
            r2 = "onDoubleTap";
            com.amap.api.mapcore.util.az.m3143a(r0, r1, r2);
            r0.printStackTrace();
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView.b.onDoubleTap(android.view.MotionEvent):boolean");
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.f1379a.aQ = false;
            if (this.f1379a.aU) {
                this.f1379a.aU = false;
            } else {
                if (this.f1379a.f1416R != null) {
                    if (this.f1379a.f1426b.m2456a(new Rect(this.f1379a.f1416R.getLeft(), this.f1379a.f1416R.getTop(), this.f1379a.f1416R.getRight(), this.f1379a.f1416R.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        if (this.f1379a.f1413O != null) {
                            C0294z e = this.f1379a.f1426b.m2464e();
                            if (e.mo307o()) {
                                this.f1379a.f1413O.onInfoWindowClick(new Marker(e));
                            }
                        }
                    }
                }
                try {
                    if (this.f1379a.f1426b.m2458b(motionEvent)) {
                        final C0294z e2 = this.f1379a.f1426b.m2464e();
                        if (e2 != null && e2.mo307o()) {
                            Marker marker = new Marker(e2);
                            if (this.f1379a.f1405G != null) {
                                if (this.f1379a.f1405G.onMarkerClick(marker) || this.f1379a.f1426b.m2450a() <= 0) {
                                    this.f1379a.f1426b.m2461c(e2);
                                } else {
                                    this.f1379a.au.postDelayed(new Runnable(this) {
                                        /* renamed from: b */
                                        final /* synthetic */ C0306b f1378b;

                                        public void run() {
                                            try {
                                                this.f1378b.f1379a.mo366a(e2);
                                            } catch (Throwable th) {
                                                az.m3143a(th, "AMapDelegateImpGLSurfaceView", "onSingleTapUp showInfoWindow");
                                                th.printStackTrace();
                                            }
                                        }
                                    }, 20);
                                    if (!(this.f1379a.f1426b.m2464e() == null || e2.mo274F())) {
                                        LatLng g = e2.mo299g();
                                        if (g != null) {
                                            IPoint iPoint = new IPoint();
                                            this.f1379a.mo353a(g.latitude, g.longitude, iPoint);
                                            this.f1379a.mo362a(C0338k.m2885a(iPoint));
                                        }
                                    }
                                }
                            }
                            this.f1379a.f1426b.m2461c(e2);
                        }
                    } else {
                        if (this.f1379a.f1409K != null) {
                            DPoint dPoint = new DPoint();
                            this.f1379a.mo359a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
                            this.f1379a.f1409K.onMapClick(new LatLng(dPoint.f3636y, dPoint.f3635x));
                        }
                        if (this.f1379a.f1411M != null) {
                            List a = this.f1379a.m2134a((int) motionEvent.getX(), (int) motionEvent.getY(), 25);
                            if (a != null && a.size() > 0) {
                                this.f1379a.f1411M.onPOIClick((Poi) a.get(0));
                            }
                        }
                    }
                } catch (Throwable e3) {
                    az.m3143a(e3, "AMapDelegateImpGLSurfaceView", "onSingleTapUp moveCamera");
                    e3.printStackTrace();
                } catch (Throwable e32) {
                    az.m3143a(e32, "AMapDelegateImpGLSurfaceView", "onSingleTapUp");
                    e32.printStackTrace();
                }
            }
            return true;
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$c */
    private class C0307c implements OnGestureListener {
        /* renamed from: a */
        FPoint f1380a;
        /* renamed from: b */
        IPoint f1381b;
        /* renamed from: c */
        IPoint f1382c;
        /* renamed from: d */
        C0338k f1383d;
        /* renamed from: e */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1384e;

        private C0307c(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1384e = aMapDelegateImpGLSurfaceView;
            this.f1380a = new FPoint();
            this.f1381b = new IPoint();
            this.f1382c = new IPoint();
            this.f1383d = C0338k.m2885a(this.f1382c);
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f1384e.aQ = false;
            if (!this.f1384e.aS) {
                try {
                    this.f1384e.mo417o();
                } catch (Throwable e) {
                    az.m3143a(e, "AMapDelegateImpGLSurfaceView", "onDown");
                    e.printStackTrace();
                }
            }
            this.f1384e.aS = false;
            this.f1384e.aT = 0;
            this.f1380a.f3637x = motionEvent.getX();
            this.f1380a.f3638y = motionEvent.getY();
            this.f1384e.m2220a((int) this.f1380a.f3637x, (int) this.f1380a.f3638y, this.f1381b);
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onFling(android.view.MotionEvent r11, android.view.MotionEvent r12, float r13, float r14) {
            /*
            r10 = this;
            r4 = 0;
            r9 = 1;
            r0 = r10.f1384e;
            r0.aQ = r4;
            r0 = r10.f1384e;	 Catch:{ RemoteException -> 0x0014 }
            r0 = r0.f1421W;	 Catch:{ RemoteException -> 0x0014 }
            r0 = r0.mo546e();	 Catch:{ RemoteException -> 0x0014 }
            if (r0 != 0) goto L_0x001f;
        L_0x0013:
            return r9;
        L_0x0014:
            r0 = move-exception;
            r1 = "AMapDelegateImpGLSurfaceView";
            r2 = "onFling";
            com.amap.api.mapcore.util.az.m3143a(r0, r1, r2);
            r0.printStackTrace();
        L_0x001f:
            r0 = r10.f1384e;
            r0 = r0.ad;
            r0 = r0.m3149a();
            if (r0 != 0) goto L_0x0013;
        L_0x002b:
            r0 = r11.getEventTime();
            r2 = r10.f1384e;
            r2 = r2.ad;
            r2 = r2.m3151b();
            r0 = r0 - r2;
            r2 = 30;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 < 0) goto L_0x0013;
        L_0x0040:
            r0 = r10.f1384e;
            r0 = r0.mo406h();
            r1 = r10.f1384e;
            r1 = r1.mo409i();
            r6 = r0 * 2;
            r8 = r1 * 2;
            r2 = r10.f1384e;
            r0 = r0 / 2;
            r2.ag = r0;
            r0 = r10.f1384e;
            r1 = r1 / 2;
            r0.ah = r1;
            r0 = r10.f1384e;
            r1 = 0;
            r0.ai = r1;
            r0 = r10.f1384e;
            r0 = r0.f1416R;
            if (r0 == 0) goto L_0x0096;
        L_0x006c:
            r0 = r10.f1384e;
            r0 = r0.f1417S;
            if (r0 == 0) goto L_0x0096;
        L_0x0074:
            r0 = r10.f1384e;
            r0 = r0.f1417S;
            r0 = r0.mo274F();
            if (r0 != 0) goto L_0x0096;
        L_0x0080:
            r0 = r10.f1384e;
            r0.f1419U = r4;
            r0 = r10.f1384e;
            r0 = r0.f1418T;
            if (r0 == 0) goto L_0x0096;
        L_0x008d:
            r0 = r10.f1384e;
            r0 = r0.f1418T;
            r0.mo291b(r9);
        L_0x0096:
            r0 = r10.f1384e;
            r0 = r0.af;
            r1 = r10.f1384e;
            r1 = r1.ag;
            r2 = r10.f1384e;
            r2 = r2.ah;
            r3 = -r13;
            r3 = (int) r3;
            r3 = r3 * 3;
            r3 = r3 / 5;
            r4 = -r14;
            r4 = (int) r4;
            r4 = r4 * 3;
            r4 = r4 / 5;
            r5 = -r6;
            r7 = -r8;
            r0.m2860a(r1, r2, r3, r4, r5, r6, r7, r8);
            r0 = r10.f1384e;
            r0 = r0.f1428d;
            if (r0 == 0) goto L_0x0013;
        L_0x00bf:
            r0 = r10.f1384e;
            r0 = r0.f1428d;
            r0.m2781b(r9);
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView.c.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        public void onLongPress(MotionEvent motionEvent) {
            this.f1384e.aQ = false;
            this.f1384e.aP = this.f1384e.f1426b.m2452a(motionEvent);
            DPoint dPoint;
            if (this.f1384e.f1406H != null && this.f1384e.aP != null && this.f1384e.aP.mo303k()) {
                this.f1384e.aO = new Marker(this.f1384e.aP);
                LatLng position = this.f1384e.aO.getPosition();
                LatLng g = this.f1384e.aP.mo299g();
                IPoint iPoint = new IPoint();
                this.f1384e.mo387b(g.latitude, g.longitude, iPoint);
                iPoint.f3640y -= 60;
                dPoint = new DPoint();
                this.f1384e.mo359a(iPoint.f3639x, iPoint.f3640y, dPoint);
                this.f1384e.aO.setPosition(new LatLng((position.latitude + dPoint.f3636y) - g.latitude, (position.longitude + dPoint.f3635x) - g.longitude));
                this.f1384e.f1426b.m2461c(this.f1384e.aP);
                this.f1384e.f1406H.onMarkerDragStart(this.f1384e.aO);
                this.f1384e.aN = true;
            } else if (this.f1384e.f1412N != null) {
                dPoint = new DPoint();
                this.f1384e.mo359a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
                this.f1384e.f1412N.onMapLongClick(new LatLng(dPoint.f3636y, dPoint.f3635x));
                this.f1384e.aU = true;
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f1384e.aQ = true;
            if ((!this.f1384e.af.m2863a() && this.f1384e.af.m2873j() == 1) || this.f1384e.ad.m3149a() || motionEvent2.getEventTime() - this.f1384e.ad.m3151b() < 30) {
                this.f1384e.aQ = false;
            } else if (motionEvent2.getPointerCount() >= 2) {
                this.f1384e.aQ = false;
            } else {
                try {
                    if (!this.f1384e.f1421W.mo546e()) {
                        this.f1384e.aQ = false;
                    }
                } catch (Throwable e) {
                    az.m3143a(e, "AMapDelegateImpGLSurfaceView", "onScroll");
                    e.printStackTrace();
                }
                if (this.f1384e.aT > 1) {
                    this.f1384e.aQ = false;
                } else {
                    if (!(this.f1384e.f1416R == null || this.f1384e.f1417S == null || this.f1384e.f1417S.mo274F() || this.f1384e.f1418T == null)) {
                        this.f1384e.f1418T.mo291b(true);
                    }
                    IPoint iPoint = new IPoint();
                    this.f1384e.m2220a((int) motionEvent2.getX(), (int) motionEvent2.getY(), iPoint);
                    int i = this.f1381b.f3639x - iPoint.f3639x;
                    int i2 = this.f1381b.f3640y - iPoint.f3640y;
                    IPoint iPoint2 = new IPoint();
                    this.f1384e.f1446v.getGeoCenter(iPoint2);
                    this.f1382c.f3639x = i + iPoint2.f3639x;
                    this.f1382c.f3640y = i2 + iPoint2.f3640y;
                    this.f1383d.f1850o = this.f1382c;
                    this.f1384e.f1425a.m2443a(this.f1383d);
                }
            }
            return true;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$d */
    private class C0309d implements C0308a {
        /* renamed from: a */
        float f1385a;
        /* renamed from: b */
        float f1386b;
        /* renamed from: c */
        IPoint f1387c;
        /* renamed from: d */
        C0338k f1388d;
        /* renamed from: e */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1389e;

        private C0309d(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1389e = aMapDelegateImpGLSurfaceView;
            this.f1385a = 0.0f;
            this.f1386b = 0.0f;
            this.f1387c = new IPoint();
            this.f1388d = C0338k.m2875a();
        }

        /* renamed from: a */
        public boolean mo328a(C0375c c0375c) {
            if (this.f1389e.aL) {
                return false;
            }
            float b = c0375c.m3318b();
            this.f1385a += b;
            if (!this.f1389e.aR && Math.abs(this.f1385a) <= 30.0f && Math.abs(this.f1385a) <= 350.0f) {
                return true;
            }
            this.f1389e.aR = true;
            this.f1386b = b + this.f1389e.f1446v.getMapAngle();
            this.f1388d.f1842g = this.f1386b;
            this.f1389e.f1425a.m2443a(this.f1388d);
            this.f1385a = 0.0f;
            return true;
        }

        /* renamed from: b */
        public boolean mo329b(C0375c c0375c) {
            try {
                if (!this.f1389e.f1421W.mo552h()) {
                    return false;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (this.f1389e.aZ) {
                this.f1388d.f1849n = this.f1389e.aZ;
                this.f1388d.f1836a = C0337a.changeBearingGeoCenter;
                this.f1389e.m2220a(this.f1389e.ba, this.f1389e.bb, this.f1387c);
                this.f1388d.f1850o = this.f1387c;
            } else {
                this.f1388d.f1836a = C0337a.changeBearing;
            }
            this.f1389e.aR = false;
            this.f1385a = 0.0f;
            this.f1389e.aT = 2;
            if (this.f1389e.aL || ((float) this.f1389e.getWidth()) / 8.0f >= c0375c.m3314c()) {
                return false;
            }
            return true;
        }

        /* renamed from: c */
        public void mo330c(C0375c c0375c) {
            this.f1385a = 0.0f;
            if (this.f1389e.aR) {
                this.f1389e.aR = false;
                C0338k a = C0338k.m2875a();
                a.f1851p = true;
                this.f1389e.f1425a.m2443a(a);
            }
            this.f1389e.m2124W();
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$e */
    private class C0310e implements OnScaleGestureListener {
        /* renamed from: a */
        C0338k f1390a;
        /* renamed from: b */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1391b;
        /* renamed from: c */
        private float f1392c;
        /* renamed from: d */
        private IPoint f1393d;

        private C0310e(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
            this.f1391b = aMapDelegateImpGLSurfaceView;
            this.f1392c = 0.0f;
            this.f1393d = new IPoint();
            this.f1390a = C0338k.m2875a();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!this.f1391b.aL) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (this.f1391b.aM || ((double) scaleFactor) > 1.08d || ((double) scaleFactor) < 0.92d) {
                    this.f1391b.aM = true;
                    scaleFactor = (float) (Math.log((double) scaleFactor) / AMapDelegateImpGLSurfaceView.ay);
                    this.f1390a.f1839d = C0405u.m3473b(scaleFactor + this.f1392c);
                    this.f1391b.f1425a.m2443a(this.f1390a);
                }
            }
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            try {
                if (!this.f1391b.f1421W.mo548f() || this.f1391b.aT < 2) {
                    return false;
                }
            } catch (Throwable e) {
                az.m3143a(e, "AMapDelegateImpGLSurfaceView", "onScaleBegin");
                e.printStackTrace();
            }
            this.f1391b.aT = 2;
            if (this.f1391b.aL) {
                return false;
            }
            if (this.f1391b.aZ) {
                this.f1390a.f1849n = this.f1391b.aZ;
                this.f1390a.f1836a = C0337a.changeGeoCenterZoom;
                this.f1391b.m2220a(this.f1391b.ba, this.f1391b.bb, this.f1393d);
                this.f1390a.f1850o = this.f1393d;
            } else {
                this.f1390a.f1836a = C0337a.zoomTo;
            }
            this.f1391b.aM = false;
            this.f1392c = this.f1391b.f1446v.getMapZoomer();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f1392c = 0.0f;
            if (this.f1391b.aM) {
                this.f1391b.aM = false;
                C0338k a = C0338k.m2875a();
                a.f1851p = true;
                this.f1391b.f1425a.m2443a(a);
            }
            this.f1391b.m2124W();
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$f */
    private class C0311f extends TimerTask {
        /* renamed from: a */
        AMapDelegateImpGLSurfaceView f1394a;
        /* renamed from: b */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1395b;

        public C0311f(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView, AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView2) {
            this.f1395b = aMapDelegateImpGLSurfaceView;
            this.f1394a = aMapDelegateImpGLSurfaceView2;
        }

        public void run() {
            if (!this.f1395b.aF || this.f1395b.aG || !this.f1395b.f1431g.m2949e()) {
                this.f1394a.requestRender();
            } else if (!this.f1395b.f1426b.m2463d()) {
                this.f1394a.requestRender();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.AMapDelegateImpGLSurfaceView$g */
    private class C0312g implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AMapDelegateImpGLSurfaceView f1396a;
        /* renamed from: b */
        private Context f1397b;
        /* renamed from: c */
        private OnCacheRemoveListener f1398c;

        public C0312g(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView, Context context, OnCacheRemoveListener onCacheRemoveListener) {
            this.f1396a = aMapDelegateImpGLSurfaceView;
            this.f1397b = context;
            this.f1398c = onCacheRemoveListener;
        }

        public void run() {
            Throwable th;
            Throwable th2;
            boolean z;
            boolean z2 = true;
            boolean z3 = false;
            try {
                Context applicationContext = this.f1397b.getApplicationContext();
                String b = C0405u.m3476b(applicationContext);
                String a = C0405u.m3456a(applicationContext);
                boolean z4 = this.f1396a.m2142a(new File(b));
                if (z4) {
                    try {
                        if (this.f1396a.m2142a(new File(a))) {
                            z3 = true;
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        z = z4;
                        this.f1396a.f1443s.setParameter(2601, 1, 0, 0, 0);
                        if (this.f1398c != null) {
                            this.f1398c.onRemoveCacheFinish(z);
                        }
                        throw th2;
                    }
                }
                try {
                    OfflineDBDao.getInstance(this.f1396a.getContext().getApplicationContext()).clear();
                    try {
                        this.f1396a.f1443s.setParameter(2601, 1, 0, 0, 0);
                        if (this.f1398c != null) {
                            this.f1398c.onRemoveCacheFinish(z3);
                        }
                    } catch (Throwable th32) {
                        th32.printStackTrace();
                    }
                } catch (Throwable th322) {
                    z = z3;
                    th2 = th322;
                    this.f1396a.f1443s.setParameter(2601, 1, 0, 0, 0);
                    if (this.f1398c != null) {
                        this.f1398c.onRemoveCacheFinish(z);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th322 = th4;
                az.m3143a(th322, "AMapDelegateImpGLSurfaceView", "RemoveCacheRunnable");
                this.f1396a.f1443s.setParameter(2601, 1, 0, 0, 0);
                if (this.f1398c == null) {
                    this.f1398c.onRemoveCacheFinish(false);
                }
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0312g;
        }
    }

    /* renamed from: a */
    public void mo381a(CustomRenderer customRenderer) {
        this.f1430f = customRenderer;
    }

    /* renamed from: a */
    public MapCore m2209a() {
        return this.f1443s;
    }

    /* renamed from: b */
    public int mo386b() {
        return this.f1435k;
    }

    /* renamed from: c */
    public MapProjection mo395c() {
        if (this.f1446v == null) {
            this.f1446v = this.f1443s.getMapstate();
        }
        return this.f1446v;
    }

    /* renamed from: a */
    public void m2245a(GL10 gl10) {
        int i = 0;
        if (!this.f1439o) {
            int[] iArr = new int[VTMCDataCache.MAXSIZE];
            gl10.glGenTextures(VTMCDataCache.MAXSIZE, iArr, 0);
            while (i < iArr.length) {
                this.f1440p.add(Integer.valueOf(iArr[i]));
                i++;
            }
            this.f1439o = true;
        }
    }

    public AMapDelegateImpGLSurfaceView(Context context) {
        this(context, null);
        this.f1444t = context;
        this.f1450z = getHolder();
        this.f1450z.addCallback(this);
    }

    public AMapDelegateImpGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1434j = false;
        this.f1435k = -1;
        this.f1436l = -1;
        this.f1437m = null;
        this.f1438n = null;
        this.f1439o = false;
        this.f1440p = new CopyOnWriteArrayList();
        this.f1441q = new CopyOnWriteArrayList();
        this.f1442r = 1;
        this.f1445u = null;
        this.f1425a = new am(this);
        this.f1450z = null;
        this.f1419U = true;
        this.f1423Y = new Rect();
        this.f1424Z = true;
        this.aa = false;
        this.ab = true;
        this.f1429e = false;
        this.ag = 0;
        this.ah = 0;
        this.ai = null;
        this.aj = false;
        this.ak = 0;
        this.al = false;
        this.am = false;
        this.an = null;
        this.ap = Boolean.valueOf(false);
        this.aq = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, 10000, 5000, 2000, 1000, VTMCDataCache.MAXSIZE, 200, 100, 50, 25, 10, 5};
        this.ar = false;
        this.as = null;
        this.at = null;
        this.au = new Handler();
        this.av = null;
        this.ax = null;
        this.az = false;
        this.aA = new Handler();
        this.aB = new C0321b(this);
        this.aC = new C0330e(this);
        this.aD = new C0331f(this);
        this.f1431g = new C0350r();
        this.aE = new C0346o();
        this.aF = false;
        this.aG = false;
        this.aI = new C0332g(this);
        this.aJ = false;
        this.aK = false;
        this.aL = false;
        this.aM = false;
        this.aN = false;
        this.aO = null;
        this.aP = null;
        this.aQ = false;
        this.aR = false;
        this.aS = false;
        this.aT = 0;
        this.aU = false;
        this.aV = new C0328c(this);
        this.aW = null;
        this.f1433i = new C0329d(this);
        this.aX = false;
        this.aY = false;
        this.aZ = false;
        setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        this.f1444t = context;
        this.f1443s = new MapCore(context);
        this.f1445u = new C0315a(this);
        this.f1443s.setMapCallback(this.f1445u);
        this.f1446v = this.f1443s.getMapstate();
        this.f1425a.m2443a(C0338k.m2882a(new LatLng(39.924216d, 116.3978653d), 10.0f, 0.0f, 0.0f));
        this.f1420V = new az(this);
        this.ac = new C0333h(this);
        this.f1421W = new bg(this);
        this.f1447w = new GestureDetector(context, new C0307c());
        this.f1447w.setOnDoubleTapListener(new C0306b());
        this.f1447w.setIsLongpressEnabled(true);
        this.f1448x = new ScaleGestureDetector(context, new C0310e());
        this.f1449y = new C0375c(context, new C0309d());
        this.ad = new C0360b(context, new C0304a());
        this.f1399A = new aq(this, context, this) {
            /* renamed from: a */
            final /* synthetic */ AMapDelegateImpGLSurfaceView f1353a;

            /* renamed from: a */
            protected void mo320a() {
                super.mo320a();
                this.f1353a.au.removeCallbacks(this.f1353a.aD);
                this.f1353a.au.post(this.f1353a.aC);
            }
        };
        this.f1400B = new bi_常量类(this.f1444t, this);
        this.f1403E = new ba(this.f1444t, this);
        this.f1428d = new bf(this.f1444t, this);
        this.f1427c = new bj(this.f1444t, this);
        this.f1401C = new aj(this.f1444t, this.f1425a, this);
        this.f1402D = new C0342m(this.f1444t, this.f1425a, this);
        this.f1426b = new an(this.f1444t, attributeSet, this);
        this.f1400B.setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        this.f1403E.setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        this.f1399A.setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        this.f1428d.setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        this.f1427c.setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        this.f1426b.setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        this.f1401C.setBackgroundColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 235, 235, 235));
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f1399A.addView(this, 0, layoutParams);
        this.f1399A.addView(this.f1426b, new C0320a(layoutParams));
        this.f1399A.addView(this.f1400B, layoutParams);
        this.f1399A.addView(this.f1403E, layoutParams);
        this.f1399A.addView(this.f1428d, layoutParams);
        this.f1399A.addView(this.f1427c, new C0320a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        this.f1399A.addView(this.f1401C, new C0320a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        try {
            if (!this.f1421W.mo544d()) {
                this.f1401C.setVisibility(8);
            }
        } catch (Throwable e) {
            az.m3143a(e, "AMapDelegateImpGLSurfaceView", "locationView gone");
            e.printStackTrace();
        }
        this.f1399A.addView(this.f1402D, new C0320a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 51));
        this.f1402D.setVisibility(8);
        this.af = new C0336j(context);
        this.ae = new as(this, context);
        this.f1415Q = new C02996(this);
        this.f1414P = this.f1415Q;
        setRenderer(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        this.ax = new TimeChangedReceiver(this);
        this.f1444t.registerReceiver(this.ax, intentFilter);
        this.f1427c.setId(AutoTestConfig.ZoomControllerViewId);
        this.f1403E.setId(AutoTestConfig.ScaleControlsViewId);
        this.f1401C.setId(AutoTestConfig.MyLocationViewId);
        this.f1402D.setId(AutoTestConfig.CompassViewId);
    }

    /* renamed from: a */
    public void mo365a(C0348q c0348q) {
        this.aE.m2933a(c0348q);
    }

    /* renamed from: a */
    public void mo378a(OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f1404F = onMyLocationChangeListener;
    }

    public void onResume() {
        m2116S();
        if (this.f1445u != null) {
            this.f1445u.onResume();
            mo401e(false);
        }
        if (this.f1428d != null) {
            this.f1428d.m2785e();
        }
        if (this.ae != null) {
            this.ae.m2548b();
        }
    }

    public void onPause() {
        m2118T();
        if (this.f1445u != null) {
            this.f1445u.onPause();
        }
        if (this.f1428d != null) {
            this.f1428d.m2784d();
        }
        if (this.ae != null) {
            this.ae.m2543a();
        }
    }

    /* renamed from: a */
    public void mo383a(MyLocationStyle myLocationStyle) {
        if (this.ae != null) {
            this.ae.m2547a(myLocationStyle);
        }
    }

    /* renamed from: a */
    public void mo356a(int i) {
        if (this.ae != null) {
            this.ae.m2545a(i);
        }
    }

    /* renamed from: a */
    public void mo354a(float f) throws RemoteException {
        if (this.ae != null) {
            this.ae.m2544a(f);
        }
    }

    /* renamed from: a */
    public void mo361a(Location location) throws RemoteException {
        if (location != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            try {
                if (!this.f1424Z || this.f1422X == null) {
                    this.ae.m2549c();
                    this.ae = null;
                    return;
                }
                if (this.ae == null || this.ao == null) {
                    if (this.ae == null) {
                        this.ae = new as(this, this.f1444t);
                    }
                    mo362a(C0338k.m2881a(latLng, this.f1446v.getMapZoomer()));
                }
                this.ae.m2546a(location);
                if (!(this.f1404F == null || (this.ao != null && this.ao.getBearing() == location.getBearing() && this.ao.getAccuracy() == location.getAccuracy() && this.ao.getLatitude() == location.getLatitude() && this.ao.getLongitude() == location.getLongitude()))) {
                    this.f1404F.onMyLocationChange(location);
                }
                this.ao = new Location(location);
                mo401e(false);
            } catch (Throwable e) {
                az.m3143a(e, "AMapDelegateImpGLSurfaceView", "showMyLocationOverlay");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo384a(boolean z) {
        if (this.f1427c != null) {
            if (z) {
                this.f1427c.setVisibility(0);
            } else {
                this.f1427c.setVisibility(8);
            }
        }
    }

    /* renamed from: d */
    public void mo397d() {
        this.ap = Boolean.valueOf(true);
        try {
            m2118T();
            if (this.f1438n != null) {
                this.f1438n.recycle();
                this.f1438n = null;
            }
            if (this.f1437m != null) {
                this.f1437m.recycle();
                this.f1437m = null;
            }
            if (!(this.f1433i == null || this.f1432h == null)) {
                this.f1433i.removeCallbacks(this.f1432h);
                this.f1432h = null;
            }
            if (aH != null) {
                aH.removeCallbacks(this.aI);
            }
            if (this.ax != null) {
                this.f1444t.unregisterReceiver(this.ax);
            }
            if (this.f1427c != null) {
                this.f1427c.m2824a();
            }
            if (this.f1403E != null) {
                this.f1403E.m2646a();
            }
            if (this.f1400B != null) {
                this.f1400B.m2812a();
            }
            if (this.f1401C != null) {
                this.f1401C.m2410a();
            }
            if (this.f1402D != null) {
                this.f1402D.m2930a();
            }
            if (this.f1428d != null) {
                this.f1428d.m2780b();
            }
            if (this.f1431g != null) {
                this.f1431g.m2945b();
            }
            if (this.f1426b != null) {
                this.f1426b.m2466f();
            }
            if (this.aV != null) {
                this.aV.interrupt();
            }
            if (this.f1445u != null) {
                this.f1445u.OnMapDestory(this.f1443s);
            }
            mo429y();
            C0405u.m3463a(this.an);
            if (this.f1440p != null) {
                this.f1440p.clear();
            }
            if (this.f1441q != null) {
                this.f1441q.clear();
            }
            az.m3145c();
            m2115R();
            C0399o.m3422a("amap", "完全释放", ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH);
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "destroy");
            C0399o.m3422a("amap", "没有完全释放" + th.getMessage(), ErrorCode.NETWORK_NOT_WIFI_ERROR);
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo392b(boolean z) {
        if (this.f1401C != null) {
            if (z) {
                this.f1401C.setVisibility(0);
            } else {
                this.f1401C.setVisibility(8);
            }
        }
    }

    /* renamed from: c */
    public void mo396c(boolean z) {
        if (this.f1402D != null) {
            if (z) {
                this.f1402D.setVisibility(0);
                this.f1402D.m2931b();
                return;
            }
            this.f1402D.setVisibility(8);
        }
    }

    /* renamed from: e */
    void m2264e() {
        this.f1433i.obtainMessage(14).sendToTarget();
    }

    /* renamed from: d */
    public void mo399d(boolean z) {
        if (this.f1403E != null) {
            if (z) {
                this.f1403E.setVisibility(0);
                m2267f();
                return;
            }
            this.f1403E.m2648a(bi_常量类.f6358b_空串);
            this.f1403E.m2647a(0);
            this.f1403E.setVisibility(8);
        }
    }

    /* renamed from: f */
    void m2267f() {
        this.f1433i.sendEmptyMessage(15);
    }

    /* renamed from: g */
    void m2270g() {
        if (this.f1403E != null) {
            try {
                LatLng latLng = mo413l().target;
                float mapZoomer = this.f1446v.getMapZoomer();
                int cos = (int) ((((double) this.aq[(int) mapZoomer]) / ((double) ((float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, (double) mapZoomer)))))) * ((double) 1.0f));
                String b = C0405u.m3475b(this.aq[(int) mapZoomer]);
                this.f1403E.m2647a(cos);
                this.f1403E.m2648a(b);
                this.f1403E.invalidate();
            } catch (Throwable th) {
                az.m3143a(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean mo385a(String str) throws RemoteException {
        mo401e(false);
        return this.f1431g.m2946b(str);
    }

    /* renamed from: e */
    public synchronized void mo401e(boolean z) {
        if (!z) {
            this.aG = false;
            aH.removeCallbacks(this.aI);
            this.aF = false;
        } else if (!(this.aF || this.aG)) {
            this.aG = true;
            aH.postDelayed(this.aI, 6000);
        }
    }

    /* renamed from: R */
    private void m2115R() {
        if (this.f1443s != null) {
            this.f1443s.destroy();
        }
    }

    public void onDrawFrame(GL10 gl10) {
        if (!this.ap.booleanValue()) {
            if (this.f1434j) {
                this.f1434j = false;
                m2149c(gl10);
            }
            gl10.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            this.f1443s.setGL(gl10);
            this.f1443s.drawFrame(gl10);
            m2245a(gl10);
            this.f1431g.m2944a(gl10, false, this.ak);
            this.f1428d.m2778a(gl10);
            this.f1426b.m2455a(gl10);
            this.aE.m2932a(gl10);
            if (this.f1418T != null) {
                this.f1418T.m1945a(gl10);
            }
            if (this.ar && this.f1445u.isDownloaded()) {
                this.f1433i.obtainMessage(16, m2126a(0, 0, getWidth(), getHeight(), gl10)).sendToTarget();
                this.ar = false;
            }
            if (!this.af.m2863a()) {
                this.f1433i.sendEmptyMessage(13);
            }
            if (!this.aa) {
                this.f1433i.sendEmptyMessage(11);
                this.aa = true;
            }
        }
    }

    /* renamed from: h */
    public int mo406h() {
        return this.f1423Y.width();
    }

    /* renamed from: i */
    public int mo409i() {
        return this.f1423Y.height();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f1423Y = new Rect(0, 0, i, i2);
        m2139a(gl10, i, i2);
    }

    /* renamed from: a */
    private void m2139a(GL10 gl10, int i, int i2) {
        this.f1443s.setGL(gl10);
        this.f1443s.surfaceChange(gl10, i, i2);
        int i3 = this.f1444t.getResources().getDisplayMetrics().densityDpi;
        m2120U();
        if (i3 <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
            this.f1443s.setParameter(2051, 100, 50, 1, 0);
        } else if (i3 <= 160) {
            if (Math.min(i, i2) >= 1000) {
                this.f1443s.setParameter(2051, 80, 100, 1, 0);
            } else if (Math.max(i, i2) <= 480) {
                this.f1443s.setParameter(2051, ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 60, 1, 0);
            } else {
                this.f1443s.setParameter(2051, 100, 80, 1, 0);
            }
        } else if (i3 <= ErrorCode.COPY_EXCEPTION) {
            this.f1443s.setParameter(2051, 100, 80, 1, 0);
        } else if (i3 <= 240) {
            if (Math.min(i, i2) >= 1000) {
                this.f1443s.setParameter(2051, 60, 100, 2, 0);
            } else {
                this.f1443s.setParameter(2051, 100, 90, 2, 0);
            }
        } else if (i3 <= ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE) {
            if (Math.max(i, i2) <= 1280) {
                this.f1443s.setParameter(2051, 90, 100, 2, 0);
            } else if (Math.max(i, i2) >= 2160) {
                this.f1443s.setParameter(2051, 50, 170, 2, 0);
            } else {
                this.f1443s.setParameter(2051, 70, 150, 2, 0);
            }
        } else if (i3 <= 480) {
            this.f1443s.setParameter(2051, 70, 150, 3, 0);
        } else if (i3 == 640) {
            this.f1443s.setParameter(2051, 50, 180, 3, 0);
        } else {
            this.f1443s.setParameter(2051, 60, 180, 3, 0);
        }
        this.f1443s.setParameter(1021, 1, 0, 0, 0);
        this.f1443s.setParameter(1022, 0, 0, 0, 0);
        this.f1443s.setParameter(1023, 1, 0, 0, 0);
        mo401e(false);
        if (this.f1432h == null) {
            this.f1432h = new C03007(this);
        }
        this.f1433i.postDelayed(this.f1432h, 300);
        if (this.f1430f != null) {
            this.f1430f.onSurfaceChanged(gl10, i, i2);
        }
    }

    /* renamed from: a */
    public void mo358a(int i, int i2, int i3, int i4) {
        this.f1443s.setParameter(2201, 1, 1, 1, 1);
        this.f1443s.setParameter(2202, i, i2, i3, i4);
    }

    /* renamed from: S */
    private synchronized void m2116S() {
        if (this.aw != null) {
            m2118T();
        }
        if (this.aw == null) {
            this.aw = new Timer();
        }
        this.aw.schedule(new C0311f(this, this), 0, 20);
    }

    /* renamed from: T */
    private synchronized void m2118T() {
        if (this.aw != null) {
            this.aw.cancel();
            this.aw = null;
        }
    }

    /* renamed from: U */
    private synchronized void m2120U() {
        int i = 1;
        synchronized (this) {
            try {
                if (!this.aJ) {
                    this.aJ = true;
                    this.f1443s.setStyleData(C0405u.m3481b(this.f1444t, this.az ? "style_v3_night.data" : "style_v3.data"), 0);
                    this.f1443s.setStyleData(C0405u.m3481b(this.f1444t, "style_sv3.data"), 1);
                    C0399o.m3422a("amapv241", "mapInit - loadStyle", 115);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, this.az ? "bk_night.pvr" : "bk.pvr"), 1);
                    C0399o.m3422a("amapv241", "mapInit - loadBackground", 115);
                    if (this.f1444t.getResources().getDisplayMetrics().densityDpi >= 240) {
                        this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, this.az ? "icn_h_night.data" : "icn_h.data"), 0);
                    } else {
                        String str;
                        MapCore mapCore = this.f1443s;
                        Context context = this.f1444t;
                        if (this.az) {
                            str = "icn_night.data";
                        } else {
                            str = "icn.data";
                        }
                        mapCore.setInternaltexture(C0405u.m3481b(context, str), 0);
                    }
                    C0399o.m3422a("amapv241", "mapInit - loadIcon", 115);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, "roadarrow.pvr"), 2);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, "LineRound.pvr"), 3);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, "dash.pvr"), 8);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, "tgl.data"), 6);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, "trl.data"), 4);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, "tyl.data"), 5);
                    this.f1443s.setInternaltexture(C0405u.m3481b(this.f1444t, "tbl.data"), 7);
                    C0399o.m3422a("amapv241", "mapInit - loadResSuccessed", 115);
                    MapCore mapCore2 = this.f1443s;
                    if (!this.az) {
                        i = 0;
                    }
                    mapCore2.setParameter(2401, i, 0, 0, 0);
                }
            } catch (Throwable th) {
                az.m3143a(th, "AMapDelegateImpGLSurfaceView", "setInternaltexture");
                C0399o.m3422a("amapv241", "mapInitError", ErrorCode.DOWNLOAD_OVER_FLOW);
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m2145b(GL10 gl10) {
        m2116S();
        this.f1443s.setGL(gl10);
        m2120U();
        this.f1443s.surfaceCreate(gl10);
        String glGetString = gl10.glGetString(7937);
        if (glGetString != null) {
            if (glGetString.toLowerCase(Locale.US).indexOf("adreno") > -1) {
                this.ab = true;
                this.f1443s.setParameter(1001, 0, 0, 0, 0);
            } else {
                this.ab = false;
                this.f1443s.setParameter(1001, 1, 0, 0, 0);
            }
        }
        if (this.f1437m == null || this.f1437m.isRecycled()) {
            this.f1437m = C0405u.m3450a(this.f1444t, "lineTexture.png");
        }
        if (this.f1438n == null || this.f1438n.isRecycled()) {
            this.f1438n = C0405u.m3450a(this.f1444t, "lineDashTexture.png");
        }
        this.f1435k = C0405u.m3447a(gl10, this.f1437m);
        this.f1436l = C0405u.m3448a(gl10, this.f1438n, true);
        this.f1437m = null;
        mo401e(false);
        if (!this.f1429e) {
            try {
                this.aV.setName("AuthThread");
                this.aV.start();
                this.f1429e = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        setRenderMode(0);
        m2145b(gl10);
        if (this.f1430f != null) {
            this.f1430f.onSurfaceCreated(gl10, eGLConfig);
        }
    }

    /* renamed from: j */
    public int mo411j() {
        return this.f1436l;
    }

    /* renamed from: k */
    public void mo412k() {
        try {
            if (this.f1419U && this.f1416R != null && this.f1417S != null && !this.f1417S.mo274F()) {
                C0320a c0320a = (C0320a) this.f1416R.getLayoutParams();
                if (c0320a != null) {
                    this.f1417S.mo295d();
                    int D = this.f1417S.mo272D() + this.f1417S.mo270B();
                    int E = (this.f1417S.mo273E() + this.f1417S.mo271C()) + 2;
                    c0320a.f1497a = this.f1417S.mo298f();
                    c0320a.f1498b = D;
                    c0320a.f1499c = E;
                    if (this.f1418T != null) {
                        this.f1418T.m1941a(this.f1417S.mo298f());
                        this.f1418T.m1950b(D, E);
                    }
                }
                this.f1399A.onLayout(false, 0, 0, 0, 0);
            }
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    public void setZOrderOnTop(boolean z) {
        super.setZOrderOnTop(z);
    }

    /* renamed from: l */
    public CameraPosition mo413l() throws RemoteException {
        return mo410i(this.aZ);
    }

    /* renamed from: m */
    public float mo415m() {
        return 20.0f;
    }

    /* renamed from: n */
    public float mo416n() {
        return 3.0f;
    }

    /* renamed from: a */
    public void mo362a(C0338k c0338k) throws RemoteException {
        if (c0338k.f1836a == C0337a.newLatLngBounds) {
            boolean z = getWidth() > 0 && getHeight() > 0;
            C0376e.m3322a(z, (Object) "the map must have a size");
        }
        mo417o();
        c0338k.f1851p = true;
        c0338k.f1849n = this.aZ;
        this.f1425a.m2443a(c0338k);
    }

    /* renamed from: b */
    public void mo391b(C0338k c0338k) throws RemoteException {
        mo364a(c0338k, null);
    }

    /* renamed from: a */
    public void mo364a(C0338k c0338k, CancelableCallback cancelableCallback) throws RemoteException {
        mo363a(c0338k, 250, cancelableCallback);
    }

    /* renamed from: a */
    public void mo363a(C0338k c0338k, long j, CancelableCallback cancelableCallback) throws RemoteException {
        if (c0338k.f1836a == C0337a.newLatLngBounds) {
            boolean z = getWidth() > 0 && getHeight() > 0;
            C0376e.m3322a(z, (Object) "the map must have a size");
        }
        if (!this.af.m2863a()) {
            this.af.m2862a(true);
            if (this.ai != null) {
                this.ai.onCancel();
            }
        }
        this.af.m2865b(this.aZ);
        this.ai = cancelableCallback;
        if (this.al) {
            this.am = true;
        }
        this.aj = false;
        if (c0338k.f1836a == C0337a.scrollBy) {
            if (c0338k.f1837b == 0.0f && c0338k.f1838c == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
            this.af.m2865b(false);
            IPoint iPoint = new IPoint();
            this.f1446v.getGeoCenter(iPoint);
            IPoint iPoint2 = new IPoint();
            m2220a((getWidth() / 2) + ((int) c0338k.f1837b), (getHeight() / 2) + ((int) c0338k.f1838c), iPoint2);
            this.af.m2861a(new AccelerateDecelerateInterpolator());
            this.af.m2859a(iPoint.f3639x, iPoint.f3640y, this.f1446v.getMapZoomer(), this.f1446v.getMapAngle(), this.f1446v.getCameraHeaderAngle(), iPoint2.f3639x - iPoint.f3639x, iPoint2.f3640y - iPoint.f3640y, 0.0f, 0.0f, 0.0f, j);
        } else if (c0338k.f1836a == C0337a.zoomIn) {
            r5 = this.f1446v.getMapZoomer();
            r10 = C0405u.m3473b(1.0f + r5) - r5;
            if (r10 == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
            r4 = new IPoint();
            if (this.aZ) {
                m2220a(this.ba, this.bb, r4);
            } else {
                this.f1446v.getGeoCenter(r4);
            }
            this.af.m2861a(new AccelerateInterpolator());
            this.af.m2859a(r4.f3639x, r4.f3640y, r5, this.f1446v.getMapAngle(), this.f1446v.getCameraHeaderAngle(), 0, 0, r10, 0.0f, 0.0f, j);
        } else if (c0338k.f1836a == C0337a.zoomOut) {
            r5 = this.f1446v.getMapZoomer();
            r10 = C0405u.m3473b(r5 - 1.0f) - r5;
            if (r10 == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
            r4 = new IPoint();
            if (this.aZ) {
                m2220a(this.ba, this.bb, r4);
            } else {
                this.f1446v.getGeoCenter(r4);
            }
            this.af.m2861a(new AccelerateInterpolator());
            this.af.m2859a(r4.f3639x, r4.f3640y, r5, this.f1446v.getMapAngle(), this.f1446v.getCameraHeaderAngle(), 0, 0, r10, 0.0f, 0.0f, j);
        } else if (c0338k.f1836a == C0337a.zoomTo) {
            r5 = this.f1446v.getMapZoomer();
            r10 = C0405u.m3473b(c0338k.f1839d) - r5;
            if (r10 == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
            r4 = new IPoint();
            if (this.aZ) {
                m2220a(this.ba, this.bb, r4);
            } else {
                this.f1446v.getGeoCenter(r4);
            }
            this.af.m2861a(new AccelerateInterpolator());
            this.af.m2859a(r4.f3639x, r4.f3640y, r5, this.f1446v.getMapAngle(), this.f1446v.getCameraHeaderAngle(), 0, 0, r10, 0.0f, 0.0f, j);
        } else if (c0338k.f1836a == C0337a.zoomBy) {
            this.af.m2865b(false);
            float f = c0338k.f1840e;
            r5 = this.f1446v.getMapZoomer();
            r10 = C0405u.m3473b(r5 + f) - r5;
            if (r10 == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
            Point point = c0338k.f1848m;
            r4 = new IPoint();
            this.f1446v.getGeoCenter(r4);
            r8 = 0;
            r9 = 0;
            IPoint iPoint3 = new IPoint();
            if (point != null) {
                m2220a(point.x, point.y, iPoint3);
                r3 = r4.f3639x - iPoint3.f3639x;
                r6 = r4.f3640y - iPoint3.f3640y;
                r8 = (int) ((((double) r3) / Math.pow(2.0d, (double) f)) - ((double) r3));
                r9 = (int) ((((double) r6) / Math.pow(2.0d, (double) f)) - ((double) r6));
            } else if (this.aZ) {
                m2220a(this.ba, this.bb, iPoint3);
                r3 = r4.f3639x - iPoint3.f3639x;
                r6 = r4.f3640y - iPoint3.f3640y;
                r8 = (int) ((((double) r3) / Math.pow(2.0d, (double) f)) - ((double) r3));
                r9 = (int) ((((double) r6) / Math.pow(2.0d, (double) f)) - ((double) r6));
            }
            this.af.m2861a(new AccelerateInterpolator());
            this.af.m2859a(r4.f3639x, r4.f3640y, r5, this.f1446v.getMapAngle(), this.f1446v.getCameraHeaderAngle(), r8, r9, r10, 0.0f, 0.0f, j);
        } else if (c0338k.f1836a == C0337a.newCameraPosition) {
            r4 = new IPoint();
            if (this.aZ) {
                m2220a(this.ba, this.bb, r4);
            } else {
                this.f1446v.getGeoCenter(r4);
            }
            r2 = new IPoint();
            CameraPosition cameraPosition = c0338k.f1843h;
            MapProjection.lonlat2Geo(cameraPosition.target.longitude, cameraPosition.target.latitude, r2);
            r5 = this.f1446v.getMapZoomer();
            r8 = r2.f3639x - r4.f3639x;
            r9 = r2.f3640y - r4.f3640y;
            r10 = C0405u.m3473b(cameraPosition.zoom) - r5;
            r6 = this.f1446v.getMapAngle();
            r11 = (cameraPosition.bearing % 360.0f) - (r6 % 360.0f);
            if (Math.abs(r11) >= 180.0f) {
                r11 -= Math.signum(r11) * 360.0f;
            }
            r7 = this.f1446v.getCameraHeaderAngle();
            r12 = C0405u.m3443a(cameraPosition.tilt) - r7;
            if (r8 == 0 && r9 == 0 && r10 == 0.0f && r11 == 0.0f && r12 == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            } else {
                this.af.m2861a(new AccelerateInterpolator());
                this.af.m2859a(r4.f3639x, r4.f3640y, r5, r6, r7, r8, r9, r10, r11, r12, j);
            }
        } else if (c0338k.f1836a == C0337a.changeBearing) {
            r6 = this.f1446v.getMapAngle();
            r11 = (c0338k.f1842g % 360.0f) - (r6 % 360.0f);
            if (Math.abs(r11) >= 180.0f) {
                r11 -= Math.signum(r11) * 360.0f;
            }
            if (r11 == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
            r4 = new IPoint();
            if (this.aZ) {
                m2220a(this.ba, this.bb, r4);
            } else {
                this.f1446v.getGeoCenter(r4);
            }
            this.af.m2861a(new AccelerateInterpolator());
            this.af.m2859a(r4.f3639x, r4.f3640y, this.f1446v.getMapZoomer(), r6, this.f1446v.getCameraHeaderAngle(), 0, 0, 0.0f, r11, 0.0f, j);
        } else if (c0338k.f1836a == C0337a.changeTilt) {
            r7 = this.f1446v.getCameraHeaderAngle();
            r12 = c0338k.f1841f - r7;
            if (r12 == 0.0f) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
            r4 = new IPoint();
            if (this.aZ) {
                m2220a(this.ba, this.bb, r4);
            } else {
                this.f1446v.getGeoCenter(r4);
            }
            this.af.m2861a(new AccelerateInterpolator());
            this.af.m2859a(r4.f3639x, r4.f3640y, this.f1446v.getMapZoomer(), this.f1446v.getMapAngle(), r7, 0, 0, 0.0f, 0.0f, r12, j);
        } else if (c0338k.f1836a == C0337a.changeCenter) {
            r4 = new IPoint();
            if (this.aZ) {
                m2220a(this.ba, this.bb, r4);
            } else {
                this.f1446v.getGeoCenter(r4);
            }
            r8 = c0338k.f1850o.f3639x - r4.f3639x;
            r9 = c0338k.f1850o.f3640y - r4.f3640y;
            if (r8 == 0 && r9 == 0) {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            } else {
                this.af.m2861a(new AccelerateDecelerateInterpolator());
                this.af.m2859a(r4.f3639x, r4.f3640y, this.f1446v.getMapZoomer(), this.f1446v.getMapAngle(), this.f1446v.getCameraHeaderAngle(), r8, r9, 0.0f, 0.0f, 0.0f, j);
            }
        } else if (c0338k.f1836a == C0337a.newLatLngBounds || c0338k.f1836a == C0337a.newLatLngBoundsWithSize) {
            this.af.m2865b(false);
            if (c0338k.f1836a == C0337a.newLatLngBounds) {
                r3 = getWidth();
                r8 = getHeight();
                r9 = r3;
            } else {
                r3 = c0338k.f1846k;
                r8 = c0338k.f1847l;
                r9 = r3;
            }
            float mapAngle = this.f1446v.getMapAngle() % 360.0f;
            float cameraHeaderAngle = this.f1446v.getCameraHeaderAngle();
            r11 = -mapAngle;
            if (Math.abs(r11) >= 180.0f) {
                r11 -= Math.signum(r11) * 360.0f;
            }
            r12 = -cameraHeaderAngle;
            LatLngBounds latLngBounds = c0338k.f1844i;
            int i = c0338k.f1845j;
            IPoint iPoint4 = new IPoint();
            this.f1446v.getGeoCenter(iPoint4);
            float mapZoomer = this.f1446v.getMapZoomer();
            this.af.m2861a(new AccelerateInterpolator());
            r2 = new IPoint();
            IPoint iPoint5 = new IPoint();
            MapProjection.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.northeast.latitude, r2);
            MapProjection.lonlat2Geo(latLngBounds.southwest.longitude, latLngBounds.southwest.latitude, iPoint5);
            int i2 = r2.f3639x - iPoint5.f3639x;
            int i3 = iPoint5.f3640y - r2.f3640y;
            if (i2 > 0 || i3 > 0) {
                int i4 = (r2.f3639x + iPoint5.f3639x) / 2;
                int i5 = (r2.f3640y + iPoint5.f3640y) / 2;
                IPoint iPoint6 = new IPoint();
                mo387b((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) / 2.0d, (latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) / 2.0d, iPoint6);
                int i6;
                if ((!this.f1423Y.contains(iPoint6.f3639x, iPoint6.f3640y) ? 1 : null) == null) {
                    r3 = r9 - (i * 2);
                    i6 = r8 - (i * 2);
                    if (r3 <= 0) {
                        r3 = 1;
                    }
                    if (i6 <= 0) {
                        i6 = 1;
                    }
                    r10 = C0405u.m3473b((float) ((int) (Math.min(Math.log(((double) this.f1446v.getMapLenWithWin(r3)) / ((double) this.f1446v.getMapLenWithGeo(i2))) / Math.log(2.0d), Math.log(((double) this.f1446v.getMapLenWithWin(i6)) / ((double) this.f1446v.getMapLenWithGeo(i3))) / Math.log(2.0d)) + ((double) mapZoomer)))) - mapZoomer;
                    r8 = i4 - iPoint4.f3639x;
                    r9 = i5 - iPoint4.f3640y;
                    if (r8 == 0 && r9 == 0 && r10 == 0.0f) {
                        this.f1433i.obtainMessage(17).sendToTarget();
                        return;
                    } else {
                        this.af.m2861a(new DecelerateInterpolator());
                        this.af.m2859a(iPoint4.f3639x, iPoint4.f3640y, mapZoomer, mapAngle, cameraHeaderAngle, r8, r9, r10, r11, r12, j);
                    }
                } else {
                    final CancelableCallback cancelableCallback2 = this.ai;
                    final LatLngBounds latLngBounds2 = latLngBounds;
                    final int i7 = r9;
                    r6 = r8;
                    final int i8 = i;
                    final long j2 = j;
                    this.ai = new CancelableCallback(this) {
                        /* renamed from: g */
                        final /* synthetic */ AMapDelegateImpGLSurfaceView f1362g;

                        public void onFinish() {
                            try {
                                this.f1362g.mo363a(C0338k.m2884a(latLngBounds2, i7, r6, i8), j2, cancelableCallback2);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        public void onCancel() {
                            if (cancelableCallback2 != null) {
                                cancelableCallback2.onCancel();
                            }
                        }
                    };
                    i3 = ((iPoint4.f3639x + i4) / 2) - iPoint4.f3639x;
                    int i9 = ((iPoint4.f3640y + i5) / 2) - iPoint4.f3640y;
                    i6 = (int) C0405u.m3442a((double) (((float) mo406h()) / 2.0f), (double) (((float) mo409i()) / 2.0f), (double) Math.abs(i4 - iPoint4.f3639x), (double) Math.abs(i5 - iPoint4.f3640y));
                    r10 = i6 == 0 ? 0.0f : ((float) i6) - mapZoomer;
                    if (r10 >= 0.0f) {
                        r10 = 0.0f;
                    }
                    this.aj = true;
                    this.af.m2859a(iPoint4.f3639x, iPoint4.f3640y, mapZoomer, mapAngle, cameraHeaderAngle, i3, i9, r10, r11 / 2.0f, r12 / 2.0f, j / 2);
                }
            } else {
                this.f1433i.obtainMessage(17).sendToTarget();
                return;
            }
        } else {
            c0338k.f1851p = true;
            this.f1425a.m2443a(c0338k);
        }
        mo401e(false);
    }

    /* renamed from: o */
    public void mo417o() throws RemoteException {
        if (!this.af.m2863a()) {
            this.af.m2862a(true);
            m2247a(true, null);
            if (this.ai != null) {
                this.ai.onCancel();
            }
            if (!(this.f1416R == null || this.f1418T == null)) {
                this.f1416R.setVisibility(0);
            }
            this.ai = null;
        }
        mo401e(false);
    }

    /* renamed from: a */
    public ad mo343a(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        ab axVar = new ax(this);
        axVar.mo489a(polylineOptions.getColor());
        axVar.mo492b(polylineOptions.isGeodesic());
        axVar.mo493c(polylineOptions.isDottedLine());
        axVar.mo490a(polylineOptions.getPoints());
        axVar.mo462a(polylineOptions.isVisible());
        axVar.mo491b(polylineOptions.getWidth());
        axVar.mo458a(polylineOptions.getZIndex());
        axVar.m2628d(polylineOptions.isUseTexture());
        if (polylineOptions.getCustomTexture() != null) {
            Bitmap bitmap = polylineOptions.getCustomTexture().clone().getBitmap();
            if (bitmap != null) {
                axVar.m2613a(bitmap);
            }
        }
        this.f1431g.m2943a(axVar);
        mo401e(false);
        return axVar;
    }

    /* renamed from: a */
    public aa mo341a(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        ab atVar = new at(this);
        atVar.mo459a(navigateArrowOptions.getTopColor());
        atVar.mo467b(navigateArrowOptions.getSideColor());
        atVar.mo460a(navigateArrowOptions.getPoints());
        atVar.mo462a(navigateArrowOptions.isVisible());
        atVar.mo466b(navigateArrowOptions.getWidth());
        atVar.mo458a(navigateArrowOptions.getZIndex());
        this.f1431g.m2943a(atVar);
        mo401e(false);
        return atVar;
    }

    /* renamed from: a */
    public ac mo342a(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        ab awVar = new aw(this);
        awVar.mo479a(polygonOptions.getFillColor());
        awVar.mo480a(polygonOptions.getPoints());
        awVar.mo462a(polygonOptions.isVisible());
        awVar.mo482b(polygonOptions.getStrokeWidth());
        awVar.mo458a(polygonOptions.getZIndex());
        awVar.mo483b(polygonOptions.getStrokeColor());
        this.f1431g.m2943a(awVar);
        mo401e(false);
        return awVar;
    }

    /* renamed from: a */
    public C0339w mo345a(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        ab c0340l = new C0340l(this);
        c0340l.mo565b(circleOptions.getFillColor());
        c0340l.mo563a(circleOptions.getCenter());
        c0340l.mo462a(circleOptions.isVisible());
        c0340l.mo564b(circleOptions.getStrokeWidth());
        c0340l.mo458a(circleOptions.getZIndex());
        c0340l.mo562a(circleOptions.getStrokeColor());
        c0340l.mo561a(circleOptions.getRadius());
        this.f1431g.m2943a(c0340l);
        mo401e(false);
        return c0340l;
    }

    /* renamed from: a */
    public C0334v mo344a(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        ab c0335i = new C0335i(this);
        c0335i.mo557a(arcOptions.getStrokeColor());
        c0335i.m2836a(arcOptions.getStart());
        c0335i.m2843b(arcOptions.getPassed());
        c0335i.m2845c(arcOptions.getEnd());
        c0335i.mo462a(arcOptions.isVisible());
        c0335i.mo558b(arcOptions.getStrokeWidth());
        c0335i.mo458a(arcOptions.getZIndex());
        this.f1431g.m2943a(c0335i);
        mo401e(false);
        return c0335i;
    }

    /* renamed from: a */
    public C0352x mo346a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        ab c0353t = new C0353t(this);
        c0353t.m2980b(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        c0353t.mo572a(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        c0353t.mo573a(groundOverlayOptions.getImage());
        c0353t.mo574a(groundOverlayOptions.getLocation());
        c0353t.mo575a(groundOverlayOptions.getBounds());
        c0353t.mo577c(groundOverlayOptions.getBearing());
        c0353t.mo578d(groundOverlayOptions.getTransparency());
        c0353t.mo462a(groundOverlayOptions.isVisible());
        c0353t.mo458a(groundOverlayOptions.getZIndex());
        this.f1431g.m2943a(c0353t);
        mo401e(false);
        return c0353t;
    }

    /* renamed from: a */
    public Marker mo348a(MarkerOptions markerOptions) throws RemoteException {
        if (markerOptions == null) {
            return null;
        }
        C0294z arVar = new ar(markerOptions, this.f1426b);
        this.f1426b.m2454a(arVar);
        mo401e(false);
        return new Marker(arVar);
    }

    /* renamed from: a */
    public Text mo349a(TextOptions textOptions) throws RemoteException {
        if (textOptions == null) {
            return null;
        }
        C0294z bcVar = new bc(textOptions, this.f1426b);
        this.f1426b.m2454a(bcVar);
        mo401e(false);
        return new Text(bcVar);
    }

    /* renamed from: a */
    public ArrayList<Marker> mo351a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        int i = 0;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList();
        try {
            MarkerOptions markerOptions;
            if (arrayList.size() == 1) {
                markerOptions = (MarkerOptions) arrayList.get(0);
                if (markerOptions != null) {
                    arrayList2.add(mo348a(markerOptions));
                    if (z && markerOptions.getPosition() != null) {
                        mo362a(C0338k.m2881a(markerOptions.getPosition(), 18.0f));
                    }
                    return arrayList2;
                }
            }
            Builder builder = LatLngBounds.builder();
            int i2 = 0;
            while (i2 < arrayList.size()) {
                int i3;
                markerOptions = (MarkerOptions) arrayList.get(i2);
                if (arrayList.get(i2) != null) {
                    arrayList2.add(mo348a(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                        i3 = i + 1;
                        i2++;
                        i = i3;
                    }
                }
                i3 = i;
                i2++;
                i = i3;
            }
            if (z && i > 0) {
                if (this.aa) {
                    mo362a(C0338k.m2883a(builder.build(), 50));
                } else {
                    this.av = C0338k.m2883a(builder.build(), 50);
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    /* renamed from: a */
    public TileOverlay mo350a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null) {
            return null;
        }
        ah beVar = new be(tileOverlayOptions, this.f1428d);
        this.f1428d.m2777a(beVar);
        mo401e(false);
        return new TileOverlay(beVar);
    }

    /* renamed from: p */
    public void mo420p() throws RemoteException {
        try {
            mo429y();
            this.f1431g.m2942a();
            this.f1428d.m2780b();
            this.f1426b.m2457b();
            mo401e(false);
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "clear");
            Log.d("amapApi", "AMapDelegateImpGLSurfaceView clear erro" + th.getMessage());
            th.printStackTrace();
        }
    }

    /* renamed from: q */
    public int mo421q() throws RemoteException {
        return this.f1442r;
    }

    /* renamed from: b */
    public void mo388b(int i) throws RemoteException {
        if (i == 2) {
            try {
                if (this.f1442r == 3) {
                    this.f1425a.m2442a(new al(2012).m2439a(false));
                }
                this.f1442r = 2;
                this.f1425a.m2442a(new al(2011).m2439a(true));
                this.f1400B.m2814a(true);
            } catch (Throwable th) {
                az.m3143a(th, "AMapDelegateImpGLSurfaceView", "setMaptype");
                th.printStackTrace();
            }
        } else if (i == 1) {
            if (this.f1442r == 3) {
                this.f1425a.m2442a(new al(2012).m2439a(false));
            }
            this.f1442r = 1;
            this.f1425a.m2442a(new al(2011).m2439a(false));
            this.f1400B.m2814a(false);
        } else {
            if (this.f1442r == 2) {
                this.f1425a.m2442a(new al(2011).m2439a(false));
            }
            this.f1442r = 3;
            this.f1425a.m2442a(new al(2012).m2439a(true));
            this.f1400B.m2814a(true);
        }
    }

    /* renamed from: r */
    public boolean mo422r() throws RemoteException {
        return this.aK;
    }

    /* renamed from: f */
    public void mo403f(boolean z) throws RemoteException {
        this.aK = z;
        this.f1425a.m2442a(new al(2).m2439a(z));
    }

    /* renamed from: g */
    public void mo405g(final boolean z) throws RemoteException {
        queueEvent(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ AMapDelegateImpGLSurfaceView f1364b;

            public void run() {
                if (this.f1364b.f1443s != null) {
                    int i;
                    MapCore i2 = this.f1364b.f1443s;
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    i2.setParameter(1024, i, 0, 0, 0);
                }
            }
        });
    }

    /* renamed from: s */
    public boolean mo423s() throws RemoteException {
        return this.f1424Z;
    }

    /* renamed from: h */
    public void mo408h(boolean z) throws RemoteException {
        try {
            if (this.f1422X == null) {
                this.f1401C.m2411a(false);
            } else if (z) {
                this.f1422X.activate(this.ac);
                this.f1401C.m2411a(true);
                if (this.ae == null) {
                    this.ae = new as(this, this.f1444t);
                }
            } else {
                if (this.ae != null) {
                    this.ae.m2549c();
                    this.ae = null;
                }
                this.ao = null;
                this.f1422X.deactivate();
            }
            if (!z) {
                this.f1421W.mo543d(z);
            }
            this.f1424Z = z;
            mo401e(false);
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "setMyLocationEnabled");
            th.printStackTrace();
        }
    }

    /* renamed from: t */
    public Location mo425t() throws RemoteException {
        if (this.f1422X != null) {
            return this.ac.f1755a;
        }
        return null;
    }

    /* renamed from: a */
    public void mo382a(LocationSource locationSource) throws RemoteException {
        try {
            this.f1422X = locationSource;
            if (locationSource != null) {
                this.f1401C.m2411a(true);
            } else {
                this.f1401C.m2411a(false);
            }
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "setLocationSource");
            th.printStackTrace();
        }
    }

    /* renamed from: u */
    public ai mo426u() throws RemoteException {
        return this.f1421W;
    }

    /* renamed from: v */
    public ae mo427v() throws RemoteException {
        return this.f1420V;
    }

    /* renamed from: a */
    public void mo369a(OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        this.f1408J = onCameraChangeListener;
    }

    /* renamed from: a */
    void m2243a(CameraPosition cameraPosition) {
        Message message = new Message();
        message.what = 10;
        message.obj = cameraPosition;
        this.f1433i.sendMessage(message);
    }

    /* renamed from: w */
    public OnCameraChangeListener m2294w() throws RemoteException {
        return this.f1408J;
    }

    /* renamed from: a */
    public void mo371a(OnMapClickListener onMapClickListener) throws RemoteException {
        this.f1409K = onMapClickListener;
    }

    /* renamed from: a */
    public void mo375a(OnMapTouchListener onMapTouchListener) throws RemoteException {
        this.f1410L = onMapTouchListener;
    }

    /* renamed from: a */
    public void mo379a(OnPOIClickListener onPOIClickListener) throws RemoteException {
        this.f1411M = onPOIClickListener;
    }

    /* renamed from: a */
    public void mo373a(OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        this.f1412N = onMapLongClickListener;
    }

    /* renamed from: a */
    public void mo376a(OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        this.f1405G = onMarkerClickListener;
    }

    /* renamed from: a */
    public void mo377a(OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        this.f1406H = onMarkerDragListener;
    }

    /* renamed from: a */
    public void mo372a(OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        this.f1407I = onMapLoadedListener;
    }

    /* renamed from: a */
    public void mo370a(OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        this.f1413O = onInfoWindowClickListener;
    }

    /* renamed from: a */
    public void mo367a(InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        if (infoWindowAdapter == null) {
            this.f1414P = this.f1415Q;
        } else {
            this.f1414P = infoWindowAdapter;
        }
    }

    /* renamed from: x */
    public View mo428x() throws RemoteException {
        return this.f1399A;
    }

    /* renamed from: b */
    public float m2249b(float f) throws RemoteException {
        return C0405u.m3473b(f);
    }

    /* renamed from: c */
    public float mo394c(int i) {
        return this.f1446v.getMapLenWithWin(i);
    }

    /* renamed from: a */
    public void mo359a(int i, int i2, DPoint dPoint) {
        m2138a(this.f1446v, i, i2, dPoint);
    }

    /* renamed from: a */
    private void m2138a(MapProjection mapProjection, int i, int i2, DPoint dPoint) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        IPoint iPoint = new IPoint();
        mapProjection.map2Geo(fPoint.f3637x, fPoint.f3638y, iPoint);
        MapProjection.geo2LonLat(iPoint.f3639x, iPoint.f3640y, dPoint);
    }

    /* renamed from: a */
    public void m2220a(int i, int i2, IPoint iPoint) {
        FPoint fPoint = new FPoint();
        this.f1446v.win2Map(i, i2, fPoint);
        this.f1446v.map2Geo(fPoint.f3637x, fPoint.f3638y, iPoint);
    }

    /* renamed from: a */
    public void mo352a(double d, double d2, FPoint fPoint) {
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(d2, d, iPoint);
        this.f1446v.geo2Map(iPoint.f3639x, iPoint.f3640y, fPoint);
    }

    /* renamed from: a */
    public void mo353a(double d, double d2, IPoint iPoint) {
        MapProjection.lonlat2Geo(d2, d, iPoint);
    }

    /* renamed from: a */
    public void mo360a(int i, int i2, FPoint fPoint) {
        this.f1446v.win2Map(i, i2, fPoint);
    }

    /* renamed from: b */
    public void mo390b(int i, int i2, FPoint fPoint) {
        this.f1446v.geo2Map(i2, i, fPoint);
    }

    /* renamed from: a */
    public void mo355a(float f, float f2, IPoint iPoint) {
        this.f1446v.map2Geo(f, f2, iPoint);
    }

    /* renamed from: b */
    public void mo389b(int i, int i2, DPoint dPoint) {
        MapProjection.geo2LonLat(i, i2, dPoint);
    }

    /* renamed from: b */
    public void mo387b(double d, double d2, IPoint iPoint) {
        IPoint iPoint2 = new IPoint();
        FPoint fPoint = new FPoint();
        MapProjection.lonlat2Geo(d2, d, iPoint2);
        this.f1446v.geo2Map(iPoint2.f3639x, iPoint2.f3640y, fPoint);
        this.f1446v.map2Win(fPoint.f3637x, fPoint.f3638y, iPoint);
    }

    /* renamed from: V */
    private LatLng m2122V() {
        DPoint dPoint = new DPoint();
        IPoint iPoint = new IPoint();
        this.f1446v.getGeoCenter(iPoint);
        MapProjection.geo2LonLat(iPoint.f3639x, iPoint.f3640y, dPoint);
        return new LatLng(dPoint.f3636y, dPoint.f3635x, false);
    }

    /* renamed from: i */
    public CameraPosition mo410i(boolean z) {
        LatLng latLng;
        if (z) {
            DPoint dPoint = new DPoint();
            mo359a(this.ba, this.bb, dPoint);
            latLng = new LatLng(dPoint.f3636y, dPoint.f3635x, false);
        } else {
            latLng = m2122V();
        }
        return CameraPosition.builder().target(latLng).bearing(this.f1446v.getMapAngle()).tilt(this.f1446v.getCameraHeaderAngle()).zoom(this.f1446v.getMapZoomer()).build();
    }

    /* renamed from: W */
    private void m2124W() {
        if (this.aU) {
            this.aU = false;
        }
        if (this.aQ) {
            this.aQ = false;
            C0338k a = C0338k.m2875a();
            a.f1851p = true;
            this.f1425a.m2443a(a);
        }
        if (this.aL) {
            this.aL = false;
            a = C0338k.m2875a();
            a.f1851p = true;
            this.f1425a.m2443a(a);
        }
        this.aM = false;
        this.aN = false;
        if (this.f1406H != null && this.aO != null) {
            this.f1406H.onMarkerDragEnd(this.aO);
            this.aO = null;
        }
    }

    /* renamed from: a */
    private void m2136a(MotionEvent motionEvent) throws RemoteException {
        if (this.aN && this.aO != null) {
            int x = (int) motionEvent.getX();
            int y = (int) (motionEvent.getY() - 60.0f);
            LatLng g = this.aP.mo299g();
            LatLng e = this.aP.mo297e();
            DPoint dPoint = new DPoint();
            mo359a(x, y, dPoint);
            this.aO.setPosition(new LatLng((e.latitude + dPoint.f3636y) - g.latitude, (dPoint.f3635x + e.longitude) - g.longitude));
            this.f1406H.onMarkerDrag(this.aO);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.aX) {
            return false;
        }
        mo401e(false);
        if (motionEvent.getAction() == 261) {
            this.aT = motionEvent.getPointerCount();
        }
        this.f1447w.onTouchEvent(motionEvent);
        this.ad.m3150a(motionEvent);
        this.f1448x.onTouchEvent(motionEvent);
        this.f1449y.m2998a(motionEvent);
        if (motionEvent.getAction() == 2) {
            try {
                m2136a(motionEvent);
            } catch (Throwable e) {
                az.m3143a(e, "AMapDelegateImpGLSurfaceView", "onDragMarker");
                e.printStackTrace();
            }
        }
        if (motionEvent.getAction() == 1) {
            m2124W();
        }
        mo401e(false);
        if (this.f1410L != null) {
            this.aB.removeMessages(1);
            Message obtainMessage = this.aB.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = MotionEvent.obtain(motionEvent);
            obtainMessage.sendToTarget();
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    public void mo366a(C0294z c0294z) throws RemoteException {
        int i = -2;
        if (c0294z != null) {
            if ((c0294z.mo301i() != null || c0294z.mo302j() != null) && this.f1414P != null) {
                mo429y();
                this.f1417S = c0294z;
                if (this.aa) {
                    int i2;
                    Marker marker = new Marker(c0294z);
                    this.f1416R = this.f1414P.getInfoWindow(marker);
                    try {
                        if (this.an == null) {
                            this.an = au.m2575a(this.f1444t, "infowindow_bg.9.png");
                        }
                    } catch (Throwable th) {
                        az.m3143a(th, "AMapDelegateImpGLSurfaceView", "showInfoWindow decodeDrawableFromAsset");
                        th.printStackTrace();
                    }
                    if (this.f1416R == null) {
                        this.f1416R = this.f1414P.getInfoContents(marker);
                    }
                    View linearLayout = new LinearLayout(this.f1444t);
                    if (this.f1416R != null) {
                        if (this.f1416R.getBackground() == null) {
                            this.f1416R.setBackgroundDrawable(this.an);
                        }
                        linearLayout.addView(this.f1416R);
                    } else {
                        linearLayout.setBackgroundDrawable(this.an);
                        View textView = new TextView(this.f1444t);
                        textView.setText(c0294z.mo301i());
                        textView.setTextColor(-16777216);
                        View textView2 = new TextView(this.f1444t);
                        textView2.setTextColor(-16777216);
                        textView2.setText(c0294z.mo302j());
                        linearLayout.setOrientation(1);
                        linearLayout.addView(textView);
                        linearLayout.addView(textView2);
                    }
                    this.f1416R = linearLayout;
                    LayoutParams layoutParams = this.f1416R.getLayoutParams();
                    this.f1416R.setDrawingCacheEnabled(true);
                    this.f1416R.setDrawingCacheQuality(0);
                    c0294z.mo295d();
                    int D = c0294z.mo272D() + c0294z.mo270B();
                    int E = (c0294z.mo273E() + c0294z.mo271C()) + 2;
                    if (layoutParams != null) {
                        i2 = layoutParams.width;
                        i = layoutParams.height;
                    } else {
                        i2 = -2;
                    }
                    layoutParams = new C0320a(i2, i, c0294z.mo298f(), D, E, 81);
                    if (this.f1418T == null) {
                        this.f1418T = new ay(this, new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(C0405u.m3453a(this.f1416R))), this) {
                            /* renamed from: a */
                            final /* synthetic */ AMapDelegateImpGLSurfaceView f1348a;

                            /* renamed from: a */
                            public void mo319a() {
                                this.f1348a.au.removeCallbacks(this.f1348a.aC);
                                this.f1348a.au.post(this.f1348a.aD);
                            }
                        };
                        this.f1418T.m1941a(c0294z.mo298f());
                        this.f1418T.m1950b(D, E);
                    } else {
                        this.f1418T.m1941a(c0294z.mo298f());
                        this.f1418T.m1950b(D, E);
                        this.f1418T.mo281a(BitmapDescriptorFactory.fromBitmap(C0405u.m3453a(this.f1416R)));
                    }
                    this.f1399A.addView(this.f1416R, layoutParams);
                    return;
                }
                this.au.postDelayed(new C02931(this), 100);
            }
        }
    }

    /* renamed from: b */
    public boolean mo393b(C0294z c0294z) {
        try {
            if (!(this.f1417S == null || this.f1416R == null)) {
                return this.f1417S.mo300h().equals(c0294z.mo300h());
            }
        } catch (Throwable e) {
            az.m3143a(e, "AMapDelegateImpGLSurfaceView", "isInfoWindowShown");
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: y */
    public void mo429y() {
        if (this.f1416R != null) {
            this.f1416R.clearFocus();
            this.f1399A.removeView(this.f1416R);
            C0405u.m3463a(this.f1416R.getBackground());
            C0405u.m3463a(this.an);
            if (this.f1418T != null) {
                this.f1418T.mo291b(false);
            }
            this.f1416R = null;
        }
        this.f1417S = null;
    }

    /* renamed from: z */
    public float mo430z() {
        return this.f1446v.getMapZoomer();
    }

    /* renamed from: A */
    void m2183A() {
        this.f1433i.obtainMessage(18).sendToTarget();
    }

    /* renamed from: B */
    public LatLngBounds mo331B() {
        return this.aW;
    }

    /* renamed from: a */
    public LatLngBounds mo347a(LatLng latLng, float f) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        MapProjection mapProjection = new MapProjection(this.f1443s);
        mapProjection.setCameraHeaderAngle(0.0f);
        mapProjection.setMapAngle(0.0f);
        mapProjection.setGeoCenter(iPoint.f3639x, iPoint.f3640y);
        mapProjection.setMapZoomer(f);
        mapProjection.recalculate();
        DPoint dPoint = new DPoint();
        m2138a(mapProjection, 0, 0, dPoint);
        LatLng latLng2 = new LatLng(dPoint.f3636y, dPoint.f3635x, false);
        m2138a(mapProjection, width, height, dPoint);
        LatLng latLng3 = new LatLng(dPoint.f3636y, dPoint.f3635x, false);
        mapProjection.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    /* renamed from: C */
    void m2185C() {
        if (!this.aX) {
            setBackgroundColor(0);
            this.f1400B.setBackgroundColor(0);
            this.f1403E.setBackgroundColor(0);
            this.f1399A.setBackgroundColor(0);
            this.f1428d.setBackgroundColor(0);
            if (this.f1427c != null) {
                this.f1427c.setBackgroundColor(0);
            }
            this.f1426b.setBackgroundColor(0);
            this.f1401C.setBackgroundColor(0);
            this.aX = true;
            postInvalidate();
        }
    }

    /* renamed from: D */
    Point m2186D() {
        if (this.f1400B == null) {
            return null;
        }
        return this.f1400B.m2816c();
    }

    /* renamed from: a */
    public static Bitmap m2126a(int i, int i2, int i3, int i4, GL10 gl10) {
        try {
            int[] iArr = new int[(i3 * i4)];
            int[] iArr2 = new int[(i3 * i4)];
            Buffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
            for (int i5 = 0; i5 < i4; i5++) {
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = iArr[(i5 * i3) + i6];
                    iArr2[(((i4 - i5) - 1) * i3) + i6] = ((i7 & Component.f3920) | ((i7 << 16) & 16711680)) | ((i7 >> 16) & WebView.NORMAL_MODE_ALPHA);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i3, 0, 0, i3, i4);
            return createBitmap;
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void mo380a(onMapPrintScreenListener onmapprintscreenlistener) {
        this.as = onmapprintscreenlistener;
        this.ar = true;
        mo401e(false);
    }

    /* renamed from: a */
    public void mo374a(OnMapScreenShotListener onMapScreenShotListener) {
        this.at = onMapScreenShotListener;
        this.ar = true;
        mo401e(false);
    }

    /* renamed from: d */
    public void mo398d(int i) {
        if (this.f1400B != null) {
            this.f1400B.m2813a(i);
            this.f1400B.invalidate();
            if (this.f1403E.getVisibility() == 0) {
                this.f1403E.invalidate();
            }
        }
    }

    /* renamed from: e */
    public void mo400e(int i) {
        if (this.f1427c != null) {
            C0320a c0320a = (C0320a) this.f1427c.getLayoutParams();
            if (i == 0) {
                c0320a.f1500d = 16;
            } else if (i == 1) {
                c0320a.f1500d = 80;
            }
            this.f1399A.updateViewLayout(this.f1427c, c0320a);
        }
    }

    /* renamed from: E */
    public float mo332E() {
        try {
            LatLng latLng = mo413l().target;
            return (float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) this.f1446v.getMapZoomer()) * 256.0d));
        } catch (Throwable th) {
            az.m3143a(th, "AMapDelegateImpGLSurfaceView", "getScalePerPixel");
            th.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: j */
    void m2279j(boolean z) {
        int i;
        Handler handler = this.f1433i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.obtainMessage(20, i, 0).sendToTarget();
    }

    /* renamed from: a */
    protected void m2247a(boolean z, CameraPosition cameraPosition) {
        if (this.f1408J != null && this.af.m2863a() && isEnabled()) {
            if (cameraPosition == null) {
                try {
                    cameraPosition = mo413l();
                } catch (Throwable e) {
                    az.m3143a(e, "AMapDelegateImpGLSurfaceView", "cameraChangeFinish");
                    e.printStackTrace();
                }
            }
            this.f1408J.onCameraChangeFinish(cameraPosition);
        }
    }

    /* renamed from: f */
    public void mo402f(int i) {
        if (this.f1441q.contains(Integer.valueOf(i))) {
            this.f1440p.add(Integer.valueOf(i));
            this.f1441q.remove(this.f1441q.indexOf(Integer.valueOf(i)));
        }
    }

    /* renamed from: F */
    public int mo333F() {
        Integer valueOf = Integer.valueOf(0);
        if (this.f1440p.size() > 0) {
            valueOf = (Integer) this.f1440p.get(0);
            this.f1440p.remove(0);
            this.f1441q.add(valueOf);
        }
        return valueOf.intValue();
    }

    /* renamed from: G */
    public List<Marker> mo334G() {
        boolean z = getWidth() > 0 && getHeight() > 0;
        C0376e.m3322a(z, (Object) "地图未初始化完成！");
        return this.f1426b.m2468g();
    }

    /* renamed from: H */
    public void mo335H() {
        this.f1431g.m2947c();
    }

    /* renamed from: I */
    public void mo336I() {
        this.aY = true;
    }

    /* renamed from: J */
    public boolean m2192J() {
        return this.aY;
    }

    /* renamed from: K */
    public void m2193K() {
        if (this.f1426b != null) {
            this.f1426b.m2469h();
        }
        this.aY = false;
    }

    /* renamed from: a */
    public void mo357a(int i, int i2) {
        if (this.f1445u != null) {
            this.aZ = true;
            this.f1445u.m2311a(i, i2);
            this.ba = i;
            this.bb = i2;
        }
    }

    /* renamed from: g */
    public void mo404g(int i) {
        this.ak = i;
    }

    /* renamed from: L */
    public int mo337L() {
        return this.ak;
    }

    /* renamed from: M */
    public boolean mo338M() {
        return this.aa;
    }

    /* renamed from: k */
    public void m2281k(boolean z) {
        if (this.az != z) {
            this.az = z;
            if (this.aJ) {
                this.aJ = false;
                queueEvent(new C02963(this));
            }
        }
    }

    /* renamed from: N */
    public C0336j mo339N() {
        return this.af;
    }

    /* renamed from: l */
    public void mo414l(final boolean z) throws RemoteException {
        queueEvent(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ AMapDelegateImpGLSurfaceView f1351b;

            public void run() {
                this.f1351b.f1443s.setParameter(2601, z ? 0 : 1, 0, 0, 0);
            }
        });
    }

    /* renamed from: O */
    public void mo340O() {
        mo368a(null);
    }

    /* renamed from: a */
    public void mo368a(OnCacheRemoveListener onCacheRemoveListener) {
        if (this.aA != null) {
            try {
                this.f1443s.setParameter(2601, 0, 0, 0, 0);
                Runnable c0312g = new C0312g(this, this.f1444t, onCacheRemoveListener);
                this.aA.removeCallbacks(c0312g);
                this.aA.post(c0312g);
            } catch (Throwable th) {
                az.m3143a(th, "AMapDelegateImpGLSurfaceView", "removecache");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private boolean m2142a(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!m2142a(listFiles[i])) {
                    return false;
                } else {
                    listFiles[i].delete();
                }
            }
        }
        return true;
    }

    /* renamed from: P */
    public void m2198P() {
        if (this.f1431g != null) {
            this.f1431g.m2948d();
        }
        if (this.f1426b != null) {
            this.f1426b.m2460c();
        }
        if (this.f1430f != null) {
            this.f1430f.OnMapReferencechanged();
        }
    }

    /* renamed from: h */
    public void mo407h(int i) {
        setVisibility(i);
    }

    /* renamed from: a */
    private ArrayList<Poi> m2134a(int i, int i2, int i3) {
        if (!this.aa) {
            return null;
        }
        try {
            ArrayList<Poi> arrayList = new ArrayList();
            byte[] bArr = new byte[2048];
            int labelBuffer = this.f1443s.getLabelBuffer(i, i2, i3, bArr);
            if (labelBuffer <= 0 || bArr == null) {
                return null;
            }
            int i4 = 0;
            DPoint dPoint = new DPoint();
            for (int i5 = 0; i5 < labelBuffer; i5++) {
                int i6 = i4 + 8;
                int i7 = Convert.getInt(bArr, i6);
                i6 += 4;
                MapProjection.geo2LonLat(i7, Convert.getInt(bArr, i6), dPoint);
                i6 += 20;
                i7 = i6 + 1;
                byte b = bArr[i6];
                StringBuffer stringBuffer = new StringBuffer();
                byte b2 = (byte) 0;
                i4 = i7;
                while (b2 < b) {
                    stringBuffer.append((char) Convert.getShort(bArr, i4));
                    b2++;
                    i4 += 2;
                }
                arrayList.add(new Poi(stringBuffer.toString(), new LatLng(dPoint.f3636y, dPoint.f3635x, false)));
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: c */
    private void m2149c(GL10 gl10) {
        CameraPosition l;
        if (this.f1446v != null) {
            try {
                l = mo413l();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            m2118T();
            this.ap = Boolean.valueOf(true);
            if (this.f1443s != null) {
                this.f1443s.destroy();
                this.f1443s.setMapCallback(null);
                this.f1443s = null;
            }
            if (this.f1446v != null) {
                this.f1446v.recycle();
                this.f1446v = null;
            }
            this.f1425a.m2441a();
            this.f1425a = new am(this);
            if (l == null) {
                this.f1425a.m2443a(C0338k.m2879a(l));
            } else {
                this.f1425a.m2443a(C0338k.m2882a(new LatLng(39.924216d, 116.3978653d), 10.0f, 0.0f, 0.0f));
            }
            this.f1443s = new MapCore(this.f1444t);
            this.f1443s.setMapCallback(this.f1445u);
            this.f1446v = this.f1443s.getMapstate();
            this.f1445u.onResume();
            this.aJ = false;
            m2145b(gl10);
            m2139a(gl10, this.f1423Y.width(), this.f1423Y.height());
            this.ap = Boolean.valueOf(false);
        }
        l = null;
        m2118T();
        this.ap = Boolean.valueOf(true);
        if (this.f1443s != null) {
            this.f1443s.destroy();
            this.f1443s.setMapCallback(null);
            this.f1443s = null;
        }
        if (this.f1446v != null) {
            this.f1446v.recycle();
            this.f1446v = null;
        }
        this.f1425a.m2441a();
        this.f1425a = new am(this);
        if (l == null) {
            this.f1425a.m2443a(C0338k.m2882a(new LatLng(39.924216d, 116.3978653d), 10.0f, 0.0f, 0.0f));
        } else {
            this.f1425a.m2443a(C0338k.m2879a(l));
        }
        this.f1443s = new MapCore(this.f1444t);
        this.f1443s.setMapCallback(this.f1445u);
        this.f1446v = this.f1443s.getMapstate();
        this.f1445u.onResume();
        this.aJ = false;
        m2145b(gl10);
        m2139a(gl10, this.f1423Y.width(), this.f1423Y.height());
        this.ap = Boolean.valueOf(false);
    }
}
