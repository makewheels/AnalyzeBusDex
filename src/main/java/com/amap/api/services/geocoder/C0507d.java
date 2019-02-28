package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RegeocodeRoad */
/* renamed from: com.amap.api.services.geocoder.d */
class C0507d implements Creator<RegeocodeRoad> {
    C0507d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4138a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4139a(i);
    }

    /* renamed from: a */
    public RegeocodeRoad m4138a(Parcel parcel) {
        return new RegeocodeRoad(parcel);
    }

    /* renamed from: a */
    public RegeocodeRoad[] m4139a(int i) {
        return null;
    }
}
