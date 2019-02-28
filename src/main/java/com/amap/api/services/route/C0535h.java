package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DriveStep */
/* renamed from: com.amap.api.services.route.h */
class C0535h implements Creator<DriveStep> {
    C0535h() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m4197a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m4198a(i);
    }

    /* renamed from: a */
    public DriveStep m4197a(Parcel parcel) {
        return new DriveStep(parcel);
    }

    /* renamed from: a */
    public DriveStep[] m4198a(int i) {
        return null;
    }
}
