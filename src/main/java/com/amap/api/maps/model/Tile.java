package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class Tile implements Parcelable {
    public static final C0417b CREATOR = new C0417b();
    /* renamed from: a */
    private final int f2385a;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.f2385a = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2385a);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
    }
}
