package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Poi implements Parcelable {
    public static final PoiCreator CREATOR = new PoiCreator();
    /* renamed from: a */
    private final String f2342a;
    /* renamed from: b */
    private final LatLng f2343b;

    public Poi(String str, LatLng latLng) {
        this.f2342a = str;
        this.f2343b = latLng;
    }

    public String getName() {
        return this.f2342a;
    }

    public LatLng getCoordinate() {
        return this.f2343b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Poi)) {
            return false;
        }
        Poi poi = (Poi) obj;
        if (poi.getName().equals(this.f2342a) && poi.getCoordinate().equals(this.f2343b)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "name:" + this.f2342a + "  coordinate:" + this.f2343b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2342a);
        parcel.writeParcelable(this.f2343b, i);
    }
}
