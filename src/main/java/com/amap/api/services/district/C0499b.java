package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DistrictResult */
/* renamed from: com.amap.api.services.district.b */
class C0499b implements Creator<DistrictResult> {
    /* renamed from: a */
    final /* synthetic */ DistrictResult f2978a;

    C0499b(DistrictResult districtResult) {
        this.f2978a = districtResult;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4129a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4130a(i);
    }

    /* renamed from: a */
    public DistrictResult m4129a(Parcel parcel) {
        return new DistrictResult(parcel);
    }

    /* renamed from: a */
    public DistrictResult[] m4130a(int i) {
        return new DistrictResult[i];
    }
}
