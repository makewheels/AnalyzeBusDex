package com.amap.api.navi.model;

public class AMapNaviLocation {
    private float accuracy;
    private double altitude;
    private float bearing;
    private NaviLatLng coord;
    private int matchStatus;
    private float speed;
    private long time;

    public int getMatchStatus() {
        return this.matchStatus;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public Double getAltitude() {
        return Double.valueOf(this.altitude);
    }

    public float getBearing() {
        return this.bearing;
    }

    public float getSpeed() {
        return this.speed;
    }

    public Long getTime() {
        return Long.valueOf(this.time);
    }

    void setAccuracy(float f) {
        this.accuracy = f;
    }

    void setAltitude(double d) {
        this.altitude = d;
    }

    public void setBearing(float f) {
        this.bearing = f;
    }

    void setSpeed(float f) {
        this.speed = f;
    }

    void setTime(long j) {
        this.time = j;
    }

    public boolean isMatchNaviPath() {
        return this.matchStatus != 0;
    }

    void setMatchStatus(int i) {
        this.matchStatus = i;
    }

    public void setCoord(NaviLatLng naviLatLng) {
        this.coord = naviLatLng;
    }

    public NaviLatLng getCoord() {
        return this.coord;
    }
}
