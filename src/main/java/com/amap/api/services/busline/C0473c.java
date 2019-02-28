package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusStationItem */
/* renamed from: com.amap.api.services.busline.c */
class C0473c implements Creator<BusStationItem> {
    C0473c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3986a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3987a(i);
    }

    /* renamed from: a */
    public BusStationItem m3986a(Parcel parcel) {
        return new BusStationItem(parcel);
    }

    /* renamed from: a */
    public BusStationItem[] m3987a(int i) {
        return null;
    }
}
