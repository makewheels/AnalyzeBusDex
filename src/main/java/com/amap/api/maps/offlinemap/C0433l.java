package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Province */
/* renamed from: com.amap.api.maps.offlinemap.l */
class C0433l implements Creator<Province> {
    C0433l() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3705a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3706a(i);
    }

    /* renamed from: a */
    public Province m3705a(Parcel parcel) {
        return new Province(parcel);
    }

    /* renamed from: a */
    public Province[] m3706a(int i) {
        return new Province[i];
    }
}
