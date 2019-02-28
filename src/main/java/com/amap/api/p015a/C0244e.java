package com.amap.api.p015a;

import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps2d.LocationSource.OnLocationChangedListener;

/* compiled from: AMapOnLocationChangedListener */
/* renamed from: com.amap.api.a.e */
class C0244e implements OnLocationChangedListener {
    /* renamed from: a */
    Location f1031a;
    /* renamed from: b */
    private af f1032b;

    C0244e(af afVar) {
        this.f1032b = afVar;
    }

    public void onLocationChanged(Location location) {
        this.f1031a = location;
        try {
            if (this.f1032b.mo140n()) {
                this.f1032b.mo90a(location);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
