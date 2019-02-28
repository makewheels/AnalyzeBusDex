package com.autonavi.tbt;

import com.amap.api.navi.C0458i;

public class TBT implements C0458i {
    public static final int DATA_ADD_OP = 2;
    public static final int DATA_DELETE_OP = 5;
    public static final int DATA_FINISH_OP = 4;
    public static final int DATA_UPDAE_OP = 3;
    public static final int ERROR_STATE_CallCenterError = 5;
    public static final int ERROR_STATE_DataBufError = 9;
    public static final int ERROR_STATE_ENV_FAILED = 0;
    public static final int ERROR_STATE_EncodeFalse = 7;
    public static final int ERROR_STATE_EndNoRoad = 11;
    public static final int ERROR_STATE_EndPointFalse = 6;
    public static final int ERROR_STATE_FORBID = 100;
    public static final int ERROR_STATE_HalfwayNoRoad = 12;
    public static final int ERROR_STATE_IllegalRequest = 4;
    public static final int ERROR_STATE_LackPreview = 8;
    public static final int ERROR_STATE_PARAM_INVALID = 2;
    public static final int ERROR_STATE_RouteFail = 13;
    public static final int ERROR_STATE_StartNoRoad = 10;
    public static final int ERROR_STATE_StartPointFalse = 3;
    public static final int OFFLINE_DATAMANAGER = 1;
    public static final int SUCCEED_STATE = 1;
    public static final int VERSION_GET_OP = 1;

    public native int IOParam(int i, int i2, int i3);

    public native void closeCamera();

    public native void closeTMC();

    public native void closeTrafficPanel();

    public native void closeTrafficRadio();

    public native TmcBarItem[] createTmcBar(int i, int i2);

    public native void destroy();

    public native Camera[] getAllCamera();

    public native int[] getAllRouteID();

    public native AvoidJamArea getAvoidInfo();

    public native AvoidJamArea getAvoidJamArea();

    public native int getBypassLimitedRoad();

    public native int getDestDirection();

    public native int getDiffToTMCRoute();

    public native GroupSegment[] getGroupSegmentList();

    public native JamInfo[] getJamInfoList();

    public native int getLinkCityCode(int i, int i2);

    public native double[] getLinkCoor(int i, int i2);

    public native int getLinkFormWay(int i, int i2);

    public native int getLinkIOFlag(int i, int i2);

    public native int getLinkIsBranched(int i, int i2);

    public native int getLinkLength(int i, int i2);

    public native int getLinkRoadClass(int i, int i2);

    public native String getLinkRoadName(int i, int i2);

    public native int getLinkTime(int i, int i2);

    public native LinkStatus getLinkTrafficStatus(int i, int i2);

    public native int getLinkType(int i, int i2);

    public native byte[] getManeuverIcon(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native EventTip[] getNaviEvents();

    public native NaviGuideItem[] getNaviGuideList();

    public native NaviStaticInfo getNaviStaticInfo();

    public native GeoPoint[] getPassPoints();

    public native GPSDataInfo[] getRecentGPS(int i, int i2, int i3);

    public native RestAreaInfo[] getRestAreas(int i, int i2);

    public native RestrictionInfo getRestrictionInfo();

    public native GeoPoint getRouteEndPos();

    public native RouteIncident[] getRouteIncident();

    public native int getRouteLength();

    public native GeoPoint getRouteStartPos();

    public native int getRouteStrategy();

    public native int getRouteTime();

    public native String getRouteVersion();

    public native int getSegAccessType(int i);

    public native int getSegChargeLength(int i);

    public native double[] getSegCoor(int i);

    public native int getSegLength(int i);

    public native int getSegLinkNum(int i);

    public native NaviAction getSegNaviAction(int i);

    public native int getSegNum();

    public native int getSegTime(int i);

    public native int getSegTollCost(int i);

    public native String getSegTollPathName(int i);

    public native int getTMCRouteTime();

    public native String getVersion();

    public native int haveTrafficLights(int i, int i2);

    public native int init(IFrameForTBT iFrameForTBT, String str, String str2, String str3, String str4);

    public native void manualRefreshTMC();

    public native int moveToRoute(int i);

    public native void openCamera();

    public native void openTMC();

    public native void openTrafficPanel();

    public native void openTrafficRadio();

    public native void pauseNavi();

    public native int playNaviManual();

    public native int playTrafficRadioManual(int i);

    public native int pushRouteData(int i, int i2, byte[] bArr, int i3);

    public native void receiveNetData(int i, int i2, byte[] bArr, int i3);

    public native int requestRoute(int i, int i2, int i3, double[] dArr, int i4, double[] dArr2);

    public native int requestRouteWithPOI(int i, int i2, int i3, int i4, PointOfInterest[] pointOfInterestArr, int i5, PointOfInterest[] pointOfInterestArr2, int i6, PointOfInterest[] pointOfInterestArr3, double d);

    public native int requestRouteWithStart(int i, int i2, int i3, double[] dArr, int i4, double[] dArr2, int i5, double[] dArr3);

    public native int reroute(int i, int i2);

    public native void resumeNavi();

    public native int selectRoute(int i);

    public native void setCarLocation(int i, double d, double d2);

    public native void setClientNetType(int i);

    public native void setCrossDisplayMode(int i);

    public native void setDetectedMode(int i);

    public native void setEmulatorSpeed(int i);

    public native void setGPSInfo(int i, double d, double d2, double d3, double d4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, double d5);

    public native void setMotionData(MotionVector3D motionVector3D, MotionVector3D motionVector3D2, MotionVector3D motionVector3D3, double d);

    public native void setNetRequestState(int i, int i2, int i3);

    public native int setParam(String str, String str2);

    public native void setTMCRerouteStrategy(int i);

    public native void setTimeForOneWord(int i);

    public native int startEmulatorNavi();

    public native int startGPSNavi();

    public native void stopEmulatorNavi();

    public native void stopNavi();

    public native int switchNaviRoute(int i);

    public native void switchParallelRoad();

    static {
        System.loadLibrary("tbt");
    }
}
