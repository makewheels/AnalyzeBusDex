package com.aps;

/* compiled from: Reflect */
/* renamed from: com.aps.n */
public class C0574n {
    /* renamed from: a */
    public static Object m4545a(Object obj, String str, Object... objArr) throws Exception {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }
}
