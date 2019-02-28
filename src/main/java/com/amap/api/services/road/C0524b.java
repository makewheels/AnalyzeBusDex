package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Road */
/* renamed from: com.amap.api.services.road.b */
class C0524b implements Creator<Road> {
    C0524b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4180a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4181a(i);
    }

    /* renamed from: a */
    public Road m4180a(Parcel parcel) {
        return new Road(parcel);
    }

    /* renamed from: a */
    public Road[] m4181a(int i) {
        return null;
    }
}
