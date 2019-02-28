package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;

/* compiled from: RouteSearch */
/* renamed from: com.amap.api.services.route.n */
class C0541n implements Creator<BusRouteQuery> {
    C0541n() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4207a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4208a(i);
    }

    /* renamed from: a */
    public BusRouteQuery m4207a(Parcel parcel) {
        return new BusRouteQuery(parcel);
    }

    /* renamed from: a */
    public BusRouteQuery[] m4208a(int i) {
        return new BusRouteQuery[i];
    }
}
