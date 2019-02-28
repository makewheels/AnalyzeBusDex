package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class StreetNumber implements Parcelable {
    public static final Creator<StreetNumber> CREATOR = new C0508e();
    /* renamed from: a */
    private String f3024a;
    /* renamed from: b */
    private String f3025b;
    /* renamed from: c */
    private LatLonPoint f3026c;
    /* renamed from: d */
    private String f3027d;
    /* renamed from: e */
    private float f3028e;

    public String getStreet() {
        return this.f3024a;
    }

    public void setStreet(String str) {
        this.f3024a = str;
    }

    public String getNumber() {
        return this.f3025b;
    }

    public void setNumber(String str) {
        this.f3025b = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f3026c;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f3026c = latLonPoint;
    }

    public String getDirection() {
        return this.f3027d;
    }

    public void setDirection(String str) {
        this.f3027d = str;
    }

    public float getDistance() {
        return this.f3028e;
    }

    public void setDistance(float f) {
        this.f3028e = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3024a);
        parcel.writeString(this.f3025b);
        parcel.writeValue(this.f3026c);
        parcel.writeString(this.f3027d);
        parcel.writeFloat(this.f3028e);
    }

    private StreetNumber(Parcel parcel) {
        this.f3024a = parcel.readString();
        this.f3025b = parcel.readString();
        this.f3026c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f3027d = parcel.readString();
        this.f3028e = parcel.readFloat();
    }
}
