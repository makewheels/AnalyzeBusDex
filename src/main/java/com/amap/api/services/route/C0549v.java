package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WalkStep */
/* renamed from: com.amap.api.services.route.v */
class C0549v implements Creator<WalkStep> {
    C0549v() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4223a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4224a(i);
    }

    /* renamed from: a */
    public WalkStep m4223a(Parcel parcel) {
        return new WalkStep(parcel);
    }

    /* renamed from: a */
    public WalkStep[] m4224a(int i) {
        return null;
    }
}
