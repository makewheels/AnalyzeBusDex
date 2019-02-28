package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: OfflineMapCity */
/* renamed from: com.amap.api.maps.offlinemap.h */
class C0430h implements Creator<OfflineMapCity> {
    C0430h() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3692a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3693a(i);
    }

    /* renamed from: a */
    public OfflineMapCity m3692a(Parcel parcel) {
        return new OfflineMapCity(parcel);
    }

    /* renamed from: a */
    public OfflineMapCity[] m3693a(int i) {
        return new OfflineMapCity[i];
    }
}
