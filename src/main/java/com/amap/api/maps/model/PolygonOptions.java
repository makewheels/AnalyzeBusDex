package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements Parcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    /* renamed from: a */
    String f2347a;
    /* renamed from: b */
    private final List<LatLng> f2348b = new ArrayList();
    /* renamed from: c */
    private float f2349c = 10.0f;
    /* renamed from: d */
    private int f2350d = -16777216;
    /* renamed from: e */
    private int f2351e = -16777216;
    /* renamed from: f */
    private float f2352f = 0.0f;
    /* renamed from: g */
    private boolean f2353g = true;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2348b);
        parcel.writeFloat(this.f2349c);
        parcel.writeInt(this.f2350d);
        parcel.writeInt(this.f2351e);
        parcel.writeFloat(this.f2352f);
        parcel.writeByte((byte) (this.f2353g ? 1 : 0));
        parcel.writeString(this.f2347a);
    }

    public PolygonOptions add(LatLng latLng) {
        this.f2348b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f2348b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f2348b.add(add);
        }
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f2349c = f;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.f2350d = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f2351e = i;
        return this;
    }

    public PolygonOptions zIndex(float f) {
        this.f2352f = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f2353g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f2348b;
    }

    public float getStrokeWidth() {
        return this.f2349c;
    }

    public int getStrokeColor() {
        return this.f2350d;
    }

    public int getFillColor() {
        return this.f2351e;
    }

    public float getZIndex() {
        return this.f2352f;
    }

    public boolean isVisible() {
        return this.f2353g;
    }
}
