package com.alipay.apmobilesecuritysdk.p004a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.alipay.sdk.cons.C0108a;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.alipay.security.mobile.module.p010a.p011a.C0158c;
import com.alipay.security.mobile.module.p013c.C0169c;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.a.h */
public final class C0059h {
    /* renamed from: a */
    public static synchronized void m161a(Context context, String str) {
        synchronized (C0059h.class) {
            try {
                Editor edit = context.getSharedPreferences("vkeyid_settings", 0).edit();
                if (edit != null) {
                    edit.putString("vkey_applist", C0158c.m551a(C0158c.m550a(), str));
                    edit.commit();
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m162a(Context context) {
        boolean z = true;
        try {
            String a = C0169c.m616a(context, "vkeyid_settings", "log_switch", bi_常量类.f6358b_空串);
            if (!C0159a.m556a(a)) {
                a = C0158c.m553b(C0158c.m550a(), a);
                if (!C0159a.m556a(a)) {
                    z = a.equals(C0108a.f262e);
                }
            }
        } catch (Throwable th) {
        }
        return z;
    }

    /* renamed from: b */
    public static long m163b(Context context) {
        long j = 0;
        try {
            String string = context.getSharedPreferences("vkeyid_settings", 0).getString("vkey_valid", bi_常量类.f6358b_空串);
            if (!C0159a.m556a(string)) {
                string = C0158c.m553b(C0158c.m550a(), string);
                if (!C0159a.m556a(string)) {
                    j = Long.parseLong(string);
                }
            }
        } catch (Throwable th) {
        }
        return j;
    }

    /* renamed from: b */
    public static synchronized void m164b(Context context, String str) {
        synchronized (C0059h.class) {
            try {
                Editor edit = context.getSharedPreferences("vkeyid_settings", 0).edit();
                if (edit != null) {
                    edit.putString("vkey_applist_version", C0158c.m551a(C0158c.m550a(), str));
                    edit.commit();
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: c */
    public static synchronized String m165c(Context context) {
        String string;
        synchronized (C0059h.class) {
            try {
                string = context.getSharedPreferences("vkeyid_settings", 0).getString("vkey_applist", bi_常量类.f6358b_空串);
                if (C0159a.m556a(string)) {
                    string = bi_常量类.f6358b_空串;
                } else {
                    string = C0158c.m553b(C0158c.m550a(), string);
                    if (C0159a.m556a(string)) {
                        string = bi_常量类.f6358b_空串;
                    }
                }
            } catch (Throwable th) {
                string = bi_常量类.f6358b_空串;
            }
        }
        return string;
    }

    /* renamed from: d */
    public static synchronized String m166d(Context context) {
        String string;
        synchronized (C0059h.class) {
            try {
                string = context.getSharedPreferences("vkeyid_settings", 0).getString("vkey_applist_version", bi_常量类.f6358b_空串);
                if (C0159a.m556a(string)) {
                    string = bi_常量类.f6358b_空串;
                } else {
                    string = C0158c.m553b(C0158c.m550a(), string);
                    if (C0159a.m556a(string)) {
                        string = bi_常量类.f6358b_空串;
                    }
                }
            } catch (Throwable th) {
                string = bi_常量类.f6358b_空串;
            }
        }
        return string;
    }
}
