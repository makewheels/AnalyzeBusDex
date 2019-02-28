package com.amap.api.p015a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.amap.api.maps2d.AMap.CancelableCallback;
import com.amap.api.maps2d.AMap.InfoWindowAdapter;
import com.amap.api.maps2d.AMap.OnCameraChangeListener;
import com.amap.api.maps2d.AMap.OnInfoWindowClickListener;
import com.amap.api.maps2d.AMap.OnMapClickListener;
import com.amap.api.maps2d.AMap.OnMapLoadedListener;
import com.amap.api.maps2d.AMap.OnMapLongClickListener;
import com.amap.api.maps2d.AMap.OnMapScreenShotListener;
import com.amap.api.maps2d.AMap.OnMarkerClickListener;
import com.amap.api.maps2d.AMap.OnMarkerDragListener;
import com.amap.api.maps2d.AMap.OnMyLocationChangeListener;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import com.amap.api.p015a.C0260s.C0220a;
import com.amap.api.p015a.C0262t.C0261a;
import com.amap.api.p015a.C0263u.C0221a;
import com.amap.api.p015a.az.C0213a;
import com.amap.api.p015a.bg.C0218b;
import com.amap.api.p015a.bp.C0219a;
import com.amap.api.p015a.p016a.C0171a;
import com.amap.api.p015a.p016a.C0204q;
import com.autonavi.amap.mapcore.VTMCDataCache;
import com.autonavi.amap.mapcore2d.DPoint;
import com.autonavi.amap.mapcore2d.FPoint;
import com.autonavi.amap.mapcore2d.IPoint;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p054u.aly.bi_常量类;

/* compiled from: AMapDelegateImpGLSurfaceView */
/* renamed from: com.amap.api.a.b */
public class C0222b extends View implements OnDoubleTapListener, OnGestureListener, af, C0218b, C0219a, C0220a, C0221a {
    /* renamed from: A */
    private bo f698A;
    /* renamed from: B */
    private LocationSource f699B;
    /* renamed from: C */
    private C0267w f700C;
    /* renamed from: D */
    private C0205a f701D;
    /* renamed from: E */
    private boolean f702E;
    /* renamed from: F */
    private boolean f703F;
    /* renamed from: G */
    private OnCameraChangeListener f704G;
    /* renamed from: H */
    private C0259r f705H;
    /* renamed from: I */
    private CancelableCallback f706I;
    /* renamed from: J */
    private boolean f707J;
    /* renamed from: K */
    private ba f708K;
    /* renamed from: L */
    private boolean f709L;
    /* renamed from: M */
    private boolean f710M;
    /* renamed from: N */
    private View f711N;
    /* renamed from: O */
    private OnInfoWindowClickListener f712O;
    /* renamed from: P */
    private InfoWindowAdapter f713P;
    /* renamed from: Q */
    private be f714Q;
    /* renamed from: R */
    private OnMarkerClickListener f715R;
    /* renamed from: S */
    private Drawable f716S;
    /* renamed from: T */
    private an f717T;
    /* renamed from: U */
    private boolean f718U;
    /* renamed from: V */
    private boolean f719V;
    /* renamed from: W */
    private boolean f720W;
    /* renamed from: Z */
    private Marker f721Z;
    /* renamed from: a */
    public av f722a;
    private final long aA;
    private int aB;
    private boolean aC;
    private C0216a aD;
    private Thread aE;
    private boolean aa;
    private OnMarkerDragListener ab;
    private OnMapLongClickListener ac;
    private OnMapLoadedListener ad;
    private OnMapClickListener ae;
    private boolean af;
    private C0272z ag;
    private OnMapScreenShotListener ah;
    private Point ai;
    private GestureDetector aj;
    private bg ak;
    private boolean al;
    private ArrayList<OnGestureListener> am;
    private ArrayList<C0218b> an;
    private Scroller ao;
    private int ap;
    private int aq;
    private float ar;
    private boolean as;
    private float at;
    private float au;
    private int av;
    private int aw;
    private long ax;
    private int ay;
    private int az;
    /* renamed from: b */
    int[] f723b;
    /* renamed from: c */
    boolean f724c;
    /* renamed from: d */
    ax f725d;
    /* renamed from: e */
    cg f726e;
    /* renamed from: f */
    public az f727f;
    /* renamed from: g */
    protected aq f728g;
    /* renamed from: h */
    public bv f729h;
    /* renamed from: i */
    public ay f730i;
    /* renamed from: j */
    final Handler f731j;
    /* renamed from: k */
    protected Matrix f732k;
    /* renamed from: l */
    private Context f733l;
    /* renamed from: m */
    private bf f734m;
    /* renamed from: n */
    private boolean f735n;
    /* renamed from: o */
    private boolean f736o;
    /* renamed from: p */
    private aj f737p;
    /* renamed from: q */
    private final int[] f738q;
    /* renamed from: r */
    private boolean f739r;
    /* renamed from: s */
    private int f740s;
    /* renamed from: t */
    private au f741t;
    /* renamed from: u */
    private Location f742u;
    /* renamed from: v */
    private C0244e f743v;
    /* renamed from: w */
    private OnMyLocationChangeListener f744w;
    /* renamed from: x */
    private boolean f745x;
    /* renamed from: y */
    private bh f746y;
    /* renamed from: z */
    private cf f747z;

    /* compiled from: AMapDelegateImpGLSurfaceView */
    /* renamed from: com.amap.api.a.b$1 */
    class C02141 extends cd {
        /* renamed from: a */
        final /* synthetic */ C0222b f692a;

        C02141(C0222b c0222b) {
            this.f692a = c0222b;
        }

        /* renamed from: a */
        public String mo74a(int i, int i2, int i3) {
            return bd.m1300a().m1303d() + "/appmaptile?z=" + i3 + "&x=" + i + "&y=" + i2 + "&lang=zh_cn&size=1&scale=1&style=6";
        }
    }

    /* compiled from: AMapDelegateImpGLSurfaceView */
    /* renamed from: com.amap.api.a.b$2 */
    class C02152 extends cd {
        /* renamed from: a */
        final /* synthetic */ C0222b f693a;

        C02152(C0222b c0222b) {
            this.f693a = c0222b;
        }

        /* renamed from: a */
        public String mo74a(int i, int i2, int i3) {
            return bd.m1300a().m1302c() + "/trafficengine/mapabc/traffictile?v=w2.61&zoom=" + (17 - i3) + "&x=" + i + "&y=" + i2;
        }
    }

    /* compiled from: AMapDelegateImpGLSurfaceView */
    /* renamed from: com.amap.api.a.b$a */
    public static abstract class C0216a {
        /* renamed from: a */
        public abstract void m1137a(int i, int i2, int i3, int i4);
    }

    /* compiled from: AMapDelegateImpGLSurfaceView */
    /* renamed from: com.amap.api.a.b$b */
    public enum C0217b {
        DRAW_RETICLE_NEVER,
        DRAW_RETICLE_OVER,
        DRAW_RETICLE_UNDER
    }

    /* renamed from: a */
    public bf mo84a() {
        return this.f734m;
    }

    /* renamed from: a */
    public void mo91a(aa aaVar) {
        this.ag.m1737a(aaVar);
    }

    /* renamed from: b */
    public ba mo113b() {
        return this.f708K;
    }

    /* renamed from: c */
    public int mo121c() {
        return this.f734m.f837b.m1391c();
    }

    /* renamed from: d */
    public int mo125d() {
        return this.f734m.f837b.m1393d();
    }

    /* renamed from: e */
    public View mo128e() throws RemoteException {
        return this.f727f;
    }

    /* renamed from: a */
    public void mo107a(boolean z) throws RemoteException {
    }

    /* renamed from: a */
    public void mo90a(Location location) {
        if (location != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            try {
                if (!mo140n() || this.f699B == null) {
                    this.f746y.m1421a();
                    this.f746y = null;
                    return;
                }
                if (this.f746y == null || this.f742u == null) {
                    if (this.f746y == null) {
                        this.f746y = new bh(this);
                    }
                    if (latLng != null) {
                        mo92a(C0262t.m1692a(latLng, (float) this.f734m.f837b.m1394e()));
                    }
                }
                this.f746y.m1423a(latLng, (double) location.getAccuracy());
                if (!(this.f744w == null || (this.f742u != null && this.f742u.getBearing() == location.getBearing() && this.f742u.getAccuracy() == location.getAccuracy() && this.f742u.getLatitude() == location.getLatitude() && this.f742u.getLongitude() == location.getLongitude()))) {
                    this.f744w.onMyLocationChange(location);
                }
                this.f742u = new Location(location);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean mo112a(String str) throws RemoteException {
        return this.f734m.f841f.m820b(str);
    }

    /* renamed from: b */
    public boolean mo120b(String str) {
        aj a;
        try {
            a = this.f730i.m1112a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            a = null;
        }
        if (a != null) {
            return this.f730i.m1119b(a);
        }
        return false;
    }

    /* renamed from: a */
    public int m1192a(int i) {
        if (i < this.f734m.f837b.m1388b()) {
            i = this.f734m.f837b.m1388b();
        }
        if (i > this.f734m.f837b.m1382a()) {
            return this.f734m.f837b.m1382a();
        }
        return i;
    }

    /* renamed from: f */
    public float mo130f() {
        return (float) this.f734m.f837b.m1394e();
    }

    /* renamed from: g */
    public CameraPosition mo132g() throws RemoteException {
        LatLng N = m1186N();
        return CameraPosition.builder().target(N).zoom(mo130f()).build();
    }

    /* renamed from: h */
    public float mo134h() {
        return (float) this.f734m.f837b.m1382a();
    }

    /* renamed from: i */
    public float mo135i() {
        return (float) this.f734m.f837b.m1388b();
    }

    /* renamed from: a */
    public void mo92a(C0262t c0262t) throws RemoteException {
        this.f701D.m812a(c0262t);
    }

    /* renamed from: b */
    public void mo117b(C0262t c0262t) throws RemoteException {
        mo94a(c0262t, null);
    }

    /* renamed from: a */
    public void mo94a(C0262t c0262t, CancelableCallback cancelableCallback) throws RemoteException {
        mo93a(c0262t, 250, cancelableCallback);
    }

    /* renamed from: a */
    public void mo93a(C0262t c0262t, long j, CancelableCallback cancelableCallback) throws RemoteException {
        if (c0262t.f1137a == C0261a.newLatLngBounds) {
            boolean z = getWidth() > 0 && getHeight() > 0;
            C0171a.m622a(z, (Object) "the map must have a size");
        }
        if (!this.f705H.m1674a()) {
            this.f705H.m1673a(true);
            if (this.f706I != null) {
                this.f706I.onCancel();
            }
        }
        this.f706I = cancelableCallback;
        if (this.f702E) {
            this.f703F = true;
        }
        this.f707J = false;
        if (c0262t.f1137a == C0261a.scrollBy) {
            m1183K();
            if (this.f734m != null && this.f735n) {
                this.f722a.m1090c((int) c0262t.f1138b, (int) c0262t.f1139c);
                postInvalidate();
            }
        } else if (c0262t.f1137a == C0261a.zoomIn) {
            m1176D().m1091c();
        } else if (c0262t.f1137a == C0261a.zoomOut) {
            m1176D().m1092d();
        } else if (c0262t.f1137a == C0261a.zoomTo) {
            m1176D().m1089c((int) c0262t.f1140d);
        } else if (c0262t.f1137a == C0261a.zoomBy) {
            m1203a(c0262t.f1141e, c0262t.f1149m, true);
        } else if (c0262t.f1137a == C0261a.newCameraPosition) {
            r0 = c0262t.f1144h;
            m1176D().m1089c((int) r0.zoom);
            m1176D().m1084a(new ac((int) (r0.target.latitude * 1000000.0d), (int) (r0.target.longitude * 1000000.0d)), (int) j);
        } else if (c0262t.f1137a == C0261a.changeCenter) {
            r0 = c0262t.f1144h;
            m1176D().m1084a(new ac((int) (r0.target.latitude * 1000000.0d), (int) (r0.target.longitude * 1000000.0d)), (int) j);
        } else if (c0262t.f1137a == C0261a.newLatLngBounds || c0262t.f1137a == C0261a.newLatLngBoundsWithSize) {
            m1183K();
            m1249c(c0262t);
        } else {
            c0262t.f1151o = true;
            this.f725d.m1108a(c0262t);
        }
    }

    /* renamed from: a */
    public void m1203a(float f, Point point, boolean z) {
        float e = (float) this.f734m.f837b.m1394e();
        if (C0204q.m807b(e + f) - e != 0.0f) {
            IPoint iPoint = new IPoint();
            IPoint Y = m1152Y();
            if (point != null) {
                iPoint = new IPoint();
                m1205a(point.x, point.y, iPoint);
                int i = Y.f3652x - iPoint.f3652x;
                int i2 = Y.f3653y - iPoint.f3653y;
                i2 = (int) ((((double) i2) / Math.pow(2.0d, (double) f)) - ((double) i2));
                Y.f3652x = ((int) ((((double) i) / Math.pow(2.0d, (double) f)) - ((double) i))) + iPoint.f3652x;
                Y.f3653y = iPoint.f3653y + i2;
                ac b = this.f734m.f843h.m1295b(new ac((double) Y.f3653y, (double) Y.f3652x, false));
                if (z) {
                    m1176D().m1084a(b, 1000);
                } else {
                    m1176D().m1083a(b);
                }
            }
        }
    }

    /* renamed from: j */
    public void mo136j() throws RemoteException {
        if (!this.f705H.m1674a()) {
            this.f705H.m1673a(true);
            C0260s.m1682a().m1684b();
            if (this.f706I != null) {
                this.f706I.onCancel();
            }
            this.f706I = null;
        }
        m1176D().m1085a(true);
    }

    /* renamed from: a */
    public am mo83a(PolylineOptions polylineOptions) throws RemoteException {
        ak bkVar = new bk(this);
        bkVar.mo194a(polylineOptions.getColor());
        bkVar.mo197b(polylineOptions.isDottedLine());
        bkVar.mo198c(polylineOptions.isGeodesic());
        bkVar.mo195a(polylineOptions.getPoints());
        bkVar.mo42a(polylineOptions.isVisible());
        bkVar.mo196b(polylineOptions.getWidth());
        bkVar.mo36a(polylineOptions.getZIndex());
        mo84a().f841f.m818a(bkVar);
        invalidate();
        return bkVar;
    }

    /* renamed from: a */
    public ag mo80a(CircleOptions circleOptions) throws RemoteException {
        ak c0264v = new C0264v(this);
        c0264v.mo261b(circleOptions.getFillColor());
        c0264v.mo259a(circleOptions.getCenter());
        c0264v.mo42a(circleOptions.isVisible());
        c0264v.mo260b(circleOptions.getStrokeWidth());
        c0264v.mo36a(circleOptions.getZIndex());
        c0264v.mo258a(circleOptions.getStrokeColor());
        c0264v.mo257a(circleOptions.getRadius());
        this.f734m.f841f.m818a(c0264v);
        invalidate();
        return c0264v;
    }

    /* renamed from: a */
    public ah mo81a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        ak aeVar = new ae(this);
        aeVar.m870b(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        aeVar.mo48c(groundOverlayOptions.getBearing());
        aeVar.mo37a(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        aeVar.mo39a(groundOverlayOptions.getImage());
        aeVar.mo40a(groundOverlayOptions.getLocation());
        aeVar.mo41a(groundOverlayOptions.getBounds());
        aeVar.mo50d(groundOverlayOptions.getTransparency());
        aeVar.mo42a(groundOverlayOptions.isVisible());
        aeVar.mo36a(groundOverlayOptions.getZIndex());
        this.f734m.f841f.m818a(aeVar);
        invalidate();
        return aeVar;
    }

    /* renamed from: a */
    public al mo82a(PolygonOptions polygonOptions) throws RemoteException {
        ak bjVar = new bj(this);
        bjVar.mo185a(polygonOptions.getFillColor());
        bjVar.mo186a(polygonOptions.getPoints());
        bjVar.mo42a(polygonOptions.isVisible());
        bjVar.mo188b(polygonOptions.getStrokeWidth());
        bjVar.mo36a(polygonOptions.getZIndex());
        bjVar.mo189b(polygonOptions.getStrokeColor());
        this.f734m.f841f.m818a(bjVar);
        invalidate();
        return bjVar;
    }

    /* renamed from: a */
    public Marker mo85a(MarkerOptions markerOptions) throws RemoteException {
        aj beVar = new be(markerOptions, this.f730i);
        this.f730i.m1115a(beVar);
        invalidate();
        return new Marker(beVar);
    }

    /* renamed from: b */
    public be mo114b(MarkerOptions markerOptions) throws RemoteException {
        aj beVar = new be(markerOptions, this.f730i);
        this.f730i.m1115a(beVar);
        invalidate();
        return beVar;
    }

    /* renamed from: a */
    public TileOverlay mo86a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        ap buVar = new bu(tileOverlayOptions, this.f729h);
        this.f729h.m1538a(buVar);
        invalidate();
        return new TileOverlay(buVar);
    }

    /* renamed from: k */
    public void mo137k() throws RemoteException {
        try {
            m1276t();
            this.f734m.f841f.m816a();
            this.f730i.m1120c();
            this.f746y.m1421a();
            invalidate();
        } catch (Exception e) {
            Log.d("amapApi", "AMapDelegateImpGLSurfaceView clear erro" + e.getMessage());
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    public int mo138l() throws RemoteException {
        return 0;
    }

    /* renamed from: b */
    public void mo116b(int i) throws RemoteException {
        if (i == 2) {
            m1263h(true);
            this.f747z.m1617a(true);
        } else {
            m1263h(false);
            this.f747z.m1617a(false);
        }
        postInvalidate();
    }

    /* renamed from: m */
    public boolean mo139m() throws RemoteException {
        return m1178F();
    }

    /* renamed from: b */
    public void mo118b(boolean z) throws RemoteException {
        m1265i(z);
        postInvalidate();
    }

    /* renamed from: n */
    public boolean mo140n() throws RemoteException {
        return this.f745x;
    }

    /* renamed from: c */
    public void mo123c(boolean z) throws RemoteException {
        if (this.f699B == null) {
            this.f741t.m1062a(false);
        } else if (z) {
            this.f699B.activate(this.f743v);
            this.f741t.m1062a(true);
            if (this.f746y == null) {
                this.f746y = new bh(this);
            }
        } else {
            if (this.f746y != null) {
                this.f746y.m1421a();
                this.f746y = null;
            }
            this.f742u = null;
            this.f699B.deactivate();
            this.f741t.m1062a(false);
        }
        if (z) {
            this.f741t.setVisibility(0);
        } else {
            this.f741t.setVisibility(8);
        }
        this.f745x = z;
    }

    /* renamed from: a */
    public void mo88a(float f) throws RemoteException {
        if (this.f746y != null) {
            this.f746y.m1422a(f);
        }
    }

    /* renamed from: a */
    public void mo106a(MyLocationStyle myLocationStyle) throws RemoteException {
        if (m1271o() != null) {
            m1271o().m1424a(myLocationStyle);
        }
    }

    /* renamed from: o */
    public bh m1271o() {
        return this.f746y;
    }

    /* renamed from: p */
    public Location mo141p() throws RemoteException {
        if (this.f699B != null) {
            return this.f743v.f1031a;
        }
        return null;
    }

    /* renamed from: a */
    public void mo105a(LocationSource locationSource) throws RemoteException {
        this.f699B = locationSource;
        if (locationSource != null) {
            this.f741t.m1062a(true);
        } else {
            this.f741t.m1062a(false);
        }
    }

    /* renamed from: q */
    public aq mo142q() throws RemoteException {
        return this.f728g;
    }

    /* renamed from: r */
    public an mo143r() {
        return this.f717T;
    }

    /* renamed from: s */
    public bl mo144s() {
        return this.f734m.f836a;
    }

    /* renamed from: a */
    public void mo98a(OnMapClickListener onMapClickListener) throws RemoteException {
        this.ae = onMapClickListener;
    }

    /* renamed from: a */
    public void mo100a(OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        this.ac = onMapLongClickListener;
    }

    /* renamed from: a */
    public void mo102a(OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        this.f715R = onMarkerClickListener;
    }

    /* renamed from: a */
    public void mo103a(OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        this.ab = onMarkerDragListener;
    }

    /* renamed from: a */
    public void mo99a(OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        this.ad = onMapLoadedListener;
    }

    /* renamed from: a */
    public void mo97a(OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        this.f712O = onInfoWindowClickListener;
    }

    /* renamed from: a */
    public void mo95a(InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        this.f713P = infoWindowAdapter;
    }

    /* renamed from: a */
    public void m1210a(aj ajVar) throws RemoteException {
        int i = -2;
        if (ajVar != null) {
            if ((ajVar.mo169g() != null || ajVar.mo170h() != null) && this.f713P != null) {
                int i2;
                m1276t();
                Marker marker = new Marker(ajVar);
                this.f711N = this.f713P.getInfoWindow(marker);
                try {
                    if (this.f716S == null) {
                        this.f716S = bi_常量类.m1427a(this.f733l, "infowindow_bg.9.png");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f711N == null) {
                    this.f711N = this.f713P.getInfoContents(marker);
                }
                if (this.f711N == null) {
                    View linearLayout = new LinearLayout(this.f733l);
                    linearLayout.setBackgroundDrawable(this.f716S);
                    View textView = new TextView(this.f733l);
                    textView.setText(ajVar.mo169g());
                    textView.setTextColor(-16777216);
                    View textView2 = new TextView(this.f733l);
                    textView2.setTextColor(-16777216);
                    textView2.setText(ajVar.mo170h());
                    linearLayout.setOrientation(1);
                    linearLayout.addView(textView);
                    linearLayout.addView(textView2);
                    this.f711N = linearLayout;
                } else if (this.f711N.getBackground() == null) {
                    this.f711N.setBackgroundDrawable(this.f716S);
                }
                LayoutParams layoutParams = this.f711N.getLayoutParams();
                this.f711N.setDrawingCacheEnabled(true);
                this.f711N.setDrawingCacheQuality(0);
                FPoint f = ajVar.mo168f();
                if (layoutParams != null) {
                    i2 = layoutParams.width;
                    i = layoutParams.height;
                } else {
                    i2 = -2;
                }
                layoutParams = new C0213a(i2, i, ajVar.mo166d(), (-((int) f.f3650x)) + (ajVar.mo179q() / 2), (-((int) f.f3651y)) + 2, 81);
                this.f714Q = (be) ajVar;
                this.f727f.addView(this.f711N, layoutParams);
            }
        }
    }

    /* renamed from: b */
    public boolean m1244b(aj ajVar) {
        if (this.f714Q == null || this.f711N == null) {
            return false;
        }
        return this.f714Q.mo167e().equals(ajVar.mo167e());
    }

    /* renamed from: t */
    public void m1276t() {
        if (this.f711N != null) {
            this.f711N.clearFocus();
            this.f727f.removeView(this.f711N);
            Drawable background = this.f711N.getBackground();
            if (background != null) {
                background.setCallback(null);
            }
            this.f711N = null;
        }
        this.f714Q = null;
    }

    /* renamed from: u */
    public void m1277u() {
        if (this.f711N != null && this.f714Q != null) {
            C0213a c0213a = (C0213a) this.f711N.getLayoutParams();
            if (c0213a != null) {
                c0213a.f687b = this.f714Q.mo166d();
            }
            this.f727f.m1133a();
        }
    }

    /* renamed from: a */
    public void mo104a(OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        this.f744w = onMyLocationChangeListener;
    }

    /* renamed from: d */
    public void mo127d(boolean z) {
        if (z) {
            this.f726e.setVisibility(0);
        } else {
            this.f726e.setVisibility(8);
        }
    }

    /* renamed from: e */
    public void mo129e(boolean z) {
        if (z) {
            this.f741t.setVisibility(0);
        } else {
            this.f741t.setVisibility(8);
        }
    }

    /* renamed from: f */
    public void mo131f(boolean z) {
        if (z) {
            this.f700C.setVisibility(0);
        } else {
            this.f700C.setVisibility(8);
        }
    }

    /* renamed from: g */
    public void mo133g(boolean z) {
        if (z) {
            this.f698A.setVisibility(0);
            m1184L();
            return;
        }
        this.f698A.m1497a(bi_常量类.f6358b);
        this.f698A.m1496a(0);
        this.f698A.setVisibility(8);
    }

    /* renamed from: v */
    public void mo145v() {
        try {
            C0263u.m1701a().m1704b(this);
            bp.m1498a().m1501b(this);
            C0260s.m1682a().m1685b(this);
            this.f726e.m1630a();
            this.f698A.m1495a();
            this.f747z.m1615a();
            this.f741t.m1061a();
            this.f700C.m1728a();
            this.f734m.f841f.m819b();
            this.f730i.m1124e();
            if (C0248k.f1038d != null) {
                C0248k.f1038d.disconnect();
            }
            if (this.f716S != null) {
                this.f716S.setCallback(null);
            }
            this.f727f.removeAllViews();
            m1276t();
            if (this.f734m != null) {
                this.f734m.f838c.m1373a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo101a(OnMapScreenShotListener onMapScreenShotListener) {
        this.ah = onMapScreenShotListener;
        this.f718U = true;
    }

    /* renamed from: c */
    public void mo122c(int i) {
        if (this.f747z != null) {
            this.f747z.m1616a(i);
            this.f747z.invalidate();
            if (this.f698A.getVisibility() == 0) {
                this.f698A.invalidate();
            }
        }
    }

    /* renamed from: d */
    public void mo126d(int i) {
        if (this.f726e != null) {
            this.f726e.m1632a(i);
            this.f726e.invalidate();
        }
    }

    /* renamed from: w */
    public float mo146w() {
        int width = getWidth();
        DPoint dPoint = new DPoint();
        DPoint dPoint2 = new DPoint();
        mo89a(0, 0, dPoint);
        mo89a(width, 0, dPoint2);
        return (float) (C0204q.m791a(new LatLng(dPoint.f3649y, dPoint.f3648x), new LatLng(dPoint2.f3649y, dPoint2.f3648x)) / ((double) width));
    }

    /* renamed from: x */
    public LatLngBounds m1280x() {
        return null;
    }

    /* renamed from: y */
    public void mo147y() {
        if (this.f734m != null) {
            this.f734m.f838c.m1374b();
        }
    }

    /* renamed from: z */
    public void mo148z() {
        if (this.f734m != null) {
            this.f734m.f838c.m1375c();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f734m != null) {
            this.f734m.f837b.m1397h();
        }
    }

    /* renamed from: T */
    private void m1147T() {
        for (Method method : View.class.getMethods()) {
            if (method.getName().equals("setLayerType")) {
                break;
            }
        }
        Method method2 = null;
        if (method2 != null) {
            try {
                Field field = View.class.getField("LAYER_TYPE_SOFTWARE");
                method2.invoke(this, new Object[]{Integer.valueOf(field.getInt(null)), null});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: A */
    Point m1173A() {
        return this.f747z.m1619c();
    }

    public C0222b(Context context) {
        super(context);
        this.f735n = false;
        this.f736o = true;
        this.f738q = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, 10000, 5000, 2000, 1000, VTMCDataCache.MAXSIZE, 200, 100, 50, 25, 10, 5};
        this.f739r = true;
        this.f723b = new int[2];
        this.f724c = false;
        this.f740s = 0;
        this.f725d = new ax(this);
        this.f745x = true;
        this.f701D = null;
        this.f702E = false;
        this.f703F = false;
        this.f706I = null;
        this.f707J = false;
        this.f709L = false;
        this.f710M = false;
        this.f716S = null;
        this.f718U = false;
        this.f719V = false;
        this.f720W = false;
        this.f721Z = null;
        this.aa = false;
        this.af = false;
        this.f731j = new C0238c(this);
        this.ag = new C0272z();
        this.ah = null;
        this.al = false;
        this.am = new ArrayList();
        this.an = new ArrayList();
        this.ap = 0;
        this.aq = 0;
        this.f732k = new Matrix();
        this.ar = 1.0f;
        this.as = false;
        this.ax = 0;
        this.ay = 0;
        this.az = 0;
        this.aA = 300;
        this.aB = 0;
        this.aC = false;
        this.aD = null;
        this.aE = new C0243d(this);
        m1147T();
        setClickable(true);
        m1207a(context, null);
    }

    public C0222b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m1207a(context, attributeSet);
    }

    public C0222b(Context context, AttributeSet attributeSet, int i) {
        String str = null;
        super(context, attributeSet, i);
        this.f735n = false;
        this.f736o = true;
        this.f738q = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, 10000, 5000, 2000, 1000, VTMCDataCache.MAXSIZE, 200, 100, 50, 25, 10, 5};
        this.f739r = true;
        this.f723b = new int[2];
        this.f724c = false;
        this.f740s = 0;
        this.f725d = new ax(this);
        this.f745x = true;
        this.f701D = str;
        this.f702E = false;
        this.f703F = false;
        this.f706I = str;
        this.f707J = false;
        this.f709L = false;
        this.f710M = false;
        this.f716S = str;
        this.f718U = false;
        this.f719V = false;
        this.f720W = false;
        this.f721Z = str;
        this.aa = false;
        this.af = false;
        this.f731j = new C0238c(this);
        this.ag = new C0272z();
        this.ah = str;
        this.al = false;
        this.am = new ArrayList();
        this.an = new ArrayList();
        this.ap = 0;
        this.aq = 0;
        this.f732k = new Matrix();
        this.ar = 1.0f;
        this.as = false;
        this.ax = 0;
        this.ay = 0;
        this.az = 0;
        this.aA = 300;
        this.aB = 0;
        this.aC = false;
        this.aD = str;
        this.aE = new C0243d(this);
        m1147T();
        this.f733l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843281});
        if (str == null || str.length() < 15) {
            obtainStyledAttributes.getString(0);
        }
        m1207a(context, attributeSet);
    }

    /* renamed from: a */
    void m1207a(Context context, AttributeSet attributeSet) {
        this.f733l = context;
        this.f717T = new bm(this);
        setBackgroundColor(Color.rgb(222, ErrorCode.COPY_EXCEPTION, ErrorCode.COPY_TMPDIR_ERROR));
        C0263u.m1701a().m1702a(this);
        bp.m1498a().m1499a(this);
        C0260s.m1682a().m1683a(this);
        this.f701D = new C0205a(this);
        this.f743v = new C0244e(this);
        this.f705H = new C0259r(context);
        this.f729h = new bv(this.f733l, this);
        this.f734m = new bf(this.f733l, this);
        this.f729h.m1539a(true);
        this.f708K = this.f734m.f843h;
        this.f722a = new av(this.f734m);
        this.f728g = new cb(this);
        this.f730i = new ay(this.f733l, attributeSet, this);
        this.f726e = new cg(this.f733l, this.f722a, this);
        this.f727f = new az(this.f733l, this);
        this.f741t = new au(this.f733l, this.f725d, this);
        this.f747z = new cf(this.f733l, this);
        this.f698A = new bo(this.f733l, this);
        this.f700C = new C0267w(this.f733l, this.f725d, this);
        this.f730i = new ay(this.f733l, attributeSet, this);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        m1148U();
        this.f727f.addView(this.f729h, layoutParams);
        this.f727f.addView(this.f747z, layoutParams);
        this.f727f.addView(this.f698A, layoutParams);
        this.f727f.addView(this.f730i, new C0213a(layoutParams));
        this.f727f.addView(this.f726e, new C0213a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 83));
        this.f727f.addView(this.f741t, new C0213a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 83));
        try {
            if (!mo142q().mo247d()) {
                this.f741t.setVisibility(8);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.f700C.setVisibility(8);
        this.f727f.addView(this.f700C, new C0213a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 51));
        this.f746y = new bh(this);
        this.f726e.setId(C0249l.f1040a);
        try {
            this.aE.setName("AuthThread");
            this.aE.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: B */
    public boolean m1174B() {
        return this.f736o;
    }

    /* renamed from: e */
    void m1256e(int i) {
        this.f740s = i;
    }

    /* renamed from: C */
    public ac m1175C() {
        return this.f734m.f837b.m1395f();
    }

    /* renamed from: D */
    public av m1176D() {
        return this.f722a;
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    /* renamed from: U */
    private void m1148U() {
        m1206a(this.f733l);
        this.f727f.addView(this, 0, new LayoutParams(-1, -1));
    }

    /* renamed from: h */
    public void m1263h(boolean z) {
        if (m1177E() != z) {
            boolean F = m1178F();
            m1265i(false);
            if (!z) {
                mo84a().f839d.m1369a(mo84a().f839d.f811e, false);
                mo84a().f839d.m1369a(mo84a().f839d.f810d, true);
                if (F) {
                    m1265i(true);
                }
                mo84a().f837b.m1387a(false, false);
            } else if (mo84a().f839d.m1362a(mo84a().f839d.f811e) != null) {
                mo84a().f839d.m1369a(mo84a().f839d.f811e, true);
                if (F) {
                    m1265i(true);
                }
                mo84a().f837b.m1387a(false, false);
            } else {
                as asVar = new as();
                asVar.f645j = new C02141(this);
                asVar.f636a = mo84a().f839d.f811e;
                asVar.f640e = true;
                asVar.f639d = true;
                asVar.f641f = true;
                asVar.f642g = true;
                asVar.f637b = C0269x.f1182c;
                asVar.f638c = C0269x.f1183d;
                mo84a().f839d.m1368a(asVar, getContext());
                mo84a().f839d.m1369a(mo84a().f839d.f811e, true);
                if (F) {
                    m1265i(true);
                }
                mo84a().f837b.m1387a(false, false);
            }
        }
    }

    /* renamed from: E */
    public boolean m1177E() {
        as a = mo84a().f839d.m1362a(mo84a().f839d.f811e);
        if (a != null) {
            return a.f641f;
        }
        return false;
    }

    /* renamed from: i */
    public void m1265i(boolean z) {
        if (z != m1178F()) {
            boolean E = m1177E();
            String str = bi_常量类.f6358b;
            if (!E) {
                str = mo84a().f839d.f812f;
                if (!z) {
                    mo84a().f839d.m1369a(str, false);
                    mo84a().f837b.m1387a(false, false);
                } else if (mo84a().f839d.m1362a(str) != null) {
                    mo84a().f839d.m1369a(str, true);
                    mo84a().f837b.m1387a(false, false);
                } else {
                    as asVar;
                    if (E) {
                        asVar = new as();
                        asVar.f643h = true;
                        asVar.f644i = 120000;
                        asVar.f636a = str;
                        asVar.f640e = false;
                        asVar.f639d = true;
                        asVar.f641f = true;
                        asVar.f642g = false;
                        asVar.f637b = 18;
                        asVar.f638c = 9;
                        mo84a().f839d.m1368a(asVar, getContext());
                    } else {
                        asVar = new as();
                        asVar.f643h = true;
                        asVar.f644i = 120000;
                        asVar.f645j = new C02152(this);
                        asVar.f636a = str;
                        asVar.f640e = false;
                        asVar.f639d = true;
                        asVar.f641f = true;
                        asVar.f642g = false;
                        asVar.f637b = 18;
                        asVar.f638c = 9;
                        mo84a().f839d.m1368a(asVar, getContext());
                    }
                    mo84a().f839d.m1369a(str, true);
                    mo84a().f837b.m1387a(false, false);
                }
            }
        }
    }

    /* renamed from: F */
    public boolean m1178F() {
        boolean E = m1177E();
        String str = bi_常量类.f6358b;
        if (E) {
            return false;
        }
        as a = mo84a().f839d.m1362a(mo84a().f839d.f812f);
        if (a != null) {
            return a.f641f;
        }
        return false;
    }

    /* renamed from: V */
    private void m1149V() {
        if (this.f709L) {
            this.f709L = false;
        }
        if (this.aa) {
            this.aa = false;
            C0262t a = C0262t.m1686a();
            a.f1151o = true;
            this.f725d.m1108a(a);
        }
        if (this.f710M) {
            this.f710M = false;
            a = C0262t.m1686a();
            a.f1151o = true;
            this.f725d.m1108a(a);
        }
        this.f719V = false;
        this.f720W = false;
        if (this.ab != null && this.f721Z != null) {
            this.ab.onMarkerDragEnd(this.f721Z);
            this.f721Z = null;
        }
    }

    /* renamed from: b */
    private void m1161b(MotionEvent motionEvent) {
        if (this.f720W && this.f721Z != null) {
            int x = (int) motionEvent.getX();
            int y = (int) (motionEvent.getY() - 60.0f);
            DPoint dPoint = new DPoint();
            mo89a(x, y, dPoint);
            LatLng latLng = new LatLng(dPoint.f3649y, dPoint.f3648x);
            if (this.ab != null && this.f737p != null && this.f737p.mo171i()) {
                this.f737p.mo162b(latLng);
                this.ab.onMarkerDrag(this.f721Z);
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void computeScroll() {
        if (this.ao.computeScrollOffset()) {
            int currX = this.ao.getCurrX() - this.ap;
            int currY = this.ao.getCurrY() - this.aq;
            this.ap = this.ao.getCurrX();
            this.aq = this.ao.getCurrY();
            ac a = this.f734m.f836a.mo183a(currX + this.f734m.f843h.f763l.x, currY + this.f734m.f843h.f763l.y);
            if (this.ao.isFinished()) {
                C0260s.m1682a().m1684b();
                if (this.f704G != null) {
                    m1227a(true, m1151X());
                }
                this.f734m.f837b.m1387a(false, false);
                return;
            }
            this.f734m.f837b.m1390b(a);
            return;
        }
        super.computeScroll();
    }

    public void setClickable(boolean z) {
        this.f735n = z;
        super.setClickable(z);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f734m == null) {
            return true;
        }
        if (!this.f735n) {
            return false;
        }
        if (this.f734m.f839d.m1366a(i, keyEvent) || this.f722a.onKey(this, i, keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f734m == null) {
            return true;
        }
        if (!this.f735n) {
            return false;
        }
        if (this.f734m.f839d.m1371b(i, keyEvent) || this.f722a.onKey(this, i, keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!C0269x.f1190k || this.f734m == null) {
            return true;
        }
        if (!this.f735n) {
            return false;
        }
        if (this.f734m.f839d.m1367a(motionEvent)) {
            return true;
        }
        m1232a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f734m.f843h.m1291a(new Point(i / 2, i2 / 2));
        this.f734m.f837b.m1384a(i, i2);
        if (!(this.f722a.m1079a() == 0 || this.f722a.m1086b() == 0)) {
            this.f722a.m1081a(this.f722a.m1079a(), this.f722a.m1086b());
            this.f722a.m1080a(0);
            this.f722a.m1087b(0);
        }
        if (this.aD != null) {
            this.aD.m1137a(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public void m1206a(Context context) {
        this.ai = null;
        this.aj = new GestureDetector(this);
        this.ak = bg.m1408a(context, this, this);
        this.ao = new Scroller(context);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        this.av = displayMetrics.widthPixels;
        this.aw = displayMetrics.heightPixels;
        this.ap = displayMetrics.widthPixels / 2;
        this.aq = displayMetrics.heightPixels / 2;
    }

    /* renamed from: G */
    public bg m1179G() {
        return this.ak;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f718U) {
            setDrawingCacheEnabled(true);
            buildDrawingCache();
            Bitmap drawingCache = getDrawingCache();
            Message message = new Message();
            message.what = 16;
            message.obj = drawingCache;
            this.f731j.sendMessage(message);
            this.f718U = false;
        }
        this.f734m.f837b.m1384a(getWidth(), getHeight());
        this.f734m.f839d.m1364a(canvas, this.f732k, this.at, this.au);
        if (!this.f705H.m1674a()) {
            this.f731j.sendEmptyMessage(13);
        }
        if (!this.af) {
            this.f731j.sendEmptyMessage(11);
            this.af = true;
        }
    }

    /* renamed from: b */
    public void m1238b(float f) {
        this.ar = f;
    }

    /* renamed from: H */
    public float m1180H() {
        return this.ar;
    }

    /* renamed from: I */
    public void m1181I() {
        this.at = 0.0f;
        this.au = 0.0f;
    }

    /* renamed from: W */
    private void m1150W() {
        if (this.ai != null) {
            int i = this.ai.x - this.ay;
            int i2 = this.ai.y - this.az;
            this.ai.x = this.ay;
            this.ai.y = this.az;
            this.f722a.m1090c(i, i2);
        }
    }

    /* renamed from: a */
    private void m1158a(int i, int i2) {
        if (this.ai != null) {
            this.ay = i;
            this.az = i2;
            m1150W();
        }
    }

    /* renamed from: a */
    public boolean m1232a(MotionEvent motionEvent) {
        boolean a = this.ak.mo184a(motionEvent);
        if (!a) {
            a = this.aj.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1 && this.aa) {
            C0260s.m1682a().m1684b();
        }
        if (motionEvent.getAction() == 2) {
            m1161b(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            m1149V();
        }
        return a;
    }

    /* renamed from: X */
    private CameraPosition m1151X() {
        return CameraPosition.fromLatLngZoom(new LatLng(((double) m1175C().m823b()) / 1000000.0d, ((double) m1175C().m821a()) / 1000000.0d), mo130f());
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.aa = false;
        if (!(this.aC || this.f705H.m1674a())) {
            this.f705H.m1673a(true);
            if (this.f706I != null) {
                this.f706I.onCancel();
            }
            this.f706I = null;
        }
        this.aC = false;
        this.aB = 0;
        if (this.ai == null) {
            this.ai = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        } else {
            this.ai.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onFling(android.view.MotionEvent r11, android.view.MotionEvent r12, float r13, float r14) {
        /*
        r10 = this;
        r9 = 1;
        r0 = r10.ak;
        r0 = r0.f859l;
        if (r0 != 0) goto L_0x0016;
    L_0x0007:
        r0 = r11.getEventTime();
        r2 = r10.ak;
        r2 = r2.f863p;
        r0 = r0 - r2;
        r2 = 30;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0017;
    L_0x0016:
        return r9;
    L_0x0017:
        r10.invalidate();
        r0 = 0;
        r10.aa = r0;
        r0 = r10.f728g;	 Catch:{ RemoteException -> 0x0048 }
        r0 = r0.mo249e();	 Catch:{ RemoteException -> 0x0048 }
        if (r0 == 0) goto L_0x0016;
    L_0x0025:
        r0 = 0;
        r10.f706I = r0;
        r0 = r10.ao;
        r1 = r10.ap;
        r2 = r10.aq;
        r3 = -r13;
        r3 = (int) r3;
        r3 = r3 * 3;
        r3 = r3 / 5;
        r4 = -r14;
        r4 = (int) r4;
        r4 = r4 * 3;
        r4 = r4 / 5;
        r5 = r10.av;
        r5 = -r5;
        r6 = r10.av;
        r7 = r10.aw;
        r7 = -r7;
        r8 = r10.aw;
        r0.fling(r1, r2, r3, r4, r5, r6, r7, r8);
        goto L_0x0016;
    L_0x0048:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.b.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.aa = false;
        if (this.ac != null) {
            DPoint dPoint = new DPoint();
            mo89a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
            this.ac.onMapLongClick(new LatLng(dPoint.f3649y, dPoint.f3648x));
            this.f709L = true;
        }
        this.f737p = this.f730i.m1111a(motionEvent);
        if (this.ab != null && this.f737p != null && this.f737p.mo171i()) {
            this.f721Z = new Marker(this.f737p);
            this.f737p.mo162b(m1156a(this.f737p.mo166d()));
            this.f730i.m1121c(this.f737p);
            this.ab.onMarkerDragStart(this.f721Z);
            this.f720W = true;
        }
    }

    /* renamed from: a */
    private LatLng m1156a(LatLng latLng) {
        IPoint iPoint = new IPoint();
        mo115b(latLng.latitude, latLng.longitude, iPoint);
        iPoint.f3653y -= 60;
        DPoint dPoint = new DPoint();
        mo89a(iPoint.f3652x, iPoint.f3653y, dPoint);
        return new LatLng(dPoint.f3649y, dPoint.f3648x);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.ak.f859l && motionEvent2.getEventTime() - this.ak.f863p >= 30) {
            try {
                if (!this.f728g.mo249e()) {
                    this.aa = false;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (this.aB > 1) {
                this.aa = false;
            } else {
                this.aa = true;
                m1158a((int) motionEvent2.getX(), (int) motionEvent2.getY());
                postInvalidate();
                m1183K();
            }
        }
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f734m.f839d.m1372b(motionEvent);
        Iterator it = this.am.iterator();
        while (it.hasNext()) {
            ((OnGestureListener) it.next()).onSingleTapUp(motionEvent);
        }
        this.aa = false;
        if (this.f709L) {
            this.f709L = false;
        } else {
            if (this.f711N != null) {
                if (this.f730i.m1116a(new Rect(this.f711N.getLeft(), this.f711N.getTop(), this.f711N.getRight(), this.f711N.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY()) && this.f712O != null) {
                    aj d = this.f730i.m1122d();
                    if (d.mo175m()) {
                        this.f712O.onInfoWindowClick(new Marker(d));
                    }
                }
            }
            try {
                if (this.f730i.m1118b(motionEvent)) {
                    aj d2 = this.f730i.m1122d();
                    if (d2 != null && d2.mo175m()) {
                        Marker marker = new Marker(d2);
                        if (this.f715R != null) {
                            if (this.f715R.onMarkerClick(marker) || this.f730i.m1117b() <= 0) {
                                this.f730i.m1121c(d2);
                            } else {
                                try {
                                    if (this.f730i.m1122d() != null) {
                                        m1210a(d2);
                                    }
                                    LatLng d3 = d2.mo166d();
                                    if (d3 != null) {
                                        m1176D().m1083a(C0204q.m798a(d3));
                                    }
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        this.f730i.m1121c(d2);
                    }
                } else if (this.ae != null) {
                    DPoint dPoint = new DPoint();
                    mo89a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
                    this.ae.onMapClick(new LatLng(dPoint.f3649y, dPoint.f3648x));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo108a(float f, float f2) {
        this.f722a.m1085a(true);
        if (this.as) {
            this.at += f;
            this.au += f2;
        }
        invalidate();
        return this.as;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public boolean mo124c(float r3) {
        /*
        r2 = this;
        r1 = 0;
        r0 = r2.f728g;	 Catch:{ RemoteException -> 0x000a }
        r0 = r0.mo251f();	 Catch:{ RemoteException -> 0x000a }
        if (r0 != 0) goto L_0x000e;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x000e:
        r2.m1238b(r3);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.b.c(float):boolean");
    }

    /* renamed from: a */
    public boolean mo110a(Matrix matrix) {
        return false;
    }

    /* renamed from: b */
    public boolean mo119b(Matrix matrix) {
        try {
            if (!this.f728g.mo251f()) {
                return false;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.f732k.set(matrix);
        postInvalidate();
        return true;
    }

    /* renamed from: a */
    public boolean mo109a(float f, PointF pointF) {
        this.f734m.f839d.f809c = false;
        m1157a(f, pointF, this.at, this.au);
        this.as = false;
        postInvalidateDelayed(8);
        this.f734m.m1407a(true);
        C0260s.m1682a().m1684b();
        return true;
    }

    /* renamed from: a */
    public boolean mo111a(PointF pointF) {
        try {
            if (!this.f728g.mo251f()) {
                return false;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.f734m.m1407a(this.f736o);
        this.f734m.f839d.m1365a(true);
        this.f734m.f839d.f809c = true;
        this.as = true;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onDoubleTap(android.view.MotionEvent r5) {
        /*
        r4 = this;
        r3 = 1;
        r0 = r4.f728g;	 Catch:{ RemoteException -> 0x000a }
        r0 = r0.mo251f();	 Catch:{ RemoteException -> 0x000a }
        if (r0 != 0) goto L_0x000e;
    L_0x0009:
        return r3;
    L_0x000a:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x000e:
        r0 = r4.f739r;
        if (r0 == 0) goto L_0x0021;
    L_0x0012:
        r0 = r4.f722a;
        r1 = r5.getX();
        r1 = (int) r1;
        r2 = r5.getY();
        r2 = (int) r2;
        r0.m1088b(r1, r2);
    L_0x0021:
        r0 = r4.aB;
        if (r0 > r3) goto L_0x0009;
    L_0x0025:
        r4.aC = r3;
        r0 = r4.f726e;
        r1 = r4.f734m;
        r1 = r1.f837b;
        r1 = r1.m1394e();
        r1 = r1 + 1;
        r1 = (float) r1;
        r0.m1631a(r1);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.b.onDoubleTap(android.view.MotionEvent):boolean");
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    /* renamed from: a */
    private void m1157a(float f, PointF pointF, float f2, float f3) {
        int floor;
        int i;
        try {
            if (!this.f728g.mo251f()) {
                return;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.aB = 2;
        int c = this.f734m.f837b.m1391c() / 2;
        int d = this.f734m.f837b.m1393d() / 2;
        if (f > 0.0f) {
            this.f726e.m1631a((float) (this.f734m.f837b.m1394e() + 1));
            m1184L();
            floor = (int) Math.floor((double) f);
            i = 1;
        } else if (f < 0.0f) {
            this.f726e.m1631a((float) (this.f734m.f837b.m1394e() - 1));
            m1184L();
            floor = (int) Math.floor((double) Math.abs(f));
            i = 0;
        } else {
            return;
        }
        floor = m1192a(i != 0 ? floor + this.f734m.f837b.m1394e() : this.f734m.f837b.m1394e() - floor);
        if (floor != this.f734m.f837b.m1394e()) {
            this.f723b[0] = this.f723b[1];
            this.f723b[1] = floor;
            if (this.f723b[0] != this.f723b[1]) {
                ac a = this.f734m.f836a.mo183a(c, d);
                this.f734m.f837b.m1383a(floor);
                this.f734m.f837b.m1385a(a);
            }
        }
    }

    /* renamed from: b */
    protected PointF m1234b(PointF pointF) {
        PointF pointF2 = new PointF();
        int width = getWidth();
        int height = getHeight();
        float f = pointF.x - ((float) (width >> 1));
        float f2 = pointF.y - ((float) (height >> 1));
        double atan2 = Math.atan2((double) f2, (double) f);
        double sqrt = Math.sqrt(Math.pow((double) f2, 2.0d) + Math.pow((double) f, 2.0d));
        atan2 -= (((double) m1182J()) * 3.141592653589793d) / 180.0d;
        pointF2.x = (float) ((Math.cos(atan2) * sqrt) + ((double) (width >> 1)));
        pointF2.y = (float) (((double) (height >> 1)) + (sqrt * Math.sin(atan2)));
        return pointF2;
    }

    /* renamed from: c */
    protected PointF m1247c(PointF pointF) {
        PointF pointF2 = new PointF();
        int width = getWidth();
        int height = getHeight();
        float f = pointF.x - ((float) (width >> 1));
        float f2 = pointF.y - ((float) (height >> 1));
        double atan2 = Math.atan2((double) f2, (double) f);
        double sqrt = Math.sqrt(Math.pow((double) f2, 2.0d) + Math.pow((double) f, 2.0d));
        atan2 += (((double) m1182J()) * 3.141592653589793d) / 180.0d;
        pointF2.x = (float) ((Math.cos(atan2) * sqrt) + ((double) (width >> 1)));
        pointF2.y = (float) (((double) (height >> 1)) + (sqrt * Math.sin(atan2)));
        return pointF2;
    }

    /* renamed from: J */
    public int m1182J() {
        return 0;
    }

    /* renamed from: a */
    protected void m1227a(boolean z, CameraPosition cameraPosition) {
        if (this.f704G != null && this.f705H.m1674a() && isEnabled()) {
            if (cameraPosition == null) {
                try {
                    cameraPosition = mo132g();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.f704G.onCameraChangeFinish(cameraPosition);
        }
    }

    /* renamed from: a */
    public void mo96a(OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        this.f704G = onCameraChangeListener;
    }

    /* renamed from: K */
    protected void m1183K() {
        this.f731j.sendEmptyMessage(10);
    }

    /* renamed from: L */
    void m1184L() {
        this.f731j.sendEmptyMessage(15);
    }

    /* renamed from: M */
    void m1185M() {
        if (this.f698A != null) {
            int width = getWidth();
            DPoint dPoint = new DPoint();
            DPoint dPoint2 = new DPoint();
            mo89a(0, 0, dPoint);
            mo89a(width, 0, dPoint2);
            double a = C0204q.m791a(new LatLng(dPoint.f3649y, dPoint.f3648x), new LatLng(dPoint2.f3649y, dPoint2.f3648x));
            int e = this.f734m.f837b.m1394e();
            width = (int) (((double) (width * this.f738q[e])) / a);
            String b = C0204q.m808b(this.f738q[e]);
            this.f698A.m1496a(width);
            this.f698A.m1497a(b);
            this.f698A.invalidate();
        }
    }

    /* renamed from: a */
    public void mo89a(int i, int i2, DPoint dPoint) {
        int e = this.f734m.f837b.m1394e();
        ac a = this.f708K.m1287a(new PointF((float) i, (float) i2), this.f708K.f761j, this.f708K.f763l, this.f708K.f759h[e], this.f708K.f764m);
        if (dPoint != null) {
            double a2 = C0270y.m1729a((long) a.m823b());
            double a3 = C0270y.m1729a((long) a.m821a());
            dPoint.f3649y = a2;
            dPoint.f3648x = a3;
        }
    }

    /* renamed from: a */
    public void m1205a(int i, int i2, IPoint iPoint) {
        int e = this.f734m.f837b.m1394e();
        ac a = this.f708K.m1287a(new PointF((float) i, (float) i2), this.f708K.f761j, this.f708K.f763l, this.f708K.f759h[e], this.f708K.f764m);
        if (iPoint != null) {
            iPoint.f3652x = (int) a.m827e();
            iPoint.f3653y = (int) a.m828f();
        }
    }

    /* renamed from: a */
    public void mo87a(double d, double d2, FPoint fPoint) {
        int e = this.f734m.f837b.m1394e();
        PointF b = this.f708K.m1293b(new ac((int) C0270y.m1730a(d), (int) C0270y.m1730a(d2)), this.f708K.f761j, this.f708K.f763l, this.f708K.f759h[e]);
        if (fPoint != null) {
            fPoint.f3650x = b.x;
            fPoint.f3651y = b.y;
        }
    }

    /* renamed from: a */
    public void m1201a(double d, double d2, IPoint iPoint) {
        ac b = this.f708K.m1295b(new ac((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)));
        iPoint.f3652x = b.m821a();
        iPoint.f3653y = b.m823b();
    }

    /* renamed from: b */
    public void m1240b(int i, int i2, DPoint dPoint) {
        if (dPoint != null) {
            dPoint.f3648x = C0270y.m1729a((long) i);
            dPoint.f3649y = C0270y.m1729a((long) i2);
        }
    }

    /* renamed from: b */
    public void mo115b(double d, double d2, IPoint iPoint) {
        int e = this.f734m.f837b.m1394e();
        PointF b = this.f708K.m1293b(new ac((int) C0270y.m1730a(d), (int) C0270y.m1730a(d2)), this.f708K.f761j, this.f708K.f763l, this.f708K.f759h[e]);
        if (iPoint != null) {
            iPoint.f3652x = (int) b.x;
            iPoint.f3653y = (int) b.y;
        }
    }

    /* renamed from: N */
    protected LatLng m1186N() {
        ac C = m1175C();
        return new LatLng(C0270y.m1729a((long) C.m823b()), C0270y.m1729a((long) C.m821a()));
    }

    /* renamed from: Y */
    private IPoint m1152Y() {
        ac C = m1175C();
        IPoint iPoint = new IPoint();
        iPoint.f3652x = (int) C.m827e();
        iPoint.f3653y = (int) C.m828f();
        return iPoint;
    }

    /* renamed from: O */
    public void mo75O() {
        if (this.f706I != null) {
            this.f706I.onCancel();
        }
    }

    /* renamed from: P */
    public void mo76P() {
        if (this.f706I != null) {
            this.f706I.onFinish();
        }
    }

    /* renamed from: Q */
    public void mo77Q() {
        this.f731j.sendEmptyMessage(17);
    }

    /* renamed from: R */
    public void mo78R() {
        postInvalidate();
        this.f727f.postInvalidate();
    }

    /* renamed from: S */
    public List<Marker> mo79S() {
        boolean z = getWidth() > 0 && getHeight() > 0;
        C0171a.m622a(z, (Object) "地图未初始化完成！");
        return this.f730i.m1126f();
    }

    /* renamed from: c */
    protected void m1249c(C0262t c0262t) {
        LatLngBounds latLngBounds = c0262t.f1145i;
        int i = c0262t.f1146j;
        int i2 = (int) ((latLngBounds.northeast.latitude * 1000000.0d) - (latLngBounds.southwest.latitude * 1000000.0d));
        int i3 = (int) ((latLngBounds.northeast.longitude * 1000000.0d) - (latLngBounds.southwest.longitude * 1000000.0d));
        m1176D().m1083a(new ac((int) (((latLngBounds.northeast.latitude * 1000000.0d) + (latLngBounds.southwest.latitude * 1000000.0d)) / 2.0d), (int) (((latLngBounds.northeast.longitude * 1000000.0d) + (latLngBounds.southwest.longitude * 1000000.0d)) / 2.0d)));
        m1176D().m1081a(i2, i3);
        m1166f(i);
        C0260s.m1682a().m1684b();
    }

    /* renamed from: f */
    private int m1166f(int i) {
        bl s = mo144s();
        return (Math.abs(s.mo183a(0, 0).m823b() - s.mo183a(0, 10).m823b()) * i) / 10;
    }
}
