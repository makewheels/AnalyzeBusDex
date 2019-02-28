package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.C0405u;

public final class VisibleRegion implements Parcelable {
    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
    /* renamed from: a */
    private final int f2398a;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f2398a = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public void writeToParcel(Parcel parcel, int i) {
        VisibleRegionCreator.m3582a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return C0405u.m3449a(new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
    }

    /* renamed from: a */
    int m3581a() {
        return this.f2398a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        if (this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return C0405u.m3460a(C0405u.m3459a("nearLeft", this.nearLeft), C0405u.m3459a("nearRight", this.nearRight), C0405u.m3459a("farLeft", this.farLeft), C0405u.m3459a("farRight", this.farRight), C0405u.m3459a("latLngBounds", this.latLngBounds));
    }
}
