package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PoiItemDetail */
/* renamed from: com.amap.api.services.poisearch.g */
class C0520g implements Creator<PoiItemDetail> {
    C0520g() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4174a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4175a(i);
    }

    /* renamed from: a */
    public PoiItemDetail m4174a(Parcel parcel) {
        return new PoiItemDetail(parcel);
    }

    /* renamed from: a */
    public PoiItemDetail[] m4175a(int i) {
        return new PoiItemDetail[i];
    }
}
