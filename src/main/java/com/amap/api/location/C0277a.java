package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.C0285d;
import com.aps.C0568j;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: AMapLocationManager */
/* renamed from: com.amap.api.location.a */
public class C0277a {
    /* renamed from: a */
    C0289d f1252a = null;
    /* renamed from: b */
    C0281c f1253b = null;
    /* renamed from: c */
    boolean f1254c = false;
    /* renamed from: d */
    long f1255d;
    /* renamed from: e */
    boolean f1256e = true;
    /* renamed from: f */
    boolean f1257f = true;
    /* renamed from: g */
    C0280b f1258g;
    /* renamed from: h */
    private Context f1259h;
    /* renamed from: i */
    private Vector<C0292g> f1260i = null;
    /* renamed from: j */
    private C0276a f1261j = null;
    /* renamed from: k */
    private Vector<C0292g> f1262k = new Vector();
    /* renamed from: l */
    private AMapLocation f1263l;
    /* renamed from: m */
    private AMapLocation f1264m;
    /* renamed from: n */
    private Thread f1265n;
    /* renamed from: o */
    private long f1266o = 2000;
    /* renamed from: p */
    private float f1267p = 10.0f;

    /* compiled from: AMapLocationManager */
    /* renamed from: com.amap.api.location.a$a */
    class C0276a extends Handler {
        /* renamed from: a */
        final /* synthetic */ C0277a f1251a;

        public C0276a(C0277a c0277a, Looper looper) {
            this.f1251a = c0277a;
            super(looper);
            Looper.prepare();
        }

        public C0276a(C0277a c0277a) {
            this.f1251a = c0277a;
        }

        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    if (message.what == 100 && this.f1251a.f1260i != null) {
                        this.f1251a.f1263l = (AMapLocation) message.obj;
                        if (!(this.f1251a.f1263l == null || this.f1251a.f1263l.getAdCode() == null || this.f1251a.f1263l.getAdCode().length() <= 0)) {
                            this.f1251a.f1264m = this.f1251a.f1263l;
                        }
                        Iterator it = this.f1251a.f1260i.iterator();
                        while (it.hasNext()) {
                            C0292g c0292g = (C0292g) it.next();
                            if (c0292g.f1326b != null) {
                                AMapLocation aMapLocation = (AMapLocation) message.obj;
                                if (c0292g.f1327c.booleanValue() || aMapLocation.getAMapException().getErrorCode() == 0) {
                                    c0292g.f1326b.onLocationChanged(aMapLocation);
                                    if (c0292g.f1327c.booleanValue() && c0292g.f1325a == -1 && this.f1251a.f1262k != null) {
                                        this.f1251a.f1262k.add(c0292g);
                                    }
                                }
                            }
                        }
                        if (this.f1251a.f1262k != null && this.f1251a.f1262k.size() > 0) {
                            for (int i = 0; i < this.f1251a.f1262k.size(); i++) {
                                this.f1251a.m1786a(((C0292g) this.f1251a.f1262k.get(i)).f1326b);
                            }
                            this.f1251a.f1262k.clear();
                        }
                        if (this.f1251a.f1263l != null) {
                            C0285d.m1843a(this.f1251a.f1259h, this.f1251a.f1263l);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                }
            }
        }
    }

    C0277a(Context context, LocationManager locationManager) {
        this.f1259h = context;
        m1776c();
        if (Looper.myLooper() == null) {
            this.f1261j = new C0276a(this, context.getMainLooper());
        } else {
            this.f1261j = new C0276a(this);
        }
        this.f1252a = new C0289d(context, locationManager, this.f1261j, this);
        this.f1253b = new C0281c(context, this.f1261j, this);
        m1791b(false);
        this.f1256e = true;
        this.f1257f = true;
        this.f1258g = new C0280b(this, context);
    }

    /* renamed from: c */
    private void m1776c() {
        this.f1260i = new Vector();
    }

    /* renamed from: a */
    void m1782a(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        C0568j c0568j = new C0568j();
        c0568j.f3503b = d;
        c0568j.f3502a = d2;
        c0568j.f3504c = f;
        c0568j.m4530a(j);
        this.f1253b.m1810a(c0568j, pendingIntent);
    }

    /* renamed from: b */
    void m1789b(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        C0568j c0568j = new C0568j();
        c0568j.f3503b = d;
        c0568j.f3502a = d2;
        c0568j.f3504c = f;
        c0568j.m4530a(j);
        this.f1253b.m1812b(c0568j, pendingIntent);
    }

    /* renamed from: a */
    void m1785a(PendingIntent pendingIntent) {
        this.f1253b.m1809a(pendingIntent);
    }

    /* renamed from: b */
    void m1790b(PendingIntent pendingIntent) {
        this.f1253b.m1811b(pendingIntent);
    }

    /* renamed from: a */
    AMapLocation m1781a() {
        if (this.f1263l != null) {
            return this.f1263l;
        }
        return C0285d.m1847b(this.f1259h);
    }

    /* renamed from: a */
    void m1784a(long j, float f, AMapLocationListener aMapLocationListener, String str, boolean z) {
        this.f1266o = j;
        this.f1267p = f;
        if (aMapLocationListener != null) {
            this.f1260i.add(new C0292g(j, f, aMapLocationListener, str, z));
        }
        if ("gps".equals(str)) {
            this.f1252a.m1865a(j, f);
        } else if (LocationProviderProxy.AMapNetwork.equals(str)) {
            if (this.f1257f) {
                this.f1252a.m1865a(j, f);
            }
            this.f1253b.m1808a(j);
            m1777c(true);
            if (this.f1265n == null) {
                this.f1265n = new Thread(this.f1253b);
                this.f1265n.start();
            }
        }
    }

    /* renamed from: c */
    private void m1777c(boolean z) {
        this.f1256e = z;
    }

    /* renamed from: a */
    void m1786a(AMapLocationListener aMapLocationListener) {
        int size = this.f1260i.size();
        int i = 0;
        while (i < size) {
            int i2;
            C0292g c0292g = (C0292g) this.f1260i.get(i);
            if (aMapLocationListener.equals(c0292g.f1326b)) {
                this.f1260i.remove(c0292g);
                i2 = i - 1;
                i = size - 1;
            } else {
                i2 = i;
                i = size;
            }
            size = i;
            i = i2 + 1;
        }
        if (this.f1252a != null && this.f1260i.size() == 0) {
            this.f1252a.m1866b();
            m1791b(false);
            m1777c(false);
            if (this.f1265n != null) {
                this.f1265n.interrupt();
                this.f1265n = null;
            }
        }
    }

    /* renamed from: a */
    void m1787a(boolean z) {
        m1779d(z);
        if (this.f1260i != null && this.f1260i.size() > 0) {
            if (z) {
                this.f1252a.m1866b();
                this.f1252a.m1865a(this.f1266o, this.f1267p);
                return;
            }
            this.f1252a.m1866b();
        }
    }

    /* renamed from: d */
    private void m1779d(boolean z) {
        this.f1257f = z;
    }

    /* renamed from: b */
    synchronized void m1788b() {
        if (this.f1252a != null) {
            this.f1252a.m1866b();
            this.f1252a.m1864a();
            this.f1252a = null;
        }
        if (this.f1253b != null) {
            this.f1253b.m1807a();
            this.f1253b = null;
        }
        if (this.f1260i != null) {
            this.f1260i.clear();
        }
        m1791b(false);
        this.f1265n = null;
    }

    /* renamed from: b */
    void m1791b(boolean z) {
        this.f1254c = z;
    }

    /* renamed from: a */
    void m1783a(final int i, final AMapLocalWeatherListener aMapLocalWeatherListener) {
        try {
            new Thread(this) {
                /* renamed from: c */
                final /* synthetic */ C0277a f1250c;

                public void run() {
                    this.f1250c.f1258g.m1799a(i, aMapLocalWeatherListener, this.f1250c.f1264m);
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
