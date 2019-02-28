package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Hotel */
/* renamed from: com.amap.api.services.poisearch.e */
class C0518e implements Creator<Hotel> {
    C0518e() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4170a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4171a(i);
    }

    /* renamed from: a */
    public Hotel m4170a(Parcel parcel) {
        return new Hotel(parcel);
    }

    /* renamed from: a */
    public Hotel[] m4171a(int i) {
        return null;
    }
}
