package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WalkRouteResult */
/* renamed from: com.amap.api.services.route.u */
class C0548u implements Creator<WalkRouteResult> {
    C0548u() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4221a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4222a(i);
    }

    /* renamed from: a */
    public WalkRouteResult m4221a(Parcel parcel) {
        return new WalkRouteResult(parcel);
    }

    /* renamed from: a */
    public WalkRouteResult[] m4222a(int i) {
        return new WalkRouteResult[i];
    }
}
