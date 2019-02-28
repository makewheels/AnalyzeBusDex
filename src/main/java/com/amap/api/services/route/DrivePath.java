package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class DrivePath extends Path implements Parcelable {
    public static final Creator<DrivePath> CREATOR = new C0533f();
    /* renamed from: a */
    private String f3188a;
    /* renamed from: b */
    private float f3189b;
    /* renamed from: c */
    private float f3190c;
    /* renamed from: d */
    private List<DriveStep> f3191d;

    public String getStrategy() {
        return this.f3188a;
    }

    public void setStrategy(String str) {
        this.f3188a = str;
    }

    public float getTolls() {
        return this.f3189b;
    }

    public void setTolls(float f) {
        this.f3189b = f;
    }

    public float getTollDistance() {
        return this.f3190c;
    }

    public void setTollDistance(float f) {
        this.f3190c = f;
    }

    public List<DriveStep> getSteps() {
        return this.f3191d;
    }

    public void setSteps(List<DriveStep> list) {
        this.f3191d = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3188a);
        parcel.writeFloat(this.f3189b);
        parcel.writeFloat(this.f3190c);
        parcel.writeTypedList(this.f3191d);
    }

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f3188a = parcel.readString();
        this.f3189b = parcel.readFloat();
        this.f3190c = parcel.readFloat();
        this.f3191d = parcel.createTypedArrayList(DriveStep.CREATOR);
    }
}
