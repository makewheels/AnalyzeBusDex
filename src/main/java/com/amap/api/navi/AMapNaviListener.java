package com.amap.api.navi;

import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.NaviInfo;

public interface AMapNaviListener {
    void onArriveDestination();

    void onArrivedWayPoint(int i);

    void onCalculateRouteFailure(int i);

    void onCalculateRouteSuccess();

    void onEndEmulatorNavi();

    void onGetNavigationText(int i, String str);

    void onGpsOpenStatus(boolean z);

    void onInitNaviFailure();

    void onInitNaviSuccess();

    void onLocationChange(AMapNaviLocation aMapNaviLocation);

    void onNaviInfoUpdate(NaviInfo naviInfo);

    @Deprecated
    void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo);

    void onReCalculateRouteForTrafficJam();

    void onReCalculateRouteForYaw();

    void onStartNavi(int i);

    void onTrafficStatusUpdate();
}
