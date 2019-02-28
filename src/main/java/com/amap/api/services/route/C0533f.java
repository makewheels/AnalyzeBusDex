package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DrivePath */
/* renamed from: com.amap.api.services.route.f */
class C0533f implements Creator<DrivePath> {
    C0533f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4193a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4194a(i);
    }

    /* renamed from: a */
    public DrivePath m4193a(Parcel parcel) {
        return new DrivePath(parcel);
    }

    /* renamed from: a */
    public DrivePath[] m4194a(int i) {
        return null;
    }
}
