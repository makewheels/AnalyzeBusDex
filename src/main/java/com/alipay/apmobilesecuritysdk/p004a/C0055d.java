package com.alipay.apmobilesecuritysdk.p004a;

import android.content.Context;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.alipay.security.mobile.module.p010a.C0161c;
import com.alipay.security.mobile.module.p010a.p011a.C0158c;
import com.alipay.security.mobile.module.p013c.C0167a;
import com.alipay.security.mobile.module.p013c.C0169c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.a.d */
public final class C0055d {
    /* renamed from: a */
    public static synchronized C0056e m141a() {
        C0056e c0056e = null;
        synchronized (C0055d.class) {
            String b = C0055d.m145b();
            if (!C0159a.m556a(b)) {
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    c0056e = new C0056e(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("token"), jSONObject.optString("timestamp"));
                } catch (Throwable e) {
                    C0161c.m563a(e);
                }
            }
        }
        return c0056e;
    }

    /* renamed from: a */
    public static synchronized C0056e m142a(Context context) {
        C0056e c0056e = null;
        synchronized (C0055d.class) {
            String c = C0055d.m146c(context);
            if (C0159a.m556a(c)) {
                c = C0055d.m145b();
            }
            if (!C0159a.m556a(c)) {
                try {
                    JSONObject jSONObject = new JSONObject(c);
                    c0056e = new C0056e(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("token"), jSONObject.optString("timestamp"));
                } catch (Throwable e) {
                    C0161c.m563a(e);
                }
            }
        }
        return c0056e;
    }

    /* renamed from: a */
    public static synchronized void m143a(Context context, C0056e c0056e) {
        synchronized (C0055d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", c0056e.m147a());
                jSONObject.put("deviceInfoHash", c0056e.m148b());
                jSONObject.put("token", c0056e.m149c());
                jSONObject.put("timestamp", c0056e.m150d());
                String jSONObject2 = jSONObject.toString();
                String a = C0158c.m551a(C0158c.m550a(), jSONObject2);
                if (!C0159a.m556a(a)) {
                    Map hashMap = new HashMap();
                    hashMap.put("deviceid", a);
                    C0169c.m617a(context, "vkeyid_profiles_v3", hashMap);
                }
                if (!C0159a.m556a(jSONObject2)) {
                    try {
                        jSONObject2 = C0158c.m551a(C0158c.m550a(), jSONObject2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("wxcasxx", jSONObject2);
                        C0167a.m613a("wxcasxx_v3", jSONObject3.toString());
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable e2) {
                C0161c.m563a(e2);
            }
        }
    }

    /* renamed from: b */
    public static synchronized C0056e m144b(Context context) {
        C0056e c0056e = null;
        synchronized (C0055d.class) {
            String c = C0055d.m146c(context);
            if (!C0159a.m556a(c)) {
                try {
                    JSONObject jSONObject = new JSONObject(c);
                    c0056e = new C0056e(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("token"), jSONObject.optString("timestamp"));
                } catch (Throwable e) {
                    C0161c.m563a(e);
                }
            }
        }
        return c0056e;
    }

    /* renamed from: b */
    private static String m145b() {
        try {
            return C0158c.m553b(C0158c.m550a(), new JSONObject(C0167a.m612a("wxcasxx_v3")).getString("wxcasxx"));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: c */
    private static String m146c(Context context) {
        String a = C0169c.m616a(context, "vkeyid_profiles_v3", "deviceid", bi_常量类.f6358b);
        return C0159a.m556a(a) ? null : C0158c.m553b(C0158c.m550a(), a);
    }
}
