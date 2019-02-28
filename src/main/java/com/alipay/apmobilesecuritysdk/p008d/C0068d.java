package com.alipay.apmobilesecuritysdk.p008d;

import android.content.Context;
import com.alipay.security.mobile.module.p010a.p011a.C0157b;
import com.alipay.security.mobile.module.p012b.C0163a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.d.d */
public final class C0068d {
    /* renamed from: a */
    private static Map<String, String> f134a = null;
    /* renamed from: b */
    private static Map<String, String> f135b = null;

    /* renamed from: a */
    private static synchronized String m179a(Map<String, String> map) {
        String str;
        synchronized (C0068d.class) {
            if (map == null) {
                str = null;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                List arrayList = new ArrayList(map.keySet());
                Collections.sort(arrayList);
                int i = 0;
                while (i < arrayList.size()) {
                    str = (String) arrayList.get(i);
                    if (str == null || !str.equals("AC3")) {
                        stringBuffer.append((i == 0 ? bi_常量类.f6358b_空串 : "&") + str + "=" + ((String) map.get(str)));
                    }
                    i++;
                }
                str = stringBuffer.toString();
            }
        }
        return str;
    }

    /* renamed from: a */
    public static synchronized Map<String, String> m180a(Context context, Map<String, String> map) {
        Map<String, String> map2;
        synchronized (C0068d.class) {
            if (f134a == null) {
                C0068d.m183c(context, map);
            }
            map2 = f134a;
        }
        return map2;
    }

    /* renamed from: a */
    public static synchronized void m181a() {
        synchronized (C0068d.class) {
            f134a = null;
            f135b = null;
        }
    }

    /* renamed from: b */
    public static synchronized String m182b(Context context, Map<String, String> map) {
        String a;
        synchronized (C0068d.class) {
            C0068d.m180a(context, map);
            a = C0157b.m549a(C0068d.m179a(f134a));
        }
        return a;
    }

    /* renamed from: c */
    private static synchronized void m183c(Context context, Map<String, String> map) {
        synchronized (C0068d.class) {
            f135b = new TreeMap();
            f134a = new TreeMap();
            f135b.putAll(C0066b.m177a(context, map));
            f135b.putAll(C0067c.m178a(context));
            Map map2 = f135b;
            C0163a a = C0163a.m566a();
            Map hashMap = new HashMap();
            hashMap.put("AD1", C0163a.m567a(context));
            hashMap.put("AD2", C0163a.m570b(context));
            hashMap.put("AD3", C0163a.m573d(context));
            hashMap.put("AD5", C0163a.m575e(context));
            hashMap.put("AD6", C0163a.m577f(context));
            hashMap.put("AD7", C0163a.m579g(context));
            hashMap.put("AD8", C0163a.m581h(context));
            hashMap.put("AD9", C0163a.m583i(context));
            hashMap.put("AD10", C0163a.m585j(context));
            hashMap.put("AD11", C0163a.m569b());
            hashMap.put("AD12", a.m591c());
            hashMap.put("AD13", C0163a.m572d());
            hashMap.put("AD14", C0163a.m574e());
            hashMap.put("AD15", C0163a.m576f());
            hashMap.put("AD16", C0163a.m578g());
            hashMap.put("AD17", bi_常量类.f6358b_空串);
            hashMap.put("AD18", C0163a.m580h());
            hashMap.put("AD19", C0163a.m587k(context));
            hashMap.put("AD20", C0163a.m582i());
            hashMap.put("AD21", C0163a.m571c(context));
            hashMap.put("AD22", a.m592n(context));
            map2.putAll(hashMap);
            f134a.putAll(f135b);
            f134a.putAll(C0065a.m175a(context));
        }
    }
}
