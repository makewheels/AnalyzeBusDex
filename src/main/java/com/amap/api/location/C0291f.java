package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;

/* compiled from: LocationListenerProxy */
/* renamed from: com.amap.api.location.f */
public class C0291f implements AMapLocationListener {
    /* renamed from: a */
    private LocationManagerProxy f1323a;
    /* renamed from: b */
    private AMapLocationListener f1324b = null;

    public C0291f(LocationManagerProxy locationManagerProxy) {
        this.f1323a = locationManagerProxy;
    }

    /* renamed from: a */
    public boolean m1868a(AMapLocationListener aMapLocationListener, long j, float f, String str) {
        this.f1324b = aMapLocationListener;
        if (!LocationProviderProxy.AMapNetwork.equals(str)) {
            return false;
        }
        this.f1323a.requestLocationUpdates(str, j, f, (AMapLocationListener) this);
        return true;
    }

    /* renamed from: a */
    public void m1867a() {
        if (this.f1323a != null) {
            this.f1323a.removeUpdates((AMapLocationListener) this);
        }
        this.f1324b = null;
    }

    public void onLocationChanged(Location location) {
        if (this.f1324b != null) {
            this.f1324b.onLocationChanged(location);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (this.f1324b != null) {
            this.f1324b.onStatusChanged(str, i, bundle);
        }
    }

    public void onProviderEnabled(String str) {
        if (this.f1324b != null) {
            this.f1324b.onProviderEnabled(str);
        }
    }

    public void onProviderDisabled(String str) {
        if (this.f1324b != null) {
            this.f1324b.onProviderDisabled(str);
        }
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (this.f1324b != null) {
            this.f1324b.onLocationChanged(aMapLocation);
        }
    }
}
