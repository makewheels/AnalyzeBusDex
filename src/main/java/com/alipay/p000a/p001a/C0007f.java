package com.alipay.p000a.p001a;

import com.alipay.p000a.p002b.C0012a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.C1270a;
import org.json.alipay.C1272b;

/* renamed from: com.alipay.a.a.f */
public final class C0007f {
    /* renamed from: a */
    private static List<C0001j> f1a;

    static {
        List arrayList = new ArrayList();
        f1a = arrayList;
        arrayList.add(new C0011l());
        f1a.add(new C0005d());
        f1a.add(new C0004c());
        f1a.add(new C0009h());
        f1a.add(new C0003b());
        f1a.add(new C0002a());
        f1a.add(new C0008g());
    }

    /* renamed from: a */
    public static String m19a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = C0007f.m20b(obj);
        if (C0012a.m34a(b.getClass())) {
            return C1272b.m8503c(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new C1270a((List) b).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new C1272b((Map) b).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b.getClass());
    }

    /* renamed from: b */
    public static Object m20b(Object obj) {
        if (obj == null) {
            return null;
        }
        for (C0001j c0001j : f1a) {
            if (c0001j.mo3a(obj.getClass())) {
                Object a = c0001j.mo1a(obj);
                if (a != null) {
                    return a;
                }
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
