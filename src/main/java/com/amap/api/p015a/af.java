package com.amap.api.p015a;

import android.location.Location;
import android.os.RemoteException;
import android.view.View;
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
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import com.autonavi.amap.mapcore2d.DPoint;
import com.autonavi.amap.mapcore2d.FPoint;
import com.autonavi.amap.mapcore2d.IPoint;
import java.util.List;

/* compiled from: IAMapDelegate */
/* renamed from: com.amap.api.a.af */
public interface af {
    /* renamed from: R */
    void mo78R();

    /* renamed from: S */
    List<Marker> mo79S() throws RemoteException;

    /* renamed from: a */
    ag mo80a(CircleOptions circleOptions) throws RemoteException;

    /* renamed from: a */
    ah mo81a(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    /* renamed from: a */
    al mo82a(PolygonOptions polygonOptions) throws RemoteException;

    /* renamed from: a */
    am mo83a(PolylineOptions polylineOptions) throws RemoteException;

    /* renamed from: a */
    bf mo84a();

    /* renamed from: a */
    Marker mo85a(MarkerOptions markerOptions) throws RemoteException;

    /* renamed from: a */
    TileOverlay mo86a(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    /* renamed from: a */
    void mo87a(double d, double d2, FPoint fPoint);

    /* renamed from: a */
    void mo88a(float f) throws RemoteException;

    /* renamed from: a */
    void mo89a(int i, int i2, DPoint dPoint);

    /* renamed from: a */
    void mo90a(Location location);

    /* renamed from: a */
    void mo91a(aa aaVar);

    /* renamed from: a */
    void mo92a(C0262t c0262t) throws RemoteException;

    /* renamed from: a */
    void mo93a(C0262t c0262t, long j, CancelableCallback cancelableCallback) throws RemoteException;

    /* renamed from: a */
    void mo94a(C0262t c0262t, CancelableCallback cancelableCallback) throws RemoteException;

    /* renamed from: a */
    void mo95a(InfoWindowAdapter infoWindowAdapter) throws RemoteException;

    /* renamed from: a */
    void mo96a(OnCameraChangeListener onCameraChangeListener) throws RemoteException;

    /* renamed from: a */
    void mo97a(OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException;

    /* renamed from: a */
    void mo98a(OnMapClickListener onMapClickListener) throws RemoteException;

    /* renamed from: a */
    void mo99a(OnMapLoadedListener onMapLoadedListener) throws RemoteException;

    /* renamed from: a */
    void mo100a(OnMapLongClickListener onMapLongClickListener) throws RemoteException;

    /* renamed from: a */
    void mo101a(OnMapScreenShotListener onMapScreenShotListener);

    /* renamed from: a */
    void mo102a(OnMarkerClickListener onMarkerClickListener) throws RemoteException;

    /* renamed from: a */
    void mo103a(OnMarkerDragListener onMarkerDragListener) throws RemoteException;

    /* renamed from: a */
    void mo104a(OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException;

    /* renamed from: a */
    void mo105a(LocationSource locationSource) throws RemoteException;

    /* renamed from: a */
    void mo106a(MyLocationStyle myLocationStyle) throws RemoteException;

    /* renamed from: a */
    void mo107a(boolean z) throws RemoteException;

    /* renamed from: a */
    boolean mo112a(String str) throws RemoteException;

    /* renamed from: b */
    ba mo113b();

    /* renamed from: b */
    be mo114b(MarkerOptions markerOptions) throws RemoteException;

    /* renamed from: b */
    void mo115b(double d, double d2, IPoint iPoint);

    /* renamed from: b */
    void mo116b(int i) throws RemoteException;

    /* renamed from: b */
    void mo117b(C0262t c0262t) throws RemoteException;

    /* renamed from: b */
    void mo118b(boolean z) throws RemoteException;

    /* renamed from: b */
    boolean mo120b(String str);

    /* renamed from: c */
    int mo121c();

    /* renamed from: c */
    void mo122c(int i);

    /* renamed from: c */
    void mo123c(boolean z) throws RemoteException;

    /* renamed from: d */
    int mo125d();

    /* renamed from: d */
    void mo126d(int i);

    /* renamed from: d */
    void mo127d(boolean z);

    /* renamed from: e */
    View mo128e() throws RemoteException;

    /* renamed from: e */
    void mo129e(boolean z);

    /* renamed from: f */
    float mo130f();

    /* renamed from: f */
    void mo131f(boolean z);

    /* renamed from: g */
    CameraPosition mo132g() throws RemoteException;

    /* renamed from: g */
    void mo133g(boolean z);

    /* renamed from: h */
    float mo134h();

    /* renamed from: i */
    float mo135i();

    /* renamed from: j */
    void mo136j() throws RemoteException;

    /* renamed from: k */
    void mo137k() throws RemoteException;

    /* renamed from: l */
    int mo138l() throws RemoteException;

    /* renamed from: m */
    boolean mo139m() throws RemoteException;

    /* renamed from: n */
    boolean mo140n() throws RemoteException;

    /* renamed from: p */
    Location mo141p() throws RemoteException;

    /* renamed from: q */
    aq mo142q() throws RemoteException;

    /* renamed from: r */
    an mo143r() throws RemoteException;

    /* renamed from: s */
    bl mo144s() throws RemoteException;

    /* renamed from: v */
    void mo145v();

    /* renamed from: w */
    float mo146w();

    /* renamed from: y */
    void mo147y();

    /* renamed from: z */
    void mo148z();
}
