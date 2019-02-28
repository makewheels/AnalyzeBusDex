package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.C0277a.C0276a;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.C0282a;
import com.amap.api.location.core.C0284c;
import com.aps.C0553k;
import com.aps.C0554a;
import com.aps.C0555b;
import com.aps.C0556c;
import com.aps.C0568j;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: IAPSManager */
/* renamed from: com.amap.api.location.c */
public class C0281c implements Runnable {
    /* renamed from: a */
    C0553k f1278a = null;
    /* renamed from: b */
    boolean f1279b = true;
    /* renamed from: c */
    private boolean f1280c = true;
    /* renamed from: d */
    private Thread f1281d = null;
    /* renamed from: e */
    private Context f1282e;
    /* renamed from: f */
    private long f1283f = 2000;
    /* renamed from: g */
    private C0276a f1284g;
    /* renamed from: h */
    private C0277a f1285h;

    protected C0281c(Context context, C0276a c0276a, C0277a c0277a) {
        this.f1285h = c0277a;
        this.f1280c = true;
        this.f1282e = context;
        this.f1278a = new C0554a();
        C0284c.m1822a(context);
        this.f1278a.mo677a(context, c0277a.f1252a);
        this.f1278a.mo680a("api_serverSDK_130905##S128DF1572465B890OE3F7A13167KLEI##" + C0284c.m1826b(context) + "," + C0284c.m1825b());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", C0284c.m1826b(context));
            jSONObject.put("X-INFO", C0284c.m1822a(context).m1836a("loc"));
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ex", C0555b.m4413a(C0284c.m1822a(context).m1838c().getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            jSONObject.put("X-BIZ", jSONObject2);
            jSONObject.put("User-Agent", "AMAP Location SDK Android 1.3.0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f1278a.mo681a(jSONObject);
        this.f1284g = c0276a;
    }

    /* renamed from: a */
    void m1807a() {
        this.f1280c = false;
        if (this.f1281d != null) {
            this.f1281d.interrupt();
        }
        this.f1278a.mo682b();
        this.f1278a = null;
    }

    public void run() {
        Looper.prepare();
        this.f1281d = Thread.currentThread();
        while (this.f1280c && !Thread.currentThread().isInterrupted()) {
            this.f1281d = Thread.currentThread();
            Message message;
            try {
                if ((!this.f1285h.f1254c || m1806d()) && this.f1285h.f1256e) {
                    Object a;
                    C0556c b = m1804b();
                    if (b != null) {
                        a = m1801a(b);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        if (this.f1285h.f1256e && (!this.f1285h.f1254c || m1806d())) {
                            Message message2 = new Message();
                            message2.obj = a;
                            message2.what = 100;
                            this.f1284g.sendMessage(message2);
                        }
                    }
                    if (C0282a.m1814a() == -1) {
                        C0282a.m1816a(this.f1282e);
                    }
                    if (this.f1279b) {
                        Thread.sleep(this.f1283f);
                    } else {
                        Thread.sleep(30000);
                    }
                } else {
                    try {
                        this.f1279b = true;
                        Thread.sleep(this.f1283f);
                        if (null != null) {
                            if (this.f1285h.f1256e && (!this.f1285h.f1254c || m1806d())) {
                                message = new Message();
                                message.obj = null;
                                message.what = 100;
                                this.f1284g.sendMessage(message);
                            }
                        }
                        if (C0282a.m1814a() == -1) {
                            C0282a.m1816a(this.f1282e);
                        }
                        if (this.f1279b) {
                            Thread.sleep(this.f1283f);
                        } else {
                            Thread.sleep(30000);
                        }
                    } catch (Throwable th) {
                        if (null != null) {
                            if (this.f1285h.f1256e && (!this.f1285h.f1254c || m1806d())) {
                                message = new Message();
                                message.obj = null;
                                message.what = 100;
                                this.f1284g.sendMessage(message);
                            }
                        }
                        if (C0282a.m1814a() == -1) {
                            C0282a.m1816a(this.f1282e);
                        }
                        if (this.f1279b) {
                            Thread.sleep(this.f1283f);
                            return;
                        } else {
                            Thread.sleep(30000);
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                return;
            }
        }
    }

    /* renamed from: a */
    void m1808a(long j) {
        if (j > this.f1283f) {
            this.f1283f = j;
        }
    }

    /* renamed from: b */
    private C0556c m1804b() throws Exception {
        C0556c c = m1805c();
        if (c != null) {
            return c;
        }
        c = new C0556c();
        c.m4432a(new AMapLocException("未知的错误"));
        this.f1279b = false;
        return c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private com.aps.C0556c m1805c() {
        /*
        r4 = this;
        r2 = 0;
        r1 = 0;
        r0 = r4.f1278a;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
        if (r0 == 0) goto L_0x002f;
    L_0x0006:
        r0 = r4.f1278a;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
        r0 = r0.mo675a();	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x0023 }
    L_0x000c:
        if (r0 != 0) goto L_0x0012;
    L_0x000e:
        r1 = 0;
        r4.f1279b = r1;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x002d }
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = 1;
        r4.f1279b = r1;	 Catch:{ AMapLocException -> 0x0016, Throwable -> 0x002d }
        goto L_0x0011;
    L_0x0016:
        r0 = move-exception;
        r1 = r0;
        r0 = new com.aps.c;
        r0.<init>();
        r0.m4432a(r1);
        r4.f1279b = r2;
        goto L_0x0011;
    L_0x0023:
        r0 = move-exception;
        r3 = r0;
        r0 = r1;
        r1 = r3;
    L_0x0027:
        r4.f1279b = r2;
        r1.printStackTrace();
        goto L_0x0011;
    L_0x002d:
        r1 = move-exception;
        goto L_0x0027;
    L_0x002f:
        r0 = r1;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.c.c():com.aps.c");
    }

    /* renamed from: d */
    private boolean m1806d() {
        if (System.currentTimeMillis() - this.f1285h.f1255d <= 5 * this.f1283f) {
            return false;
        }
        this.f1285h.f1254c = false;
        return true;
    }

    /* renamed from: a */
    private AMapLocation m1801a(C0556c c0556c) {
        AMapLocation aMapLocation = new AMapLocation(bi_常量类.f6358b);
        aMapLocation.setProvider(LocationProviderProxy.AMapNetwork);
        aMapLocation.setLatitude(c0556c.m4442e());
        aMapLocation.setLongitude(c0556c.m4440d());
        aMapLocation.setAccuracy(c0556c.m4444f());
        aMapLocation.setTime(c0556c.m4446g());
        aMapLocation.setPoiId(c0556c.m4435b());
        aMapLocation.setFloor(c0556c.m4438c());
        aMapLocation.setAMapException(c0556c.m4428a());
        Bundle bundle = new Bundle();
        bundle.putString("citycode", c0556c.m4452j());
        bundle.putString("desc", c0556c.m4454k());
        bundle.putString("adcode", c0556c.m4456l());
        aMapLocation.setExtras(bundle);
        try {
            m1802a(aMapLocation, c0556c.m4452j(), c0556c.m4456l(), c0556c.m4454k());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aMapLocation;
    }

    /* renamed from: a */
    private void m1802a(AMapLocation aMapLocation, String str, String str2, String str3) {
        String[] split = str3.split(" ");
        aMapLocation.setCityCode(str);
        aMapLocation.setAdCode(str2);
        if (str.equals(bi_常量类.f6358b) || !m1803a(str)) {
            if (split.length > 3) {
                aMapLocation.setProvince(split[0]);
                aMapLocation.setCity(split[1]);
                aMapLocation.setDistrict(split[2]);
                aMapLocation.m1758a(split[3]);
            }
            if (split.length > 4) {
                aMapLocation.m1758a(split[3] + split[4]);
            }
        } else {
            if (split.length > 2) {
                aMapLocation.setCity(split[0]);
                aMapLocation.setDistrict(split[1]);
                aMapLocation.m1758a(split[2]);
            }
            if (split.length > 3) {
                aMapLocation.m1758a(split[2] + split[3]);
            }
        }
        aMapLocation.m1759b(str3.replace(" ", bi_常量类.f6358b));
    }

    /* renamed from: a */
    private boolean m1803a(String str) {
        if (str.endsWith("010") || str.endsWith("021") || str.endsWith("022") || str.endsWith("023")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    void m1810a(C0568j c0568j, PendingIntent pendingIntent) {
        this.f1278a.mo679a(c0568j, pendingIntent);
    }

    /* renamed from: b */
    void m1812b(C0568j c0568j, PendingIntent pendingIntent) {
        this.f1278a.mo684b(c0568j, pendingIntent);
    }

    /* renamed from: a */
    void m1809a(PendingIntent pendingIntent) {
        this.f1278a.mo676a(pendingIntent);
    }

    /* renamed from: b */
    void m1811b(PendingIntent pendingIntent) {
        this.f1278a.mo683b(pendingIntent);
    }
}
