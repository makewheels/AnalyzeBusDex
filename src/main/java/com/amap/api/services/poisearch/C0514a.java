package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Cinema */
/* renamed from: com.amap.api.services.poisearch.a */
class C0514a implements Creator<Cinema> {
    C0514a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4162a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4163a(i);
    }

    /* renamed from: a */
    public Cinema m4162a(Parcel parcel) {
        return new Cinema(parcel);
    }

    /* renamed from: a */
    public Cinema[] m4163a(int i) {
        return null;
    }
}
