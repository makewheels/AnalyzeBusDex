package com.alipay.android.phone.mrpc.core;

/* renamed from: com.alipay.android.phone.mrpc.core.p */
public final class C0043p extends C0042u {
    /* renamed from: c */
    private int f64c;
    /* renamed from: d */
    private String f65d;
    /* renamed from: e */
    private long f66e;
    /* renamed from: f */
    private long f67f;
    /* renamed from: g */
    private String f68g;
    /* renamed from: h */
    private HttpUrlHeader f69h;

    public C0043p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.f69h = httpUrlHeader;
        this.f64c = i;
        this.f65d = str;
        this.a = bArr;
    }

    /* renamed from: a */
    public final HttpUrlHeader m103a() {
        return this.f69h;
    }

    /* renamed from: a */
    public final void m104a(long j) {
        this.f66e = j;
    }

    /* renamed from: a */
    public final void m105a(String str) {
        this.f68g = str;
    }

    /* renamed from: b */
    public final void m106b(long j) {
        this.f67f = j;
    }
}
