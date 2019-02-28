package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OfflineMapProvince extends Province {
    public static final Creator<OfflineMapProvince> CREATOR = new C0431i();
    /* renamed from: a */
    private String f2443a;
    /* renamed from: b */
    private int f2444b = 6;
    /* renamed from: c */
    private long f2445c;
    /* renamed from: d */
    private String f2446d;
    /* renamed from: e */
    private int f2447e = 0;

    public String getUrl() {
        return this.f2443a;
    }

    public void setUrl(String str) {
        this.f2443a = str;
    }

    public int getState() {
        return this.f2444b;
    }

    public void setState(int i) {
        this.f2444b = i;
    }

    public long getSize() {
        return this.f2445c;
    }

    public void setSize(long j) {
        this.f2445c = j;
    }

    public String getVersion() {
        return this.f2446d;
    }

    public void setVersion(String str) {
        this.f2446d = str;
    }

    public int getcompleteCode() {
        return this.f2447e;
    }

    public void setCompleteCode(int i) {
        this.f2447e = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2443a);
        parcel.writeInt(this.f2444b);
        parcel.writeLong(this.f2445c);
        parcel.writeString(this.f2446d);
        parcel.writeInt(this.f2447e);
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f2443a = parcel.readString();
        this.f2444b = parcel.readInt();
        this.f2445c = parcel.readLong();
        this.f2446d = parcel.readString();
        this.f2447e = parcel.readInt();
    }
}
