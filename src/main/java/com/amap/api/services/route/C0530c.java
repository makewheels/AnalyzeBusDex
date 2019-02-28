package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusStep */
/* renamed from: com.amap.api.services.route.c */
class C0530c implements Creator<BusStep> {
    C0530c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4187a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4188a(i);
    }

    /* renamed from: a */
    public BusStep m4187a(Parcel parcel) {
        return new BusStep(parcel);
    }

    /* renamed from: a */
    public BusStep[] m4188a(int i) {
        return null;
    }
}
