package com.amap.api.services.geocoder;

public class GeocodeQuery {
    /* renamed from: a */
    private String f2990a;
    /* renamed from: b */
    private String f2991b;

    public GeocodeQuery(String str, String str2) {
        this.f2990a = str;
        this.f2991b = str2;
    }

    public String getLocationName() {
        return this.f2990a;
    }

    public void setLocationName(String str) {
        this.f2990a = str;
    }

    public String getCity() {
        return this.f2991b;
    }

    public void setCity(String str) {
        this.f2991b = str;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f2991b == null ? 0 : this.f2991b.hashCode()) + 31) * 31;
        if (this.f2990a != null) {
            i = this.f2990a.hashCode();
        }
        return hashCode + i;
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
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        if (this.f2991b == null) {
            if (geocodeQuery.f2991b != null) {
                return false;
            }
        } else if (!this.f2991b.equals(geocodeQuery.f2991b)) {
            return false;
        }
        if (this.f2990a == null) {
            if (geocodeQuery.f2990a != null) {
                return false;
            }
            return true;
        } else if (this.f2990a.equals(geocodeQuery.f2990a)) {
            return true;
        } else {
            return false;
        }
    }
}
