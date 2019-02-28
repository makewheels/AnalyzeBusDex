package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RouteBusWalkItem */
/* renamed from: com.amap.api.services.route.k */
class C0538k implements Creator<RouteBusWalkItem> {
    C0538k() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4203a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4204a(i);
    }

    /* renamed from: a */
    public RouteBusWalkItem m4203a(Parcel parcel) {
        return new RouteBusWalkItem(parcel);
    }

    /* renamed from: a */
    public RouteBusWalkItem[] m4204a(int i) {
        return null;
    }
}
