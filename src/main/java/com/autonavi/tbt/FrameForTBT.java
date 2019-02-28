package com.autonavi.tbt;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.C0443e;
import com.amap.api.navi.C0457h;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.C0461c;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

public class FrameForTBT implements IFrameForTBT {
    AMapNaviInfo aMapNaviInfo = new AMapNaviInfo();
    private int arrayWayId = -1;
    private byte[] backInfo;
    Camera[] camera;
    int cameraIndex = -1;
    int errorcode = 0;
    private byte[] frontInfo;
    private boolean isGpsOpen = false;
    private boolean isReCalculateRouteForTrafficJam = false;
    private boolean isReCalculateRouteForYaw = true;
    private Context mContext;
    private C0596a mHandler = new C0596a(this);
    private List<AMapNaviListener> mNaviListener;
    private C0457h m_stTbt;
    NaviInfo naviInfo;
    private C0461c naviLocation;
    private int navitype = -1;
    private StringBuffer playBuff = new StringBuffer();
    private int soundtype = 1;

    /* renamed from: com.autonavi.tbt.FrameForTBT$a */
    class C0596a extends Handler {
        /* renamed from: a */
        final /* synthetic */ FrameForTBT f3656a;

        C0596a(FrameForTBT frameForTBT) {
            this.f3656a = frameForTBT;
        }

        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (this.f3656a.mNaviListener != null) {
                    int i;
                    switch (message.what) {
                        case 0:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onNaviInfoUpdate(this.f3656a.naviInfo);
                                if (this.f3656a.naviInfo != null) {
                                    AMapNaviInfo aMapNaviInfo = new AMapNaviInfo();
                                    aMapNaviInfo.setPathRemainDistance(this.f3656a.naviInfo.getPathRetainDistance());
                                    aMapNaviInfo.setPathRemainTime(this.f3656a.naviInfo.getPathRetainTime());
                                    ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onNaviInfoUpdated(aMapNaviInfo);
                                }
                            }
                            return;
                        case 1:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onGetNavigationText(this.f3656a.soundtype, this.f3656a.playBuff.toString());
                            }
                            return;
                        case 2:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onEndEmulatorNavi();
                            }
                            return;
                        case 3:
                            if (this.f3656a.arrayWayId < 0) {
                                return;
                            }
                            if (this.f3656a.arrayWayId == 0) {
                                for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                    ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onArriveDestination();
                                }
                                return;
                            }
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onArrivedWayPoint(this.f3656a.arrayWayId);
                            }
                            return;
                        case 4:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onReCalculateRouteForYaw();
                            }
                            return;
                        case 5:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onReCalculateRouteForTrafficJam();
                            }
                            return;
                        case 6:
                            if (this.f3656a.naviLocation != null) {
                                for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                    if (this.f3656a.naviLocation != null) {
                                        ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onLocationChange(this.f3656a.naviLocation.f2771a);
                                    }
                                }
                                return;
                            }
                            return;
                        case 7:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onTrafficStatusUpdate();
                            }
                            return;
                        case 8:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onInitNaviSuccess();
                            }
                            return;
                        case 9:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onInitNaviFailure();
                            }
                            return;
                        case 10:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onStartNavi(this.f3656a.navitype);
                            }
                            return;
                        case 11:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onCalculateRouteSuccess();
                            }
                            return;
                        case 12:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onCalculateRouteFailure(this.f3656a.errorcode);
                            }
                            return;
                        case 13:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3656a.mNaviListener.get(i)).onGpsOpenStatus(this.f3656a.isGpsOpen);
                            }
                            return;
                        case 14:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                if (this.f3656a.mNaviListener.get(i) instanceof C0443e) {
                                    ((C0443e) this.f3656a.mNaviListener.get(i)).showLaneInfo(this.f3656a.backInfo, this.f3656a.frontInfo);
                                }
                            }
                            return;
                        case 15:
                            for (i = 0; i < this.f3656a.mNaviListener.size(); i++) {
                                if (this.f3656a.mNaviListener.get(i) instanceof C0443e) {
                                    ((C0443e) this.f3656a.mNaviListener.get(i)).hideLaneInfo();
                                }
                            }
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
        }
    }

    public void setReCalculateRouteForYaw(boolean z) {
        this.isReCalculateRouteForYaw = z;
    }

    public void setReCalculateRouteForTrafficJam(boolean z) {
        this.isReCalculateRouteForTrafficJam = z;
    }

    public FrameForTBT(Context context, C0457h c0457h) {
        this.mContext = context;
        this.m_stTbt = c0457h;
        this.mNaviListener = new ArrayList();
    }

    public void requestHttp(int i, int i2, int i3, String str, String str2, byte[] bArr, int i4) {
        try {
            if (this.m_stTbt != null && this.m_stTbt.f2748c != null) {
                this.m_stTbt.f2748c.m4808a(new C0613d(this.m_stTbt, this.mContext, str, i3, str2, i, i2, bArr, i4));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public NaviInfo getNaviInfo() {
        return this.naviInfo;
    }

    public void setGpsValid(int i) {
    }

    public void updateNaviInfo(DGNaviInfo dGNaviInfo) {
        if (dGNaviInfo != null) {
            try {
                this.naviInfo = new NaviInfo(dGNaviInfo);
                if (dGNaviInfo.m_CameraDist != -1 && dGNaviInfo.m_CameraIndex >= 0) {
                    this.camera = this.m_stTbt.m3916m().getAllCamera();
                    this.cameraIndex = dGNaviInfo.m_CameraIndex;
                    if (this.camera != null && this.cameraIndex < this.camera.length) {
                        NaviLatLng naviLatLng = new NaviLatLng();
                        naviLatLng.setLatitude(this.camera[this.cameraIndex].m_Latitude);
                        naviLatLng.setLongitude(this.camera[this.cameraIndex].m_Longitude);
                        this.naviInfo.setCameraCoord(naviLatLng);
                        this.naviInfo.setLimitSpeed(this.camera[this.cameraIndex].m_CameraSpeed);
                        this.naviInfo.setCameraType(this.camera[this.cameraIndex].m_CameraType);
                    }
                }
                if (this.mHandler != null) {
                    this.mHandler.sendEmptyMessage(0);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
        }
    }

    public void showCross(int i, byte[] bArr, byte[] bArr2, int i2, int i3) {
        if (i == 1) {
        }
        if (i != 2) {
        }
    }

    public void hideCross() {
    }

    public void showLaneInfo(byte[] bArr, byte[] bArr2) {
        this.backInfo = bArr;
        this.frontInfo = bArr2;
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(14);
        }
    }

    public void hideLaneInfo() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(15);
        }
    }

    public void playNaviSound(int i, String str) {
        try {
            if (this.playBuff != null) {
                this.playBuff.delete(0, this.playBuff.length());
            } else {
                this.playBuff = new StringBuffer();
            }
            if (i == 8) {
                this.playBuff.append(bi_常量类.f6358b);
            } else {
                this.playBuff.append(str);
            }
            this.soundtype = i;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void endEmulatorNavi() {
        try {
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void arriveWay(int i) {
        try {
            this.arrayWayId = i;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void offRoute() {
        boolean z = true;
        try {
            if (this.isReCalculateRouteForYaw) {
                C0615f.m4835a("offRoute");
                z = this.m_stTbt.m3899c(-1);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(4);
            }
            if (!z) {
                this.errorcode = 3;
                this.mHandler.sendEmptyMessage(12);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void routeDestroy() {
        try {
            if (this.m_stTbt != null) {
                this.m_stTbt.m3919p();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void carLocationChange(CarLocation carLocation) {
        if (carLocation != null) {
            try {
                this.naviLocation = new C0461c();
                this.naviLocation.m3924a((float) carLocation.m_CarDir);
                this.naviLocation.m3928b((float) carLocation.m_Speed);
                this.naviLocation.m3925a(carLocation.m_MatchStatus);
                this.naviLocation.m3927a(new NaviLatLng(carLocation.m_Latitude, carLocation.m_Longitude));
                this.naviLocation.m3926a(System.currentTimeMillis());
                if (this.mHandler != null) {
                    this.mHandler.sendEmptyMessage(6);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
        }
    }

    public void setRouteRequestState(int i) {
        try {
            this.errorcode = i;
            switch (i) {
                case 1:
                    int f;
                    C0615f.m4835a("setRouteRequestState errorcod = " + this.errorcode);
                    if (this.m_stTbt != null) {
                        f = this.m_stTbt.m3906f(0);
                    } else {
                        f = -1;
                    }
                    if (this.mNaviListener != null) {
                        if (f == -1) {
                            this.mHandler.sendEmptyMessage(12);
                            break;
                        } else {
                            this.mHandler.sendEmptyMessage(11);
                            break;
                        }
                    }
                    break;
            }
            if (i != 1) {
                this.mHandler.sendEmptyMessage(12);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void tmcUpdate() {
        try {
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void showTrafficPanel(int i, byte[] bArr) {
    }

    public void hideTrafficPanel() {
    }

    public void rerouteForTMC(int i, int i2, int i3) {
        try {
            if (!(!this.isReCalculateRouteForTrafficJam || this.m_stTbt == null || i == 0)) {
                if (this.m_stTbt.m3908g(i) == 1) {
                    this.m_stTbt.m3906f(i);
                }
                if (this.mHandler != null) {
                    this.mHandler.sendEmptyMessage(11);
                }
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void tmcUpdate(int i, int i2, int i3) {
        try {
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void showTrafficPanel(byte[] bArr) {
    }

    public int getPlayState() {
        return 0;
    }

    public void lockScreenNaviTips(String str, int i, int i2) {
    }

    public void notifyMessage(int i, int i2, int i3, String str) {
        if (i == 8 && i2 == 1 && i3 == 1) {
            playNaviSound(8, bi_常量类.f6358b);
        }
    }

    public void initSuccess() {
        try {
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(8);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void initFailure() {
        try {
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(9);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void setAMapNaviListener(AMapNaviListener aMapNaviListener) {
        if (aMapNaviListener != null) {
            try {
                if (this.mNaviListener != null && !this.mNaviListener.contains(aMapNaviListener)) {
                    this.mNaviListener.add(aMapNaviListener);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
        }
    }

    public void removeNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.mNaviListener != null) {
                this.mNaviListener.remove(aMapNaviListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void destroy() {
        try {
            if (this.mNaviListener != null) {
                this.mNaviListener.clear();
                this.mNaviListener = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void onStartNavi(int i) {
        try {
            this.navitype = i;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(10);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void onGpsOpenStatus(boolean z) {
        try {
            this.isGpsOpen = z;
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(13);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public int matchRouteChanged(int i) {
        return 0;
    }

    public void offRoute(int i) {
        boolean z = true;
        try {
            if (this.isReCalculateRouteForYaw) {
                C0615f.m4835a("offRoute status");
                z = this.m_stTbt.m3899c(-1);
            }
            if (i != 2) {
                if (this.mHandler != null) {
                    this.mHandler.sendEmptyMessage(4);
                }
                if (!z) {
                    this.errorcode = 3;
                    this.mHandler.sendEmptyMessage(12);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void updateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    public void updateServiceFacility(ServiceFacilityInfo[] serviceFacilityInfoArr) {
    }

    public void updateCameraInfo(ViewCameraInfo[] viewCameraInfoArr) {
    }

    public void updateTrack(TrackPosition[] trackPositionArr) {
    }
}
