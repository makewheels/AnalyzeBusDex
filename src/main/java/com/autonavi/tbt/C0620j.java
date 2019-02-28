package com.autonavi.tbt;

import android.content.Context;
import android.util.Log;
import com.alipay.sdk.cons.C0108a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: AuthManager */
/* renamed from: com.autonavi.tbt.j */
public class C0620j {
    /* renamed from: a */
    public static int f3818a = -1;
    /* renamed from: b */
    public static String f3819b = bi_常量类.f6358b_空串;
    /* renamed from: c */
    private static C0629p f3820c;
    /* renamed from: d */
    private static String f3821d = "http://apiinit.amap.com/v3/log/init";
    /* renamed from: e */
    private static String f3822e = null;

    /* renamed from: a */
    public static synchronized boolean m4872a(Context context, C0629p c0629p) {
        boolean z;
        synchronized (C0620j.class) {
            f3820c = c0629p;
            z = true;
            try {
                String a = C0620j.m4869a();
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", f3820c.f3838b);
                hashMap.put("X-INFO", C0621k.m4876a(context, f3820c, null));
                hashMap.put("ia", C0108a.f262e);
                hashMap.put("key", C0619i.m4867f(context));
                at a2 = at.m4777a();
                au c0631r = new C0631r();
                c0631r.m4792a(C0626o.m4923a(context));
                c0631r.m4953a(hashMap);
                c0631r.m4955b(C0620j.m4870a(context));
                c0631r.m4952a(a);
                z = C0620j.m4873a(a2.m4788a(c0631r));
            } catch (Throwable th) {
                ae.m4671a(th, "Auth", "getAuth");
                th.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: a */
    public static void m4871a(String str) {
        f3821d = str;
    }

    /* renamed from: a */
    private static String m4869a() {
        return f3821d;
    }

    /* renamed from: a */
    private static boolean m4873a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f3818a = 1;
                } else if (i == 0) {
                    f3818a = 0;
                }
            }
            if (jSONObject.has("info")) {
                f3819b = jSONObject.getString("info");
            }
            if (f3818a == 0) {
                Log.i("AuthFailure", f3819b);
            }
            if (f3818a != 1) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            ae.m4671a(e, "Auth", "lData");
            e.printStackTrace();
            return false;
        } catch (Throwable e2) {
            ae.m4671a(e2, "Auth", "lData");
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static Map<String, String> m4870a(Context context) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", "UTF-8");
            hashMap.put("ec", C0108a.f262e);
            String a = C0621k.m4874a();
            hashMap.put("ts", a);
            hashMap.put("scode", C0621k.m4877a(context, a, C0630q.m4944a("resType=json&encode=UTF-8&ec=1")));
        } catch (Throwable th) {
            ae.m4671a(th, "Auth", "gParams");
            th.printStackTrace();
        }
        return hashMap;
    }
}
