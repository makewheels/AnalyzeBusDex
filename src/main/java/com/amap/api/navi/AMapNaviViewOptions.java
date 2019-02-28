package com.amap.api.navi;

import android.graphics.Bitmap;

public class AMapNaviViewOptions {
    public static final int BLUE_COLOR_TOPIC = 1;
    public static final int DEFAULT_COLOR_TOPIC = 0;
    public static final int HUD_MIRROR_SHOW = 2;
    public static final int HUD_NORMAL_SHOW = 1;
    public static final int PINK_COLOR_TOPIC = 2;
    public static final int WHITE_COLOR_TOPIC = 3;
    private Bitmap endBitmap;
    private boolean isCameraEnable = true;
    private boolean isCameraInfoUpdateEnable = true;
    private boolean isCompassEnable = true;
    private boolean isLayoutVisible = true;
    private boolean isNaviNight = false;
    private boolean isReCalculateRouteForTrafficJam = false;
    private boolean isReCalculateRouteForYaw = true;
    private boolean isRouteListButtonShow = true;
    private boolean isScreenAlwaysBright = true;
    private boolean isSettingMenuenable = false;
    private boolean isTrafficBarEnabled = true;
    private boolean isTrafficInfoUpdateEnabled = true;
    private boolean isTrafficLayerEnable = true;
    private boolean isTrafficLine = false;
    private int leaderLineColor = -1;
    private long lockMapDelayed = 5000;
    private Bitmap monitorBitmap;
    private Bitmap startBitmap;
    private int themeColor = 0;
    private Bitmap wayBitmap;

    public void setCompassEnabled(Boolean bool) {
        this.isCompassEnable = bool.booleanValue();
    }

    public boolean isCompassEnabled() {
        return this.isCompassEnable;
    }

    public void setTrafficBarEnabled(Boolean bool) {
        this.isTrafficBarEnabled = bool.booleanValue();
    }

    public boolean isTrafficBarEnabled() {
        return this.isTrafficBarEnabled;
    }

    public void setTrafficLayerEnabled(Boolean bool) {
        this.isTrafficLayerEnable = bool.booleanValue();
    }

    public boolean isTrafficLayerEnabled() {
        return this.isTrafficLayerEnable;
    }

    public void setRouteListButtonShow(boolean z) {
        this.isRouteListButtonShow = z;
    }

    public boolean isRouteListButtonShow() {
        return this.isRouteListButtonShow;
    }

    public void setNaviNight(boolean z) {
        this.isNaviNight = z;
    }

    public boolean isNaviNight() {
        return this.isNaviNight;
    }

    public void setStartPointBitmap(Bitmap bitmap) {
        this.startBitmap = bitmap;
    }

    Bitmap getStartMarker() {
        return this.startBitmap;
    }

    public void setEndPointBitmap(Bitmap bitmap) {
        this.endBitmap = bitmap;
    }

    Bitmap getEndtMarker() {
        return this.endBitmap;
    }

    public void setWayPointBitmap(Bitmap bitmap) {
        this.wayBitmap = bitmap;
    }

    Bitmap getWayMarker() {
        return this.wayBitmap;
    }

    public void setMonitorCamerBitmap(Bitmap bitmap) {
        this.monitorBitmap = bitmap;
    }

    Bitmap getMonitorMarker() {
        return this.monitorBitmap;
    }

    public void setMonitorCameraEnabled(Boolean bool) {
        this.isCameraEnable = bool.booleanValue();
    }

    public boolean isMonitorCameraEnable() {
        return this.isCameraEnable;
    }

    public void setScreenAlwaysBright(boolean z) {
        this.isScreenAlwaysBright = z;
    }

    public boolean isScreenAlwaysBright() {
        return this.isScreenAlwaysBright;
    }

    public void setTrafficInfoUpdateEnabled(boolean z) {
        this.isTrafficInfoUpdateEnabled = z;
    }

    public boolean isTrafficInfoUpdateEnabled() {
        return this.isTrafficInfoUpdateEnabled;
    }

    public void setCameraInfoUpdateEnabled(boolean z) {
        this.isCameraInfoUpdateEnable = z;
    }

    public boolean isCameraInfoUpdateEnable() {
        return this.isCameraInfoUpdateEnable;
    }

    public void setReCalculateRouteForYaw(Boolean bool) {
        this.isReCalculateRouteForYaw = bool.booleanValue();
    }

    public boolean isReCalculateRouteForYaw() {
        return this.isReCalculateRouteForYaw;
    }

    public void setReCalculateRouteForTrafficJam(Boolean bool) {
        this.isReCalculateRouteForTrafficJam = bool.booleanValue();
    }

    public boolean isReCalculateRouteForTrafficJam() {
        return this.isReCalculateRouteForTrafficJam;
    }

    public void setSettingMenuEnabled(Boolean bool) {
        this.isSettingMenuenable = bool.booleanValue();
    }

    public boolean isSettingMenuenable() {
        return this.isSettingMenuenable;
    }

    public void setNaviViewTopic(int i) {
        this.themeColor = i;
    }

    public int getNaviViewTopic() {
        return this.themeColor;
    }

    public void setTrafficLine(boolean z) {
        this.isTrafficLine = z;
    }

    public boolean isTrafficLine() {
        return this.isTrafficLine;
    }

    public void setLeaderLineEnabled(int i) {
        this.leaderLineColor = i;
    }

    int getLeaderLineColor() {
        return this.leaderLineColor;
    }

    public boolean getLeaderLineEnabled(int i) {
        if (this.leaderLineColor != -1) {
            return true;
        }
        return false;
    }

    public boolean isLayoutVisible() {
        return this.isLayoutVisible;
    }

    public void setLayoutVisible(boolean z) {
        this.isLayoutVisible = z;
    }

    public long getLockMapDelayed() {
        return this.lockMapDelayed;
    }

    public void setLockMapDelayed(long j) {
        this.lockMapDelayed = j;
    }
}
