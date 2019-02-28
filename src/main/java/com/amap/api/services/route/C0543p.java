package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.FromAndTo;

/* compiled from: RouteSearch */
/* renamed from: com.amap.api.services.route.p */
class C0543p implements Creator<FromAndTo> {
    C0543p() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4211a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4212a(i);
    }

    /* renamed from: a */
    public FromAndTo m4211a(Parcel parcel) {
        return new FromAndTo(parcel);
    }

    /* renamed from: a */
    public FromAndTo[] m4212a(int i) {
        return new FromAndTo[i];
    }
}
