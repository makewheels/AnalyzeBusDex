package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Photo implements Parcelable {
    public static final Creator<Photo> CREATOR = new C0519f();
    /* renamed from: a */
    private String f3103a;
    /* renamed from: b */
    private String f3104b;

    public Photo(String str, String str2) {
        this.f3103a = str;
        this.f3104b = str2;
    }

    public String getTitle() {
        return this.f3103a;
    }

    public void setTitle(String str) {
        this.f3103a = str;
    }

    public String getUrl() {
        return this.f3104b;
    }

    public void setUrl(String str) {
        this.f3104b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3103a);
        parcel.writeString(this.f3104b);
    }

    public Photo(Parcel parcel) {
        this.f3103a = parcel.readString();
        this.f3104b = parcel.readString();
    }
}
