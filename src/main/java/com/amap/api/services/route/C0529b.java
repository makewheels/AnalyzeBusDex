package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusRouteResult */
/* renamed from: com.amap.api.services.route.b */
class C0529b implements Creator<BusRouteResult> {
    C0529b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4185a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4186a(i);
    }

    /* renamed from: a */
    public BusRouteResult m4185a(Parcel parcel) {
        return new BusRouteResult(parcel);
    }

    /* renamed from: a */
    public BusRouteResult[] m4186a(int i) {
        return new BusRouteResult[i];
    }
}
