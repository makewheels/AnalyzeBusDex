package com.amap.api.navi;

/* compiled from: TBTEngine */
/* renamed from: com.amap.api.navi.i */
public interface C0458i {
    double[] getLinkCoor(int i, int i2);

    int getLinkLength(int i, int i2);

    int getLinkRoadClass(int i, int i2);

    String getLinkRoadName(int i, int i2);

    int getLinkTime(int i, int i2);

    int getRouteLength();

    int getRouteStrategy();

    int getRouteTime();

    int getSegChargeLength(int i);

    double[] getSegCoor(int i);

    int getSegLength(int i);

    int getSegLinkNum(int i);

    int getSegNum();

    int getSegTime(int i);

    int getSegTollCost(int i);

    int haveTrafficLights(int i, int i2);

    void manualRefreshTMC();

    void pauseNavi();

    int playNaviManual();

    int playTrafficRadioManual(int i);

    int reroute(int i, int i2);

    void resumeNavi();

    int selectRoute(int i);

    void setEmulatorSpeed(int i);

    int startEmulatorNavi();

    int startGPSNavi();

    void stopNavi();
}
