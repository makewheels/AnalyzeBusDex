package com.amap.api.mapcore;

import android.location.Location;
import android.os.RemoteException;
import android.view.View;
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
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IAMapDelegate */
/* renamed from: com.amap.api.mapcore.u */
public interface C0313u {
    /* renamed from: B */
    LatLngBounds mo331B();

    /* renamed from: E */
    float mo332E() throws RemoteException;

    /* renamed from: F */
    int mo333F();

    /* renamed from: G */
    List<Marker> mo334G() throws RemoteException;

    /* renamed from: H */
    void mo335H();

    /* renamed from: I */
    void mo336I();

    /* renamed from: L */
    int mo337L() throws RemoteException;

    /* renamed from: M */
    boolean mo338M();

    /* renamed from: N */
    C0336j mo339N();

    /* renamed from: O */
    void mo340O() throws RemoteException;

    /* renamed from: a */
    aa mo341a(NavigateArrowOptions navigateArrowOptions) throws RemoteException;

    /* renamed from: a */
    ac mo342a(PolygonOptions polygonOptions) throws RemoteException;

    /* renamed from: a */
    ad mo343a(PolylineOptions polylineOptions) throws RemoteException;

    /* renamed from: a */
    C0334v mo344a(ArcOptions arcOptions) throws RemoteException;

    /* renamed from: a */
    C0339w mo345a(CircleOptions circleOptions) throws RemoteException;

    /* renamed from: a */
    C0352x mo346a(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    /* renamed from: a */
    LatLngBounds mo347a(LatLng latLng, float f);

    /* renamed from: a */
    Marker mo348a(MarkerOptions markerOptions) throws RemoteException;

    /* renamed from: a */
    Text mo349a(TextOptions textOptions) throws RemoteException;

    /* renamed from: a */
    TileOverlay mo350a(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    /* renamed from: a */
    ArrayList<Marker> mo351a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo352a(double d, double d2, FPoint fPoint);

    /* renamed from: a */
    void mo353a(double d, double d2, IPoint iPoint);

    /* renamed from: a */
    void mo354a(float f) throws RemoteException;

    /* renamed from: a */
    void mo355a(float f, float f2, IPoint iPoint);

    /* renamed from: a */
    void mo356a(int i) throws RemoteException;

    /* renamed from: a */
    void mo357a(int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo358a(int i, int i2, int i3, int i4) throws RemoteException;

    /* renamed from: a */
    void mo359a(int i, int i2, DPoint dPoint);

    /* renamed from: a */
    void mo360a(int i, int i2, FPoint fPoint);

    /* renamed from: a */
    void mo361a(Location location) throws RemoteException;

    /* renamed from: a */
    void mo362a(C0338k c0338k) throws RemoteException;

    /* renamed from: a */
    void mo363a(C0338k c0338k, long j, CancelableCallback cancelableCallback) throws RemoteException;

    /* renamed from: a */
    void mo364a(C0338k c0338k, CancelableCallback cancelableCallback) throws RemoteException;

    /* renamed from: a */
    void mo365a(C0348q c0348q);

    /* renamed from: a */
    void mo366a(C0294z c0294z) throws RemoteException;

    /* renamed from: a */
    void mo367a(InfoWindowAdapter infoWindowAdapter) throws RemoteException;

    /* renamed from: a */
    void mo368a(OnCacheRemoveListener onCacheRemoveListener) throws RemoteException;

    /* renamed from: a */
    void mo369a(OnCameraChangeListener onCameraChangeListener) throws RemoteException;

    /* renamed from: a */
    void mo370a(OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException;

    /* renamed from: a */
    void mo371a(OnMapClickListener onMapClickListener) throws RemoteException;

    /* renamed from: a */
    void mo372a(OnMapLoadedListener onMapLoadedListener) throws RemoteException;

    /* renamed from: a */
    void mo373a(OnMapLongClickListener onMapLongClickListener) throws RemoteException;

    /* renamed from: a */
    void mo374a(OnMapScreenShotListener onMapScreenShotListener);

    /* renamed from: a */
    void mo375a(OnMapTouchListener onMapTouchListener) throws RemoteException;

    /* renamed from: a */
    void mo376a(OnMarkerClickListener onMarkerClickListener) throws RemoteException;

    /* renamed from: a */
    void mo377a(OnMarkerDragListener onMarkerDragListener) throws RemoteException;

    /* renamed from: a */
    void mo378a(OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException;

    /* renamed from: a */
    void mo379a(OnPOIClickListener onPOIClickListener) throws RemoteException;

    /* renamed from: a */
    void mo380a(onMapPrintScreenListener onmapprintscreenlistener);

    /* renamed from: a */
    void mo381a(CustomRenderer customRenderer) throws RemoteException;

    /* renamed from: a */
    void mo382a(LocationSource locationSource) throws RemoteException;

    /* renamed from: a */
    void mo383a(MyLocationStyle myLocationStyle) throws RemoteException;

    /* renamed from: a */
    void mo384a(boolean z);

    /* renamed from: a */
    boolean mo385a(String str) throws RemoteException;

    /* renamed from: b */
    int mo386b();

    /* renamed from: b */
    void mo387b(double d, double d2, IPoint iPoint);

    /* renamed from: b */
    void mo388b(int i) throws RemoteException;

    /* renamed from: b */
    void mo389b(int i, int i2, DPoint dPoint);

    /* renamed from: b */
    void mo390b(int i, int i2, FPoint fPoint);

    /* renamed from: b */
    void mo391b(C0338k c0338k) throws RemoteException;

    /* renamed from: b */
    void mo392b(boolean z);

    /* renamed from: b */
    boolean mo393b(C0294z c0294z) throws RemoteException;

    /* renamed from: c */
    float mo394c(int i);

    /* renamed from: c */
    MapProjection mo395c();

    /* renamed from: c */
    void mo396c(boolean z);

    /* renamed from: d */
    void mo397d();

    /* renamed from: d */
    void mo398d(int i);

    /* renamed from: d */
    void mo399d(boolean z);

    /* renamed from: e */
    void mo400e(int i);

    /* renamed from: e */
    void mo401e(boolean z);

    /* renamed from: f */
    void mo402f(int i);

    /* renamed from: f */
    void mo403f(boolean z) throws RemoteException;

    /* renamed from: g */
    void mo404g(int i) throws RemoteException;

    /* renamed from: g */
    void mo405g(boolean z) throws RemoteException;

    /* renamed from: h */
    int mo406h();

    /* renamed from: h */
    void mo407h(int i);

    /* renamed from: h */
    void mo408h(boolean z) throws RemoteException;

    /* renamed from: i */
    int mo409i();

    /* renamed from: i */
    CameraPosition mo410i(boolean z);

    /* renamed from: j */
    int mo411j();

    /* renamed from: k */
    void mo412k();

    /* renamed from: l */
    CameraPosition mo413l() throws RemoteException;

    /* renamed from: l */
    void mo414l(boolean z) throws RemoteException;

    /* renamed from: m */
    float mo415m();

    /* renamed from: n */
    float mo416n();

    /* renamed from: o */
    void mo417o() throws RemoteException;

    void onPause();

    void onResume();

    /* renamed from: p */
    void mo420p() throws RemoteException;

    /* renamed from: q */
    int mo421q() throws RemoteException;

    /* renamed from: r */
    boolean mo422r() throws RemoteException;

    /* renamed from: s */
    boolean mo423s() throws RemoteException;

    void setZOrderOnTop(boolean z) throws RemoteException;

    /* renamed from: t */
    Location mo425t() throws RemoteException;

    /* renamed from: u */
    ai mo426u() throws RemoteException;

    /* renamed from: v */
    ae mo427v() throws RemoteException;

    /* renamed from: x */
    View mo428x() throws RemoteException;

    /* renamed from: y */
    void mo429y();

    /* renamed from: z */
    float mo430z();
}
