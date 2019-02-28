package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p054u.aly.bi_常量类;

public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Creator<DistrictSearchQuery> CREATOR = new C0501d();
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";
    /* renamed from: a */
    private int f2973a;
    /* renamed from: b */
    private int f2974b;
    /* renamed from: c */
    private String f2975c;
    /* renamed from: d */
    private String f2976d;
    /* renamed from: e */
    private boolean f2977e;

    public DistrictSearchQuery() {
        this.f2973a = 0;
        this.f2974b = 20;
        this.f2977e = true;
    }

    public DistrictSearchQuery(String str, String str2, int i) {
        this.f2973a = 0;
        this.f2974b = 20;
        this.f2977e = true;
        this.f2975c = str;
        this.f2976d = str2;
        this.f2973a = i;
    }

    public DistrictSearchQuery(String str, String str2, int i, boolean z, int i2) {
        this(str, str2, i);
        this.f2977e = z;
        this.f2974b = i2;
    }

    public int getPageNum() {
        return this.f2973a;
    }

    public void setPageNum(int i) {
        this.f2973a = i;
    }

    public int getPageSize() {
        return this.f2974b;
    }

    public void setPageSize(int i) {
        this.f2974b = i;
    }

    public String getKeywords() {
        return this.f2975c;
    }

    public void setKeywords(String str) {
        this.f2975c = str;
    }

    public String getKeywordsLevel() {
        return this.f2976d;
    }

    public void setKeywordsLevel(String str) {
        this.f2976d = str;
    }

    public boolean isShowChild() {
        return this.f2977e;
    }

    public void setShowChild(boolean z) {
        this.f2977e = z;
    }

    public boolean checkLevels() {
        if (this.f2976d == null) {
            return false;
        }
        if (this.f2976d.trim().equals(KEYWORDS_COUNTRY) || this.f2976d.trim().equals(KEYWORDS_PROVINCE) || this.f2976d.trim().equals(KEYWORDS_CITY) || this.f2976d.trim().equals(KEYWORDS_DISTRICT) || this.f2976d.trim().equals(KEYWORDS_BUSINESS)) {
            return true;
        }
        return false;
    }

    public boolean checkKeyWords() {
        if (this.f2975c == null || this.f2975c.trim().equalsIgnoreCase(bi_常量类.f6358b_空串)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f2975c == null ? 0 : this.f2975c.hashCode()) + 31) * 31;
        if (this.f2976d != null) {
            i = this.f2976d.hashCode();
        }
        return (this.f2977e ? 1231 : 1237) + ((((((hashCode + i) * 31) + this.f2973a) * 31) + this.f2974b) * 31);
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
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.f2975c == null) {
            if (districtSearchQuery.f2975c != null) {
                return false;
            }
        } else if (!this.f2975c.equals(districtSearchQuery.f2975c)) {
            return false;
        }
        if (this.f2976d == null) {
            if (districtSearchQuery.f2976d != null) {
                return false;
            }
        } else if (!this.f2976d.equals(districtSearchQuery.f2976d)) {
            return false;
        }
        if (this.f2973a != districtSearchQuery.f2973a) {
            return false;
        }
        if (this.f2974b != districtSearchQuery.f2974b) {
            return false;
        }
        if (this.f2977e != districtSearchQuery.f2977e) {
            return false;
        }
        return true;
    }

    protected boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        if (this.f2975c == null) {
            if (districtSearchQuery.f2975c != null) {
                return false;
            }
        } else if (!this.f2975c.equals(districtSearchQuery.f2975c)) {
            return false;
        }
        if (this.f2976d == null) {
            if (districtSearchQuery.f2976d != null) {
                return false;
            }
        } else if (!this.f2976d.equals(districtSearchQuery.f2976d)) {
            return false;
        }
        if (this.f2974b != districtSearchQuery.f2974b) {
            return false;
        }
        if (this.f2977e != districtSearchQuery.f2977e) {
            return false;
        }
        return true;
    }

    public DistrictSearchQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new DistrictSearchQuery(this.f2975c, this.f2976d, this.f2973a, this.f2977e, this.f2974b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2975c);
        parcel.writeString(this.f2976d);
        parcel.writeInt(this.f2973a);
        parcel.writeInt(this.f2974b);
        parcel.writeByte((byte) (this.f2977e ? 1 : 0));
    }
}
