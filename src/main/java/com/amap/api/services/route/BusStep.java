package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class BusStep implements Parcelable {
    public static final Creator<BusStep> CREATOR = new C0530c();
    /* renamed from: a */
    private RouteBusWalkItem f3180a;
    /* renamed from: b */
    private List<RouteBusLineItem> f3181b;
    /* renamed from: c */
    private Doorway f3182c;
    /* renamed from: d */
    private Doorway f3183d;

    public RouteBusWalkItem getWalk() {
        return this.f3180a;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f3180a = routeBusWalkItem;
    }

    public RouteBusLineItem getBusLine() {
        if (this.f3181b == null || this.f3181b.size() == 0) {
            return null;
        }
        return (RouteBusLineItem) this.f3181b.get(0);
    }

    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        if (this.f3181b != null) {
            if (this.f3181b.size() == 0) {
                this.f3181b.add(routeBusLineItem);
            }
            this.f3181b.set(0, routeBusLineItem);
        }
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f3181b = list;
    }

    public Doorway getEntrance() {
        return this.f3182c;
    }

    public void setEntrance(Doorway doorway) {
        this.f3182c = doorway;
    }

    public Doorway getExit() {
        return this.f3183d;
    }

    public void setExit(Doorway doorway) {
        this.f3183d = doorway;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3180a, i);
        parcel.writeTypedList(this.f3181b);
        parcel.writeParcelable(this.f3182c, i);
        parcel.writeParcelable(this.f3183d, i);
    }

    public BusStep(Parcel parcel) {
        this.f3180a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f3181b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f3182c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f3183d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
    }
}
