package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;
import java.util.List;

public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Creator<BusRouteResult> CREATOR = new C0529b();
    /* renamed from: a */
    private float f3177a;
    /* renamed from: b */
    private List<BusPath> f3178b;
    /* renamed from: c */
    private BusRouteQuery f3179c;

    public float getTaxiCost() {
        return this.f3177a;
    }

    public void setTaxiCost(float f) {
        this.f3177a = f;
    }

    public List<BusPath> getPaths() {
        return this.f3178b;
    }

    public void setPaths(List<BusPath> list) {
        this.f3178b = list;
    }

    public BusRouteQuery getBusQuery() {
        return this.f3179c;
    }

    public void setBusQuery(BusRouteQuery busRouteQuery) {
        this.f3179c = busRouteQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f3177a);
        parcel.writeTypedList(this.f3178b);
        parcel.writeParcelable(this.f3179c, i);
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f3177a = parcel.readFloat();
        this.f3178b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f3179c = (BusRouteQuery) parcel.readParcelable(BusRouteQuery.class.getClassLoader());
    }
}
