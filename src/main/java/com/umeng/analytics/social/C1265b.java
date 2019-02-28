package com.umeng.analytics.social;

import android.util.Log;

/* compiled from: UMLog */
/* renamed from: com.umeng.analytics.social.b */
public class C1265b {
    /* renamed from: a */
    public static void m8469a(String str, String str2) {
        if (C1268e.f5716v) {
            Log.i(str, str2);
        }
    }

    /* renamed from: a */
    public static void m8470a(String str, String str2, Exception exception) {
        if (C1268e.f5716v) {
            Log.i(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    /* renamed from: b */
    public static void m8471b(String str, String str2) {
        if (C1268e.f5716v) {
            Log.e(str, str2);
        }
    }

    /* renamed from: b */
    public static void m8472b(String str, String str2, Exception exception) {
        if (C1268e.f5716v) {
            Log.e(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.e(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }

    /* renamed from: c */
    public static void m8473c(String str, String str2) {
        if (C1268e.f5716v) {
            Log.d(str, str2);
        }
    }

    /* renamed from: c */
    public static void m8474c(String str, String str2, Exception exception) {
        if (C1268e.f5716v) {
            Log.d(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    /* renamed from: d */
    public static void m8475d(String str, String str2) {
        if (C1268e.f5716v) {
            Log.v(str, str2);
        }
    }

    /* renamed from: d */
    public static void m8476d(String str, String str2, Exception exception) {
        if (C1268e.f5716v) {
            Log.v(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    /* renamed from: e */
    public static void m8477e(String str, String str2) {
        if (C1268e.f5716v) {
            Log.w(str, str2);
        }
    }

    /* renamed from: e */
    public static void m8478e(String str, String str2, Exception exception) {
        if (C1268e.f5716v) {
            Log.w(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.w(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }
}
