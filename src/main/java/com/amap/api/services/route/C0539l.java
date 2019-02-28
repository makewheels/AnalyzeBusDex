package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RouteResult */
/* renamed from: com.amap.api.services.route.l */
class C0539l implements Creator<RouteResult> {
    C0539l() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4205a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4206a(i);
    }

    /* renamed from: a */
    public RouteResult m4205a(Parcel parcel) {
        return new RouteResult(parcel);
    }

    /* renamed from: a */
    public RouteResult[] m4206a(int i) {
        return new RouteResult[i];
    }
}
