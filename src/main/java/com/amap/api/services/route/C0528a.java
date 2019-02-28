package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusPath */
/* renamed from: com.amap.api.services.route.a */
class C0528a implements Creator<BusPath> {
    C0528a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4183a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4184a(i);
    }

    /* renamed from: a */
    public BusPath m4183a(Parcel parcel) {
        return new BusPath(parcel);
    }

    /* renamed from: a */
    public BusPath[] m4184a(int i) {
        return null;
    }
}
