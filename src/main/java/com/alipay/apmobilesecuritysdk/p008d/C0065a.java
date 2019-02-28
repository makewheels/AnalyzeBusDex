package com.alipay.apmobilesecuritysdk.p008d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.apmobilesecuritysdk.d.a */
public final class C0065a {
    /* renamed from: a */
    public static synchronized Map<String, String> m175a(Context context) {
        Map<String, String> hashMap;
        synchronized (C0065a.class) {
            hashMap = new HashMap();
            hashMap.put("AA1", context.getPackageName());
            hashMap.put("AA2", C0065a.m176b(context));
            hashMap.put("AA3", "security-sdk-token");
            hashMap.put("AA4", "3.0.2.20150525");
        }
        return hashMap;
    }

    /* renamed from: b */
    private static String m176b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception e) {
            return "0.0.0";
        }
    }
}
