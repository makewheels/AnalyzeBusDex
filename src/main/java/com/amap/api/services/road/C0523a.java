package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Crossroad */
/* renamed from: com.amap.api.services.road.a */
class C0523a implements Creator<Crossroad> {
    C0523a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4178a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4179a(i);
    }

    /* renamed from: a */
    public Crossroad[] m4179a(int i) {
        return null;
    }

    /* renamed from: a */
    public Crossroad m4178a(Parcel parcel) {
        return new Crossroad(parcel);
    }
}
