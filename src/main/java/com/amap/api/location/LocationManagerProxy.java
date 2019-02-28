package com.amap.api.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.amap.api.location.core.C0284c;
import com.amap.api.location.core.C0285d;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import p054u.aly.bi_常量类;

public class LocationManagerProxy {
    public static final String GPS_PROVIDER = "gps";
    public static final String KEY_LOCATION_CHANGED = "location";
    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    public static final String KEY_PROXIMITY_ENTERING = "entering";
    public static final String KEY_STATUS_CHANGED = "status";
    public static final String NETWORK_PROVIDER = "network";
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;
    /* renamed from: b */
    private static LocationManagerProxy f1235b = null;
    /* renamed from: a */
    private LocationManager f1236a = null;
    /* renamed from: c */
    private C0277a f1237c = null;
    /* renamed from: d */
    private Context f1238d;
    /* renamed from: e */
    private C0291f f1239e;
    /* renamed from: f */
    private C0274b f1240f;
    /* renamed from: g */
    private ArrayList<PendingIntent> f1241g = new ArrayList();
    /* renamed from: h */
    private Hashtable<String, LocationProviderProxy> f1242h = new Hashtable();
    /* renamed from: i */
    private Vector<C0292g> f1243i = new Vector();
    /* renamed from: j */
    private Vector<C0292g> f1244j = new Vector();
    /* renamed from: k */
    private C0273a f1245k = new C0273a(this);

    /* renamed from: com.amap.api.location.LocationManagerProxy$a */
    class C0273a implements AMapLocationListener {
        /* renamed from: a */
        final /* synthetic */ LocationManagerProxy f1233a;

        C0273a(LocationManagerProxy locationManagerProxy) {
            this.f1233a = locationManagerProxy;
        }

        public void onLocationChanged(Location location) {
            int i = 0;
            int i2;
            C0292g c0292g;
            if (location != null) {
                try {
                    AMapLocation aMapLocation = new AMapLocation(location);
                    i2 = 0;
                    while (this.f1233a.f1243i != null && i2 < this.f1233a.f1243i.size()) {
                        c0292g = (C0292g) this.f1233a.f1243i.get(i2);
                        if (!(c0292g == null || c0292g.f1326b == null)) {
                            c0292g.f1326b.onLocationChanged(aMapLocation);
                        }
                        if (!(c0292g == null || c0292g.f1325a != -1 || this.f1233a.f1244j == null)) {
                            this.f1233a.f1244j.add(c0292g);
                        }
                        i2++;
                    }
                    if (this.f1233a.f1244j != null && this.f1233a.f1244j.size() > 0 && this.f1233a.f1243i != null) {
                        while (i < this.f1233a.f1244j.size()) {
                            this.f1233a.f1243i.remove(this.f1233a.f1244j.get(i));
                            i++;
                        }
                        this.f1233a.f1244j.clear();
                        if (this.f1233a.f1243i.size() == 0 && this.f1233a.f1236a != null && this.f1233a.f1245k != null) {
                            this.f1233a.f1236a.removeUpdates(this.f1233a.f1245k);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            i2 = 0;
            while (this.f1233a.f1243i != null && i2 < this.f1233a.f1243i.size()) {
                c0292g = (C0292g) this.f1233a.f1243i.get(i2);
                if (!(c0292g == null || c0292g.f1325a != -1 || this.f1233a.f1244j == null)) {
                    this.f1233a.f1244j.add(c0292g);
                }
                i2++;
            }
            if (this.f1233a.f1244j != null && this.f1233a.f1244j.size() > 0 && this.f1233a.f1243i != null) {
                for (int i3 = 0; i3 < this.f1233a.f1244j.size(); i3++) {
                    this.f1233a.f1243i.remove(this.f1233a.f1244j.get(i3));
                }
                this.f1233a.f1244j.clear();
                if (this.f1233a.f1243i.size() == 0 && this.f1233a.f1236a != null && this.f1233a.f1245k != null) {
                    this.f1233a.f1236a.removeUpdates(this.f1233a.f1245k);
                }
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onProviderDisabled(String str) {
        }

        public void onLocationChanged(AMapLocation aMapLocation) {
        }
    }

    /* renamed from: com.amap.api.location.LocationManagerProxy$b */
    class C0274b implements AMapLocationListener {
        /* renamed from: a */
        final /* synthetic */ LocationManagerProxy f1234a;

        C0274b(LocationManagerProxy locationManagerProxy) {
            this.f1234a = locationManagerProxy;
        }

        public void onLocationChanged(Location location) {
            try {
                if (this.f1234a.f1241g != null && this.f1234a.f1241g.size() > 0) {
                    Iterator it = this.f1234a.f1241g.iterator();
                    while (it.hasNext()) {
                        PendingIntent pendingIntent = (PendingIntent) it.next();
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(LocationManagerProxy.KEY_LOCATION_CHANGED, location);
                        intent.putExtras(bundle);
                        pendingIntent.send(this.f1234a.f1238d, 0, intent);
                    }
                }
            } catch (CanceledException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onProviderDisabled(String str) {
        }

        public void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (this.f1234a.f1241g != null && this.f1234a.f1241g.size() > 0) {
                    Iterator it = this.f1234a.f1241g.iterator();
                    while (it.hasNext()) {
                        PendingIntent pendingIntent = (PendingIntent) it.next();
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(LocationManagerProxy.KEY_LOCATION_CHANGED, aMapLocation);
                        intent.putExtras(bundle);
                        pendingIntent.send(this.f1234a.f1238d, 0, intent);
                    }
                }
            } catch (CanceledException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m1761a() {
        f1235b = null;
    }

    private LocationManagerProxy(Context context) {
        m1762a(context);
    }

    private LocationManagerProxy(Activity activity) {
        m1762a(activity.getApplicationContext());
    }

    public static synchronized LocationManagerProxy getInstance(Activity activity) {
        LocationManagerProxy locationManagerProxy;
        synchronized (LocationManagerProxy.class) {
            try {
                if (f1235b == null) {
                    f1235b = new LocationManagerProxy(activity);
                }
                locationManagerProxy = f1235b;
            } catch (Throwable th) {
                th.printStackTrace();
                locationManagerProxy = null;
            }
        }
        return locationManagerProxy;
    }

    public static synchronized LocationManagerProxy getInstance(Context context) {
        LocationManagerProxy locationManagerProxy;
        synchronized (LocationManagerProxy.class) {
            try {
                if (f1235b == null) {
                    f1235b = new LocationManagerProxy(context);
                }
                locationManagerProxy = f1235b;
            } catch (Throwable th) {
                th.printStackTrace();
                locationManagerProxy = null;
            }
        }
        return locationManagerProxy;
    }

    /* renamed from: a */
    private void m1762a(Context context) {
        try {
            this.f1238d = context;
            C0284c.m1822a(context);
            this.f1236a = (LocationManager) context.getSystemService(KEY_LOCATION_CHANGED);
            this.f1237c = new C0277a(context.getApplicationContext(), this.f1236a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void addProximityAlert(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            if (this.f1237c.f1257f) {
                this.f1236a.addProximityAlert(d, d2, f, j, pendingIntent);
            }
            this.f1237c.m1782a(d, d2, f, j, pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void addGeoFenceAlert(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            if (this.f1237c != null) {
                this.f1237c.m1789b(d, d2, f, j, pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            if (this.f1237c != null) {
                this.f1237c.m1790b(pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeProximityAlert(PendingIntent pendingIntent) {
        try {
            if (!(this.f1237c == null || !this.f1237c.f1257f || this.f1236a == null)) {
                this.f1236a.removeProximityAlert(pendingIntent);
            }
            if (this.f1237c != null) {
                this.f1237c.m1785a(pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapLocation getLastKnownLocation(String str) {
        try {
            if (this.f1237c == null) {
                return null;
            }
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                return this.f1237c.m1781a();
            }
            if (this.f1236a == null) {
                return null;
            }
            Location mark = StubApp.mark(this.f1236a, str);
            if (mark != null) {
                return new AMapLocation(mark);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void setGpsEnable(boolean z) {
        try {
            if (this.f1237c != null) {
                this.f1237c.m1787a(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1763a(String str, long j, float f, AMapLocationListener aMapLocationListener, boolean z) {
        try {
            String str2;
            if (this.f1237c == null) {
                this.f1237c = new C0277a(this.f1238d.getApplicationContext(), this.f1236a);
            }
            if (str == null) {
                str2 = LocationProviderProxy.AMapNetwork;
            } else {
                str2 = str;
            }
            if (LocationProviderProxy.AMapNetwork.equals(str2)) {
                this.f1237c.m1784a(j, f, aMapLocationListener, LocationProviderProxy.AMapNetwork, z);
            } else if ("gps".equals(str2)) {
                this.f1237c.m1784a(j, f, aMapLocationListener, "gps", z);
            } else {
                Looper mainLooper = this.f1238d.getMainLooper();
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                this.f1243i.add(new C0292g(j, f, aMapLocationListener, str2, false));
                this.f1236a.requestLocationUpdates(str2, j, f, this.f1245k, mainLooper);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public void requestLocationUpdates(String str, long j, float f, AMapLocationListener aMapLocationListener) {
        m1763a(str, j, f, aMapLocationListener, false);
    }

    public void requestLocationData(String str, long j, float f, AMapLocationListener aMapLocationListener) {
        m1763a(str, j, f, aMapLocationListener, true);
    }

    public void removeUpdates(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            try {
                if (this.f1237c != null) {
                    this.f1237c.m1786a(aMapLocationListener);
                }
                this.f1236a.removeUpdates(aMapLocationListener);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (this.f1243i != null && this.f1243i.size() > 0) {
            int size = this.f1243i.size();
            int i = 0;
            while (i < size) {
                int i2;
                C0292g c0292g = (C0292g) this.f1243i.get(i);
                if (aMapLocationListener.equals(c0292g.f1326b)) {
                    this.f1243i.remove(c0292g);
                    i2 = i - 1;
                    i = size - 1;
                } else {
                    i2 = i;
                    i = size;
                }
                size = i;
                i = i2 + 1;
            }
            if (this.f1243i.size() == 0 && this.f1245k != null) {
                this.f1236a.removeUpdates(this.f1245k);
            }
        }
    }

    public void requestLocationUpdates(String str, long j, float f, PendingIntent pendingIntent) {
        try {
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                if (this.f1239e == null) {
                    this.f1239e = new C0291f(this);
                }
                if (this.f1240f == null) {
                    this.f1240f = new C0274b(this);
                }
                this.f1239e.m1868a(this.f1240f, j, f, str);
                this.f1241g.add(pendingIntent);
                return;
            }
            this.f1241g.add(pendingIntent);
            this.f1236a.requestLocationUpdates(str, j, f, pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeUpdates(PendingIntent pendingIntent) {
        try {
            if (this.f1239e != null) {
                this.f1241g.remove(pendingIntent);
                if (this.f1241g.size() == 0) {
                    this.f1239e.m1867a();
                }
            }
            this.f1239e = null;
            this.f1236a.removeUpdates(pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<String> getAllProviders() {
        try {
            List<String> allProviders = this.f1236a.getAllProviders();
            if (allProviders == null) {
                allProviders = new ArrayList();
                allProviders.add(LocationProviderProxy.AMapNetwork);
                allProviders.addAll(this.f1236a.getAllProviders());
                return allProviders;
            } else if (allProviders.contains(LocationProviderProxy.AMapNetwork)) {
                return allProviders;
            } else {
                allProviders.add(LocationProviderProxy.AMapNetwork);
                return allProviders;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<String> getProviders(boolean z) {
        try {
            List<String> providers = this.f1236a.getProviders(z);
            if (!isProviderEnabled(LocationProviderProxy.AMapNetwork)) {
                return providers;
            }
            if (providers == null || providers.size() == 0) {
                providers = new ArrayList();
            }
            providers.add(LocationProviderProxy.AMapNetwork);
            return providers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<String> getProviders(Criteria criteria, boolean z) {
        try {
            List<String> providers = this.f1236a.getProviders(criteria, z);
            if (providers == null || providers.size() == 0) {
                providers = new ArrayList();
            }
            if (!LocationProviderProxy.AMapNetwork.equals(getBestProvider(criteria, z))) {
                return providers;
            }
            providers.add(LocationProviderProxy.AMapNetwork);
            return providers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getBestProvider(Criteria criteria, boolean z) {
        try {
            String str = LocationProviderProxy.AMapNetwork;
            if (criteria == null) {
                return str;
            }
            if (!getProvider(LocationProviderProxy.AMapNetwork).meetsCriteria(criteria)) {
                str = this.f1236a.getBestProvider(criteria, z);
            }
            if (!z || C0285d.m1846a(this.f1238d)) {
                return str;
            }
            return this.f1236a.getBestProvider(criteria, z);
        } catch (Throwable th) {
            th.printStackTrace();
            return "gps";
        }
    }

    public boolean isProviderEnabled(String str) {
        try {
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                return C0285d.m1846a(this.f1238d);
            }
            return this.f1236a.isProviderEnabled(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public LocationProviderProxy getProvider(String str) {
        if (str == null) {
            try {
                throw new IllegalArgumentException("name不能为空！");
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else if (this.f1242h.containsKey(str)) {
            return (LocationProviderProxy) this.f1242h.get(str);
        } else {
            LocationProviderProxy a = LocationProviderProxy.m1770a(this.f1236a, str);
            this.f1242h.put(str, a);
            return a;
        }
    }

    public GpsStatus getGpsStatus(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = null;
        try {
            if (this.f1236a != null) {
                gpsStatus2 = this.f1236a.getGpsStatus(gpsStatus);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return gpsStatus2;
    }

    public void removeGpsStatusListener(Listener listener) {
        try {
            if (this.f1236a != null) {
                this.f1236a.removeGpsStatusListener(listener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean addGpsStatusListener(Listener listener) {
        try {
            if (this.f1236a != null) {
                return this.f1236a.addGpsStatusListener(listener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void addTestProvider(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, int i2) {
        try {
            if (this.f1236a != null) {
                this.f1236a.addTestProvider(str, z, z2, z3, z4, z5, z6, z7, i, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderEnabled(String str, boolean z) {
        try {
            if (this.f1236a != null) {
                this.f1236a.setTestProviderEnabled(str, z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderLocation(String str, Location location) {
        try {
            if (this.f1236a != null) {
                this.f1236a.setTestProviderLocation(str, location);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderStatus(String str, int i, Bundle bundle, long j) {
        try {
            if (this.f1236a != null) {
                this.f1236a.setTestProviderStatus(str, i, bundle, j);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderEnabled(String str) {
        try {
            if (this.f1236a != null) {
                this.f1236a.clearTestProviderEnabled(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderLocation(String str) {
        try {
            if (this.f1236a != null) {
                this.f1236a.clearTestProviderLocation(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderStatus(String str) {
        try {
            if (this.f1236a != null) {
                this.f1236a.clearTestProviderStatus(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestWeatherUpdates(int i, AMapLocalWeatherListener aMapLocalWeatherListener) {
        try {
            this.f1237c.m1783a(i, aMapLocalWeatherListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public void destory() {
        try {
            destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.f1237c != null) {
                this.f1237c.m1788b();
            }
            if (this.f1242h != null) {
                this.f1242h.clear();
            }
            if (this.f1243i != null) {
                this.f1243i.clear();
            }
            if (this.f1236a != null) {
                if (this.f1245k != null) {
                    this.f1236a.removeUpdates(this.f1245k);
                }
                if (this.f1241g != null) {
                    for (int i = 0; i < this.f1241g.size(); i++) {
                        PendingIntent pendingIntent = (PendingIntent) this.f1241g.get(i);
                        if (pendingIntent != null) {
                            this.f1236a.removeUpdates(pendingIntent);
                        }
                    }
                }
            }
            if (this.f1241g != null) {
                this.f1241g.clear();
            }
            this.f1237c = null;
            m1761a();
            this.f1245k = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getVersion() {
        try {
            return "V1.3.0";
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }
}
