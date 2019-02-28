package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;
import java.util.List;

public class AMapLocalWeatherForecast {
    /* renamed from: a */
    private String f1210a;
    /* renamed from: b */
    private List<AMapLocalDayWeatherForecast> f1211b;
    /* renamed from: c */
    private AMapLocException f1212c;

    public AMapLocException getAMapException() {
        return this.f1212c;
    }

    /* renamed from: a */
    void m1748a(AMapLocException aMapLocException) {
        this.f1212c = aMapLocException;
    }

    public String getReportTime() {
        return this.f1210a;
    }

    /* renamed from: a */
    void m1749a(String str) {
        this.f1210a = str;
    }

    public List<AMapLocalDayWeatherForecast> getWeatherForecast() {
        return this.f1211b;
    }

    /* renamed from: a */
    void m1750a(List<AMapLocalDayWeatherForecast> list) {
        this.f1211b = list;
    }
}
