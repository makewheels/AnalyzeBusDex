package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PoiItem */
/* renamed from: com.amap.api.services.core.p */
class C0491p implements Creator<PoiItem> {
    C0491p() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4102a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4103a(i);
    }

    /* renamed from: a */
    public PoiItem m4102a(Parcel parcel) {
        return new PoiItem(parcel);
    }

    /* renamed from: a */
    public PoiItem[] m4103a(int i) {
        return new PoiItem[i];
    }
}
