package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import com.alipay.sdk.cons.C0108a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: AuthManager */
/* renamed from: com.amap.api.mapcore.util.x */
public class C0408x {
    /* renamed from: a */
    public static int f2198a = -1;
    /* renamed from: b */
    public static String f2199b = bi_常量类.f6358b;
    /* renamed from: c */
    private static ad f2200c;
    /* renamed from: d */
    private static String f2201d = "http://apiinit.amap.com/v3/log/init";
    /* renamed from: e */
    private static String f2202e = null;

    /* renamed from: a */
    public static synchronized boolean m3500a(Context context, ad adVar) {
        boolean z;
        synchronized (C0408x.class) {
            f2200c = adVar;
            z = true;
            try {
                String a = C0408x.m3497a();
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", f2200c.f1926b);
                hashMap.put("X-INFO", C0409y.m3505a(context, f2200c, null));
                hashMap.put("ia", C0108a.f262e);
                hashMap.put("key", C0407w.m3495f(context));
                bt a2 = bt.m3293a();
                bu afVar = new af();
                afVar.m3048a(ac.m3018a(context));
                afVar.m3055a(hashMap);
                afVar.m3057b(C0408x.m3498a(context));
                afVar.m3054a(a);
                z = C0408x.m3501a(a2.m3304a(afVar));
            } catch (Throwable th) {
                az.m3143a(th, "Auth", "getAuth");
                th.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: a */
    public static void m3499a(String str) {
        C0407w.m3490a(str);
    }

    /* renamed from: a */
    private static String m3497a() {
        return f2201d;
    }

    /* renamed from: a */
    private static boolean m3501a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f2198a = 1;
                } else if (i == 0) {
                    f2198a = 0;
                }
            }
            if (jSONObject.has("info")) {
                f2199b = jSONObject.getString("info");
            }
            if (f2198a == 0) {
                Log.i("AuthFailure", f2199b);
            }
            if (f2198a != 1) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            az.m3143a(e, "Auth", "lData");
            e.printStackTrace();
            return false;
        } catch (Throwable e2) {
            az.m3143a(e2, "Auth", "lData");
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static Map<String, String> m3498a(Context context) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            hashMap.put("ec", C0108a.f262e);
            String a = C0409y.m3502a();
            hashMap.put("ts", a);
            hashMap.put("scode", C0409y.m3506a(context, a, ae.m3039a("resType=json&encode=UTF-8&ec=1")));
        } catch (Throwable th) {
            az.m3143a(th, "Auth", "gParams");
            th.printStackTrace();
        }
        return hashMap;
    }
}
