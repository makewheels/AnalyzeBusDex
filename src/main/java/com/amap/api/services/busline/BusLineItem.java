package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.C0480e;
import com.amap.api.services.core.LatLonPoint;
import java.util.Date;
import java.util.List;

public class BusLineItem implements Parcelable {
    public static final Creator<BusLineItem> CREATOR = new C0471a();
    /* renamed from: a */
    private float f2845a;
    /* renamed from: b */
    private String f2846b;
    /* renamed from: c */
    private String f2847c;
    /* renamed from: d */
    private String f2848d;
    /* renamed from: e */
    private List<LatLonPoint> f2849e;
    /* renamed from: f */
    private List<LatLonPoint> f2850f;
    /* renamed from: g */
    private String f2851g;
    /* renamed from: h */
    private String f2852h;
    /* renamed from: i */
    private String f2853i;
    /* renamed from: j */
    private Date f2854j;
    /* renamed from: k */
    private Date f2855k;
    /* renamed from: l */
    private String f2856l;
    /* renamed from: m */
    private float f2857m;
    /* renamed from: n */
    private float f2858n;
    /* renamed from: o */
    private List<BusStationItem> f2859o;

    public float getDistance() {
        return this.f2845a;
    }

    public void setDistance(float f) {
        this.f2845a = f;
    }

    public String getBusLineName() {
        return this.f2846b;
    }

    public void setBusLineName(String str) {
        this.f2846b = str;
    }

    public String getBusLineType() {
        return this.f2847c;
    }

    public void setBusLineType(String str) {
        this.f2847c = str;
    }

    public String getCityCode() {
        return this.f2848d;
    }

    public void setCityCode(String str) {
        this.f2848d = str;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f2849e;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f2849e = list;
    }

    public List<LatLonPoint> getBounds() {
        return this.f2850f;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f2850f = list;
    }

    public String getBusLineId() {
        return this.f2851g;
    }

    public void setBusLineId(String str) {
        this.f2851g = str;
    }

    public String getOriginatingStation() {
        return this.f2852h;
    }

    public void setOriginatingStation(String str) {
        this.f2852h = str;
    }

    public String getTerminalStation() {
        return this.f2853i;
    }

    public void setTerminalStation(String str) {
        this.f2853i = str;
    }

    public Date getFirstBusTime() {
        if (this.f2854j == null) {
            return null;
        }
        return (Date) this.f2854j.clone();
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f2854j = null;
        } else {
            this.f2854j = (Date) date.clone();
        }
    }

    public Date getLastBusTime() {
        if (this.f2855k == null) {
            return null;
        }
        return (Date) this.f2855k.clone();
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f2855k = null;
        } else {
            this.f2855k = (Date) date.clone();
        }
    }

    public String getBusCompany() {
        return this.f2856l;
    }

    public void setBusCompany(String str) {
        this.f2856l = str;
    }

    public float getBasicPrice() {
        return this.f2857m;
    }

    public void setBasicPrice(float f) {
        this.f2857m = f;
    }

    public float getTotalPrice() {
        return this.f2858n;
    }

    public void setTotalPrice(float f) {
        this.f2858n = f;
    }

    public List<BusStationItem> getBusStations() {
        return this.f2859o;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f2859o = list;
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
        BusLineItem busLineItem = (BusLineItem) obj;
        if (this.f2851g == null) {
            if (busLineItem.f2851g != null) {
                return false;
            }
            return true;
        } else if (this.f2851g.equals(busLineItem.f2851g)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (this.f2851g == null ? 0 : this.f2851g.hashCode()) + 31;
    }

    public String toString() {
        return this.f2846b + " " + C0480e.m4016a(this.f2854j) + "-" + C0480e.m4016a(this.f2855k);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f2845a);
        parcel.writeString(this.f2846b);
        parcel.writeString(this.f2847c);
        parcel.writeString(this.f2848d);
        parcel.writeList(this.f2849e);
        parcel.writeList(this.f2850f);
        parcel.writeString(this.f2851g);
        parcel.writeString(this.f2852h);
        parcel.writeString(this.f2853i);
        parcel.writeString(C0480e.m4016a(this.f2854j));
        parcel.writeString(C0480e.m4016a(this.f2855k));
        parcel.writeString(this.f2856l);
        parcel.writeFloat(this.f2857m);
        parcel.writeFloat(this.f2858n);
        parcel.writeList(this.f2859o);
    }

    public BusLineItem(Parcel parcel) {
        this.f2845a = parcel.readFloat();
        this.f2846b = parcel.readString();
        this.f2847c = parcel.readString();
        this.f2848d = parcel.readString();
        this.f2849e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f2850f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f2851g = parcel.readString();
        this.f2852h = parcel.readString();
        this.f2853i = parcel.readString();
        this.f2854j = C0480e.m4028e(parcel.readString());
        this.f2855k = C0480e.m4028e(parcel.readString());
        this.f2856l = parcel.readString();
        this.f2857m = parcel.readFloat();
        this.f2858n = parcel.readFloat();
        this.f2859o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
