package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Creator<RouteBusWalkItem> CREATOR = new C0538k();
    /* renamed from: a */
    private LatLonPoint f3213a;
    /* renamed from: b */
    private LatLonPoint f3214b;

    public LatLonPoint getOrigin() {
        return this.f3213a;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f3213a = latLonPoint;
    }

    public LatLonPoint getDestination() {
        return this.f3214b;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f3214b = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f3213a, i);
        parcel.writeParcelable(this.f3214b, i);
    }

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f3213a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f3214b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
