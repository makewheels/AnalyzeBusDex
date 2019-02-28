package com.alipay.p000a.p001a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.C1270a;

/* renamed from: com.alipay.a.a.k */
public final class C0010k implements C0000i {
    /* renamed from: a */
    public final Object mo2a(Object obj, Type type) {
        int i = 0;
        if (!obj.getClass().equals(C1270a.class)) {
            return null;
        }
        C1270a c1270a = (C1270a) obj;
        Collection hashSet = new HashSet();
        Type type2 = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class;
        while (i < c1270a.m8499a()) {
            hashSet.add(C0006e.m17a(c1270a.m8500a(i), type2));
            i++;
        }
        return hashSet;
    }

    /* renamed from: a */
    public final boolean mo3a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
