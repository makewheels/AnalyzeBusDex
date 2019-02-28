package com.amap.api.location;

import android.location.Location;
import com.amap.api.location.core.AMapLocException;

public class AMapLocation extends Location {
    /* renamed from: a */
    private String f1223a;
    /* renamed from: b */
    private String f1224b;
    /* renamed from: c */
    private String f1225c;
    /* renamed from: d */
    private String f1226d;
    /* renamed from: e */
    private String f1227e;
    /* renamed from: f */
    private String f1228f;
    /* renamed from: g */
    private String f1229g;
    /* renamed from: h */
    private String f1230h;
    /* renamed from: i */
    private String f1231i;
    /* renamed from: j */
    private AMapLocException f1232j = new AMapLocException();

    public AMapLocException getAMapException() {
        return this.f1232j;
    }

    public void setAMapException(AMapLocException aMapLocException) {
        this.f1232j = aMapLocException;
    }

    /* renamed from: a */
    void m1758a(String str) {
        this.f1230h = str;
    }

    /* renamed from: b */
    void m1759b(String str) {
        this.f1231i = str;
    }

    public String getPoiId() {
        return this.f1228f;
    }

    public void setPoiId(String str) {
        this.f1228f = str;
    }

    public String getFloor() {
        return this.f1229g;
    }

    public void setFloor(String str) {
        this.f1229g = str;
    }

    public AMapLocation(String str) {
        super(str);
    }

    public AMapLocation(Location location) {
        super(location);
    }

    public String getProvince() {
        return this.f1223a;
    }

    public void setProvince(String str) {
        this.f1223a = str;
    }

    public String getCity() {
        return this.f1224b;
    }

    public void setCity(String str) {
        this.f1224b = str;
    }

    public String getDistrict() {
        return this.f1225c;
    }

    public void setDistrict(String str) {
        this.f1225c = str;
    }

    public String getCityCode() {
        return this.f1226d;
    }

    public void setCityCode(String str) {
        this.f1226d = str;
    }

    public String getAdCode() {
        return this.f1227e;
    }

    public void setAdCode(String str) {
        this.f1227e = str;
    }

    public String getAddress() {
        return this.f1231i;
    }

    public String getStreet() {
        return this.f1230h;
    }
}
