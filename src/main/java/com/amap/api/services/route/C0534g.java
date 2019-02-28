package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DriveRouteResult */
/* renamed from: com.amap.api.services.route.g */
class C0534g implements Creator<DriveRouteResult> {
    C0534g() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4195a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4196a(i);
    }

    /* renamed from: a */
    public DriveRouteResult m4195a(Parcel parcel) {
        return new DriveRouteResult(parcel);
    }

    /* renamed from: a */
    public DriveRouteResult[] m4196a(int i) {
        return new DriveRouteResult[i];
    }
}
