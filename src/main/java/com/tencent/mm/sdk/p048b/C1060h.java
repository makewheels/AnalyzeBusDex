package com.tencent.mm.sdk.p048b;

import java.util.TimeZone;

/* renamed from: com.tencent.mm.sdk.b.h */
public final class C1060h {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final long[] bh = new long[]{300, 200, 300, 200};
    private static final long[] bi = new long[]{300, 50, 300, 50};
    private static final char[] bj = new char[]{'<', '>', '\"', '\'', '&', '\r', '\n', ' ', '\t'};
    private static final String[] bk = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};

    /* renamed from: h */
    public static boolean m7530h(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: u */
    public static C1058f m7531u() {
        return new C1058f();
    }
}
