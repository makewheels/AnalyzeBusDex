package com.amap.api.mapcore.util;

import p054u.aly.bi_常量类;

/* compiled from: Util */
class au {
    au() {
    }

    /* renamed from: a */
    static String m3126a(String str) {
        if (str == null) {
            return null;
        }
        String b = aa.m3006b(str.getBytes());
        return ((char) ((b.length() % 26) + 65)) + b;
    }

    /* renamed from: b */
    static String m3127b(String str) {
        if (str.length() < 2) {
            return bi_常量类.f6358b_空串;
        }
        return aa.m3002a(str.substring(1));
    }
}
