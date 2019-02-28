package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.C0376e;

public final class GroundOverlayOptions implements Parcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    /* renamed from: a */
    private final int f2272a;
    /* renamed from: b */
    private BitmapDescriptor f2273b;
    /* renamed from: c */
    private LatLng f2274c;
    /* renamed from: d */
    private float f2275d;
    /* renamed from: e */
    private float f2276e;
    /* renamed from: f */
    private LatLngBounds f2277f;
    /* renamed from: g */
    private float f2278g;
    /* renamed from: h */
    private float f2279h;
    /* renamed from: i */
    private boolean f2280i;
    /* renamed from: j */
    private float f2281j;
    /* renamed from: k */
    private float f2282k;
    /* renamed from: l */
    private float f2283l;

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.f2279h = 0.0f;
        this.f2280i = true;
        this.f2281j = 0.0f;
        this.f2282k = 0.5f;
        this.f2283l = 0.5f;
        this.f2272a = i;
        this.f2273b = BitmapDescriptorFactory.fromBitmap(null);
        this.f2274c = latLng;
        this.f2275d = f;
        this.f2276e = f2;
        this.f2277f = latLngBounds;
        this.f2278g = f3;
        this.f2279h = f4;
        this.f2280i = z;
        this.f2281j = f5;
        this.f2282k = f6;
        this.f2283l = f7;
    }

    public GroundOverlayOptions() {
        this.f2279h = 0.0f;
        this.f2280i = true;
        this.f2281j = 0.0f;
        this.f2282k = 0.5f;
        this.f2283l = 0.5f;
        this.f2272a = 1;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f2273b = bitmapDescriptor;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f2282k = f;
        this.f2283l = f2;
        return this;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z;
        boolean z2 = true;
        if (this.f2277f == null) {
            z = true;
        } else {
            z = false;
        }
        C0376e.m3322a(z, (Object) "Position has already been set using positionFromBounds");
        if (latLng != null) {
            z = true;
        } else {
            z = false;
        }
        C0376e.m3324b(z, "Location must be specified");
        if (f < 0.0f) {
            z2 = false;
        }
        C0376e.m3324b(z2, "Width must be non-negative");
        return m3551a(latLng, f, f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z;
        boolean z2 = true;
        if (this.f2277f == null) {
            z = true;
        } else {
            z = false;
        }
        C0376e.m3322a(z, (Object) "Position has already been set using positionFromBounds");
        if (latLng != null) {
            z = true;
        } else {
            z = false;
        }
        C0376e.m3324b(z, "Location must be specified");
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        C0376e.m3324b(z, "Width must be non-negative");
        if (f2 < 0.0f) {
            z2 = false;
        }
        C0376e.m3324b(z2, "Height must be non-negative");
        return m3551a(latLng, f, f2);
    }

    /* renamed from: a */
    private GroundOverlayOptions m3551a(LatLng latLng, float f, float f2) {
        this.f2274c = latLng;
        this.f2275d = f;
        this.f2276e = f2;
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        C0376e.m3322a(this.f2274c == null, "Position has already been set using position: " + this.f2274c);
        this.f2277f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f2278g = f;
        return this;
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f2279h = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f2280i = z;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        C0376e.m3324b(z, "Transparency must be in the range [0..1]");
        this.f2281j = f;
        return this;
    }

    public BitmapDescriptor getImage() {
        return this.f2273b;
    }

    public LatLng getLocation() {
        return this.f2274c;
    }

    public float getWidth() {
        return this.f2275d;
    }

    public float getHeight() {
        return this.f2276e;
    }

    public LatLngBounds getBounds() {
        return this.f2277f;
    }

    public float getBearing() {
        return this.f2278g;
    }

    public float getZIndex() {
        return this.f2279h;
    }

    public float getTransparency() {
        return this.f2281j;
    }

    public float getAnchorU() {
        return this.f2282k;
    }

    public float getAnchorV() {
        return this.f2283l;
    }

    public boolean isVisible() {
        return this.f2280i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2272a);
        parcel.writeParcelable(this.f2273b, i);
        parcel.writeParcelable(this.f2274c, i);
        parcel.writeFloat(this.f2275d);
        parcel.writeFloat(this.f2276e);
        parcel.writeParcelable(this.f2277f, i);
        parcel.writeFloat(this.f2278g);
        parcel.writeFloat(this.f2279h);
        parcel.writeByte((byte) (this.f2280i ? 1 : 0));
        parcel.writeFloat(this.f2281j);
        parcel.writeFloat(this.f2282k);
        parcel.writeFloat(this.f2283l);
    }
}
