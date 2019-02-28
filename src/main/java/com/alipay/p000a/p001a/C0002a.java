package com.alipay.p000a.p001a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.C1270a;

/* renamed from: com.alipay.a.a.a */
public final class C0002a implements C0000i, C0001j {
    /* renamed from: a */
    public final Object mo1a(Object obj) {
        Object[] objArr = (Object[]) obj;
        List arrayList = new ArrayList();
        for (Object b : objArr) {
            arrayList.add(C0007f.m20b(b));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final Object mo2a(Object obj, Type type) {
        if (!obj.getClass().equals(C1270a.class)) {
            return null;
        }
        C1270a c1270a = (C1270a) obj;
        if (type instanceof GenericArrayType) {
            throw new IllegalArgumentException("Does not support generic array!");
        }
        Type componentType = ((Class) type).getComponentType();
        int a = c1270a.m8499a();
        Object newInstance = Array.newInstance(componentType, a);
        for (int i = 0; i < a; i++) {
            Array.set(newInstance, i, C0006e.m17a(c1270a.m8500a(i), componentType));
        }
        return newInstance;
    }

    /* renamed from: a */
    public final boolean mo3a(Class<?> cls) {
        return cls.isArray();
    }
}
