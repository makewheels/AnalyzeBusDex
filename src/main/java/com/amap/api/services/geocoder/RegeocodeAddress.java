package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.List;

public final class RegeocodeAddress implements Parcelable {
    public static final Creator<RegeocodeAddress> CREATOR = new C0506c();
    /* renamed from: a */
    private String f3001a;
    /* renamed from: b */
    private String f3002b;
    /* renamed from: c */
    private String f3003c;
    /* renamed from: d */
    private String f3004d;
    /* renamed from: e */
    private String f3005e;
    /* renamed from: f */
    private String f3006f;
    /* renamed from: g */
    private String f3007g;
    /* renamed from: h */
    private StreetNumber f3008h;
    /* renamed from: i */
    private String f3009i;
    /* renamed from: j */
    private String f3010j;
    /* renamed from: k */
    private List<RegeocodeRoad> f3011k;
    /* renamed from: l */
    private List<Crossroad> f3012l;
    /* renamed from: m */
    private List<PoiItem> f3013m;

    public String getFormatAddress() {
        return this.f3001a;
    }

    public void setFormatAddress(String str) {
        this.f3001a = str;
    }

    public String getProvince() {
        return this.f3002b;
    }

    public void setProvince(String str) {
        this.f3002b = str;
    }

    public String getCity() {
        return this.f3003c;
    }

    public void setCity(String str) {
        this.f3003c = str;
    }

    public String getCityCode() {
        return this.f3009i;
    }

    public void setCityCode(String str) {
        this.f3009i = str;
    }

    public String getAdCode() {
        return this.f3010j;
    }

    public void setAdCode(String str) {
        this.f3010j = str;
    }

    public String getDistrict() {
        return this.f3004d;
    }

    public void setDistrict(String str) {
        this.f3004d = str;
    }

    public String getTownship() {
        return this.f3005e;
    }

    public void setTownship(String str) {
        this.f3005e = str;
    }

    public String getNeighborhood() {
        return this.f3006f;
    }

    public void setNeighborhood(String str) {
        this.f3006f = str;
    }

    public String getBuilding() {
        return this.f3007g;
    }

    public void setBuilding(String str) {
        this.f3007g = str;
    }

    public StreetNumber getStreetNumber() {
        return this.f3008h;
    }

    public void setStreetNumber(StreetNumber streetNumber) {
        this.f3008h = streetNumber;
    }

    public List<RegeocodeRoad> getRoads() {
        return this.f3011k;
    }

    public void setRoads(List<RegeocodeRoad> list) {
        this.f3011k = list;
    }

    public List<PoiItem> getPois() {
        return this.f3013m;
    }

    public void setPois(List<PoiItem> list) {
        this.f3013m = list;
    }

    public List<Crossroad> getCrossroads() {
        return this.f3012l;
    }

    public void setCrossroads(List<Crossroad> list) {
        this.f3012l = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3001a);
        parcel.writeString(this.f3002b);
        parcel.writeString(this.f3003c);
        parcel.writeString(this.f3004d);
        parcel.writeString(this.f3005e);
        parcel.writeString(this.f3006f);
        parcel.writeString(this.f3007g);
        parcel.writeValue(this.f3008h);
        parcel.writeList(this.f3011k);
        parcel.writeList(this.f3012l);
        parcel.writeList(this.f3013m);
        parcel.writeString(this.f3009i);
        parcel.writeString(this.f3010j);
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f3001a = parcel.readString();
        this.f3002b = parcel.readString();
        this.f3003c = parcel.readString();
        this.f3004d = parcel.readString();
        this.f3005e = parcel.readString();
        this.f3006f = parcel.readString();
        this.f3007g = parcel.readString();
        this.f3008h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f3011k = parcel.readArrayList(Road.class.getClassLoader());
        this.f3012l = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f3013m = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f3009i = parcel.readString();
        this.f3010j = parcel.readString();
    }
}
