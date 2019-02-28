package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

public class RegeocodeQuery {
    /* renamed from: a */
    private LatLonPoint f3014a;
    /* renamed from: b */
    private float f3015b;
    /* renamed from: c */
    private String f3016c = GeocodeSearch.AMAP;

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.f3014a = latLonPoint;
        this.f3015b = f;
        setLatLonType(str);
    }

    public LatLonPoint getPoint() {
        return this.f3014a;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f3014a = latLonPoint;
    }

    public float getRadius() {
        return this.f3015b;
    }

    public void setRadius(float f) {
        this.f3015b = f;
    }

    public String getLatLonType() {
        return this.f3016c;
    }

    public void setLatLonType(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(GeocodeSearch.AMAP) || str.equals("gps")) {
            this.f3016c = str;
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3016c == null ? 0 : this.f3016c.hashCode()) + 31) * 31;
        if (this.f3014a != null) {
            i = this.f3014a.hashCode();
        }
        return ((hashCode + i) * 31) + Float.floatToIntBits(this.f3015b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        if (this.f3016c == null) {
            if (regeocodeQuery.f3016c != null) {
                return false;
            }
        } else if (!this.f3016c.equals(regeocodeQuery.f3016c)) {
            return false;
        }
        if (this.f3014a == null) {
            if (regeocodeQuery.f3014a != null) {
                return false;
            }
        } else if (!this.f3014a.equals(regeocodeQuery.f3014a)) {
            return false;
        }
        if (Float.floatToIntBits(this.f3015b) != Float.floatToIntBits(regeocodeQuery.f3015b)) {
            return false;
        }
        return true;
    }
}
