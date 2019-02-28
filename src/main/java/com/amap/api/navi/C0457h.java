package com.amap.api.navi;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.navi.model.AMapNaviCamera;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviLink;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.amap.api.navi.model.C0459a;
import com.amap.api.navi.model.C0462d;
import com.amap.api.navi.model.C0463e;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.C0610b;
import com.autonavi.tbt.C0615f;
import com.autonavi.tbt.C0618h;
import com.autonavi.tbt.C0620j;
import com.autonavi.tbt.C0621k;
import com.autonavi.tbt.C0629p;
import com.autonavi.tbt.C0629p.C0628a;
import com.autonavi.tbt.C0630q;
import com.autonavi.tbt.FrameForTBT;
import com.autonavi.tbt.NaviGuideItem;
import com.autonavi.tbt.TBT;
import com.autonavi.tbt.TmcBarItem;
import com.autonavi.tbt.az;
import com.autonavi.wtbt.FrameForWTBT;
import com.autonavi.wtbt.WTBT;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import p054u.aly.bi_常量类;

/* compiled from: TBTControl */
/* renamed from: com.amap.api.navi.h */
public class C0457h {
    /* renamed from: h */
    private static C0457h f2745h;
    /* renamed from: a */
    public TBT f2746a;
    /* renamed from: b */
    public WTBT f2747b;
    /* renamed from: c */
    public az f2748c;
    /* renamed from: d */
    public C0462d f2749d;
    /* renamed from: e */
    public int f2750e = -1;
    /* renamed from: f */
    List<AMapTrafficStatus> f2751f = new ArrayList();
    /* renamed from: g */
    private Context f2752g;
    /* renamed from: i */
    private FrameForTBT f2753i;
    /* renamed from: j */
    private FrameForWTBT f2754j;
    /* renamed from: k */
    private boolean f2755k = false;
    /* renamed from: l */
    private C0451c f2756l;
    /* renamed from: m */
    private int f2757m = 0;
    /* renamed from: n */
    private C0458i f2758n;
    /* renamed from: o */
    private Thread f2759o;
    /* renamed from: p */
    private C0456a f2760p;
    /* renamed from: q */
    private NaviLatLng f2761q;
    /* renamed from: r */
    private List<NaviLatLng> f2762r;
    /* renamed from: s */
    private double f2763s = 0.0d;
    /* renamed from: t */
    private double f2764t = 0.0d;
    /* renamed from: u */
    private List<AMapNaviGuide> f2765u = new ArrayList();
    /* renamed from: v */
    private List<AMapNaviCamera> f2766v = new ArrayList();
    /* renamed from: w */
    private boolean f2767w = false;
    /* renamed from: x */
    private Method f2768x;

    /* compiled from: TBTControl */
    /* renamed from: com.amap.api.navi.h$1 */
    class C04551 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C0457h f2743a;

        C04551(C0457h c0457h) {
            this.f2743a = c0457h;
        }

        public void run() {
            C0620j.m4871a("http://apiinit.amap.com/v3/log/init");
            C0629p c0629p = null;
            try {
                c0629p = new C0628a("navi", "1.3.0", "AMAP_SDK_Android_NAVI_1.3.0").m4936a(C0615f.m4836a()).m4937a();
            } catch (C0618h e) {
                e.printStackTrace();
            }
            C0620j.m4872a(this.f2743a.f2752g, c0629p);
            if (C0620j.f3818a == 0) {
                Message obtain = Message.obtain();
                obtain.obj = C0620j.f3819b;
                this.f2743a.f2760p.sendMessage(obtain);
            }
        }
    }

    /* compiled from: TBTControl */
    /* renamed from: com.amap.api.navi.h$a */
    static class C0456a extends Handler {
        /* renamed from: a */
        Context f2744a = null;

        public C0456a(Context context, Looper looper) {
            super(looper);
            this.f2744a = context;
            try {
                Looper.prepare();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public C0456a(Context context) {
            this.f2744a = context;
        }

        public void handleMessage(Message message) {
            try {
                Toast.makeText(this.f2744a, (String) message.obj, 0).show();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private C0457h(Context context) {
        this.f2752g = context;
        this.f2746a = new TBT();
        this.f2747b = new WTBT();
        this.f2753i = new FrameForTBT(this.f2752g, this);
        this.f2754j = new FrameForWTBT(this.f2752g, this);
        this.f2756l = C0451c.m3822a(this.f2752g, this);
        if (Looper.myLooper() == null) {
            this.f2760p = new C0456a(this.f2752g, this.f2752g.getMainLooper());
        } else {
            this.f2760p = new C0456a(this.f2752g);
        }
    }

    /* renamed from: a */
    int m3879a() {
        return this.f2757m;
    }

    /* renamed from: r */
    private String m3874r() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public void m3893b() {
        /*
        r6 = this;
        r6.m3875s();
        r0 = r6.f2752g;
        com.autonavi.tbt.C0617g.m4849a(r0);
        r0 = r6.f2755k;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r6.f2752g;
        if (r0 == 0) goto L_0x000c;
    L_0x0011:
        r0 = r6.f2746a;
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = new com.autonavi.tbt.TBT;
        r0.<init>();
        r6.f2746a = r0;
    L_0x001c:
        r0 = r6.f2747b;
        if (r0 != 0) goto L_0x0027;
    L_0x0020:
        r0 = new com.autonavi.wtbt.WTBT;
        r0.<init>();
        r6.f2747b = r0;
    L_0x0027:
        r0 = r6.f2753i;
        if (r0 != 0) goto L_0x0034;
    L_0x002b:
        r0 = new com.autonavi.tbt.FrameForTBT;
        r1 = r6.f2752g;
        r0.<init>(r1, r6);
        r6.f2753i = r0;
    L_0x0034:
        r0 = r6.f2753i;
        if (r0 != 0) goto L_0x0041;
    L_0x0038:
        r0 = new com.autonavi.wtbt.FrameForWTBT;
        r1 = r6.f2752g;
        r0.<init>(r1, r6);
        r6.f2754j = r0;
    L_0x0041:
        r5 = "";
        r0 = r6.f2746a;
        r6.f2758n = r0;
        r0 = r6.f2752g;	 Catch:{ Exception -> 0x00de }
        r1 = "phone";
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x00de }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x0057;
    L_0x0053:
        r5 = r0.getSimSerialNumber();	 Catch:{ Exception -> 0x00de }
    L_0x0057:
        if (r5 == 0) goto L_0x0061;
    L_0x0059:
        r1 = "";
        r1 = r1.equals(r5);	 Catch:{ Exception -> 0x00de }
        if (r1 == 0) goto L_0x0065;
    L_0x0061:
        r5 = r0.getDeviceId();	 Catch:{ Exception -> 0x00de }
    L_0x0065:
        if (r5 == 0) goto L_0x006f;
    L_0x0067:
        r0 = "";
        r0 = r0.equals(r5);	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x0075;
    L_0x006f:
        r0 = r6.f2752g;	 Catch:{ Exception -> 0x00de }
        r5 = r6.m3892b(r0);	 Catch:{ Exception -> 0x00de }
    L_0x0075:
        if (r5 == 0) goto L_0x007f;
    L_0x0077:
        r0 = "";
        r0 = r0.equals(r5);	 Catch:{ Exception -> 0x00de }
        if (r0 == 0) goto L_0x0088;
    L_0x007f:
        r5 = r6.m3874r();	 Catch:{ Exception -> 0x00de }
        r0 = r6.f2752g;	 Catch:{ Exception -> 0x00de }
        r6.m3884a(r0, r5);	 Catch:{ Exception -> 0x00de }
    L_0x0088:
        r0 = r5;
        if (r0 == 0) goto L_0x0093;
    L_0x008b:
        r1 = "";
        r1 = r1.equals(r0);	 Catch:{ Exception -> 0x0155 }
        if (r1 == 0) goto L_0x0095;
    L_0x0093:
        r0 = "000000000000000";
    L_0x0095:
        r5 = r0;
    L_0x0096:
        r0 = r6.f2747b;
        r1 = r6.f2754j;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = android.os.Environment.getExternalStorageDirectory();
        r3 = r3.getPath();
        r2 = r2.append(r3);
        r3 = "/navigation";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = "AN_AmapSdk_ADR_FC";
        r4 = "0";
        r0 = r0.init(r1, r2, r3, r4, r5);
        r1 = r6.f2747b;
        r2 = "userid";
        r3 = "AN_AmapSdk_ADR_FC";
        r1 = r1.setParam(r2, r3);
        r2 = r6.f2747b;
        r3 = "userpwd";
        r4 = "amapsdk";
        r2 = r2.setParam(r3, r4);
        if (r0 == 0) goto L_0x00d7;
    L_0x00d3:
        if (r1 == 0) goto L_0x00d7;
    L_0x00d5:
        if (r2 != 0) goto L_0x00f6;
    L_0x00d7:
        r0 = r6.f2753i;
        r0.initFailure();
        goto L_0x000c;
    L_0x00de:
        r0 = move-exception;
    L_0x00df:
        r0.printStackTrace();
        if (r5 == 0) goto L_0x00ec;
    L_0x00e4:
        r0 = "";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0096;
    L_0x00ec:
        r5 = r6.m3874r();
        r0 = r6.f2752g;
        r6.m3884a(r0, r5);
        goto L_0x0096;
    L_0x00f6:
        r0 = r6.f2746a;
        r1 = r6.f2753i;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = android.os.Environment.getExternalStorageDirectory();
        r3 = r3.getPath();
        r2 = r2.append(r3);
        r3 = "/navigation";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = "AN_AmapSdk_ADR_FC";
        r4 = "0";
        r0 = r0.init(r1, r2, r3, r4, r5);
        r1 = r6.f2746a;
        r2 = "userid";
        r3 = "AN_AmapSdk_ADR_FC";
        r1 = r1.setParam(r2, r3);
        r2 = r6.f2746a;
        r3 = "userpwd";
        r4 = "amapsdk";
        r2 = r2.setParam(r3, r4);
        if (r0 == 0) goto L_0x0137;
    L_0x0133:
        if (r1 == 0) goto L_0x0137;
    L_0x0135:
        if (r2 != 0) goto L_0x013e;
    L_0x0137:
        r0 = r6.f2753i;
        r0.initFailure();
        goto L_0x000c;
    L_0x013e:
        r0 = r6.f2753i;
        r0.initSuccess();
        r6.m3876t();
        r0 = 2;
        r0 = com.autonavi.tbt.az.m4801a(r0);
        r6.f2748c = r0;
        r0 = 1;
        r6.f2755k = r0;
        r6.m3917n();
        goto L_0x000c;
    L_0x0155:
        r1 = move-exception;
        r5 = r0;
        r0 = r1;
        goto L_0x00df;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.h.b():void");
    }

    /* renamed from: s */
    private void m3875s() {
        try {
            this.f2759o = new C04551(this);
            this.f2759o.setName("AuthThread");
            this.f2759o.start();
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    /* renamed from: t */
    private void m3876t() {
        if (this.f2746a != null) {
            this.f2746a.closeTrafficPanel();
            this.f2746a.openTrafficRadio();
            this.f2746a.openTMC();
            this.f2746a.openCamera();
            this.f2746a.setCrossDisplayMode(0);
            this.f2746a.setTMCRerouteStrategy(0);
        }
    }

    /* renamed from: c */
    public void m3897c() {
        if (((LocationManager) this.f2752g.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED)).isProviderEnabled("gps")) {
            this.f2753i.onGpsOpenStatus(true);
        } else {
            this.f2753i.onGpsOpenStatus(false);
        }
    }

    /* renamed from: a */
    public static synchronized C0457h m3870a(Context context) {
        C0457h c0457h;
        synchronized (C0457h.class) {
            if (f2745h == null) {
                f2745h = new C0457h(context);
            }
            c0457h = f2745h;
        }
        return c0457h;
    }

    /* renamed from: d */
    public synchronized void m3900d() {
        if (this.f2746a != null) {
            this.f2746a.destroy();
        }
        if (this.f2747b != null) {
            this.f2747b.destroy();
        }
        if (this.f2748c != null) {
            az.m4802a();
        }
        if (this.f2756l != null) {
            this.f2756l.m3840a();
        }
        this.f2759o = null;
        this.f2752g = null;
        C0457h.m3877u();
        this.f2753i.destroy();
        this.f2754j.destroy();
        this.f2753i = null;
        this.f2754j = null;
        this.f2746a = null;
        this.f2747b = null;
    }

    /* renamed from: u */
    private static void m3877u() {
        f2745h = null;
    }

    /* renamed from: a */
    public boolean m3887a(int i) {
        if (this.f2758n == null) {
            return false;
        }
        if (i == 1) {
            C0615f.m4835a("startNavi");
            m3917n();
            if (this.f2758n.startGPSNavi() != 1) {
                return false;
            }
            if (this.f2753i != null) {
                this.f2753i.onStartNavi(i);
            }
        }
        if (i == 2) {
            if (this.f2758n.startEmulatorNavi() != 1) {
                return false;
            }
            if (this.f2753i != null) {
                this.f2753i.onStartNavi(i);
            }
        }
        this.f2750e = i;
        return true;
    }

    /* renamed from: e */
    int m3903e() {
        return this.f2750e;
    }

    /* renamed from: f */
    public void m3907f() {
        if (this.f2758n != null) {
            this.f2758n.pauseNavi();
        }
    }

    /* renamed from: g */
    public void m3909g() {
        if (this.f2758n != null) {
            this.f2758n.stopNavi();
            m3918o();
        }
    }

    /* renamed from: h */
    public void m3910h() {
        if (this.f2758n != null) {
            this.f2758n.resumeNavi();
        }
    }

    /* renamed from: i */
    public void m3912i() {
        if (this.f2758n != null) {
            this.f2758n.manualRefreshTMC();
        }
    }

    /* renamed from: j */
    public boolean m3913j() {
        if (this.f2758n == null) {
            return false;
        }
        if (this.f2758n.playNaviManual() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m3896b(int i) {
        if (this.f2758n == null) {
            return false;
        }
        if (this.f2758n.playTrafficRadioManual(i) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3891a(List<NaviLatLng> list, List<NaviLatLng> list2, List<NaviLatLng> list3, int i) {
        this.f2762r = list3;
        m3872a("cr");
        if (this.f2746a == null || list == null || list2 == null || list2.size() <= 0) {
            return false;
        }
        this.f2757m = 0;
        int size = list.size();
        int size2 = list2.size();
        int i2 = 0;
        if (list3 != null) {
            i2 = list3.size();
        }
        double[] dArr = new double[(size << 1)];
        double[] dArr2 = new double[(size2 << 1)];
        double[] dArr3 = null;
        if (i2 != 0) {
            dArr3 = new double[(i2 << 1)];
        }
        int i3 = 0;
        for (NaviLatLng naviLatLng : list) {
            if (naviLatLng == null) {
                return false;
            }
            dArr[i3 << 1] = naviLatLng.getLongitude();
            dArr[(i3 << 1) + 1] = naviLatLng.getLatitude();
            i3++;
        }
        i3 = 0;
        for (NaviLatLng naviLatLng2 : list2) {
            if (i3 == 0) {
                this.f2761q = naviLatLng2;
            }
            if (naviLatLng2 == null) {
                return false;
            }
            dArr2[i3 << 1] = naviLatLng2.getLongitude();
            dArr2[(i3 << 1) + 1] = naviLatLng2.getLatitude();
            i3++;
        }
        if (i2 != 0) {
            i3 = 0;
            for (NaviLatLng naviLatLng22 : list3) {
                if (naviLatLng22 == null) {
                    return false;
                }
                dArr3[i3 << 1] = naviLatLng22.getLongitude();
                dArr3[(i3 << 1) + 1] = naviLatLng22.getLatitude();
                i3++;
            }
        }
        this.f2758n = this.f2746a;
        return this.f2746a.requestRouteWithStart(i, 0, size, dArr, size2, dArr2, i2, dArr3) == 1;
    }

    /* renamed from: a */
    public boolean m3890a(List<NaviLatLng> list, List<NaviLatLng> list2, int i) {
        this.f2762r = list2;
        m3872a("cr");
        if (this.f2746a == null || list == null || !this.f2767w) {
            return false;
        }
        int size;
        this.f2757m = 0;
        int size2 = list.size();
        if (list2 != null) {
            size = list2.size();
        } else {
            size = 0;
        }
        double[] dArr = null;
        if (size != 0) {
            dArr = new double[(size << 1)];
        }
        double[] dArr2 = new double[(size2 << 1)];
        int i2 = 0;
        for (NaviLatLng naviLatLng : list) {
            if (i2 == 0) {
                this.f2761q = naviLatLng;
            }
            if (naviLatLng == null) {
                return false;
            }
            dArr2[i2 << 1] = naviLatLng.getLongitude();
            dArr2[(i2 << 1) + 1] = naviLatLng.getLatitude();
            i2++;
        }
        if (size != 0) {
            i2 = 0;
            for (NaviLatLng naviLatLng2 : list2) {
                if (naviLatLng2 == null) {
                    return false;
                }
                dArr[i2 << 1] = naviLatLng2.getLongitude();
                dArr[(i2 << 1) + 1] = naviLatLng2.getLatitude();
                i2++;
            }
        }
        this.f2758n = this.f2746a;
        if (this.f2746a.requestRoute(i, 0, size2, dArr2, size, dArr) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m3881a(int i, double d, double d2) {
        this.f2763s = d;
        this.f2764t = d2;
        if (this.f2746a != null) {
            this.f2746a.setCarLocation(i, d, d2);
        }
        if (this.f2747b != null) {
            this.f2747b.setCarLocation(i, d, d2);
        }
    }

    /* renamed from: c */
    public boolean m3899c(int i) {
        if (this.f2758n == null) {
            return false;
        }
        if (this.f2758n.reroute(i, 0) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m3889a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        boolean z = true;
        if (this.f2747b == null || naviLatLng == null || naviLatLng2 == null || C0615f.m4826a(naviLatLng, naviLatLng2) > 100000) {
            return false;
        }
        this.f2757m = 1;
        this.f2758n = this.f2747b;
        r4 = new double[2];
        double[] dArr = new double[]{naviLatLng.getLongitude(), naviLatLng.getLatitude()};
        dArr[0] = naviLatLng2.getLongitude();
        dArr[1] = naviLatLng2.getLatitude();
        this.f2761q = naviLatLng2;
        if (this.f2747b.requestRouteWithStart(0, 0, 1, r4, 1, dArr, 0, null) != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public boolean m3888a(NaviLatLng naviLatLng) {
        boolean z = true;
        this.f2757m = 1;
        this.f2758n = this.f2747b;
        if (naviLatLng == null) {
            return false;
        }
        if (this.f2763s != 0.0d && this.f2764t != 0.0d && C0615f.m4826a(new NaviLatLng(this.f2764t, this.f2763s), naviLatLng) > 100000) {
            return false;
        }
        double[] dArr = new double[]{naviLatLng.getLongitude(), naviLatLng.getLatitude()};
        this.f2761q = naviLatLng;
        if (this.f2747b.requestRoute(0, 0, 1, dArr, 0, null) != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public List<AMapTrafficStatus> m3880a(int i, int i2) {
        if (this.f2757m == 0 && this.f2746a != null) {
            TmcBarItem[] createTmcBar = this.f2746a.createTmcBar(i, i2);
            if (createTmcBar != null && createTmcBar.length > 0) {
                this.f2751f.clear();
                for (TmcBarItem c0463e : createTmcBar) {
                    this.f2751f.add(new C0463e(c0463e).f2792a);
                }
                return this.f2751f;
            }
        }
        return null;
    }

    /* renamed from: k */
    public AMapNaviPath m3914k() {
        if (this.f2749d != null) {
            return this.f2749d.f2777a;
        }
        return null;
    }

    /* renamed from: l */
    public List<AMapNaviGuide> m3915l() {
        int i = 0;
        if (this.f2757m == 0 && this.f2746a != null) {
            NaviGuideItem[] naviGuideList = this.f2746a.getNaviGuideList();
            if (naviGuideList != null && naviGuideList.length > 0) {
                this.f2765u.clear();
                while (i < naviGuideList.length) {
                    this.f2765u.add(new C0459a(naviGuideList[i]).f2769a);
                    i++;
                }
                return this.f2765u;
            }
        }
        if (this.f2757m == 1 && this.f2747b != null) {
            com.autonavi.wtbt.NaviGuideItem[] naviGuideList2 = this.f2747b.getNaviGuideList();
            if (naviGuideList2 != null && naviGuideList2.length > 0) {
                this.f2765u.clear();
                while (i < naviGuideList2.length) {
                    this.f2765u.add(new C0459a(naviGuideList2[i]).f2769a);
                    i++;
                }
                return this.f2765u;
            }
        }
        return null;
    }

    /* renamed from: m */
    public TBT m3916m() {
        if (this.f2746a == null) {
            this.f2746a = new TBT();
        }
        return this.f2746a;
    }

    /* renamed from: d */
    public void m3901d(int i) {
        if (this.f2758n != null) {
            this.f2758n.setEmulatorSpeed(i);
        }
    }

    /* renamed from: e */
    public void m3904e(int i) {
        if (this.f2746a != null) {
            this.f2746a.setTimeForOneWord(i);
        }
        if (this.f2747b != null) {
            this.f2747b.setTimeForOneWord(i);
        }
    }

    /* renamed from: a */
    public void m3885a(AMapNaviListener aMapNaviListener) {
        if (this.f2753i != null) {
            this.f2753i.setAMapNaviListener(aMapNaviListener);
        }
        if (this.f2754j != null) {
            this.f2754j.setAMapNaviListener(aMapNaviListener);
        }
    }

    /* renamed from: b */
    public void m3894b(AMapNaviListener aMapNaviListener) {
        if (this.f2753i != null) {
            this.f2753i.removeNaviListener(aMapNaviListener);
        }
        if (this.f2754j != null) {
            this.f2754j.removeNaviListener(aMapNaviListener);
        }
    }

    /* renamed from: n */
    public void m3917n() {
        if (this.f2756l != null) {
            this.f2756l.m3843c();
        }
    }

    /* renamed from: a */
    public void m3883a(long j, int i) {
        if (this.f2756l != null) {
            this.f2756l.m3841a(j, i);
        }
    }

    /* renamed from: o */
    public void m3918o() {
        if (this.f2756l != null) {
            this.f2756l.m3844d();
        }
    }

    /* renamed from: f */
    public int m3906f(int i) {
        if (this.f2758n == null) {
            return -1;
        }
        int selectRoute = this.f2758n.selectRoute(i);
        if (selectRoute == -1) {
            return selectRoute;
        }
        m3878v();
        return selectRoute;
    }

    /* renamed from: v */
    private void m3878v() {
        this.f2749d = new C0462d();
        this.f2749d.m3930a(this.f2758n.getRouteLength());
        this.f2749d.m3938c(this.f2758n.getRouteTime());
        this.f2749d.m3941d(this.f2758n.getSegNum());
        if (this.f2758n.getRouteStrategy() == 5) {
            this.f2749d.m3935b(3);
        } else {
            this.f2749d.m3935b(this.f2758n.getRouteStrategy());
        }
        int segNum = this.f2758n.getSegNum();
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int i = -1;
        double d = Double.MIN_VALUE;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MIN_VALUE;
        double d4 = Double.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        while (i2 < segNum) {
            AMapNaviStep aMapNaviStep = new AMapNaviStep();
            aMapNaviStep.setChargelength(this.f2758n.getSegChargeLength(i2));
            int segTollCost = i3 + this.f2758n.getSegTollCost(i2);
            aMapNaviStep.setTime(this.f2758n.getSegTime(i2));
            double[] segCoor = this.f2758n.getSegCoor(i2);
            List arrayList3 = new ArrayList();
            if (segCoor != null) {
                for (i3 = 0; i3 < segCoor.length - 1; i3 += 2) {
                    arrayList3.add(new NaviLatLng(segCoor[i3 + 1], segCoor[i3]));
                }
            }
            aMapNaviStep.setCoords(arrayList3);
            aMapNaviStep.setLength(this.f2758n.getSegLength(i2));
            List arrayList4 = new ArrayList();
            int segLinkNum = this.f2758n.getSegLinkNum(i2);
            aMapNaviStep.setStartIndex(i + 1);
            for (int i4 = 0; i4 < segLinkNum; i4++) {
                AMapNaviLink aMapNaviLink = new AMapNaviLink();
                aMapNaviLink.setLength(this.f2758n.getLinkLength(i2, i4));
                aMapNaviLink.setTime(this.f2758n.getLinkTime(i2, i4));
                aMapNaviLink.setRoadClass(this.f2758n.getLinkRoadClass(i2, i4));
                aMapNaviLink.setRoadName(this.f2758n.getLinkRoadName(i2, i4));
                aMapNaviLink.setTrafficLights(this.f2758n.haveTrafficLights(i2, i4) == 1);
                double[] linkCoor = this.f2758n.getLinkCoor(i2, i4);
                List arrayList5 = new ArrayList();
                for (i3 = 0; i3 < linkCoor.length - 1; i3 += 2) {
                    double d5 = linkCoor[i3 + 1];
                    double d6 = linkCoor[i3];
                    if (d < d5) {
                        d = d5;
                    }
                    if (d3 < d6) {
                        d3 = d6;
                    }
                    if (d2 > d5) {
                        d2 = d5;
                    }
                    if (d4 > d6) {
                        d4 = d6;
                    }
                    NaviLatLng naviLatLng = new NaviLatLng(d5, d6);
                    arrayList5.add(naviLatLng);
                    arrayList2.add(naviLatLng);
                    i++;
                }
                aMapNaviLink.setCoords(arrayList5);
                arrayList4.add(aMapNaviLink);
            }
            aMapNaviStep.setEndIndex(i);
            aMapNaviStep.setLink(arrayList4);
            arrayList.add(aMapNaviStep);
            i2++;
            i3 = segTollCost;
        }
        this.f2749d.m3929a().setLatitude(d);
        this.f2749d.m3929a().setLongitude(d3);
        this.f2749d.m3934b().setLatitude(d2);
        this.f2749d.m3934b().setLongitude(d4);
        this.f2749d.m3942e(i3);
        this.f2749d.m3937b((List) arrayList);
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.f2749d.m3932a((NaviLatLng) arrayList2.get(0));
        }
        this.f2749d.m3940c(arrayList2);
        NaviLatLng a = C0615f.m4827a(this.f2749d.m3934b().getLatitude(), this.f2749d.m3934b().getLongitude(), this.f2749d.m3929a().getLatitude(), this.f2749d.m3929a().getLongitude());
        try {
            this.f2749d.m3931a(new LatLngBounds(new LatLng(this.f2749d.m3934b().getLatitude(), this.f2749d.m3934b().getLongitude()), new LatLng(this.f2749d.m3929a().getLatitude(), this.f2749d.m3929a().getLongitude())));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f2749d.m3939c(a);
        this.f2749d.m3936b(this.f2761q);
        this.f2749d.m3933a(this.f2762r);
    }

    /* renamed from: a */
    public void m3882a(int i, Location location) {
        this.f2767w = true;
        Calendar instance = Calendar.getInstance(Locale.CHINA);
        instance.setTimeInMillis(location.getTime());
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(5);
        int i5 = instance.get(11);
        int i6 = instance.get(12);
        int i7 = instance.get(13);
        if (this.f2757m == 0) {
            this.f2746a.setGPSInfo(i, location.getLongitude(), location.getLatitude(), ((double) location.getSpeed()) * 3.6d, (double) location.getBearing(), i2, i3, i4, i5, i6, i7, 1, (double) location.getAccuracy());
        }
        if (this.f2757m == 1 && this.f2750e == 1) {
            this.f2747b.setGPSInfo(i, (int) location.getAccuracy(), 0.0d, location.getLongitude(), location.getLatitude(), ((double) location.getSpeed()) * 3.6d, (double) location.getBearing(), i2, i3, i4, i5, i6, i7);
        }
    }

    /* renamed from: a */
    void m3886a(boolean z) {
        if (this.f2753i != null) {
            this.f2753i.setReCalculateRouteForYaw(z);
        }
        if (this.f2754j != null) {
            this.f2754j.setReCalculateRouteForYaw(z);
        }
    }

    /* renamed from: b */
    void m3895b(boolean z) {
        if (this.f2753i != null) {
            this.f2753i.setReCalculateRouteForTrafficJam(z);
        }
    }

    /* renamed from: p */
    public void m3919p() {
        this.f2749d = null;
    }

    /* renamed from: c */
    public void m3898c(boolean z) {
        if (this.f2746a == null) {
            return;
        }
        if (z) {
            this.f2746a.openTMC();
        } else {
            this.f2746a.closeTMC();
        }
    }

    /* renamed from: d */
    public void m3902d(boolean z) {
        if (this.f2746a == null) {
            return;
        }
        if (z) {
            this.f2746a.openTrafficRadio();
        } else {
            this.f2746a.closeTrafficRadio();
        }
    }

    /* renamed from: e */
    public void m3905e(boolean z) {
        if (this.f2746a == null) {
            return;
        }
        if (z) {
            this.f2746a.openCamera();
        } else {
            this.f2746a.closeCamera();
        }
    }

    /* renamed from: a */
    private void m3872a(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String a = C0630q.m4944a("resType=json&encode=UTF-8");
            stringBuffer.append(a);
            String a2 = C0621k.m4874a();
            stringBuffer.append("&ts=" + a2);
            stringBuffer.append("&scode=" + C0621k.m4877a(this.f2752g, a2, a));
            byte[] bytes = stringBuffer.toString().getBytes("UTF-8");
            this.f2748c = az.m4801a(2);
            this.f2748c.m4808a(new C0610b(this, this.f2752g, "http://apiinit.amap.com/v3/log/init", 0, str, 21, 0, bytes, bytes.length));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: g */
    public int m3908g(int i) {
        return this.f2746a.switchNaviRoute(i);
    }

    /* renamed from: b */
    String m3892b(Context context) {
        try {
            return context.getSharedPreferences("navigation_uid", 0).getString("uid", bi_常量类.f6358b_空串);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    void m3884a(Context context, String str) {
        try {
            Editor edit = context.getSharedPreferences("navigation_uid", 0).edit();
            edit.putString("uid", str);
            m3871a(edit);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m3871a(Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                try {
                    if (this.f2768x == null) {
                        this.f2768x = Editor.class.getDeclaredMethod("apply", new Class[0]);
                    }
                    this.f2768x.invoke(editor, new Object[0]);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    editor.commit();
                    return;
                }
            }
            editor.commit();
        }
    }

    /* renamed from: q */
    NaviInfo m3920q() {
        return this.f2753i.getNaviInfo();
    }

    /* renamed from: h */
    public void m3911h(int i) {
        this.f2757m = 0;
        this.f2758n = this.f2746a;
        if (this.f2746a != null) {
            this.f2746a.setDetectedMode(i);
        }
        m3917n();
    }
}
