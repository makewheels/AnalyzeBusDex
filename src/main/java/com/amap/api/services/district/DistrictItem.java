package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public final class DistrictItem implements Parcelable {
    public static final Creator<DistrictItem> CREATOR = new C0498a();
    /* renamed from: a */
    private String f2955a;
    /* renamed from: b */
    private String f2956b;
    /* renamed from: c */
    private String f2957c;
    /* renamed from: d */
    private LatLonPoint f2958d;
    /* renamed from: e */
    private String f2959e;
    /* renamed from: f */
    private List<DistrictItem> f2960f;

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f2957c = str;
        this.f2955a = str2;
        this.f2956b = str3;
        this.f2958d = latLonPoint;
        this.f2959e = str4;
    }

    public String getCitycode() {
        return this.f2955a;
    }

    public void setCitycode(String str) {
        this.f2955a = str;
    }

    public String getAdcode() {
        return this.f2956b;
    }

    public void setAdcode(String str) {
        this.f2956b = str;
    }

    public String getName() {
        return this.f2957c;
    }

    public void setName(String str) {
        this.f2957c = str;
    }

    public LatLonPoint getCenter() {
        return this.f2958d;
    }

    public void setCenter(LatLonPoint latLonPoint) {
        this.f2958d = latLonPoint;
    }

    public String getLevel() {
        return this.f2959e;
    }

    public void setLevel(String str) {
        this.f2959e = str;
    }

    public List<DistrictItem> getSubDistrict() {
        return this.f2960f;
    }

    public void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f2960f = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2955a);
        parcel.writeString(this.f2956b);
        parcel.writeString(this.f2957c);
        parcel.writeParcelable(this.f2958d, i);
        parcel.writeString(this.f2959e);
        parcel.writeTypedList(this.f2960f);
    }

    public DistrictItem(Parcel parcel) {
        this.f2955a = parcel.readString();
        this.f2956b = parcel.readString();
        this.f2957c = parcel.readString();
        this.f2958d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f2959e = parcel.readString();
        this.f2960f = parcel.createTypedArrayList(CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f2959e == null ? 0 : this.f2959e.hashCode()) + (((this.f2960f == null ? 0 : this.f2960f.hashCode()) + (((this.f2955a == null ? 0 : this.f2955a.hashCode()) + (((this.f2958d == null ? 0 : this.f2958d.hashCode()) + (((this.f2956b == null ? 0 : this.f2956b.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f2957c != null) {
            i = this.f2957c.hashCode();
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
        DistrictItem districtItem = (DistrictItem) obj;
        if (this.f2956b == null) {
            if (districtItem.f2956b != null) {
                return false;
            }
        } else if (!this.f2956b.equals(districtItem.f2956b)) {
            return false;
        }
        if (this.f2958d == null) {
            if (districtItem.f2958d != null) {
                return false;
            }
        } else if (!this.f2958d.equals(districtItem.f2958d)) {
            return false;
        }
        if (this.f2955a == null) {
            if (districtItem.f2955a != null) {
                return false;
            }
        } else if (!this.f2955a.equals(districtItem.f2955a)) {
            return false;
        }
        if (this.f2960f == null) {
            if (districtItem.f2960f != null) {
                return false;
            }
        } else if (!this.f2960f.equals(districtItem.f2960f)) {
            return false;
        }
        if (this.f2959e == null) {
            if (districtItem.f2959e != null) {
                return false;
            }
        } else if (!this.f2959e.equals(districtItem.f2959e)) {
            return false;
        }
        if (this.f2957c == null) {
            if (districtItem.f2957c != null) {
                return false;
            }
            return true;
        } else if (this.f2957c.equals(districtItem.f2957c)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.f2955a + ", mAdcode=" + this.f2956b + ", mName=" + this.f2957c + ", mCenter=" + this.f2958d + ", mLevel=" + this.f2959e + ", mDistricts=" + this.f2960f + "]";
    }
}
