package com.alipay.sdk.encrypt;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.alipay.sdk.encrypt.e */
public final class C0121e {
    /* renamed from: a */
    private static String f348a = "DESede/ECB/PKCS5Padding";

    /* renamed from: a */
    public static String m369a(String str, String str2) {
        String str3 = null;
        try {
            Key secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher instance = Cipher.getInstance(f348a);
            instance.init(1, secretKeySpec);
            str3 = C0117a.m353a(instance.doFinal(str2.getBytes()));
        } catch (Exception e) {
        }
        return str3;
    }

    /* renamed from: b */
    public static String m370b(String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher instance = Cipher.getInstance(f348a);
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(C0117a.m355a(str2)));
        } catch (Exception e) {
            return null;
        }
    }
}
