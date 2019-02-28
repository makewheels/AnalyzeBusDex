package com.e4a.runtime.components.impl.android.n89;

import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.location.AMapLocalWeatherForecast;
import com.amap.api.location.AMapLocalWeatherListener;
import com.amap.api.location.AMapLocalWeatherLive;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.maps2d.AMap;
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
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.LocationSource.OnLocationChangedListener;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.overlay.BusLineOverlay;
import com.amap.api.maps2d.overlay.BusRouteOverlay;
import com.amap.api.maps2d.overlay.DrivingRouteOverlay;
import com.amap.api.maps2d.overlay.WalkRouteOverlay;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineQuery.SearchType;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;
import com.amap.api.services.route.RouteSearch.FromAndTo;
import com.amap.api.services.route.RouteSearch.OnRouteSearchListener;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0894;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.android.mainActivity.OnDestroyListener;
import com.e4a.runtime.android.mainActivity.OnPauseListener;
import com.e4a.runtime.android.mainActivity.OnResumeListener;
import com.e4a.runtime.android.mainActivity.OnSaveInstanceStateListener;
import com.e4a.runtime.components.Component;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.components.impl.android.n89.RouteSearchPoiDialog.OnListItemClick;
import com.e4a.runtime.events.EventDispatcher;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl */
public class C0789Impl extends ViewComponent implements C0778, OnPauseListener, OnResumeListener, AMapLocalWeatherListener, OnDestroyListener, OnSaveInstanceStateListener, CancelableCallback, LocationSource, AMapLocationListener, SensorEventListener, OnMapLoadedListener, OnMarkerClickListener, OnInfoWindowClickListener, OnMarkerDragListener, InfoWindowAdapter, OnBusLineSearchListener, OnBusStationSearchListener, OnPoiSearchListener, OnRouteSearchListener {
    public static final String GEOFENCE_BROADCAST_ACTION = "com.location.apis.geofencedemo.broadcast";
    private static final int SCROLL_BY_PX = 100;
    private static GeocodeSearch geocoderSearch = null;
    private String CityCode = bi_常量类.f6358b;
    private final int TIME_SENSOR = 100;
    private AMap aMap;
    private LocationManagerProxy aMapManager;
    private BusLineQuery busLineQuery;
    private BusLineResult busLineResult;
    private BusLineSearch busLineSearch;
    private int busMode = 0;
    private BusRouteResult busRouteResult;
    private BusStationQuery busStationQuery;
    private BusStationResult busStationResult;
    private List<Circle> circles;
    private int currentpage = 0;
    private DriveRouteResult driveRouteResult;
    private int drivingMode = 0;
    private LatLonPoint endPoint = null;
    private Query endSearchQuery;
    private String endTextView;
    private boolean isClickStart = false;
    private boolean isClickTarget = false;
    private long lastTime = 0;
    private LatLng latlng;
    private List<BusLineItem> lineItems = null;
    private float mAngle;
    private Marker mGPSMarker;
    private BroadcastReceiver mGeoFenceReceiver = new C07879();
    private OnLocationChangedListener mListener;
    private PendingIntent mPendingIntent;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private UiSettings mUiSettings;
    private MapView mapView;
    private List<Marker> markers;
    private List<Polyline> polylines;
    private ProgressDialog progDialog = null;
    private RouteSearch routeSearch;
    private int routeType = 1;
    private Marker startMk;
    private LatLonPoint startPoint = null;
    private Query startSearchQuery;
    private String startTextView;
    private List<BusStationItem> stationItems;
    private String strEnd;
    private String strStart;
    private Marker targetMk;
    private int walkMode = 0;
    private WalkRouteResult walkRouteResult;
    /* renamed from: 定位模式 */
    private int f4326 = 3;

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$1 */
    class C07791 implements OnCameraChangeListener {
        C07791() {
        }

        public void onCameraChangeFinish(CameraPosition cameraPosition) {
            C0789Impl.this.mo1386(cameraPosition.zoom);
        }

        public void onCameraChange(CameraPosition arg0) {
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$2 */
    class C07802 implements OnMapClickListener {
        C07802() {
        }

        public void onMapClick(LatLng point) {
            if (C0789Impl.this.isClickStart) {
                C0789Impl.this.startMk = C0789Impl.this.aMap.addMarker(new MarkerOptions().anchor(0.5f, 1.0f).icon(BitmapDescriptorFactory.fromResource(C0894.m6890("location_point", "drawable"))).position(point).title("点击本提示框设为起点"));
                C0789Impl.this.startMk.showInfoWindow();
            } else if (C0789Impl.this.isClickTarget) {
                C0789Impl.this.targetMk = C0789Impl.this.aMap.addMarker(new MarkerOptions().anchor(0.5f, 1.0f).icon(BitmapDescriptorFactory.fromResource(C0894.m6890("location_point", "drawable"))).position(point).title("点击本提示框设为终点"));
                C0789Impl.this.targetMk.showInfoWindow();
            }
            C0789Impl.this.mo1348(point.latitude, point.longitude);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$3 */
    class C07813 implements OnMapLongClickListener {
        C07813() {
        }

        public void onMapLongClick(LatLng point) {
            C0789Impl.this.mo1349(point.latitude, point.longitude);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$5 */
    class C07835 implements OnGeocodeSearchListener {
        C07835() {
        }

        public void onGeocodeSearched(GeocodeResult result, int rCode) {
            if (rCode == 0) {
                if (result == null || result.getGeocodeAddressList() == null || result.getGeocodeAddressList().size() <= 0) {
                    C0789Impl.this.mo1351(false, -1.0d, -1.0d);
                    return;
                }
                LatLng latlng = C0789Impl.this.convertToLatLng(((GeocodeAddress) result.getGeocodeAddressList().get(0)).getLatLonPoint());
                C0789Impl.this.mo1351(true, latlng.latitude, latlng.longitude);
            } else if (rCode == 27) {
                C0789Impl.this.mo1351(false, -1.0d, -1.0d);
            } else if (rCode == 32) {
                C0789Impl.this.mo1351(false, -1.0d, -1.0d);
            } else {
                C0789Impl.this.mo1351(false, -1.0d, -1.0d);
            }
        }

        public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
            if (rCode == 0) {
                if (result == null || result.getRegeocodeAddress() == null || result.getRegeocodeAddress().getFormatAddress() == null) {
                    C0789Impl.this.mo1353(false, bi_常量类.f6358b);
                    return;
                }
                C0789Impl.this.mo1353(true, result.getRegeocodeAddress().getFormatAddress());
            } else if (rCode == 27) {
                C0789Impl.this.mo1353(false, bi_常量类.f6358b);
            } else if (rCode == 32) {
                C0789Impl.this.mo1353(false, bi_常量类.f6358b);
            } else {
                C0789Impl.this.mo1353(false, bi_常量类.f6358b);
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$OnListItemlistener */
    interface OnListItemlistener {
        void onListItemClick(BusLineDialog busLineDialog, BusLineItem busLineItem);
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$6 */
    class C07846 implements OnListItemlistener {
        C07846() {
        }

        public void onListItemClick(BusLineDialog dialog, BusLineItem item) {
            C0789Impl.this.showProgressDialog();
            C0789Impl.this.busLineQuery = new BusLineQuery(item.getBusLineId(), SearchType.BY_LINE_ID, C0789Impl.this.CityCode);
            BusLineSearch busLineSearch = new BusLineSearch(mainActivity.getContext(), C0789Impl.this.busLineQuery);
            busLineSearch.setOnBusLineSearchListener(C0789Impl.this);
            busLineSearch.searchBusLineAsyn();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$7 */
    class C07857 implements OnListItemClick {
        C07857() {
        }

        public void onListItemClick(RouteSearchPoiDialog dialog, PoiItem startpoiItem) {
            C0789Impl.this.startPoint = startpoiItem.getLatLonPoint();
            C0789Impl.this.strStart = startpoiItem.getTitle();
            C0789Impl.this.startTextView = C0789Impl.this.strStart;
            C0789Impl.this.endSearchResult();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$8 */
    class C07868 implements OnListItemClick {
        C07868() {
        }

        public void onListItemClick(RouteSearchPoiDialog dialog, PoiItem endpoiItem) {
            C0789Impl.this.endPoint = endpoiItem.getLatLonPoint();
            C0789Impl.this.strEnd = endpoiItem.getTitle();
            C0789Impl.this.endTextView = C0789Impl.this.strEnd;
            C0789Impl.this.searchRouteResult(C0789Impl.this.startPoint, C0789Impl.this.endPoint);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$9 */
    class C07879 extends BroadcastReceiver {
        C07879() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals(C0789Impl.GEOFENCE_BROADCAST_ACTION)) {
                return;
            }
            if (intent.getExtras().getInt("status") == 0) {
                C0789Impl.this.mo1388(false);
            } else {
                C0789Impl.this.mo1388(true);
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$BusLineDialog */
    class BusLineDialog extends Dialog implements OnClickListener {
        private BusLineAdapter busLineAdapter;
        private List<BusLineItem> busLineItems;
        private ListView listView;
        private Button nextButton;
        protected OnListItemlistener onListItemlistener;
        private Button preButton;

        /* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图Impl$BusLineDialog$1 */
        class C07881 implements OnItemClickListener {
            C07881() {
            }

            public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                BusLineDialog.this.onListItemlistener.onListItemClick(BusLineDialog.this, (BusLineItem) BusLineDialog.this.busLineItems.get(arg2));
                BusLineDialog.this.dismiss();
            }
        }

        public BusLineDialog(Context context, int theme) {
            super(context, theme);
        }

        public void onListItemClicklistener(OnListItemlistener onListItemlistener) {
            this.onListItemlistener = onListItemlistener;
        }

        public BusLineDialog(C0789Impl c0789Impl, Context context, List<BusLineItem> busLineItems) {
            this(context, 16973830);
            this.busLineItems = busLineItems;
            this.busLineAdapter = new BusLineAdapter(context, busLineItems);
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(C0894.m6890("busline_dialog", "layout"));
            this.preButton = (Button) findViewById(C0894.m6890("preButton", "id"));
            this.nextButton = (Button) findViewById(C0894.m6890("nextButton", "id"));
            this.listView = (ListView) findViewById(C0894.m6890("listview", "id"));
            this.listView.setAdapter(this.busLineAdapter);
            this.listView.setOnItemClickListener(new C07881());
            this.preButton.setOnClickListener(this);
            this.nextButton.setOnClickListener(this);
            if (C0789Impl.this.currentpage <= 0) {
                this.preButton.setEnabled(false);
            }
            if (C0789Impl.this.currentpage >= C0789Impl.this.busLineResult.getPageCount() - 1) {
                this.nextButton.setEnabled(false);
            }
        }

        public void onClick(View v) {
            dismiss();
            if (v.equals(this.preButton)) {
                C0789Impl.this.currentpage = C0789Impl.this.currentpage - 1;
            } else if (v.equals(this.nextButton)) {
                C0789Impl.this.currentpage = C0789Impl.this.currentpage + 1;
            }
            C0789Impl.this.showProgressDialog();
            C0789Impl.this.busLineQuery.setPageNumber(C0789Impl.this.currentpage);
            C0789Impl.this.busLineSearch.setOnBusLineSearchListener(C0789Impl.this);
            C0789Impl.this.busLineSearch.searchBusLineAsyn();
        }
    }

    public C0789Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        this.mapView = new MapView(mainActivity.getContext());
        this.mapView.onCreate(C0880_应用操作类.m6708());
        this.mSensorManager = (SensorManager) mainActivity.getContext().getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(3);
        registerSensorListener();
        m6351();
        mainActivity.getContext().addOnPauseListener(this);
        mainActivity.getContext().addOnResumeListener(this);
        mainActivity.getContext().addOnDestroyListener(this);
        mainActivity.getContext().addOnSaveInstanceStateListener(this);
        return this.mapView;
    }

    /* renamed from: 初始化地图模块 */
    private void m6351() {
        if (this.aMap == null) {
            this.aMap = this.mapView.getMap();
            this.aMap.setOnCameraChangeListener(new C07791());
            this.aMap.setOnMapClickListener(new C07802());
            this.aMap.setOnMapLongClickListener(new C07813());
            this.aMap.setOnMarkerDragListener(this);
            this.aMap.setOnMapLoadedListener(this);
            this.aMap.setOnMarkerClickListener(this);
            this.aMap.setOnInfoWindowClickListener(this);
            this.aMap.setInfoWindowAdapter(this);
            this.mUiSettings = this.aMap.getUiSettings();
            this.mGPSMarker = this.aMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(C0894.m6890("location_marker", "drawable"))).anchor(0.5f, 0.5f));
            this.markers = new ArrayList();
            this.circles = new ArrayList();
            this.polylines = new ArrayList();
            this.routeSearch = new RouteSearch(mainActivity.getContext());
            this.routeSearch.setRouteSearchListener(this);
        }
    }

    /* renamed from: 视图被改变 */
    public void mo1386(float zoom) {
        EventDispatcher.dispatchEvent(this, "视图被改变", Float.valueOf(zoom));
    }

    /* renamed from: 地图被单击 */
    public void mo1348(double latitude, double longitude) {
        EventDispatcher.dispatchEvent(this, "地图被单击", Double.valueOf(latitude), Double.valueOf(longitude));
    }

    /* renamed from: 地图被长按 */
    public void mo1349(double latitude, double longitude) {
        EventDispatcher.dispatchEvent(this, "地图被长按", Double.valueOf(latitude), Double.valueOf(longitude));
    }

    private void changeCamera(CameraUpdate update, CancelableCallback callback, boolean 开启动画效果) {
        if (开启动画效果) {
            this.aMap.animateCamera(update, 1000, callback);
        } else {
            this.aMap.moveCamera(update);
        }
    }

    public void onCancel() {
    }

    public void onFinish() {
    }

    /* renamed from: 移动视图 */
    public void mo1379(double 纬度, double 经度) {
        changeCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(纬度, 经度), 18.0f, 0.0f, 30.0f)), this, true);
    }

    /* renamed from: 停止移动视图动画效果 */
    public void m6354() {
        this.aMap.stopAnimation();
    }

    /* renamed from: 向左移动视图 */
    public void mo1346() {
        changeCamera(CameraUpdateFactory.scrollBy(-100.0f, 0.0f), null, false);
    }

    /* renamed from: 向右移动视图 */
    public void mo1345() {
        changeCamera(CameraUpdateFactory.scrollBy(100.0f, 0.0f), null, false);
    }

    /* renamed from: 向上移动视图 */
    public void mo1343() {
        changeCamera(CameraUpdateFactory.scrollBy(0.0f, -100.0f), null, false);
    }

    /* renamed from: 向下移动视图 */
    public void mo1344() {
        changeCamera(CameraUpdateFactory.scrollBy(0.0f, 100.0f), null, false);
    }

    /* renamed from: 放大视图 */
    public void mo1361() {
        changeCamera(CameraUpdateFactory.zoomIn(), null, false);
    }

    /* renamed from: 缩小视图 */
    public void mo1380() {
        changeCamera(CameraUpdateFactory.zoomOut(), null, false);
    }

    /* renamed from: 置缩放级别 */
    public void mo1383(float 级别) {
        changeCamera(CameraUpdateFactory.zoomTo(级别), null, false);
    }

    /* renamed from: 置地图模式 */
    public void mo1381(int 模式) {
        if (模式 == 2) {
            this.aMap.setMapType(2);
        } else {
            this.aMap.setMapType(1);
        }
    }

    /* renamed from: 显示交通状况 */
    public void mo1362(boolean 是否显示) {
        this.aMap.setTrafficEnabled(是否显示);
    }

    /* renamed from: 保存截图 */
    public void mo1337(String 保存路径) {
        final String path = 保存路径;
        this.aMap.getMapScreenShot(new OnMapScreenShotListener() {
            public void onMapScreenShot(Bitmap bitmap) {
                boolean b = false;
                try {
                    FileOutputStream fos = new FileOutputStream(path);
                    b = bitmap.compress(CompressFormat.PNG, 100, fos);
                    try {
                        fos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                }
                if (b) {
                    C0789Impl.this.mo1359(true);
                } else {
                    C0789Impl.this.mo1359(false);
                }
            }
        });
    }

    /* renamed from: 截图完毕 */
    public void mo1359(boolean 结果) {
        EventDispatcher.dispatchEvent(this, "截图完毕", Boolean.valueOf(结果));
    }

    /* renamed from: 显示比例尺 */
    public void mo1366(boolean 是否显示) {
        this.mUiSettings.setScaleControlsEnabled(是否显示);
    }

    /* renamed from: 显示缩放按钮 */
    public void mo1367(boolean 是否显示) {
        this.mUiSettings.setZoomControlsEnabled(是否显示);
    }

    /* renamed from: 显示指南针 */
    public void mo1364(boolean 是否显示) {
        this.mUiSettings.setCompassEnabled(是否显示);
    }

    /* renamed from: 显示定位按钮 */
    public void mo1363(boolean 是否显示) {
        this.aMap.setLocationSource(this);
        this.mUiSettings.setMyLocationButtonEnabled(是否显示);
        this.aMap.setMyLocationEnabled(是否显示);
    }

    /* renamed from: 置定位模式 */
    public void mo1382(int 模式) {
        this.f4326 = 模式;
    }

    public void onLocationChanged(Location location) {
    }

    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    public void onLocationChanged(AMapLocation aLocation) {
        if (this.mListener != null) {
            this.mListener.onLocationChanged(aLocation);
            if (this.mGPSMarker == null) {
                this.mGPSMarker = this.aMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(C0894.m6890("location_marker", "drawable"))).anchor(0.5f, 0.5f));
            }
            this.latlng = new LatLng(aLocation.getLatitude(), aLocation.getLongitude());
            this.mGPSMarker.setPosition(this.latlng);
            mo1354(aLocation.getLatitude(), aLocation.getLongitude(), aLocation.getProvince(), aLocation.getCity(), aLocation.getDistrict(), aLocation.getStreet());
        }
    }

    /* renamed from: 定位完毕 */
    public void mo1354(double 纬度, double 经度, String 省份, String 城市, String 地区, String 街道) {
        EventDispatcher.dispatchEvent(this, "定位完毕", Double.valueOf(纬度), Double.valueOf(经度), 省份, 城市, 地区, 街道);
    }

    public void activate(OnLocationChangedListener listener) {
        this.mListener = listener;
        if (this.aMapManager == null) {
            this.aMapManager = LocationManagerProxy.getInstance(mainActivity.getContext());
            switch (this.f4326) {
                case 1:
                    this.aMapManager.requestLocationUpdates("gps", 2000, 10.0f, (AMapLocationListener) this);
                    return;
                case 2:
                    this.aMapManager.requestLocationUpdates(LocationManagerProxy.NETWORK_PROVIDER, 2000, 10.0f, (AMapLocationListener) this);
                    return;
                case 3:
                    this.aMapManager.requestLocationUpdates(LocationProviderProxy.AMapNetwork, 2000, 10.0f, (AMapLocationListener) this);
                    return;
                default:
                    return;
            }
        }
    }

    public void deactivate() {
        this.mListener = null;
        if (this.aMapManager != null) {
            this.aMapManager.removeUpdates((AMapLocationListener) this);
            this.aMapManager.destory();
        }
        this.aMapManager = null;
        unRegisterSensorListener();
    }

    public void registerSensorListener() {
        this.mSensorManager.registerListener(this, this.mSensor, 3);
    }

    public void unRegisterSensorListener() {
        this.mSensorManager.unregisterListener(this, this.mSensor);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        if (System.currentTimeMillis() - this.lastTime >= 100) {
            switch (event.sensor.getType()) {
                case 3:
                    float x = (event.values[0] + ((float) C0789Impl.getScreenRotationOnPhone())) % 360.0f;
                    if (x > 180.0f) {
                        x -= 360.0f;
                    } else if (x < -180.0f) {
                        x += 360.0f;
                    }
                    if (Math.abs((this.mAngle - 90.0f) + x) >= 3.0f) {
                        this.mAngle = x;
                        if (this.mGPSMarker != null) {
                            this.mGPSMarker.setRotateAngle(-this.mAngle);
                            this.aMap.invalidate();
                        }
                        this.lastTime = System.currentTimeMillis();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static int getScreenRotationOnPhone() {
        switch (((WindowManager) mainActivity.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return -90;
            default:
                return 0;
        }
    }

    /* renamed from: 禁用手势 */
    public void mo1378(boolean 是否禁用) {
        boolean z;
        boolean z2 = true;
        UiSettings uiSettings = this.mUiSettings;
        if (是否禁用) {
            z = false;
        } else {
            z = true;
        }
        uiSettings.setScrollGesturesEnabled(z);
        UiSettings uiSettings2 = this.mUiSettings;
        if (是否禁用) {
            z2 = false;
        }
        uiSettings2.setZoomGesturesEnabled(z2);
    }

    /* renamed from: 画线条 */
    public String mo1377(double 起点纬度, double 起点经度, double 终点纬度, double 终点经度, int 线条样式, int 线条颜色, int 线条宽度) {
        Polyline line;
        switch (线条样式) {
            case 1:
                line = this.aMap.addPolyline(new PolylineOptions().add(new LatLng(起点纬度, 起点经度), new LatLng(终点纬度, 终点经度)).color(线条颜色).width((float) 线条宽度));
                break;
            case 2:
                line = this.aMap.addPolyline(new PolylineOptions().add(new LatLng(起点纬度, 起点经度), new LatLng(终点纬度, 终点经度)).color(线条颜色).width((float) 线条宽度));
                line.setDottedLine(true);
                break;
            case 3:
                line = this.aMap.addPolyline(new PolylineOptions().add(new LatLng(起点纬度, 起点经度), new LatLng(终点纬度, 终点经度)).color(线条颜色).width((float) 线条宽度));
                line.setGeodesic(true);
                break;
            default:
                line = this.aMap.addPolyline(new PolylineOptions().add(new LatLng(起点纬度, 起点经度), new LatLng(终点纬度, 终点经度)).color(线条颜色).width((float) 线条宽度));
                break;
        }
        this.polylines.add(line);
        return line.getId();
    }

    /* renamed from: 删除线条 */
    public void mo1341(String 标记ID) {
        for (int i = 0; i < this.polylines.size(); i++) {
            Polyline line = (Polyline) this.polylines.get(i);
            if (line.getId().equals(标记ID)) {
                this.polylines.remove(i);
                line.remove();
                return;
            }
        }
    }

    /* renamed from: 地址查询坐标 */
    public void mo1350(String name, String citycode) {
        m6352();
        geocoderSearch.getFromLocationNameAsyn(new GeocodeQuery(name, citycode));
    }

    /* renamed from: 坐标查询地址 */
    public void mo1352(double 纬度, double 经度) {
        m6352();
        geocoderSearch.getFromLocationAsyn(new RegeocodeQuery(new LatLonPoint(纬度, 经度), 200.0f, GeocodeSearch.AMAP));
    }

    /* renamed from: 初始化查询 */
    private void m6352() {
        if (geocoderSearch == null) {
            geocoderSearch = new GeocodeSearch(mainActivity.getContext());
            geocoderSearch.setOnGeocodeSearchListener(new C07835());
        }
    }

    private LatLonPoint convertToLatLonPoint(LatLng latlon) {
        return new LatLonPoint(latlon.latitude, latlon.longitude);
    }

    private LatLng convertToLatLng(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    /* renamed from: 地址查询坐标完毕 */
    public void mo1351(boolean 查询结果, double 纬度, double 经度) {
        EventDispatcher.dispatchEvent(this, "地址查询坐标完毕", Boolean.valueOf(查询结果), Double.valueOf(纬度), Double.valueOf(经度));
    }

    /* renamed from: 坐标查询地址完毕 */
    public void mo1353(boolean 查询结果, String 地址) {
        EventDispatcher.dispatchEvent(this, "坐标查询地址完毕", Boolean.valueOf(查询结果), 地址);
    }

    /* renamed from: 添加标记 */
    public String mo1374(double 纬度, double 经度, String 标题, String 信息, int 颜色, boolean 可否拖动) {
        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(new LatLng(纬度, 经度));
        markerOption.title(标题).snippet(信息);
        switch (颜色) {
            case 1:
                markerOption.icon(BitmapDescriptorFactory.defaultMarker(0.0f));
                break;
            case 2:
                markerOption.icon(BitmapDescriptorFactory.defaultMarker(240.0f));
                break;
            case 3:
                markerOption.icon(BitmapDescriptorFactory.defaultMarker(60.0f));
                break;
        }
        markerOption.draggable(可否拖动);
        Marker marker = this.aMap.addMarker(markerOption);
        this.markers.add(marker);
        return marker.getId();
    }

    /* renamed from: 添加标记2 */
    public String mo13752(double 纬度, double 经度, String 标题, String 信息, int 图标资源索引, boolean 可否拖动) {
        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(new LatLng(纬度, 经度));
        markerOption.title(标题).snippet(信息);
        markerOption.icon(BitmapDescriptorFactory.fromResource(图标资源索引));
        markerOption.draggable(可否拖动);
        Marker marker = this.aMap.addMarker(markerOption);
        this.markers.add(marker);
        return marker.getId();
    }

    /* renamed from: 删除标记 */
    public void mo1340(String 标记ID) {
        for (int i = 0; i < this.markers.size(); i++) {
            Marker marker = (Marker) this.markers.get(i);
            if (marker.getId().equals(标记ID)) {
                this.markers.remove(i);
                marker.remove();
                return;
            }
        }
    }

    /* renamed from: 删除所有标记 */
    public void mo1339() {
        this.markers.clear();
        this.circles.clear();
        this.polylines.clear();
        this.aMap.clear();
        this.mGPSMarker = this.aMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(C0894.m6890("location_marker", "drawable"))).anchor(0.5f, 0.5f));
        this.mGPSMarker.setPosition(this.latlng);
    }

    /* renamed from: 显示标记信息窗口 */
    public void mo1365(String 标记ID) {
        for (int i = 0; i < this.markers.size(); i++) {
            Marker marker = (Marker) this.markers.get(i);
            if (marker.getId().equals(标记ID)) {
                marker.showInfoWindow();
                return;
            }
        }
    }

    /* renamed from: 隐藏标记信息窗口 */
    public void mo1389(String 标记ID) {
        for (int i = 0; i < this.markers.size(); i++) {
            Marker marker = (Marker) this.markers.get(i);
            if (marker.getId().equals(标记ID)) {
                marker.hideInfoWindow();
                return;
            }
        }
    }

    /* renamed from: 刷新地图 */
    public void mo1342() {
        this.aMap.invalidate();
    }

    public boolean onMarkerClick(Marker marker) {
        mo1371(marker.getId(), marker.getTitle(), marker.getSnippet(), marker.isInfoWindowShown());
        return true;
    }

    /* renamed from: 标记被单击 */
    public void mo1371(String 标记ID, String 标题, String 信息, boolean 信息窗口是否已显示) {
        EventDispatcher.dispatchEvent(this, "标记被单击", 标记ID, 标题, 信息, Boolean.valueOf(信息窗口是否已显示));
    }

    public void onInfoWindowClick(Marker marker) {
        this.isClickStart = false;
        this.isClickTarget = false;
        if (marker.equals(this.startMk)) {
            this.startTextView = "地图上的起点";
            this.startPoint = convertToLatLonPoint(this.startMk.getPosition());
            this.startMk.hideInfoWindow();
            this.startMk.remove();
        } else if (marker.equals(this.targetMk)) {
            this.endTextView = "地图上的终点";
            this.endPoint = convertToLatLonPoint(this.targetMk.getPosition());
            this.targetMk.hideInfoWindow();
            this.targetMk.remove();
        }
        mo1370(marker.getId(), marker.getTitle(), marker.getSnippet());
    }

    /* renamed from: 标记信息窗口被单击 */
    public void mo1370(String 标记ID, String 标题, String 信息) {
        EventDispatcher.dispatchEvent(this, "标记信息窗口被单击", 标记ID, 标题, 信息);
    }

    public void onMarkerDrag(Marker marker) {
    }

    public void onMarkerDragEnd(Marker marker) {
        mo1372(marker.getId(), marker.getPosition().latitude, marker.getPosition().longitude);
    }

    /* renamed from: 标记被拖动完毕 */
    public void mo1372(String 标记ID, double 纬度, double 经度) {
        EventDispatcher.dispatchEvent(this, "标记被拖动完毕", 标记ID, Double.valueOf(纬度), Double.valueOf(经度));
    }

    public void onMarkerDragStart(Marker marker) {
    }

    public void onMapLoaded() {
        mo1347();
    }

    /* renamed from: 地图加载完毕 */
    public void mo1347() {
        EventDispatcher.dispatchEvent(this, "地图加载完毕", new Object[0]);
    }

    public View getInfoContents(Marker marker) {
        View infoWindow = mainActivity.getContext().getLayoutInflater().inflate(C0894.m6890("custom_info_window", "layout"), null);
        render(marker, infoWindow);
        return infoWindow;
    }

    public View getInfoWindow(Marker marker) {
        View infoWindow = mainActivity.getContext().getLayoutInflater().inflate(C0894.m6890("custom_info_window", "layout"), null);
        render(marker, infoWindow);
        return infoWindow;
    }

    public void render(Marker marker, View view) {
        ((ImageView) view.findViewById(C0894.m6890("badge", "id"))).setVisibility(8);
        String title = marker.getTitle();
        TextView titleUi = (TextView) view.findViewById(C0894.m6890("title", "id"));
        if (title != null) {
            SpannableString titleText = new SpannableString(title);
            titleText.setSpan(new ForegroundColorSpan(Component.f3916), 0, titleText.length(), 0);
            titleUi.setTextSize(0, C0880_应用操作类.m6713(12.0f));
            titleUi.setText(titleText);
        } else {
            titleUi.setText(bi_常量类.f6358b);
        }
        String snippet = marker.getSnippet();
        TextView snippetUi = (TextView) view.findViewById(C0894.m6890("snippet", "id"));
        if (snippet != null) {
            SpannableString snippetText = new SpannableString(snippet);
            snippetText.setSpan(new ForegroundColorSpan(Component.f3925), 0, snippetText.length(), 0);
            snippetUi.setTextSize(0, C0880_应用操作类.m6713(9.0f));
            snippetUi.setText(snippetText);
            return;
        }
        snippetUi.setText(bi_常量类.f6358b);
    }

    /* renamed from: 查询公交线路 */
    public void mo1369(String search, String cityCode) {
        this.currentpage = 0;
        if (!bi_常量类.f6358b.equals(search) && !bi_常量类.f6358b.equals(cityCode)) {
            showProgressDialog();
            this.CityCode = cityCode;
            this.busLineQuery = new BusLineQuery(search, SearchType.BY_LINE_NAME, cityCode);
            this.busLineQuery.setPageSize(10);
            this.busLineQuery.setPageNumber(this.currentpage);
            this.busLineSearch = new BusLineSearch(mainActivity.getContext(), this.busLineQuery);
            this.busLineSearch.setOnBusLineSearchListener(this);
            this.busLineSearch.searchBusLineAsyn();
        }
    }

    /* renamed from: 查询公交站点 */
    public void mo1368(String search, String cityCode) {
        this.currentpage = 0;
        if (!bi_常量类.f6358b.equals(search) && !bi_常量类.f6358b.equals(cityCode)) {
            showProgressDialog();
            this.CityCode = cityCode;
            BusStationQuery query = new BusStationQuery(search, cityCode);
            query.setPageSize(10);
            query.setPageNumber(this.currentpage);
            BusStationSearch busStationSearch = new BusStationSearch(mainActivity.getContext(), query);
            busStationSearch.setOnBusStationSearchListener(this);
            busStationSearch.searchBusStationAsyn();
        }
    }

    private void showProgressDialog() {
        if (this.progDialog == null) {
            this.progDialog = new ProgressDialog(mainActivity.getContext());
        }
        this.progDialog.setProgressStyle(0);
        this.progDialog.setIndeterminate(false);
        this.progDialog.setCancelable(true);
        this.progDialog.setMessage("正在搜索");
        this.progDialog.show();
    }

    private void dissmissProgressDialog() {
        if (this.progDialog != null) {
            this.progDialog.dismiss();
        }
    }

    public void showResultList(List<BusLineItem> busLineItems) {
        BusLineDialog busLineDialog = new BusLineDialog(this, mainActivity.getContext(), (List) busLineItems);
        busLineDialog.onListItemClicklistener(new C07846());
        busLineDialog.show();
    }

    public void onBusStationSearched(BusStationResult result, int rCode) {
        dissmissProgressDialog();
        if (rCode == 0) {
            if (result == null || result.getPageCount() <= 0 || result.getBusStations() == null || result.getBusStations().size() <= 0) {
                C0880_应用操作类.m6694("未查询到结果");
                return;
            }
            this.busStationResult = result;
            this.stationItems = result.getBusStations();
        } else if (rCode == 27) {
            C0880_应用操作类.m6694("无网络连接");
        } else if (rCode == 32) {
            C0880_应用操作类.m6694("秘钥错误");
        } else {
            C0880_应用操作类.m6694("未知错误");
        }
    }

    public void onBusLineSearched(BusLineResult result, int rCode) {
        dissmissProgressDialog();
        if (rCode == 0) {
            if (result == null || result.getQuery() == null || !result.getQuery().equals(this.busLineQuery)) {
                C0880_应用操作类.m6694("未查询到结果");
            } else if (result.getQuery().getCategory() == SearchType.BY_LINE_NAME) {
                if (result.getPageCount() > 0 && result.getBusLines() != null && result.getBusLines().size() > 0) {
                    this.busLineResult = result;
                    this.lineItems = result.getBusLines();
                    showResultList(this.lineItems);
                }
            } else if (result.getQuery().getCategory() == SearchType.BY_LINE_ID) {
                mo1339();
                this.busLineResult = result;
                this.lineItems = this.busLineResult.getBusLines();
                BusLineOverlay busLineOverlay = new BusLineOverlay(mainActivity.getContext(), this.aMap, (BusLineItem) this.lineItems.get(0));
                busLineOverlay.removeFromMap();
                busLineOverlay.addToMap();
                busLineOverlay.zoomToSpan();
            }
        } else if (rCode == 27) {
            C0880_应用操作类.m6694("无网络连接");
        } else if (rCode == 32) {
            C0880_应用操作类.m6694("秘钥错误");
        } else {
            C0880_应用操作类.m6694("未知错误");
        }
    }

    public void busRoute() {
        this.routeType = 1;
        this.busMode = 0;
    }

    public void drivingRoute() {
        this.routeType = 2;
        this.drivingMode = 1;
    }

    public void walkRoute() {
        this.routeType = 3;
        this.walkMode = 1;
    }

    /* renamed from: 开始选择起点 */
    public void mo1358() {
        C0880_应用操作类.m6694("请在地图上点击您的起点");
        this.isClickStart = true;
        this.isClickTarget = false;
    }

    /* renamed from: 开始选择终点 */
    public void mo1357() {
        C0880_应用操作类.m6694("请在地图上点击您的终点");
        this.isClickTarget = true;
        this.isClickStart = false;
    }

    /* renamed from: 开始搜索路线 */
    public void mo1355(int type, String citycode) {
        this.strStart = this.startTextView;
        this.strEnd = this.endTextView;
        if (this.strStart == null || this.strStart.length() == 0) {
            C0880_应用操作类.m6694("请选择起点");
        } else if (this.strEnd == null || this.strEnd.length() == 0) {
            C0880_应用操作类.m6694("请选择终点");
        } else if (this.strStart.equals(this.strEnd)) {
            C0880_应用操作类.m6694("起点与终点距离很近，您可以步行前往");
        } else {
            this.CityCode = citycode;
            if (type == 1) {
                busRoute();
            } else if (type == 2) {
                drivingRoute();
            } else {
                walkRoute();
            }
            startSearchResult();
        }
    }

    /* renamed from: 开始搜索路线2 */
    public void mo13562(String 起点, String 终点, int type, String citycode) {
        this.startTextView = 起点;
        this.endTextView = 终点;
        this.strStart = this.startTextView;
        this.strEnd = this.endTextView;
        if (this.strStart == null || this.strStart.length() == 0) {
            C0880_应用操作类.m6694("请选择起点");
        } else if (this.strEnd == null || this.strEnd.length() == 0) {
            C0880_应用操作类.m6694("请选择终点");
        } else if (this.strStart.equals(this.strEnd)) {
            C0880_应用操作类.m6694("起点与终点距离很近，您可以步行前往");
        } else {
            this.CityCode = citycode;
            if (type == 1) {
                busRoute();
            } else if (type == 2) {
                drivingRoute();
            } else {
                walkRoute();
            }
            startSearchResult();
        }
    }

    public void startSearchResult() {
        this.strStart = this.startTextView;
        if (this.startPoint == null || !this.strStart.equals("地图上的起点")) {
            showProgressDialog();
            this.startSearchQuery = new Query(this.strStart, bi_常量类.f6358b, this.CityCode);
            this.startSearchQuery.setPageNum(0);
            this.startSearchQuery.setPageSize(20);
            PoiSearch poiSearch = new PoiSearch(mainActivity.getContext(), this.startSearchQuery);
            poiSearch.setOnPoiSearchListener(this);
            poiSearch.searchPOIAsyn();
            return;
        }
        endSearchResult();
    }

    public void endSearchResult() {
        this.strEnd = this.endTextView;
        if (this.endPoint == null || !this.strEnd.equals("地图上的终点")) {
            showProgressDialog();
            this.endSearchQuery = new Query(this.strEnd, bi_常量类.f6358b, this.CityCode);
            this.endSearchQuery.setPageNum(0);
            this.endSearchQuery.setPageSize(20);
            PoiSearch poiSearch = new PoiSearch(mainActivity.getContext(), this.endSearchQuery);
            poiSearch.setOnPoiSearchListener(this);
            poiSearch.searchPOIAsyn();
            return;
        }
        searchRouteResult(this.startPoint, this.endPoint);
    }

    public void searchRouteResult(LatLonPoint startPoint, LatLonPoint endPoint) {
        showProgressDialog();
        FromAndTo fromAndTo = new FromAndTo(startPoint, endPoint);
        if (this.routeType == 1) {
            this.routeSearch.calculateBusRouteAsyn(new BusRouteQuery(fromAndTo, this.busMode, this.CityCode, 0));
        } else if (this.routeType == 2) {
            this.routeSearch.calculateDriveRouteAsyn(new DriveRouteQuery(fromAndTo, this.drivingMode, null, null, bi_常量类.f6358b));
        } else if (this.routeType == 3) {
            this.routeSearch.calculateWalkRouteAsyn(new WalkRouteQuery(fromAndTo, this.walkMode));
        }
    }

    public void onPoiItemDetailSearched(PoiItemDetail arg0, int arg1) {
    }

    public void onPoiSearched(PoiResult result, int rCode) {
        dissmissProgressDialog();
        if (rCode == 0) {
            if (result == null || result.getQuery() == null || result.getPois() == null || result.getPois().size() <= 0) {
                C0880_应用操作类.m6694("未查询到结果");
                mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
            } else if (result.getQuery().equals(this.startSearchQuery)) {
                dialog = new RouteSearchPoiDialog(mainActivity.getContext(), result.getPois());
                dialog.setTitle("您要找的起点是:");
                dialog.show();
                dialog.setOnListClickListener(new C07857());
            } else if (result.getQuery().equals(this.endSearchQuery)) {
                dialog = new RouteSearchPoiDialog(mainActivity.getContext(), result.getPois());
                dialog.setTitle("您要找的终点是:");
                dialog.show();
                dialog.setOnListClickListener(new C07868());
            }
        } else if (rCode == 27) {
            C0880_应用操作类.m6694("无网络连接");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else if (rCode == 32) {
            C0880_应用操作类.m6694("秘钥错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else {
            C0880_应用操作类.m6694("未知错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        }
    }

    public void onBusRouteSearched(BusRouteResult result, int rCode) {
        dissmissProgressDialog();
        if (rCode == 0) {
            if (result == null || result.getPaths() == null || result.getPaths().size() <= 0) {
                C0880_应用操作类.m6694("未查询到结果");
                mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
                return;
            }
            this.busRouteResult = result;
            BusPath busPath = (BusPath) this.busRouteResult.getPaths().get(0);
            mo1339();
            BusRouteOverlay routeOverlay = new BusRouteOverlay(mainActivity.getContext(), this.aMap, busPath, this.busRouteResult.getStartPos(), this.busRouteResult.getTargetPos());
            routeOverlay.removeFromMap();
            routeOverlay.addToMap();
            routeOverlay.zoomToSpan();
            mo1360(true, this.busRouteResult.getStartPos().getLatitude(), this.busRouteResult.getStartPos().getLongitude(), this.busRouteResult.getTargetPos().getLatitude(), this.busRouteResult.getTargetPos().getLongitude());
        } else if (rCode == 27) {
            C0880_应用操作类.m6694("无网络连接");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else if (rCode == 32) {
            C0880_应用操作类.m6694("秘钥错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else {
            C0880_应用操作类.m6694("未知错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        }
    }

    public void onDriveRouteSearched(DriveRouteResult result, int rCode) {
        dissmissProgressDialog();
        if (rCode == 0) {
            if (result == null || result.getPaths() == null || result.getPaths().size() <= 0) {
                C0880_应用操作类.m6694("未查询到结果");
                mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
                return;
            }
            this.driveRouteResult = result;
            DrivePath drivePath = (DrivePath) this.driveRouteResult.getPaths().get(0);
            mo1339();
            DrivingRouteOverlay drivingRouteOverlay = new DrivingRouteOverlay(mainActivity.getContext(), this.aMap, drivePath, this.driveRouteResult.getStartPos(), this.driveRouteResult.getTargetPos());
            drivingRouteOverlay.removeFromMap();
            drivingRouteOverlay.addToMap();
            drivingRouteOverlay.zoomToSpan();
            mo1360(true, this.driveRouteResult.getStartPos().getLatitude(), this.driveRouteResult.getStartPos().getLongitude(), this.driveRouteResult.getTargetPos().getLatitude(), this.driveRouteResult.getTargetPos().getLongitude());
        } else if (rCode == 27) {
            C0880_应用操作类.m6694("无网络连接");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else if (rCode == 32) {
            C0880_应用操作类.m6694("秘钥错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else {
            C0880_应用操作类.m6694("未知错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        }
    }

    public void onWalkRouteSearched(WalkRouteResult result, int rCode) {
        dissmissProgressDialog();
        if (rCode == 0) {
            if (result == null || result.getPaths() == null || result.getPaths().size() <= 0) {
                C0880_应用操作类.m6694("未查询到结果");
                mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
                return;
            }
            this.walkRouteResult = result;
            WalkPath walkPath = (WalkPath) this.walkRouteResult.getPaths().get(0);
            mo1339();
            WalkRouteOverlay walkRouteOverlay = new WalkRouteOverlay(mainActivity.getContext(), this.aMap, walkPath, this.walkRouteResult.getStartPos(), this.walkRouteResult.getTargetPos());
            walkRouteOverlay.removeFromMap();
            walkRouteOverlay.addToMap();
            walkRouteOverlay.zoomToSpan();
            mo1360(true, this.walkRouteResult.getStartPos().getLatitude(), this.walkRouteResult.getStartPos().getLongitude(), this.walkRouteResult.getTargetPos().getLatitude(), this.walkRouteResult.getTargetPos().getLongitude());
        } else if (rCode == 27) {
            C0880_应用操作类.m6694("无网络连接");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else if (rCode == 32) {
            C0880_应用操作类.m6694("秘钥错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        } else {
            C0880_应用操作类.m6694("未知错误");
            mo1360(false, 0.0d, 0.0d, 0.0d, 0.0d);
        }
    }

    /* renamed from: 搜索路线完毕 */
    public void mo1360(boolean 搜索结果, double 起点纬度, double 起点经度, double 终点纬度, double 终点经度) {
        EventDispatcher.dispatchEvent(this, "搜索路线完毕", Boolean.valueOf(搜索结果), Double.valueOf(起点纬度), Double.valueOf(起点经度), Double.valueOf(终点纬度), Double.valueOf(终点经度));
    }

    /* renamed from: 计算两点距离 */
    public float mo1387(double 起点纬度, double 起点经度, double 终点纬度, double 终点经度) {
        return AMapUtils.calculateLineDistance(new LatLng(起点纬度, 起点经度), new LatLng(终点纬度, 终点经度));
    }

    /* renamed from: 获取天气 */
    public void mo1384() {
        this.aMapManager.requestWeatherUpdates(1, this);
    }

    public void onWeatherForecaseSearched(AMapLocalWeatherForecast arg0) {
    }

    public void onWeatherLiveSearched(AMapLocalWeatherLive aMapLocalWeatherLive) {
        if (aMapLocalWeatherLive == null || aMapLocalWeatherLive.getAMapException().getErrorCode() != 0) {
            mo1385(bi_常量类.f6358b, bi_常量类.f6358b, bi_常量类.f6358b, bi_常量类.f6358b, bi_常量类.f6358b, bi_常量类.f6358b, bi_常量类.f6358b);
        } else {
            mo1385(aMapLocalWeatherLive.getCity(), aMapLocalWeatherLive.getWeather(), aMapLocalWeatherLive.getTemperature() + "℃", aMapLocalWeatherLive.getWindDir() + "风", aMapLocalWeatherLive.getWindPower() + "级", aMapLocalWeatherLive.getHumidity() + "%", aMapLocalWeatherLive.getReportTime());
        }
    }

    /* renamed from: 获取天气完毕 */
    public void mo1385(String 城市, String 天气, String 气温, String 风向, String 风力, String 湿度, String 发布时间) {
        EventDispatcher.dispatchEvent(this, "获取天气完毕", 城市, 天气, 气温, 风向, 风力, 湿度, 发布时间);
    }

    /* renamed from: 添加地理围栏 */
    public void mo1373(double 纬度, double 经度, float 半径) {
        if (this.aMapManager != null) {
            if (this.mPendingIntent == null) {
                IntentFilter fliter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                fliter.addAction(GEOFENCE_BROADCAST_ACTION);
                mainActivity.getContext().registerReceiver(this.mGeoFenceReceiver, fliter);
                this.mPendingIntent = PendingIntent.getBroadcast(mainActivity.getContext().getApplicationContext(), 0, new Intent(GEOFENCE_BROADCAST_ACTION), 0);
            }
            this.aMapManager.removeGeoFenceAlert(this.mPendingIntent);
            this.aMapManager.addGeoFenceAlert(纬度, 经度, 半径, 1800000, this.mPendingIntent);
        }
    }

    /* renamed from: 画圆圈 */
    public String mo1376(double 纬度, double 经度, double 半径, float 线条宽度, int 线条颜色, int 填充色) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(纬度, 经度)).radius(半径).strokeWidth(线条宽度).strokeColor(线条颜色).fillColor(填充色);
        Circle mCircle = this.aMap.addCircle(circleOptions);
        this.circles.add(mCircle);
        return mCircle.getId();
    }

    /* renamed from: 删除圆圈 */
    public void mo1338(String 标记ID) {
        for (int i = 0; i < this.circles.size(); i++) {
            Circle circle = (Circle) this.circles.get(i);
            if (circle.getId().equals(标记ID)) {
                this.circles.remove(i);
                circle.remove();
                return;
            }
        }
    }

    /* renamed from: 进出围栏 */
    public void mo1388(boolean 是否在围栏内) {
        EventDispatcher.dispatchEvent(this, "进出围栏", Boolean.valueOf(是否在围栏内));
    }

    public void onPause() {
    }

    public void onResume() {
        this.mapView.onResume();
        registerSensorListener();
    }

    public void onSaveInstanceState(Bundle outState) {
        this.mapView.onSaveInstanceState(outState);
    }

    public void onDestroy() {
        this.mapView.onDestroy();
        if (this.mPendingIntent != null) {
            mainActivity.getContext().unregisterReceiver(this.mGeoFenceReceiver);
        }
        if (this.aMapManager != null) {
            if (this.mPendingIntent != null) {
                this.aMapManager.removeGeoFenceAlert(this.mPendingIntent);
            }
            this.aMapManager.removeUpdates((AMapLocationListener) this);
        }
        this.aMapManager = null;
    }
}
