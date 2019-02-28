package com.amap.api.navi.model;

import com.amap.api.maps.model.LatLngBounds;
import java.util.List;

public class AMapNaviPath {
    private int allLength;
    private int allTime;
    private LatLngBounds bounds;
    private NaviLatLng center;
    private NaviLatLng endPoi;
    private List<NaviLatLng> list;
    private List<AMapNaviStep> listStep;
    private NaviLatLng startPoi;
    private int stepsCount;
    private int strategy;
    private int tollCost = 0;
    private List<NaviLatLng> wayPoi;

    public List<NaviLatLng> getWayPoint() {
        return this.wayPoi;
    }

    void setWayPoint(List<NaviLatLng> list) {
        this.wayPoi = list;
    }

    public NaviLatLng getStartPoint() {
        return this.startPoi;
    }

    void setStartPoint(NaviLatLng naviLatLng) {
        this.startPoi = naviLatLng;
    }

    public NaviLatLng getEndPoint() {
        return this.endPoi;
    }

    void setEndPoint(NaviLatLng naviLatLng) {
        this.endPoi = naviLatLng;
    }

    public NaviLatLng getCenterForPath() {
        return this.center;
    }

    void setCenter(NaviLatLng naviLatLng) {
        this.center = naviLatLng;
    }

    public LatLngBounds getBoundsForPath() {
        return this.bounds;
    }

    void setBounds(LatLngBounds latLngBounds) {
        this.bounds = latLngBounds;
    }

    public List<AMapNaviStep> getSteps() {
        return this.listStep;
    }

    void setListStep(List<AMapNaviStep> list) {
        this.listStep = list;
    }

    public List<NaviLatLng> getCoordList() {
        return this.list;
    }

    void setList(List<NaviLatLng> list) {
        this.list = list;
    }

    AMapNaviStep getStep(int i) {
        return null;
    }

    void setAllLength(int i) {
        this.allLength = i;
    }

    void setStrategy(int i) {
        this.strategy = i;
    }

    void setAllTime(int i) {
        this.allTime = i;
    }

    void setStepsCount(int i) {
        this.stepsCount = i;
    }

    public int getAllLength() {
        return this.allLength;
    }

    public int getStrategy() {
        return this.strategy;
    }

    public int getAllTime() {
        return this.allTime;
    }

    public int getStepsCount() {
        return this.stepsCount;
    }

    public int getTollCost() {
        return this.tollCost;
    }

    void setTollCost(int i) {
        this.tollCost = i;
    }
}
