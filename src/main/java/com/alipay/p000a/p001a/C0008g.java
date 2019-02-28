package com.alipay.p000a.p001a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;
import org.json.alipay.C1272b;

/* renamed from: com.alipay.a.a.g */
public final class C0008g implements C0000i, C0001j {
    /* renamed from: a */
    public final Object mo1a(Object obj) {
        Map treeMap = new TreeMap();
        Class cls = obj.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        while (!cls.equals(Object.class)) {
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    Object obj2;
                    if (field == null || obj == null) {
                        obj2 = null;
                    } else {
                        if ("this$0".equals(field.getName())) {
                            obj2 = null;
                        } else {
                            boolean isAccessible = field.isAccessible();
                            field.setAccessible(true);
                            Object obj3 = field.get(obj);
                            if (obj3 == null) {
                                obj2 = null;
                            } else {
                                field.setAccessible(isAccessible);
                                obj2 = C0007f.m20b(obj3);
                            }
                        }
                    }
                    if (obj2 != null) {
                        treeMap.put(field.getName(), obj2);
                    }
                }
            }
            cls = cls.getSuperclass();
            declaredFields = cls.getDeclaredFields();
        }
        return treeMap;
    }

    /* renamed from: a */
    public final Object mo2a(Object obj, Type type) {
        if (!obj.getClass().equals(C1272b.class)) {
            return null;
        }
        C1272b c1272b = (C1272b) obj;
        Class cls = (Class) type;
        Object newInstance = cls.newInstance();
        while (!cls.equals(Object.class)) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    String name = field.getName();
                    Type genericType = field.getGenericType();
                    if (c1272b.m8506b(name)) {
                        field.setAccessible(true);
                        field.set(newInstance, C0006e.m17a(c1272b.m8504a(name), genericType));
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return newInstance;
    }

    /* renamed from: a */
    public final boolean mo3a(Class<?> cls) {
        return true;
    }
}
