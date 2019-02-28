package com.ta.utdid2.p037b.p038a;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p054u.aly.bi_常量类;

/* compiled from: AESUtils */
/* renamed from: com.ta.utdid2.b.a.a */
public final class C1010a {
    /* renamed from: a */
    public static String m7366a(String str, String str2) {
        byte[] a;
        try {
            a = C1010a.m7367a(str.getBytes());
            byte[] bytes = str2.getBytes();
            Key secretKeySpec = new SecretKeySpec(a, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            a = instance.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            a = null;
        }
        if (a != null) {
            return C1010a.m7369b(a);
        }
        return null;
    }

    /* renamed from: b */
    public static String m7368b(String str, String str2) {
        try {
            byte[] a = C1010a.m7367a(str.getBytes());
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

    /* renamed from: a */
    private static byte[] m7367a(byte[] bArr) throws Exception {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init(128, instance2);
        return instance.generateKey().getEncoded();
    }

    /* renamed from: b */
    private static String m7369b(byte[] bArr) {
        if (bArr == null) {
            return bi_常量类.f6358b;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }
}
