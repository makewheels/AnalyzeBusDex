package com.amap.api.p015a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: GeoPoint */
/* renamed from: com.amap.api.a.ad */
class ad implements Creator<ac> {
    ad() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m830a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m831a(i);
    }

    /* renamed from: a */
    public ac m830a(Parcel parcel) {
        return new ac(parcel);
    }

    /* renamed from: a */
    public ac[] m831a(int i) {
        return new ac[i];
    }
}
