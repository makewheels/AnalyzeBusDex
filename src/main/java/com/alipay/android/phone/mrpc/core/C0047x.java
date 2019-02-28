package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* renamed from: com.alipay.android.phone.mrpc.core.x */
public final class C0047x {
    /* renamed from: a */
    private C0030g f88a;
    /* renamed from: b */
    private C0049z f89b = new C0049z(this);

    public C0047x(C0030g c0030g) {
        this.f88a = c0030g;
    }

    /* renamed from: a */
    public final C0030g m124a() {
        return this.f88a;
    }

    /* renamed from: a */
    public final <T> T m125a(Class<T> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0048y(this.f88a, cls, this.f89b));
    }
}
