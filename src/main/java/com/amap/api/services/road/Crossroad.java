package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Crossroad extends Road implements Parcelable {
    public static final Creator<Crossroad> CREATOR = new C0523a();
    /* renamed from: a */
    private float f3162a;
    /* renamed from: b */
    private String f3163b;
    /* renamed from: c */
    private String f3164c;
    /* renamed from: d */
    private String f3165d;
    /* renamed from: e */
    private String f3166e;
    /* renamed from: f */
    private String f3167f;

    public float getDistance() {
        return this.f3162a;
    }

    public void setDistance(float f) {
        this.f3162a = f;
    }

    public String getDirection() {
        return this.f3163b;
    }

    public void setDirection(String str) {
        this.f3163b = str;
    }

    public String getFirstRoadId() {
        return this.f3164c;
    }

    public void setFirstRoadId(String str) {
        this.f3164c = str;
    }

    public String getFirstRoadName() {
        return this.f3165d;
    }

    public void setFirstRoadName(String str) {
        this.f3165d = str;
    }

    public String getSecondRoadId() {
        return this.f3166e;
    }

    public void setSecondRoadId(String str) {
        this.f3166e = str;
    }

    public String getSecondRoadName() {
        return this.f3167f;
    }

    public void setSecondRoadName(String str) {
        this.f3167f = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f3162a);
        parcel.writeString(this.f3163b);
        parcel.writeString(this.f3164c);
        parcel.writeString(this.f3165d);
        parcel.writeString(this.f3166e);
        parcel.writeString(this.f3167f);
    }

    private Crossroad(Parcel parcel) {
        this.f3162a = parcel.readFloat();
        this.f3163b = parcel.readString();
        this.f3164c = parcel.readString();
        this.f3165d = parcel.readString();
        this.f3166e = parcel.readString();
        this.f3167f = parcel.readString();
    }
}
