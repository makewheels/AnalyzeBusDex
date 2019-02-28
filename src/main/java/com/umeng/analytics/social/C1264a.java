package com.umeng.analytics.social;

import p054u.aly.bi_常量类;

/* compiled from: UMException */
/* renamed from: com.umeng.analytics.social.a */
public class C1264a extends RuntimeException {
    /* renamed from: b */
    private static final long f5688b = -4656673116019167471L;
    /* renamed from: a */
    protected int f5689a = 5000;
    /* renamed from: c */
    private String f5690c = bi_常量类.f6358b_空串;

    /* renamed from: a */
    public int m8468a() {
        return this.f5689a;
    }

    public C1264a(int i, String str) {
        super(str);
        this.f5689a = i;
        this.f5690c = str;
    }

    public C1264a(String str, Throwable th) {
        super(str, th);
        this.f5690c = str;
    }

    public C1264a(String str) {
        super(str);
        this.f5690c = str;
    }

    public String getMessage() {
        return this.f5690c;
    }
}
