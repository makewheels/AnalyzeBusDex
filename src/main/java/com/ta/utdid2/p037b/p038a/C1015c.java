package com.ta.utdid2.p037b.p038a;

import java.lang.reflect.Method;

/* compiled from: DebugUtils */
/* renamed from: com.ta.utdid2.b.a.c */
public final class C1015c {
    /* renamed from: a */
    public static boolean f4699a;
    /* renamed from: b */
    private static Class<?> f4700b = null;
    /* renamed from: c */
    private static Method f4701c = null;
    /* renamed from: d */
    private static Method f4702d = null;

    /* renamed from: a */
    private static int m7374a(String str) {
        try {
            if (f4700b == null) {
                Class cls = Class.forName("android.os.SystemProperties");
                f4700b = cls;
                f4701c = cls.getDeclaredMethod("get", new Class[]{String.class});
                f4702d = f4700b.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return ((Integer) f4702d.invoke(f4700b, new Object[]{str, Integer.valueOf(0)})).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    static {
        boolean z = true;
        if (C1015c.m7374a("alidebug") != 1) {
            z = false;
        }
        f4699a = z;
    }
}
