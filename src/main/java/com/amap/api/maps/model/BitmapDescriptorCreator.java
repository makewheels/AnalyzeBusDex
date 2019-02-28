package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BitmapDescriptorCreator implements Creator<BitmapDescriptor> {
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null);
        bitmapDescriptor.f2249c = (Bitmap) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        bitmapDescriptor.f2247a = parcel.readInt();
        bitmapDescriptor.f2248b = parcel.readInt();
        return bitmapDescriptor;
    }

    public BitmapDescriptor[] newArray(int i) {
        return new BitmapDescriptor[i];
    }
}
