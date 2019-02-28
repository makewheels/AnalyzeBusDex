package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class Doorway implements Parcelable {
    public static final Creator<Doorway> CREATOR = new C0532e();
    /* renamed from: a */
    private String f3186a;
    /* renamed from: b */
    private LatLonPoint f3187b;

    public String getName() {
        return this.f3186a;
    }

    public void setName(String str) {
        this.f3186a = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f3187b;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f3187b = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3186a);
        parcel.writeParcelable(this.f3187b, i);
    }

    public Doorway(Parcel parcel) {
        this.f3186a = parcel.readString();
        this.f3187b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
