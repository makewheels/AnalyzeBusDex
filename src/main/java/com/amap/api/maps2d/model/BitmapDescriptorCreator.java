package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BitmapDescriptorCreator implements Creator<BitmapDescriptor> {
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null);
        bitmapDescriptor.f2571c = (Bitmap) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        bitmapDescriptor.f2569a = parcel.readInt();
        bitmapDescriptor.f2570b = parcel.readInt();
        return bitmapDescriptor;
    }

    public BitmapDescriptor[] newArray(int i) {
        return new BitmapDescriptor[i];
    }
}
