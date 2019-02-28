package com.aps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.stub.StubApp;
import java.text.SimpleDateFormat;

final class ao implements LocationListener {
    /* renamed from: a */
    private /* synthetic */ C0588y f3366a;

    ao(C0588y c0588y) {
        this.f3366a = c0588y;
    }

    /* renamed from: a */
    private static boolean m4388a(Location location) {
        return location != null && "gps".equalsIgnoreCase(location.getProvider()) && location.getLatitude() > -90.0d && location.getLatitude() < 90.0d && location.getLongitude() > -180.0d && location.getLongitude() < 180.0d;
    }

    public final void onLocationChanged(Location location) {
        try {
            StubApp.mark(location);
            long time = location.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.format(Long.valueOf(time));
            simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            if (time > 0) {
                currentTimeMillis = time;
            }
            if (location != null && m4388a(location)) {
                if (location.getSpeed() > ((float) C0588y.f3586e)) {
                    aw.m4409a(C0588y.f3589h);
                    aw.m4410b(C0588y.f3589h * 10);
                } else if (location.getSpeed() > ((float) C0588y.f3585d)) {
                    aw.m4409a(C0588y.f3588g);
                    aw.m4410b(C0588y.f3588g * 10);
                } else {
                    aw.m4409a(C0588y.f3587f);
                    aw.m4410b(C0588y.f3587f * 10);
                }
                this.f3366a.f3621y.m4400a();
                m4388a(location);
                if (this.f3366a.f3621y.m4400a() && m4388a(location)) {
                    location.setTime(System.currentTimeMillis());
                    this.f3366a.f3613q = System.currentTimeMillis();
                    this.f3366a.f3595D = location;
                    if (!this.f3366a.f3607k) {
                        C0588y.m4603a(this.f3366a, location, 0, currentTimeMillis);
                    } else {
                        be.m4426a("collector");
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
