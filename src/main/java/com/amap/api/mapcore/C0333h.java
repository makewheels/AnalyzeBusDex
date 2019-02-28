package com.amap.api.mapcore;

import android.location.Location;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;

/* compiled from: AMapOnLocationChangedListener */
/* renamed from: com.amap.api.mapcore.h */
class C0333h implements OnLocationChangedListener {
    /* renamed from: a */
    Location f1755a;
    /* renamed from: b */
    private C0313u f1756b;

    C0333h(C0313u c0313u) {
        this.f1756b = c0313u;
    }

    public void onLocationChanged(Location location) {
        this.f1755a = location;
        try {
            if (this.f1756b.mo423s()) {
                this.f1756b.mo361a(location);
            }
        } catch (Throwable e) {
            az.m3143a(e, "AMapOnLocationChangedListener", "onLocationChanged");
            e.printStackTrace();
        }
    }
}
