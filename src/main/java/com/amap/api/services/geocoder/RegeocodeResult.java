package com.amap.api.services.geocoder;

public class RegeocodeResult {
    /* renamed from: a */
    private RegeocodeQuery f3017a;
    /* renamed from: b */
    private RegeocodeAddress f3018b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f3017a = regeocodeQuery;
        this.f3018b = regeocodeAddress;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f3017a;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f3017a = regeocodeQuery;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f3018b;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f3018b = regeocodeAddress;
    }
}
