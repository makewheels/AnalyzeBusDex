package com.e4a.runtime.components.impl.android.p021;

import android.content.Intent;
import android.os.Bundle;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.RouteOverLay;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;
import java.util.ArrayList;

/* renamed from: com.e4a.runtime.components.impl.android.高德导航类库.高德导航Impl */
public class C0831Impl extends ComponentImpl implements C0830, AMapNaviListener {
    private AMapNavi mAMapNavi;
    private ArrayList<NaviLatLng> mEndPoints;
    private boolean mIsCalculateRouteSuccess = false;
    private boolean mIsDriveMode = true;
    private RouteOverLay mRouteOverLay;
    private ArrayList<NaviLatLng> mStartPoints;
    private TTSController ttsManager;

    public C0831Impl(ComponentContainer componentContainer) {
        super(componentContainer);
    }

    /* renamed from: 初始化 */
    public void mo1491() {
        this.mAMapNavi = AMapNavi.getInstance(mainActivity.getContext());
        this.ttsManager = TTSController.getInstance(mainActivity.getContext());
        this.ttsManager.init();
        this.mAMapNavi.setAMapNaviListener(this.ttsManager);
        this.mAMapNavi.setAMapNaviListener(this);
        this.mStartPoints = new ArrayList();
        this.mEndPoints = new ArrayList();
    }

    /* renamed from: 释放资源 */
    public void mo1500() {
        AMapNavi.getInstance(mainActivity.getContext()).removeAMapNaviListener(this);
        AMapNavi.getInstance(mainActivity.getContext()).destroy();
    }

    /* renamed from: 设置导航发音人 */
    public void mo1499(int i) {
        this.ttsManager.setSpeaker(i);
    }

    /* renamed from: 规划步行导航路线 */
    public void mo1497(double d, double d2, double d3, double d4) {
        this.mIsCalculateRouteSuccess = false;
        this.mIsDriveMode = false;
        this.mAMapNavi.calculateWalkRoute(new NaviLatLng(d, d2), new NaviLatLng(d3, d4));
    }

    /* renamed from: 开始步行模拟导航 */
    public void mo1493() {
        startEmulatorNavi(false);
    }

    /* renamed from: 开始步行实时导航 */
    public void mo1492() {
        startGPSNavi(false);
    }

    /* renamed from: 规划驾车导航路线 */
    public void mo1498(double d, double d2, double d3, double d4) {
        this.mIsCalculateRouteSuccess = false;
        this.mIsDriveMode = true;
        NaviLatLng naviLatLng = new NaviLatLng(d, d2);
        NaviLatLng naviLatLng2 = new NaviLatLng(d3, d4);
        this.mStartPoints.clear();
        this.mEndPoints.clear();
        this.mStartPoints.add(naviLatLng);
        this.mEndPoints.add(naviLatLng2);
        this.mAMapNavi.calculateDriveRoute(this.mStartPoints, this.mEndPoints, null, AMapNavi.DrivingDefault);
    }

    /* renamed from: 开始驾车模拟导航 */
    public void mo1495() {
        startEmulatorNavi(true);
    }

    /* renamed from: 开始驾车实时导航 */
    public void mo1494() {
        startGPSNavi(true);
    }

    /* renamed from: 规划导航路线完毕 */
    public void mo1496(boolean z) {
        EventDispatcher.dispatchEvent(this, "规划导航路线完毕", Boolean.valueOf(z));
    }

    private void startEmulatorNavi(boolean z) {
        if ((z && this.mIsDriveMode && this.mIsCalculateRouteSuccess) || (!z && !this.mIsDriveMode && this.mIsCalculateRouteSuccess)) {
            Intent intent = new Intent(mainActivity.getContext(), SimpleNaviActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isemulator", true);
            bundle.putInt("activityindex", 3);
            intent.putExtras(bundle);
            intent.addFlags(131072);
            mainActivity.getContext().startActivity(intent);
        }
    }

    private void startGPSNavi(boolean z) {
        if ((z && this.mIsDriveMode && this.mIsCalculateRouteSuccess) || (!z && !this.mIsDriveMode && this.mIsCalculateRouteSuccess)) {
            Intent intent = new Intent(mainActivity.getContext(), SimpleNaviActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isemulator", false);
            bundle.putInt("activityindex", 3);
            intent.putExtras(bundle);
            intent.addFlags(131072);
            mainActivity.getContext().startActivity(intent);
        }
    }

    public void onArriveDestination() {
    }

    public void onArrivedWayPoint(int i) {
    }

    public void onCalculateRouteFailure(int i) {
        this.mIsCalculateRouteSuccess = false;
        mo1496(false);
    }

    public void onCalculateRouteSuccess() {
        if (this.mAMapNavi.getNaviPath() != null) {
            this.mIsCalculateRouteSuccess = true;
            mo1496(true);
        }
    }

    public void onEndEmulatorNavi() {
    }

    public void onGetNavigationText(int i, String str) {
    }

    public void onGpsOpenStatus(boolean z) {
    }

    public void onInitNaviFailure() {
    }

    public void onInitNaviSuccess() {
    }

    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    public void onReCalculateRouteForTrafficJam() {
    }

    public void onReCalculateRouteForYaw() {
    }

    public void onStartNavi(int i) {
    }

    public void onTrafficStatusUpdate() {
    }

    public void onNaviInfoUpdate(NaviInfo naviInfo) {
    }
}
