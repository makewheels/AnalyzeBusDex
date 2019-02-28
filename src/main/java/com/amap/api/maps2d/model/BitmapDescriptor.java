package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    /* renamed from: a */
    int f2569a = 0;
    /* renamed from: b */
    int f2570b = 0;
    /* renamed from: c */
    Bitmap f2571c;

    BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f2569a = bitmap.getWidth();
            this.f2570b = bitmap.getHeight();
            this.f2571c = bitmap;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.f2569a = i;
        this.f2570b = i2;
        this.f2571c = bitmap;
    }

    public BitmapDescriptor clone() {
        return new BitmapDescriptor(Bitmap.createBitmap(this.f2571c), this.f2569a, this.f2570b);
    }

    @Deprecated
    public Bitmap getBitmap() {
        return this.f2571c;
    }

    public int getWidth() {
        return this.f2569a;
    }

    public int getHeight() {
        return this.f2570b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2571c, i);
        parcel.writeInt(this.f2569a);
        parcel.writeInt(this.f2570b);
    }

    public void recycle() {
        if (this.f2571c != null && !this.f2571c.isRecycled()) {
            this.f2571c.recycle();
            this.f2571c = null;
        }
    }
}
