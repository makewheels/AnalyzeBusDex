package com.alipay.sdk.protocol;

/* renamed from: com.alipay.sdk.protocol.f */
public enum C0132f {
    SUCCESS("0"),
    TID_REFRESH("tid_refresh_invalid"),
    POP_TYPE("pop_type"),
    NOT_POP_TYPE("not_pop_type");
    
    /* renamed from: e */
    private String f400e;

    private C0132f(String str) {
        this.f400e = str;
    }

    /* renamed from: a */
    public static C0132f m447a(String str) {
        C0132f c0132f = null;
        C0132f[] values = C0132f.values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            C0132f c0132f2 = values[i];
            if (!str.startsWith(c0132f2.f400e)) {
                c0132f2 = c0132f;
            }
            i++;
            c0132f = c0132f2;
        }
        return c0132f;
    }

    /* renamed from: a */
    private String m448a() {
        return this.f400e;
    }
}
