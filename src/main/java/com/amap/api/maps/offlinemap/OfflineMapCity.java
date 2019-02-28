package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import p054u.aly.bi_常量类;

public class OfflineMapCity extends City {
    public static final Creator<OfflineMapCity> CREATOR = new C0430h();
    /* renamed from: a */
    private String f2411a = bi_常量类.f6358b_空串;
    /* renamed from: b */
    private long f2412b = 0;
    /* renamed from: c */
    private int f2413c = 6;
    /* renamed from: d */
    private String f2414d = bi_常量类.f6358b_空串;
    /* renamed from: e */
    private int f2415e = 0;

    public String getUrl() {
        return this.f2411a;
    }

    public void setUrl(String str) {
        this.f2411a = str;
    }

    public long getSize() {
        return this.f2412b;
    }

    public void setSize(long j) {
        this.f2412b = j;
    }

    public int getState() {
        return this.f2413c;
    }

    public void setState(int i) {
        this.f2413c = i;
    }

    public String getVersion() {
        return this.f2414d;
    }

    public void setVersion(String str) {
        this.f2414d = str;
    }

    public int getcompleteCode() {
        return this.f2415e;
    }

    public void setCompleteCode(int i) {
        this.f2415e = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2411a);
        parcel.writeLong(this.f2412b);
        parcel.writeInt(this.f2413c);
        parcel.writeString(this.f2414d);
        parcel.writeInt(this.f2415e);
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f2411a = parcel.readString();
        this.f2412b = parcel.readLong();
        this.f2413c = parcel.readInt();
        this.f2414d = parcel.readString();
        this.f2415e = parcel.readInt();
    }
}
