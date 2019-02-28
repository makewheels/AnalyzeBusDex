package com.amap.api.maps.offlinemap;

import android.content.Context;
import com.alipay.sdk.cons.C0108a;
import com.amap.api.mapcore.C0344n;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.C0407w;
import com.amap.api.mapcore.util.C0409y;
import com.amap.api.mapcore.util.ac;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.bt;
import com.amap.api.mapcore.util.bu;
import com.amap.api.maps.AMapException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import p054u.aly.bi_常量类;

/* compiled from: ProtocalHandler */
/* renamed from: com.amap.api.maps.offlinemap.k */
abstract class C0428k<T, V> extends bu {
    /* renamed from: a */
    protected T f2478a;
    /* renamed from: b */
    protected int f2479b = 1;
    /* renamed from: c */
    protected String f2480c = bi_常量类.f6358b_空串;
    /* renamed from: d */
    protected Context f2481d;
    /* renamed from: e */
    protected final int f2482e = 5000;
    /* renamed from: f */
    protected final int f2483f = 50000;
    /* renamed from: j */
    private int f2484j = 1;

    /* renamed from: b */
    protected abstract V mo623b(String str) throws AMapException;

    public C0428k(Context context, T t) {
        m3680a(context, t);
    }

    /* renamed from: a */
    private void m3680a(Context context, T t) {
        this.f2481d = context;
        this.f2478a = t;
    }

    /* renamed from: f */
    public V m3686f() throws AMapException {
        if (this.f2478a != null) {
            return m3681h();
        }
        return null;
    }

    /* renamed from: h */
    private V m3681h() throws AMapException {
        int i = 0;
        V v = null;
        while (i < this.f2479b) {
            try {
                bt a = bt.m3294a(false);
                m3048a(ac.m3018a(this.f2481d));
                v = mo624a(a.m3305b(this));
                i = this.f2479b;
            } catch (Throwable e) {
                az.m3143a(e, "ProtocalHandler", "getDataMayThrow AMapException");
                i++;
                if (i >= this.f2479b) {
                    throw new AMapException(e.getErrorMessage());
                }
            } catch (Throwable e2) {
                az.m3143a(e2, "ProtocalHandler", "getDataMayThrow AMapCoreException");
                i++;
                if (i < this.f2479b) {
                    try {
                        Thread.sleep((long) (this.f2484j * 1000));
                    } catch (InterruptedException e3) {
                        az.m3143a(e2, "ProtocalHandler", "getDataMayThrow InterruptedException");
                        throw new AMapException(e2.getMessage());
                    }
                }
                m3687g();
                throw new AMapException(e2.m3488a());
            }
        }
        return v;
    }

    /* renamed from: b */
    protected V mo625b(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Throwable e) {
            az.m3143a(e, "ProtocalHandler", "loadData Exception");
            str = null;
        }
        if (str == null || str.equals(bi_常量类.f6358b_空串)) {
            return null;
        }
        C0405u.m3464a(str);
        return mo623b(str);
    }

    /* renamed from: e */
    public HttpEntity mo588e() {
        return null;
    }

    /* renamed from: b */
    public Map<String, String> mo585b() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", C0344n.f1880c);
        hashMap.put("X-INFO", C0409y.m3505a(this.f2481d, C0405u.m3486e(), null));
        hashMap.put("ia", C0108a.f262e);
        hashMap.put("ec", C0108a.f262e);
        hashMap.put("key", C0407w.m3495f(this.f2481d));
        return hashMap;
    }

    /* renamed from: a */
    private V mo624a(byte[] bArr) throws AMapException {
        return mo625b(bArr);
    }

    /* renamed from: g */
    protected V m3687g() {
        return null;
    }
}
