package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Creator<RouteBusLineItem> CREATOR = new C0537j();
    /* renamed from: a */
    private BusStationItem f3206a;
    /* renamed from: b */
    private BusStationItem f3207b;
    /* renamed from: c */
    private List<LatLonPoint> f3208c;
    /* renamed from: d */
    private int f3209d;
    /* renamed from: e */
    private List<BusStationItem> f3210e;
    /* renamed from: f */
    private float f3211f;

    public BusStationItem getDepartureBusStation() {
        return this.f3206a;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f3206a = busStationItem;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f3207b;
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f3207b = busStationItem;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f3208c;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f3208c = list;
    }

    public int getPassStationNum() {
        return this.f3209d;
    }

    public void setPassStationNum(int i) {
        this.f3209d = i;
    }

    public List<BusStationItem> getPassStations() {
        return this.f3210e;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f3210e = list;
    }

    public float getDuration() {
        return this.f3211f;
    }

    public void setDuration(float f) {
        this.f3211f = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f3206a, i);
        parcel.writeParcelable(this.f3207b, i);
        parcel.writeTypedList(this.f3208c);
        parcel.writeInt(this.f3209d);
        parcel.writeTypedList(this.f3210e);
        parcel.writeFloat(this.f3211f);
    }

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f3206a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f3207b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f3208c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f3209d = parcel.readInt();
        this.f3210e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f3211f = parcel.readFloat();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3207b == null ? 0 : this.f3207b.hashCode()) + (super.hashCode() * 31)) * 31;
        if (this.f3206a != null) {
            i = this.f3206a.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        if (this.f3207b == null) {
            if (routeBusLineItem.f3207b != null) {
                return false;
            }
        } else if (!this.f3207b.equals(routeBusLineItem.f3207b)) {
            return false;
        }
        if (this.f3206a == null) {
            if (routeBusLineItem.f3206a != null) {
                return false;
            }
            return true;
        } else if (this.f3206a.equals(routeBusLineItem.f3206a)) {
            return true;
        } else {
            return false;
        }
    }
}
