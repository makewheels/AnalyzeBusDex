package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    /* renamed from: a */
    String f2355a;
    /* renamed from: b */
    private final List<LatLng> f2356b = new ArrayList();
    /* renamed from: c */
    private float f2357c = 10.0f;
    /* renamed from: d */
    private int f2358d = -16777216;
    /* renamed from: e */
    private float f2359e = 0.0f;
    /* renamed from: f */
    private boolean f2360f = true;
    /* renamed from: g */
    private BitmapDescriptor f2361g;
    /* renamed from: h */
    private boolean f2362h = true;
    /* renamed from: i */
    private boolean f2363i = false;
    /* renamed from: j */
    private boolean f2364j = false;

    public PolylineOptions setUseTexture(boolean z) {
        this.f2362h = z;
        return this;
    }

    public PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.f2361g = bitmapDescriptor;
        return this;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f2361g;
    }

    public boolean isUseTexture() {
        return this.f2362h;
    }

    public boolean isGeodesic() {
        return this.f2363i;
    }

    public PolylineOptions add(LatLng latLng) {
        this.f2356b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f2356b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f2356b.add(add);
        }
        return this;
    }

    public PolylineOptions width(float f) {
        this.f2357c = f;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f2358d = i;
        return this;
    }

    public PolylineOptions zIndex(float f) {
        this.f2359e = f;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f2360f = z;
        return this;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f2363i = z;
        return this;
    }

    public PolylineOptions setDottedLine(boolean z) {
        this.f2364j = z;
        return this;
    }

    public boolean isDottedLine() {
        return this.f2364j;
    }

    public List<LatLng> getPoints() {
        return this.f2356b;
    }

    public float getWidth() {
        return this.f2357c;
    }

    public int getColor() {
        return this.f2358d;
    }

    public float getZIndex() {
        return this.f2359e;
    }

    public boolean isVisible() {
        return this.f2360f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2356b);
        parcel.writeFloat(this.f2357c);
        parcel.writeInt(this.f2358d);
        parcel.writeFloat(this.f2359e);
        parcel.writeString(this.f2355a);
        parcel.writeBooleanArray(new boolean[]{this.f2360f, this.f2364j, this.f2363i});
        if (this.f2361g != null) {
            parcel.writeParcelable(this.f2361g, i);
        }
    }
}
