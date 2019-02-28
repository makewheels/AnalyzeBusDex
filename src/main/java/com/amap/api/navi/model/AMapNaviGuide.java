package com.amap.api.navi.model;

public class AMapNaviGuide {
    public static int IconTypeArrivedDestination = 15;
    public static int IconTypeArrivedServiceArea = 13;
    public static int IconTypeArrivedTollGate = 14;
    public static int IconTypeArrivedTunnel = 16;
    public static int IconTypeArrivedWayPoint = 10;
    public static int IconTypeCrosswalk = 19;
    public static int IconTypeDefault = 1;
    public static int IconTypeDiagonallyOpposite = 23;
    public static int IconTypeEnterRoundabout = 11;
    public static int IconTypeKeepLeft = 17;
    public static int IconTypeKeepRight = 18;
    public static int IconTypeLeft = 2;
    public static int IconTypeLeftAndAround = 8;
    public static int IconTypeLeftBack = 6;
    public static int IconTypeLeftFront = 4;
    public static int IconTypeNone = 0;
    public static int IconTypeOutRoundabout = 12;
    public static int IconTypeOverpass = 20;
    public static int IconTypeRight = 3;
    public static int IconTypeRightBack = 7;
    public static int IconTypeRightFront = 5;
    public static int IconTypeSquare = 22;
    public static int IconTypeStraight = 9;
    public static int IconTypeUnderpass = 21;
    private NaviLatLng coord;
    private int m_Icon;
    private int m_Length;
    private String m_Name;
    private int m_UseTime;

    void setCoord(NaviLatLng naviLatLng) {
        this.coord = naviLatLng;
    }

    public NaviLatLng getCoord() {
        return this.coord;
    }

    public int getLength() {
        return this.m_Length;
    }

    void setLength(int i) {
        this.m_Length = i;
    }

    public int getIconType() {
        return this.m_Icon;
    }

    void setIconType(int i) {
        this.m_Icon = i;
    }

    public String getName() {
        return this.m_Name;
    }

    void setName(String str) {
        this.m_Name = str;
    }

    void setTime(int i) {
        this.m_UseTime = i;
    }

    public int getTime() {
        return this.m_UseTime;
    }

    AMapNaviGuide(C0459a c0459a) {
        this.m_Length = c0459a.m_Length;
        this.m_Icon = c0459a.m_Icon;
        this.m_Name = c0459a.m_Name;
        this.coord = c0459a.m3921a();
    }

    AMapNaviGuide() {
    }
}
