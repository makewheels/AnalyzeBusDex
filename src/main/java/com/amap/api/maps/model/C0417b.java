package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TileCreator */
/* renamed from: com.amap.api.maps.model.b */
class C0417b implements Creator<Tile> {
    C0417b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3588a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3589a(i);
    }

    /* renamed from: a */
    public Tile m3588a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    /* renamed from: a */
    public Tile[] m3589a(int i) {
        return new Tile[i];
    }
}
