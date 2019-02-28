package com.alipay.apmobilesecuritysdk.p009e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.alipay.security.mobile.module.p010a.p011a.C0157b;
import com.alipay.security.mobile.module.p013c.C0169c;
import java.util.UUID;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.e.b */
public final class C0070b {
    /* renamed from: a */
    public static String m185a(Context context) {
        String a = C0169c.m616a(context, "alipay_vkey_random", "random", bi_常量类.f6358b);
        if (C0159a.m556a(a)) {
            a = C0157b.m549a(UUID.randomUUID().toString());
            String str = "alipay_vkey_random";
            String str2 = "random";
            if (a != null) {
                Editor edit = context.getSharedPreferences(str, 0).edit();
                if (edit != null) {
                    edit.clear();
                    edit.putString(str2, a);
                    edit.commit();
                }
            }
        }
        return a;
    }
}
