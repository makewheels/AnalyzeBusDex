package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    /* renamed from: a */
    String f2635a;
    /* renamed from: b */
    private final List<LatLng> f2636b = new ArrayList();
    /* renamed from: c */
    private float f2637c = 10.0f;
    /* renamed from: d */
    private int f2638d = -16777216;
    /* renamed from: e */
    private float f2639e = 0.0f;
    /* renamed from: f */
    private boolean f2640f = true;
    /* renamed from: g */
    private boolean f2641g = false;
    /* renamed from: h */
    private boolean f2642h = false;

    public PolylineOptions add(LatLng latLng) {
        this.f2636b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f2636b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f2636b.add(add);
        }
        return this;
    }

    public PolylineOptions width(float f) {
        this.f2637c = f;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f2638d = i;
        return this;
    }

    public PolylineOptions zIndex(float f) {
        this.f2639e = f;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f2640f = z;
        return this;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f2641g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f2636b;
    }

    public float getWidth() {
        return this.f2637c;
    }

    public int getColor() {
        return this.f2638d;
    }

    public float getZIndex() {
        return this.f2639e;
    }

    public boolean isVisible() {
        return this.f2640f;
    }

    public PolylineOptions setDottedLine(boolean z) {
        this.f2642h = z;
        return this;
    }

    public boolean isDottedLine() {
        return this.f2642h;
    }

    public boolean isGeodesic() {
        return this.f2641g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeTypedList(getPoints());
        parcel.writeFloat(getWidth());
        parcel.writeInt(getColor());
        parcel.writeFloat(getZIndex());
        parcel.writeByte((byte) (isVisible() ? 1 : 0));
        parcel.writeString(this.f2635a);
        if (isGeodesic()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!isDottedLine()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
