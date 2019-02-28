package com.alipay.apmobilesecuritysdk.p008d;

import android.content.Context;
import com.alipay.sdk.cons.C0108a;
import com.alipay.security.mobile.module.p012b.C0165c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.apmobilesecuritysdk.d.c */
public final class C0067c {
    /* renamed from: a */
    public static synchronized Map<String, String> m178a(Context context) {
        Map<String, String> hashMap;
        synchronized (C0067c.class) {
            C0165c.m593a();
            hashMap = new HashMap();
            hashMap.put("AE1", C0165c.m596b());
            hashMap.put("AE2", (C0165c.m597c() ? C0108a.f262e : "0"));
            hashMap.put("AE3", (C0165c.m595a(context) ? C0108a.f262e : "0"));
            hashMap.put("AE4", C0165c.m598d());
            hashMap.put("AE5", C0165c.m599e());
            hashMap.put("AE6", C0165c.m600f());
            hashMap.put("AE7", C0165c.m601g());
            hashMap.put("AE8", C0165c.m602h());
            hashMap.put("AE9", C0165c.m603i());
            hashMap.put("AE10", C0165c.m604j());
            hashMap.put("AE11", C0165c.m605k());
            hashMap.put("AE12", C0165c.m606l());
            hashMap.put("AE13", C0165c.m607m());
            hashMap.put("AE14", C0165c.m608n());
            hashMap.put("AE15", C0165c.m609o());
        }
        return hashMap;
    }
}
