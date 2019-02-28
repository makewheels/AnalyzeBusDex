package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WalkPath */
/* renamed from: com.amap.api.services.route.t */
class C0547t implements Creator<WalkPath> {
    C0547t() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4219a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4220a(i);
    }

    /* renamed from: a */
    public WalkPath m4219a(Parcel parcel) {
        return new WalkPath(parcel);
    }

    /* renamed from: a */
    public WalkPath[] m4220a(int i) {
        return null;
    }
}
