package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;

/* compiled from: RouteSearch */
/* renamed from: com.amap.api.services.route.o */
class C0542o implements Creator<DriveRouteQuery> {
    C0542o() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4209a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4210a(i);
    }

    /* renamed from: a */
    public DriveRouteQuery m4209a(Parcel parcel) {
        return new DriveRouteQuery(parcel);
    }

    /* renamed from: a */
    public DriveRouteQuery[] m4210a(int i) {
        return new DriveRouteQuery[i];
    }
}
