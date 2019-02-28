package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TileCreator */
/* renamed from: com.amap.api.maps2d.model.a */
class C0440a implements Creator<Tile> {
    C0440a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3802a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3803a(i);
    }

    /* renamed from: a */
    public Tile m3802a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    /* renamed from: a */
    public Tile[] m3803a(int i) {
        return new Tile[i];
    }
}
