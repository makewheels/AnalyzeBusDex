package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Tip implements Parcelable {
    public static final Creator<Tip> CREATOR = new C0511b();
    /* renamed from: a */
    private String f3036a;
    /* renamed from: b */
    private String f3037b;
    /* renamed from: c */
    private String f3038c;

    public String getName() {
        return this.f3036a;
    }

    public void setName(String str) {
        this.f3036a = str;
    }

    public String getDistrict() {
        return this.f3037b;
    }

    public void setDistrict(String str) {
        this.f3037b = str;
    }

    public String getAdcode() {
        return this.f3038c;
    }

    public void setAdcode(String str) {
        this.f3038c = str;
    }

    public String toString() {
        return "name:" + this.f3036a + " district:" + this.f3037b + " adcode:" + this.f3038c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3036a);
        parcel.writeString(this.f3038c);
        parcel.writeString(this.f3037b);
    }

    private Tip(Parcel parcel) {
        this.f3036a = parcel.readString();
        this.f3038c = parcel.readString();
        this.f3037b = parcel.readString();
    }
}
