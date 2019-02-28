package com.aps;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.C0289d;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.C0284c;
import com.amap.api.location.core.C0285d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: APS */
/* renamed from: com.aps.a */
public class C0554a implements C0553k {
    /* renamed from: A */
    private long f3258A = 0;
    /* renamed from: B */
    private C0569l f3259B = C0569l.m4533a();
    /* renamed from: C */
    private int f3260C = 0;
    /* renamed from: D */
    private String f3261D = "00:00:00:00:00:00";
    /* renamed from: E */
    private C0588y f3262E = null;
    /* renamed from: F */
    private StringBuilder f3263F = new StringBuilder();
    /* renamed from: G */
    private long f3264G = 0;
    /* renamed from: H */
    private long f3265H = 0;
    /* renamed from: I */
    private CellLocation f3266I = null;
    /* renamed from: J */
    private String f3267J = null;
    /* renamed from: K */
    private String f3268K = null;
    /* renamed from: L */
    private boolean f3269L = false;
    /* renamed from: a */
    long f3270a = 0;
    /* renamed from: b */
    TimerTask f3271b;
    /* renamed from: c */
    Timer f3272c;
    /* renamed from: d */
    ae f3273d;
    /* renamed from: e */
    int f3274e = 0;
    /* renamed from: f */
    private Context f3275f = null;
    /* renamed from: g */
    private int f3276g = 9;
    /* renamed from: h */
    private ConnectivityManager f3277h = null;
    /* renamed from: i */
    private WifiManager f3278i = null;
    /* renamed from: j */
    private TelephonyManager f3279j = null;
    /* renamed from: k */
    private List<C0559e> f3280k = new ArrayList();
    /* renamed from: l */
    private List<ScanResult> f3281l = new ArrayList();
    /* renamed from: m */
    private Map<PendingIntent, List<C0568j>> f3282m = new HashMap();
    /* renamed from: n */
    private Map<PendingIntent, List<C0568j>> f3283n = new HashMap();
    /* renamed from: o */
    private C0555b f3284o = new C0555b();
    /* renamed from: p */
    private PhoneStateListener f3285p = null;
    /* renamed from: q */
    private int f3286q = -113;
    /* renamed from: r */
    private C0552a f3287r = new C0552a();
    /* renamed from: s */
    private WifiInfo f3288s = null;
    /* renamed from: t */
    private JSONObject f3289t = null;
    /* renamed from: u */
    private String f3290u = null;
    /* renamed from: v */
    private C0556c f3291v = null;
    /* renamed from: w */
    private long f3292w = 0;
    /* renamed from: x */
    private boolean f3293x = false;
    /* renamed from: y */
    private long f3294y = 0;
    /* renamed from: z */
    private long f3295z = 0;

    /* compiled from: APS */
    /* renamed from: com.aps.a$1 */
    class C05501 extends PhoneStateListener {
        /* renamed from: a */
        final /* synthetic */ C0554a f3254a;

        C05501(C0554a c0554a) {
            this.f3254a = c0554a;
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation != null) {
                try {
                    if (!this.f3254a.m4278p()) {
                        this.f3254a.f3266I = cellLocation;
                        this.f3254a.f3294y = C0583t.m4572a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public void onSignalStrengthChanged(int i) {
            int i2 = -113;
            try {
                switch (this.f3254a.f3276g) {
                    case 1:
                        i2 = C0583t.m4570a(i);
                        break;
                    case 2:
                        i2 = C0583t.m4570a(i);
                        break;
                }
                this.f3254a.m4255b(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int i = -113;
            try {
                switch (this.f3254a.f3276g) {
                    case 1:
                        i = C0583t.m4570a(signalStrength.getGsmSignalStrength());
                        break;
                    case 2:
                        i = signalStrength.getCdmaDbm();
                        break;
                }
                this.f3254a.m4255b(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            try {
                switch (serviceState.getState()) {
                    case 1:
                        this.f3254a.f3280k.clear();
                        this.f3254a.f3286q = -113;
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: APS */
    /* renamed from: com.aps.a$a */
    private class C0552a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C0554a f3257a;

        private C0552a(C0554a c0554a) {
            this.f3257a = c0554a;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    String action = intent.getAction();
                    if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                        if (this.f3257a.f3278i != null) {
                            this.f3257a.f3281l = this.f3257a.f3278i.getScanResults();
                            if (this.f3257a.f3281l == null) {
                                this.f3257a.f3281l = new ArrayList();
                            }
                        }
                    } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                        if (this.f3257a.f3278i != null) {
                            r0 = 4;
                            try {
                                r0 = this.f3257a.f3278i.getWifiState();
                            } catch (SecurityException e) {
                            }
                            switch (r0) {
                                case 0:
                                    this.f3257a.m4276n();
                                    return;
                                case 1:
                                    this.f3257a.m4276n();
                                    return;
                                case 4:
                                    this.f3257a.m4276n();
                                    return;
                                default:
                                    return;
                            }
                            th.printStackTrace();
                        }
                    } else if (action.equals("android.intent.action.SCREEN_ON")) {
                        CellLocation.requestLocationUpdate();
                        this.f3257a.m4277o();
                        C0560f.f3463i = 10000;
                        C0560f.f3464j = 30000;
                    } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                        if (this.f3257a.f3260C >= 5) {
                            C0560f.f3463i = 20000;
                            C0560f.f3464j = 60000;
                        }
                    } else if (action.equals("android.intent.action.AIRPLANE_MODE")) {
                        this.f3257a.f3293x = C0583t.m4577a(context);
                    } else if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                        r0 = intent.getIntExtra("level", 0);
                        int intExtra = intent.getIntExtra("scale", 100);
                        int intExtra2 = intent.getIntExtra("status", 0);
                        C0583t.m4576a("batt is ", Integer.valueOf((r0 * 100) / intExtra), "%");
                        switch (intExtra2) {
                            case 4:
                                if (r0 < 15 && this.f3257a.f3260C >= 5) {
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else if (action.equals("android.location.GPS_FIX_CHANGE")) {
                        this.f3257a.m4298c();
                    } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        if (this.f3257a.m4275m()) {
                            this.f3257a.m4287a(true, 2);
                        }
                    } else if (!action.equals("android.location.PROVIDERS_CHANGED")) {
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo677a(Context context, C0289d c0289d) {
        if (context != null && this.f3275f == null) {
            this.f3275f = context.getApplicationContext();
            C0583t.m4573a(this.f3275f, "in debug mode, only for test");
            m4264f();
            m4266g();
            this.f3264G = System.currentTimeMillis();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized com.aps.C0556c mo675a() throws java.lang.Exception {
        /*
        r9 = this;
        r2 = 0;
        r1 = 1;
        monitor-enter(r9);
        r0 = r9.f3275f;	 Catch:{ all -> 0x000f }
        if (r0 != 0) goto L_0x0012;
    L_0x0007:
        r0 = new com.amap.api.location.core.AMapLocException;	 Catch:{ all -> 0x000f }
        r1 = "未知的错误";
        r0.<init>(r1);	 Catch:{ all -> 0x000f }
        throw r0;	 Catch:{ all -> 0x000f }
    L_0x000f:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0012:
        r0 = com.aps.C0560f.f3458d;	 Catch:{ all -> 0x000f }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x0022;
    L_0x001a:
        r0 = new com.amap.api.location.core.AMapLocException;	 Catch:{ all -> 0x000f }
        r1 = "key鉴权失败";
        r0.<init>(r1);	 Catch:{ all -> 0x000f }
        throw r0;	 Catch:{ all -> 0x000f }
    L_0x0022:
        r0 = com.aps.C0560f.f3459e;	 Catch:{ all -> 0x000f }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x0032;
    L_0x002a:
        r0 = new com.amap.api.location.core.AMapLocException;	 Catch:{ all -> 0x000f }
        r1 = "key鉴权失败";
        r0.<init>(r1);	 Catch:{ all -> 0x000f }
        throw r0;	 Catch:{ all -> 0x000f }
    L_0x0032:
        r0 = r9.f3289t;	 Catch:{ all -> 0x000f }
        r0 = com.aps.C0569l.m4538a(r0);	 Catch:{ all -> 0x000f }
        r3 = "false";
        r4 = 0;
        r0 = r0[r4];	 Catch:{ all -> 0x000f }
        r0 = r3.equals(r0);	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x0052;
    L_0x0043:
        r0 = "AuthLocation";
        r1 = "key鉴权失败";
        android.util.Log.e(r0, r1);	 Catch:{ all -> 0x000f }
        r0 = new com.amap.api.location.core.AMapLocException;	 Catch:{ all -> 0x000f }
        r1 = "key鉴权失败";
        r0.<init>(r1);	 Catch:{ all -> 0x000f }
        throw r0;	 Catch:{ all -> 0x000f }
    L_0x0052:
        r0 = r9.m4273k();	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x0061;
    L_0x0058:
        android.telephony.CellLocation.requestLocationUpdate();	 Catch:{ all -> 0x000f }
        r3 = com.aps.C0583t.m4572a();	 Catch:{ all -> 0x000f }
        r9.f3295z = r3;	 Catch:{ all -> 0x000f }
    L_0x0061:
        r0 = r9.m4274l();	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x006a;
    L_0x0067:
        r9.m4277o();	 Catch:{ all -> 0x000f }
    L_0x006a:
        r0 = r9.f3260C;	 Catch:{ all -> 0x000f }
        r0 = r0 + 1;
        r9.f3260C = r0;	 Catch:{ all -> 0x000f }
        r0 = r9.f3260C;	 Catch:{ all -> 0x000f }
        if (r0 <= r1) goto L_0x0077;
    L_0x0074:
        r9.m4298c();	 Catch:{ all -> 0x000f }
    L_0x0077:
        r0 = r9.f3260C;	 Catch:{ all -> 0x000f }
        if (r0 != r1) goto L_0x0095;
    L_0x007b:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x000f }
        r9.f3265H = r3;	 Catch:{ all -> 0x000f }
        r0 = r9.f3275f;	 Catch:{ all -> 0x000f }
        r0 = com.aps.C0583t.m4577a(r0);	 Catch:{ all -> 0x000f }
        r9.f3293x = r0;	 Catch:{ all -> 0x000f }
        r0 = r9.f3278i;	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x0095;
    L_0x008d:
        r0 = r9.f3278i;	 Catch:{ all -> 0x000f }
        r0 = r0.getScanResults();	 Catch:{ all -> 0x000f }
        r9.f3281l = r0;	 Catch:{ all -> 0x000f }
    L_0x0095:
        r0 = r9.f3281l;	 Catch:{ all -> 0x000f }
        if (r0 != 0) goto L_0x00a0;
    L_0x0099:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x000f }
        r0.<init>();	 Catch:{ all -> 0x000f }
        r9.f3281l = r0;	 Catch:{ all -> 0x000f }
    L_0x00a0:
        r0 = r9.f3260C;	 Catch:{ all -> 0x000f }
        if (r0 != r1) goto L_0x00c8;
    L_0x00a4:
        r0 = r9.m4281s();	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x00c8;
    L_0x00aa:
        r3 = r9.f3265H;	 Catch:{ all -> 0x000f }
        r5 = r9.f3264G;	 Catch:{ all -> 0x000f }
        r3 = r3 - r5;
        r5 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x00c8;
    L_0x00b5:
        r0 = 4;
    L_0x00b6:
        if (r0 <= 0) goto L_0x00c8;
    L_0x00b8:
        r3 = r9.f3281l;	 Catch:{ all -> 0x000f }
        r3 = r3.size();	 Catch:{ all -> 0x000f }
        if (r3 != 0) goto L_0x00c8;
    L_0x00c0:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        android.os.SystemClock.sleep(r3);	 Catch:{ all -> 0x000f }
        r0 = r0 + -1;
        goto L_0x00b6;
    L_0x00c8:
        r3 = r9.f3292w;	 Catch:{ all -> 0x000f }
        r0 = r9.m4246a(r3);	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x00de;
    L_0x00d0:
        r0 = r9.f3291v;	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x00de;
    L_0x00d4:
        r0 = com.aps.C0583t.m4572a();	 Catch:{ all -> 0x000f }
        r9.f3292w = r0;	 Catch:{ all -> 0x000f }
        r0 = r9.f3291v;	 Catch:{ all -> 0x000f }
    L_0x00dc:
        monitor-exit(r9);
        return r0;
    L_0x00de:
        r0 = r9.f3266I;	 Catch:{ all -> 0x000f }
        r9.m4241a(r0);	 Catch:{ all -> 0x000f }
        r0 = r9.f3281l;	 Catch:{ all -> 0x000f }
        r9.m4244a(r0);	 Catch:{ all -> 0x000f }
        r3 = r9.m4269h();	 Catch:{ all -> 0x000f }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x00f4;
    L_0x00f2:
        r0 = 0;
        goto L_0x00dc;
    L_0x00f4:
        r4 = r9.m4270i();	 Catch:{ all -> 0x000f }
        r0 = r9.f3275f;	 Catch:{ all -> 0x000f }
        r0 = com.aps.C0558d.m4468a(r0);	 Catch:{ all -> 0x000f }
        r5 = "mem";
        r0 = r0.m4473a(r3, r4, r5);	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x0150;
    L_0x0106:
        r5 = r0.m4446g();	 Catch:{ all -> 0x000f }
        r7 = com.aps.C0583t.m4572a();	 Catch:{ all -> 0x000f }
        r5 = r7 - r5;
        r7 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x0150;
    L_0x0117:
        if (r0 == 0) goto L_0x011b;
    L_0x0119:
        if (r1 == 0) goto L_0x014d;
    L_0x011b:
        r0 = r9.m4282t();	 Catch:{ AMapLocException -> 0x0149 }
    L_0x011f:
        r9.f3291v = r0;	 Catch:{ all -> 0x000f }
    L_0x0121:
        r0 = r9.f3275f;	 Catch:{ all -> 0x000f }
        r0 = com.aps.C0558d.m4468a(r0);	 Catch:{ all -> 0x000f }
        r1 = r9.f3291v;	 Catch:{ all -> 0x000f }
        r0.m4475a(r3, r1, r4);	 Catch:{ all -> 0x000f }
        r0 = 0;
        r1 = r4.length();	 Catch:{ all -> 0x000f }
        r4.delete(r0, r1);	 Catch:{ all -> 0x000f }
        r0 = com.aps.C0583t.m4572a();	 Catch:{ all -> 0x000f }
        r9.f3292w = r0;	 Catch:{ all -> 0x000f }
        r9.m4279q();	 Catch:{ all -> 0x000f }
        r9.m4299d();	 Catch:{ all -> 0x000f }
        r0 = com.aps.C0583t.m4572a();	 Catch:{ all -> 0x000f }
        r9.f3270a = r0;	 Catch:{ all -> 0x000f }
        r0 = r9.f3291v;	 Catch:{ all -> 0x000f }
        goto L_0x00dc;
    L_0x0149:
        r1 = move-exception;
        if (r0 != 0) goto L_0x011f;
    L_0x014c:
        throw r1;	 Catch:{ all -> 0x000f }
    L_0x014d:
        r9.f3291v = r0;	 Catch:{ all -> 0x000f }
        goto L_0x0121;
    L_0x0150:
        r1 = r2;
        goto L_0x0117;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aps.a.a():com.aps.c");
    }

    /* renamed from: a */
    public void mo680a(String str) {
        if (str != null && str.indexOf("##") != -1) {
            String[] split = str.split("##");
            if (split.length == 3) {
                C0560f.m4477a(split[0]);
                if (!C0560f.f3459e.equals(split[1])) {
                    C0558d.m4468a(this.f3275f).m4474a();
                }
                C0560f.m4479b(split[1]);
                C0560f.m4480c(split[2]);
            }
        }
    }

    /* renamed from: a */
    public void mo681a(JSONObject jSONObject) {
        this.f3289t = jSONObject;
    }

    /* renamed from: a */
    public void mo679a(C0568j c0568j, PendingIntent pendingIntent) {
        if (pendingIntent != null && c0568j != null) {
            long a = c0568j.m4529a();
            if (a != -1 && a < C0583t.m4572a()) {
                return;
            }
            List list;
            if (this.f3282m.get(pendingIntent) != null) {
                list = (List) this.f3282m.get(pendingIntent);
                list.add(c0568j);
                this.f3282m.put(pendingIntent, list);
                return;
            }
            list = new ArrayList();
            list.add(c0568j);
            this.f3282m.put(pendingIntent, list);
        }
    }

    /* renamed from: b */
    public void mo684b(C0568j c0568j, PendingIntent pendingIntent) {
        if (pendingIntent != null && c0568j != null) {
            long a = c0568j.m4529a();
            if (a != -1 && a < C0583t.m4572a()) {
                return;
            }
            List list;
            if (this.f3283n.get(pendingIntent) != null) {
                list = (List) this.f3283n.get(pendingIntent);
                list.add(c0568j);
                this.f3283n.put(pendingIntent, list);
                return;
            }
            list = new ArrayList();
            list.add(c0568j);
            this.f3283n.put(pendingIntent, list);
        }
    }

    /* renamed from: a */
    public void mo676a(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f3282m.remove(pendingIntent);
        }
    }

    /* renamed from: b */
    public void mo683b(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f3283n.remove(pendingIntent);
        }
    }

    /* renamed from: b */
    public void mo682b() {
        try {
            if (this.f3262E != null) {
                this.f3262E.m4639c();
                this.f3269L = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.f3275f != null) {
                this.f3275f.unregisterReceiver(this.f3287r);
            }
        } catch (Throwable th2) {
            this.f3287r = null;
        }
        this.f3287r = null;
        m4284v();
        try {
            if (!(this.f3279j == null || this.f3285p == null)) {
                this.f3279j.listen(this.f3285p, 0);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
            C0583t.m4574a(th3);
        }
        C0558d.m4468a(this.f3275f).m4474a();
        C0560f.m4478a(false);
        this.f3292w = 0;
        this.f3280k.clear();
        this.f3282m.clear();
        this.f3283n.clear();
        this.f3286q = -113;
        m4276n();
        this.f3290u = null;
        this.f3291v = null;
        this.f3275f = null;
        this.f3279j = null;
    }

    /* renamed from: f */
    private void m4264f() {
        this.f3278i = (WifiManager) C0583t.m4583b(this.f3275f, "wifi");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.location.GPS_FIX_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        this.f3275f.registerReceiver(this.f3287r, intentFilter);
        m4277o();
    }

    /* renamed from: g */
    private void m4266g() {
        int i;
        this.f3277h = (ConnectivityManager) C0583t.m4583b(this.f3275f, "connectivity");
        CellLocation.requestLocationUpdate();
        this.f3295z = C0583t.m4572a();
        this.f3279j = (TelephonyManager) C0583t.m4583b(this.f3275f, "phone");
        switch (this.f3279j.getPhoneType()) {
            case 1:
                this.f3276g = 1;
                break;
            case 2:
                this.f3276g = 2;
                break;
            default:
                this.f3276g = 9;
                break;
        }
        this.f3285p = new C05501(this);
        if (C0583t.m4581b() < 7) {
            i = 2;
        } else {
            i = 256;
        }
        if (i == 0) {
            this.f3279j.listen(this.f3285p, 16);
            return;
        }
        try {
            this.f3279j.listen(this.f3285p, i | 16);
        } catch (Throwable e) {
            C0583t.m4574a(e);
        }
    }

    /* renamed from: a */
    private void m4241a(CellLocation cellLocation) {
        CellLocation cellLocation2 = null;
        if (!(this.f3293x || this.f3279j == null)) {
            cellLocation2 = this.f3279j.getCellLocation();
        }
        if (cellLocation2 != null) {
            cellLocation = cellLocation2;
        }
        if (cellLocation != null) {
            switch (C0583t.m4571a(cellLocation, this.f3275f)) {
                case 1:
                    if (this.f3279j != null) {
                        m4258c(cellLocation);
                        return;
                    }
                    return;
                case 2:
                    m4262d(cellLocation);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private boolean m4246a(long j) {
        long a = C0583t.m4572a();
        if (a - j >= 300) {
            return false;
        }
        long j2 = 0;
        if (this.f3291v != null) {
            j2 = a - this.f3291v.m4446g();
        }
        if (j2 > 10000) {
            return false;
        }
        return true;
    }

    /* renamed from: h */
    private String m4269h() {
        m4283u();
        String str = bi_常量类.f6358b_空串;
        String str2 = bi_常量类.f6358b_空串;
        str2 = LocationManagerProxy.NETWORK_PROVIDER;
        if (m4281s()) {
            this.f3288s = this.f3278i.getConnectionInfo();
        } else {
            m4276n();
        }
        String str3 = bi_常量类.f6358b_空串;
        C0559e c0559e;
        StringBuilder stringBuilder;
        switch (this.f3276g) {
            case 1:
                if (this.f3280k.size() > 0) {
                    c0559e = (C0559e) this.f3280k.get(0);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(c0559e.f3445a).append("#");
                    stringBuilder.append(c0559e.f3446b).append("#");
                    stringBuilder.append(c0559e.f3447c).append("#");
                    stringBuilder.append(c0559e.f3448d).append("#");
                    stringBuilder.append(str2).append("#");
                    if (this.f3281l.size() > 0) {
                        str = "cellwifi";
                    } else {
                        str = "cell";
                    }
                    stringBuilder.append(str);
                    return stringBuilder.toString();
                }
                break;
            case 2:
                if (this.f3280k.size() > 0) {
                    c0559e = (C0559e) this.f3280k.get(0);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(c0559e.f3445a).append("#");
                    stringBuilder.append(c0559e.f3446b).append("#");
                    stringBuilder.append(c0559e.f3451g).append("#");
                    stringBuilder.append(c0559e.f3452h).append("#");
                    stringBuilder.append(c0559e.f3453i).append("#");
                    stringBuilder.append(str2).append("#");
                    if (this.f3281l.size() > 0) {
                        str = "cellwifi";
                    } else {
                        str = "cell";
                    }
                    stringBuilder.append(str);
                    return stringBuilder.toString();
                }
                break;
            case 9:
                str2 = String.format("#%s#", new Object[]{str2});
                if ((this.f3281l.size() == 1 && !m4248a(this.f3288s)) || this.f3281l.size() == 0) {
                    return null;
                }
                if (this.f3281l.size() != 1 || !m4248a(this.f3288s)) {
                    return str2 + "wifi";
                }
                ScanResult scanResult = (ScanResult) this.f3281l.get(0);
                if (scanResult == null || !this.f3288s.getBSSID().equals(scanResult.BSSID)) {
                    str = str2;
                } else {
                    str = null;
                }
                return str;
        }
        return str;
    }

    /* renamed from: a */
    private boolean m4248a(WifiInfo wifiInfo) {
        if (wifiInfo == null || wifiInfo.getBSSID() == null || wifiInfo.getSSID() == null || wifiInfo.getBSSID().equals("00:00:00:00:00:00") || TextUtils.isEmpty(wifiInfo.getSSID())) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m4247a(ScanResult scanResult) {
        boolean z = false;
        if (scanResult != null) {
            try {
                if (!(TextUtils.isEmpty(scanResult.BSSID) || scanResult.BSSID.equals("00:00:00:00:00:00"))) {
                    z = true;
                }
            } catch (Exception e) {
                return true;
            }
        }
        return z;
    }

    /* renamed from: i */
    private StringBuilder m4270i() {
        m4283u();
        StringBuilder stringBuilder = new StringBuilder(700);
        switch (this.f3276g) {
            case 1:
                for (int i = 0; i < this.f3280k.size(); i++) {
                    if (i != 0) {
                        C0559e c0559e = (C0559e) this.f3280k.get(i);
                        stringBuilder.append("#").append(c0559e.f3446b);
                        stringBuilder.append("|").append(c0559e.f3447c);
                        stringBuilder.append("|").append(c0559e.f3448d);
                    }
                }
                break;
        }
        if ((this.f3261D == null || this.f3261D.equals("00:00:00:00:00:00")) && this.f3288s != null) {
            this.f3261D = this.f3288s.getMacAddress();
            if (this.f3261D == null) {
                this.f3261D = "00:00:00:00:00:00";
            }
        }
        if (m4281s()) {
            String bssid;
            String str = bi_常量类.f6358b_空串;
            if (m4248a(this.f3288s)) {
                bssid = this.f3288s.getBSSID();
            } else {
                bssid = str;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f3281l.size(); i3++) {
                ScanResult scanResult = (ScanResult) this.f3281l.get(i3);
                if (m4247a(scanResult)) {
                    String str2 = scanResult.BSSID;
                    str = "nb";
                    if (bssid.equals(str2)) {
                        str = "access";
                        i2 = 1;
                    }
                    stringBuilder.append(String.format("#%s,%s", new Object[]{str2, str}));
                }
            }
            if (i2 == 0 && bssid.length() > 0) {
                stringBuilder.append("#").append(bssid);
                stringBuilder.append(",access");
            }
        } else {
            m4276n();
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder;
    }

    /* renamed from: a */
    private synchronized byte[] m4251a(Object obj) {
        C0575o c0575o;
        String str;
        StringBuilder stringBuilder;
        c0575o = new C0575o();
        this.f3263F.delete(0, this.f3263F.length());
        String str2 = "0";
        String str3 = "0";
        String str4 = "0";
        String str5 = "0";
        String str6 = "0";
        String str7 = bi_常量类.f6358b_空串;
        C0560f.f3455a = "888888888888888";
        C0560f.f3456b = "888888888888888";
        C0560f.f3457c = bi_常量类.f6358b_空串;
        String str8 = bi_常量类.f6358b_空串;
        String str9 = bi_常量类.f6358b_空串;
        String str10 = bi_常量类.f6358b_空串;
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        if (this.f3276g == 2) {
            str = C0108a.f262e;
        } else {
            str = str2;
        }
        if (this.f3279j != null) {
            if (this.f3267J == null && C0560f.f3455a.equals("888888888888888")) {
                try {
                    C0560f.f3455a = this.f3279j.getDeviceId();
                } catch (SecurityException e) {
                }
            }
            if (C0560f.f3455a == null) {
                C0560f.f3455a = "888888888888888";
            }
            this.f3267J = C0560f.f3455a;
            if ((this.f3268K == null && C0560f.f3456b == null) || C0560f.f3456b.equals("888888888888888")) {
                C0560f.f3456b = "888888888888888";
                try {
                    if (this.f3279j != null) {
                        C0560f.f3456b = this.f3279j.getSubscriberId();
                    }
                } catch (SecurityException e2) {
                }
            }
            if (C0560f.f3456b == null) {
                C0560f.f3456b = "888888888888888";
            }
            this.f3268K = C0560f.f3456b;
            if (TextUtils.isEmpty(C0560f.f3457c)) {
                C0560f.f3457c = bi_常量类.f6358b_空串;
            }
            if (C0560f.f3457c == null) {
                C0560f.f3457c = bi_常量类.f6358b_空串;
            }
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = this.f3277h.getActiveNetworkInfo();
        } catch (SecurityException e3) {
        }
        if (C0569l.m4532a(networkInfo) != -1) {
            str8 = C0569l.m4534a(this.f3279j);
            if (m4281s()) {
                if (m4248a(this.f3288s)) {
                    str9 = "2";
                }
            }
            str9 = C0108a.f262e;
            if (!m4281s()) {
                m4276n();
            }
        } else {
            this.f3288s = null;
        }
        String[] a = C0569l.m4538a(this.f3289t);
        if (a[0].equals("true")) {
            str7 = a[1];
        }
        c0575o.f3521i = str;
        c0575o.f3522j = str3;
        c0575o.f3524l = str4;
        c0575o.f3525m = str5;
        c0575o.f3526n = str6;
        c0575o.f3515c = C0560f.f3458d;
        c0575o.f3516d = C0560f.f3459e;
        c0575o.f3527o = str7;
        c0575o.f3528p = this.f3267J;
        c0575o.f3531s = C0560f.f3457c;
        c0575o.f3529q = this.f3268K;
        c0575o.f3538z = this.f3261D;
        c0575o.f3532t = str8;
        c0575o.f3533u = str9;
        c0575o.f3518f = C0284c.m1830e();
        c0575o.f3519g = "android" + C0284c.m1829d();
        c0575o.f3520h = C0284c.m1831g();
        this.f3263F.append("<?xml version=\"1.0\" encoding=\"");
        this.f3263F.append("GBK").append("\"?>");
        this.f3263F.append("<Cell_Req ver=\"3.0\"><HDR version=\"3.0\" cdma=\"");
        this.f3263F.append(str);
        this.f3263F.append("\" gtype=\"").append(str3);
        this.f3263F.append("\" glong=\"").append(str4);
        this.f3263F.append("\" glat=\"").append(str5);
        this.f3263F.append("\" precision=\"").append(str6);
        this.f3263F.append("\"><src>").append(C0560f.f3458d);
        this.f3263F.append("</src><license>").append(C0560f.f3459e);
        this.f3263F.append("</license><key>").append(str7);
        this.f3263F.append("</key><clientid>").append(C0560f.f3460f);
        this.f3263F.append("</clientid><imei>").append(C0560f.f3455a);
        this.f3263F.append("</imei><imsi>").append(C0560f.f3456b);
        this.f3263F.append("</imsi><smac>").append(this.f3261D);
        this.f3263F.append("</smac></HDR><DRR phnum=\"").append(C0560f.f3457c);
        this.f3263F.append("\" nettype=\"").append(str8);
        this.f3263F.append("\" inftype=\"").append(str9).append("\">");
        if (this.f3280k.size() > 0) {
            StringBuilder stringBuilder5 = new StringBuilder();
            C0559e c0559e;
            switch (this.f3276g) {
                case 1:
                    c0559e = (C0559e) this.f3280k.get(0);
                    stringBuilder5.delete(0, stringBuilder5.length());
                    stringBuilder5.append("<mcc>").append(c0559e.f3445a).append("</mcc>");
                    stringBuilder5.append("<mnc>").append(c0559e.f3446b).append("</mnc>");
                    stringBuilder5.append("<lac>").append(c0559e.f3447c).append("</lac>");
                    stringBuilder5.append("<cellid>").append(c0559e.f3448d);
                    stringBuilder5.append("</cellid>");
                    stringBuilder5.append("<signal>").append(c0559e.f3454j);
                    stringBuilder5.append("</signal>");
                    str7 = stringBuilder5.toString();
                    for (int i = 0; i < this.f3280k.size(); i++) {
                        if (i != 0) {
                            c0559e = (C0559e) this.f3280k.get(i);
                            stringBuilder2.append(c0559e.f3447c).append(",");
                            stringBuilder2.append(c0559e.f3448d).append(",");
                            stringBuilder2.append(c0559e.f3454j);
                            if (i != this.f3280k.size() - 1) {
                                stringBuilder2.append("*");
                            }
                        }
                    }
                    str10 = str7;
                    break;
                case 2:
                    c0559e = (C0559e) this.f3280k.get(0);
                    stringBuilder5.delete(0, stringBuilder5.length());
                    stringBuilder5.append("<mcc>").append(c0559e.f3445a).append("</mcc>");
                    stringBuilder5.append("<sid>").append(c0559e.f3451g).append("</sid>");
                    stringBuilder5.append("<nid>").append(c0559e.f3452h).append("</nid>");
                    stringBuilder5.append("<bid>").append(c0559e.f3453i).append("</bid>");
                    if (c0559e.f3450f > 0 && c0559e.f3449e > 0) {
                        stringBuilder5.append("<lon>").append(c0559e.f3450f).append("</lon>");
                        stringBuilder5.append("<lat>").append(c0559e.f3449e).append("</lat>");
                    }
                    stringBuilder5.append("<signal>").append(c0559e.f3454j).append("</signal>");
                    str10 = stringBuilder5.toString();
                    break;
            }
            stringBuilder5.delete(0, stringBuilder5.length());
            str9 = str10;
        } else {
            str9 = str10;
        }
        if (m4281s()) {
            if (m4248a(this.f3288s)) {
                stringBuilder4.append(this.f3288s.getBSSID()).append(",");
                stringBuilder4.append(this.f3288s.getRssi()).append(",");
                stringBuilder4.append(this.f3288s.getSSID().replace("*", "."));
            }
            for (int i2 = 0; i2 < this.f3281l.size(); i2++) {
                ScanResult scanResult = (ScanResult) this.f3281l.get(i2);
                if (m4247a(scanResult)) {
                    stringBuilder3.append(scanResult.BSSID).append(",");
                    stringBuilder3.append(scanResult.level).append(",");
                    stringBuilder3.append(i2).append("*");
                }
            }
        } else {
            m4276n();
        }
        this.f3263F.append(str9);
        this.f3263F.append(String.format("<nb>%s</nb>", new Object[]{stringBuilder2}));
        if (stringBuilder3.length() == 0) {
            this.f3263F.append(String.format("<macs><![CDATA[%s]]></macs>", new Object[]{stringBuilder4}));
        } else {
            stringBuilder3.deleteCharAt(stringBuilder3.length() - 1);
            this.f3263F.append(String.format("<macs><![CDATA[%s]]></macs>", new Object[]{stringBuilder3}));
        }
        this.f3263F.append(String.format("<mmac><![CDATA[%s]]></mmac>", new Object[]{stringBuilder4}));
        this.f3263F.append("</DRR></Cell_Req>");
        m4243a(this.f3263F);
        if (stringBuilder3.length() == 0) {
            stringBuilder = stringBuilder4;
        } else {
            stringBuilder = stringBuilder3;
        }
        c0575o.f3535w = str9;
        c0575o.f3536x = stringBuilder2.toString();
        c0575o.f3538z = stringBuilder4.toString();
        c0575o.f3537y = stringBuilder.toString();
        c0575o.f3534v = String.valueOf(this.f3276g);
        stringBuilder2.delete(0, stringBuilder2.length());
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder4.delete(0, stringBuilder4.length());
        return c0575o.m4550a();
    }

    /* renamed from: a */
    private synchronized void m4244a(List<ScanResult> list) {
        if (list != null) {
            if (list.size() >= 1) {
                Object hashMap = new HashMap();
                for (int i = 0; i < list.size(); i++) {
                    ScanResult scanResult = (ScanResult) list.get(i);
                    if (list.size() <= 20 || m4245a(scanResult.level)) {
                        if (scanResult.SSID != null) {
                            scanResult.SSID = scanResult.SSID.replace("*", ".");
                        } else {
                            scanResult.SSID = "null";
                        }
                        hashMap.put(Integer.valueOf((scanResult.level * 30) + i), scanResult);
                    }
                }
                TreeMap treeMap = new TreeMap(Collections.reverseOrder());
                treeMap.putAll(hashMap);
                list.clear();
                for (Entry value : treeMap.entrySet()) {
                    list.add(value.getValue());
                    if (list.size() > 29) {
                        break;
                    }
                }
                hashMap.clear();
                treeMap.clear();
            }
        }
    }

    /* renamed from: a */
    private boolean m4245a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (Throwable e) {
            C0583t.m4574a(e);
        }
        if (i2 >= 1) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    private synchronized byte[] m4272j() {
        if (m4273k()) {
            CellLocation.requestLocationUpdate();
            this.f3295z = C0583t.m4572a();
        }
        if (m4274l()) {
            m4277o();
        }
        return m4251a(null);
    }

    /* renamed from: k */
    private boolean m4273k() {
        if (this.f3293x || this.f3295z == 0 || C0583t.m4572a() - this.f3295z < C0560f.f3464j) {
            return false;
        }
        return true;
    }

    /* renamed from: l */
    private boolean m4274l() {
        if (m4281s() && this.f3258A != 0 && C0583t.m4572a() - this.f3258A >= C0560f.f3463i) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    private boolean m4275m() {
        if (this.f3278i == null || !m4281s()) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            if (this.f3277h != null) {
                networkInfo = this.f3277h.getActiveNetworkInfo();
            }
            if (C0569l.m4532a(networkInfo) == -1 || !m4248a(this.f3278i.getConnectionInfo())) {
                return false;
            }
            return true;
        } catch (SecurityException e) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private C0556c m4237a(byte[] bArr, boolean z) throws Exception {
        if (this.f3275f == null) {
            return null;
        }
        C0573m c0573m = new C0573m();
        String a = this.f3259B.m4542a(bArr, this.f3275f, this.f3289t);
        try {
            C0285d.m1845a(a);
        } catch (AMapLocException e) {
            throw e;
        } catch (Exception e2) {
        }
        String str = bi_常量类.f6358b_空串;
        String[] a2 = C0569l.m4538a(this.f3289t);
        if (a != null && a.indexOf("<saps>") != -1) {
            a = this.f3284o.m4415a(c0573m.m4543a(a), "GBK");
        } else if (a2[0].equals("true")) {
            C0583t.m4576a("api return pure");
        } else {
            C0583t.m4576a("aps return pure");
        }
        C0556c b = c0573m.m4544b(a);
        if (C0583t.m4578a(b)) {
            if (b.m4458m() != null) {
            }
            if (this.f3263F == null || this.f3263F.length() <= 0) {
                return b;
            }
            this.f3290u = this.f3263F.toString();
            return b;
        }
        throw new AMapLocException("未知的错误");
    }

    /* renamed from: a */
    private void m4243a(StringBuilder stringBuilder) {
        int i = 0;
        if (stringBuilder != null) {
            String[] strArr = new String[]{" phnum=\"\"", " nettype=\"\"", " nettype=\"UNKNOWN\"", " inftype=\"\"", "<macs><![CDATA[]]></macs>", "<nb></nb>", "<mmac><![CDATA[]]></mmac>", " gtype=\"0\"", " glong=\"0.0\"", " glat=\"0.0\"", " precision=\"0.0\"", " glong=\"0\"", " glat=\"0\"", " precision=\"0\"", "<smac>null</smac>", "<smac>00:00:00:00:00:00</smac>", "<imei>000000000000000</imei>", "<imsi>000000000000000</imsi>", "<mcc>000</mcc>", "<mcc>0</mcc>", "<lac>0</lac>", "<cellid>0</cellid>", "<key></key>"};
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                while (stringBuilder.indexOf(str) != -1) {
                    int indexOf = stringBuilder.indexOf(str);
                    stringBuilder.delete(indexOf, str.length() + indexOf);
                }
                i++;
            }
            while (stringBuilder.indexOf("*<") != -1) {
                stringBuilder.deleteCharAt(stringBuilder.indexOf("*<"));
            }
        }
    }

    /* renamed from: b */
    private void m4255b(int i) {
        if (i == -113) {
            this.f3286q = -113;
            return;
        }
        this.f3286q = i;
        switch (this.f3276g) {
            case 1:
            case 2:
                if (this.f3280k.size() > 0) {
                    ((C0559e) this.f3280k.get(0)).f3454j = this.f3286q;
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private C0559e m4254b(CellLocation cellLocation) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        C0559e c0559e = new C0559e();
        String[] a = C0583t.m4580a(this.f3279j);
        c0559e.f3445a = a[0];
        c0559e.f3446b = a[1];
        c0559e.f3447c = gsmCellLocation.getLac();
        c0559e.f3448d = gsmCellLocation.getCid();
        c0559e.f3454j = this.f3286q;
        return c0559e;
    }

    /* renamed from: a */
    private C0559e m4238a(NeighboringCellInfo neighboringCellInfo) {
        if (C0583t.m4581b() < 5) {
            return null;
        }
        try {
            C0559e c0559e = new C0559e();
            String[] a = C0583t.m4580a(this.f3279j);
            c0559e.f3445a = a[0];
            c0559e.f3446b = a[1];
            c0559e.f3447c = neighboringCellInfo.getLac();
            c0559e.f3448d = neighboringCellInfo.getCid();
            c0559e.f3454j = C0583t.m4570a(neighboringCellInfo.getRssi());
            return c0559e;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private void m4258c(CellLocation cellLocation) {
        if (this.f3280k != null && cellLocation != null && this.f3279j != null) {
            int i;
            this.f3280k.clear();
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getLac() == -1) {
                i = 0;
            } else if (gsmCellLocation.getCid() == -1 || gsmCellLocation.getCid() == 65535 || gsmCellLocation.getCid() >= 268435455) {
                i = 0;
            } else if (gsmCellLocation.getLac() == 0) {
                i = 0;
            } else if (gsmCellLocation.getLac() > 65535) {
                i = 0;
            } else if (gsmCellLocation.getCid() == 0) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                this.f3276g = 9;
                C0583t.m4576a("case 2,gsm illegal");
                return;
            }
            this.f3276g = 1;
            this.f3280k.add(m4254b(cellLocation));
            List<NeighboringCellInfo> neighboringCellInfo = this.f3279j.getNeighboringCellInfo();
            if (neighboringCellInfo != null) {
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    if (neighboringCellInfo2.getCid() != -1) {
                        int i2;
                        if (neighboringCellInfo2.getLac() == -1) {
                            i2 = 0;
                        } else if (neighboringCellInfo2.getLac() == 0) {
                            i2 = 0;
                        } else if (neighboringCellInfo2.getLac() > 65535) {
                            i2 = 0;
                        } else if (neighboringCellInfo2.getCid() == -1) {
                            i2 = 0;
                        } else if (neighboringCellInfo2.getCid() == 0) {
                            i2 = 0;
                        } else if (neighboringCellInfo2.getCid() == 65535) {
                            i2 = 0;
                        } else if (neighboringCellInfo2.getCid() >= 268435455) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            C0559e a = m4238a(neighboringCellInfo2);
                            if (a != null) {
                                this.f3280k.add(a);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private void m4262d(CellLocation cellLocation) {
        this.f3280k.clear();
        if (C0583t.m4581b() >= 5) {
            try {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                if (cdmaCellLocation.getSystemId() <= 0) {
                    this.f3276g = 9;
                    C0583t.m4576a("cdma illegal");
                } else if (cdmaCellLocation.getNetworkId() < 0) {
                    this.f3276g = 9;
                    C0583t.m4576a("cdma illegal");
                } else if (cdmaCellLocation.getBaseStationId() < 0) {
                    this.f3276g = 9;
                    C0583t.m4576a("cdma illegal");
                } else {
                    this.f3276g = 2;
                    String[] a = C0583t.m4580a(this.f3279j);
                    C0559e c0559e = new C0559e();
                    c0559e.f3445a = a[0];
                    c0559e.f3446b = a[1];
                    c0559e.f3451g = cdmaCellLocation.getSystemId();
                    c0559e.f3452h = cdmaCellLocation.getNetworkId();
                    c0559e.f3453i = cdmaCellLocation.getBaseStationId();
                    c0559e.f3454j = this.f3286q;
                    c0559e.f3449e = cdmaCellLocation.getBaseStationLatitude();
                    c0559e.f3450f = cdmaCellLocation.getBaseStationLongitude();
                    this.f3280k.add(c0559e);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: n */
    private void m4276n() {
        this.f3281l.clear();
        this.f3288s = null;
    }

    /* renamed from: o */
    private void m4277o() {
        if (m4281s()) {
            try {
                this.f3278i.startScan();
                this.f3258A = C0583t.m4572a();
            } catch (SecurityException e) {
            }
        }
    }

    /* renamed from: p */
    private boolean m4278p() {
        if (this.f3294y != 0 && C0583t.m4572a() - this.f3294y < 2000) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m4298c() {
        try {
            if (this.f3262E == null) {
                this.f3262E = C0588y.m4600a(this.f3275f);
                this.f3262E.m4636a(256);
            }
            if (!this.f3269L) {
                this.f3269L = true;
                this.f3262E.m4635a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: q */
    private void m4279q() {
        if (this.f3291v != null && this.f3282m.size() >= 1) {
            Iterator it = this.f3282m.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<C0568j> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (C0568j c0568j : list) {
                    long a = c0568j.m4529a();
                    if (a == -1 || a >= C0583t.m4572a()) {
                        float a2 = C0583t.m4569a(new double[]{c0568j.f3503b, c0568j.f3502a, this.f3291v.m4442e(), this.f3291v.m4440d()});
                        if (a2 < c0568j.f3504c) {
                            bundle.putFloat("distance", a2);
                            bundle.putString("fence", c0568j.m4531b());
                            intent.putExtras(bundle);
                            try {
                                pendingIntent.send(this.f3275f, 0, intent);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void m4299d() {
        if (this.f3291v != null && this.f3283n.size() >= 1) {
            Iterator it = this.f3283n.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<C0568j> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (C0568j c0568j : list) {
                    long a = c0568j.m4529a();
                    if (a == -1 || a >= C0583t.m4572a()) {
                        float a2 = C0583t.m4569a(new double[]{c0568j.f3503b, c0568j.f3502a, this.f3291v.m4442e(), this.f3291v.m4440d()});
                        if (a2 >= c0568j.f3504c) {
                            if (c0568j.f3505d != 0) {
                                c0568j.f3505d = 0;
                            }
                        }
                        if (a2 < c0568j.f3504c) {
                            if (c0568j.f3505d != 1) {
                                c0568j.f3505d = 1;
                            }
                        }
                        bundle.putFloat("distance", a2);
                        bundle.putString("fence", c0568j.m4531b());
                        bundle.putInt("status", c0568j.f3505d);
                        intent.putExtras(bundle);
                        try {
                            pendingIntent.send(this.f3275f, 0, intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo678a(AMapLocation aMapLocation) {
        if (aMapLocation != null && this.f3283n.size() >= 1) {
            Iterator it = this.f3283n.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                PendingIntent pendingIntent = (PendingIntent) entry.getKey();
                List<C0568j> list = (List) entry.getValue();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                for (C0568j c0568j : list) {
                    long a = c0568j.m4529a();
                    if (a == -1 || a >= C0583t.m4572a()) {
                        float a2 = C0583t.m4569a(new double[]{c0568j.f3503b, c0568j.f3502a, aMapLocation.getLatitude(), aMapLocation.getLongitude()});
                        if (a2 >= c0568j.f3504c) {
                            if (c0568j.f3505d != 0) {
                                c0568j.f3505d = 0;
                            }
                        }
                        if (a2 < c0568j.f3504c) {
                            if (c0568j.f3505d != 1) {
                                c0568j.f3505d = 1;
                            }
                        }
                        bundle.putFloat("distance", a2);
                        bundle.putString("fence", c0568j.m4531b());
                        bundle.putInt("status", c0568j.f3505d);
                        intent.putExtras(bundle);
                        try {
                            pendingIntent.send(this.f3275f, 0, intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: r */
    private void m4280r() {
        switch (this.f3276g) {
            case 1:
                if (this.f3280k.size() == 0) {
                    this.f3276g = 9;
                    return;
                }
                return;
            case 2:
                if (this.f3280k.size() == 0) {
                    this.f3276g = 9;
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: s */
    private boolean m4281s() {
        boolean z = false;
        if (this.f3278i != null) {
            try {
                z = this.f3278i.isWifiEnabled();
            } catch (Exception e) {
            }
            if (!z && C0583t.m4581b() > 17) {
                try {
                    z = String.valueOf(C0574n.m4545a(this.f3278i, "isScanAlwaysAvailable", new Object[0])).equals("true");
                } catch (Exception e2) {
                }
            }
        }
        return z;
    }

    /* renamed from: t */
    private C0556c m4282t() throws Exception {
        byte[] j = m4272j();
        if (this.f3263F == null || !this.f3263F.toString().equals(this.f3290u) || this.f3291v == null) {
            return m4237a(j, false);
        }
        this.f3292w = C0583t.m4572a();
        return this.f3291v;
    }

    /* renamed from: u */
    private void m4283u() {
        if (this.f3293x) {
            this.f3276g = 9;
            this.f3280k.clear();
            return;
        }
        m4280r();
    }

    /* renamed from: a */
    public int m4287a(boolean z, int i) {
        if (z) {
            m4257c(i);
        } else {
            m4284v();
        }
        return m4300e() ? this.f3262E.m4642f() : -1;
    }

    /* renamed from: c */
    private void m4257c(final int i) {
        try {
            if (C0583t.m4572a() - this.f3264G >= 45000) {
                if (!m4300e() || this.f3262E.m4642f() >= 20) {
                    m4286x();
                    if (this.f3271b == null) {
                        this.f3271b = new TimerTask(this) {
                            /* renamed from: b */
                            final /* synthetic */ C0554a f3256b;

                            public void run() {
                                this.f3256b.m4261d(i);
                            }
                        };
                    }
                    if (this.f3272c == null) {
                        this.f3272c = new Timer(false);
                        this.f3272c.schedule(this.f3271b, 3000, 3000);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: v */
    private void m4284v() {
        if (this.f3272c != null) {
            this.f3272c.cancel();
            this.f3272c = null;
        }
        if (this.f3271b != null) {
            this.f3271b.cancel();
            this.f3271b = null;
        }
    }

    /* renamed from: w */
    private void m4285w() {
        if (m4300e()) {
            try {
                this.f3262E.m4636a(768);
            } catch (Throwable th) {
                th.printStackTrace();
                C0583t.m4574a(th);
            }
        }
    }

    /* renamed from: d */
    private void m4261d(int i) {
        int i2 = 70254591;
        if (m4300e()) {
            try {
                m4285w();
                switch (i) {
                    case 1:
                        i2 = 674234367;
                        break;
                    case 2:
                        if (!m4275m()) {
                            i2 = 674234367;
                            break;
                        } else {
                            i2 = 2083520511;
                            break;
                        }
                }
                this.f3262E.m4637a(null, m4239a(1, i2, 1));
                this.f3273d = this.f3262E.m4640d();
                if (this.f3273d != null) {
                    Object a = this.f3259B.m4541a(this.f3273d.m4306a(), this.f3275f);
                    if (m4300e()) {
                        if (TextUtils.isEmpty(a) || !a.equals("true")) {
                            this.f3274e++;
                            this.f3262E.m4637a(this.f3273d, m4239a(1, i2, 0));
                        } else {
                            this.f3262E.m4637a(this.f3273d, m4239a(1, i2, 1));
                        }
                    }
                }
                m4286x();
                if (m4300e() && this.f3262E.m4642f() == 0) {
                    m4284v();
                } else if (this.f3274e >= 3) {
                    m4284v();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0583t.m4574a(th);
            }
        }
    }

    /* renamed from: e */
    boolean m4300e() {
        if (this.f3262E == null) {
            return false;
        }
        return true;
    }

    /* renamed from: x */
    private void m4286x() {
        if (m4300e() && this.f3262E.m4642f() <= 0) {
            try {
                if (!this.f3262E.m4641e()) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private String m4239a(int i, int i2, int i3) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("e", i);
        jSONObject.put("d", i2);
        jSONObject.put("u", i3);
        return jSONObject.toString();
    }
}
