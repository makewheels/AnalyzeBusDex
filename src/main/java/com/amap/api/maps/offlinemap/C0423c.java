package com.amap.api.maps.offlinemap;

import com.amap.api.mapcore.C0344n;
import com.amap.api.mapcore.util.az;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: FileSplitterFetch */
/* renamed from: com.amap.api.maps.offlinemap.c */
class C0423c extends Thread {
    /* renamed from: a */
    String f2449a;
    /* renamed from: b */
    long f2450b;
    /* renamed from: c */
    long f2451c;
    /* renamed from: d */
    int f2452d;
    /* renamed from: e */
    boolean f2453e = false;
    /* renamed from: f */
    boolean f2454f = false;
    /* renamed from: g */
    C0422b f2455g = null;
    /* renamed from: h */
    HttpURLConnection f2456h;
    /* renamed from: i */
    InputStream f2457i;
    /* renamed from: j */
    private int f2458j = 0;

    public C0423c(String str, String str2, long j, long j2, int i) throws IOException {
        this.f2449a = str;
        this.f2450b = j;
        this.f2451c = j2;
        this.f2452d = i;
        this.f2455g = new C0422b(str2, this.f2450b);
    }

    public void run() {
        while (this.f2450b < this.f2451c && !this.f2454f) {
            try {
                if (isInterrupted()) {
                    if (this.f2457i != null) {
                        try {
                            this.f2457i.close();
                        } catch (Throwable e) {
                            az.m3143a(e, "FileSplitterFetch", "input.close()");
                        }
                        this.f2457i = null;
                    }
                    if (this.f2456h != null) {
                        this.f2456h.disconnect();
                        this.f2456h = null;
                    }
                    C0437p.m3753a(1000);
                    return;
                } else if (this.f2458j > 3) {
                    m3653b();
                    if (this.f2457i != null) {
                        try {
                            this.f2457i.close();
                        } catch (Throwable e2) {
                            az.m3143a(e2, "FileSplitterFetch", "input.close()");
                        }
                        this.f2457i = null;
                    }
                    if (this.f2456h != null) {
                        this.f2456h.disconnect();
                        this.f2456h = null;
                    }
                    C0437p.m3753a(1000);
                    return;
                } else {
                    this.f2456h = (HttpURLConnection) new URL(this.f2449a).openConnection();
                    this.f2456h.setRequestProperty("User-Agent", C0344n.f1880c);
                    this.f2456h.setRequestMethod("GET");
                    this.f2456h.setRequestProperty("Content-Type", "text/xml;");
                    String str = "bytes=" + this.f2450b + "-";
                    this.f2456h.setRequestProperty("RANGE", str);
                    C0437p.m3755a(str);
                    this.f2457i = this.f2456h.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = this.f2457i.read(bArr, 0, 1024);
                        if (read <= 0 || this.f2450b >= this.f2451c || this.f2454f) {
                            break;
                        }
                        this.f2450b += (long) this.f2455g.m3651a(bArr, 0, read);
                    }
                    C0437p.m3755a("Thread " + this.f2452d + " is over!");
                    this.f2453e = true;
                    if (this.f2457i != null) {
                        try {
                            this.f2457i.close();
                        } catch (Throwable e22) {
                            az.m3143a(e22, "FileSplitterFetch", "input.close()");
                        }
                        this.f2457i = null;
                    }
                    if (this.f2456h != null) {
                        this.f2456h.disconnect();
                        this.f2456h = null;
                    }
                    C0437p.m3753a(1000);
                }
            } catch (Throwable e222) {
                az.m3143a(e222, "FileSplitterFetch", "request");
                this.f2458j++;
                C0437p.m3760b("failuetimes:" + System.currentTimeMillis() + "\n");
                C0437p.m3760b(e222.getMessage() + "\n");
                C0437p.m3760b(C0437p.m3752a(e222) + "\n");
                if (this.f2457i != null) {
                    try {
                        this.f2457i.close();
                    } catch (Throwable e2222) {
                        az.m3143a(e2222, "FileSplitterFetch", "input.close()");
                    }
                    this.f2457i = null;
                }
                if (this.f2456h != null) {
                    this.f2456h.disconnect();
                    this.f2456h = null;
                }
                C0437p.m3753a(1000);
            } catch (Throwable th) {
                if (this.f2457i != null) {
                    try {
                        this.f2457i.close();
                    } catch (Throwable e3) {
                        az.m3143a(e3, "FileSplitterFetch", "input.close()");
                    }
                    this.f2457i = null;
                }
                if (this.f2456h != null) {
                    this.f2456h.disconnect();
                    this.f2456h = null;
                }
                C0437p.m3753a(1000);
            }
        }
    }

    /* renamed from: a */
    public synchronized int m3652a() {
        return this.f2458j;
    }

    /* renamed from: b */
    public void m3653b() {
        try {
            this.f2454f = true;
            interrupt();
        } catch (Throwable th) {
            Thread.interrupted();
            az.m3143a(th, "FileSplitterFetch", "splitterStop");
            th.printStackTrace();
        }
    }
}
