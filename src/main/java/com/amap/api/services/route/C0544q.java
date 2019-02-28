package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;

/* compiled from: RouteSearch */
/* renamed from: com.amap.api.services.route.q */
class C0544q implements Creator<WalkRouteQuery> {
    C0544q() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4213a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4214a(i);
    }

    /* renamed from: a */
    public WalkRouteQuery m4213a(Parcel parcel) {
        return new WalkRouteQuery(parcel);
    }

    /* renamed from: a */
    public WalkRouteQuery[] m4214a(int i) {
        return new WalkRouteQuery[i];
    }
}
