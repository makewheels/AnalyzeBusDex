package com.amap.api.maps2d.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.p015a.p016a.C0171a;

public final class GroundOverlayOptions implements Parcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    /* renamed from: a */
    private final int f2586a;
    /* renamed from: b */
    private BitmapDescriptor f2587b;
    /* renamed from: c */
    private LatLng f2588c;
    /* renamed from: d */
    private float f2589d;
    /* renamed from: e */
    private float f2590e;
    /* renamed from: f */
    private LatLngBounds f2591f;
    /* renamed from: g */
    private float f2592g;
    /* renamed from: h */
    private float f2593h;
    /* renamed from: i */
    private boolean f2594i;
    /* renamed from: j */
    private float f2595j;
    /* renamed from: k */
    private float f2596k;
    /* renamed from: l */
    private float f2597l;

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.f2594i = true;
        this.f2595j = 0.0f;
        this.f2596k = 0.5f;
        this.f2597l = 0.5f;
        this.f2586a = i;
        this.f2587b = BitmapDescriptorFactory.fromBitmap(null);
        this.f2588c = latLng;
        this.f2589d = f;
        this.f2590e = f2;
        this.f2591f = latLngBounds;
        this.f2592g = f3;
        this.f2593h = f4;
        this.f2594i = z;
        this.f2595j = f5;
        this.f2596k = f6;
        this.f2597l = f7;
    }

    public GroundOverlayOptions() {
        this.f2594i = true;
        this.f2595j = 0.0f;
        this.f2596k = 0.5f;
        this.f2597l = 0.5f;
        this.f2586a = 1;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f2587b = bitmapDescriptor;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f2596k = f;
        this.f2597l = f2;
        return this;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z;
        boolean z2 = true;
        if (this.f2591f == null) {
            z = true;
        } else {
            z = false;
        }
        C0171a.m622a(z, (Object) "Position has already been set using positionFromBounds");
        if (latLng != null) {
            z = true;
        } else {
            z = false;
        }
        C0171a.m624b(z, "Location must be specified");
        if (f < 0.0f) {
            z2 = false;
        }
        C0171a.m624b(z2, "Width must be non-negative");
        return m3785a(latLng, f, f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z;
        boolean z2 = true;
        if (this.f2591f == null) {
            z = true;
        } else {
            z = false;
        }
        C0171a.m622a(z, (Object) "Position has already been set using positionFromBounds");
        if (latLng != null) {
            z = true;
        } else {
            z = false;
        }
        C0171a.m624b(z, "Location must be specified");
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        C0171a.m624b(z, "Width must be non-negative");
        if (f2 < 0.0f) {
            z2 = false;
        }
        C0171a.m624b(z2, "Height must be non-negative");
        return m3785a(latLng, f, f2);
    }

    /* renamed from: a */
    private GroundOverlayOptions m3785a(LatLng latLng, float f, float f2) {
        this.f2588c = latLng;
        this.f2589d = f;
        this.f2590e = f2;
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        C0171a.m622a(this.f2588c == null, "Position has already been set using position: " + this.f2588c);
        this.f2591f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f2592g = f;
        return this;
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f2593h = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f2594i = z;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        C0171a.m624b(z, "Transparency must be in the range [0..1]");
        this.f2595j = f;
        return this;
    }

    public BitmapDescriptor getImage() {
        return this.f2587b;
    }

    public LatLng getLocation() {
        return this.f2588c;
    }

    public float getWidth() {
        return this.f2589d;
    }

    public float getHeight() {
        return this.f2590e;
    }

    public LatLngBounds getBounds() {
        return this.f2591f;
    }

    public float getBearing() {
        return this.f2592g;
    }

    public float getZIndex() {
        return this.f2593h;
    }

    public float getTransparency() {
        return this.f2595j;
    }

    public float getAnchorU() {
        return this.f2596k;
    }

    public float getAnchorV() {
        return this.f2597l;
    }

    public boolean isVisible() {
        return this.f2594i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2586a);
        parcel.writeParcelable(this.f2587b, i);
        parcel.writeParcelable(this.f2588c, i);
        parcel.writeFloat(this.f2589d);
        parcel.writeFloat(this.f2590e);
        parcel.writeParcelable(this.f2591f, i);
        parcel.writeFloat(this.f2592g);
        parcel.writeFloat(this.f2593h);
        parcel.writeByte((byte) (this.f2594i ? 1 : 0));
        parcel.writeFloat(this.f2595j);
        parcel.writeFloat(this.f2596k);
        parcel.writeFloat(this.f2597l);
    }
}
