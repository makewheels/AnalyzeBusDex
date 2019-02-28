package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: StreetNumber */
/* renamed from: com.amap.api.services.geocoder.e */
class C0508e implements Creator<StreetNumber> {
    C0508e() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4140a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4141a(i);
    }

    /* renamed from: a */
    public StreetNumber m4140a(Parcel parcel) {
        return new StreetNumber(parcel);
    }

    /* renamed from: a */
    public StreetNumber[] m4141a(int i) {
        return null;
    }
}
