package com.alipay.sdk.util;

/* renamed from: com.alipay.sdk.util.g */
public enum C0146g {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NONE(-1, "none");
    
    /* renamed from: p */
    private int f450p;
    /* renamed from: q */
    private String f451q;

    private C0146g(int i, String str) {
        this.f450p = i;
        this.f451q = str;
    }

    /* renamed from: a */
    public static C0146g m512a(int i) {
        for (C0146g c0146g : C0146g.values()) {
            if (c0146g.f450p == i) {
                return c0146g;
            }
        }
        return NONE;
    }

    /* renamed from: b */
    private int m513b() {
        return this.f450p;
    }

    /* renamed from: a */
    public final String m514a() {
        return this.f451q;
    }
}
