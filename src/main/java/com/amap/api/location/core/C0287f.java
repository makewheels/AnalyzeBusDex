package com.amap.api.location.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: GeoPoint */
/* renamed from: com.amap.api.location.core.f */
class C0287f implements Creator<GeoPoint> {
    C0287f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1858a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1859a(i);
    }

    /* renamed from: a */
    public GeoPoint m1858a(Parcel parcel) {
        return new GeoPoint(parcel);
    }

    /* renamed from: a */
    public GeoPoint[] m1859a(int i) {
        return new GeoPoint[i];
    }
}
