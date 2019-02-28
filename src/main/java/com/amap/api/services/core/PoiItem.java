package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p054u.aly.bi_常量类;

public class PoiItem implements Parcelable {
    public static final Creator<PoiItem> CREATOR = new C0491p();
    /* renamed from: a */
    private String f2908a;
    /* renamed from: b */
    private String f2909b;
    /* renamed from: c */
    private String f2910c;
    /* renamed from: d */
    private String f2911d;
    /* renamed from: e */
    private String f2912e = bi_常量类.f6358b_空串;
    /* renamed from: f */
    private int f2913f = -1;
    /* renamed from: g */
    private LatLonPoint f2914g;
    /* renamed from: h */
    private LatLonPoint f2915h;
    /* renamed from: i */
    private String f2916i;
    /* renamed from: j */
    private String f2917j;
    /* renamed from: k */
    private String f2918k;
    /* renamed from: l */
    private boolean f2919l;
    /* renamed from: m */
    private boolean f2920m;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;
    /* renamed from: n */
    private String f2921n;
    /* renamed from: o */
    private String f2922o;
    /* renamed from: p */
    private String f2923p;
    /* renamed from: q */
    private String f2924q;
    /* renamed from: r */
    private boolean f2925r;
    /* renamed from: s */
    private String f2926s;

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f2908a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    public String getAdName() {
        return this.f2924q;
    }

    public void setAdName(String str) {
        this.f2924q = str;
    }

    public String getCityName() {
        return this.f2923p;
    }

    public void setCityName(String str) {
        this.f2923p = str;
    }

    public String getProvinceName() {
        return this.f2922o;
    }

    public void setProvinceName(String str) {
        this.f2922o = str;
    }

    public String getTypeDes() {
        return this.f2912e;
    }

    public void setTypeDes(String str) {
        this.f2912e = str;
    }

    public String getTel() {
        return this.f2909b;
    }

    public void setTel(String str) {
        this.f2909b = str;
    }

    public String getAdCode() {
        return this.f2910c;
    }

    public void setAdCode(String str) {
        this.f2910c = str;
    }

    public String getPoiId() {
        return this.f2908a;
    }

    public int getDistance() {
        return this.f2913f;
    }

    public void setDistance(int i) {
        this.f2913f = i;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getCityCode() {
        return this.f2911d;
    }

    public void setCityCode(String str) {
        this.f2911d = str;
    }

    public LatLonPoint getEnter() {
        return this.f2914g;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f2914g = latLonPoint;
    }

    public LatLonPoint getExit() {
        return this.f2915h;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f2915h = latLonPoint;
    }

    public String getWebsite() {
        return this.f2916i;
    }

    public void setWebsite(String str) {
        this.f2916i = str;
    }

    public String getPostcode() {
        return this.f2917j;
    }

    public void setPostcode(String str) {
        this.f2917j = str;
    }

    public String getEmail() {
        return this.f2918k;
    }

    public void setEmail(String str) {
        this.f2918k = str;
    }

    public boolean isGroupbuyInfo() {
        return this.f2919l;
    }

    public void setGroupbuyInfo(boolean z) {
        this.f2919l = z;
    }

    public boolean isDiscountInfo() {
        return this.f2920m;
    }

    public void setDiscountInfo(boolean z) {
        this.f2920m = z;
    }

    public String getDirection() {
        return this.f2921n;
    }

    public void setDirection(String str) {
        this.f2921n = str;
    }

    public void setIndoorMap(boolean z) {
        this.f2925r = z;
    }

    public boolean isIndoorMap() {
        return this.f2925r;
    }

    public void setProvinceCode(String str) {
        this.f2926s = str;
    }

    public String getProvinceCode() {
        return this.f2926s;
    }

    protected PoiItem(Parcel parcel) {
        this.f2908a = parcel.readString();
        this.f2910c = parcel.readString();
        this.f2909b = parcel.readString();
        this.f2912e = parcel.readString();
        this.f2913f = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f2911d = parcel.readString();
        this.f2914g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f2915h = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f2916i = parcel.readString();
        this.f2917j = parcel.readString();
        this.f2918k = parcel.readString();
        boolean[] zArr = new boolean[3];
        parcel.readBooleanArray(zArr);
        this.f2919l = zArr[0];
        this.f2920m = zArr[1];
        this.f2925r = zArr[2];
        this.f2921n = parcel.readString();
        this.f2922o = parcel.readString();
        this.f2923p = parcel.readString();
        this.f2924q = parcel.readString();
        this.f2926s = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2908a);
        parcel.writeString(this.f2910c);
        parcel.writeString(this.f2909b);
        parcel.writeString(this.f2912e);
        parcel.writeInt(this.f2913f);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f2911d);
        parcel.writeValue(this.f2914g);
        parcel.writeValue(this.f2915h);
        parcel.writeString(this.f2916i);
        parcel.writeString(this.f2917j);
        parcel.writeString(this.f2918k);
        parcel.writeBooleanArray(new boolean[]{this.f2919l, this.f2920m, this.f2925r});
        parcel.writeString(this.f2921n);
        parcel.writeString(this.f2922o);
        parcel.writeString(this.f2923p);
        parcel.writeString(this.f2924q);
        parcel.writeString(this.f2926s);
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
        PoiItem poiItem = (PoiItem) obj;
        if (this.f2908a == null) {
            if (poiItem.f2908a != null) {
                return false;
            }
            return true;
        } else if (this.f2908a.equals(poiItem.f2908a)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (this.f2908a == null ? 0 : this.f2908a.hashCode()) + 31;
    }

    public String toString() {
        return this.mTitle;
    }
}
