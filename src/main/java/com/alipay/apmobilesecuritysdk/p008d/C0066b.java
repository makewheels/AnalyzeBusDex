package com.alipay.apmobilesecuritysdk.p008d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p009e.C0070b;
import com.alipay.sdk.cons.C0109b;
import com.alipay.security.mobile.module.p010a.C0159a;
import java.util.HashMap;
import java.util.Map;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.d.b */
public final class C0066b {
    /* renamed from: a */
    public static synchronized Map<String, String> m177a(Context context, Map<String, String> map) {
        Map<String, String> hashMap;
        synchronized (C0066b.class) {
            hashMap = new HashMap();
            String a = C0159a.m555a(map, C0109b.f277c, bi_常量类.f6358b_空串);
            String a2 = C0159a.m555a(map, C0109b.f281g, bi_常量类.f6358b_空串);
            String a3 = C0070b.m185a(context);
            String a4 = C0159a.m555a(map, "userId", bi_常量类.f6358b_空串);
            hashMap.put("AC1", a);
            hashMap.put("AC2", a2);
            hashMap.put("AC3", bi_常量类.f6358b_空串);
            hashMap.put("AC4", a3);
            hashMap.put("AC5", a4);
        }
        return hashMap;
    }
}
