package com.amap.api.location;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.amap.api.location.C0277a.C0276a;

/* compiled from: IGPSManager */
/* renamed from: com.amap.api.location.d */
public class C0289d {
    /* renamed from: a */
    public LocationManager f1317a = null;
    /* renamed from: b */
    LocationListener f1318b = new C0290e(this);
    /* renamed from: c */
    private C0276a f1319c;
    /* renamed from: d */
    private C0277a f1320d;
    /* renamed from: e */
    private Context f1321e;

    C0289d(Context context, LocationManager locationManager, C0276a c0276a, C0277a c0277a) {
        this.f1321e = context;
        this.f1317a = locationManager;
        this.f1320d = c0277a;
        this.f1319c = c0276a;
    }

    /* renamed from: a */
    void m1865a(long j, float f) {
        try {
            Looper mainLooper = this.f1321e.getMainLooper();
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.f1317a.requestLocationUpdates("gps", j, f, this.f1318b, mainLooper);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    void m1864a() {
    }

    /* renamed from: b */
    void m1866b() {
        if (this.f1318b != null) {
            this.f1317a.removeUpdates(this.f1318b);
        }
    }
}
