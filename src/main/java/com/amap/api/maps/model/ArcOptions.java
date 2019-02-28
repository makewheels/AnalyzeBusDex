package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class ArcOptions implements Parcelable {
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();
    /* renamed from: a */
    String f2239a;
    /* renamed from: b */
    private LatLng f2240b;
    /* renamed from: c */
    private LatLng f2241c;
    /* renamed from: d */
    private LatLng f2242d;
    /* renamed from: e */
    private float f2243e = 10.0f;
    /* renamed from: f */
    private int f2244f = -16777216;
    /* renamed from: g */
    private float f2245g = 0.0f;
    /* renamed from: h */
    private boolean f2246h = true;

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.f2240b != null) {
            bundle.putDouble("startlat", this.f2240b.latitude);
            bundle.putDouble("startlng", this.f2240b.longitude);
        }
        if (this.f2241c != null) {
            bundle.putDouble("passedlat", this.f2241c.latitude);
            bundle.putDouble("passedlng", this.f2241c.longitude);
        }
        if (this.f2242d != null) {
            bundle.putDouble("endlat", this.f2242d.latitude);
            bundle.putDouble("endlng", this.f2242d.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.f2243e);
        parcel.writeInt(this.f2244f);
        parcel.writeFloat(this.f2245g);
        parcel.writeByte((byte) (this.f2246h ? 1 : 0));
        parcel.writeString(this.f2239a);
    }

    public int describeContents() {
        return 0;
    }

    public ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.f2240b = latLng;
        this.f2241c = latLng2;
        this.f2242d = latLng3;
        return this;
    }

    public ArcOptions strokeWidth(float f) {
        this.f2243e = f;
        return this;
    }

    public ArcOptions strokeColor(int i) {
        this.f2244f = i;
        return this;
    }

    public ArcOptions zIndex(float f) {
        this.f2245g = f;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f2246h = z;
        return this;
    }

    public float getStrokeWidth() {
        return this.f2243e;
    }

    public int getStrokeColor() {
        return this.f2244f;
    }

    public float getZIndex() {
        return this.f2245g;
    }

    public boolean isVisible() {
        return this.f2246h;
    }

    public LatLng getStart() {
        return this.f2240b;
    }

    public LatLng getPassed() {
        return this.f2241c;
    }

    public LatLng getEnd() {
        return this.f2242d;
    }
}
