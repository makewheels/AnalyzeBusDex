package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

/* renamed from: com.alipay.android.phone.mrpc.core.a */
public abstract class C0022a implements C0021v {
    /* renamed from: a */
    protected Method f10a;
    /* renamed from: b */
    protected byte[] f11b;
    /* renamed from: c */
    protected String f12c;
    /* renamed from: d */
    protected int f13d;
    /* renamed from: e */
    protected String f14e;
    /* renamed from: f */
    protected boolean f15f;

    public C0022a(Method method, int i, String str, byte[] bArr, String str2, boolean z) {
        this.f10a = method;
        this.f13d = i;
        this.f12c = str;
        this.f11b = bArr;
        this.f14e = str2;
        this.f15f = z;
    }
}
