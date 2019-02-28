package com.iflytek.cloud.speech;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.iflytek.cloud.speech.b */
final class C0977b implements Creator<UnderstanderResult> {
    C0977b() {
    }

    /* renamed from: a */
    public UnderstanderResult m7293a(Parcel parcel) {
        return new UnderstanderResult(parcel);
    }

    /* renamed from: a */
    public UnderstanderResult[] m7294a(int i) {
        return new UnderstanderResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7293a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7294a(i);
    }
}
