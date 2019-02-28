package com.alipay.apmobilesecuritysdk.p004a.p005a;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p004a.C0056e;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.alipay.security.mobile.module.p010a.p011a.C0158c;
import com.alipay.security.mobile.module.p013c.C0167a;
import com.alipay.security.mobile.module.p013c.C0169c;
import java.util.Map;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.a.a.a */
public final class C0050a {
    /* renamed from: a */
    public static synchronized String m127a() {
        String str = null;
        synchronized (C0050a.class) {
            String b = C0050a.m130b();
            if (!C0159a.m556a(b)) {
                String[] split = b.split("`");
                if (split != null && split.length >= 2) {
                    str = split[0];
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static synchronized String m128a(Context context) {
        String a;
        synchronized (C0050a.class) {
            a = C0050a.m127a();
            if (C0159a.m556a(a)) {
                a = C0050a.m131b(context);
            }
        }
        return a;
    }

    /* renamed from: a */
    public static synchronized void m129a(C0056e c0056e) {
        synchronized (C0050a.class) {
            if (!C0159a.m556a(c0056e.m147a())) {
                if (!c0056e.m147a().equals(C0050a.m127a())) {
                    String str = c0056e.m147a() + "`" + c0056e.m150d();
                    if (str != null) {
                        try {
                            str = C0158c.m551a(C0158c.m550a(), str);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("device", str);
                            C0167a.m613a("deviceid_v2", jSONObject.toString());
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static String m130b() {
        try {
            return C0158c.m553b(C0158c.m550a(), new JSONObject(C0167a.m612a("deviceid_v2")).getString("device"));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public static synchronized String m131b(Context context) {
        String str = null;
        synchronized (C0050a.class) {
            String str2 = bi_常量类.f6358b;
            try {
                String a = C0169c.m616a(context, "profiles", "deviceid", bi_常量类.f6358b);
                a = C0159a.m556a(a) ? null : C0158c.m553b(C0158c.m550a(), a);
                if (!C0159a.m556a(a)) {
                    C0051b c0051b = new C0051b();
                    Map a2 = C0051b.m132a(a);
                    if (a2 != null) {
                        str = (String) a2.get("deviceId");
                    }
                    str = str2;
                }
            } catch (Throwable th) {
            }
        }
        return str;
    }
}
