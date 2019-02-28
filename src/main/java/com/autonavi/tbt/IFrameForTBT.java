package com.autonavi.tbt;

public interface IFrameForTBT {
    void arriveWay(int i);

    void carLocationChange(CarLocation carLocation);

    void endEmulatorNavi();

    int getPlayState();

    void hideCross();

    void hideLaneInfo();

    void hideTrafficPanel();

    void lockScreenNaviTips(String str, int i, int i2);

    int matchRouteChanged(int i);

    void notifyMessage(int i, int i2, int i3, String str);

    void offRoute(int i);

    void playNaviSound(int i, String str);

    void requestHttp(int i, int i2, int i3, String str, String str2, byte[] bArr, int i4);

    void rerouteForTMC(int i, int i2, int i3);

    void routeDestroy();

    void setRouteRequestState(int i);

    void showCross(int i, byte[] bArr, byte[] bArr2, int i2, int i3);

    void showLaneInfo(byte[] bArr, byte[] bArr2);

    void showTrafficPanel(byte[] bArr);

    void tmcUpdate(int i, int i2, int i3);

    void updateCameraInfo(ViewCameraInfo[] viewCameraInfoArr);

    void updateNaviInfo(DGNaviInfo dGNaviInfo);

    void updateServiceFacility(ServiceFacilityInfo[] serviceFacilityInfoArr);

    void updateTrack(TrackPosition[] trackPositionArr);

    void updateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo);
}
