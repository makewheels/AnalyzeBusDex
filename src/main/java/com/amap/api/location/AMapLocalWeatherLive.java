package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;

public class AMapLocalWeatherLive {
    /* renamed from: a */
    private String f1213a;
    /* renamed from: b */
    private String f1214b;
    /* renamed from: c */
    private String f1215c;
    /* renamed from: d */
    private String f1216d;
    /* renamed from: e */
    private String f1217e;
    /* renamed from: f */
    private String f1218f;
    /* renamed from: g */
    private AMapLocException f1219g;
    /* renamed from: h */
    private String f1220h;
    /* renamed from: i */
    private String f1221i;
    /* renamed from: j */
    private String f1222j;

    public String getCity() {
        return this.f1220h;
    }

    public void setCity(String str) {
        this.f1220h = str;
    }

    public String getProvince() {
        return this.f1221i;
    }

    public void setProvince(String str) {
        this.f1221i = str;
    }

    public String getCityCode() {
        return this.f1222j;
    }

    public void setCityCode(String str) {
        this.f1222j = str;
    }

    public AMapLocException getAMapException() {
        return this.f1219g;
    }

    /* renamed from: a */
    void m1751a(AMapLocException aMapLocException) {
        this.f1219g = aMapLocException;
    }

    public String getWeather() {
        return this.f1213a;
    }

    /* renamed from: a */
    void m1752a(String str) {
        this.f1213a = str;
    }

    public String getTemperature() {
        return this.f1214b;
    }

    /* renamed from: b */
    void m1753b(String str) {
        this.f1214b = str;
    }

    public String getWindDir() {
        return this.f1215c;
    }

    /* renamed from: c */
    void m1754c(String str) {
        this.f1215c = str;
    }

    public String getWindPower() {
        return this.f1216d;
    }

    /* renamed from: d */
    void m1755d(String str) {
        this.f1216d = str;
    }

    public String getHumidity() {
        return this.f1217e;
    }

    /* renamed from: e */
    void m1756e(String str) {
        this.f1217e = str;
    }

    public String getReportTime() {
        return this.f1218f;
    }

    /* renamed from: f */
    void m1757f(String str) {
        this.f1218f = str;
    }
}
