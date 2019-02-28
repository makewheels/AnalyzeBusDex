package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.C0376e;
import com.amap.api.mapcore.util.C0405u;

public final class LatLngBounds implements Parcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    /* renamed from: a */
    private final int f2304a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        /* renamed from: a */
        private double f2300a = Double.POSITIVE_INFINITY;
        /* renamed from: b */
        private double f2301b = Double.NEGATIVE_INFINITY;
        /* renamed from: c */
        private double f2302c = Double.NaN;
        /* renamed from: d */
        private double f2303d = Double.NaN;

        public Builder include(LatLng latLng) {
            this.f2300a = Math.min(this.f2300a, latLng.latitude);
            this.f2301b = Math.max(this.f2301b, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f2302c)) {
                this.f2302c = d;
                this.f2303d = d;
            } else if (!m3568a(d)) {
                if (LatLngBounds.m3574c(this.f2302c, d) < LatLngBounds.m3575d(this.f2303d, d)) {
                    this.f2302c = d;
                } else {
                    this.f2303d = d;
                }
            }
            return this;
        }

        /* renamed from: a */
        private boolean m3568a(double d) {
            boolean z = false;
            if (this.f2302c > this.f2303d) {
                if (this.f2302c <= d || d <= this.f2303d) {
                    z = true;
                }
                return z;
            } else if (this.f2302c > d || d > this.f2303d) {
                return false;
            } else {
                return true;
            }
        }

        public LatLngBounds build() {
            boolean z;
            if (Double.isNaN(this.f2302c)) {
                z = false;
            } else {
                z = true;
            }
            C0376e.m3322a(z, (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f2300a, this.f2302c, false), new LatLng(this.f2301b, this.f2303d, false));
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        C0376e.m3321a((Object) latLng, (Object) "null southwest");
        C0376e.m3321a((Object) latLng2, (Object) "null northeast");
        C0376e.m3323a(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", new Object[]{Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude)});
        this.f2304a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* renamed from: a */
    int m3576a() {
        return this.f2304a;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        return m3570a(latLng.latitude) && m3573b(latLng.longitude);
    }

    public boolean contains(LatLngBounds latLngBounds) {
        if (latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (m3571a(latLngBounds) || latLngBounds.m3571a(this)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m3571a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        double d = ((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) - this.northeast.latitude) - this.southwest.latitude;
        double d2 = ((this.northeast.latitude - this.southwest.latitude) + latLngBounds.northeast.latitude) - latLngBounds.southwest.latitude;
        if (Math.abs(((latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) - this.northeast.longitude) - this.southwest.longitude) >= ((this.northeast.longitude - this.southwest.longitude) + latLngBounds.northeast.longitude) - this.southwest.longitude || Math.abs(d) >= d2) {
            return false;
        }
        return true;
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (m3573b(d3)) {
            d3 = d2;
        } else if (m3574c(d2, d3) >= m3575d(d, d3)) {
            d = d3;
            d3 = d2;
        }
        return new LatLngBounds(new LatLng(min, d3, false), new LatLng(max, d, false));
    }

    /* renamed from: c */
    private static double m3574c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: d */
    private static double m3575d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* renamed from: a */
    private boolean m3570a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: b */
    private boolean m3573b(double d) {
        boolean z = false;
        if (this.southwest.longitude > this.northeast.longitude) {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        } else if (this.southwest.longitude > d || d > this.northeast.longitude) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return C0405u.m3449a(new Object[]{this.southwest, this.northeast});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return C0405u.m3460a(C0405u.m3459a("southwest", this.southwest), C0405u.m3459a("northeast", this.northeast));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.m3577a(this, parcel, i);
    }
}
