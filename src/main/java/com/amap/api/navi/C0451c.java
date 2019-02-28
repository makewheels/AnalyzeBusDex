package com.amap.api.navi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.location.LocationManagerProxy;
import com.autonavi.tbt.C0615f;
import com.autonavi.tbt.bc;
import com.stub.StubApp;
import java.io.File;
import java.util.Vector;

/* compiled from: GPSManager */
/* renamed from: com.amap.api.navi.c */
public class C0451c implements LocationListener {
    /* renamed from: b */
    private static C0451c f2690b;
    /* renamed from: j */
    private static String f2691j = (C0615f.m4838b() + File.separator + "navigation" + File.separator);
    /* renamed from: a */
    public Handler f2692a = new C0452d(this);
    /* renamed from: c */
    private LocationManager f2693c;
    /* renamed from: d */
    private Context f2694d;
    /* renamed from: e */
    private C0457h f2695e;
    /* renamed from: f */
    private C0450a f2696f = new C0450a();
    /* renamed from: g */
    private boolean f2697g = false;
    /* renamed from: h */
    private long f2698h = 1000;
    /* renamed from: i */
    private int f2699i = 5;
    /* renamed from: k */
    private int f2700k = 0;
    /* renamed from: l */
    private int f2701l = 0;
    /* renamed from: m */
    private boolean f2702m = false;
    /* renamed from: n */
    private boolean f2703n = false;
    /* renamed from: o */
    private int f2704o = 0;
    /* renamed from: p */
    private long f2705p = 0;
    /* renamed from: q */
    private Location f2706q = null;
    /* renamed from: r */
    private Vector<String> f2707r;
    /* renamed from: s */
    private String f2708s = "mnt/sdcard/autonavi/";

    /* compiled from: GPSManager */
    /* renamed from: com.amap.api.navi.c$1 */
    class C04491 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C0451c f2688a;

        public void run() {
            while (this.f2688a.f2702m) {
                try {
                    long j;
                    if (!this.f2688a.f2703n) {
                        this.f2688a.f2700k = this.f2688a.f2700k + 1;
                        if (this.f2688a.f2700k == this.f2688a.f2701l) {
                            this.f2688a.f2703n = true;
                            this.f2688a.f2700k = this.f2688a.f2701l - 2;
                            this.f2688a.f2706q = this.f2688a.m3839a((String) this.f2688a.f2707r.elementAt(this.f2688a.f2700k));
                            this.f2688a.f2705p = this.f2688a.f2706q.getTime();
                        }
                        j = 1000;
                    } else if (this.f2688a.f2700k < this.f2688a.f2704o) {
                        Location a = this.f2688a.m3839a((String) this.f2688a.f2707r.elementAt(this.f2688a.f2700k));
                        long time = a.getTime();
                        j = time - this.f2688a.f2705p;
                        if (j > 0) {
                            Message message = new Message();
                            message.what = 0;
                            message.obj = this.f2688a.f2706q;
                            this.f2688a.f2692a.sendMessage(message);
                        } else {
                            j = 1000;
                        }
                        this.f2688a.f2705p = time;
                        this.f2688a.f2706q = a;
                        this.f2688a.f2700k = this.f2688a.f2700k + 1;
                    } else {
                        this.f2688a.f2702m = false;
                        j = 1000;
                    }
                    Thread.sleep(j);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: GPSManager */
    /* renamed from: com.amap.api.navi.c$a */
    private class C0450a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C0451c f2689a;

        private C0450a(C0451c c0451c) {
            this.f2689a = c0451c;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.location.PROVIDERS_CHANGED".equals(intent.getAction()) && this.f2689a.f2693c != null && this.f2689a.f2693c.isProviderEnabled("gps") && this.f2689a.m3842b()) {
                    this.f2689a.f2693c.removeUpdates(this.f2689a);
                    this.f2689a.f2693c.requestLocationUpdates("gps", this.f2689a.f2698h, (float) this.f2689a.f2699i, this.f2689a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private C0451c(Context context, C0457h c0457h) {
        try {
            this.f2694d = context;
            this.f2695e = c0457h;
            if (this.f2694d != null) {
                this.f2693c = (LocationManager) this.f2694d.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            if (this.f2694d != null) {
                this.f2694d.registerReceiver(this.f2696f, intentFilter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    /* renamed from: a */
    public static synchronized C0451c m3822a(Context context, C0457h c0457h) {
        C0451c c0451c;
        synchronized (C0451c.class) {
            if (f2690b == null) {
                f2690b = new C0451c(context, c0457h);
            }
            c0451c = f2690b;
        }
        return c0451c;
    }

    /* renamed from: a */
    public void m3840a() {
        try {
            m3844d();
            m3830e();
            if (this.f2694d != null) {
                this.f2694d.unregisterReceiver(this.f2696f);
            }
            this.f2696f = null;
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
            return;
        }
        this.f2702m = false;
    }

    /* renamed from: e */
    private synchronized void m3830e() {
        f2690b = null;
    }

    public void onLocationChanged(Location location) {
        StubApp.mark(location);
        if (location != null) {
            try {
                double[] a = bc.m4815a(location.getLongitude(), location.getLatitude());
                if (a != null && a.length > 1) {
                    location.setLongitude(a[0]);
                    location.setLatitude(a[1]);
                }
                if (this.f2695e != null) {
                    C0615f.m4835a("onLocationChanged");
                    this.f2695e.m3881a(2, location.getLongitude(), location.getLatitude());
                    this.f2695e.m3882a(2, location);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0615f.m4834a(th);
            }
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onProviderDisabled(String str) {
    }

    /* renamed from: b */
    public boolean m3842b() {
        return this.f2697g;
    }

    /* renamed from: c */
    public void m3843c() {
        try {
            if (this.f2693c != null) {
                if (!m3842b()) {
                    this.f2693c.removeUpdates(this);
                    this.f2693c.requestLocationUpdates("gps", 1000, 0.0f, this);
                    this.f2695e.m3897c();
                }
                this.f2697g = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    /* renamed from: a */
    public void m3841a(long j, int i) {
        try {
            if (this.f2693c != null) {
                if (!(m3842b() && this.f2698h == j && this.f2699i == i)) {
                    this.f2693c.removeUpdates(this);
                    this.f2693c.requestLocationUpdates("gps", j, (float) i, this);
                    this.f2698h = j;
                    this.f2699i = i;
                    this.f2695e.m3897c();
                }
                this.f2697g = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    /* renamed from: d */
    public void m3844d() {
        if (this.f2693c != null) {
            this.f2693c.removeUpdates(this);
            this.f2697g = false;
        }
    }

    /* renamed from: a */
    public Location m3839a(String str) {
        try {
            String[] split = str.split(",");
            if (split != null && split.length >= 11) {
                Location location = new Location("agps");
                location.setLatitude(Double.parseDouble(split[0]));
                location.setLongitude(Double.parseDouble(split[1]));
                location.setAltitude(Double.parseDouble(split[3]));
                location.setSpeed(Float.parseFloat(split[5]));
                location.setBearing(Float.parseFloat(split[7]));
                location.setAccuracy(Float.parseFloat(split[9]));
                location.setTime(Long.parseLong(split[10]));
                return location;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
