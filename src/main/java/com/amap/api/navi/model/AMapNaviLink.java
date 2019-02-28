package com.amap.api.navi.model;

import java.util.List;

public class AMapNaviLink {
    private List<NaviLatLng> coords;
    private int length;
    private int roadClass;
    private String roadName;
    private int time;
    private boolean trafficLights;

    public String getRoadName() {
        return this.roadName;
    }

    public void setRoadName(String str) {
        this.roadName = str;
    }

    public int getLength() {
        return this.length;
    }

    public List<NaviLatLng> getCoords() {
        return this.coords;
    }

    public void setCoords(List<NaviLatLng> list) {
        this.coords = list;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setRoadClass(int i) {
        this.roadClass = i;
    }

    public void setTrafficLights(boolean z) {
        this.trafficLights = z;
    }

    public int getTime() {
        return this.time;
    }

    public int getRoadClass() {
        return this.roadClass;
    }

    public boolean getTrafficLights() {
        return this.trafficLights;
    }
}
