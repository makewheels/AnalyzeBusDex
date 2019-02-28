package com.alipay.security.mobile.module.p010a.p011a;

import android.annotation.SuppressLint;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.security.mobile.module.a.a.c */
public final class C0158c {
    /* renamed from: a */
    private static String f478a = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");

    /* renamed from: a */
    public static String m550a() {
        String str = new String();
        for (int i = 0; i < f478a.length() - 1; i += 4) {
            str = str + f478a.charAt(i);
        }
        return str;
    }

    /* renamed from: a */
    public static String m551a(String str, String str2) {
        byte[] bArr = null;
        try {
            byte[] a = C0158c.m552a(str.getBytes());
            byte[] bytes = str2.getBytes();
            Key secretKeySpec = new SecretKeySpec(a, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            bArr = instance.doFinal(bytes);
        } catch (Exception e) {
        }
        return C0158c.m554b(bArr);
    }

    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    private static byte[] m552a(byte[] bArr) {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init(128, instance2);
        return instance.generateKey().getEncoded();
    }

    /* renamed from: b */
    public static String m553b(String str, String str2) {
        try {
            byte[] a = C0158c.m552a(str.getBytes());
            int length = str2.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = Integer.valueOf(str2.substring(i * 2, (i * 2) + 2), 16).byteValue();
            }
            Key secretKeySpec = new SecretKeySpec(a, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            return new String(instance.doFinal(bArr));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private static String m554b(byte[] bArr) {
        if (bArr == null) {
            return bi_常量类.f6358b_空串;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }
}
