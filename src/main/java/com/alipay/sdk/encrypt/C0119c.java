package com.alipay.sdk.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.encrypt.c */
public final class C0119c {
    /* renamed from: a */
    private static String m361a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return C0119c.m363b(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: a */
    public static String m362a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return C0119c.m363b(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: b */
    private static String m363b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(Character.forDigit((bArr[i] & 240) >> 4, 16));
            stringBuffer.append(Character.forDigit(bArr[i] & 15, 16));
        }
        return stringBuffer.toString();
    }
}
