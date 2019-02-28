package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: OfflineMapProvince */
/* renamed from: com.amap.api.maps.offlinemap.i */
class C0431i implements Creator<OfflineMapProvince> {
    C0431i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3694a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3695a(i);
    }

    /* renamed from: a */
    public OfflineMapProvince m3694a(Parcel parcel) {
        return new OfflineMapProvince(parcel);
    }

    /* renamed from: a */
    public OfflineMapProvince[] m3695a(int i) {
        return new OfflineMapProvince[i];
    }
}
