package com.alipay.sdk.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.alipay.sdk.encrypt.d */
public final class C0120d {
    /* renamed from: a */
    public static final String f346a = "SHA1WithRSA";
    /* renamed from: b */
    private static final String f347b = "RSA";

    /* renamed from: a */
    public static String m364a(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            Key generatePublic = KeyFactory.getInstance(f347b).generatePublic(new X509EncodedKeySpec(C0117a.m355a(str2)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            byte[] bytes = str.getBytes("UTF-8");
            int blockSize = instance.getBlockSize();
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i = 0;
            while (i < bytes.length) {
                try {
                    byteArrayOutputStream3.write(instance.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                    i += blockSize;
                } catch (Exception e) {
                    byteArrayOutputStream = byteArrayOutputStream3;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                }
            }
            String str3 = new String(C0117a.m353a(byteArrayOutputStream3.toByteArray()));
            try {
                byteArrayOutputStream3.close();
                return str3;
            } catch (IOException e2) {
                return str3;
            }
        } catch (Exception e3) {
            byteArrayOutputStream = null;
            if (byteArrayOutputStream == null) {
                return null;
            }
            try {
                byteArrayOutputStream.close();
                return null;
            } catch (IOException e4) {
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static boolean m365a(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(f347b).generatePublic(new X509EncodedKeySpec(C0117a.m355a(str3)));
            Signature instance = Signature.getInstance(f346a);
            instance.initVerify(generatePublic);
            instance.update(str.getBytes("utf-8"));
            return instance.verify(C0117a.m355a(str2));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    private static PublicKey m366b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(C0117a.m355a(str2)));
    }

    /* renamed from: c */
    private static String m367c(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            Key generatePrivate = KeyFactory.getInstance(f347b).generatePrivate(new PKCS8EncodedKeySpec(C0117a.m355a(str2)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePrivate);
            byte[] a = C0117a.m355a(str);
            int blockSize = instance.getBlockSize();
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i = 0;
            while (i < a.length) {
                try {
                    byteArrayOutputStream3.write(instance.doFinal(a, i, a.length - i < blockSize ? a.length - i : blockSize));
                    i += blockSize;
                } catch (Exception e) {
                    byteArrayOutputStream = byteArrayOutputStream3;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                }
            }
            String str3 = new String(byteArrayOutputStream3.toByteArray());
            try {
                byteArrayOutputStream3.close();
                return str3;
            } catch (IOException e2) {
                return str3;
            }
        } catch (Exception e3) {
            byteArrayOutputStream = null;
            if (byteArrayOutputStream == null) {
                return null;
            }
            try {
                byteArrayOutputStream.close();
                return null;
            } catch (IOException e4) {
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    /* renamed from: d */
    private static String m368d(String str, String str2) {
        String str3 = "utf-8";
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance(f347b).generatePrivate(new PKCS8EncodedKeySpec(C0117a.m355a(str2)));
            Signature instance = Signature.getInstance(f346a);
            instance.initSign(generatePrivate);
            instance.update(str.getBytes(str3));
            return C0117a.m353a(instance.sign());
        } catch (Exception e) {
            return null;
        }
    }
}
