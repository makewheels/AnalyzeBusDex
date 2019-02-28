package com.amap.api.navi;

import android.content.Context;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.C0597a;
import com.autonavi.tbt.C0615f;
import java.util.List;

public class AMapNavi {
    public static int CameraAndSpecialRoadDetectedMode = 3;
    public static int CameraDetectedMode = 1;
    public static int DrivingAvoidCongestion = 12;
    public static int DrivingDefault = 0;
    public static int DrivingFastestTime = 4;
    public static int DrivingNoExpressways = 3;
    public static int DrivingSaveMoney = 1;
    public static int DrivingShortDistance = 2;
    public static int EmulatorNaviMode = 2;
    public static int FrontTrafficText = 2;
    public static int GPSNaviMode = 1;
    public static int NaviInfoText = 1;
    public static int NoneDetectedMode = 0;
    public static int SpecialRoadDetectedMode = 2;
    public static int WholeTrafficText = 3;
    private static AMapNavi aMapNavi;
    private Context mContext;
    private C0453f naviSetting = new C0453f(this.mContext, this.tbtControl);
    private C0457h tbtControl = C0457h.m3870a(this.mContext);

    private AMapNavi(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        if (this.tbtControl != null) {
            this.tbtControl.m3893b();
        }
    }

    public static synchronized AMapNavi getInstance(Context context) {
        AMapNavi aMapNavi;
        synchronized (AMapNavi.class) {
            try {
                if (aMapNavi == null) {
                    aMapNavi = new AMapNavi(context);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
            aMapNavi = aMapNavi;
        }
        return aMapNavi;
    }

    public synchronized void destroy() {
        try {
            this.mContext = null;
            destroyAMapNavi();
            this.naviSetting.m3847b();
            if (this.tbtControl != null) {
                this.tbtControl.m3900d();
            }
            this.tbtControl = null;
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    private synchronized void destroyAMapNavi() {
        aMapNavi = null;
    }

    public boolean startNavi(int i) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3887a(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public void pauseNavi() {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3907f();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void stopNavi() {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3909g();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void resumeNavi() {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3910h();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void refreshTrafficStatuses() {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3912i();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public boolean readNaviInfo() {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3913j();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean readTrafficInfo(int i) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3896b(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3891a(list, list2, list3, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean calculateDriveRoute(List<NaviLatLng> list, List<NaviLatLng> list2, int i) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3890a((List) list, (List) list2, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean reCalculateRoute(int i) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3899c(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public List<AMapTrafficStatus> getTrafficStatuses(int i, int i2) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3880a(i, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return null;
    }

    public AMapNaviPath getNaviPath() {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3914k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return null;
    }

    public List<AMapNaviGuide> getNaviGuideList() {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3915l();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return null;
    }

    C0453f getNaviSetting() {
        return this.naviSetting;
    }

    public void setEmulatorNaviSpeed(int i) {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3901d(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void setTimeForOneWord(int i) {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3904e(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void setAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3885a(aMapNaviListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void removeAMapNaviListener(AMapNaviListener aMapNaviListener) {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3894b(aMapNaviListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public boolean startGPS() {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3917n();
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean startGPS(long j, int i) {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3883a(j, i);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean stopGPS() {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3918o();
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean calculateWalkRoute(NaviLatLng naviLatLng) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3888a(naviLatLng);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public boolean calculateWalkRoute(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3889a(naviLatLng, naviLatLng2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return false;
    }

    public void setReCalculateRouteForYaw(boolean z) {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3886a(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    public void setReCalculateRouteForTrafficJam(boolean z) {
        try {
            if (this.tbtControl != null) {
                this.tbtControl.m3895b(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    int getEngineType() {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.m3879a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return -1;
    }

    int getNaviModel() {
        try {
            if (this.tbtControl != null) {
                return this.tbtControl.f2750e;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
        return -1;
    }

    int getNaviType() {
        if (this.tbtControl != null) {
            return this.tbtControl.m3903e();
        }
        return 0;
    }

    NaviInfo getNaviInfo() {
        if (this.tbtControl != null) {
            return this.tbtControl.m3920q();
        }
        return null;
    }

    public static String getVersion() {
        return "1.3.0";
    }

    public void setDetectedMode(int i) {
        if (this.tbtControl != null) {
            this.tbtControl.m3911h(i);
        }
    }

    public void setConnectionTimeout(int i) {
        if (i < 5000) {
            i = 5000;
        }
        C0597a.f3663j = i;
    }

    public void setSoTimeout(int i) {
        if (i < 5000) {
            i = 5000;
        }
        C0597a.f3664k = i;
    }
}
