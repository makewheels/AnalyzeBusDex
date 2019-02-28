package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Path implements Parcelable {
    public static final Creator<Path> CREATOR = new C0536i();
    /* renamed from: a */
    private float f3168a;
    /* renamed from: b */
    private long f3169b;

    public float getDistance() {
        return this.f3168a;
    }

    public void setDistance(float f) {
        this.f3168a = f;
    }

    public long getDuration() {
        return this.f3169b;
    }

    public void setDuration(long j) {
        this.f3169b = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f3168a);
        parcel.writeLong(this.f3169b);
    }

    public Path(Parcel parcel) {
        this.f3168a = parcel.readFloat();
        this.f3169b = parcel.readLong();
    }
}
