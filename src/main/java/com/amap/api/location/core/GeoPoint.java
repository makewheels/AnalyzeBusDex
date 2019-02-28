package com.amap.api.location.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p054u.aly.bi_常量类;

public class GeoPoint implements Parcelable {
    public static final Creator<GeoPoint> CREATOR = new C0287f();
    /* renamed from: a */
    private long f1288a;
    /* renamed from: b */
    private long f1289b;
    /* renamed from: c */
    private double f1290c;
    /* renamed from: d */
    private double f1291d;

    public GeoPoint() {
        this.f1288a = Long.MIN_VALUE;
        this.f1289b = Long.MIN_VALUE;
        this.f1290c = Double.MIN_VALUE;
        this.f1291d = Double.MIN_VALUE;
        this.f1288a = 0;
        this.f1289b = 0;
    }

    public GeoPoint(int i, int i2) {
        this.f1288a = Long.MIN_VALUE;
        this.f1289b = Long.MIN_VALUE;
        this.f1290c = Double.MIN_VALUE;
        this.f1291d = Double.MIN_VALUE;
        this.f1288a = (long) i;
        this.f1289b = (long) i2;
    }

    public GeoPoint(long j, long j2) {
        this.f1288a = Long.MIN_VALUE;
        this.f1289b = Long.MIN_VALUE;
        this.f1290c = Double.MIN_VALUE;
        this.f1291d = Double.MIN_VALUE;
        this.f1288a = j;
        this.f1289b = j2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.f1290c == geoPoint.f1290c && this.f1291d == geoPoint.f1291d && this.f1288a == geoPoint.f1288a && this.f1289b == geoPoint.f1289b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((this.f1291d * 7.0d) + (this.f1290c * 11.0d));
    }

    public String toString() {
        return bi_常量类.f6358b_空串 + this.f1288a + "," + this.f1289b;
    }

    public int getLongitudeE6() {
        return (int) this.f1289b;
    }

    public int getLatitudeE6() {
        return (int) this.f1288a;
    }

    private GeoPoint(Parcel parcel) {
        this.f1288a = Long.MIN_VALUE;
        this.f1289b = Long.MIN_VALUE;
        this.f1290c = Double.MIN_VALUE;
        this.f1291d = Double.MIN_VALUE;
        this.f1288a = parcel.readLong();
        this.f1289b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f1288a);
        parcel.writeLong(this.f1289b);
    }
}
