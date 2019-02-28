package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p054u.aly.bi_常量类;

public final class LatLonPoint implements Parcelable {
    public static final Creator<LatLonPoint> CREATOR = new C0489n();
    /* renamed from: a */
    private double f2906a;
    /* renamed from: b */
    private double f2907b;

    public LatLonPoint(double d, double d2) {
        this.f2906a = d;
        this.f2907b = d2;
    }

    public double getLongitude() {
        return this.f2907b;
    }

    public void setLongitude(double d) {
        this.f2907b = d;
    }

    public double getLatitude() {
        return this.f2906a;
    }

    public void setLatitude(double d) {
        this.f2906a = d;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f2906a, this.f2907b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f2906a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f2907b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
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
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        if (Double.doubleToLongBits(this.f2906a) != Double.doubleToLongBits(latLonPoint.f2906a)) {
            return false;
        }
        if (Double.doubleToLongBits(this.f2907b) != Double.doubleToLongBits(latLonPoint.f2907b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return bi_常量类.f6358b + this.f2906a + "," + this.f2907b;
    }

    private LatLonPoint(Parcel parcel) {
        this.f2906a = parcel.readDouble();
        this.f2907b = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f2906a);
        parcel.writeDouble(this.f2907b);
    }
}
