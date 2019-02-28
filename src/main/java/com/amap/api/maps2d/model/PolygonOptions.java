package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements Parcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    /* renamed from: a */
    String f2627a;
    /* renamed from: b */
    private final List<LatLng> f2628b = new ArrayList();
    /* renamed from: c */
    private float f2629c = 10.0f;
    /* renamed from: d */
    private int f2630d = -16777216;
    /* renamed from: e */
    private int f2631e = -16777216;
    /* renamed from: f */
    private float f2632f = 0.0f;
    /* renamed from: g */
    private boolean f2633g = true;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2628b);
        parcel.writeFloat(this.f2629c);
        parcel.writeInt(this.f2630d);
        parcel.writeInt(this.f2631e);
        parcel.writeFloat(this.f2632f);
        parcel.writeByte((byte) (this.f2633g ? 0 : 1));
        parcel.writeString(this.f2627a);
    }

    public PolygonOptions add(LatLng latLng) {
        this.f2628b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f2628b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f2628b.add(add);
        }
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f2629c = f;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.f2630d = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f2631e = i;
        return this;
    }

    public PolygonOptions zIndex(float f) {
        this.f2632f = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f2633g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f2628b;
    }

    public float getStrokeWidth() {
        return this.f2629c;
    }

    public int getStrokeColor() {
        return this.f2630d;
    }

    public int getFillColor() {
        return this.f2631e;
    }

    public float getZIndex() {
        return this.f2632f;
    }

    public boolean isVisible() {
        return this.f2633g;
    }
}
