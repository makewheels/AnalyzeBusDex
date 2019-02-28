package com.iflytek.cloud.p023b.p024e.p029a;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.e.a.c */
public class C0941c {
    /* renamed from: a */
    public static HashMap<String, String> f4478a = new HashMap();
    /* renamed from: b */
    private static boolean f4479b = false;
    /* renamed from: c */
    private static long f4480c = 0;
    /* renamed from: d */
    private static String f4481d = "=";
    /* renamed from: e */
    private static String f4482e = ",";
    /* renamed from: f */
    private static String f4483f = ";";
    /* renamed from: g */
    private static String f4484g = "=========================================================\n";

    /* renamed from: a */
    private static String m7126a() {
        return new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: a */
    public static void m7127a(String str, String str2) {
        if (f4479b) {
            C0939a.m7122b("appendInfo:" + str + "," + str2);
            if (f4480c == 0) {
                f4478a.put(str, C0941c.m7126a());
                f4480c = System.currentTimeMillis();
                return;
            }
            String str3 = bi_常量类.f6358b + (System.currentTimeMillis() - f4480c);
            if (TextUtils.isEmpty(str2)) {
                str2 = str3;
            }
            if (!f4478a.containsKey(str) || TextUtils.isEmpty((CharSequence) f4478a.get(str))) {
                f4478a.put(str, str2);
                return;
            }
            f4478a.put(str, ((String) f4478a.get(str)) + f4483f + str2);
        }
    }
}
