package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Path */
/* renamed from: com.amap.api.services.route.i */
class C0536i implements Creator<Path> {
    C0536i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4199a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4200a(i);
    }

    /* renamed from: a */
    public Path m4199a(Parcel parcel) {
        return new Path(parcel);
    }

    /* renamed from: a */
    public Path[] m4200a(int i) {
        return null;
    }
}
