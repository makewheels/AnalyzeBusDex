package com.iflytek.cloud.speech;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.iflytek.cloud.speech.a */
final class C0976a implements Creator<RecognizerResult> {
    C0976a() {
    }

    /* renamed from: a */
    public RecognizerResult m7291a(Parcel parcel) {
        return new RecognizerResult(parcel);
    }

    /* renamed from: a */
    public RecognizerResult[] m7292a(int i) {
        return new RecognizerResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7291a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7292a(i);
    }
}
