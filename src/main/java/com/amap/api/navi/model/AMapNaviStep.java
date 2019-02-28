package com.amap.api.navi.model;

import java.util.List;

public class AMapNaviStep {
    private int chargelength;
    private List<NaviLatLng> coords;
    private int endIndex;
    private int length;
    private List<AMapNaviLink> link;
    private int startIndex;
    private int time;

    public int getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getChargelength() {
        return this.chargelength;
    }

    public void setChargelength(int i) {
        this.chargelength = i;
    }

    public List<NaviLatLng> getCoords() {
        return this.coords;
    }

    public void setCoords(List<NaviLatLng> list) {
        this.coords = list;
    }

    public List<AMapNaviLink> getLinks() {
        return this.link;
    }

    public void setLink(List<AMapNaviLink> list) {
        this.link = list;
    }
}
