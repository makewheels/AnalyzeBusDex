package com.amap.api.navi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: NaviLatLng */
/* renamed from: com.amap.api.navi.model.b */
class C0460b implements Creator<NaviLatLng> {
    C0460b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3922a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3923a(i);
    }

    /* renamed from: a */
    public NaviLatLng m3922a(Parcel parcel) {
        return new NaviLatLng(parcel.readDouble(), parcel.readDouble());
    }

    /* renamed from: a */
    public NaviLatLng[] m3923a(int i) {
        return new NaviLatLng[i];
    }
}
