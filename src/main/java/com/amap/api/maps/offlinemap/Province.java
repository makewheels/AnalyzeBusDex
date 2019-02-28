package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class Province implements Parcelable {
    public static final Creator<Province> CREATOR = new C0433l();
    /* renamed from: a */
    private String f2438a;
    /* renamed from: b */
    private String f2439b;
    /* renamed from: c */
    private String f2440c;
    /* renamed from: d */
    private String f2441d;
    /* renamed from: e */
    private ArrayList<OfflineMapCity> f2442e;

    public String getProvinceName() {
        return this.f2438a;
    }

    public String getJianpin() {
        return this.f2439b;
    }

    public String getPinyin() {
        return this.f2440c;
    }

    public void setProvinceName(String str) {
        this.f2438a = str;
    }

    public void setJianpin(String str) {
        this.f2439b = str;
    }

    public void setPinyin(String str) {
        this.f2440c = str;
    }

    public void setProvinceCode(String str) {
        this.f2441d = str;
    }

    public String getProvinceCode() {
        return this.f2441d;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        if (this.f2442e == null) {
            return new ArrayList();
        }
        return this.f2442e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f2442e = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2438a);
        parcel.writeString(this.f2439b);
        parcel.writeString(this.f2440c);
        parcel.writeString(this.f2441d);
        parcel.writeTypedList(this.f2442e);
    }

    public Province(Parcel parcel) {
        this.f2438a = parcel.readString();
        this.f2439b = parcel.readString();
        this.f2440c = parcel.readString();
        this.f2441d = parcel.readString();
        this.f2442e = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
