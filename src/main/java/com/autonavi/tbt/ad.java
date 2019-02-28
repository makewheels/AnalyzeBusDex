package com.autonavi.tbt;

import p054u.aly.bi_常量类;

/* compiled from: Util */
class ad {
    ad() {
    }

    /* renamed from: a */
    static String m4667a(String str) {
        if (str == null) {
            return null;
        }
        String b = C0624m.m4913b(str.getBytes());
        return ((char) ((b.length() % 26) + 65)) + b;
    }

    /* renamed from: b */
    static String m4668b(String str) {
        if (str.length() < 2) {
            return bi_常量类.f6358b;
        }
        return C0624m.m4909a(str.substring(1));
    }
}
