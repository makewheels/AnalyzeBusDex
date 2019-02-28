package com.amap.api.maps2d.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class TileOverlayOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    /* renamed from: a */
    private final int f2645a;
    /* renamed from: b */
    private TileProvider f2646b;
    /* renamed from: c */
    private boolean f2647c;
    /* renamed from: d */
    private float f2648d;
    /* renamed from: e */
    private int f2649e;
    /* renamed from: f */
    private int f2650f;
    /* renamed from: g */
    private String f2651g;
    /* renamed from: h */
    private boolean f2652h;
    /* renamed from: i */
    private boolean f2653i;

    public TileOverlayOptions() {
        this.f2647c = true;
        this.f2649e = 5120;
        this.f2650f = 20480;
        this.f2651g = null;
        this.f2652h = true;
        this.f2653i = true;
        this.f2645a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f) {
        this.f2647c = true;
        this.f2649e = 5120;
        this.f2650f = 20480;
        this.f2651g = null;
        this.f2652h = true;
        this.f2653i = true;
        this.f2645a = i;
        this.f2647c = z;
        this.f2648d = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f2645a);
        parcel.writeValue(this.f2646b);
        parcel.writeByte((byte) (this.f2647c ? 1 : 0));
        parcel.writeFloat(this.f2648d);
        parcel.writeInt(this.f2649e);
        parcel.writeInt(this.f2650f);
        parcel.writeString(this.f2651g);
        if (this.f2652h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f2653i) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.f2646b = tileProvider;
        return this;
    }

    public TileOverlayOptions zIndex(float f) {
        this.f2648d = f;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f2647c = z;
        return this;
    }

    public TileOverlayOptions memCacheSize(int i) {
        this.f2649e = i;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int i) {
        this.f2650f = i * 1024;
        return this;
    }

    public TileOverlayOptions diskCacheDir(String str) {
        this.f2651g = str;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.f2652h = z;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean z) {
        this.f2653i = z;
        return this;
    }

    public TileProvider getTileProvider() {
        return this.f2646b;
    }

    public float getZIndex() {
        return this.f2648d;
    }

    public boolean isVisible() {
        return this.f2647c;
    }

    public int getMemCacheSize() {
        return this.f2649e;
    }

    public int getDiskCacheSize() {
        return this.f2650f;
    }

    public String getDiskCacheDir() {
        return this.f2651g;
    }

    public boolean getMemoryCacheEnabled() {
        return this.f2652h;
    }

    public boolean getDiskCacheEnabled() {
        return this.f2653i;
    }
}
