package com.iflytek.cloud.p022a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.amap.api.location.LocationManagerProxy;
import com.iflytek.cloud.Setting;
import com.iflytek.cloud.p023b.p024e.C0942a;
import com.iflytek.cloud.p023b.p024e.C0945d;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.stub.StubApp;

/* renamed from: com.iflytek.cloud.a.a */
public class C0913a {
    /* renamed from: a */
    public static C0913a f4361a = null;
    /* renamed from: b */
    private SharedPreferences f4362b = null;
    /* renamed from: c */
    private Context f4363c = null;
    /* renamed from: d */
    private boolean f4364d = true;
    /* renamed from: e */
    private long f4365e = 0;

    private C0913a(Context context) {
        this.f4363c = context;
        this.f4362b = context.getSharedPreferences("com.iflytek.msc", 0);
        this.f4364d = C0913a.m6974b(context);
    }

    /* renamed from: a */
    public static C0913a m6973a(Context context) {
        if (f4361a == null && context != null) {
            C0913a.m6975c(context);
        }
        return f4361a;
    }

    /* renamed from: b */
    public static boolean m6974b(Context context) {
        try {
            if (!Setting.f4358c || context == null) {
                return false;
            }
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            int i = 0;
            while (i < strArr.length) {
                if ("android.permission.ACCESS_FINE_LOCATION".equalsIgnoreCase(strArr[i]) || "android.permission.ACCESS_COARSE_LOCATION".equalsIgnoreCase(strArr[i])) {
                    return true;
                }
                i++;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    private static synchronized C0913a m6975c(Context context) {
        C0913a c0913a;
        synchronized (C0913a.class) {
            if (f4361a == null) {
                f4361a = new C0913a(context);
            }
            C0945d.m7138a(context);
            C0942a.m7128a(context);
            C0916d.m6991a();
            c0913a = f4361a;
        }
        return c0913a;
    }

    /* renamed from: a */
    public synchronized float m6976a(String str) {
        try {
            if (this.f4364d && System.currentTimeMillis() - this.f4365e > 216000) {
                LocationManager locationManager = (LocationManager) this.f4363c.getApplicationContext().getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
                this.f4365e = System.currentTimeMillis();
                m6978a("loction_last_update", this.f4365e);
                C0939a.m7122b("getLocation begin:" + System.currentTimeMillis());
                Criteria criteria = new Criteria();
                criteria.setAccuracy(1);
                C0939a.m7122b("bestProvider:" + locationManager.getBestProvider(criteria, true));
                Location mark = StubApp.mark(locationManager, "gps");
                if (mark != null) {
                    C0939a.m7120a(mark.toString());
                    m6977a(mark);
                } else {
                    Location mark2 = StubApp.mark(locationManager, LocationManagerProxy.NETWORK_PROVIDER);
                    if (mark2 != null) {
                        C0939a.m7120a(mark2.toString());
                        m6977a(mark2);
                    }
                }
                C0939a.m7122b("getLocation end:" + System.currentTimeMillis());
            }
        } catch (Exception e) {
        }
        return this.f4362b.getFloat(str, -0.1f);
    }

    /* renamed from: a */
    public void m6977a(Location location) {
        if (location != null) {
            Editor edit = this.f4362b.edit();
            edit.putFloat("msc.lat", (float) location.getLatitude());
            edit.putFloat("msc.lng", (float) location.getLongitude());
            edit.commit();
        }
    }

    /* renamed from: a */
    public void m6978a(String str, long j) {
        Editor edit = this.f4362b.edit();
        edit.putLong(str, j);
        edit.commit();
    }

    /* renamed from: b */
    public long m6979b(String str, long j) {
        return this.f4362b.getLong(str, j);
    }
}
