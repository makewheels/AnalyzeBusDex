package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RegeocodeAddress */
/* renamed from: com.amap.api.services.geocoder.c */
class C0506c implements Creator<RegeocodeAddress> {
    C0506c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4136a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4137a(i);
    }

    /* renamed from: a */
    public RegeocodeAddress m4136a(Parcel parcel) {
        return new RegeocodeAddress(parcel);
    }

    /* renamed from: a */
    public RegeocodeAddress[] m4137a(int i) {
        return null;
    }
}
