package com.amap.api.navi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NaviLatLng implements Parcelable {
    public static final Creator<NaviLatLng> CREATOR = new C0460b();
    private double latitude;
    private double longitude;

    public NaviLatLng(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (hashCode() == obj.hashCode()) {
            return true;
        }
        if (!(obj instanceof NaviLatLng)) {
            return false;
        }
        NaviLatLng naviLatLng = (NaviLatLng) obj;
        if (!(Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(naviLatLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(naviLatLng.longitude))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }
}
