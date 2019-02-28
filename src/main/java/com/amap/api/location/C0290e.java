package com.amap.api.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.location.core.C0284c;
import com.aps.C0584u;
import com.stub.StubApp;

/* compiled from: IGPSManager */
/* renamed from: com.amap.api.location.e */
class C0290e implements LocationListener {
    /* renamed from: a */
    final /* synthetic */ C0289d f1322a;

    C0290e(C0289d c0289d) {
        this.f1322a = c0289d;
    }

    public void onLocationChanged(Location location) {
        AMapLocation aMapLocation;
        Message message;
        Exception e;
        Throwable th;
        Message message2;
        AMapLocation aMapLocation2;
        try {
            StubApp.mark(location);
            this.f1322a.f1320d.m1791b(true);
            this.f1322a.f1320d.f1255d = System.currentTimeMillis();
            aMapLocation = null;
            if (location == null) {
                message = new Message();
                message.obj = null;
                message.what = 100;
                if (this.f1322a.f1319c != null) {
                    this.f1322a.f1319c.sendMessage(message);
                }
                this.f1322a.f1320d.f1254c = true;
                this.f1322a.f1320d.f1255d = System.currentTimeMillis();
                if (this.f1322a.f1320d.f1253b != null && this.f1322a.f1320d.f1253b.f1278a != null) {
                    this.f1322a.f1320d.f1253b.f1278a.mo678a(null);
                    return;
                }
                return;
            }
            if (C0284c.m1824a(location.getLatitude(), location.getLongitude())) {
                double[] a = C0584u.m4585a(location.getLongitude(), location.getLatitude());
                aMapLocation2 = new AMapLocation(location);
                try {
                    aMapLocation2.setLatitude(a[1]);
                    aMapLocation2.setLongitude(a[0]);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        message = new Message();
                        message.obj = aMapLocation2;
                        message.what = 100;
                        if (this.f1322a.f1319c != null) {
                            this.f1322a.f1319c.sendMessage(message);
                        }
                        this.f1322a.f1320d.f1254c = true;
                        this.f1322a.f1320d.f1255d = System.currentTimeMillis();
                        if (this.f1322a.f1320d.f1253b != null && this.f1322a.f1320d.f1253b.f1278a != null) {
                            this.f1322a.f1320d.f1253b.f1278a.mo678a(aMapLocation2);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aMapLocation = aMapLocation2;
                        message2 = new Message();
                        message2.obj = aMapLocation;
                        message2.what = 100;
                        if (this.f1322a.f1319c != null) {
                            this.f1322a.f1319c.sendMessage(message2);
                        }
                        this.f1322a.f1320d.f1254c = true;
                        this.f1322a.f1320d.f1255d = System.currentTimeMillis();
                        this.f1322a.f1320d.f1253b.f1278a.mo678a(aMapLocation);
                        throw th;
                    }
                }
            }
            aMapLocation2 = new AMapLocation(location);
            message = new Message();
            message.obj = aMapLocation2;
            message.what = 100;
            if (this.f1322a.f1319c != null) {
                this.f1322a.f1319c.sendMessage(message);
            }
            this.f1322a.f1320d.f1254c = true;
            this.f1322a.f1320d.f1255d = System.currentTimeMillis();
            if (this.f1322a.f1320d.f1253b != null && this.f1322a.f1320d.f1253b.f1278a != null) {
                this.f1322a.f1320d.f1253b.f1278a.mo678a(aMapLocation2);
            }
        } catch (Exception e3) {
            e = e3;
            aMapLocation2 = null;
            e.printStackTrace();
            message = new Message();
            message.obj = aMapLocation2;
            message.what = 100;
            if (this.f1322a.f1319c != null) {
                this.f1322a.f1319c.sendMessage(message);
            }
            this.f1322a.f1320d.f1254c = true;
            this.f1322a.f1320d.f1255d = System.currentTimeMillis();
            if (this.f1322a.f1320d.f1253b != null) {
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
