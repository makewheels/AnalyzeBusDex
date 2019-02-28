package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class TileOverlayOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    /* renamed from: a */
    private final int f2387a;
    /* renamed from: b */
    private TileProvider f2388b;
    /* renamed from: c */
    private boolean f2389c;
    /* renamed from: d */
    private float f2390d;
    /* renamed from: e */
    private int f2391e;
    /* renamed from: f */
    private int f2392f;
    /* renamed from: g */
    private String f2393g;
    /* renamed from: h */
    private boolean f2394h;
    /* renamed from: i */
    private boolean f2395i;

    public TileOverlayOptions() {
        this.f2389c = true;
        this.f2391e = 5242880;
        this.f2392f = 20971520;
        this.f2393g = null;
        this.f2394h = true;
        this.f2395i = true;
        this.f2387a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f) {
        this.f2389c = true;
        this.f2391e = 5242880;
        this.f2392f = 20971520;
        this.f2393g = null;
        this.f2394h = true;
        this.f2395i = true;
        this.f2387a = i;
        this.f2389c = z;
        this.f2390d = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f2387a);
        parcel.writeValue(this.f2388b);
        parcel.writeByte((byte) (this.f2389c ? 1 : 0));
        parcel.writeFloat(this.f2390d);
        parcel.writeInt(this.f2391e);
        parcel.writeInt(this.f2392f);
        parcel.writeString(this.f2393g);
        if (this.f2394h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f2395i) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.f2388b = tileProvider;
        return this;
    }

    public TileOverlayOptions zIndex(float f) {
        this.f2390d = f;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f2389c = z;
        return this;
    }

    public TileOverlayOptions memCacheSize(int i) {
        this.f2391e = i;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int i) {
        this.f2392f = i * 1024;
        return this;
    }

    public TileOverlayOptions diskCacheDir(String str) {
        this.f2393g = str;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.f2394h = z;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean z) {
        this.f2395i = z;
        return this;
    }

    public TileProvider getTileProvider() {
        return this.f2388b;
    }

    public float getZIndex() {
        return this.f2390d;
    }

    public boolean isVisible() {
        return this.f2389c;
    }

    public int getMemCacheSize() {
        return this.f2391e;
    }

    public int getDiskCacheSize() {
        return this.f2392f;
    }

    public String getDiskCacheDir() {
        return this.f2393g;
    }

    public boolean getMemoryCacheEnabled() {
        return this.f2394h;
    }

    public boolean getDiskCacheEnabled() {
        return this.f2395i;
    }
}
