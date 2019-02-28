package com.amap.api.navi;

public interface AMapNaviViewListener {
    void onLockMap(boolean z);

    void onNaviCancel();

    void onNaviMapMode(int i);

    void onNaviSetting();

    void onNaviTurnClick();

    void onNextRoadClick();

    void onScanViewButtonClick();
}
