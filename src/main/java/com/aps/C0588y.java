package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.amap.api.location.LocationManagerProxy;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import p054u.aly.bi_常量类;

/* renamed from: com.aps.y */
public class C0588y {
    /* renamed from: P */
    private static float f3571P = 1.1f;
    /* renamed from: Q */
    private static float f3572Q = 2.2f;
    /* renamed from: R */
    private static float f3573R = 2.3f;
    /* renamed from: S */
    private static float f3574S = 3.8f;
    /* renamed from: T */
    private static int f3575T = 3;
    /* renamed from: U */
    private static int f3576U = 10;
    /* renamed from: V */
    private static int f3577V = 2;
    /* renamed from: W */
    private static int f3578W = 7;
    /* renamed from: X */
    private static int f3579X = 20;
    /* renamed from: Y */
    private static int f3580Y = 70;
    /* renamed from: Z */
    private static int f3581Z = ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;
    /* renamed from: a */
    protected static boolean f3582a = false;
    /* renamed from: b */
    protected static boolean f3583b = true;
    /* renamed from: c */
    private static int f3584c = 10;
    /* renamed from: d */
    private static int f3585d = 2;
    /* renamed from: e */
    private static int f3586e = 10;
    /* renamed from: f */
    private static int f3587f = 10;
    /* renamed from: g */
    private static int f3588g = 50;
    /* renamed from: h */
    private static int f3589h = 200;
    /* renamed from: i */
    private static Object f3590i = new Object();
    /* renamed from: j */
    private static C0588y f3591j;
    /* renamed from: A */
    private Thread f3592A = null;
    /* renamed from: B */
    private Looper f3593B = null;
    /* renamed from: C */
    private at f3594C = null;
    /* renamed from: D */
    private Location f3595D = null;
    /* renamed from: E */
    private as f3596E = null;
    /* renamed from: F */
    private Handler f3597F = null;
    /* renamed from: G */
    private au f3598G = new au(this);
    /* renamed from: H */
    private LocationListener f3599H = new ao(this);
    /* renamed from: I */
    private BroadcastReceiver f3600I = new ap(this);
    /* renamed from: J */
    private GpsStatus f3601J = null;
    /* renamed from: K */
    private int f3602K = 0;
    /* renamed from: L */
    private int f3603L = 0;
    /* renamed from: M */
    private HashMap f3604M = null;
    /* renamed from: N */
    private int f3605N = 0;
    /* renamed from: O */
    private int f3606O = 0;
    /* renamed from: k */
    private boolean f3607k = false;
    /* renamed from: l */
    private boolean f3608l = false;
    /* renamed from: m */
    private int f3609m = -1;
    /* renamed from: n */
    private int f3610n = 0;
    /* renamed from: o */
    private int f3611o = 0;
    /* renamed from: p */
    private int f3612p = 10000;
    /* renamed from: q */
    private long f3613q = 0;
    /* renamed from: r */
    private Context f3614r;
    /* renamed from: s */
    private LocationManager f3615s;
    /* renamed from: t */
    private ai f3616t;
    /* renamed from: u */
    private aw f3617u;
    /* renamed from: v */
    private bd f3618v;
    /* renamed from: w */
    private af f3619w;
    /* renamed from: x */
    private bc f3620x;
    /* renamed from: y */
    private av f3621y;
    /* renamed from: z */
    private ab f3622z;

    private C0588y(Context context) {
        this.f3614r = context;
        this.f3616t = ai.m4333a(context);
        this.f3622z = new ab();
        this.f3617u = new aw(this.f3616t);
        this.f3619w = new af(context);
        this.f3618v = new bd(this.f3619w);
        this.f3620x = new bc(this.f3619w);
        this.f3615s = (LocationManager) this.f3614r.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        this.f3621y = av.m4392a(this.f3614r);
        this.f3621y.m4399a(this.f3598G);
        m4632n();
        List allProviders = this.f3615s.getAllProviders();
        boolean z = allProviders != null && allProviders.contains("gps") && allProviders.contains("passive");
        this.f3608l = z;
        be.m4427a(context);
    }

    /* renamed from: a */
    static /* synthetic */ int m4592a(C0588y c0588y, C0586w c0586w, int i) {
        if (c0588y.f3605N >= f3576U) {
            return 1;
        }
        if (c0588y.f3605N <= f3575T) {
            return 4;
        }
        double c = c0586w.m4590c();
        if (c <= ((double) f3571P)) {
            return 1;
        }
        if (c >= ((double) f3572Q)) {
            return 4;
        }
        c = c0586w.m4589b();
        return c > ((double) f3573R) ? c >= ((double) f3574S) ? 4 : i < f3578W ? i <= f3577V ? 4 : c0588y.f3604M != null ? c0588y.m4593a(c0588y.f3604M) : 3 : 1 : 1;
    }

    /* renamed from: a */
    private int m4593a(HashMap hashMap) {
        if (this.f3602K > 4) {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int i2 = 0;
            for (Entry value : hashMap.entrySet()) {
                List list = (List) value.getValue();
                if (list != null) {
                    Object a = m4605a(list);
                    if (a != null) {
                        arrayList.add(a);
                        i = i2 + 1;
                        arrayList2.add(Integer.valueOf(i2));
                        i2 = i;
                    }
                }
                i = i2;
                i2 = i;
            }
            if (!arrayList.isEmpty()) {
                double[] dArr = new double[2];
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    double[] dArr2 = (double[]) arrayList.get(i3);
                    i = ((Integer) arrayList2.get(i3)).intValue();
                    dArr2[0] = dArr2[0] * ((double) i);
                    dArr2[1] = dArr2[1] * ((double) i);
                    dArr[0] = dArr[0] + dArr2[0];
                    dArr[1] = dArr[1] + dArr2[1];
                }
                dArr[0] = dArr[0] / ((double) size);
                dArr[1] = dArr[1] / ((double) size);
                double d = dArr[0];
                double d2 = dArr[1];
                double toDegrees = d2 == 0.0d ? d > 0.0d ? 90.0d : d < 0.0d ? 270.0d : 0.0d : Math.toDegrees(Math.atan(d / d2));
                double[] dArr3 = new double[]{Math.sqrt((d * d) + (d2 * d2)), toDegrees};
                String.format(Locale.CHINA, "%d,%d,%d,%d", new Object[]{Long.valueOf(Math.round(dArr[0] * 100.0d)), Long.valueOf(Math.round(dArr[1] * 100.0d)), Long.valueOf(Math.round(dArr3[0] * 100.0d)), Long.valueOf(Math.round(dArr3[1] * 100.0d))});
                if (dArr3[0] <= ((double) f3580Y)) {
                    return 1;
                }
                if (dArr3[0] >= ((double) f3581Z)) {
                    return 4;
                }
            }
        }
        return 3;
    }

    /* renamed from: a */
    public static C0588y m4600a(Context context) {
        if (f3591j == null) {
            synchronized (f3590i) {
                if (f3591j == null) {
                    f3591j = new C0588y(context);
                }
            }
        }
        return f3591j;
    }

    /* renamed from: a */
    static /* synthetic */ void m4603a(C0588y c0588y, Location location, int i, long j) {
        Location location2;
        int i2;
        int i3;
        aa a;
        int i4 = 1;
        System.currentTimeMillis();
        boolean a2 = c0588y.f3617u.m4411a(location);
        if (a2) {
            c0588y.f3617u.f3394b.f3397b = new Location(location);
        }
        boolean b = c0588y.f3617u.m4412b(location);
        if (b) {
            c0588y.f3617u.f3393a.f3407b = new Location(location);
        }
        if (i == 1) {
            location2 = c0588y.f3595D;
            i2 = 1;
            i3 = 1;
        } else if (i == 2) {
            location2 = c0588y.f3595D;
            i2 = 1;
            i3 = 0;
        } else {
            boolean z = a2;
            a2 = b;
            location2 = location;
        }
        if (i3 == 0) {
            i4 = i2 != 0 ? 2 : 0;
        } else if (i2 != 0) {
            i4 = 3;
        }
        try {
            ab abVar = c0588y.f3622z;
            a = ab.m4303a(location2, c0588y.f3616t, i4, (byte) c0588y.f3606O, j);
        } catch (Exception e) {
            a = null;
        }
        if (a != null && c0588y.f3616t != null) {
            List n = c0588y.f3616t.m4377n();
            Long valueOf = Long.valueOf(0);
            if (n != null && n.size() > 0) {
                valueOf = (Long) n.get(0);
            }
            c0588y.f3618v.m4425a(valueOf.longValue(), a.m4302a());
        }
    }

    /* renamed from: a */
    private double[] m4605a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        double[] dArr = new double[2];
        for (GpsSatellite gpsSatellite : list) {
            if (gpsSatellite != null) {
                double elevation = (double) (90.0f - gpsSatellite.getElevation());
                double azimuth = (double) gpsSatellite.getAzimuth();
                double[] dArr2 = new double[]{Math.sin(Math.toRadians(azimuth)) * elevation, elevation * Math.cos(Math.toRadians(azimuth))};
                dArr[0] = dArr[0] + dArr2[0];
                dArr[1] = dArr[1] + dArr2[1];
            }
        }
        int size = list.size();
        dArr[0] = dArr[0] / ((double) size);
        dArr[1] = dArr[1] / ((double) size);
        return dArr;
    }

    /* renamed from: b */
    static /* synthetic */ String m4609b(C0588y c0588y, String str) {
        return str;
    }

    /* renamed from: n */
    private void m4632n() {
        this.f3610n = this.f3621y.m4402b() * 1000;
        this.f3611o = this.f3621y.m4404c();
        aw awVar = this.f3617u;
        int i = this.f3610n;
        i = this.f3611o;
        aw.m4408a();
    }

    /* renamed from: a */
    public void m4635a() {
        if (this.f3608l && this.f3616t != null && !f3582a) {
            IntentFilter intentFilter = new IntentFilter("android.location.GPS_ENABLED_CHANGE");
            intentFilter.addAction("android.location.GPS_FIX_CHANGE");
            this.f3614r.registerReceiver(this.f3600I, intentFilter);
            String str = bi_常量类.f6358b_空串;
            this.f3615s.removeUpdates(this.f3599H);
            if (this.f3593B != null) {
                this.f3593B.quit();
                this.f3593B = null;
            }
            if (this.f3592A != null) {
                this.f3592A.interrupt();
                this.f3592A = null;
            }
            this.f3592A = new aq(this, str);
            this.f3592A.start();
            this.f3616t.m4363a();
            f3582a = true;
        }
    }

    /* renamed from: a */
    public void m4636a(int i) {
        if (i == 256 || i == 8736 || i == 768) {
            this.f3619w.m4325a(i);
            return;
        }
        throw new RuntimeException("invalid Size! must be COLLECTOR_SMALL_SIZE or COLLECTOR_BIG_SIZE or COLLECTOR_MEDIUM_SIZE");
    }

    /* renamed from: a */
    public void m4637a(ae aeVar, String str) {
        boolean a = this.f3621y.m4401a(str);
        if (aeVar != null) {
            byte[] a2 = aeVar.m4306a();
            if (a && a2 != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3614r.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        this.f3621y.m4398a(a2.length + this.f3621y.m4406e());
                    } else {
                        this.f3621y.m4403b(a2.length + this.f3621y.m4407f());
                    }
                }
            }
            aeVar.m4305a(a);
            this.f3620x.m4424a(aeVar);
        }
    }

    /* renamed from: b */
    public void m4638b() {
        if (this.f3608l && this.f3616t != null && f3582a) {
            if (this.f3600I != null) {
                try {
                    this.f3614r.unregisterReceiver(this.f3600I);
                } catch (Exception e) {
                }
            }
            this.f3615s.removeGpsStatusListener(this.f3596E);
            this.f3615s.removeNmeaListener(this.f3596E);
            this.f3596E = null;
            this.f3615s.removeUpdates(this.f3599H);
            if (this.f3593B != null) {
                this.f3593B.quit();
                this.f3593B = null;
            }
            if (this.f3592A != null) {
                this.f3592A.interrupt();
                this.f3592A = null;
            }
            if (this.f3594C != null) {
                this.f3607k = false;
                this.f3594C.interrupt();
                this.f3594C = null;
            }
            this.f3616t.m4365b();
            f3582a = false;
        }
    }

    /* renamed from: c */
    public void m4639c() {
        if (this.f3608l) {
            m4638b();
        }
    }

    /* renamed from: d */
    public ae m4640d() {
        m4641e();
        return !this.f3621y.m4400a() ? null : this.f3620x.m4423a(this.f3621y.m4405d());
    }

    /* renamed from: e */
    public boolean m4641e() {
        if (this.f3616t == null) {
            return false;
        }
        List n = this.f3616t.m4377n();
        return (n == null || n.size() <= 0) ? false : this.f3619w.m4327b(((Long) n.get(0)).longValue());
    }

    /* renamed from: f */
    public int m4642f() {
        return this.f3620x != null ? this.f3620x.m4422a() : 0;
    }
}
