package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: GeocodeAddress */
/* renamed from: com.amap.api.services.geocoder.a */
class C0504a implements Creator<GeocodeAddress> {
    C0504a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4134a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4135a(i);
    }

    /* renamed from: a */
    public GeocodeAddress[] m4135a(int i) {
        return null;
    }

    /* renamed from: a */
    public GeocodeAddress m4134a(Parcel parcel) {
        return new GeocodeAddress(parcel);
    }
}
