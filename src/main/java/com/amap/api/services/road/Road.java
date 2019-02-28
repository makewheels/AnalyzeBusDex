package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class Road implements Parcelable {
    public static final Creator<Road> CREATOR = new C0524b();
    /* renamed from: a */
    private String f3156a;
    /* renamed from: b */
    private String f3157b;
    /* renamed from: c */
    private String f3158c;
    /* renamed from: d */
    private float f3159d;
    /* renamed from: e */
    private String f3160e;
    /* renamed from: f */
    private LatLonPoint f3161f;

    public Road(String str, String str2) {
        this.f3156a = str;
        this.f3157b = str2;
    }

    public void setId(String str) {
        this.f3156a = str;
    }

    public void setName(String str) {
        this.f3157b = str;
    }

    public String getCityCode() {
        return this.f3158c;
    }

    public void setCityCode(String str) {
        this.f3158c = str;
    }

    public float getRoadWidth() {
        return this.f3159d;
    }

    public void setRoadWidth(float f) {
        this.f3159d = f;
    }

    public String getType() {
        return this.f3160e;
    }

    public void setType(String str) {
        this.f3160e = str;
    }

    public LatLonPoint getCenterPoint() {
        return this.f3161f;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f3161f = latLonPoint;
    }

    public String getId() {
        return this.f3156a;
    }

    public String getName() {
        return this.f3157b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3156a);
        parcel.writeString(this.f3157b);
        parcel.writeString(this.f3158c);
        parcel.writeFloat(this.f3159d);
        parcel.writeString(this.f3160e);
        parcel.writeValue(this.f3161f);
    }

    private Road(Parcel parcel) {
        this.f3156a = parcel.readString();
        this.f3157b = parcel.readString();
        this.f3158c = parcel.readString();
        this.f3159d = parcel.readFloat();
        this.f3160e = parcel.readString();
        this.f3161f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
