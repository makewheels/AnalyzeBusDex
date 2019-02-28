package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.p015a.p016a.C0171a;
import com.amap.api.p015a.p016a.C0204q;

public final class CameraPosition implements Parcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        /* renamed from: a */
        private LatLng f2572a;
        /* renamed from: b */
        private float f2573b;
        /* renamed from: c */
        private float f2574c;
        /* renamed from: d */
        private float f2575d;

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public Builder target(LatLng latLng) {
            this.f2572a = latLng;
            return this;
        }

        public Builder zoom(float f) {
            this.f2573b = f;
            return this;
        }

        public Builder tilt(float f) {
            this.f2574c = f;
            return this;
        }

        public Builder bearing(float f) {
            this.f2575d = f;
            return this;
        }

        public CameraPosition build() {
            C0171a.m620a(this.f2572a);
            return new CameraPosition(this.f2572a, this.f2573b, this.f2574c, this.f2575d);
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        C0171a.m621a((Object) latLng, (Object) "CameraPosition 位置不能为null");
        this.target = latLng;
        this.zoom = C0204q.m807b(f);
        this.tilt = C0204q.m792a(f2);
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.bearing = f3 % 360.0f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return C0204q.m800a(C0204q.m799a("target", this.target), C0204q.m799a("zoom", Float.valueOf(this.zoom)), C0204q.m799a("tilt", Float.valueOf(this.tilt)), C0204q.m799a("bearing", Float.valueOf(this.bearing)));
    }
}
