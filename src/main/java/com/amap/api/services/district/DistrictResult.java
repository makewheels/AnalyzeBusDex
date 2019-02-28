package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

public final class DistrictResult implements Parcelable {
    public Creator<DistrictResult> CREATOR = new C0499b(this);
    /* renamed from: a */
    private DistrictSearchQuery f2961a;
    /* renamed from: b */
    private ArrayList<DistrictItem> f2962b;
    /* renamed from: c */
    private int f2963c;
    /* renamed from: d */
    private AMapException f2964d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f2961a = districtSearchQuery;
        this.f2962b = arrayList;
    }

    public ArrayList<DistrictItem> getDistrict() {
        return this.f2962b;
    }

    public void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f2962b = arrayList;
    }

    public DistrictSearchQuery getQuery() {
        return this.f2961a;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f2961a = districtSearchQuery;
    }

    public int getPageCount() {
        return this.f2963c;
    }

    public void setPageCount(int i) {
        this.f2963c = i;
    }

    public AMapException getAMapException() {
        return this.f2964d;
    }

    public void setAMapException(AMapException aMapException) {
        this.f2964d = aMapException;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2961a, i);
        parcel.writeTypedList(this.f2962b);
    }

    protected DistrictResult(Parcel parcel) {
        this.f2961a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f2962b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f2961a == null ? 0 : this.f2961a.hashCode()) + 31) * 31;
        if (this.f2962b != null) {
            i = this.f2962b.hashCode();
        }
        return hashCode + i;
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
        DistrictResult districtResult = (DistrictResult) obj;
        if (this.f2961a == null) {
            if (districtResult.f2961a != null) {
                return false;
            }
        } else if (!this.f2961a.equals(districtResult.f2961a)) {
            return false;
        }
        if (this.f2962b == null) {
            if (districtResult.f2962b != null) {
                return false;
            }
            return true;
        } else if (this.f2962b.equals(districtResult.f2962b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.f2961a + ", mDistricts=" + this.f2962b + "]";
    }
}
