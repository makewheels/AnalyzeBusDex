package com.ta.utdid2.p037b.p038a;

/* compiled from: StringUtils */
/* renamed from: com.ta.utdid2.b.a.h */
public final class C1020h {
    /* renamed from: a */
    public static boolean m7383a(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static int m7384b(String str) {
        int i = 0;
        if (str.length() <= 0) {
            return 0;
        }
        char[] toCharArray = str.toCharArray();
        int i2 = 0;
        while (i < toCharArray.length) {
            i2 = (i2 * 31) + toCharArray[i];
            i++;
        }
        return i2;
    }
}
