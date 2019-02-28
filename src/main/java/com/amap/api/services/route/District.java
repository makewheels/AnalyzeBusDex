package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class District implements Parcelable {
    public static final Creator<District> CREATOR = new C0531d();
    /* renamed from: a */
    private String f3184a;
    /* renamed from: b */
    private String f3185b;

    public String getDistrictName() {
        return this.f3184a;
    }

    public void setDistrictName(String str) {
        this.f3184a = str;
    }

    public String getDistrictAdcode() {
        return this.f3185b;
    }

    public void setDistrictAdcode(String str) {
        this.f3185b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3184a);
        parcel.writeString(this.f3185b);
    }

    public District(Parcel parcel) {
        this.f3184a = parcel.readString();
        this.f3185b = parcel.readString();
    }
}
