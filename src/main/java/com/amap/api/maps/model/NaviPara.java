package com.amap.api.maps.model;

public class NaviPara {
    @Deprecated
    public static final int DRIVING_AVOID_CONGESTION = 4;
    @Deprecated
    public static final int DRIVING_DEFAULT = 0;
    @Deprecated
    public static final int DRIVING_NO_HIGHWAY = 3;
    @Deprecated
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    @Deprecated
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    @Deprecated
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    @Deprecated
    public static final int DRIVING_SAVE_MONEY = 1;
    @Deprecated
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    @Deprecated
    public static final int DRIVING_SHORT_DISTANCE = 2;
    /* renamed from: a */
    private int f2332a = 0;
    /* renamed from: b */
    private LatLng f2333b;

    public void setTargetPoint(LatLng latLng) {
        this.f2333b = latLng;
    }

    public void setNaviStyle(int i) {
        if (i >= 0 && i < 9) {
            this.f2332a = i;
        }
    }

    public LatLng getTargetPoint() {
        return this.f2333b;
    }

    public int getNaviStyle() {
        return this.f2332a;
    }
}
