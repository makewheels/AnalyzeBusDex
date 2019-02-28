package com.tencent.smtt.utils;

import java.security.MessageDigest;

/* renamed from: com.tencent.smtt.utils.n */
public class C1150n {
    /* renamed from: a */
    public static String m8007a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                byte[] bytes = str.getBytes();
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bytes);
                str2 = C1136c.m7956a(instance.digest());
            } catch (Exception e) {
            }
        }
        return str2;
    }
}
