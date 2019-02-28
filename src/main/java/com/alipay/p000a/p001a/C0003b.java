package com.alipay.p000a.p001a;

import com.alipay.p000a.p002b.C0012a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import org.json.alipay.C1270a;

/* renamed from: com.alipay.a.a.b */
public final class C0003b implements C0000i, C0001j {
    /* renamed from: a */
    private static Collection<Object> m7a(Class<?> cls, Type type) {
        if (cls == AbstractCollection.class) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf(type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class);
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("create instane error, class " + cls.getName());
        }
    }

    /* renamed from: a */
    public final Object mo1a(Object obj) {
        List arrayList = new ArrayList();
        for (Object b : (Iterable) obj) {
            arrayList.add(C0007f.m20b(b));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final Object mo2a(Object obj, Type type) {
        int i = 0;
        if (!obj.getClass().equals(C1270a.class)) {
            return null;
        }
        C1270a c1270a = (C1270a) obj;
        Collection a = C0003b.m7a(C0012a.m33a(type), type);
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            while (i < c1270a.m8499a()) {
                a.add(C0006e.m17a(c1270a.m8500a(i), type2));
                i++;
            }
            return a;
        }
        throw new IllegalArgumentException("Does not support the implement for generics.");
    }

    /* renamed from: a */
    public final boolean mo3a(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
}
