package com.autonavi.wtbt;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.C0457h;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.C0461c;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.C0614e;
import com.autonavi.tbt.C0615f;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

public class FrameForWTBT implements IFrameForWTBT {
    int arriveWayId = 0;
    NaviInfo currentNaviInfo;
    int errorcode = 0;
    private boolean isReCalculateRouteForYaw = true;
    String lockSoundStr = null;
    int lockTrunIcon = 0;
    C0461c mCarLocationChange;
    CarLocation mCarProjectionChange;
    private Context mContext;
    private C0640a mHandler = new C0640a(this);
    private List<AMapNaviListener> mNaviListener;
    private C0457h m_stTbt;
    int matchRouteChangeId = 0;
    byte[] panel = null;
    String playSound = null;
    int playType = 0;
    int segRemainLen = 0;
    int vibrateStrength = 0;
    int vibrateTime = 0;

    /* renamed from: com.autonavi.wtbt.FrameForWTBT$a */
    class C0640a extends Handler {
        /* renamed from: a */
        final /* synthetic */ FrameForWTBT f3878a;

        C0640a(FrameForWTBT frameForWTBT) {
            this.f3878a = frameForWTBT;
        }

        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                if (this.f3878a.mNaviListener != null) {
                    int i;
                    switch (message.what) {
                        case 0:
                            for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onNaviInfoUpdate(this.f3878a.currentNaviInfo);
                                if (this.f3878a.currentNaviInfo != null) {
                                    AMapNaviInfo aMapNaviInfo = new AMapNaviInfo();
                                    aMapNaviInfo.setPathRemainDistance(this.f3878a.currentNaviInfo.m_RouteRemainDis);
                                    aMapNaviInfo.setPathRemainTime(this.f3878a.currentNaviInfo.m_RouteRemainTime);
                                    ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onNaviInfoUpdated(aMapNaviInfo);
                                }
                            }
                            return;
                        case 1:
                            for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onGetNavigationText(this.f3878a.playType, this.f3878a.playSound.toString());
                            }
                            return;
                        case 2:
                            for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onEndEmulatorNavi();
                            }
                            return;
                        case 3:
                            if (this.f3878a.arriveWayId < 0) {
                                return;
                            }
                            if (this.f3878a.arriveWayId == 0) {
                                for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                    ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onArriveDestination();
                                }
                                return;
                            }
                            for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onArrivedWayPoint(this.f3878a.arriveWayId);
                            }
                            return;
                        case 4:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 13:
                        case 14:
                            return;
                        case 5:
                            for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onReCalculateRouteForYaw();
                            }
                            return;
                        case 7:
                            if (this.f3878a.mCarLocationChange != null) {
                                for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                    if (this.f3878a.mCarLocationChange != null) {
                                        ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onLocationChange(this.f3878a.mCarLocationChange.f2771a);
                                    }
                                }
                                return;
                            }
                            return;
                        case 11:
                            for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onCalculateRouteSuccess();
                            }
                            return;
                        case 12:
                            for (i = 0; i < this.f3878a.mNaviListener.size(); i++) {
                                ((AMapNaviListener) this.f3878a.mNaviListener.get(i)).onCalculateRouteFailure(this.f3878a.errorcode);
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

    public FrameForWTBT(Context context, C0457h c0457h) {
        this.m_stTbt = c0457h;
        this.mContext = context;
        this.mNaviListener = new ArrayList();
    }

    public void requestHttp(int i, int i2, int i3, String str, String str2, byte[] bArr, int i4) {
        try {
            String str3 = "http://s.amap.com/" + str;
            if (this.m_stTbt != null && this.m_stTbt.f2748c != null) {
                this.m_stTbt.f2748c.m4808a(new C0614e(this.m_stTbt, this.mContext, str3, i3, str2, i, i2, bArr, i4));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void updateNaviInfo(DGNaviInfo dGNaviInfo) {
        try {
            this.currentNaviInfo = new NaviInfo(dGNaviInfo);
            this.mHandler.sendEmptyMessage(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void playNaviSound(int i, String str) {
        try {
            this.playType = i;
            if (i == 8) {
                this.playSound = bi_常量类.f6358b;
            } else {
                this.playSound = str;
            }
            this.mHandler.sendEmptyMessage(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void endEmulatorNavi() {
        try {
            this.mHandler.sendEmptyMessage(2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void arriveWay(int i) {
        try {
            this.arriveWayId = i;
            this.mHandler.sendEmptyMessage(3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int matchRouteChanged(int i) {
        return 0;
    }

    public void offRoute() {
        boolean z = true;
        try {
            if (this.isReCalculateRouteForYaw) {
                z = this.m_stTbt.m3899c(-1);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(5);
            }
            if (!z) {
                this.mHandler.sendEmptyMessage(12);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void routeDestroy() {
        try {
            this.mHandler.sendEmptyMessage(6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void carLocationChange(CarLocation carLocation) {
        try {
            this.mCarLocationChange = new C0461c();
            this.mCarLocationChange.m3924a((float) carLocation.m_CarDir);
            this.mCarLocationChange.m3928b((float) carLocation.m_Speed);
            this.mCarLocationChange.m3925a(carLocation.m_MatchStatus);
            this.mCarLocationChange.m3927a(new NaviLatLng(carLocation.m_Latitude, carLocation.m_Longitude));
            this.mCarLocationChange.m3926a(System.currentTimeMillis());
            this.mHandler.sendEmptyMessage(7);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void carProjectionChange(CarLocation carLocation) {
        try {
            this.mCarProjectionChange = carLocation;
            this.mHandler.sendEmptyMessage(8);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRouteRequestState(int i) {
        try {
            this.errorcode = i;
            switch (i) {
                case 1:
                    int f;
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

    public void showTrafficPanel(byte[] bArr) {
    }

    public void hideTrafficPanel() {
    }

    public int getPlayState() {
        return 0;
    }

    public void lockScreenNaviTips(String str, int i, int i2) {
        try {
            this.lockSoundStr = str;
            this.lockTrunIcon = i;
            this.segRemainLen = i2;
            this.mHandler.sendEmptyMessage(13);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void vibratePhoneTips(int i, int i2) {
        try {
            this.vibrateStrength = i;
            this.vibrateTime = i2;
            this.mHandler.sendEmptyMessage(14);
        } catch (Throwable th) {
            th.printStackTrace();
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
}
