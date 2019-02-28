package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Dining */
/* renamed from: com.amap.api.services.poisearch.b */
class C0515b implements Creator<Dining> {
    C0515b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4164a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4165a(i);
    }

    /* renamed from: a */
    public Dining m4164a(Parcel parcel) {
        return new Dining(parcel);
    }

    /* renamed from: a */
    public Dining[] m4165a(int i) {
        return null;
    }
}
