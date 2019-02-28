package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* renamed from: com.tencent.smtt.utils.q */
public class C1153q {
    /* renamed from: a */
    private static Class f5155a;
    /* renamed from: b */
    private static Method f5156b;

    static {
        try {
            f5155a = Class.forName("android.os.SystemProperties");
            f5156b = f5155a.getDeclaredMethod("get", new Class[]{String.class, String.class});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static String m8019a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : C1153q.m8020b(str, str2);
    }

    /* renamed from: b */
    private static String m8020b(String str, String str2) {
        if (f5155a == null || f5156b == null) {
            return str2;
        }
        try {
            return (String) f5156b.invoke(f5155a, new Object[]{str, str2});
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}
