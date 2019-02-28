package com.amap.api.services.geocoder;

import java.util.List;

public class GeocodeResult {
    /* renamed from: a */
    private GeocodeQuery f2992a;
    /* renamed from: b */
    private List<GeocodeAddress> f2993b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        this.f2992a = geocodeQuery;
        this.f2993b = list;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f2992a;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f2992a = geocodeQuery;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f2993b;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f2993b = list;
    }
}
