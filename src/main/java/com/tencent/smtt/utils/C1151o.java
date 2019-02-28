package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.WebView;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.o */
public class C1151o {
    /* renamed from: a */
    protected static final char[] f5143a = "0123456789abcdef".toCharArray();
    /* renamed from: b */
    private static String f5144b = bi_常量类.f6358b_空串;
    /* renamed from: c */
    private static byte[] f5145c = null;
    /* renamed from: f */
    private static C1151o f5146f = null;
    /* renamed from: g */
    private static String f5147g;
    /* renamed from: d */
    private Cipher f5148d = null;
    /* renamed from: e */
    private Cipher f5149e = null;

    private C1151o() {
        f5147g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i = 0; i < 12; i++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        f5145c = (str + f5147g).getBytes();
        this.f5148d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.f5148d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        f5144b = C1151o.m8009b(this.f5148d.doFinal(f5145c));
        Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f5147g.getBytes()));
        this.f5149e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.f5149e.init(1, generateSecret);
    }

    /* renamed from: a */
    public static C1151o m8008a() {
        try {
            if (f5146f == null) {
                f5146f = new C1151o();
            }
            return f5146f;
        } catch (Exception e) {
            f5146f = null;
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static String m8009b(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            cArr[i * 2] = f5143a[i2 >>> 4];
            cArr[(i * 2) + 1] = f5143a[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public byte[] m8010a(byte[] bArr) {
        return this.f5149e.doFinal(bArr);
    }

    /* renamed from: b */
    public String m8011b() {
        return f5144b;
    }

    /* renamed from: c */
    public byte[] m8012c(byte[] bArr) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f5147g.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
