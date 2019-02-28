package com.amap.api.maps2d.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class CircleOptions implements Parcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    /* renamed from: a */
    String f2577a;
    /* renamed from: b */
    private LatLng f2578b = null;
    /* renamed from: c */
    private double f2579c = 0.0d;
    /* renamed from: d */
    private float f2580d = 10.0f;
    /* renamed from: e */
    private int f2581e = -16777216;
    /* renamed from: f */
    private int f2582f = 0;
    /* renamed from: g */
    private float f2583g = 0.0f;
    /* renamed from: h */
    private boolean f2584h = true;

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.f2578b != null) {
            bundle.putDouble("lat", this.f2578b.latitude);
            bundle.putDouble("lng", this.f2578b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.f2579c);
        parcel.writeFloat(this.f2580d);
        parcel.writeInt(this.f2581e);
        parcel.writeInt(this.f2582f);
        parcel.writeFloat(this.f2583g);
        parcel.writeByte((byte) (this.f2584h ? 1 : 0));
        parcel.writeString(this.f2577a);
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions center(LatLng latLng) {
        this.f2578b = latLng;
        return this;
    }

    public CircleOptions radius(double d) {
        this.f2579c = d;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f2580d = f;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f2581e = i;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f2582f = i;
        return this;
    }

    public CircleOptions zIndex(float f) {
        this.f2583g = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f2584h = z;
        return this;
    }

    public LatLng getCenter() {
        return this.f2578b;
    }

    public double getRadius() {
        return this.f2579c;
    }

    public float getStrokeWidth() {
        return this.f2580d;
    }

    public int getStrokeColor() {
        return this.f2581e;
    }

    public int getFillColor() {
        return this.f2582f;
    }

    public float getZIndex() {
        return this.f2583g;
    }

    public boolean isVisible() {
        return this.f2584h;
    }
}
