package com.alipay.security.mobile.module.p010a.p011a;

import com.alipay.security.mobile.module.p010a.C0159a;
import java.security.MessageDigest;

/* renamed from: com.alipay.security.mobile.module.a.a.b */
public final class C0157b {
    /* renamed from: a */
    public static String m549a(String str) {
        String str2 = null;
        try {
            if (!C0159a.m556a(str)) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(str.getBytes("UTF-8"));
                byte[] digest = instance.digest();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < digest.length; i++) {
                    stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
                }
                str2 = stringBuilder.toString();
            }
        } catch (Exception e) {
        }
        return str2;
    }
}
