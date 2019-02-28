package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class RegeocodeRoad implements Parcelable {
    public static final Creator<RegeocodeRoad> CREATOR = new C0507d();
    /* renamed from: a */
    private String f3019a;
    /* renamed from: b */
    private String f3020b;
    /* renamed from: c */
    private float f3021c;
    /* renamed from: d */
    private String f3022d;
    /* renamed from: e */
    private LatLonPoint f3023e;

    public String getId() {
        return this.f3019a;
    }

    public void setId(String str) {
        this.f3019a = str;
    }

    public String getName() {
        return this.f3020b;
    }

    public void setName(String str) {
        this.f3020b = str;
    }

    public float getDistance() {
        return this.f3021c;
    }

    public void setDistance(float f) {
        this.f3021c = f;
    }

    public String getDirection() {
        return this.f3022d;
    }

    public void setDirection(String str) {
        this.f3022d = str;
    }

    public LatLonPoint getLatLngPoint() {
        return this.f3023e;
    }

    public void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f3023e = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3019a);
        parcel.writeString(this.f3020b);
        parcel.writeFloat(this.f3021c);
        parcel.writeString(this.f3022d);
        parcel.writeValue(this.f3023e);
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f3019a = parcel.readString();
        this.f3020b = parcel.readString();
        this.f3021c = parcel.readFloat();
        this.f3022d = parcel.readString();
        this.f3023e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
