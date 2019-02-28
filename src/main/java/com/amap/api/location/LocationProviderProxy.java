package com.amap.api.location;

import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;

public class LocationProviderProxy {
    public static final String AMapNetwork = "lbs";
    public static final int AVAILABLE = 2;
    public static final int OUT_OF_SERVICE = 0;
    public static final int TEMPORARILY_UNAVAILABLE = 1;
    /* renamed from: a */
    private LocationManager f1246a;
    /* renamed from: b */
    private String f1247b;

    protected LocationProviderProxy(LocationManager locationManager, String str) {
        this.f1246a = locationManager;
        this.f1247b = str;
    }

    /* renamed from: a */
    static LocationProviderProxy m1770a(LocationManager locationManager, String str) {
        return new LocationProviderProxy(locationManager, str);
    }

    /* renamed from: a */
    private LocationProvider m1769a() {
        try {
            if (this.f1246a != null) {
                return this.f1246a.getProvider(this.f1247b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public int getAccuracy() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f1247b)) {
                return 2;
            }
            if (m1769a() != null) {
                return m1769a().getAccuracy();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getName() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f1247b)) {
                return AMapNetwork;
            }
            if (m1769a() != null) {
                return m1769a().getName();
            }
            return "null";
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getPowerRequirement() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f1247b)) {
                return 2;
            }
            if (m1769a() != null) {
                return m1769a().getPowerRequirement();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean hasMonetaryCost() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f1247b)) && m1769a() != null) {
                z = m1769a().hasMonetaryCost();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean meetsCriteria(Criteria criteria) {
        try {
            if (AMapNetwork == null || !AMapNetwork.equals(this.f1247b)) {
                if (m1769a() != null) {
                    return m1769a().meetsCriteria(criteria);
                }
                return false;
            } else if (criteria == null) {
                return true;
            } else {
                if (criteria.isAltitudeRequired() || criteria.isBearingRequired() || criteria.isSpeedRequired() || criteria.getAccuracy() == 1) {
                    return false;
                }
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean requiresCell() {
        boolean z = true;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f1247b)) && m1769a() != null) {
                z = m1769a().requiresCell();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean requiresNetwork() {
        boolean z = true;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f1247b)) && m1769a() != null) {
                z = m1769a().requiresNetwork();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean requiresSatellite() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.f1247b)) {
                return false;
            }
            if (m1769a() != null) {
                return m1769a().requiresNetwork();
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean supportsAltitude() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f1247b)) && m1769a() != null) {
                z = m1769a().supportsAltitude();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean supportsBearing() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f1247b)) && m1769a() != null) {
                z = m1769a().supportsBearing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean supportsSpeed() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.f1247b)) && m1769a() != null) {
                z = m1769a().supportsSpeed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }
}
