package com.alipay.sdk.encrypt;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.alipay.sdk.encrypt.b */
public final class C0118b {
    /* renamed from: a */
    public static String m358a(int i, String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher instance = Cipher.getInstance("DES");
            instance.init(i, secretKeySpec);
            byte[] doFinal = instance.doFinal(i == 2 ? C0117a.m355a(str) : str.getBytes("UTF-8"));
            return i == 2 ? new String(doFinal) : C0117a.m353a(doFinal);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m359a(String str, String str2) {
        return C0118b.m358a(1, str, str2);
    }

    /* renamed from: b */
    private static String m360b(String str, String str2) {
        return C0118b.m358a(2, str, str2);
    }
}
