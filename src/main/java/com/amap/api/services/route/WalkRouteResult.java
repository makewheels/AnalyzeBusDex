package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;
import java.util.List;

public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Creator<WalkRouteResult> CREATOR = new C0548u();
    /* renamed from: a */
    private List<WalkPath> f3243a;
    /* renamed from: b */
    private WalkRouteQuery f3244b;

    public List<WalkPath> getPaths() {
        return this.f3243a;
    }

    public void setPaths(List<WalkPath> list) {
        this.f3243a = list;
    }

    public WalkRouteQuery getWalkQuery() {
        return this.f3244b;
    }

    public void setWalkQuery(WalkRouteQuery walkRouteQuery) {
        this.f3244b = walkRouteQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3243a);
        parcel.writeParcelable(this.f3244b, i);
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f3243a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f3244b = (WalkRouteQuery) parcel.readParcelable(WalkRouteQuery.class.getClassLoader());
    }
}
