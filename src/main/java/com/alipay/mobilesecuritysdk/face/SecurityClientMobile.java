package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.apmobilesecuritysdk.p004a.C0055d;
import com.alipay.apmobilesecuritysdk.p004a.C0056e;
import com.alipay.apmobilesecuritysdk.p004a.C0060i;
import com.alipay.apmobilesecuritysdk.p004a.p005a.C0050a;
import com.alipay.apmobilesecuritysdk.p009e.C0070b;
import com.alipay.sdk.cons.C0109b;
import com.alipay.security.mobile.module.p010a.C0159a;
import java.util.HashMap;
import java.util.Map;
import p054u.aly.bi_常量类;

public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a;
        synchronized (SecurityClientMobile.class) {
            a = C0060i.m167a();
            if (C0159a.m556a(a)) {
                C0056e a2 = C0055d.m142a(context);
                if (a2 == null || C0159a.m556a(a2.m147a())) {
                    a = C0050a.m128a(context);
                    if (C0159a.m556a(a)) {
                        Map hashMap = new HashMap();
                        hashMap.put(C0109b.f281g, C0159a.m555a(map, C0109b.f281g, bi_常量类.f6358b));
                        hashMap.put(C0109b.f277c, C0159a.m555a(map, C0109b.f277c, bi_常量类.f6358b));
                        hashMap.put("userId", C0159a.m555a(map, "userId", bi_常量类.f6358b));
                        APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
                        a = C0070b.m185a(context);
                    }
                } else {
                    a = a2.m147a();
                }
            }
        }
        return a;
    }
}
