package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RouteBusLineItem */
/* renamed from: com.amap.api.services.route.j */
class C0537j implements Creator<RouteBusLineItem> {
    C0537j() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4201a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4202a(i);
    }

    /* renamed from: a */
    public RouteBusLineItem m4201a(Parcel parcel) {
        return new RouteBusLineItem(parcel);
    }

    /* renamed from: a */
    public RouteBusLineItem[] m4202a(int i) {
        return null;
    }
}
