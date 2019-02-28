package com.alipay.p000a.p001a;

import java.lang.reflect.Type;

/* renamed from: com.alipay.a.a.d */
public final class C0005d implements C0000i, C0001j {
    /* renamed from: a */
    public final Object mo1a(Object obj) {
        return ((Enum) obj).name();
    }

    /* renamed from: a */
    public final Object mo2a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    /* renamed from: a */
    public final boolean mo3a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
