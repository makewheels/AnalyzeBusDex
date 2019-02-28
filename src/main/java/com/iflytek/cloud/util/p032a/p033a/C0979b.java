package com.iflytek.cloud.util.p032a.p033a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.iflytek.cloud.util.a.a.b */
final class C0979b implements Creator<C0978a> {
    C0979b() {
    }

    /* renamed from: a */
    public C0978a m7309a(Parcel parcel) {
        C0978a c0978a = new C0978a();
        c0978a.f4610a = parcel.readString();
        c0978a.f4611b = parcel.readString();
        c0978a.f4612c = parcel.readString();
        c0978a.f4613d = parcel.readString();
        c0978a.f4614e = parcel.readString();
        c0978a.f4615f = parcel.readString();
        c0978a.f4616g = parcel.readString();
        return c0978a;
    }

    /* renamed from: a */
    public C0978a[] m7310a(int i) {
        return new C0978a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7309a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7310a(i);
    }
}
