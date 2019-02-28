package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchCity implements Parcelable {
    public static final Creator<SearchCity> CREATOR = new C0546s();
    /* renamed from: a */
    private String f3239a;
    /* renamed from: b */
    private String f3240b;
    /* renamed from: c */
    private String f3241c;

    public String getSearchCityName() {
        return this.f3239a;
    }

    public void setSearchCityName(String str) {
        this.f3239a = str;
    }

    public String getSearchCitycode() {
        return this.f3240b;
    }

    public void setSearchCitycode(String str) {
        this.f3240b = str;
    }

    public String getSearchCityAdCode() {
        return this.f3241c;
    }

    public void setSearchCityhAdCode(String str) {
        this.f3241c = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3239a);
        parcel.writeString(this.f3240b);
        parcel.writeString(this.f3241c);
    }

    public SearchCity(Parcel parcel) {
        this.f3239a = parcel.readString();
        this.f3240b = parcel.readString();
        this.f3241c = parcel.readString();
    }
}
