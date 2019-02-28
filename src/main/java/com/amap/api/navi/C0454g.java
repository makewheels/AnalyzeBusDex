package com.amap.api.navi;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.C0464a;
import com.amap.api.navi.view.C0467c;
import com.amap.api.navi.view.C0468d;
import com.amap.api.navi.view.RouteOverLay;
import com.autonavi.tbt.C0615f;
import com.autonavi.tbt.C0617g;
import java.util.List;
import p054u.aly.bi_常量类;

/* compiled from: NaviUIController */
/* renamed from: com.amap.api.navi.g */
public class C0454g implements C0443e {
    /* renamed from: a */
    public static final String[] f2719a = new String[]{"无", "自车", "左转", "右转", "左前方行驶", "右前方行驶", "左后方行驶", "右后方行驶", "左转掉头", "直行", "到达途经点", "进入环岛", "驶出环岛", "到达服务区", "到达收费站", "到达目的地", "进入隧道", "通过人行横道图标", "通过过街天桥", "通过地下通道"};
    /* renamed from: b */
    static final int[] f2720b = new int[]{2130837511, 2130837511, 2130837630, 2130837631, 2130837632, 2130837633, 2130837634, 2130837635, 2130837636, 2130837637, 2130837620, 2130837621, 2130837622, 2130837623, 2130837624, 2130837625, 2130837626, 2130837627, 2130837628, 2130837629};
    /* renamed from: c */
    NaviInfo f2721c;
    /* renamed from: d */
    String f2722d = "#ffffff";
    /* renamed from: e */
    String f2723e = "#ffffff";
    /* renamed from: f */
    ProgressDialog f2724f;
    /* renamed from: g */
    int f2725g = AMapNavi.EmulatorNaviMode;
    /* renamed from: h */
    List<AMapTrafficStatus> f2726h = null;
    /* renamed from: i */
    boolean f2727i = true;
    /* renamed from: j */
    Bitmap f2728j;
    /* renamed from: k */
    private RouteOverLay f2729k;
    /* renamed from: l */
    private C0467c f2730l;
    /* renamed from: m */
    private C0464a f2731m;
    /* renamed from: n */
    private C0468d f2732n;
    /* renamed from: o */
    private AMapNavi f2733o = null;
    /* renamed from: p */
    private AMap f2734p;
    /* renamed from: q */
    private Context f2735q;
    /* renamed from: r */
    private AMapNaviView f2736r;
    /* renamed from: s */
    private boolean f2737s = false;
    /* renamed from: t */
    private MapView f2738t;
    /* renamed from: u */
    private AMapNaviPath f2739u;
    /* renamed from: v */
    private AMapNaviLocation f2740v = null;
    /* renamed from: w */
    private int f2741w = -1;
    /* renamed from: x */
    private boolean f2742x = true;

    public C0454g(Context context, MapView mapView, AMapNaviView aMapNaviView) {
        if (aMapNaviView != null) {
            this.f2729k = new RouteOverLay(mapView.getMap(), null, context);
            this.f2730l = new C0467c(mapView);
            this.f2731m = new C0464a();
            this.f2733o = AMapNavi.getInstance(context);
            this.f2735q = context;
            this.f2736r = aMapNaviView;
            this.f2734p = mapView.getMap();
            this.f2738t = mapView;
        }
    }

    public void onArriveDestination() {
        if (this.f2725g != AMapNavi.EmulatorNaviMode) {
            if (this.f2729k != null) {
                this.f2729k.removeFromMap();
            }
            if (this.f2731m != null) {
                this.f2731m.m3946a(false);
            }
            m3859a(false);
            this.f2736r.arrivedEnd();
            this.f2740v = null;
            this.f2721c = null;
            if (this.f2730l != null) {
                this.f2730l.m3967c();
            }
        }
    }

    public void onArrivedWayPoint(int i) {
    }

    public void onCalculateRouteFailure(int i) {
        m3853g();
    }

    public void onCalculateRouteSuccess() {
        if (this.f2734p != null && this.f2733o != null) {
            m3853g();
            m3860b();
            m3854a();
            this.f2741w = -1;
        }
    }

    /* renamed from: a */
    void m3854a() {
        if (this.f2733o != null) {
            this.f2739u = this.f2733o.getNaviPath();
        }
        if (this.f2739u != null && this.f2736r.tmc_info != null) {
            int allLength = this.f2739u.getAllLength();
            if (this.f2721c != null) {
                allLength = this.f2721c.getPathRetainDistance();
            }
            this.f2726h = this.f2733o.getTrafficStatuses(this.f2739u.getAllLength() - allLength, this.f2739u.getAllLength());
            if (this.f2721c == null) {
                this.f2736r.tmc_info.m3950a(this.f2726h, this.f2739u.getAllLength());
            } else {
                this.f2736r.tmc_info.m3950a(this.f2726h, this.f2721c.getPathRetainDistance());
            }
            this.f2736r.tmc_info.invalidate();
        }
    }

    /* renamed from: b */
    void m3860b() {
        this.f2739u = this.f2733o.getNaviPath();
        if (this.f2739u != null) {
            if (this.f2729k != null) {
                this.f2729k.setRouteInfo(this.f2739u);
                this.f2729k.addToMap();
            }
            LatLng latLng = null;
            if (!(this.f2739u.getStartPoint() == null || this.f2739u.getEndPoint() == null)) {
                latLng = new LatLng(this.f2739u.getStartPoint().getLatitude(), this.f2739u.getStartPoint().getLongitude());
            }
            if (latLng != null) {
                this.f2730l.m3959a();
                this.f2730l.m3962a(this.f2734p, latLng, 0.0f, 51.0f);
                if (this.f2739u.getEndPoint() != null) {
                    this.f2730l.m3963a(new LatLng(this.f2739u.getEndPoint().getLatitude(), this.f2739u.getEndPoint().getLongitude()));
                }
            }
            if (this.f2736r.remainDis != null) {
                this.f2736r.remainDis.setText(Html.fromHtml(C0615f.m4830a(this.f2739u.getAllLength(), this.f2722d, this.f2723e)));
            }
            if (this.f2736r.remainTime != null) {
                this.f2736r.remainTime.setText(Html.fromHtml(C0615f.m4832a(C0615f.m4839b(this.f2739u.getAllTime()), this.f2722d, this.f2723e)));
            }
        }
    }

    /* renamed from: c */
    void m3863c() {
        if (this.f2729k != null) {
            this.f2729k.setRouteInfo(this.f2739u);
            this.f2729k.zoomToSpan();
        }
    }

    public void onEndEmulatorNavi() {
        if (this.f2731m != null) {
            this.f2731m.m3946a(false);
        }
    }

    public void onGetNavigationText(int i, String str) {
    }

    public void onInitNaviFailure() {
    }

    public void onInitNaviSuccess() {
    }

    /* renamed from: d */
    public void m3866d() {
        this.f2729k.setEmulateGPSLocationVisible();
    }

    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
        this.f2740v = aMapNaviLocation;
        if (this.f2736r.isArrivedEnd) {
            float bearing = aMapNaviLocation.getBearing();
            if (this.f2730l != null) {
                this.f2730l.m3962a(this.f2734p, new LatLng(aMapNaviLocation.getCoord().getLatitude(), aMapNaviLocation.getCoord().getLongitude()), bearing, 51.0f);
            }
        } else if (this.f2740v != null && this.f2721c != null) {
            if (AMapNavi.getInstance(this.f2735q).getEngineType() == 1 && AMapNavi.getInstance(this.f2735q).getNaviType() == 1) {
                LatLng latLng = new LatLng(this.f2721c.getCoord().getLatitude(), this.f2721c.getCoord().getLongitude());
                LatLng latLng2 = new LatLng(this.f2740v.getCoord().getLatitude(), this.f2740v.getCoord().getLongitude());
                if (this.f2740v.isMatchNaviPath()) {
                    this.f2729k.drawGuideLink(latLng2, latLng, false);
                } else {
                    this.f2729k.drawGuideLink(latLng2, latLng, true);
                }
            }
            NaviLatLng coord = this.f2740v.getCoord();
            float bearing2 = this.f2740v.getBearing();
            LatLng latLng3 = new LatLng(coord.getLatitude(), coord.getLongitude());
            if (this.f2730l != null) {
                this.f2730l.m3962a(this.f2734p, latLng3, bearing2, (float) this.f2721c.getCurStepRetainDistance());
            }
        }
    }

    public void onNaviInfoUpdate(NaviInfo naviInfo) {
        if (naviInfo != null) {
            C0615f.m4835a("onNaviInfoUpdate");
            if (this.f2741w != naviInfo.getCurStep()) {
                try {
                    List arrowPoints = this.f2729k.getArrowPoints(naviInfo.getCurStep());
                    if (arrowPoints != null && arrowPoints.size() > 0) {
                        this.f2729k.drawArrow(arrowPoints);
                        this.f2741w = naviInfo.getCurStep();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f2721c = naviInfo;
            NaviLatLng coord = naviInfo.getCoord();
            float direction = (float) naviInfo.getDirection();
            LatLng latLng = new LatLng(coord.getLatitude(), coord.getLongitude());
            if (this.f2730l != null && AMapNavi.getInstance(this.f2735q).getNaviType() == AMapNavi.EmulatorNaviMode) {
                this.f2730l.m3962a(this.f2734p, latLng, direction, (float) naviInfo.getCurStepRetainDistance());
            }
            if (this.f2736r != null) {
                if (this.f2733o.getEngineType() == 0 && naviInfo.getCameraDistance() > 0 && this.f2742x) {
                    if (naviInfo.getCameraCoord() != null) {
                        LatLng latLng2 = new LatLng(naviInfo.getCameraCoord().getLatitude(), naviInfo.getCameraCoord().getLongitude());
                        if (this.f2731m != null) {
                            this.f2731m.m3944a(this.f2734p, latLng2);
                        }
                    }
                    if (naviInfo.m_CameraType != 0 || naviInfo.m_CameraSpeed <= 0) {
                        this.f2736r.speedCamera.setVisibility(8);
                    } else {
                        this.f2736r.speedCamera.setText(bi_常量类.f6358b + naviInfo.m_CameraSpeed);
                        this.f2736r.speedCamera.setVisibility(0);
                    }
                    if (naviInfo.m_CameraType == 1 || naviInfo.m_CameraType == 3) {
                        this.f2736r.electronicCamera.setVisibility(0);
                    } else {
                        this.f2736r.electronicCamera.setVisibility(8);
                    }
                } else {
                    if (this.f2731m != null) {
                        this.f2731m.m3946a(false);
                    }
                    if (this.f2736r.speedCamera != null) {
                        this.f2736r.speedCamera.setVisibility(8);
                    }
                    if (this.f2736r.electronicCamera != null) {
                        this.f2736r.electronicCamera.setVisibility(8);
                    }
                }
                if (this.f2736r.roadsign != null) {
                    this.f2736r.roadsign.setBackgroundDrawable(C0617g.m4842a().getDrawable(f2720b[naviInfo.getIconType()]));
                }
                if (this.f2736r.nextRoadDis != null) {
                    this.f2736r.nextRoadDis.setText(C0615f.m4829a(naviInfo.getCurStepRetainDistance()));
                }
                if (this.f2736r.nextRoadName != null) {
                    this.f2736r.nextRoadName.setText(naviInfo.getNextRoadName());
                }
                String b = C0615f.m4839b(naviInfo.getPathRetainTime());
                CharSequence fromHtml = Html.fromHtml(C0615f.m4832a(b, this.f2722d, this.f2723e));
                CharSequence fromHtml2 = Html.fromHtml(C0615f.m4830a(naviInfo.getPathRetainDistance(), this.f2722d, this.f2723e));
                CharSequence fromHtml3 = Html.fromHtml("<big>距离终点:</big><big><big>" + C0615f.m4831a(b) + " " + C0615f.m4829a(naviInfo.getPathRetainDistance()) + "</big></big>");
                if (this.f2736r.remainDisAndTime != null) {
                    this.f2736r.remainDisAndTime.setText(fromHtml3);
                }
                if (this.f2736r.remainDis != null) {
                    this.f2736r.remainDis.setText(fromHtml2);
                }
                if (this.f2736r.remainTime != null) {
                    this.f2736r.remainTime.setText(fromHtml);
                }
            }
        }
    }

    /* renamed from: a */
    void m3858a(String str, String str2) {
        this.f2722d = str;
        this.f2723e = str2;
        if (this.f2721c != null) {
            if (this.f2736r.remainDis != null) {
                this.f2736r.remainDis.setText(Html.fromHtml(C0615f.m4830a(this.f2721c.getPathRetainDistance(), this.f2722d, this.f2723e)));
            }
            if (this.f2736r.remainTime != null) {
                this.f2736r.remainTime.setText(Html.fromHtml(C0615f.m4832a(C0615f.m4839b(this.f2721c.getPathRetainTime()), this.f2722d, this.f2723e)));
            }
        }
    }

    public void onReCalculateRouteForTrafficJam() {
        this.f2721c = null;
        this.f2741w = -1;
    }

    public void onReCalculateRouteForYaw() {
        this.f2721c = null;
        this.f2741w = -1;
        if (this.f2736r.getViewOptions().isReCalculateRouteForYaw()) {
            m3852f();
        }
    }

    /* renamed from: f */
    private void m3852f() {
        if (this.f2724f == null) {
            this.f2724f = new ProgressDialog(this.f2735q);
        }
        this.f2724f.setProgressStyle(0);
        this.f2724f.setIndeterminate(false);
        this.f2724f.setCancelable(false);
        this.f2724f.setMessage("路线重新规划");
        this.f2724f.show();
    }

    /* renamed from: g */
    private void m3853g() {
        if (this.f2724f != null && this.f2724f.isShowing()) {
            this.f2724f.dismiss();
        }
    }

    public void onStartNavi(int i) {
        this.f2725g = i;
        this.f2736r.setCarLock(true);
        this.f2736r.initLayout();
        this.f2736r.checkViewOptions();
        this.f2736r.isArrivedEnd = false;
    }

    public void onTrafficStatusUpdate() {
        m3854a();
        if (this.f2737s) {
            m3865c(this.f2737s);
        }
    }

    /* renamed from: a */
    public void m3859a(boolean z) {
        if (this.f2727i != z) {
            this.f2727i = z;
            if (this.f2730l != null) {
                this.f2730l.m3964a(z);
            }
            if (!z) {
                return;
            }
            if (AMapNavi.getInstance(this.f2735q).getNaviType() == AMapNavi.EmulatorNaviMode) {
                onNaviInfoUpdate(this.f2721c);
            } else if (this.f2740v != null) {
                onLocationChange(this.f2740v);
            } else {
                this.f2740v = new AMapNaviLocation();
                if (this.f2721c != null) {
                    this.f2740v.setCoord(this.f2721c.getCoord());
                    this.f2740v.setBearing((float) this.f2721c.getDirection());
                }
                onLocationChange(this.f2740v);
            }
        }
    }

    /* renamed from: e */
    public void m3868e() {
        if (this.f2729k != null) {
            this.f2729k.destroy();
        }
        if (this.f2730l != null) {
            this.f2730l.m3965b();
        }
        if (this.f2731m != null) {
            this.f2731m.m3943a();
        }
        if (this.f2732n != null) {
            this.f2732n.m3968a();
        }
    }

    /* renamed from: a */
    public void m3857a(Bitmap bitmap) {
        if (this.f2729k != null && bitmap != null) {
            this.f2729k.setStartPointBitmap(bitmap);
        }
    }

    /* renamed from: b */
    public void m3861b(Bitmap bitmap) {
        if (this.f2729k != null && bitmap != null) {
            this.f2729k.setEndPointBitmap(bitmap);
        }
    }

    /* renamed from: c */
    public void m3864c(Bitmap bitmap) {
        if (this.f2729k != null && bitmap != null) {
            this.f2729k.setWayPointBitmap(bitmap);
        }
    }

    /* renamed from: d */
    public void m3867d(Bitmap bitmap) {
        this.f2728j = bitmap;
        if (this.f2728j != null) {
            this.f2731m.m3945a(BitmapDescriptorFactory.fromBitmap(this.f2728j));
        }
    }

    /* renamed from: b */
    public void m3862b(boolean z) {
        this.f2742x = z;
    }

    public void onGpsOpenStatus(boolean z) {
    }

    public void showLaneInfo(byte[] bArr, byte[] bArr2) {
        if (this.f2736r.isLayOutVisible && bArr != null && bArr2 != null && this.f2736r.mDriveWayView != null) {
            this.f2736r.mDriveWayView.loadDriveWayBitmap(bArr, bArr2);
            this.f2736r.mDriveWayView.setBitmapPosition(this.f2736r.nWidth, this.f2736r.nHeight);
            this.f2736r.mDriveWayView.setVisibility(0);
            this.f2736r.mDriveWayView.invalidate();
        }
    }

    public void hideLaneInfo() {
        if (this.f2736r.mDriveWayView != null) {
            this.f2736r.mDriveWayView.setVisibility(8);
        }
    }

    /* renamed from: c */
    void m3865c(boolean z) {
        this.f2737s = z;
        if (this.f2729k != null) {
            this.f2729k.setTrafficLine(Boolean.valueOf(this.f2737s));
        }
    }

    /* renamed from: a */
    void m3855a(int i) {
        if (this.f2730l != null) {
            this.f2730l.m3960a(i);
        }
    }

    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    /* renamed from: a */
    public void m3856a(int i, int i2) {
        if (this.f2730l != null) {
            this.f2730l.m3961a(i, i2);
        }
    }
}
