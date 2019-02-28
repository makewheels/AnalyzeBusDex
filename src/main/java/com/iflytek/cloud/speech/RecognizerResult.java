package com.iflytek.cloud.speech;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p054u.aly.bi_常量类;

public class RecognizerResult implements Parcelable {
    public static final Creator<RecognizerResult> CREATOR = new C0976a();
    /* renamed from: a */
    private String f4565a = bi_常量类.f6358b;

    public RecognizerResult(Parcel parcel) {
        this.f4565a = parcel.readString();
    }

    public RecognizerResult(String str) {
        if (str != null) {
            this.f4565a = str;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getResultString() {
        return this.f4565a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4565a);
    }
}
