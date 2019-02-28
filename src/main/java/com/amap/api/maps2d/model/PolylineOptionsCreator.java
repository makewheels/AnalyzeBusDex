package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public PolylineOptions createFromParcel(Parcel parcel) {
        boolean z = true;
        PolylineOptions polylineOptions = new PolylineOptions();
        Iterable arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z2 = parcel.readByte() == (byte) 1;
        polylineOptions.addAll(arrayList);
        polylineOptions.width(readFloat);
        polylineOptions.color(readInt);
        polylineOptions.zIndex(readFloat2);
        polylineOptions.visible(z2);
        polylineOptions.f2635a = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        polylineOptions.geodesic(z2);
        polylineOptions.setDottedLine(z);
        return polylineOptions;
    }

    public PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
