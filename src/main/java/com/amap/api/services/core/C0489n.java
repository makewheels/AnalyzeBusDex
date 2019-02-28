package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LatLonPoint */
/* renamed from: com.amap.api.services.core.n */
class C0489n implements Creator<LatLonPoint> {
    C0489n() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4098a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4099a(i);
    }

    /* renamed from: a */
    public LatLonPoint m4098a(Parcel parcel) {
        return new LatLonPoint(parcel);
    }

    /* renamed from: a */
    public LatLonPoint[] m4099a(int i) {
        return new LatLonPoint[i];
    }
}
