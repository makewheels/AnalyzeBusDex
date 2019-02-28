package com.alipay.sdk.app;

import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.app.l */
public final class C0088l {
    /* renamed from: a */
    static String f189a;

    /* renamed from: a */
    public static String m224a() {
        C0089m a = C0089m.m229a(C0089m.CANCELED.m232a());
        return C0088l.m225a(a.m232a(), a.m233b(), bi_常量类.f6358b_空串);
    }

    /* renamed from: a */
    public static String m225a(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("resultStatus={").append(i).append("};memo={").append(str).append("};result={").append(str2).append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static void m226a(String str) {
        f189a = str;
    }

    /* renamed from: b */
    public static String m227b() {
        C0089m a = C0089m.m229a(C0089m.PARAMS_ERROR.m232a());
        return C0088l.m225a(a.m232a(), a.m233b(), bi_常量类.f6358b_空串);
    }

    /* renamed from: c */
    private static String m228c() {
        return f189a;
    }
}
