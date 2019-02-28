package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusLineItem */
/* renamed from: com.amap.api.services.busline.a */
class C0471a implements Creator<BusLineItem> {
    C0471a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3984a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3985a(i);
    }

    /* renamed from: a */
    public BusLineItem m3984a(Parcel parcel) {
        return new BusLineItem(parcel);
    }

    /* renamed from: a */
    public BusLineItem[] m3985a(int i) {
        return null;
    }
}
