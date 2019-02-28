package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DistrictItem */
/* renamed from: com.amap.api.services.district.a */
class C0498a implements Creator<DistrictItem> {
    C0498a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4127a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4128a(i);
    }

    /* renamed from: a */
    public DistrictItem m4127a(Parcel parcel) {
        return new DistrictItem(parcel);
    }

    /* renamed from: a */
    public DistrictItem[] m4128a(int i) {
        return new DistrictItem[i];
    }
}
