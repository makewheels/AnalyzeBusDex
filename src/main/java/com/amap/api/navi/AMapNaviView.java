package com.amap.api.navi;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.navi.view.C0465b;
import com.amap.api.navi.view.DirectionView;
import com.amap.api.navi.view.DriveWayView;
import com.autonavi.tbt.C0615f;
import com.autonavi.tbt.C0617g;
import com.chedaole.C0641R;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.ref.WeakReference;

public class AMapNaviView extends FrameLayout implements OnClickListener, OnCameraChangeListener, OnMapLoadedListener, OnMapTouchListener {
    private int LOCK_TILT = 30;
    private int LOCK_ZOOM = 18;
    private AMap aMap;
    private AMapNavi aMapNavi;
    private AMapNaviViewOptions aMapNaviViewOptions = null;
    CheckBox checkBox;
    RelativeLayout container;
    TextView curRoadName;
    FrameLayout cur_road_layout;
    DirectionView direction;
    DirectionView direction_hori;
    LinearLayout direction_layout;
    LinearLayout electronicCamera;
    RelativeLayout footerLayout;
    LinearLayout footer_linearlayout;
    boolean isAllRoute = false;
    boolean isArrivedEnd = false;
    private boolean isCarLock = true;
    boolean isLandscape = false;
    boolean isLayOutVisible = true;
    private boolean isZoomVisible = true;
    private long lockMapDelayed = 5000;
    DriveWayView mDriveWayView;
    private C0446a mHandler;
    int mapHeight = 0;
    private MapView mapView;
    int mapWidth = 0;
    int nHeight = 800;
    int nWidth = 480;
    View naviLatout = null;
    ImageView navi_back;
    FrameLayout navi_car_layout;
    ImageView navi_setting;
    ImageView navigation_back_down_line;
    ImageView navigation_down_line;
    TextView navigation_go_on;
    TextView nextRoadDis;
    TextView nextRoadName;
    TextView remainDis;
    TextView remainDisAndTime;
    TextView remainTime;
    private int roadSignClickCount = 0;
    LinearLayout roadname_layout;
    ImageView roadsign;
    LinearLayout roadsign_layout;
    ImageView routeTMC;
    private AMapNaviViewListener settingListener;
    FrameLayout show_naving_info;
    TextView speedCamera;
    C0465b tmc_info;
    Drawable trafficClose;
    Drawable trafficOpen;
    private C0454g uiController;
    float zoom = 19.0f;
    LinearLayout zoom_layout;
    Button zoomin;
    Button zoomout;

    /* renamed from: com.amap.api.navi.AMapNaviView$1 */
    class C04441 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ AMapNaviView f2683a;

        C04441(AMapNaviView aMapNaviView) {
            this.f2683a = aMapNaviView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.amap.api.navi.AMapNaviView$2 */
    class C04452 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ AMapNaviView f2684a;

        C04452(AMapNaviView aMapNaviView) {
            this.f2684a = aMapNaviView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            this.f2684a.aMapNavi.stopNavi();
            this.f2684a.mHandler.sendEmptyMessage(3);
        }
    }

    /* renamed from: com.amap.api.navi.AMapNaviView$a */
    static class C0446a extends Handler {
        /* renamed from: a */
        private WeakReference<AMapNaviView> f2685a;

        C0446a(AMapNaviView aMapNaviView) {
            try {
                this.f2685a = new WeakReference(aMapNaviView);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((AMapNaviView) this.f2685a.get()).setCarLock(true);
                        return;
                    case 1:
                        if (((AMapNaviView) this.f2685a.get()).settingListener != null) {
                            ((AMapNaviView) this.f2685a.get()).settingListener.onNaviSetting();
                            return;
                        }
                        return;
                    case 2:
                        ((AMapNaviView) this.f2685a.get()).showDialog();
                        return;
                    case 3:
                        if (((AMapNaviView) this.f2685a.get()).settingListener != null) {
                            ((AMapNaviView) this.f2685a.get()).settingListener.onNaviCancel();
                            return;
                        }
                        return;
                    case 4:
                        ((AMapNaviView) this.f2685a.get()).setCarLock(false);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public AMapNaviView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AMapNaviView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AMapNaviView(Context context) {
        super(context);
        init();
    }

    public AMapNaviView(Context context, AMapNaviViewOptions aMapNaviViewOptions) {
        super(context);
        this.aMapNaviViewOptions = aMapNaviViewOptions;
        init();
    }

    public void setViewOptions(AMapNaviViewOptions aMapNaviViewOptions) {
        this.aMapNaviViewOptions = aMapNaviViewOptions;
        checkViewOptions();
    }

    public AMapNaviViewOptions getViewOptions() {
        return this.aMapNaviViewOptions;
    }

    public AMap getMap() {
        return this.aMap;
    }

    private void init() {
        try {
            if (this.aMapNaviViewOptions == null) {
                this.aMapNaviViewOptions = new AMapNaviViewOptions();
            }
            this.aMapNavi = AMapNavi.getInstance(getContext());
            this.naviLatout = C0617g.m4844a((Activity) getContext(), C0641R.layout.routesearch_list_poi, null);
            this.mapView = (MapView) this.naviLatout.findViewById(2131427347);
            C0615f.m4833a(getContext());
            addView(this.naviLatout);
            boolean z = ((Activity) getContext()).getRequestedOrientation() == 0 || getResources().getConfiguration().orientation == 2;
            this.isLandscape = z;
            if (this.uiController == null) {
                this.uiController = new C0454g(getContext(), this.mapView, this);
            }
            initView();
            this.mHandler = new C0446a(this);
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    private void buildScreenInfo() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.nWidth = displayMetrics.widthPixels;
        this.nHeight = displayMetrics.heightPixels;
    }

    private void initListener() {
        try {
            this.aMap.setOnMapLoadedListener(this);
            this.aMap.setOnCameraChangeListener(this);
            this.aMap.setOnMapTouchListener(this);
            this.aMapNavi.setAMapNaviListener(this.uiController);
            this.navi_car_layout.setOnClickListener(this);
            this.routeTMC.setOnClickListener(this);
            this.navi_setting.setOnClickListener(this);
            this.navi_back.setOnClickListener(this);
            this.roadsign.setOnClickListener(this);
            this.direction.setOnClickListener(this);
            this.direction_hori.setOnClickListener(this);
            this.checkBox.setOnClickListener(this);
            this.zoomout.setOnClickListener(this);
            this.zoomin.setOnClickListener(this);
            this.curRoadName.setOnClickListener(this);
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    private void initView() {
        try {
            this.tmc_info = new C0465b(getContext());
            this.direction = (DirectionView) this.naviLatout.findViewById(2131427352);
            this.direction_hori = (DirectionView) this.naviLatout.findViewById(2131427359);
            this.container = (RelativeLayout) this.naviLatout.findViewById(2131427346);
            this.mDriveWayView = (DriveWayView) this.naviLatout.findViewById(2131427366);
            this.mDriveWayView.setAMapNaviView(this);
            this.speedCamera = (TextView) this.naviLatout.findViewById(2131427355);
            this.electronicCamera = (LinearLayout) this.naviLatout.findViewById(2131427354);
            this.roadsign = (ImageView) this.naviLatout.findViewById(2131427350);
            this.nextRoadDis = (TextView) this.naviLatout.findViewById(2131427351);
            this.nextRoadName = (TextView) this.naviLatout.findViewById(2131427357);
            this.remainDisAndTime = (TextView) this.naviLatout.findViewById(2131427358);
            this.remainDis = (TextView) this.naviLatout.findViewById(2131427371);
            this.remainTime = (TextView) this.naviLatout.findViewById(2131427372);
            this.navi_car_layout = (FrameLayout) this.naviLatout.findViewById(2131427375);
            this.show_naving_info = (FrameLayout) this.naviLatout.findViewById(2131427370);
            this.routeTMC = (ImageView) this.naviLatout.findViewById(2131427360);
            this.navigation_down_line = (ImageView) this.naviLatout.findViewById(2131427377);
            this.navigation_back_down_line = (ImageView) this.naviLatout.findViewById(2131427369);
            this.navi_setting = (ImageView) this.naviLatout.findViewById(2131427378);
            this.navi_back = (ImageView) this.naviLatout.findViewById(2131427368);
            this.direction_layout = (LinearLayout) this.naviLatout.findViewById(2131427349);
            this.cur_road_layout = (FrameLayout) this.naviLatout.findViewById(2131427373);
            this.footer_linearlayout = (LinearLayout) this.naviLatout.findViewById(2131427367);
            this.curRoadName = (TextView) this.naviLatout.findViewById(2131427374);
            this.navigation_go_on = (TextView) this.naviLatout.findViewById(2131427376);
            this.zoomout = (Button) this.naviLatout.findViewById(2131427364);
            this.zoomin = (Button) this.naviLatout.findViewById(2131427363);
            this.checkBox = (CheckBox) this.naviLatout.findViewById(2131427365);
            this.trafficOpen = C0617g.m4842a().getDrawable(2130837583);
            this.trafficClose = C0617g.m4842a().getDrawable(2130837582);
            this.footerLayout = (RelativeLayout) this.naviLatout.findViewById(2131427362);
            this.roadsign_layout = (LinearLayout) this.naviLatout.findViewById(2131427348);
            this.roadname_layout = (LinearLayout) this.naviLatout.findViewById(2131427356);
            this.zoom_layout = (LinearLayout) this.naviLatout.findViewById(2131427361);
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            buildScreenInfo();
            boolean z = ((Activity) getContext()).getRequestedOrientation() == 0 || getResources().getConfiguration().orientation == 2;
            this.isLandscape = z;
            setConfigurationChanged(this.isLandscape);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void setConfigurationChanged(boolean z) {
        if (this.tmc_info != null) {
            this.tmc_info.m3951a(z);
        }
        LayoutParams layoutParams;
        if (z) {
            if (!this.isArrivedEnd) {
                this.remainDisAndTime.setVisibility(0);
            }
            layoutParams = (LayoutParams) this.footerLayout.getLayoutParams();
            layoutParams.width = getPixel(ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE);
            this.footerLayout.setLayoutParams(layoutParams);
            setMapLayoutParams(0);
            setZoomLayoutParams(10, 10, 10, 0);
            this.direction.setVisibility(8);
            this.direction_hori.setVisibility(0);
        } else {
            this.remainDisAndTime.setVisibility(8);
            layoutParams = (LayoutParams) this.footerLayout.getLayoutParams();
            layoutParams.width = -2;
            this.footerLayout.setLayoutParams(layoutParams);
            setMapLayoutParams(40);
            setZoomLayoutParams(10, 10, 10, 30);
            this.direction.setVisibility(0);
            this.direction_hori.setVisibility(4);
        }
        setCarLock(this.isCarLock);
    }

    void checkViewOptions() {
        try {
            if (this.aMapNaviViewOptions.isLayoutVisible()) {
                setLayOutVisible(true);
                setZoomVisible(true);
            } else {
                setLayOutVisible(false);
                setZoomVisible(false);
            }
            this.lockMapDelayed = this.aMapNaviViewOptions.getLockMapDelayed();
            if (!this.aMapNaviViewOptions.isCompassEnabled()) {
                this.direction.setVisibility(4);
                this.direction_hori.setVisibility(4);
            } else if (this.isLandscape) {
                this.direction.setVisibility(4);
                this.direction_hori.setVisibility(0);
            } else {
                this.direction.setVisibility(0);
                this.direction_hori.setVisibility(4);
            }
            if (this.aMapNaviViewOptions.isTrafficBarEnabled() && this.aMapNavi.getEngineType() == 0) {
                this.tmc_info.setVisibility(0);
            } else {
                this.tmc_info.setVisibility(8);
            }
            this.aMapNavi.getNaviSetting().m3845a(this.aMapNaviViewOptions.isTrafficBarEnabled());
            if (this.aMapNaviViewOptions.isTrafficLayerEnabled()) {
                this.routeTMC.setVisibility(0);
            } else {
                this.routeTMC.setVisibility(8);
            }
            if (!this.aMapNaviViewOptions.isRouteListButtonShow()) {
                this.checkBox.setVisibility(8);
            } else if (!this.isCarLock) {
                this.checkBox.setVisibility(0);
            }
            if (this.aMapNaviViewOptions.isNaviNight()) {
                this.aMap.setMapType(3);
            } else {
                this.aMap.setMapType(1);
            }
            if (this.aMapNaviViewOptions.isTrafficLine()) {
                this.uiController.m3865c(true);
            } else {
                this.uiController.m3865c(false);
            }
            this.uiController.m3855a(this.aMapNaviViewOptions.getLeaderLineColor());
            Bitmap startMarker = this.aMapNaviViewOptions.getStartMarker();
            Bitmap endtMarker = this.aMapNaviViewOptions.getEndtMarker();
            Bitmap wayMarker = this.aMapNaviViewOptions.getWayMarker();
            Bitmap monitorMarker = this.aMapNaviViewOptions.getMonitorMarker();
            this.uiController.m3857a(startMarker);
            this.uiController.m3861b(endtMarker);
            this.uiController.m3864c(wayMarker);
            this.uiController.m3867d(monitorMarker);
            this.uiController.m3862b(this.aMapNaviViewOptions.isMonitorCameraEnable());
            this.aMapNavi.getNaviSetting().m3850d(this.aMapNaviViewOptions.isScreenAlwaysBright());
            this.aMapNavi.getNaviSetting().m3848b(this.aMapNaviViewOptions.isTrafficInfoUpdateEnabled());
            this.aMapNavi.getNaviSetting().m3849c(this.aMapNaviViewOptions.isCameraInfoUpdateEnable());
            this.aMapNavi.getNaviSetting().m3851e(this.aMapNaviViewOptions.isMonitorCameraEnable());
            boolean isSettingMenuenable = this.aMapNaviViewOptions.isSettingMenuenable();
            this.aMapNavi.setReCalculateRouteForYaw(this.aMapNaviViewOptions.isReCalculateRouteForYaw());
            this.aMapNavi.setReCalculateRouteForTrafficJam(this.aMapNaviViewOptions.isReCalculateRouteForTrafficJam());
            if (isSettingMenuenable) {
                this.navigation_down_line.setVisibility(0);
                this.navi_setting.setVisibility(0);
            } else {
                this.navigation_down_line.setVisibility(8);
                this.navi_setting.setVisibility(8);
            }
            Drawable drawable;
            switch (this.aMapNaviViewOptions.getNaviViewTopic()) {
                case 0:
                    this.nextRoadName.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837598));
                    this.remainDisAndTime.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837598));
                    this.direction_layout.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837587));
                    this.nextRoadDis.setTextColor(-1);
                    this.nextRoadName.setTextColor(-1);
                    this.remainDisAndTime.setTextColor(-1);
                    this.footer_linearlayout.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837591));
                    drawable = C0617g.m4842a().getDrawable(2130837611);
                    this.navigation_down_line.setBackgroundDrawable(drawable);
                    this.navigation_back_down_line.setBackgroundDrawable(drawable);
                    this.navi_back.setImageDrawable(C0617g.m4842a().getDrawable(2130837645));
                    this.navi_setting.setImageDrawable(C0617g.m4842a().getDrawable(2130837647));
                    this.curRoadName.setTextColor(-1);
                    this.navigation_go_on.setTextColor(-1);
                    this.uiController.m3858a("#ffffff", "#ffffff");
                    return;
                case 1:
                    this.nextRoadName.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837599));
                    this.remainDisAndTime.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837599));
                    this.direction_layout.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837588));
                    this.nextRoadDis.setTextColor(-1);
                    this.nextRoadName.setTextColor(-1);
                    this.remainDisAndTime.setTextColor(-1);
                    this.footer_linearlayout.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837592));
                    drawable = C0617g.m4842a().getDrawable(2130837610);
                    this.navigation_down_line.setBackgroundDrawable(drawable);
                    this.navigation_back_down_line.setBackgroundDrawable(drawable);
                    this.navi_back.setImageDrawable(C0617g.m4842a().getDrawable(2130837644));
                    this.navi_setting.setImageDrawable(C0617g.m4842a().getDrawable(2130837646));
                    this.curRoadName.setTextColor(Color.parseColor("#007aff"));
                    this.navigation_go_on.setTextColor(Color.parseColor("#007aff"));
                    this.uiController.m3858a("#007aff", "#28303b");
                    return;
                case 2:
                    this.nextRoadName.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837600));
                    this.remainDisAndTime.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837600));
                    this.direction_layout.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837589));
                    this.nextRoadDis.setTextColor(-1);
                    this.nextRoadName.setTextColor(-1);
                    this.remainDisAndTime.setTextColor(-1);
                    this.footer_linearlayout.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837592));
                    drawable = C0617g.m4842a().getDrawable(2130837610);
                    this.navigation_down_line.setBackgroundDrawable(drawable);
                    this.navigation_back_down_line.setBackgroundDrawable(drawable);
                    this.navi_back.setImageDrawable(C0617g.m4842a().getDrawable(2130837644));
                    this.navi_setting.setImageDrawable(C0617g.m4842a().getDrawable(2130837646));
                    this.curRoadName.setTextColor(Color.parseColor("#ec3a8a"));
                    this.navigation_go_on.setTextColor(Color.parseColor("#ec3a8a"));
                    this.uiController.m3858a("#ec3a8a", "#28303b");
                    return;
                case 3:
                    this.nextRoadName.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837601));
                    this.remainDisAndTime.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837601));
                    this.direction_layout.setBackgroundDrawable(C0617g.m4842a().getDrawable(2130837590));
                    this.nextRoadDis.setTextColor(-16777216);
                    this.nextRoadName.setTextColor(-16777216);
                    this.remainDisAndTime.setTextColor(-16777216);
                    drawable = C0617g.m4842a().getDrawable(2130837592);
                    Drawable drawable2 = C0617g.m4842a().getDrawable(2130837610);
                    this.navigation_down_line.setBackgroundDrawable(drawable2);
                    this.navigation_back_down_line.setBackgroundDrawable(drawable2);
                    this.footer_linearlayout.setBackgroundDrawable(drawable);
                    this.navi_back.setImageDrawable(C0617g.m4842a().getDrawable(2130837644));
                    this.navi_setting.setImageDrawable(C0617g.m4842a().getDrawable(2130837646));
                    this.curRoadName.setTextColor(Color.parseColor("#007aff"));
                    this.navigation_go_on.setTextColor(Color.parseColor("#007aff"));
                    this.uiController.m3858a("#007aff", "#28303b");
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    private int getPixel(int i) {
        Context context = getContext();
        if (i == 0) {
            return 0;
        }
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            this.mapView.onCreate(bundle);
            this.aMap = this.mapView.getMap();
            this.aMap.getUiSettings().setZoomControlsEnabled(false);
            checkViewOptions();
            initListener();
            buildScreenInfo();
            setConfigurationChanged(this.isLandscape);
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public final void onResume() {
        try {
            this.mapView.onResume();
            buildScreenInfo();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            this.mapView.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            this.aMapNavi.stopNavi();
            this.aMapNavi.removeAMapNaviListener(this.uiController);
            this.uiController.m3868e();
            this.mapView.onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            this.mapView.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onMapLoaded() {
        try {
            this.mapHeight = this.mapView.getHeight();
            this.mapWidth = this.mapView.getWidth();
            if (!(this.mapHeight == 0 || this.mapWidth == 0)) {
                this.aMap.setPointToCenter(this.mapWidth / 2, (this.mapHeight / 3) * 2);
            }
            this.uiController.m3854a();
            this.uiController.m3860b();
            changeCamere();
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    private void changeCamere() {
        this.aMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.aMap.getCameraPosition().target, (float) this.LOCK_ZOOM, (float) this.LOCK_TILT, 0.0f)));
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        try {
            if (cameraPosition.bearing == 0.0f || cameraPosition.bearing == 360.0f) {
                this.direction.setVisibility(4);
                this.direction_hori.setVisibility(4);
            } else if (this.aMapNaviViewOptions.isCompassEnabled()) {
                if (this.isLandscape) {
                    this.direction_hori.setVisibility(0);
                } else {
                    this.direction.setVisibility(0);
                }
            }
            this.direction.setDriectionMatrix(360.0f - cameraPosition.bearing);
            this.direction_hori.setDriectionMatrix(360.0f - cameraPosition.bearing);
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
    }

    private void showDialog() {
        try {
            new Builder(getContext()).setTitle("提示").setMessage("确定退出导航?").setPositiveButton("确定", new C04452(this)).setNegativeButton("取消", new C04441(this)).show();
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void onTouch(MotionEvent motionEvent) {
        try {
            this.mHandler.sendEmptyMessage(4);
            this.mHandler.removeMessages(0);
            this.mHandler.sendEmptyMessageDelayed(0, this.lockMapDelayed);
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    void setCarLock(boolean z) {
        int i = 0;
        try {
            if (!(this.settingListener == null || this.isCarLock == z || this.isArrivedEnd)) {
                this.settingListener.onLockMap(z);
            }
            if (!this.isLandscape) {
                this.footerLayout.setVisibility(0);
            } else if (z) {
                this.footerLayout.setVisibility(4);
            } else {
                this.footerLayout.setVisibility(0);
            }
            if (!this.isArrivedEnd) {
                int i2;
                this.isCarLock = z;
                if (this.settingListener != null) {
                    if (z) {
                        this.settingListener.onNaviMapMode(0);
                    } else {
                        this.settingListener.onNaviMapMode(1);
                    }
                }
                if (z) {
                    this.isAllRoute = false;
                    this.aMap.moveCamera(CameraUpdateFactory.zoomBy(this.zoom));
                } else {
                    this.zoom = this.aMap.getCameraPosition().zoom;
                    this.mHandler.removeMessages(0);
                    this.mHandler.sendEmptyMessageDelayed(0, this.lockMapDelayed);
                }
                this.uiController.m3859a(z);
                FrameLayout frameLayout = this.navi_car_layout;
                if (z) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                frameLayout.setVisibility(i2);
                frameLayout = this.show_naving_info;
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                frameLayout.setVisibility(i2);
                Button button = this.zoomout;
                if (z) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                button.setVisibility(i2);
                button = this.zoomin;
                if (z) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                button.setVisibility(i2);
                if (this.aMapNaviViewOptions.isRouteListButtonShow()) {
                    CheckBox checkBox = this.checkBox;
                    if (z) {
                        i2 = 8;
                    } else {
                        i2 = 0;
                    }
                    checkBox.setVisibility(i2);
                }
                if (this.aMapNaviViewOptions.isTrafficBarEnabled() && this.aMapNavi.getEngineType() == 0) {
                    C0465b c0465b = this.tmc_info;
                    if (!z) {
                        i = 8;
                    }
                    c0465b.setVisibility(i);
                }
                requestLayout();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void onClick(View view) {
        boolean z = true;
        try {
            if (2131427375 == view.getId()) {
                this.mHandler.sendEmptyMessage(0);
            }
            if (2131427360 == view.getId()) {
                boolean isTrafficEnabled = this.aMap.isTrafficEnabled();
                if (isTrafficEnabled) {
                    this.routeTMC.setBackgroundDrawable(this.trafficClose);
                } else {
                    this.routeTMC.setBackgroundDrawable(this.trafficOpen);
                }
                this.aMap.setTrafficEnabled(!isTrafficEnabled);
                if (this.uiController != null) {
                    C0454g c0454g = this.uiController;
                    if (isTrafficEnabled) {
                        z = false;
                    }
                    c0454g.m3865c(z);
                }
            }
            if (2131427365 == view.getId()) {
                if (this.isAllRoute) {
                    this.checkBox.setChecked(false);
                    this.mHandler.sendEmptyMessage(0);
                } else {
                    this.checkBox.setChecked(true);
                    this.mHandler.sendEmptyMessage(4);
                    this.uiController.m3863c();
                    this.isAllRoute = true;
                }
                if (this.settingListener != null) {
                    this.settingListener.onScanViewButtonClick();
                }
            }
            if (2131427378 == view.getId()) {
                this.mHandler.sendEmptyMessage(1);
            }
            if (2131427368 == view.getId()) {
                this.mHandler.sendEmptyMessage(2);
            }
            if (2131427350 == view.getId() && this.settingListener != null) {
                this.settingListener.onNaviTurnClick();
            }
            if (this.direction.equals(view)) {
                this.aMap.animateCamera(CameraUpdateFactory.changeBearing(0.0f));
                this.mHandler.sendEmptyMessage(4);
                this.mHandler.removeMessages(0);
                this.mHandler.sendEmptyMessageDelayed(0, this.lockMapDelayed);
            }
            if (this.direction_hori.equals(view)) {
                this.aMap.animateCamera(CameraUpdateFactory.changeBearing(0.0f));
                this.mHandler.sendEmptyMessage(4);
                this.mHandler.removeMessages(0);
                this.mHandler.sendEmptyMessageDelayed(0, this.lockMapDelayed);
            }
            if (this.zoomin.equals(view)) {
                setCarLock(false);
                this.aMap.animateCamera(CameraUpdateFactory.zoomIn());
                this.zoom -= 1.0f;
            }
            if (this.zoomout.equals(view)) {
                setCarLock(false);
                this.aMap.animateCamera(CameraUpdateFactory.zoomOut());
                this.zoom += 1.0f;
            }
            if (this.curRoadName.equals(view) && this.settingListener != null) {
                this.settingListener.onNextRoadClick();
            }
            if (this.roadsign.equals(view)) {
                this.roadSignClickCount++;
                if (this.roadSignClickCount > 2) {
                    this.roadSignClickCount = 0;
                    showDebugInfo();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    private void showDebugInfo() {
        if (this.uiController != null) {
            this.uiController.m3866d();
        }
    }

    public void setAMapNaviViewListener(AMapNaviViewListener aMapNaviViewListener) {
        this.settingListener = aMapNaviViewListener;
    }

    void arrivedEnd() {
        this.isArrivedEnd = true;
        this.cur_road_layout.setVisibility(0);
        this.navi_car_layout.setVisibility(8);
        this.navigation_down_line.setVisibility(8);
        this.navi_setting.setVisibility(8);
        this.direction_layout.setVisibility(8);
        this.show_naving_info.setVisibility(8);
        this.tmc_info.setVisibility(8);
        this.routeTMC.setVisibility(8);
        this.nextRoadName.setVisibility(8);
        this.checkBox.setVisibility(8);
        this.remainDisAndTime.setVisibility(8);
    }

    void initLayout() {
        this.cur_road_layout.setVisibility(8);
        this.navigation_down_line.setVisibility(0);
        this.navi_setting.setVisibility(0);
        this.direction_layout.setVisibility(0);
        this.navi_car_layout.setVisibility(8);
        this.nextRoadName.setVisibility(0);
        this.show_naving_info.setVisibility(0);
        this.routeTMC.setVisibility(0);
        this.tmc_info.setVisibility(0);
        this.zoomout.setVisibility(8);
        this.zoomin.setVisibility(8);
        this.checkBox.setVisibility(8);
        setConfigurationChanged(this.isLandscape);
    }

    public boolean isShowRoadEnlarge() {
        return false;
    }

    public int getAutoNaviTitleLeftMargin() {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        LinearLayout linearLayout = null;
        if ((!isOrientationLandscape() || this.naviLatout == null) && this.naviLatout != null) {
            linearLayout = (LinearLayout) this.naviLatout.findViewById(2131427349);
        }
        if (linearLayout == null) {
            return 0;
        }
        linearLayout.measure(makeMeasureSpec, makeMeasureSpec2);
        return linearLayout.getMeasuredWidth();
    }

    public boolean isOrientationLandscape() {
        return this.isLandscape;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        try {
            if (this.mapHeight != this.mapView.getHeight() || this.mapWidth != this.mapView.getWidth()) {
                this.mapHeight = this.mapView.getHeight();
                this.mapWidth = this.mapView.getWidth();
                this.aMap.setPointToCenter(this.mapWidth / 2, (this.mapHeight / 3) * 2);
                this.uiController.m3856a(this.mapHeight, this.mapWidth);
                if (this.mDriveWayView != null) {
                    this.mDriveWayView.setBitmapPosition(this.nWidth, this.nHeight);
                    this.mDriveWayView.invalidate();
                }
                if (this.tmc_info != null) {
                    int dimensionPixelSize = C0617g.m4842a().getDimensionPixelSize(C0641R.id.bt_filechooser_home);
                    if (dimensionPixelSize == 0) {
                        dimensionPixelSize = C0615f.m4825a(getContext(), 33);
                    }
                    this.tmc_info.m3949a(this.mapWidth, this.mapHeight, this.nWidth, this.nHeight, dimensionPixelSize, isOrientationLandscape(), true);
                    doAddTMCChartLayoutToMap();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void doAddTMCChartLayoutToMap() {
        if (this.tmc_info == null) {
            this.tmc_info = new C0465b(getContext());
        }
        this.container.removeView(this.tmc_info);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        int height = this.tmc_info.m3948a().getHeight();
        if (isOrientationLandscape()) {
            height = (((this.tmc_info.m3954d() * 2) / 3) - height) >> 1;
        } else {
            height = (this.tmc_info.m3954d() - height) >> 1;
        }
        layoutParams.setMargins(this.tmc_info.m3952b(), height + this.tmc_info.m3953c(), 0, 0);
        this.container.addView(this.tmc_info, layoutParams);
    }

    private void setMapLayoutParams(int i) {
        if (this.isLayOutVisible || i == 0) {
            LayoutParams layoutParams = (LayoutParams) this.mapView.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, getPixel(i));
            this.mapView.setLayoutParams(layoutParams);
        }
    }

    private void setZoomLayoutParams(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) this.zoom_layout.getLayoutParams();
        layoutParams.setMargins(getPixel(i), getPixel(i2), getPixel(i3), getPixel(i4));
        this.zoom_layout.setLayoutParams(layoutParams);
    }

    private void setLayOutVisible(boolean z) {
        this.isLayOutVisible = z;
        if (this.isLayOutVisible) {
            this.footer_linearlayout.setVisibility(0);
            this.zoom_layout.setVisibility(0);
            this.roadsign_layout.setVisibility(0);
            this.roadname_layout.setVisibility(0);
            if (this.isLandscape) {
                setMapLayoutParams(0);
                return;
            } else {
                setMapLayoutParams(40);
                return;
            }
        }
        this.footer_linearlayout.setVisibility(4);
        this.zoom_layout.setVisibility(4);
        this.roadsign_layout.setVisibility(4);
        this.roadname_layout.setVisibility(4);
        setMapLayoutParams(0);
    }

    private void setZoomVisible(boolean z) {
        this.isZoomVisible = z;
        if (this.isZoomVisible) {
            this.zoom_layout.setVisibility(0);
        } else {
            this.zoom_layout.setVisibility(4);
        }
    }
}
