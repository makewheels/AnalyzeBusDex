package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class GeocodeAddress implements Parcelable {
    public static final Creator<GeocodeAddress> CREATOR = new C0504a();
    /* renamed from: a */
    private String f2980a;
    /* renamed from: b */
    private String f2981b;
    /* renamed from: c */
    private String f2982c;
    /* renamed from: d */
    private String f2983d;
    /* renamed from: e */
    private String f2984e;
    /* renamed from: f */
    private String f2985f;
    /* renamed from: g */
    private String f2986g;
    /* renamed from: h */
    private String f2987h;
    /* renamed from: i */
    private LatLonPoint f2988i;
    /* renamed from: j */
    private String f2989j;

    public String getFormatAddress() {
        return this.f2980a;
    }

    public void setFormatAddress(String str) {
        this.f2980a = str;
    }

    public String getProvince() {
        return this.f2981b;
    }

    public void setProvince(String str) {
        this.f2981b = str;
    }

    public String getCity() {
        return this.f2982c;
    }

    public void setCity(String str) {
        this.f2982c = str;
    }

    public String getDistrict() {
        return this.f2983d;
    }

    public void setDistrict(String str) {
        this.f2983d = str;
    }

    public String getTownship() {
        return this.f2984e;
    }

    public void setTownship(String str) {
        this.f2984e = str;
    }

    public String getNeighborhood() {
        return this.f2985f;
    }

    public void setNeighborhood(String str) {
        this.f2985f = str;
    }

    public String getBuilding() {
        return this.f2986g;
    }

    public void setBuilding(String str) {
        this.f2986g = str;
    }

    public String getAdcode() {
        return this.f2987h;
    }

    public void setAdcode(String str) {
        this.f2987h = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f2988i;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f2988i = latLonPoint;
    }

    public String getLevel() {
        return this.f2989j;
    }

    public void setLevel(String str) {
        this.f2989j = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2980a);
        parcel.writeString(this.f2981b);
        parcel.writeString(this.f2982c);
        parcel.writeString(this.f2983d);
        parcel.writeString(this.f2984e);
        parcel.writeString(this.f2985f);
        parcel.writeString(this.f2986g);
        parcel.writeString(this.f2987h);
        parcel.writeValue(this.f2988i);
        parcel.writeString(this.f2989j);
    }

    private GeocodeAddress(Parcel parcel) {
        this.f2980a = parcel.readString();
        this.f2981b = parcel.readString();
        this.f2982c = parcel.readString();
        this.f2983d = parcel.readString();
        this.f2984e = parcel.readString();
        this.f2985f = parcel.readString();
        this.f2986g = parcel.readString();
        this.f2987h = parcel.readString();
        this.f2988i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f2989j = parcel.readString();
    }
}
