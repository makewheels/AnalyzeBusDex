package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class BusStationItem implements Parcelable {
    public static final Creator<BusStationItem> CREATOR = new C0473c();
    /* renamed from: a */
    private String f2879a;
    /* renamed from: b */
    private String f2880b;
    /* renamed from: c */
    private LatLonPoint f2881c;
    /* renamed from: d */
    private String f2882d;
    /* renamed from: e */
    private String f2883e;
    /* renamed from: f */
    private List<BusLineItem> f2884f;

    public String getBusStationId() {
        return this.f2879a;
    }

    public void setBusStationId(String str) {
        this.f2879a = str;
    }

    public String getBusStationName() {
        return this.f2880b;
    }

    public void setBusStationName(String str) {
        this.f2880b = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f2881c;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f2881c = latLonPoint;
    }

    public String getCityCode() {
        return this.f2882d;
    }

    public void setCityCode(String str) {
        this.f2882d = str;
    }

    public String getAdCode() {
        return this.f2883e;
    }

    public void setAdCode(String str) {
        this.f2883e = str;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f2884f;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f2884f = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BusStationItem busStationItem = (BusStationItem) obj;
        if (this.f2879a == null) {
            if (busStationItem.f2879a != null) {
                return false;
            }
            return true;
        } else if (this.f2879a.equals(busStationItem.f2879a)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (this.f2879a == null ? 0 : this.f2879a.hashCode()) + 31;
    }

    public String toString() {
        return "BusStationName: " + this.f2880b + " LatLonPoint: " + this.f2881c.toString() + " BusLines: " + m3976a(this.f2884f) + " CityCode: " + this.f2882d + " AdCode: " + this.f2883e;
    }

    /* renamed from: a */
    private String m3976a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(((BusLineItem) list.get(i)).getBusLineName());
                if (i < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2880b);
        parcel.writeString(this.f2879a);
        parcel.writeValue(this.f2881c);
        parcel.writeString(this.f2882d);
        parcel.writeString(this.f2883e);
        parcel.writeList(this.f2884f);
    }

    private BusStationItem(Parcel parcel) {
        this.f2880b = parcel.readString();
        this.f2879a = parcel.readString();
        this.f2881c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f2882d = parcel.readString();
        this.f2883e = parcel.readString();
        this.f2884f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
