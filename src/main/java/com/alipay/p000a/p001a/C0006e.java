package com.alipay.p000a.p001a;

import com.alipay.p000a.p002b.C0012a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.C1270a;
import org.json.alipay.C1272b;

/* renamed from: com.alipay.a.a.e */
public final class C0006e {
    /* renamed from: a */
    static List<C0000i> f0a;

    static {
        List arrayList = new ArrayList();
        f0a = arrayList;
        arrayList.add(new C0011l());
        f0a.add(new C0005d());
        f0a.add(new C0004c());
        f0a.add(new C0009h());
        f0a.add(new C0010k());
        f0a.add(new C0003b());
        f0a.add(new C0002a());
        f0a.add(new C0008g());
    }

    /* renamed from: a */
    public static final <T> T m17a(Object obj, Type type) {
        for (C0000i c0000i : f0a) {
            if (c0000i.mo3a(C0012a.m33a(type))) {
                T a = c0000i.mo2a(obj, type);
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static final Object m18a(String str, Type type) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Object trim = str.trim();
        return (trim.startsWith("[") && trim.endsWith("]")) ? C0006e.m17a(new C1270a((String) trim), type) : (trim.startsWith("{") && trim.endsWith("}")) ? C0006e.m17a(new C1272b((String) trim), type) : C0006e.m17a(trim, type);
    }
}
