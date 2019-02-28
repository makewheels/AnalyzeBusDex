package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Photo */
/* renamed from: com.amap.api.services.poisearch.f */
class C0519f implements Creator<Photo> {
    C0519f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4172a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4173a(i);
    }

    /* renamed from: a */
    public Photo m4172a(Parcel parcel) {
        return new Photo(parcel);
    }

    /* renamed from: a */
    public Photo[] m4173a(int i) {
        return null;
    }
}
