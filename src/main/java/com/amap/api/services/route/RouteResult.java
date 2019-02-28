package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class RouteResult implements Parcelable {
    public static final Creator<RouteResult> CREATOR = new C0539l();
    /* renamed from: a */
    private LatLonPoint f3175a;
    /* renamed from: b */
    private LatLonPoint f3176b;

    public LatLonPoint getStartPos() {
        return this.f3175a;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f3175a = latLonPoint;
    }

    public LatLonPoint getTargetPos() {
        return this.f3176b;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f3176b = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3175a, i);
        parcel.writeParcelable(this.f3176b, i);
    }

    public RouteResult(Parcel parcel) {
        this.f3175a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f3176b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
