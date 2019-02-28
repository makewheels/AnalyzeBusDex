package com.alipay.p000a.p001a;

import java.lang.reflect.Type;
import java.util.Date;

/* renamed from: com.alipay.a.a.c */
public final class C0004c implements C0000i, C0001j {
    /* renamed from: a */
    public final Object mo1a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    /* renamed from: a */
    public final Object mo2a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    /* renamed from: a */
    public final boolean mo3a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
