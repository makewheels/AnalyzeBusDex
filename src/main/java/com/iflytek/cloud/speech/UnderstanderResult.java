package com.iflytek.cloud.speech;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import p054u.aly.bi_常量类;

public class UnderstanderResult implements Parcelable {
    public static final Creator<UnderstanderResult> CREATOR = new C0977b();
    /* renamed from: a */
    private String f4582a = bi_常量类.f6358b_空串;

    public UnderstanderResult(Parcel parcel) {
        this.f4582a = parcel.readString();
    }

    public UnderstanderResult(String str) {
        if (str != null) {
            this.f4582a = str;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getResultString() {
        return this.f4582a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4582a);
    }
}
