package com.alipay.apmobilesecuritysdk.p004a;

import android.content.Context;
import com.alipay.security.mobile.module.p010a.C0161c;
import com.umeng.analytics.C1233a;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.a.i */
public final class C0060i {
    /* renamed from: a */
    private static String f120a = bi_常量类.f6358b;
    /* renamed from: b */
    private static String f121b = bi_常量类.f6358b;

    /* renamed from: a */
    public static String m167a() {
        return f120a;
    }

    /* renamed from: a */
    public static void m168a(C0056e c0056e) {
        f120a = c0056e.m147a();
        f121b = c0056e.m149c();
    }

    /* renamed from: a */
    public static boolean m169a(Context context) {
        try {
            if (Math.abs(System.currentTimeMillis() - C0059h.m163b(context)) < C1233a.f5597m) {
                return true;
            }
        } catch (Throwable th) {
            C0161c.m563a(th);
        }
        return false;
    }

    /* renamed from: b */
    public static String m170b() {
        return f121b;
    }
}
