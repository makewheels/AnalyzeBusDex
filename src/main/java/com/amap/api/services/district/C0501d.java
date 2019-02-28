package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DistrictSearchQuery */
/* renamed from: com.amap.api.services.district.d */
class C0501d implements Creator<DistrictSearchQuery> {
    C0501d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4131a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4132a(i);
    }

    /* renamed from: a */
    public DistrictSearchQuery m4131a(Parcel parcel) {
        boolean z = true;
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(parcel.readString());
        districtSearchQuery.setKeywordsLevel(parcel.readString());
        districtSearchQuery.setPageNum(parcel.readInt());
        districtSearchQuery.setPageSize(parcel.readInt());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        districtSearchQuery.setShowChild(z);
        return districtSearchQuery;
    }

    /* renamed from: a */
    public DistrictSearchQuery[] m4132a(int i) {
        return new DistrictSearchQuery[i];
    }
}
