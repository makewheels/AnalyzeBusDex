package com.amap.api.maps2d.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        BadParcelableException e;
        int readInt = parcel.readInt();
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e2) {
                e = e2;
                e.printStackTrace();
                latLng2 = null;
                return new LatLngBounds(readInt, latLng, latLng2);
            }
        } catch (BadParcelableException e3) {
            e = e3;
            latLng = null;
            e.printStackTrace();
            latLng2 = null;
            return new LatLngBounds(readInt, latLng, latLng2);
        }
        return new LatLngBounds(readInt, latLng, latLng2);
    }

    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }

    /* renamed from: a */
    static void m3796a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.m3795a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }
}
