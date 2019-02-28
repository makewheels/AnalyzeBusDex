package com.aps;

import android.util.SparseArray;
import p054u.aly.bi_常量类;

/* compiled from: Const */
/* renamed from: com.aps.f */
public class C0560f {
    /* renamed from: a */
    static String f3455a = null;
    /* renamed from: b */
    static String f3456b = null;
    /* renamed from: c */
    static String f3457c = null;
    /* renamed from: d */
    static String f3458d = bi_常量类.f6358b_空串;
    /* renamed from: e */
    static String f3459e = bi_常量类.f6358b_空串;
    /* renamed from: f */
    static String f3460f = bi_常量类.f6358b_空串;
    /* renamed from: g */
    static boolean f3461g = false;
    /* renamed from: h */
    static boolean f3462h = true;
    /* renamed from: i */
    static long f3463i = 10000;
    /* renamed from: j */
    static long f3464j = 30000;
    /* renamed from: k */
    static boolean f3465k = true;
    /* renamed from: l */
    static final SparseArray<String> f3466l = new SparseArray();
    /* renamed from: m */
    static final String[] f3467m = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    private C0560f() {
    }

    static {
        f3466l.append(0, "UNKNOWN");
        f3466l.append(1, "GPRS");
        f3466l.append(2, "EDGE");
        f3466l.append(3, "UMTS");
        f3466l.append(4, "CDMA");
        f3466l.append(5, "EVDO_0");
        f3466l.append(6, "EVDO_A");
        f3466l.append(7, "1xRTT");
        f3466l.append(8, "HSDPA");
        f3466l.append(9, "HSUPA");
        f3466l.append(10, "HSPA");
        f3466l.append(11, "IDEN");
        f3466l.append(12, "EVDO_B");
        f3466l.append(13, "LTE");
        f3466l.append(14, "EHRPD");
        f3466l.append(15, "HSPAP");
    }

    /* renamed from: a */
    static void m4477a(String str) {
        f3458d = str;
    }

    /* renamed from: b */
    static void m4479b(String str) {
        f3459e = str;
    }

    /* renamed from: c */
    static void m4480c(String str) {
        f3460f = str;
    }

    /* renamed from: a */
    static void m4478a(boolean z) {
        f3461g = z;
    }
}
