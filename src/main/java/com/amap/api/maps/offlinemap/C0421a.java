package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: City */
/* renamed from: com.amap.api.maps.offlinemap.a */
class C0421a implements Creator<City> {
    C0421a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3649a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3650a(i);
    }

    /* renamed from: a */
    public City m3649a(Parcel parcel) {
        return new City(parcel);
    }

    /* renamed from: a */
    public City[] m3650a(int i) {
        return new City[i];
    }
}
