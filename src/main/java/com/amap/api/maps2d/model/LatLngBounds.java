package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.p015a.p016a.C0171a;
import com.amap.api.p015a.p016a.C0204q;

public final class LatLngBounds implements Parcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    /* renamed from: a */
    private final int f2603a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        /* renamed from: a */
        private double f2599a = Double.POSITIVE_INFINITY;
        /* renamed from: b */
        private double f2600b = Double.NEGATIVE_INFINITY;
        /* renamed from: c */
        private double f2601c = Double.NaN;
        /* renamed from: d */
        private double f2602d = Double.NaN;

        public Builder include(LatLng latLng) {
            this.f2599a = Math.min(this.f2599a, latLng.latitude);
            this.f2600b = Math.max(this.f2600b, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f2601c)) {
                this.f2601c = d;
                this.f2602d = d;
            } else if (!m3787a(d)) {
                if (LatLngBounds.m3793c(this.f2601c, d) < LatLngBounds.m3794d(this.f2602d, d)) {
                    this.f2601c = d;
                } else {
                    this.f2602d = d;
                }
            }
            return this;
        }

        /* renamed from: a */
        private boolean m3787a(double d) {
            boolean z = false;
            if (this.f2601c > this.f2602d) {
                if (this.f2601c <= d || d <= this.f2602d) {
                    z = true;
                }
                return z;
            } else if (this.f2601c > d || d > this.f2602d) {
                return false;
            } else {
                return true;
            }
        }

        public LatLngBounds build() {
            C0171a.m622a(!Double.isNaN(this.f2601c), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f2599a, this.f2601c), new LatLng(this.f2600b, this.f2602d));
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        C0171a.m621a((Object) latLng, (Object) "null southwest");
        C0171a.m621a((Object) latLng2, (Object) "null northeast");
        C0171a.m623a(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", new Object[]{Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude)});
        this.f2603a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    /* renamed from: a */
    int m3795a() {
        return this.f2603a;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        return m3789a(latLng.latitude) && m3792b(latLng.longitude);
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
        if (m3790a(latLngBounds) || latLngBounds.m3790a(this)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m3790a(LatLngBounds latLngBounds) {
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
        if (m3792b(d3) || m3793c(d2, d3) < m3794d(d, d3)) {
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d3));
    }

    /* renamed from: c */
    private static double m3793c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: d */
    private static double m3794d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* renamed from: a */
    private boolean m3789a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: b */
    private boolean m3792b(double d) {
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
        return C0204q.m794a(new Object[]{this.southwest, this.northeast});
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
        return C0204q.m800a(C0204q.m799a("southwest", this.southwest), C0204q.m799a("northeast", this.northeast));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.m3796a(this, parcel, i);
    }
}
