package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.p051a.C1085a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

/* renamed from: com.tencent.smtt.utils.p */
public class C1152p {
    /* renamed from: a */
    private static final char[] f5150a = "0123456789abcdef".toCharArray();
    /* renamed from: b */
    private static C1152p f5151b;
    /* renamed from: c */
    private String f5152c;
    /* renamed from: d */
    private String f5153d;
    /* renamed from: e */
    private String f5154e = String.valueOf(new Random().nextInt(89999999) + 10000000);

    private C1152p() {
        int nextInt = new Random().nextInt(89999999) + 10000000;
        this.f5152c = this.f5154e + String.valueOf(nextInt);
    }

    /* renamed from: a */
    public static synchronized C1152p m8013a() {
        C1152p c1152p;
        synchronized (C1152p.class) {
            if (f5151b == null) {
                f5151b = new C1152p();
            }
            c1152p = f5151b;
        }
        return c1152p;
    }

    /* renamed from: b */
    private String m8014b(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            cArr[i * 2] = f5150a[i2 >>> 4];
            cArr[(i * 2) + 1] = f5150a[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public String m8015a(String str) {
        byte[] bytes = str.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } catch (Exception e) {
            try {
                m8017b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        return m8014b(cipher.doFinal(bytes));
    }

    /* renamed from: a */
    public byte[] m8016a(byte[] bArr) {
        return C1085a.m7680a(this.f5154e.getBytes(), bArr, 1);
    }

    /* renamed from: b */
    public void m8017b() {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    /* renamed from: c */
    public String m8018c() {
        if (this.f5153d == null) {
            byte[] bytes = this.f5152c.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e) {
                try {
                    m8017b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.f5153d = m8014b(cipher.doFinal(bytes));
        }
        return this.f5153d;
    }
}
