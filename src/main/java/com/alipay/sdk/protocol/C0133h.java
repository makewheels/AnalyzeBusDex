package com.alipay.sdk.protocol;

import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.data.C0116f;

/* renamed from: com.alipay.sdk.protocol.h */
public abstract class C0133h extends C0128c {
    /* renamed from: d */
    public static final int f401d = 4;
    /* renamed from: e */
    public static final int f402e = 6;
    /* renamed from: f */
    public static final int f403f = 7;
    /* renamed from: g */
    public static final int f404g = 8;
    /* renamed from: h */
    public static final int f405h = 9;
    /* renamed from: i */
    public static final int f406i = 10;
    /* renamed from: j */
    public static final int f407j = -10;
    /* renamed from: k */
    boolean f408k = false;

    protected C0133h(C0115e c0115e, C0116f c0116f) {
        super(c0115e, c0116f);
    }

    /* renamed from: a */
    private void m449a(boolean z) {
        this.f408k = z;
    }

    /* renamed from: d */
    private boolean m450d() {
        return this.f408k;
    }

    /* renamed from: a */
    public abstract boolean mo23a();

    /* renamed from: b */
    public abstract int mo24b();

    /* renamed from: c */
    public abstract String mo25c();
}
