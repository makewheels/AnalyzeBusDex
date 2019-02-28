package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Creator<RouteSearchCity> CREATOR = new C0545r();
    /* renamed from: a */
    List<District> f3242a;

    public List<District> getDistricts() {
        return this.f3242a;
    }

    public void setDistricts(List<District> list) {
        this.f3242a = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3242a);
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f3242a = parcel.createTypedArrayList(District.CREATOR);
    }
}
