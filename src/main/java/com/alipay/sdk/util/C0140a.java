package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.tid.C0138a;
import com.alipay.sdk.tid.C0139b;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.util.a */
public final class C0140a {
    /* renamed from: a */
    public static String[] m489a(String str) {
        int indexOf = str.indexOf(40) + 1;
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == 0 || lastIndexOf == -1) {
            return null;
        }
        String[] split = str.substring(indexOf, lastIndexOf).split(",");
        if (split != null) {
            for (indexOf = 0; indexOf < split.length; indexOf++) {
                if (!TextUtils.isEmpty(split[indexOf])) {
                    split[indexOf] = split[indexOf].trim();
                    split[indexOf] = split[indexOf].replaceAll("'", bi_常量类.f6358b).replaceAll("\"", bi_常量类.f6358b);
                }
            }
        }
        return split;
    }

    /* renamed from: b */
    private static void m490b(String str) {
        String[] a = C0140a.m489a(str);
        if (a.length == 3 && TextUtils.equals(C0109b.f277c, a[0])) {
            Context context = C0136b.m459a().f414a;
            C0139b a2 = C0139b.m480a();
            if (!TextUtils.isEmpty(a[1]) && !TextUtils.isEmpty(a[2])) {
                a2.f422a = a[1];
                a2.f423b = a[2];
                C0138a c0138a = new C0138a(context);
                try {
                    c0138a.m477a(C0141b.m491a(context).m497a(), C0141b.m491a(context).m498b(), a2.f422a, a2.f423b);
                } catch (Exception e) {
                } finally {
                    c0138a.close();
                }
            }
        }
    }
}
