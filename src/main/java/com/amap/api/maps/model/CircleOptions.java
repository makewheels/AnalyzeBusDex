package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class CircleOptions implements Parcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    /* renamed from: a */
    String f2255a;
    /* renamed from: b */
    private LatLng f2256b = null;
    /* renamed from: c */
    private double f2257c = 0.0d;
    /* renamed from: d */
    private float f2258d = 10.0f;
    /* renamed from: e */
    private int f2259e = -16777216;
    /* renamed from: f */
    private int f2260f = 0;
    /* renamed from: g */
    private float f2261g = 0.0f;
    /* renamed from: h */
    private boolean f2262h = true;

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.f2256b != null) {
            bundle.putDouble("lat", this.f2256b.latitude);
            bundle.putDouble("lng", this.f2256b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.f2257c);
        parcel.writeFloat(this.f2258d);
        parcel.writeInt(this.f2259e);
        parcel.writeInt(this.f2260f);
        parcel.writeFloat(this.f2261g);
        parcel.writeByte((byte) (this.f2262h ? 1 : 0));
        parcel.writeString(this.f2255a);
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions center(LatLng latLng) {
        this.f2256b = latLng;
        return this;
    }

    public CircleOptions radius(double d) {
        this.f2257c = d;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f2258d = f;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f2259e = i;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f2260f = i;
        return this;
    }

    public CircleOptions zIndex(float f) {
        this.f2261g = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f2262h = z;
        return this;
    }

    public LatLng getCenter() {
        return this.f2256b;
    }

    public double getRadius() {
        return this.f2257c;
    }

    public float getStrokeWidth() {
        return this.f2258d;
    }

    public int getStrokeColor() {
        return this.f2259e;
    }

    public int getFillColor() {
        return this.f2260f;
    }

    public float getZIndex() {
        return this.f2261g;
    }

    public boolean isVisible() {
        return this.f2262h;
    }
}
