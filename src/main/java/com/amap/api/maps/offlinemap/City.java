package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class City implements Parcelable {
    public static final Creator<City> CREATOR = new C0421a();
    /* renamed from: a */
    private String f2404a;
    /* renamed from: b */
    private String f2405b;
    /* renamed from: c */
    private String f2406c;
    /* renamed from: d */
    private String f2407d;
    /* renamed from: e */
    private String f2408e;

    public void setCity(String str) {
        this.f2404a = str;
    }

    public String getCity() {
        return this.f2404a;
    }

    public void setCode(String str) {
        this.f2405b = str;
    }

    public String getCode() {
        return this.f2405b;
    }

    public String getJianpin() {
        return this.f2406c;
    }

    public void setJianpin(String str) {
        this.f2406c = str;
    }

    public String getPinyin() {
        return this.f2407d;
    }

    public void setPinyin(String str) {
        this.f2407d = str;
    }

    public String getAdcode() {
        return this.f2408e;
    }

    public void setAdcode(String str) {
        this.f2408e = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2404a);
        parcel.writeString(this.f2405b);
        parcel.writeString(this.f2406c);
        parcel.writeString(this.f2407d);
        parcel.writeString(this.f2408e);
    }

    public City(Parcel parcel) {
        this.f2404a = parcel.readString();
        this.f2405b = parcel.readString();
        this.f2406c = parcel.readString();
        this.f2407d = parcel.readString();
        this.f2408e = parcel.readString();
    }
}
