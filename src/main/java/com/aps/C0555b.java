package com.aps;

import com.amap.api.location.core.C0283b;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p054u.aly.bi_常量类;

/* compiled from: Aes */
/* renamed from: com.aps.b */
public class C0555b {
    /* renamed from: a */
    private String f3404a = "AES/CBC/PKCS5Padding";
    /* renamed from: b */
    private Cipher f3405b = null;

    C0555b() {
        try {
            Key secretKeySpec = new SecretKeySpec("#a@u!t*o(n)a&v^i".getBytes("UTF-8"), "AES");
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec("_a+m-a=p?a>p<s%3".getBytes("UTF-8"));
            this.f3405b = Cipher.getInstance(this.f3404a);
            this.f3405b.init(2, secretKeySpec, ivParameterSpec);
        } catch (Throwable th) {
            th.printStackTrace();
            C0583t.m4574a(th);
        }
    }

    /* renamed from: a */
    String m4415a(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new String(this.f3405b.doFinal(m4414a(str)), str2);
        } catch (Throwable e) {
            C0583t.m4574a(e);
            return null;
        }
    }

    /* renamed from: a */
    private byte[] m4414a(String str) {
        byte[] bArr = null;
        if (!(str == null || str.length() == 0 || str.length() % 2 != 0)) {
            try {
                bArr = new byte[(str.length() / 2)];
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < str.length(); i += 2) {
                    stringBuilder.delete(0, stringBuilder.length());
                    stringBuilder.append("0X");
                    stringBuilder.append(str.substring(i, i + 2));
                    bArr[i / 2] = (byte) Integer.decode(stringBuilder.toString()).intValue();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C0583t.m4574a(th);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m4413a(byte[] bArr) {
        String str = bi_常量类.f6358b_空串;
        if (bArr != null) {
            try {
                str = C0283b.m1821a(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }
}
