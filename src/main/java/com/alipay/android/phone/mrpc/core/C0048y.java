package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.alipay.android.phone.mrpc.core.y */
public final class C0048y implements InvocationHandler {
    /* renamed from: a */
    protected C0030g f90a;
    /* renamed from: b */
    protected Class<?> f91b;
    /* renamed from: c */
    protected C0049z f92c;

    public C0048y(C0030g c0030g, Class<?> cls, C0049z c0049z) {
        this.f90a = c0030g;
        this.f91b = cls;
        this.f92c = c0049z;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        C0049z c0049z = this.f92c;
        Class cls = this.f91b;
        return c0049z.m126a(method, objArr);
    }
}
