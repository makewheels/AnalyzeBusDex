package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.C0408x;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.VTMCDataCache;
import java.io.File;
import java.io.IOException;

/* compiled from: SiteFileFetch */
/* renamed from: com.amap.api.maps.offlinemap.m */
class C0434m extends Thread {
    /* renamed from: a */
    C0435n f2486a = null;
    /* renamed from: b */
    long[] f2487b;
    /* renamed from: c */
    long[] f2488c;
    /* renamed from: d */
    C0423c[] f2489d;
    /* renamed from: e */
    long f2490e;
    /* renamed from: f */
    boolean f2491f = true;
    /* renamed from: g */
    boolean f2492g = false;
    /* renamed from: h */
    C0425d f2493h;
    /* renamed from: i */
    C0436o f2494i;
    /* renamed from: j */
    OfflineDBDao f2495j;
    /* renamed from: k */
    long f2496k = 0;
    /* renamed from: l */
    private Context f2497l;
    /* renamed from: m */
    private Handler f2498m;

    public C0434m(C0435n c0435n, C0425d c0425d, C0436o c0436o, Context context, Handler handler) throws IOException {
        this.f2495j = OfflineDBDao.getInstance(context.getApplicationContext());
        this.f2486a = c0435n;
        if (this.f2495j.m3602f(this.f2486a.m3719e())) {
            this.f2491f = false;
            m3712f();
        } else {
            this.f2487b = new long[c0435n.m3718d()];
            this.f2488c = new long[c0435n.m3718d()];
        }
        this.f2493h = c0425d;
        this.f2494i = c0436o;
        this.f2497l = context;
        this.f2498m = handler;
    }

    public void run() {
        try {
            if (C0405u.m3484c(this.f2497l)) {
                m3710d();
            }
            if (C0408x.f2198a == 1) {
                if (!m3709c()) {
                    this.f2491f = true;
                }
                if (this.f2491f) {
                    C0437p.m3755a(this.f2486a.m3715a());
                    this.f2490e = m3713a();
                    if (this.f2490e == -1) {
                        C0437p.m3755a("File Length is not known!");
                    } else if (this.f2490e == -2) {
                        C0437p.m3755a("File is not access!");
                    } else {
                        int i;
                        for (i = 0; i < this.f2487b.length; i++) {
                            this.f2487b[i] = ((long) i) * (this.f2490e / ((long) this.f2487b.length));
                        }
                        for (i = 0; i < this.f2488c.length - 1; i++) {
                            this.f2488c[i] = this.f2487b[i + 1];
                        }
                        this.f2488c[this.f2488c.length - 1] = this.f2490e;
                    }
                }
                this.f2489d = new C0423c[this.f2487b.length];
                for (int i2 = 0; i2 < this.f2487b.length; i2++) {
                    this.f2489d[i2] = new C0423c(this.f2486a.m3715a(), this.f2486a.m3716b() + File.separator + this.f2486a.m3717c(), this.f2487b[i2], this.f2488c[i2], i2);
                    C0437p.m3755a("Thread " + i2 + " , nStartPos = " + this.f2487b[i2] + ", nEndPos = " + this.f2488c[i2]);
                    this.f2489d[i2].start();
                }
                boolean z = false;
                do {
                    if (this.f2492g) {
                        break;
                    }
                    Object obj;
                    z = m3711e();
                    C0437p.m3753a((int) VTMCDataCache.MAXSIZE);
                    int i3 = 0;
                    while (i3 < this.f2487b.length) {
                        if (this.f2489d[i3].m3652a() > 3) {
                            this.f2492g = true;
                            this.f2493h.m3665a(this.f2494i, 101, this.f2494i.m3747n());
                            obj = 1;
                            break;
                        } else if (!this.f2489d[i3].f2453e) {
                            obj = null;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    i3 = 1;
                    if (!isInterrupted()) {
                        if (obj != null) {
                            break;
                        }
                    } else {
                        return;
                    }
                } while (!z);
                if (this.f2492g && !z) {
                    this.f2493h.m3665a(this.f2494i, 3, this.f2494i.m3747n());
                }
                if (!this.f2492g) {
                    this.f2493h.m3672c(this.f2494i);
                }
                if (z) {
                    this.f2492g = true;
                }
            }
        } catch (Throwable e) {
            az.m3143a(e, "SiteFileFetch", "download");
            m3707a(102);
        } catch (IOException e2) {
            m3707a(103);
        }
    }

    /* renamed from: a */
    private void m3707a(int i) {
        if (this.f2494i != null) {
            this.f2493h.m3665a(this.f2494i, i, this.f2494i.m3747n());
        }
    }

    /* renamed from: c */
    private boolean m3709c() {
        String str = this.f2486a.m3716b() + File.separator + this.f2486a.m3717c();
        if (new File(str).length() >= 10 || new File(str.substring(0, str.indexOf(".tmp"))).exists()) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private void m3710d() throws AMapException {
        if (C0408x.f2198a == -1) {
            int i = 0;
            while (i < 3) {
                try {
                    if (!C0408x.m3500a(this.f2497l, C0405u.m3486e())) {
                        i++;
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public long m3713a() {
        /*
        r5 = this;
        r1 = -1;
        r0 = new java.net.URL;	 Catch:{ Throwable -> 0x0046 }
        r2 = r5.f2486a;	 Catch:{ Throwable -> 0x0046 }
        r2 = r2.m3715a();	 Catch:{ Throwable -> 0x0046 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0046 }
        r0 = r0.openConnection();	 Catch:{ Throwable -> 0x0046 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Throwable -> 0x0046 }
        r2 = "User-Agent";
        r3 = com.amap.api.mapcore.C0344n.f1880c;	 Catch:{ Throwable -> 0x0046 }
        r0.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x0046 }
        r2 = r0.getResponseCode();	 Catch:{ Throwable -> 0x0046 }
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r2 < r3) goto L_0x0027;
    L_0x0021:
        r5.m3708b(r2);	 Catch:{ Throwable -> 0x0046 }
        r0 = -2;
    L_0x0026:
        return r0;
    L_0x0027:
        r2 = 1;
    L_0x0028:
        r3 = r0.getHeaderFieldKey(r2);	 Catch:{ Throwable -> 0x0046 }
        if (r3 == 0) goto L_0x0051;
    L_0x002e:
        r4 = "Content-Length";
        r4 = r3.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x0046 }
        if (r4 == 0) goto L_0x0043;
    L_0x0036:
        r0 = r0.getHeaderField(r3);	 Catch:{ Throwable -> 0x0046 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x0046 }
    L_0x003e:
        com.amap.api.maps.offlinemap.C0437p.m3758b(r0);
        r0 = (long) r0;
        goto L_0x0026;
    L_0x0043:
        r2 = r2 + 1;
        goto L_0x0028;
    L_0x0046:
        r0 = move-exception;
        r2 = "SiteFileFetch";
        r3 = "getFileSize";
        com.amap.api.mapcore.util.az.m3143a(r0, r2, r3);
        r0.printStackTrace();
    L_0x0051:
        r0 = r1;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.offlinemap.m.a():long");
    }

    /* renamed from: e */
    private boolean m3711e() {
        int i = 0;
        long j = 0;
        while (i < this.f2487b.length) {
            long j2;
            if (i == 0) {
                j2 = this.f2489d[i].f2450b + j;
            } else {
                j2 = (this.f2489d[i].f2450b - this.f2489d[i - 1].f2451c) + j;
            }
            this.f2487b[i] = this.f2489d[i].f2450b;
            this.f2488c[i] = this.f2489d[i].f2451c;
            i++;
            j = j2;
        }
        if (this.f2486a != null) {
            this.f2495j.m3594a(this.f2486a.m3719e(), this.f2486a.m3718d(), this.f2490e, this.f2487b, this.f2488c);
        }
        if (this.f2490e <= 0) {
            return false;
        }
        long j3 = (j * 100) / this.f2490e;
        this.f2494i.m3722a(j);
        this.f2494i.m3726b((int) j3);
        if (C0405u.m3484c(this.f2497l) && System.currentTimeMillis() - this.f2496k > 1000) {
            this.f2493h.m3665a(this.f2494i, 0, (int) j3);
            this.f2496k = System.currentTimeMillis();
        }
        if (j3 >= 100) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private boolean m3712f() {
        if (!this.f2495j.m3602f(this.f2486a.m3719e())) {
            return false;
        }
        this.f2490e = (long) this.f2495j.m3603g(this.f2486a.m3719e());
        int h = this.f2495j.m3604h(this.f2486a.m3719e());
        this.f2487b = new long[h];
        this.f2488c = new long[h];
        for (h = 0; h < this.f2487b.length; h++) {
            long[] a = this.f2495j.m3596a(this.f2486a.m3719e(), h);
            this.f2487b[h] = a[0];
            this.f2488c[h] = a[1];
        }
        return true;
    }

    /* renamed from: b */
    private void m3708b(int i) {
        System.err.println("Error Code : " + i);
    }

    /* renamed from: b */
    public void m3714b() {
        this.f2492g = true;
        int i = 0;
        while (i < this.f2487b.length) {
            if (!(this.f2489d == null || this.f2489d[i] == null)) {
                this.f2489d[i].m3653b();
            }
            i++;
        }
    }
}
