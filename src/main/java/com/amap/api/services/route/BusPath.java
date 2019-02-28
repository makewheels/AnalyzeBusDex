package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class BusPath extends Path implements Parcelable {
    public static final Creator<BusPath> CREATOR = new C0528a();
    /* renamed from: a */
    private float f3170a;
    /* renamed from: b */
    private boolean f3171b;
    /* renamed from: c */
    private float f3172c;
    /* renamed from: d */
    private float f3173d;
    /* renamed from: e */
    private List<BusStep> f3174e;

    public float getCost() {
        return this.f3170a;
    }

    public void setCost(float f) {
        this.f3170a = f;
    }

    public boolean isNightBus() {
        return this.f3171b;
    }

    public void setNightBus(boolean z) {
        this.f3171b = z;
    }

    public float getDistance() {
        return this.f3172c + this.f3173d;
    }

    public float getWalkDistance() {
        return this.f3172c;
    }

    public void setWalkDistance(float f) {
        this.f3172c = f;
    }

    public float getBusDistance() {
        return this.f3173d;
    }

    public void setBusDistance(float f) {
        this.f3173d = f;
    }

    public List<BusStep> getSteps() {
        return this.f3174e;
    }

    public void setSteps(List<BusStep> list) {
        this.f3174e = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f3170a);
        parcel.writeBooleanArray(new boolean[]{this.f3171b});
        parcel.writeFloat(this.f3172c);
        parcel.writeFloat(this.f3173d);
        parcel.writeTypedList(this.f3174e);
    }

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f3170a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f3171b = zArr[0];
        this.f3172c = parcel.readFloat();
        this.f3173d = parcel.readFloat();
        this.f3174e = parcel.createTypedArrayList(BusStep.CREATOR);
    }
}
